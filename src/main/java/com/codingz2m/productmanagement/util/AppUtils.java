package com.codingz2m.productmanagement.util;

import org.springframework.beans.BeanUtils;

import com.codingz2m.productmanagement.dto.CategoryDto;
import com.codingz2m.productmanagement.dto.ProductDto;
import com.codingz2m.productmanagement.dto.ProductImageDto;
import com.codingz2m.productmanagement.dto.ProductReviewDto;
import com.codingz2m.productmanagement.model.Category;
import com.codingz2m.productmanagement.model.Product;
import com.codingz2m.productmanagement.model.ProductImage;
import com.codingz2m.productmanagement.model.ProductReview;


public class AppUtils {
	
	//Product
	public static ProductDto entityToDto(Product product) {
		ProductDto productDto = new  ProductDto();
		BeanUtils.copyProperties(product, productDto);
		return productDto;
	}
	public static Product dtoToEntity(ProductDto productDto) {
		Product product = new  Product();
		BeanUtils.copyProperties(productDto, product);
		return product;
	}
	

	// ProductImage
	public static ProductImageDto entityToDto(ProductImage productImage) {
		ProductImageDto productImageDto = new  ProductImageDto();
		BeanUtils.copyProperties(productImage, productImageDto);
		return productImageDto;
	}
	public static ProductImage dtoToEntity(ProductImageDto productImageDto) {
		ProductImage productImage = new  ProductImage();
		BeanUtils.copyProperties(productImageDto, productImage);
		return productImage;
	}
	
	
	// ProductReview
	public static ProductReviewDto entityToDto(ProductReview productReview) {
		ProductReviewDto productReviewDto = new  ProductReviewDto();
		BeanUtils.copyProperties(productReview, productReviewDto);
		return productReviewDto;
	}
	public static ProductReview dtoToEntity(ProductReviewDto productReviewDto) {
		ProductReview productReview = new  ProductReview();
		BeanUtils.copyProperties(productReviewDto, productReview);
		return productReview;
	}
	
	
	// Category
	public static CategoryDto entityToDto(Category category) {
		CategoryDto categoryDto = new  CategoryDto();
		BeanUtils.copyProperties(category, categoryDto);
		return categoryDto;
	}
	public static Category dtoToEntity(CategoryDto categoryDto) {
		Category category = new  Category();
		BeanUtils.copyProperties(categoryDto, category);
		return category;
	}
	
}
