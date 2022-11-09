package com.promoengine.core;

import com.promoengine.service.DisplayService;
import com.promoengine.service.ProductService;
import com.promoengine.service.PromotionService;

public class PromoEngine {
	ProductService productService;
	DisplayService displayService;
	PromotionService promotionService;
	public PromoEngine(){
		productService= new ProductService();
		promotionService= new PromotionService(productService);
		displayService = new DisplayService();
		productService.addTemplateProducts();
		promotionService.addTemplatePromotions();
		displayService.displayProducts(productService.getAllProducts());
		displayService.displayOffers(promotionService.getPromotions());
	}
}
