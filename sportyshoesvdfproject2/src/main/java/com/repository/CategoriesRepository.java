package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {

}
