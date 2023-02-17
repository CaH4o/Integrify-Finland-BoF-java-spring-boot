package com.study.EcommerceSpringBoot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.EcommerceSpringBoot.dtos.ProductCreator;
import com.study.EcommerceSpringBoot.dtos.ProductMapper;
import com.study.EcommerceSpringBoot.models.Category;
import com.study.EcommerceSpringBoot.models.Product;
import com.study.EcommerceSpringBoot.repositories.CategoryRepository;
import com.study.EcommerceSpringBoot.repositories.ProductRepository;

@RestController
@RequestMapping("/api/v1") // http://localhost:8080/api/v1/products
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductMapper productMapper;

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@GetMapping("/products/{id}")
	public Product getSingleProduct(@PathVariable long id) {
		Optional<Product> product = productRepository.findById(id);

		if (product.isEmpty()) {
			throw new RuntimeException("The product with id [" + id + "] is not found.");
		} else {
			return product.get();
		}
	}

	@PostMapping("/products")
	public void createSingleProduct(@RequestBody ProductCreator product) {
		Optional<Category> category = categoryRepository.findById(product.getCategoryId());

		if (category.isEmpty()) {
			throw new RuntimeException("The category with id [" + product.getCategoryId() + "] is not found.");
		} else {
			productRepository.save(productMapper.createProduct(product, category.get()));
		}
	}

	@PutMapping("/products/{id}")
	public void updateSingleProduct(@PathVariable long id, @RequestBody ProductCreator productBody) {
		Optional<Product> product = productRepository.findById(id);
		Optional<Category> category = categoryRepository.findById(productBody.getCategoryId());

		if (product.isEmpty()) {
			throw new RuntimeException("The product with id [" + id + "] is not found.");
		} else if (category.isEmpty()) {
			throw new RuntimeException("The category with id [" + productBody.getCategoryId() + "] is not found.");
		} else {
			productRepository.save(productMapper.createProduct(product.get(), category.get()));
		}
	}

	@DeleteMapping("/products/{id}")
	public void deleteSingleProduct(@PathVariable long id) {
		Optional<Product> product = productRepository.findById(id);

		if (product.isEmpty()) {
			throw new RuntimeException("The product with id [" + id + "] is not found.");
		} else {
			productRepository.deleteById(id);
		}
	}
}
