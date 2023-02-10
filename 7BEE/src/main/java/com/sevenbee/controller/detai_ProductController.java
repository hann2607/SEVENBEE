package com.sevenbee.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;

@Controller
public class detai_ProductController {
	@RequestMapping("/")
	public String detai_Product(Model model) throws ServletException, IOException {
//		Optional<SANPHAM> ctsp = sanphamdao.findById("SP005");
//		System.out.println(ctsp.get().getCt_sanpham().getCTSP_MoTa());
		
//		model.addAttribute("listLatestProducts", listLatestProducts);
		return PageInfo.goSite(model, PageType.HOMEPAGE);
	}
}
