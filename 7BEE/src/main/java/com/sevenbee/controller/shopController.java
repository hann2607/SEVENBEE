package com.sevenbee.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sevenbee.dao.SANPHAMDAO;
import com.sevenbee.entities.SANPHAM;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;

@Controller
public class shopController {
	@Autowired
	SANPHAMDAO sanphamdao;
	@RequestMapping("/shop/{LoaiSP}")
	public String shop(@PathVariable("LoaiSP") String LoaiSP, @RequestParam("page") Optional<Integer> page, Model model) throws ServletException, IOException {
		Pageable pageable = PageRequest.of(page.orElse(0), 9);
		Page<SANPHAM> pages = sanphamdao.findProductsByLoaiSPAndPage(LoaiSP, pageable);
		model.addAttribute("Pagecurrent", pages.getNumber());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("loaiSP", LoaiSP);
		model.addAttribute("pages", pages);
		return PageInfo.goSite(model, PageType.SITE_SHOP);
	}
}
