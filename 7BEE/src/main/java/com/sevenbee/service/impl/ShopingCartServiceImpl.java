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
	public void addProduct(Integer id) {
		DONHANG donhang = DataSharing.donhang.get(id).orderProduct(1);
		if(!orders.containsKey(id)) {
			orders.put(donhang.getDH_MA(), donhang);
		} else if (donhang != null) {
			int oldQuantity = orders.get(id).getSo_Luong();
			orders.get(id).setSo_Luong(oldQuantity + 1); 
		}	
	}

	@Override
	public void removeProduct(Integer id) {
		//Remove product
		DONHANG donhang = orders.get(id);
		DataSharing.donhang.get(id).orderProduct(0 - donhang.getSo_Luong());
		orders.remove(id);
	}

	@Override
	public void updateProduct(Integer id, int qty) {
		DONHANG donhang = orders.get(id);
		DONHANG donhangcheck = DataSharing.donhang.get(id).orderProduct(qty - donhang.getSo_Luong());
		//UPdate or remove product
		if(qty > 0) {
			if(donhangcheck != null) {
				donhang.setSo_Luong(qty);
			}
		} else {
			orders.remove(id);
		}
	}

	@Override
	public void clear() {
		for (String id : orders.keySet()) {
			DONHANG donhang = orders.get(id);
			// Return quantity order into products list
			DataSharing.donhang.get(id).orderProduct(0 - donhang.getSo_Luong());
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
		for (DONHANG prod : orders.values()) {
			count += prod.getSo_Luong();
		}
		return count;
	}

	@Override
	public double getAmount() {
		double amount = 0;
		for (DONHANG prod : orders.values()) {
			amount += prod.getDon_gia() * prod.getSo_Luong();
		}
		return amount;
	}

}
