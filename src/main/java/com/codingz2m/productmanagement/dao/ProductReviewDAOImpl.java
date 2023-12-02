package com.codingz2m.productmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.codingz2m.productmanagement.dto.ProductReviewDto;
import com.codingz2m.productmanagement.exception.ProductNotFoundException;
import com.codingz2m.productmanagement.model.Product;
import com.codingz2m.productmanagement.model.ProductReview;
import com.codingz2m.productmanagement.repository.ProductRepository;
import com.codingz2m.productmanagement.repository.ProductReviewRepository;
import com.codingz2m.productmanagement.util.AppUtils;


@Repository
public class ProductReviewDAOImpl implements ProductReviewDAO {

    private ProductReviewRepository productReviewRepository;
    private final ProductRepository productRepository;
    
    //@Autowired
    public ProductReviewDAOImpl(ProductReviewRepository productReviewRepository, ProductRepository productRepository) {
  		super();
  		this.productReviewRepository = productReviewRepository;
  		this.productRepository = productRepository;
  	}

	@Override
	public ProductReview saveProductReview(ProductReviewDto productReviewDto) throws ProductNotFoundException {
		
		Optional<Product> optionalProduct = productRepository.findById(productReviewDto.getProduct().getId());
        
    	if ( !optionalProduct.isPresent() ) {
			throw new ProductNotFoundException("Product Not Found for Writing Review");
		}
		else {
			return productReviewRepository.save(AppUtils.dtoToEntity(productReviewDto));
		}
	}
	

	@Override
	public void deleteProductReview(Long id) {
		 productReviewRepository.deleteById(id);
	}

	@Override
	public List<ProductReview> findByProductId(Long productId) {
		 return productReviewRepository.findByProduct_Id(productId);
	}
  
}
