package com.sevenbee.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sevenbee.entity.SANPHAM;
import com.sevenbee.service.RandomService;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;
import jakarta.validation.Valid;

@Controller
public class PartnerController {
	
	@Autowired
	RandomService randomService;
	
	@GetMapping("/partner")
	public String detai_Product(Model model) throws ServletException, IOException {
		System.out.println(randomService.randomString(5));
		return PageInfo.goSite(model, PageType.SITE_PARTNER);
	}
	
	@PostMapping("/partner/addproduct")
	public String add_Product(Model model, @Valid @ModelAttribute("product") SANPHAM sp, BindingResult rs) throws ServletException, IOException {
		if (rs.hasErrors()) {
			// validate form
			return PageInfo.goSite(model, PageType.SITE_PARTNER);
		} else {
			//Save product
		
		}
		return PageInfo.goSite(model, PageType.SITE_PARTNER);
	}
}
