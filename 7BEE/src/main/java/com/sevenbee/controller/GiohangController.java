package com.sevenbee.controller;




import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.dao.SANPHAMDAO;
import com.sevenbee.entities.SANPHAM;
import com.sevenbee.service.ParamService;
import com.sevenbee.service.SessionService;
import com.sevenbee.service.ShoppingCartService;
import com.sevenbee.service.impl.ShopingCartServiceImpl;
import com.sevenbee.util.DataSharing;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;





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
	public String LoadShopcart(Model model) throws ServletException, IOException{
		model.addAttribute("ShopCart", DataSharing.cart.clone());
		model.addAttribute("cart", cartShop.getProducts());
		model.addAttribute("amount", cartShop.getAmount());
		return PageInfo.goSite(model, PageType.SITE_SHOPPINGCART);
	}
	
	@GetMapping("/addCart/{id}")
	public String addToCart(@PathVariable String id, Model model) {
		List<SANPHAM> listSP =  sanphamdao.findAll();
		for (SANPHAM sanpham : listSP) {
			DataSharing.cart.put(sanpham.getSP_MA(), sanpham);
		}
		
		cartShop.addProduct(id);
		session.set("ShopCartmini", cartShop.getCount());
		model.addAttribute("messages", "Add success!");
		return "redirect:/ShoppingCart";
	}
	
	@GetMapping("/updateCart/{id}")
	public String updateCart(@PathVariable String id, Model model) {
		cartShop.updateProduct(id, param.getInt("quantity", 0));
		session.set("ShopCartmini", cartShop.getCount());
		model.addAttribute("messages", "Update success!");
		return "redirect:/ShoppingCart";
	}
	
	@GetMapping("/removeCart/{id}")
	public String removeCart(@PathVariable String id, Model model) {
		cartShop.removeProduct(id);
		model.addAttribute("messages", "remove success!");
		return "redirect:/ShoppingCart";
	}
	
	@GetMapping("/clear")
	public String clearCart(Model model) {
		cartShop.clear();
		model.addAttribute("messages", "Clear success!");
		return "redirect:/ShoppingCart";
	}
}
