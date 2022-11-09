package com.promoengine.model;

import java.util.ArrayList;
import java.util.List;

public class CombinedPromotion extends AbstractPromotion {
	List<Product> products;
	double offerAmount;

	public CombinedPromotion(Product product, List<Product> combined, double offerAmount) {
		super(product);
		this.products = combined;
		this.offerAmount = offerAmount;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public double getOfferAmount() {
		return offerAmount;
	}

	public void setOfferAmount(double offerAmount) {
		this.offerAmount = offerAmount;
	}

	public List<Character> getProductsSkus() {
		List<Character> ls = new ArrayList<Character>();
		for (Product p : products) {
			ls.add(p.getSku());
		}
		return ls;
	}

	public double calculatePrice(List<Product> prs) {
		if(prs.size() == products.size() && products.containsAll(prs)) {
			return offerAmount;
		}
		return 0;
	}

}
