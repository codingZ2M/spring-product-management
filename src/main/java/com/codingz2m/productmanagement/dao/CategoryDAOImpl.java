package com.codingz2m.productmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.codingz2m.productmanagement.dto.CategoryDto;
import com.codingz2m.productmanagement.exception.CategoryNotFoundException;
import com.codingz2m.productmanagement.model.Category;
import com.codingz2m.productmanagement.repository.CategoryRepository;
import com.codingz2m.productmanagement.util.AppUtils;

@Component
public class CategoryDAOImpl implements CategoryDAO {

	private final CategoryRepository categoryRepository;
	
	//@Autowired
	public CategoryDAOImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category getById(Long id) throws CategoryNotFoundException {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
        
    	if ( !optionalCategory.isPresent() ) {
			throw new CategoryNotFoundException("Category Not Found for the ID: " + id);
		}
		else {
			return optionalCategory.get();
		}
	}

	@Override
	public List<Category> getAll()  throws CategoryNotFoundException {
		
		  List<Category> categories = categoryRepository.findAll();
	        if (categories.isEmpty()) {
	            throw new CategoryNotFoundException("No Categories Found");
	        }
	        return categories;
	}

	@Override
	public Category save(CategoryDto categoryDto) {
		  return categoryRepository.save(AppUtils.dtoToEntity(categoryDto) );
	}

	@Override
	public void delete(Long id) throws CategoryNotFoundException {
		  if (!categoryRepository.existsById(id)) {
	            throw new CategoryNotFoundException("Category with id " + id + " Not Found");
	        }
		  categoryRepository.deleteById(id);
	}
	

}
