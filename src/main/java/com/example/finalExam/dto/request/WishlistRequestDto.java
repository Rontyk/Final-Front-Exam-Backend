package com.example.finalExam.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WishlistRequestDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("count-of-items")
    private Integer countOfItems;
}
