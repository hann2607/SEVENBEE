package com.sevenbee.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sevenbee.dao.SANPHAMDAO;
import com.sevenbee.entity.SANPHAM;
import com.sevenbee.service.ParamService;
import com.sevenbee.service.SessionService;
import com.sevenbee.service.ShoppingCartService;
import com.sevenbee.util.DataSharing;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class GiohangController {

	@Autowired
	ShoppingCartService cartShop;

	@Autowired
	ParamService param;

	@Autowired
	SessionService session;

	@Autowired
	SANPHAMDAO sanphamdao;

	@RequestMapping("/ShoppingCart")
	public String LoadShopcart(Model model) throws ServletException, IOException {
		model.addAttribute("sumtotal", total());
		int totalProductInCart = 0;
		for (Map.Entry<String, SANPHAM> entry : DataSharing.cart.entrySet()) {
			totalProductInCart += entry.getValue().getSP_SoLuong();
		}
		model.addAttribute("totalProductInCart", totalProductInCart);
		return PageInfo.goSite(model, PageType.SITE_SHOPPINGCART);
	}

	@RequestMapping("/addCart")
	public String addToCart(@RequestParam("masp") String masp, @RequestParam("quantity") int quantity, Model model,
			HttpServletRequest request) {
		SANPHAM sanpham = sanphamdao.findById(masp).get();
		if (DataSharing.cart.get(masp) != null) {
			if (sanpham.getSP_SoLuong() >= (DataSharing.cart.get(masp).getSP_SoLuong() + quantity)) {
				DataSharing.cart.get(masp).setSP_SoLuong(DataSharing.cart.get(masp).getSP_SoLuong() + quantity);
			}
		} else {
			if (sanpham.getSP_SoLuong() >= quantity) {
				sanpham.setSP_SoLuong(quantity);
				DataSharing.cart.put(sanpham.getSP_MA(), sanpham);
			}
		}

		session.set("Carts", DataSharing.cart.clone());
		model.addAttribute("totalProductInCart", DataSharing.cart.size());

		// Update lại minicart
		updateMiniCart();

		// Get URL Previous
		String Referer = request.getHeader("Referer");
		return "redirect:/" + Referer.substring(Referer.indexOf("/") + 1, Referer.length());
	}

	@RequestMapping("/updateCart/{id}/{quantity}")
	@ResponseBody
	public String updateCart(@PathVariable("id") String id, @PathVariable("quantity") int quantity, Model model) {
		SANPHAM sanpham = sanphamdao.findById(id).get();
		if (DataSharing.cart.get(id) != null && sanpham != null) {
			if (sanpham.getSP_SoLuong() >= quantity) {
				DataSharing.cart.get(id).setSP_SoLuong(quantity);
			}
		}
		session.set("Carts", DataSharing.cart.clone());
		model.addAttribute("totalProductInCart", DataSharing.cart.size());

		// Update lại minicart
		updateMiniCart();
		
		return "";
	}

	@RequestMapping("/removeCart/{id}")
	public String removeCart(@PathVariable String id, Model model, HttpServletRequest request) {
		DataSharing.cart.remove(id);
		session.set("Carts", DataSharing.cart.clone());

		// Update lại minicart
		updateMiniCart();

		// Get URL Previous
		String Referer = request.getHeader("Referer");
		return "redirect:/" + Referer.substring(Referer.indexOf("/") + 1, Referer.length());
	}

	@GetMapping("/clearCart")
	public String clearCart(Model model) {
		DataSharing.cart.clear();
		session.set("Carts", DataSharing.cart.clone());
		// Update lại minicart
		updateMiniCart();
		return "redirect:/ShoppingCart";
	}

	private double total() {
		double sum = 0;
		for (SANPHAM sanpham : DataSharing.cart.values()) {
			sum += sanpham.getSP_Gia() * sanpham.getSP_SoLuong();
		}
		return sum;
	}

	private void updateMiniCart() {
		// tổng tiền trong giỏ hàng nhỏ
		session.set("sumtotal", total());
		int totalProductInCart = 0;
		for (Map.Entry<String, SANPHAM> entry : DataSharing.cart.entrySet()) {
			totalProductInCart += entry.getValue().getSP_SoLuong();
		}
		session.set("totalProductInCart", totalProductInCart);
	}
}
