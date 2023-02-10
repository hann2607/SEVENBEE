package com.sevenbee.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.dao.CHITIET_SANPHAMDAO;
import com.sevenbee.dao.NGUOIDUNGDAO;
import com.sevenbee.dao.SANPHAMDAO;
import com.sevenbee.entities.SANPHAM;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;

@Controller
public class homeController {
	@Autowired 
	NGUOIDUNGDAO nguoidungdao;
	@Autowired 
	CHITIET_SANPHAMDAO ctspdao;
	@Autowired 
	SANPHAMDAO sanphamdao;
	
	@SuppressWarnings("unused")
	@RequestMapping("/")
	public String home(Model model) throws ServletException, IOException {
		Optional<SANPHAM> ctsp = sanphamdao.findById("SP005");
		System.out.println(ctsp.get().getCt_sanpham().getCTSP_MoTa());
		
//		model.addAttribute("listLatestProducts", listLatestProducts);
		return PageInfo.goSite(model, PageType.HOMEPAGE);
	}
}
