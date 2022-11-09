package com.promoengine.model;

public class FixedPromotion extends AbstractPromotion {

	public FixedPromotion(Product product) {
		super(product);
	}

	@Override
	public double calculatePrice() {
		return 0;
	}
}
