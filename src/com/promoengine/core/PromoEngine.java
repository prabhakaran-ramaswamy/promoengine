package com.promoengine.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.promoengine.cart.FixedItem;
import com.promoengine.model.BuyItem;
import com.promoengine.model.CombinedPromotion;
import com.promoengine.model.FixedPromotion;
import com.promoengine.model.PercentPromotion;
import com.promoengine.model.Product;
import com.promoengine.model.Promotion;
import com.promoengine.service.CartService;
import com.promoengine.service.DisplayService;
import com.promoengine.service.ProductService;
import com.promoengine.service.PromotionService;

public class PromoEngine {

	ProductService productService;
	DisplayService displayService;
	PromotionService promotionService;
	CartService cartService;

	public PromoEngine() {
		productService = new ProductService();
		promotionService = new PromotionService(productService);
		displayService = new DisplayService();
		cartService = new CartService();
		addTemplateProducts();
		addTemplatePromotions();
		displayService.displayProducts(productService.getAllProducts());
		displayService.displayOffers(promotionService.getPromotions());
		displayService.displayCart(cartService.getCartItems(), "");
	}

	public void updateCart() {
		displayService.displayCart(cartService.getCartItems(), "Updated Cart Details");
	}

	public void buyProducts(List<BuyItem> buyItems) {
		HashMap<Character, Integer> orders = new HashMap<Character, Integer>();
		for (BuyItem buy : buyItems) {
			if (orders.containsKey(buy.getSku())) {
				orders.put(buy.getSku(), orders.get(buy.getSku()) + buy.getQuantity());
			} else {
				orders.put(buy.getSku(), buy.getQuantity());
			}
		}
		for (Map.Entry<Character, Integer> entry : orders.entrySet()) {
			char sku = entry.getKey();
			int quantity = entry.getValue();
			List<Promotion> availablePromos = promotionService.getAvailablePromos(sku);
			if (availablePromos.size() > 0 && !applyFixedAndPercentPromo(new BuyItem(sku,quantity), availablePromos.get(0))) {
			}
		}

	}

	public boolean applyFixedAndPercentPromo(BuyItem buy, Promotion promo) {
		Product product = productService.getProduct(buy.getSku());
		if (promo instanceof FixedPromotion) {
			double price = promotionService.calculateFixedPrice(buy.getQuantity(), (FixedPromotion) promo, product);
			FixedItem c = new FixedItem(buy.getQuantity(), price);
			c.setProduct(product);
			cartService.addToCart(c);
			return true;
		}
		if (promo instanceof PercentPromotion) {
			double price = promotionService.calculatePercentagePrice(buy.getQuantity(), (PercentPromotion) promo,
					product);
			FixedItem c = new FixedItem(buy.getQuantity(), price);
			c.setProduct(product);
			cartService.addToCart(c);
			return true;
		}
		return false;
	}

	public void addTemplatePromotions() {
		promotionService.addPromotion(new FixedPromotion(productService.getProduct('A'), 130, 3));
		promotionService.addPromotion(new FixedPromotion(productService.getProduct('B'), 45, 2));
		char[] c1 = { 'C', 'D' };
		promotionService.addPromotion(
				new CombinedPromotion(productService.getProduct('C'), productService.getProducts(c1), 30));
		promotionService.addPromotion(new PercentPromotion(productService.getProduct('E'), 4, 20));
		promotionService.addPromotion(new PercentPromotion(productService.getProduct('F'), 3, 10));
	}

	public void addTemplateProducts() {
		productService.addProduct(new Product('A', 50));
		productService.addProduct(new Product('B', 30));
		productService.addProduct(new Product('C', 20));
		productService.addProduct(new Product('D', 15));
		productService.addProduct(new Product('E', 100));
		productService.addProduct(new Product('F', 60));
		productService.addProduct(new Product('G', 80));

	}

}
