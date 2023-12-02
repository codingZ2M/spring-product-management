package com.codingz2m.productmanagement.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.codingz2m.productmanagement.controller.ProductController;
import com.codingz2m.productmanagement.dto.ProductDto;
import com.codingz2m.productmanagement.exception.ProductNotFoundException;
import com.codingz2m.productmanagement.model.Product;
import com.codingz2m.productmanagement.repository.CategoryRepository;
import com.codingz2m.productmanagement.repository.ProductRepository;
import com.codingz2m.productmanagement.util.AppUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProductDAOImpl implements ProductDAO {

	 private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	 
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    
    //@Autowired
    public ProductDAOImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


	@Override
	public Product save(ProductDto productDto) {
		 logger.info("save() inside ProductDAOImpl is executed");
		  return productRepository.save(AppUtils.dtoToEntity(productDto) );
	} 

    @Override
    public Product findById(Long id) throws ProductNotFoundException{
    	Optional<Product> optionalProduct = productRepository.findById(id);
        
    	if ( !optionalProduct.isPresent() ) {
			throw new ProductNotFoundException("Product Not Found for the ID: " + id);
		}
		else {
			return optionalProduct.get();
		}
    }

    @Override
    public List<Product> findAll() throws ProductNotFoundException{
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            throw new ProductNotFoundException("No Products Found");
        }
        return products;
    }

    @Override
    public void deleteById(Long id) throws ProductNotFoundException{
        
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product with id " + id + " Not Found");
        }
        productRepository.deleteById(id);
    }


    @Override
    public int getTotalStockQuantityForProduct(Long productId) throws ProductNotFoundException  {
        return productRepository.findById(productId)
                .map(Product::getStockQuantity)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + productId + " Not Found"));
    }
    
    
    @Override
    public List<Product> getProductsByCategoryName(String categoryName) throws ProductNotFoundException {
    	 // Use Java Stream API for filtering
    	 List<Product> products =  productRepository.findAll().stream()
                .filter(product -> product.getCategory().getName().equals(categoryName))
                .collect(Collectors.toList());
    	 
    	 if (products.isEmpty()) {
             throw new ProductNotFoundException("No Products Found");
         }
         return products;
    }

    
    public List<Product> getProductsByCategoryId(Long categoryId)  throws ProductNotFoundException {
    	 // Use Java Stream API for filtering
    	List<Product> products =  productRepository.findAll().stream()
    			.filter(product -> product.getCategory().getId().equals(categoryId))
                .collect(Collectors.toList());
        
        if (products.isEmpty()) {
            throw new ProductNotFoundException("No Products Found");
        }
        return products;
    }


	@Override
	public List<Product> getProductByName(String name) throws ProductNotFoundException {
		List<Product> products = productRepository.findByNameIgnoreCase(name);
		if ( products.isEmpty() ) {
			throw new ProductNotFoundException("Products Are Not Found for the Name " + " starts with " + name);
		}
		else {
			return products;
		}
	}

    
}
