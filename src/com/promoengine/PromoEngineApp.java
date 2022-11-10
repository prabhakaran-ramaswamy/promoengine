package com.promoengine;

import java.util.ArrayList;
import java.util.List;

import com.promoengine.core.PromoEngine;
import com.promoengine.model.BuyItem;

public class PromoEngineApp {

	public static void main(String[] args) {
		PromoEngine promoEngine = new PromoEngine();
		List<BuyItem> buyItem = new ArrayList<BuyItem>();
		buyItem.add(new BuyItem('A', 1));
		buyItem.add(new BuyItem('A', 5));
		buyItem.add(new BuyItem('A', 5));
		buyItem.add(new BuyItem('B', 1));
		buyItem.add(new BuyItem('B', 5));
		buyItem.add(new BuyItem('B', 5));
		buyItem.add(new BuyItem('C', 3));
		buyItem.add(new BuyItem('D', 1));
		promoEngine.buyProducts(buyItem);
		promoEngine.updateCart();
	}
}
