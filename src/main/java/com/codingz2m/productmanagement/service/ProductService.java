package com.codingz2m.productmanagement.service;

import java.util.List;

import com.codingz2m.productmanagement.dto.ProductDto;
import com.codingz2m.productmanagement.exception.ProductNotFoundException;
import com.codingz2m.productmanagement.model.Product;


public interface ProductService {
	
	  Product save(ProductDto productDto);

	    Product findById(Long id) throws ProductNotFoundException;

	    List<Product> findAll() throws ProductNotFoundException;

	    void deleteById(Long id) throws ProductNotFoundException;
	    
	    int getTotalStockQuantityForProduct(Long productId) throws ProductNotFoundException;
	    
	    List<Product> getProductsByCategoryName(String categoryName) throws ProductNotFoundException;
	    
	    List<Product> getProductsByCategoryId(Long categoryId) throws ProductNotFoundException;
	    
	    List<Product> getProductByName(String name) throws ProductNotFoundException;
	    
}
