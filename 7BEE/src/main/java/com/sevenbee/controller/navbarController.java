package com.sevenbee.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.entity.GOP_Y;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;

@Controller
public class navbarController {
	@RequestMapping("/About-us")
	public String aboutUs(Model model) throws ServletException, IOException {
		return PageInfo.goSite(model, PageType.SITE_ABOUTUS);
	}

	
}
