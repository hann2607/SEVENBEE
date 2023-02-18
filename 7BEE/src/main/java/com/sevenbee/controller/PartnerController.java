package com.sevenbee.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sevenbee.dao.SANPHAMDAO;
import com.sevenbee.entity.SANPHAM;
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
