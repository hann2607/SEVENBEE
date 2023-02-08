package com.sevenbee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.dao.CHITIET_SANPHAMDAO;
import com.sevenbee.dao.NGUOIDUNGDAO;
import com.sevenbee.entities.CHITIET_SANPHAM;
import com.sevenbee.entities.NGUOIDUNG;

@Controller
public class testcontroller {
	@Autowired 
	CHITIET_SANPHAMDAO ctspdao;
	
	@RequestMapping("/")
	public String home() {
		List<CHITIET_SANPHAM> listnd = ctspdao.findAll();
		System.out.println(listnd.toString());
		return "index";
	}
}
