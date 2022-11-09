package com.promoengine.cart;

import com.promoengine.model.Product;

public class CartItem extends Item {
	Product product;
	public CartItem(int quantity, double price) {
		super(quantity, price);
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
