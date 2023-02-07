package com.study.EcommerceSpringBoot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.EcommerceSpringBoot.bean.Category;
import com.study.EcommerceSpringBoot.repository.CategoryRepository;

@RestController
public class CategoryController {
	@Autowired
	private CategoryRepository repository;

	// http://localhost:8080/api/v1/categories
	@GetMapping("/api/v1/categories")
	public List<Category> getAllCategories() {
		return repository.findAll();
	}

	@GetMapping("/api/v1/categories/{id}")
	public Category getSingleCategory(@PathVariable long id) {
		Optional<Category> category = repository.findById(id);

		if (category.isEmpty()) {
			throw new RuntimeException("The product with id [" + id + "] is not found.");
		} else {
			return category.get();
		}
	}

	@PostMapping("/api/v1/categories")
	public void createSingleCategory(@RequestBody Category category) {
		repository.save(category);
	}

	@PutMapping("/api/v1/categories/{id}")
	public void updateSingleCategory(@PathVariable long id, @RequestBody Category categoryBody) {
		Optional<Category> category = repository.findById(id);

		if (category.isEmpty()) {
			throw new RuntimeException("The category with id [" + id + "] is not found.");
		} else {
			repository.save(categoryBody);
		}
	}

	@DeleteMapping("/api/v1/categories/{id}")
	public void deleteSingleCategory(@PathVariable long id) {
		Optional<Category> category = repository.findById(id);

		if (category.isEmpty()) {
			throw new RuntimeException("The category with id [" + id + "] is not found.");
		} else {
			repository.deleteById(id);
		}
	}
}
