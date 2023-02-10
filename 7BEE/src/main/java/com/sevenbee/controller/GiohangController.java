package com.sevenbee.controller;




import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.dao.DONHANGDAO;
import com.sevenbee.service.ParamService;
import com.sevenbee.service.SessionService;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;





@Controller
public class GiohangController {
	
	@Autowired 
	DONHANGDAO donhang;
	
	@Autowired 
	ParamService param;
	
	@Autowired
	SessionService session;
	
	@RequestMapping("/Giohang")
	public String LoadShopcart(Model model) throws ServletException, IOException{
		
		return PageInfo.goSite(model, PageType.SITE_SHOPPINGCART);
	}
}
