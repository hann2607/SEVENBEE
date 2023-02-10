package com.sevenbee.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.dao.DONHANGDAO;
import com.sevenbee.dao.DONHANG_SANPHAMDAO;
import com.sevenbee.dao.NGUOIDUNGDAO;
import com.sevenbee.dao.SANPHAMDAO;
import com.sevenbee.entities.DONHANG_SANPHAM;
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
	@Autowired 
	DONHANGDAO donhangdao;
	@Autowired 
	DONHANG_SANPHAMDAO donhang_SANPHAMDAO;
	
	@RequestMapping("/")
	public String home(Model model) throws ServletException, IOException {
		List<SANPHAM> listLatestProducts = sanphamdao.findByLatestProducts();
		List<DONHANG_SANPHAM> donhang = donhang_SANPHAMDAO.findAll();
//		List<SANPHAM> findByBestSellerProducts(); 
		System.out.println(donhang.toString());
		model.addAttribute("listLatestProducts", listLatestProducts);
		return PageInfo.goSite(model, PageType.HOMEPAGE);
	}
}
