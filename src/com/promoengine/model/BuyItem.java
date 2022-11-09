package com.promoengine.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BuyItem {

	char sku;
	int quantity;
	List<Promotion> availablePromos=new ArrayList<Promotion>();
	public BuyItem(char sku,int quantity) {
		super();
		this.quantity = quantity;
		this.sku = sku;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public char getSku() {
		return sku;
	}
	public void setSku(char sku) {
		this.sku = sku;
	}

	public List<Promotion> getAvailablePromos() {
		return availablePromos;
	}
	public void setAvailablePromos(List<Promotion> availablePromos) {
		this.availablePromos = availablePromos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sku);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BuyItem other = (BuyItem) obj;
		return sku == other.sku;
	}
	
}
