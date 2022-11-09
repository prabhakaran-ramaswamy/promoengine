package com.promoengine.service;

import java.util.ArrayList;
import java.util.List;

import com.promoengine.cart.Item;

public class CartService {
	List<Item> cartItems = new ArrayList<Item>();

	public List<Item> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<Item> cartItems) {
		this.cartItems = cartItems;
	}

	public void addToCart(Item item) {
		cartItems.add(item);
	}
}
