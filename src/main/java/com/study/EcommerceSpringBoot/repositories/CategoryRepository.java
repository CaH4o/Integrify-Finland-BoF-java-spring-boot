package com.study.EcommerceSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.EcommerceSpringBoot.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
