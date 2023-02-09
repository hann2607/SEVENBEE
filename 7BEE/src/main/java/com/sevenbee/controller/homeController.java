package com.sevenbee.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.dao.NGUOIDUNGDAO;
import com.sevenbee.dao.SANPHAMDAO;
import com.sevenbee.entities.NGUOIDUNG;
import com.sevenbee.entities.SANPHAM;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;

@Controller
public class homeController {
	@Autowired 
	NGUOIDUNGDAO nguoidungdao;
	@Autowired 
	SANPHAMDAO sanphamdao;
	
	@RequestMapping("/")
	public String home(Model model) throws ServletException, IOException {
		List<SANPHAM> listLatestProducts = sanphamdao.findByLatestProducts();
		System.out.println(listLatestProducts.toString());
		model.addAttribute("listLatestProducts", listLatestProducts);
		return PageInfo.goSite(model, PageType.HOMEPAGE);
	}
}
