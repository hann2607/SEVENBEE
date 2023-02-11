package com.sevenbee.controller;




import java.io.IOException;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.sevenbee.dao.DONHANGDAO;
import com.sevenbee.entities.DONHANG;
import com.sevenbee.service.ParamService;
import com.sevenbee.service.SessionService;
import com.sevenbee.service.ShoppingCartService;
import com.sevenbee.util.DataSharing;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;





@Controller
public class GiohangController {
	
	@Autowired 
	DONHANGDAO donhangdao;
	
	@Autowired 
	ShoppingCartService cartShop;
	
	@Autowired 
	DONHANG donhang;
	
	@Autowired 
	ParamService param;
	
	@Autowired
	SessionService session;
	
	@RequestMapping("/ShoppingCart")
	public String LoadShopcart(Model model) throws ServletException, IOException{
		model.addAttribute("products", DataSharing.donhang.values());
		model.addAttribute("cart", cartShop.getProducts());
		model.addAttribute("amount", cartShop.getAmount());
		return PageInfo.goSite(model, PageType.SITE_SHOPPINGCART);
	}
	
	@GetMapping("/addCart")
	public String addToCart(@PathVariable Integer id, Model model) {
		cartShop.addProduct(id);
		session.set("cartQuantity", cartShop.getCount());
		model.addAttribute("messages", "Add success!");
		return "redirect:/ShoppingCart";
	}
	
	@GetMapping("/updateCart")
	public String updateCart(@PathVariable Integer id, Model model) {
		cartShop.updateProduct(id, param.getInt("quantity", 0));
		session.set("cartQuantity", cartShop.getCount());
		model.addAttribute("messages", "Update success!");
		return "redirect:/ShoppingCart";
	}
	
	@GetMapping("/removeCart")
	public String removeCart(@PathVariable Integer id, Model model) {
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
