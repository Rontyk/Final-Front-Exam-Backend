package com.example.finalExam.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequestDto {
    @JsonProperty("category_id")
    private Long categoryId;

    @JsonProperty("price_min")
    private Integer priceMin;

    @JsonProperty("price_max")
    private Integer priceMax;

    @JsonProperty("search")
    private String search;
}
