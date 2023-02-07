package com.study.EcommerceSpringBoot.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	@Column(name = "Title", nullable = false, columnDefinition = "varchar(255)")
	private String title;

	public Category() {
	}

	public Category(String title) {
		super();
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
