package com.promoengine.cart;

import java.util.List;

import com.promoengine.model.Product;

public class MergedItem extends Item {
	public MergedItem(List<Product> products, int quantity, double price) {
		super(quantity, price);
	}
}
