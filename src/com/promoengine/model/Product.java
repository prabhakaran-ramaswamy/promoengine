package com.promoengine.model;

import java.util.Objects;

public class Product {
	
	double price;
	char sku;

	public Product(char sku, double price) {
		super();
		this.sku = sku;
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public char getSku() {
		return sku;
	}

	public void setSku(char sku) {
		this.sku = sku;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(sku);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return sku == other.sku;
	}

	@Override
	public String toString() {
		return "sku=" + sku+", price=" + price ;
	}
	
}