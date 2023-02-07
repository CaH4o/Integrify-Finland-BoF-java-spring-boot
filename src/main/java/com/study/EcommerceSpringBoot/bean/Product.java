package com.study.EcommerceSpringBoot.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	@Column(name = "Title", nullable = false, columnDefinition = "varchar(255)")
	private String title;

//	@JoinColumn(name = "CategoryId", nullable = false)
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Category.class)
	private Category category;

	@Column(name = "Price", nullable = false, columnDefinition = "double")
	private double price;

	public Product() {
	}

	public Product(long id, String title, Category category, double price) {
		super();
		this.Id = id;
		this.title = title;
		this.category = category;
		this.price = price;
	}

	public long getId() {
		return this.Id;
	}

	public String getTitle() {
		return this.title;
	}

	public Category getCategory() {
		return this.category;
	}

	public double getPrice() {
		return this.price;
	}

	@Override
	public String toString() {
		return "Product [Id=" + this.Id + ", Title=" + this.title + ", Category=" + this.category + ", Price="
				+ this.price + "]";
	}

}
