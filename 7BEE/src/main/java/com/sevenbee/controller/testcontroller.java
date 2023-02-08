package com.sevenbee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.dao.NGUOIDUNGDAO;
import com.sevenbee.entities.NGUOIDUNG;

@Controller
public class testcontroller {
	@Autowired 
	NGUOIDUNGDAO nguoidungdao;
	
	@RequestMapping("/")
	public String home() {
		List<NGUOIDUNG> listnd = nguoidungdao.findAll();
		System.out.println(listnd.toString());
		return "index";
	}
}
