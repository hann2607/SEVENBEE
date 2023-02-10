package com.sevenbee.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.dao.SANPHAMDAO;
import com.sevenbee.entities.SANPHAM;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;

@Controller
public class detai_ProductController {
	@Autowired
	SANPHAMDAO dao;
	
	
	@RequestMapping("/product-detail/{id}")
	public String detai_Product(@PathVariable("id") String id,Model model) throws ServletException, IOException {
		//Hiển thị chi tiết sản phẩm theo mã sản phẩm
		SANPHAM sanpham = dao.findById(id).get();
		System.out.println(sanpham.getCt_sanpham().getCTSP_MoTa());
		model.addAttribute("sanpham", sanpham);
		model.addAttribute("mota", sanpham.getCt_sanpham().getCTSP_MoTa());
		return PageInfo.goSite(model, PageType.SITE_PRODUCT);
	}
}
