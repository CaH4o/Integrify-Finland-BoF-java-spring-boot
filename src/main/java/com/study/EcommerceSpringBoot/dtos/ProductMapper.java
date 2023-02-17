package com.study.EcommerceSpringBoot.dtos;

import org.springframework.stereotype.Component;

import com.study.EcommerceSpringBoot.models.Category;
import com.study.EcommerceSpringBoot.models.Product;

@Component
public class ProductMapper {
	public Product createProduct(Product product, Category category) {
		return new Product(product.getTitle(), category, product.getPrice());
	}
}
