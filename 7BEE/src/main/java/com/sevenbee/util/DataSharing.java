package com.sevenbee.util;

import java.util.HashMap;


import com.sevenbee.entities.DONHANG;

public class DataSharing {
	public static HashMap<String, DONHANG > donhang = new HashMap<>();

	public void addData(String Ma_Sp, DONHANG value) {
		
	}

	public DONHANG getData(String DH_MA) {
		return donhang.get(DH_MA);
	}

	public HashMap<String, DONHANG> getAllData() {
		return donhang;
	}
}
