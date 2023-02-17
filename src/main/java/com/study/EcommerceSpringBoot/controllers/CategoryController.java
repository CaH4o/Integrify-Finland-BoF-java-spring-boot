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

import com.study.EcommerceSpringBoot.models.Category;
import com.study.EcommerceSpringBoot.repositories.CategoryRepository;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {
	@Autowired
	private CategoryRepository categoryRepository;

	// http://localhost:8080/api/v1/categories
	@GetMapping("/categories")
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@GetMapping("/categories/{id}")
	public Category getSingleCategory(@PathVariable long id) {
		Optional<Category> category = categoryRepository.findById(id);

		if (category.isEmpty()) {
			throw new RuntimeException("The product with id [" + id + "] is not found.");
		} else {
			return category.get();
		}
	}

	@PostMapping("/categories")
	public void createSingleCategory(@RequestBody Category category) {
		categoryRepository.save(category);
	}

	@PutMapping("/categories/{id}")
	public void updateSingleCategory(@PathVariable long id, @RequestBody Category categoryBody) {
		Optional<Category> category = categoryRepository.findById(id);

		if (category.isEmpty()) {
			throw new RuntimeException("The category with id [" + id + "] is not found.");
		} else {
			categoryRepository.save(categoryBody);
		}
	}

	@DeleteMapping("/categories/{id}")
	public void deleteSingleCategory(@PathVariable long id) {
		Optional<Category> category = categoryRepository.findById(id);

		if (category.isEmpty()) {
			throw new RuntimeException("The category with id [" + id + "] is not found.");
		} else {
			categoryRepository.deleteById(id);
		}
	}
}
