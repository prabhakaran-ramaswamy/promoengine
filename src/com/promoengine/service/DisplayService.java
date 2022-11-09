package com.promoengine.service;

import java.util.List;

import com.promoengine.model.CombinedPromotion;
import com.promoengine.model.FixedPromotion;
import com.promoengine.model.Product;
import com.promoengine.model.Promotion;


public class DisplayService {
	public void displayProducts(List<Product> products) {
		System.out.println("product Details");
		for (Product product : products) {
			System.out.println(product);
		}
		System.out.println();
	}
	
	public void displayOffers(List<Promotion> promos) {
		System.out.println("Offer Details");
		for (Promotion promotion : promos) {
			if(promotion instanceof FixedPromotion) {
				FixedPromotion fp=(FixedPromotion)promotion;
				System.out.println(promotion.getProduct() + " Fixed "+fp.getQuantity()+" "+fp.getOfferAmount());
			}
			if(promotion instanceof CombinedPromotion) {
				CombinedPromotion cp=(CombinedPromotion)promotion;
				System.out.println(promotion.getProduct() + " Combined "+cp.getProductsSkus()+" "+cp.getOfferAmount());
			}
		}
	}
}
