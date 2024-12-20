INSERT INTO _categories (name, parent_id, created_at, updated_at, is_deleted) VALUES
                                                                                 ('Electronics', NULL, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                 ('Smartphones', 1, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                 ('Laptops', 1, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                 ('Appliances', NULL, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                 ('Refrigerators', 4, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                 ('Microwaves', 4, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE);

INSERT INTO _users (first_name, last_name, email, password, role, created_at, updated_at, is_deleted) VALUES
                                                                                                         ('John', 'Doe', 'john.doe@example.com', 'hashedpassword1', 'USER', EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                                         ('Jane', 'Smith', 'jane.smith@example.com', 'hashedpassword2', 'USER', EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                                         ('Admin', 'User', 'admin@example.com', 'hashedpassword3', 'ADMIN', EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                                         ('Alice', 'Brown', 'alice.brown@example.com', 'hashedpassword4', 'USER', EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                                         ('Bob', 'White', 'bob.white@example.com', 'hashedpassword5', 'USER', EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE);


INSERT INTO _products (name, description, price, stock, category_id, created_at, updated_at, is_deleted) VALUES
                                                                                                            ('iPhone 14', 'Latest Apple smartphone', 999.99, 50, 2, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                                            ('Samsung Galaxy S22', 'High-end Android smartphone', 799.99, 30, 2, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                                            ('MacBook Pro', 'Apple laptop with M1 chip', 1999.99, 20, 3, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                                            ('Dell XPS 13', 'Compact and powerful laptop', 1499.99, 15, 3, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                                            ('LG Refrigerator', 'Energy-efficient refrigerator', 1200.00, 10, 5, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                                            ('Panasonic Microwave', 'Compact microwave for home', 300.00, 25, 6, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE);

INSERT INTO _orders (user_id, total_price, status, created_at, updated_at, is_deleted) VALUES
                                                                                          (1, 2799.97, 'completed', EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                          (2, 1499.99, 'pending', EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                          (3, 1599.99, 'shipped', EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE);

INSERT INTO _order_items (order_id, product_id, quantity, price, created_at, updated_at, is_deleted) VALUES
                                                                                                        (1, 1, 2, 999.99, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                                        (1, 3, 1, 1999.99, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                                        (2, 4, 1, 1499.99, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                                        (3, 2, 2, 799.99, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE);

INSERT INTO _reviews (product_id, user_id, rating, comment, created_at, updated_at, is_deleted) VALUES
                                                                                                   (1, 1, 5, 'Amazing phone! Worth every penny.', EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                                   (2, 2, 4, 'Great phone, but a bit pricey.', EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                                   (3, 3, 5, 'Best laptop I have ever used.', EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                                   (4, 4, 3, 'Good, but could use better battery life.', EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                                   (5, 5, 4, 'Very efficient refrigerator.', EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE);

INSERT INTO _wishlist (user_id, product_id, created_at, updated_at, is_deleted) VALUES
                                                                                   (1, 2, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                   (1, 3, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                   (2, 1, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                   (3, 5, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE),
                                                                                   (3, 6, EXTRACT(EPOCH FROM NOW()), EXTRACT(EPOCH FROM NOW()), FALSE);
