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
		for (SANPHAM sanpham : pages) {
			sanpham.setSP_HinhAnh(spitArrImages(sanpham.getSP_HinhAnh()));
		}
		model.addAttribute("Pagecurrent", pages.getNumber());
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("pages", pages);
		return PageInfo.goSite(model, PageType.SITE_SHOP);
	}

	@RequestMapping("/shop/search")
	public String shopSearch(@RequestParam("page") Optional<Integer> page, @RequestParam("SearchValue") String search,
			@RequestParam("selectedSearch") String selectedSearch, Model model) throws ServletException, IOException {
		Pageable pageable = PageRequest.of(page.orElse(0), 9);
		Page<SANPHAM> pages = searchSP(pageable, search, selectedSearch);
		for (SANPHAM sanpham : pages) {
			sanpham.setSP_HinhAnh(spitArrImages(sanpham.getSP_HinhAnh()));
		}
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
			for (SANPHAM sanpham : pages) {
				sanpham.setSP_HinhAnh(spitArrImages(sanpham.getSP_HinhAnh()));
			}
			model.addAttribute("Pagecurrent", pages.getNumber());
			model.addAttribute("totalPages", pages.getTotalPages());
			model.addAttribute("loaiSP", LoaiSP);
			model.addAttribute("pages", pages);
		}
		return PageInfo.goSite(model, PageType.SITE_SHOP);
	}

	public Page<SANPHAM> checkMaLoai(String maLoai, Pageable pageable) {
		if (maLoai.equalsIgnoreCase("LT")) {
			return sanphamdao.findProducts("%LAPTOP%", "", "%%", "%%", pageable);
		} else if (maLoai.equalsIgnoreCase("PC")) {
			return sanphamdao.findProducts("%PC%", "", "%%", "%%", pageable);
		} else if (maLoai.equalsIgnoreCase("MH")) {
			return sanphamdao.findProducts("%MÀN HÌNH%", "", "%%", "%%", pageable);
		} else if (maLoai.equalsIgnoreCase("DT")) {
			return sanphamdao.findProducts("%ĐIỆN THOẠI%", "", "%%", "%%", pageable);
		} else if (maLoai.equalsIgnoreCase("TL")) {
			return sanphamdao.findProducts("%TỦ LẠNH%", "%MÁY GIẶT%", "%%", "%%", pageable);
		} else if (maLoai.equalsIgnoreCase("QA")) {
			return sanphamdao.findProducts("%QUẦN%", "%ÁO%", "%%", "%%", pageable);
		} else if (maLoai.equalsIgnoreCase("GD")) {
			return sanphamdao.findProducts("%GIÀY%", "%DÉP%", "%%", "%%", pageable);
		} else if (maLoai.equalsIgnoreCase("T")) {
			return sanphamdao.findProducts("%TÚI%", "", "%%", "%%", pageable);
		} else if (maLoai.equalsIgnoreCase("BL")) {
			return sanphamdao.findProducts("%BALO%", "", "%%", "%%", pageable);
		} else if (maLoai.equalsIgnoreCase("MP")) {
			return sanphamdao.findProducts("%SON%", "%KEM DƯỠNG DA%", "%%", "%%", pageable);
		} else if (maLoai.equalsIgnoreCase("Fpoly")) {
			return sanphamdao.findProducts("%FPOLY%", "", "%%", "%%", pageable);
		}
		return null;
	}

	private Page<SANPHAM> searchSP(Pageable pageable, String search, String searchSelected) {
		if(search == null || search.equals(" ")) {
			search = "";
		}
		if(searchSelected.equalsIgnoreCase("all")) {
			return sanphamdao.findProducts("%" + search + "%", "", "%%", "%%", pageable);
		} else if(searchSelected.equalsIgnoreCase("DT")) {
			return sanphamdao.findProducts("%" + search + "%", "", "%LSP003%", "", pageable);
		} else if(searchSelected.equalsIgnoreCase("TT")) {
			return sanphamdao.findProducts("%" + search + "%", "", "%LSP002%", "", pageable);
		} else if(searchSelected.equalsIgnoreCase("DADU")) {
			return sanphamdao.findProducts("%" + search + "%", "", "%LSP001%", "", pageable);
		} else if(searchSelected.equalsIgnoreCase("FPOLY")) {
			return sanphamdao.findProductsFpoly("%" + search + "%", "%FPOLY%", "%%", "%%", pageable);
		}
		return null;
	}
	
	private String spitArrImages(String arrImages) {
		String[] components = arrImages.split("-\\*-");
		if (components != null) {
			return components[0];
		}
		return null;
	}
}
