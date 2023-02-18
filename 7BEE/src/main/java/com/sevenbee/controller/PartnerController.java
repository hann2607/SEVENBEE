package com.sevenbee.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;

@Controller
public class PartnerController {

	@GetMapping("/partner")
	public String detai_Product(Model model) throws ServletException, IOException {

		return PageInfo.goSite(model, PageType.SITE_PARTNER);
	}
}
