package com.promoengine.service;

import java.util.ArrayList;
import java.util.List;

import com.promoengine.model.CombinedPromotion;
import com.promoengine.model.FixedPromotion;
import com.promoengine.model.PercentPromotion;
import com.promoengine.model.Product;
import com.promoengine.model.Promotion;

public class PromotionService {

	List<Promotion> promotions = new ArrayList<Promotion>();
	ProductService productService;

	public PromotionService(ProductService productService) {
		this.productService = productService;
	}

	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

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

	public void addTemplatePromotions() {
		addPromotion(new FixedPromotion(productService.getProduct('A'), 130, 3));
		addPromotion(new FixedPromotion(productService.getProduct('B'), 45, 2));
		char[] c1 = { 'C', 'D' };
		addPromotion(new CombinedPromotion(productService.getProduct('C'), productService.getProducts(c1), 30));
	}
	
	double calculateFixedPrice(int cquantity, FixedPromotion promotion, Product product) {
		int quantity = cquantity / promotion.getQuantity();
		int re = cquantity % promotion.getQuantity();
		return (quantity * promotion.getOfferAmount()) + (re * product.getPrice());
	}
	
	double calculatePercentagePrice(int cquantity, PercentPromotion promotion, Product product) {
		if (promotion.getQuantity() <= cquantity) {
			double percentage = ((product.getPrice() * promotion.getPercent()) / 100);
			return (product.getPrice() * cquantity) - (percentage * cquantity);
		}
		return product.getPrice() * cquantity;
	}
}
