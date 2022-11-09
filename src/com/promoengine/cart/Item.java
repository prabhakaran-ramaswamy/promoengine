package com.promoengine.cart;

public abstract  class Item {
	int quantity;
	double price;

	public Item(int quantity, double price) {
		super();
		this.quantity = quantity;
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
