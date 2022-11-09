package com.promoengine.model;

public enum PromotionType {
	NO("NO"), FIXED("FIXED"), COMBINED("COMBINED"), PERCENT("PERCENT");

	private final String promotionType;

	PromotionType(String pType) {
		promotionType = pType;
	}

	@Override
	public String toString() {
		return promotionType;
	}
}
