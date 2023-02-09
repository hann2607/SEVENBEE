package com.sevenbee.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.dao.NGUOIDUNGDAO;
import com.sevenbee.entities.NGUOIDUNG;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;

@Controller
public class homeController {
	@Autowired 
	NGUOIDUNGDAO nguoidungdao;
	
	@RequestMapping("/")
	public String home(Model model) throws ServletException, IOException {
//		List<NGUOIDUNG> listnd = nguoidungdao.findAll();
//		System.out.println(listnd.toString());
		System.out.println();
		model.addAttribute("abc", "cac");
		return PageInfo.goSite(model, PageType.HOMEPAGE);
	}
}
