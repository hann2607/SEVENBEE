package com.sevenbee.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.dao.SANPHAMDAO;
import com.sevenbee.entity.SANPHAM;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;

@Controller
public class ChiTiet_SanPhamController {
	@Autowired
	SANPHAMDAO sanphamdao;

	@RequestMapping("/product-detail/{id}")
	public String detai_Product(@PathVariable("id") String id, Model model) throws ServletException, IOException {
		// Hiển thị chi tiết sản phẩm theo mã sản phẩm
		SANPHAM sanpham = sanphamdao.findById(id).get();
		model.addAttribute("sanpham", sanpham);
		model.addAttribute("mota", sanpham.getCt_sanpham().getCTSP_MoTa());
		
		// Lấy ra danh sách sản phẩm cùng loại mới nhất
		List<SANPHAM> same_Products = sanphamdao.findProductsByLoaiSP(sanpham.getLoaisp().getLoaiSP_MA().toString(), 6);
		model.addAttribute("Same_Products", same_Products);

		return PageInfo.goSite(model, PageType.SITE_PRODUCT);
	}
}
