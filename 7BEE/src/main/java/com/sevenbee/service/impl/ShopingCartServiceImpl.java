package com.sevenbee.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.sevenbee.entity.SANPHAM;
import com.sevenbee.service.ShoppingCartService;
import com.sevenbee.util.DataSharing;


@Service
@SessionScope
public class ShopingCartServiceImpl implements ShoppingCartService{
	
	private static HashMap<String, SANPHAM> carts = new HashMap<>();
	@Override
	public void addProduct(String SP_MA) {
		// TODO Auto-generated method stub
		carts = DataSharing.cart;
//		SANPHAM sanpham = carts.get(SP_MA);
//		System.out.println("sanpham: " + sanpham);
//		if(!carts.containsKey(SP_MA)) {
//			carts.put(sanpham.getSP_MA(), sanpham);
//		} else if (sanpham != null) {
//			int oldQuantity = carts.get(SP_MA).getSP_SoLuong();
//			carts.get(SP_MA).setSP_SoLuong(oldQuantity + 1); 
//		}
	}

	@Override
	public void removeProduct(String SP_MA) {
		carts.remove(SP_MA);		
	}

	@Override
	public void updateProduct(String SP_MA, int qty) {
		carts.get(SP_MA).setSP_SoLuong(qty);
		
	}

	@Override
	public void clear() {
		carts.clear();
		
	}

	@Override
	public Map<String, SANPHAM> getProducts() {
		// TODO Auto-generated method stub
		return carts;
	}

	@Override
	public int getCount() {
		int count = 0;
		for (SANPHAM sanpham : carts.values()) {
			count += sanpham.getSP_SoLuong();
		}
		return count;
	}

	@Override
	public double getAmount() {
		double amount = 0;
		for (SANPHAM sanpham : carts.values()) {
			amount += sanpham.getSP_Gia() * sanpham.getSP_SoLuong();
		}
		return amount;
	}	

	
}
