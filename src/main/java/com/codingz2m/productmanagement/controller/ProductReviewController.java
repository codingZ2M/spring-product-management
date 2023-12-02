package com.codingz2m.productmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codingz2m.productmanagement.dto.ProductReviewDto;
import com.codingz2m.productmanagement.exception.ProductNotFoundException;
import com.codingz2m.productmanagement.model.ProductReview;
import com.codingz2m.productmanagement.service.ProductReviewService;
import com.codingz2m.productmanagement.util.AppUtils;

@RestController
@RequestMapping("/api/product-reviews")
public class ProductReviewController {

    private ProductReviewService productReviewService;
    
    //@Autowired
    public ProductReviewController(ProductReviewService productReviewService) {
 		super();
 		this.productReviewService = productReviewService;
 	}

    @PostMapping
    public ResponseEntity<ProductReviewDto> saveProductReview(@RequestBody ProductReviewDto productReviewDto) throws ProductNotFoundException {
    	
        ProductReview savedProductReview = productReviewService.saveProductReview(productReviewDto);
        ProductReviewDto savedProductReviewDto = AppUtils.entityToDto(savedProductReview);
        
        return savedProductReviewDto != null
                ? new ResponseEntity<>( savedProductReviewDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


	   @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProductReview(@PathVariable Long id)  {
		   productReviewService.deleteProductReview(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
}

