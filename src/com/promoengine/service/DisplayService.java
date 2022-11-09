package com.promoengine.service;

import java.util.List;

import com.promoengine.model.Product;


public class DisplayService {
	public void displayProducts(List<Product> products) {
		System.out.println("product Details");
		for (Product product : products) {
			System.out.println(product);
		}
		System.out.println();
	}
}
