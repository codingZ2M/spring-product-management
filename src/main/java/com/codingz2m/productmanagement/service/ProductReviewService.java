package com.codingz2m.productmanagement.service;

import java.util.List;

import com.codingz2m.productmanagement.dto.ProductReviewDto;
import com.codingz2m.productmanagement.exception.ProductNotFoundException;
import com.codingz2m.productmanagement.model.ProductReview;

public interface ProductReviewService {

	   ProductReview saveProductReview(ProductReviewDto productReviewDto)  throws ProductNotFoundException;
	   
	   void deleteProductReview(Long id);
	   
	   List<ProductReview> getProductReviews(Long productId);
}
