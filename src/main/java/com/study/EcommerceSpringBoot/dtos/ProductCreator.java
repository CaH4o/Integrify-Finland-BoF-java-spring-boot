package com.study.EcommerceSpringBoot.dtos;

import com.study.EcommerceSpringBoot.models.Product;

public class ProductCreator extends Product {
	private long categoryId;

	public long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(long id) {
		this.categoryId = id;
	}

}
