package com.promoengine.service;

import java.util.ArrayList;
import java.util.List;

import com.promoengine.model.Product;
import com.promoengine.model.Promotion;

public class PromotionService {

	List<Promotion> promotions = new ArrayList<Promotion>();

	public void addPromotion(Promotion promotion) {
		promotions.add(promotion);
	}

	public List<Promotion> getAvailablePromos(char sku) {
		List<Promotion> ps = new ArrayList<Promotion>();
		for (Promotion pm : promotions) {
			Product p = pm.getProduct();
			if (p.getSku() == sku) {
				ps.add(pm);
			}
		}
		return ps;
	}
}
