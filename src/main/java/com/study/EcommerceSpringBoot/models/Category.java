package com.study.EcommerceSpringBoot.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "title", nullable = false, columnDefinition = "varchar(255)", unique = true)
	private String title;

	public Category() {
	}

	public Category(String title) {
		this.title = title;
	}

	public long getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	@Override
	public String toString() {
		return "Category [id=" + this.id + ", title=" + this.title + "]";
	}

}
