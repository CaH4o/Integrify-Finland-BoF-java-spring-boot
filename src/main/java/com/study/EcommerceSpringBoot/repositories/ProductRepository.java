package com.study.EcommerceSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.EcommerceSpringBoot.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
