package com.promoengine.cart;

import com.promoengine.model.Product;

public class FixedItem extends Item {
	Product product;
	
	public FixedItem(int quantity, double price, Product product) {
		super(quantity, price);
		this.product = product;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
