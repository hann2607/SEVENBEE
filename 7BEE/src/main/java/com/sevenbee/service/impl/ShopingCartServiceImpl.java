package com.sevenbee.service.impl;

import java.util.HashMap;




import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;


import com.sevenbee.entities.SANPHAM;
import com.sevenbee.service.ShoppingCartService;


@Service
@SessionScope
public class ShopingCartServiceImpl implements ShoppingCartService{
	
	private static HashMap<String, SANPHAM> orders = new HashMap<>();

	@Override
	public void addProduct(String SP_MA) {
		System.out.println(SP_MA);
		// TODO Auto-generated method stub
		SANPHAM sanpham = orders.get(SP_MA).orderProduct(1);
		System.out.println(sanpham.getSP_MA()+" "+sanpham.getSP_SoLuong());
		if(!orders.containsKey(SP_MA)) {
			orders.put(sanpham.getSP_MA(), sanpham);
		} else if (sanpham != null) {
			int oldQuantity = orders.get(SP_MA).getSP_SoLuong();
			orders.get(SP_MA).setSP_SoLuong(oldQuantity + 1); 
		}
	}

	@Override
	public void removeProduct(String SP_MA) {
		SANPHAM sanpham = orders.get(SP_MA);
		orders.get(SP_MA).orderProduct(0 - sanpham.getSP_SoLuong());
		orders.remove(SP_MA);		
	}

	@Override
	public void updateProduct(String SP_MA, int qty) {
		SANPHAM sanpham = orders.get(SP_MA);
		SANPHAM sanphamcheck = orders.get(SP_MA).orderProduct(qty - sanpham.getSP_SoLuong());
		//UPdate or remove product
		if(qty > 0) {
			if(sanphamcheck != null) {
				sanpham.setSP_SoLuong(qty);
			}
		} else {
			orders.remove(SP_MA);
		}
		
	}

	@Override
	public void clear() {
		for (String SP_MA : orders.keySet()) {
			SANPHAM sanpham = orders.get(SP_MA);
			// Return quantity order into products list
			orders.get(SP_MA).orderProduct(0 - sanpham.getSP_SoLuong());
		}
		orders.clear();
		
	}

	@Override
	public Map<String, SANPHAM> getProducts() {
		// TODO Auto-generated method stub
		return orders;
	}

	@Override
	public int getCount() {
		int count = 0;
		for (SANPHAM sanpham : orders.values()) {
			count += sanpham.getSP_SoLuong();
		}
		return count;
	}

	@Override
	public double getAmount() {
		double amount = 0;
		for (SANPHAM sanpham : orders.values()) {
			amount += sanpham.getSP_Gia() * sanpham.getSP_SoLuong();
		}
		return amount;
	}
	
	

	
	
	

	
}
