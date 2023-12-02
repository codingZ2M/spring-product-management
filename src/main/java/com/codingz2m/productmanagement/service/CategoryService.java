package com.codingz2m.productmanagement.service;

import java.util.List;

import com.codingz2m.productmanagement.dto.CategoryDto;
import com.codingz2m.productmanagement.exception.CategoryNotFoundException;
import com.codingz2m.productmanagement.model.Category;

public interface CategoryService {
	
	 	Category getById(Long id)throws CategoryNotFoundException;

	    List<Category> getAll()throws CategoryNotFoundException;

	    Category save(CategoryDto categoryDto);

	    void delete(Long id)throws CategoryNotFoundException;

}
