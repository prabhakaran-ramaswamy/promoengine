package com.promoengine.model;

public class CombinedPromotion extends AbstractPromotion {

	public CombinedPromotion(Product product) {
		super(product);
	}

	@Override
	public double calculatePrice() {
		return 0;
	}
}
