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
import com.sevenbee.util.DataSharing;
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
		model.addAttribute("pages", pages);
		model.addAttribute("sumtotal", total());
		model.addAttribute("listcarts", DataSharing.cart);
		model.addAttribute("totalProductInCart", DataSharing.cart.size());
		return PageInfo.goSite(model, PageType.SITE_SHOP);
	}

	@RequestMapping("/shop/search")
	public String shopSearch(@RequestParam("page") Optional<Integer> page, @RequestParam("SearchValue") String search,
			@RequestParam("selectedSearch") String selectedSearch, Model model) throws ServletException, IOException {
		Pageable pageable = PageRequest.of(page.orElse(0), 9);
		Page<SANPHAM> pages = searchSP(pageable, search, selectedSearch);

		model.addAttribute("Pagecurrent", pages.getNumber());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("pages", pages);
		model.addAttribute("sumtotal", total());
		model.addAttribute("listcarts", DataSharing.cart);
		model.addAttribute("totalProductInCart", DataSharing.cart.size());
		return PageInfo.goSite(model, PageType.SITE_SHOP);
	}

	private double total() {
		double sum = 0;
		for (SANPHAM sanpham : DataSharing.cart.values()) {
			sum += sanpham.getSP_Gia() * sanpham.getSP_SoLuong();
		}
		return sum;
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

	private Page<SANPHAM> searchSP(Pageable pageable, String search, String searchSelected) {
		if(searchSelected.equalsIgnoreCase("all")) {
			return sanphamdao.findBySearch("%" + search + "%", pageable);
		} else if(searchSelected.equalsIgnoreCase("all")) {
			return sanphamdao.findBySearch("%" + search + "%", pageable);
		} else if(searchSelected.equalsIgnoreCase("DT")) {
			return sanphamdao.findBySearch("%" + search + "%", pageable);
		} else if(searchSelected.equalsIgnoreCase("TT")) {
			return sanphamdao.findBySearch("%" + search + "%", pageable);
		} else if(searchSelected.equalsIgnoreCase("DADU")) {
			return sanphamdao.findBySearch("%" + search + "%", pageable);
		} else if(searchSelected.equalsIgnoreCase("KH")) {
			return sanphamdao.findBySearch("%" + search + "%", pageable);
		} else if(searchSelected.equalsIgnoreCase("FPOLY")) {
			return sanphamdao.findBySearch("%" + search + "%", pageable);
		}
		return null;
	}
}
