package com.codingz2m.productmanagement.service;

import org.springframework.stereotype.Service;

import com.codingz2m.productmanagement.controller.ProductController;
import com.codingz2m.productmanagement.dao.ProductDAO;
import com.codingz2m.productmanagement.dto.ProductDto;
import com.codingz2m.productmanagement.exception.ProductNotFoundException;
import com.codingz2m.productmanagement.model.Product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	 private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	 
    private final ProductDAO productDAO;

   // @Autowired
    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

	@Override
	public Product save(ProductDto productDto) {
		 logger.info("save() inside ProductServiceImpl is executed");
		 return productDAO.save(productDto);
	}

	@Override
	public Product findById(Long id) throws ProductNotFoundException {
		 return productDAO.findById(id);
	}

	@Override
	public List<Product> findAll() throws ProductNotFoundException {
		  return productDAO.findAll();
	}

	@Override
	public void deleteById(Long id) throws ProductNotFoundException {
		 productDAO.deleteById(id);
	}

	@Override
	public int getTotalStockQuantityForProduct(Long productId) throws ProductNotFoundException {
		   return productDAO.getTotalStockQuantityForProduct(productId);
	}

	@Override
	public List<Product> getProductsByCategoryName(String categoryName) throws ProductNotFoundException {
		   return productDAO.getProductsByCategoryName(categoryName);
	}

	@Override
	public List<Product> getProductsByCategoryId(Long categoryId) throws ProductNotFoundException {
		return productDAO.getProductsByCategoryId(categoryId);
	}

	@Override
	public List<Product> getProductByName(String name) throws ProductNotFoundException {
		return productDAO.getProductByName(name);
	}


}