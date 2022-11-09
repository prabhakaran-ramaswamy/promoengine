package com.promoengine.model;

public class PercentPromotion extends AbstractPromotion  {

	public PercentPromotion(Product product) {
		super(product);
	}
	@Override
	public double calculatePrice() {
		return 0;
	}
}
