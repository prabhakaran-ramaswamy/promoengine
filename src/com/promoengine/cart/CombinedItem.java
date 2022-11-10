package com.promoengine.cart;

import com.promoengine.model.Product;

public class CombinedItem extends Item {
	Product combinedItem;
	Product product;

	public CombinedItem(int quantity, double price, Product product, Product combinedItem) {
		super(quantity, price);
		this.product=product;
		this.combinedItem = combinedItem;
	}

	public Product getCombinedItem() {
		return combinedItem;
	}

	public void setCombinedItem(Product combinedItem) {
		this.combinedItem = combinedItem;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
