package com.study.EcommerceSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.EcommerceSpringBoot.bean.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
