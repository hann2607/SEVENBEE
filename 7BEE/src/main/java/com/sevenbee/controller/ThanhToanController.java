package com.sevenbee.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.dao.SANPHAMDAO;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;

@Controller
public class ThanhToanController {
	@Autowired
	SANPHAMDAO sanphamdao;

	@RequestMapping("/checkout")
	public String detai_Product(Model model) throws ServletException, IOException {

		return PageInfo.goSite(model, PageType.SITE_CHECKOUT);
	}
}
