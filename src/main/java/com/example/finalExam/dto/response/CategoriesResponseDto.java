package com.example.finalExam.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoriesResponseDto {

    private String name;
    private List<SubCategory> subCategories;

    @Data
    @AllArgsConstructor
    public static class SubCategory{
        private String name;
    }
}
