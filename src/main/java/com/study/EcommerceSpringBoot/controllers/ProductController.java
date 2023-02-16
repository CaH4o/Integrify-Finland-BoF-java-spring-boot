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

import com.study.EcommerceSpringBoot.models.Product;
import com.study.EcommerceSpringBoot.repositories.ProductRepository;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	@Autowired
	private ProductRepository repository;

	// http://localhost:8080/api/v1/products
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	@GetMapping("/products/{id}")
	public Product getSingleProduct(@PathVariable long id) {
		Optional<Product> product = repository.findById(id);

		if (product.isEmpty()) {
			throw new RuntimeException("The product with id [" + id + "] is not found.");
		} else {
			return product.get();
		}
	}

	@PostMapping("/products")
	public void createSingleProduct(@RequestBody Product product) {
		repository.save(product);
	}

	@PutMapping("/products/{id}")
	public void updateSingleProduct(@PathVariable long id, @RequestBody Product productBody) {
		Optional<Product> product = repository.findById(id);

		if (product.isEmpty()) {
			throw new RuntimeException("The product with id [" + id + "] is not found.");
		} else {
			repository.save(productBody);
		}
	}

	@DeleteMapping("/products/{id}")
	public void deleteSingleProduct(@PathVariable long id) {
		Optional<Product> product = repository.findById(id);

		if (product.isEmpty()) {
			throw new RuntimeException("The product with id [" + id + "] is not found.");
		} else {
			repository.deleteById(id);
		}
	}
}