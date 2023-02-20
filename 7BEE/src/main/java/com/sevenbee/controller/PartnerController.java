package com.sevenbee.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sevenbee.dao.LOAISPDAO;
import com.sevenbee.entity.LOAISP;
import com.sevenbee.entity.PRODUCT;
import com.sevenbee.service.RandomService;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;
import jakarta.validation.Valid;

@Controller
public class PartnerController {

	@Autowired
	LOAISPDAO loaispDAO;

	@Autowired
	RandomService randomService;

	@GetMapping("/partner")
	public String detai_Product(Model model, @ModelAttribute("product") PRODUCT p)
			throws ServletException, IOException {
//		System.out.println(randomService.randomString(5));
		List<LOAISP> lstLoaiSP = loaispDAO.findAll();
		model.addAttribute("lstLoaiSP",lstLoaiSP);
		return PageInfo.goSite(model, PageType.SITE_PARTNER);
	}

	

	@PostMapping("/partner/addproduct")
	public String add_Product(Model model, @Valid @ModelAttribute("product") PRODUCT p, BindingResult result)
			throws ServletException, IOException {
		if (result.hasErrors()) {
			// validate form
			return PageInfo.goSite(model, PageType.SITE_PARTNER);
		} else {
		}
		return PageInfo.goSite(model, PageType.SITE_PARTNER);
	}
//	@ModelAttribute("lstLoaiSP")
//	public List<LOAISP> getlstLoaiSP() {
//		List<LOAISP> lstLoaiSP = loaispDAO.findAll();
//		return lstLoaiSP;
//	}
}
