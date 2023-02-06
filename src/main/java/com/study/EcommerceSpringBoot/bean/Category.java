package com.study.EcommerceSpringBoot.bean;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	@Column(name = "Title", nullable = false, columnDefinition = "varchar(255)")
	private String title;

	public Category() {
	}

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Product.class, mappedBy = "category")
	private List<Product> telemetryData;

	public Category(long id, String title) {
		super();
		this.Id = id;
		this.title = title;
	}

	public long getId() {
		return this.Id;
	}

	public String getTitle() {
		return this.title;
	}

	@Override
	public String toString() {
		return "Category [Id=" + this.Id + ", Title=" + this.title + "]";
	}

}
