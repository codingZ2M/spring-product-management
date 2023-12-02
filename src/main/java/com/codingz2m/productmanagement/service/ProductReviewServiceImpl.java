package com.codingz2m.productmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingz2m.productmanagement.dao.ProductReviewDAO;
import com.codingz2m.productmanagement.dto.ProductReviewDto;
import com.codingz2m.productmanagement.exception.ProductNotFoundException;
import com.codingz2m.productmanagement.model.ProductReview;


@Service
public class ProductReviewServiceImpl implements ProductReviewService {

    private ProductReviewDAO productReviewDAO;
    
   //@Autowired
    public ProductReviewServiceImpl(ProductReviewDAO productReviewDAO) {
    	this.productReviewDAO = productReviewDAO;
    }

	@Override
	public ProductReview saveProductReview(ProductReviewDto productReviewDto) throws ProductNotFoundException {
		return productReviewDAO.saveProductReview(productReviewDto);
	}

	@Override
	public void deleteProductReview(Long id) {
		productReviewDAO.deleteProductReview(id);
		
	}

	@Override
	public List<ProductReview> getProductReviews(Long productId) {
		 return productReviewDAO.findByProductId(productId);
	}

  
}
