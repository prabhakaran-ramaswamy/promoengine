package com.promoengine.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.promoengine.cart.CartItem;
import com.promoengine.cart.MergedItem;
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
		List<BuyItem> exculudes = new ArrayList<BuyItem>();
		for (BuyItem buy : buyItems) {
			List<Promotion> availablePromos = promotionService.getAvailablePromos(buy.getSku());
			if (availablePromos.size() > 0 && !applyFixedAndPercentPromo(buy, availablePromos.get(0))) {
				buy.setAvailablePromos(availablePromos);
				exculudes.add(buy);
			}
		}
		HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
		if (exculudes.size() > 0) {
			for (BuyItem buy : buyItems) {
				if (hashMap.containsKey(buy.getSku())) {
					hashMap.put(buy.getSku(), hashMap.get(buy.getSku()) + buy.getQuantity());
				} else {
					hashMap.put(buy.getSku(), buy.getQuantity());
				}
			}
		}
		for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
			char key = entry.getKey();
			int quantity = entry.getValue();
			Product product = productService.getProduct(key);
			List<Promotion> availablePromos = promotionService.getAvailablePromos(key);
			if (availablePromos.size() > 0) {
				Promotion promotion = availablePromos.get(0);
				if (promotion instanceof CombinedPromotion) {
					List<Product> products = ((CombinedPromotion) promotion).getProducts();
					double price = 0;
					for (Product p : products) {
						price = ((CombinedPromotion) promotion).getOfferAmount();
						hashMap.put(p.getSku(), hashMap.get(p.getSku()) - 1);
					}
					price = price == 0 ? product.getPrice() : price;
					MergedItem m = new MergedItem(quantity, price * quantity, products);
					cartService.addToCart(m);
				}
			}
		}

	}

	public boolean applyFixedAndPercentPromo(BuyItem buy, Promotion promo) {
		Product product = productService.getProduct(buy.getSku());
		if (promo instanceof FixedPromotion) {
			double price = promotionService.calculateFixedPrice(buy.getQuantity(), (FixedPromotion) promo, product);
			CartItem c = new CartItem(buy.getQuantity(), price);
			c.setProduct(product);
			cartService.addToCart(c);
			return true;
		}
		if (promo instanceof PercentPromotion) {
			double price = promotionService.calculatePercentagePrice(buy.getQuantity(), (PercentPromotion) promo,
					product);
			CartItem c = new CartItem(buy.getQuantity(), price);
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
