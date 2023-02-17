package com.sevenbee.util;

import java.util.HashMap;

import com.sevenbee.entities.SANPHAM;

public class DataSharing {
	public static HashMap<String, SANPHAM> cart = new HashMap<String, SANPHAM>();
	
	public void addData(String Ma_Sp, SANPHAM value) {
		cart.put(Ma_Sp, value);
	}

	public SANPHAM getData(String SP_MA) {
		return cart.get(SP_MA);
	}

	public HashMap<String, SANPHAM> getAllData() {
		return cart;
	}
	
	
}
