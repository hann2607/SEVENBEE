package com.sevenbee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sevenbee.dao.SANPHAMDAO;
import com.sevenbee.entity.SANPHAM;
import com.sevenbee.util.JsonUtils;

@RestController
public class testController {
	@Autowired
	SANPHAMDAO sanphamdao;

	@GetMapping("/api/Quick-view/{id}")
	public String find(@PathVariable("id") String id, Model model) throws JsonProcessingException {
		SANPHAM sanpham = sanphamdao.findProductBySP_MA(id);
        
		//Cắt chuỗi JSON bao gồm LoaiSP và CTSP_ThongTinThem
		String CTSP = sanpham.getLoaisp().getLoaiSP_Ten() + "-*-" + sanpham.getCt_sanpham().getCTSP_ThongTinThem();
        sanpham.setCt_sanpham(null);
		sanpham.setShop(null);
		sanpham.setLoaisp(null);
		return JsonUtils.toString(sanpham) + "-*-" + CTSP;
	}
	
	@GetMapping("/quantity/{id}/{Soluong}")
	public String quantityCart(@PathVariable String Soluong, @PathVariable String id, Model model) {
		System.out.println(Soluong);
		System.out.println(id);
		return "redirect:/ShoppingCart";
	} 
	
}
