package com.promoengine.model;

public abstract class AbstractPromotion implements Promotion {

	Product product;

	public AbstractPromotion(Product product) {
		super();
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
