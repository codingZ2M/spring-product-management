package com.codingz2m.productmanagement.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.codingz2m.productmanagement.model.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	 	private Long id;
	    private String name;
	    private String description;
	    private BigDecimal price;
	    private Category category;
	    private int stockQuantity;
	    private boolean isAvailable;
	    private LocalDateTime createdAt;
	    private LocalDateTime updatedAt;
}
