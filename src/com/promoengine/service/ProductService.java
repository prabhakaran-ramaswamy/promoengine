package com.promoengine.service;

import java.util.ArrayList;
import java.util.List;

import com.promoengine.model.Product;

public class ProductService {
	List<Product> products = new ArrayList<Product>();

	public void addProduct(Product p) {
		products.add(p);
	}

	public List<Product> getAllProducts() {
		return products;
	}

	public Product getProduct(char sku) {
		for (Product product : products) {
			if (product.getSku() == sku) {
				return product;
			}
		}
		return null;
	}

	public List<Product> getProducts(char[] skus) {
		List<Product> products = new ArrayList<Product>();
		for (char sku : skus) {
			products.add(getProduct(sku));
		}
		return products;
	}
}
