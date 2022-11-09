package com.promoengine.service;

import java.util.List;

import com.promoengine.cart.CartItem;
import com.promoengine.cart.Item;
import com.promoengine.cart.MergedItem;
import com.promoengine.model.CombinedPromotion;
import com.promoengine.model.FixedPromotion;
import com.promoengine.model.Product;
import com.promoengine.model.Promotion;

public class DisplayService {
	public void displayProducts(List<Product> products) {
		System.out.println("Products Details");
		for (Product product : products) {
			System.out.println(product);
		}
		System.out.println();
	}

	public void displayOffers(List<Promotion> promos) {
		System.out.println("Promotion Offer Details");
		for (Promotion promotion : promos) {
			if (promotion instanceof FixedPromotion) {
				FixedPromotion fp = (FixedPromotion) promotion;
				System.out.println(promotion.getProduct() + " Fixed " + fp.getQuantity() + " " + fp.getOfferAmount());
			}
			if (promotion instanceof CombinedPromotion) {
				CombinedPromotion cp = (CombinedPromotion) promotion;
				System.out.println(
						promotion.getProduct() + " Combined " + cp.getProductsSkus() + " " + cp.getOfferAmount());
			}
		}
	}

	public void displayCart(List<Item> cartItems, String str) {
		System.out.println(str);
		for (Item item : cartItems) {
			if (item instanceof CartItem) {
				CartItem ci = (CartItem) item;
				System.out.println("SKU : " + ci.getProduct().getSku() + " Quantity: " + ci.getQuantity() + " Price: "
						+ ci.getPrice());
			} else {
				MergedItem mi = (MergedItem) item;
				String skus = "";
				for (Product p : mi.getProducts()) {
					skus += p.getSku() + " ";
				}
				System.out.println("SKU : (" + skus + ") Quantity: " + mi.getQuantity() + " Price: " + mi.getPrice());
			}
		}

	}
}
