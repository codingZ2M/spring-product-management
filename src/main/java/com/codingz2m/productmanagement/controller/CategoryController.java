package com.codingz2m.productmanagement.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingz2m.productmanagement.dto.CategoryDto;
import com.codingz2m.productmanagement.exception.CategoryNotFoundException;
import com.codingz2m.productmanagement.model.Category;
import com.codingz2m.productmanagement.service.CategoryService;
import com.codingz2m.productmanagement.service.ProductService;
import com.codingz2m.productmanagement.util.AppUtils;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;


    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        Category savedCategory = categoryService.save(categoryDto);
        
        return savedCategory != null
                ? new ResponseEntity<>( AppUtils.entityToDto( savedCategory), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) throws CategoryNotFoundException {
        Category category = categoryService.getById(id);
        CategoryDto categoryDto = AppUtils.entityToDto( category);
        return categoryDto != null
                ? new ResponseEntity<>(categoryDto, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() throws CategoryNotFoundException {
    	
    	 List<CategoryDto> categoriesDto= new ArrayList<CategoryDto>();    	 
        List<Category> categories = categoryService.getAll();
        Iterator<Category> iterator = categories.iterator(); 
        
        while(iterator.hasNext()) {
        	Category category = (Category) iterator.next();
        	CategoryDto categoryDto = AppUtils.entityToDto(category);
        	categoriesDto.add(categoryDto);
		   }
        return new ResponseEntity<>(categoriesDto, HttpStatus.OK);
    }

 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) throws CategoryNotFoundException {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
