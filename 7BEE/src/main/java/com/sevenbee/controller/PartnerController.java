package com.sevenbee.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sevenbee.service.RandomService;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;

@Controller
public class PartnerController {
	
	@Autowired
	RandomService randomService;
	
	@GetMapping("/partner")
	public String detai_Product(Model model) throws ServletException, IOException {
		System.out.println(randomService.randomString(5));
		return PageInfo.goSite(model, PageType.SITE_PARTNER);
	}
}
