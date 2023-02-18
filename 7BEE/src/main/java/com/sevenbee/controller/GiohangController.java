package com.sevenbee.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.dao.SANPHAMDAO;
import com.sevenbee.entity.SANPHAM;
import com.sevenbee.service.ParamService;
import com.sevenbee.service.SessionService;
import com.sevenbee.service.ShoppingCartService;
import com.sevenbee.util.DataSharing;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;

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

	@Autowired
	HttpSession sess;

	@RequestMapping("/ShoppingCart")
	public String LoadShopcart(Model model) throws ServletException, IOException {
		model.addAttribute("ShopCart", DataSharing.cart.clone());
		model.addAttribute("cart", cartShop.getProducts());
		model.addAttribute("amount", cartShop.getAmount());
		model.addAttribute("sumtotal", total());
		model.addAttribute("listcarts", DataSharing.cart);
		int totalProductInCart = 0;
		for(Map.Entry<String, SANPHAM> entry : DataSharing.cart.entrySet()) {
		    totalProductInCart += entry.getValue().getSP_SoLuong();
		}
		model.addAttribute("totalProductInCart", totalProductInCart);
		return PageInfo.goSite(model, PageType.SITE_SHOPPINGCART);
	}

	@GetMapping("/addCart/{id}")
	public String addToCart(@PathVariable String id, Model model) {
		String masp = id;
		SANPHAM sanpham = sanphamdao.findById(masp).get();
		if (DataSharing.cart.get(masp) != null) {
			if (sanpham.getSP_SoLuong() > DataSharing.cart.get(masp).getSP_SoLuong()) {
				DataSharing.cart.get(masp).setSP_SoLuong(DataSharing.cart.get(masp).getSP_SoLuong() + 1);			
			}	
		} else {
			if (sanpham.getSP_SoLuong() >= 1) {
				sanpham.setSP_SoLuong(1);
				DataSharing.cart.put(sanpham.getSP_MA(), sanpham);			
			}
		}

	
		sess.setAttribute("listcarts", DataSharing.cart.clone());
		model.addAttribute("listcarts", DataSharing.cart);
		model.addAttribute("totalProductInCart", DataSharing.cart.size());
		model.addAttribute("messages", "Add success!");
		return "redirect:/";
	}
	
	private double total() {
		double sum = 0;
		for (SANPHAM sanpham : DataSharing.cart.values()) {
			sum += sanpham.getSP_Gia() * sanpham.getSP_SoLuong();
		}
		return sum;
	}
	
	
//	@GetMapping("/updateCart/{id}")
//	public String updateCart(@PathVariable String id, Model model) {
//		cartShop.updateProduct(id, param.getInt("quantity", 0));
//		sess.setAttribute("listcarts", DataSharing.cart.clone());
//		model.addAttribute("messages", "Update success!");
//		return "redirect:/ShoppingCart";
//	}

	@GetMapping("/removeCart/{id}")
	public String removeCart(@PathVariable String id, Model model) {
		DataSharing.cart.remove(id);
		sess.setAttribute("listcarts", DataSharing.cart.clone());
		model.addAttribute("messages", "remove success!");
		return "redirect:/ShoppingCart";
	}

	@GetMapping("/clear")
	public String clearCart(Model model) {
		DataSharing.cart.clear();
		model.addAttribute("messages", "Clear success!");
		return "redirect:/ShoppingCart";
	}
}
