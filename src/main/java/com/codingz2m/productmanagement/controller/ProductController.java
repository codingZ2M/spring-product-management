package com.codingz2m.productmanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codingz2m.productmanagement.dto.ProductDto;
import com.codingz2m.productmanagement.dto.ProductReviewDto;
import com.codingz2m.productmanagement.exception.ProductNotFoundException;
import com.codingz2m.productmanagement.model.Product;
import com.codingz2m.productmanagement.model.ProductReview;
import com.codingz2m.productmanagement.service.ProductReviewService;
import com.codingz2m.productmanagement.service.ProductService;
import com.codingz2m.productmanagement.util.AppUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;
    private final ProductReviewService productReviewService;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    
   // @Autowired
    public ProductController(ProductService productService, ProductReviewService productReviewService) {
        this.productService = productService;
        this.productReviewService = productReviewService;
    }

    @PostMapping
    public ResponseEntity<ProductDto> saveProduct(@RequestBody ProductDto productDto) {
    	 logger.info("saveProduct() inside ProductController is executed");
        Product savedProduct = productService.save(productDto);
        ProductDto savedProductDto = AppUtils.entityToDto(savedProduct);
        
        return savedProductDto != null
                ? new ResponseEntity<>( savedProductDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id) throws ProductNotFoundException {
        Product product = productService.findById(id);
        ProductDto productDto = AppUtils.entityToDto(product);
        
        return productDto != null
                ? new ResponseEntity<>( productDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
    @GetMapping
    public List<ProductDto> getAllProducts() throws ProductNotFoundException {
    	List<ProductDto> productsDto= new ArrayList<ProductDto>();
    	
    	List<Product> products = productService.findAll();
    	  Iterator<Product> iterator = products.iterator(); 
    	  while(iterator.hasNext()) {
    		  Product product = (Product) iterator.next();
    		  ProductDto productDto = AppUtils.entityToDto(product);
    		  productsDto.add(productDto);
		   }
		   return productsDto;
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) throws ProductNotFoundException {
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
    @GetMapping("/stockQuantity/{productId}")
    public ResponseEntity<Integer> getTotalStockQuantityForProduct(@PathVariable Long productId) throws ProductNotFoundException {
        int stockQuantity = productService.getTotalStockQuantityForProduct(productId);
        return new ResponseEntity<>(stockQuantity, HttpStatus.OK);
    }

    @GetMapping("/categoryName/{categoryName}")
    public List<ProductDto> getProductsByCategoryName(@PathVariable String categoryName) throws ProductNotFoundException {
        
    	List<ProductDto> productsDto= new ArrayList<ProductDto>();
    	
    	List<Product> products =   productService.getProductsByCategoryName(categoryName);
    	Iterator<Product> iterator = products.iterator(); 
  	  		while(iterator.hasNext()) {
  	  			Product product = (Product) iterator.next();
  	  			ProductDto productDto = AppUtils.entityToDto(product);
  	  			productsDto.add(productDto);
		   }
		 return productsDto;
    }

    
    @GetMapping("/categoryId/{categoryId}")
    public List<ProductDto> getProductsByCategoryId(@PathVariable Long categoryId) throws ProductNotFoundException {
        
    	List<ProductDto> productsDto= new ArrayList<ProductDto>();
    	
    	List<Product> products =  productService.getProductsByCategoryId(categoryId);
    	Iterator<Product> iterator = products.iterator(); 
  	  		while(iterator.hasNext()) {
  	  			Product product = (Product) iterator.next();
  	  			ProductDto productDto = AppUtils.entityToDto(product);
  	  			productsDto.add(productDto);
		   }
		 return productsDto;
    }
    
    
    //REST End Point: localhost:8081/api/products/byProductName?productName=Shoe
	   @GetMapping("/byProductName")
	   public List<ProductDto> getSavingsAccountByHolderName(@RequestParam("productName") String productName) throws ProductNotFoundException {
		
		   List<ProductDto> productsDto= new ArrayList<ProductDto>();
	    	
	    	List<Product> products =   productService.getProductByName(productName);
	    	Iterator<Product> iterator = products.iterator(); 
	  	  		while(iterator.hasNext()) {
	  	  			Product product = (Product) iterator.next();
	  	  			ProductDto productDto = AppUtils.entityToDto(product);
	  	  			productsDto.add(productDto);
			   }
			 return productsDto;
	   }
	   

	   
	    @GetMapping("/reviews/{productId}")
	    public List<ProductReviewDto> getProductReviewsByProductId(@PathVariable Long productId) throws ProductNotFoundException {
	        
	    	List<ProductReviewDto> productsReviewDto= new ArrayList<ProductReviewDto>();
	    	
	    	List<ProductReview> productReviews =  productReviewService.getProductReviews(productId);
	    	Iterator<ProductReview> iterator = productReviews.iterator(); 
	  	  		while(iterator.hasNext()) {
	  	  			ProductReview productReview = (ProductReview) iterator.next();
	  	  			ProductReviewDto productReviewDto = AppUtils.entityToDto(productReview);
	  	  			productsReviewDto.add(productReviewDto);
			   }
			 return productsReviewDto;
	    }
	    

}
