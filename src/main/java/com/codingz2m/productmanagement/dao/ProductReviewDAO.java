package com.codingz2m.productmanagement.dao;

import java.util.List;

import com.codingz2m.productmanagement.dto.ProductReviewDto;
import com.codingz2m.productmanagement.exception.ProductNotFoundException;
import com.codingz2m.productmanagement.model.ProductReview;

public interface ProductReviewDAO {

    ProductReview saveProductReview(ProductReviewDto productReviewDto)  throws ProductNotFoundException;

    void deleteProductReview(Long id);
    
    List<ProductReview> findByProductId(Long productId);
}
