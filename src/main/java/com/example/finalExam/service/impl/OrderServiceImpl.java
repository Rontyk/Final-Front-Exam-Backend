package com.example.finalExam.service.impl;

import com.example.finalExam.dto.request.WishlistRequestDto;
import com.example.finalExam.dto.response.OrderResponseDto;
import com.example.finalExam.entities.Order;
import com.example.finalExam.entities.OrderItem;
import com.example.finalExam.entities.Product;
import com.example.finalExam.entities.Wishlist;
import com.example.finalExam.exception.DbNotFoundException;
import com.example.finalExam.repositories.*;
import com.example.finalExam.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OrderServiceImpl implements OrderService {

    private final WishlistRepository wishlistRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;


    @Override

    public void createOrderFromWishlist(Long userId, List<WishlistRequestDto> requestDtos){
        if (requestDtos.isEmpty()) {
            throw new IllegalArgumentException("Wishlist is empty");
        }

        List<Product> products = productRepository.findAllById(
                requestDtos.stream().map(WishlistRequestDto::getId).toList()
        );

        BigDecimal totalPrice = BigDecimal.ZERO;
        List<OrderItem> orderItems = new ArrayList<>();

        for (WishlistRequestDto dto : requestDtos) {
            Product product = products.stream()
                    .filter(p -> p.getId().equals(dto.getId()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Product not found: " + dto.getId()));

            if (product.getStock() < dto.getCountOfItems()) {
                throw new IllegalArgumentException("Not enough stock for product: " + product.getName());
            }

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(dto.getCountOfItems());
            orderItem.setPrice(product.getPrice());
            orderItems.add(orderItem);

            product.setStock(product.getStock() - dto.getCountOfItems());

            totalPrice = totalPrice.add(product.getPrice().multiply(BigDecimal.valueOf(dto.getCountOfItems())));
        }

        Order order = new Order();
        order.setUser(userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found")));
        order.setTotalPrice(totalPrice);
        order.setStatus("pending");


        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(order);
        }
        order = orderRepository.save(order);
        orderItemRepository.saveAll(orderItems);

        log.info("User id: {}", userId);
        wishlistRepository.deleteByUser(userRepository.findById(userId).orElseThrow(() -> new DbNotFoundException(HttpStatus.NOT_FOUND.getReasonPhrase(), "User do not found")));
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .flatMap(order -> order.getOrderItems().stream()
                        .map(orderItem -> new OrderResponseDto(
                                orderItem.getId(),
                                orderItem.getProduct().getName(),
                                order.getStatus(),
                                orderItem.getQuantity(),
                                orderItem.getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity()))
                        ))
                )
                .toList();
    }



}
