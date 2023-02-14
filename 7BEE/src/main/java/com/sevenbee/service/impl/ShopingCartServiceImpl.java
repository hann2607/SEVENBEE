package com.sevenbee.service.impl;

import java.util.HashMap;



import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;


import com.sevenbee.entities.DONHANG;
import com.sevenbee.service.ShoppingCartService;
import com.sevenbee.util.DataSharing;

@Service
@SessionScope
public class ShopingCartServiceImpl implements ShoppingCartService{
	
	private static HashMap<String, DONHANG> orders = new HashMap<>();

	@Override
	public void addProduct(String DH_MA) {
		DONHANG donhang = DataSharing.donhang.get(DH_MA).orderProduct(1);
		if(!orders.containsKey(DH_MA)) {
			orders.put(donhang.getDH_MA(), donhang);
		} else if (donhang != null) {
			int oldQuantity = orders.get(DH_MA).getSo_Luong();
			orders.get(DH_MA).setSo_Luong(oldQuantity + 1); 
		}			
	}

	@Override
	public void removeProduct(String DH_MA) {
		DONHANG donhang = orders.get(DH_MA);
		DataSharing.donhang.get(DH_MA).orderProduct(0 - donhang.getSo_Luong());
		orders.remove(DH_MA);	
	}

	@Override
	public void updateProduct(String DH_MA, int qty) {
		DONHANG donhang = orders.get(DH_MA);
		DONHANG donhangcheck = DataSharing.donhang.get(DH_MA).orderProduct(qty - donhang.getSo_Luong());
		//UPdate or remove DH
		if(qty > 0) {
			if(donhangcheck != null) {
				donhang.setSo_Luong(qty);
			}
		} else {
			orders.remove(DH_MA);
		}	
	}

	@Override
	public void clear() {
		for (String DH_MA : orders.keySet()) {
			DONHANG donhang = orders.get(DH_MA);
			// Return quantity order into DH list
			DataSharing.donhang.get(DH_MA).orderProduct(0 - donhang.getSo_Luong());
		}
		orders.clear();
	}

	@Override
	public Map<String, DONHANG> getProducts() {
		return orders;
	}

	@Override
	public int getCount() {
		int count = 0;
		for (DONHANG donhang : orders.values()) {
			count += donhang.getSo_Luong();
		}
		return count;
	}

	@Override
	public double getAmount() {
		double amount = 0;
		for (DONHANG donhang : orders.values()) {
			amount += donhang.getDon_gia() * donhang.getSo_Luong();
		}
		return amount;
	
	}
	
	

	
}
