package com.sevenbee.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sevenbee.entity.SANPHAM;
import com.sevenbee.util.DataSharing;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;

@Controller
public class PartnerController {

	@GetMapping("/partner")
	public String detai_Product(Model model) throws ServletException, IOException {
		model.addAttribute("sumtotal", total());
		model.addAttribute("listcarts", DataSharing.cart);
		model.addAttribute("totalProductInCart", DataSharing.cart.size());
		return PageInfo.goSite(model, PageType.SITE_PARTNER);
	}
	private double total() {
		double sum = 0;
		for (SANPHAM sanpham : DataSharing.cart.values()) {
			sum += sanpham.getSP_Gia() * sanpham.getSP_SoLuong();
		}
		return sum;
	}
}
