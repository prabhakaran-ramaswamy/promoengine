package com.promoengine.model;

public class FixedPromotion extends AbstractPromotion {
	double offerAmount;
	int quantity;

	public FixedPromotion(Product product, double offerAmount, int quantity) {
		super(product);
		this.offerAmount = offerAmount;
		this.quantity = quantity;
	}

	public double getOfferAmount() {
		return offerAmount;
	}

	public void setOfferAmount(double offerAmount) {
		this.offerAmount = offerAmount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
