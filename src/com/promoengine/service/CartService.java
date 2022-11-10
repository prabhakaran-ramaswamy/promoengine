package com.promoengine.service;

import java.util.ArrayList;
import java.util.List;

import com.promoengine.cart.CombinedItem;
import com.promoengine.cart.FixedItem;
import com.promoengine.cart.Item;
import com.promoengine.model.Product;

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
	
	public double getTotal() {
		double total=0;
		for (Item item : cartItems) {
			total+=item.getPrice();
		}
		return total;
	}
}
