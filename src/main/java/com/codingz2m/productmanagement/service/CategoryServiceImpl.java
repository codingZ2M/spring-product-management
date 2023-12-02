package com.codingz2m.productmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codingz2m.productmanagement.dao.CategoryDAO;
import com.codingz2m.productmanagement.dto.CategoryDto;
import com.codingz2m.productmanagement.exception.CategoryNotFoundException;
import com.codingz2m.productmanagement.model.Category;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    
	private final CategoryDAO categoryDAO;
    
   // @Autowired
	public CategoryServiceImpl(CategoryDAO categoryDAO) {
		super();
		this.categoryDAO = categoryDAO;
	}
	
	@Override
	public Category getById(Long id) throws CategoryNotFoundException {
		 return categoryDAO.getById(id);
	}

	@Override
	public List<Category> getAll() throws CategoryNotFoundException {
		 return categoryDAO.getAll();
	}

	@Override
	public Category save(CategoryDto categoryDto) {
		return categoryDAO.save(categoryDto);
	}

	@Override
	public void delete(Long id) throws CategoryNotFoundException {
		 categoryDAO.delete(id);
	}
   
}
