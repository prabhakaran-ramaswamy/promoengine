package com.promoengine.model;

public class PercentPromotion extends AbstractPromotion {
	int quantity;
	int percent;

	public PercentPromotion(Product product, int quantity, int percent) {
		super(product);
		this.quantity = quantity;
		this.percent = percent;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

}
