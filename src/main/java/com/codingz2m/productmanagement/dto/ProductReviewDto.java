package com.codingz2m.productmanagement.dto;

import java.time.LocalDateTime;

import com.codingz2m.productmanagement.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductReviewDto {

	private Long id;

    private double rating;
    private String comment;
   
    private Product product;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
