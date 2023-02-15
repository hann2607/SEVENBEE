package com.sevenbee.util;

import java.util.HashMap;

import com.sevenbee.entities.SANPHAM;

public class DataSharing {
	public static HashMap<Integer, SANPHAM> cart = new HashMap<Integer, SANPHAM>();


	public void addData(Integer Ma_Sp, SANPHAM value) {
		cart.put(Ma_Sp, value);
	}

	public SANPHAM getData(Integer SP_MA) {
		return cart.get(SP_MA);
	}

	public HashMap<Integer, SANPHAM> getAllData() {
		return cart;
	}
	
	
}
