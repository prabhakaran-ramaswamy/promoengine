package com.promoengine.core;

import com.promoengine.service.DisplayService;
import com.promoengine.service.ProductService;

public class PromoEngine {
	ProductService productService;
	DisplayService displayService;
	public PromoEngine(){
		productService= new ProductService();
		displayService = new DisplayService();
		productService.addTemplateProducts();
		displayService.displayProducts(productService.getAllProducts());
	}
}
