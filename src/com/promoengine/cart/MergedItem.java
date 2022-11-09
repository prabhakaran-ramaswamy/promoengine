package com.promoengine.cart;

import java.util.List;

import com.promoengine.model.Product;

public class MergedItem extends Item {
	List<Product> products;

	public MergedItem(int quantity, double price, List<Product> products) {
		super(quantity, price);
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
