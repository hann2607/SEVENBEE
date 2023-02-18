package com.sevenbee.controller;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.dao.SANPHAMDAO;
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

		/*
		 * tất cả các model đều lấy giá trị từ session
		 * 
		 * 
		 * 
		 */
		return PageInfo.goSite(model, PageType.SITE_SHOPPINGCART);
	}

	@GetMapping("/addCart/{id}")
	public String addToCart(@PathVariable String id, Model model) {
//		List<SANPHAM> listSP =  sanphamdao.findAll();
//		for (SANPHAM sanpham : listSP) {
//			DataSharing.cart.put(sanpham.getSP_MA(), sanpham);
//		}

//		cartShop.addProduct(id);
//		System.out.println(id);
		String masp = id;
		SANPHAM sanpham = sanphamdao.findById(masp).get();
		DataSharing.cart.put(sanpham.getSP_MA(), sanpham);
		if (sanpham.getSP_SoLuong() < DataSharing.cart.get(sanpham.getSP_MA()).getSP_SoLuong()) {
			System.out.println("san pham ko them dc");
		} else {
			if(DataSharing.cart.get(sanpham.getSP_MA())== null) {
				DataSharing.cart.get(masp).setSP_SoLuong(DataSharing.cart.get(masp).getSP_SoLuong()+ 1);	
			}else {
				sanpham.setSP_SoLuong(1);
				DataSharing.cart.put(sanpham.getSP_MA(), sanpham);
			}

			
		}
//		cartShop.addProduct(masp);
		sess.setAttribute("listcarts", DataSharing.cart.clone());

//		System.out.println("session da dc them vao");
		HashMap<String, SANPHAM> abc = new HashMap<>();
		abc = (HashMap<String, SANPHAM>) sess.getAttribute("listcarts");
		System.out.println(abc.get(masp).getSP_TenSP());
//		SANPHAM sanpham1 = (SANPHAM) sess.getAttribute("listcarts");
//		session.set("ShopCartmini", cartShop.getCount());
		model.addAttribute("messages", "Add success!");
		return "redirect:/ShoppingCart";
	}

	@GetMapping("/updateCart/{id}")
	public String updateCart(@PathVariable String id, Model model) {
		cartShop.updateProduct(id, param.getInt("quantity", 0));
		sess.setAttribute("listcarts", DataSharing.cart.clone());
		model.addAttribute("messages", "Update success!");
		return "redirect:/ShoppingCart";
	}

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
