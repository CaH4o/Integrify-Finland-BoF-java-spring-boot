package com.study.EcommerceSpringBoot.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "title", nullable = false, columnDefinition = "varchar(255)")
	private String title;

	@ManyToOne(optional = false)
	private Category category;

	@Column(name = "price", nullable = false, columnDefinition = "double")
	private double price;

	public Product() {
	}

	public Product(String title, Category category, double price) {
		this.title = title;
		this.category = category;
		this.price = price;
	}

	public long getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	@JsonProperty("Category")
	public Category getCategory() {
		return this.category;
	}

	public double getPrice() {
		return this.price;
	}

	@Override
	public String toString() {
		return "Product [id=" + this.id + ", Title=" + this.title + ", Category=" + this.category + ", Price="
				+ this.price + "]";
	}

}
