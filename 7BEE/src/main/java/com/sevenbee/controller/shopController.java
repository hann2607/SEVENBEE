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
import com.sevenbee.entity.SANPHAM;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;

@Controller
public class shopController {
	@Autowired
	SANPHAMDAO sanphamdao;

	@RequestMapping("/shop/{LoaiSP}")
	public String shop(@PathVariable("LoaiSP") String LoaiSP, @RequestParam("page") Optional<Integer> page, Model model)
			throws ServletException, IOException {
		Pageable pageable = PageRequest.of(page.orElse(0), 9);
		Page<SANPHAM> pages = sanphamdao.findProductsByLoaiSPAndPage(LoaiSP, pageable);
		model.addAttribute("Pagecurrent", pages.getNumber());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("loaiSP", LoaiSP);
		model.addAttribute("pages", pages);
		return PageInfo.goSite(model, PageType.SITE_SHOP);
	}

	@RequestMapping("/shop/category/{LoaiSP}")
	public String category(@PathVariable("LoaiSP") String LoaiSP, @RequestParam("page") Optional<Integer> page,
			Model model) throws ServletException, IOException {
		Pageable pageable = PageRequest.of(page.orElse(0), 9);
		Page<SANPHAM> pages;
		if (checkMaLoai(LoaiSP, pageable) != null) {
			pages = checkMaLoai(LoaiSP, pageable);
		} else {
			pages = sanphamdao.findAll(pageable);
		}
		if (pages != null) {
			model.addAttribute("Pagecurrent", pages.getNumber());
			model.addAttribute("totalPages", pages.getTotalPages());
			model.addAttribute("loaiSP", LoaiSP);
			model.addAttribute("pages", pages);
		}
		return PageInfo.goSite(model, PageType.SITE_SHOP);
	}

	public Page<SANPHAM> checkMaLoai(String maLoai, Pageable pageable) {
		if (maLoai.equalsIgnoreCase("LT")) {
			return sanphamdao.findProductsBy1LoaiSPAndPage("%LAPTOP%", pageable);
		} else if (maLoai.equalsIgnoreCase("PC")) {
			return sanphamdao.findProductsBy1LoaiSPAndPage("%PC%", pageable);
		} else if (maLoai.equalsIgnoreCase("MH")) {
			return sanphamdao.findProductsBy1LoaiSPAndPage("%MÀN HÌNH%", pageable);
		} else if (maLoai.equalsIgnoreCase("DT")) {
			return sanphamdao.findProductsBy1LoaiSPAndPage("%ĐIỆN THOẠI%", pageable);
		} else if (maLoai.equalsIgnoreCase("TL")) {
			return sanphamdao.findProductsBy2LoaiSPAndPage("%TỦ LẠNH%", "%MÁY GIẶT%", pageable);
		} else if (maLoai.equalsIgnoreCase("QA")) {
			return sanphamdao.findProductsBy2LoaiSPAndPage("%QUẦN%", "%ÁO%", pageable);
		} else if (maLoai.equalsIgnoreCase("GD")) {
			return sanphamdao.findProductsBy2LoaiSPAndPage("%GIÀY%", "%DÉP%", pageable);
		} else if (maLoai.equalsIgnoreCase("T")) {
			return sanphamdao.findProductsBy1LoaiSPAndPage("%TÚI%", pageable);
		} else if (maLoai.equalsIgnoreCase("BL")) {
			return sanphamdao.findProductsBy1LoaiSPAndPage("%BALO%", pageable);
		} else if (maLoai.equalsIgnoreCase("MP")) {
			return sanphamdao.findProductsBy2LoaiSPAndPage("%SON%", "%KEM DƯỠNG DA%", pageable);
		} else if (maLoai.equalsIgnoreCase("Fpoly")) {
			return sanphamdao.findProductsBy1LoaiSPAndPage("%FPOLY%", pageable);
		}
		return null;
	}
}
