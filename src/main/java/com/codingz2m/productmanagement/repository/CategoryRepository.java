package com.codingz2m.productmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingz2m.productmanagement.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


}

