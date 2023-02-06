package com.study.EcommerceSpringBoot.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.EcommerceSpringBoot.bean.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
