package com.sevenbee.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.dao.DONHANGDAO;
import com.sevenbee.dao.DONHANG_SANPHAMDAO;
import com.sevenbee.dao.LOAISPDAO;
import com.sevenbee.dao.NGUOIDUNGDAO;
import com.sevenbee.dao.PARTNERDAO;
import com.sevenbee.dao.SANPHAMDAO;
import com.sevenbee.entities.DONHANG_SANPHAM;
import com.sevenbee.entities.PARTNER;
import com.sevenbee.entities.SANPHAM;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;

@Controller
public class homeController {
	@Autowired
	NGUOIDUNGDAO nguoidungdao;
	@Autowired
	SANPHAMDAO sanphamdao;
	@Autowired
	DONHANGDAO donhangdao;
	@Autowired
	DONHANG_SANPHAMDAO donhang_SANPHAMDAO;
	@Autowired
	PARTNERDAO partnerdao;
	@Autowired
	LOAISPDAO loaispdao;

	@RequestMapping("/home")
	public String home(Model model) throws ServletException, IOException {		
		// Lấy ra danh sách sản phẩm mới nhất
		List<SANPHAM> LatestProducts = sanphamdao.findByLatestProducts(6);
		for (SANPHAM sanpham : LatestProducts) {
			sanpham.setSP_HinhAnh(spitArrImages(sanpham.getSP_HinhAnh()));
		}
		model.addAttribute("LatestProducts", LatestProducts);

		// Lấy ra danh sách sản phẩm bán chạy nhất
		List<DONHANG_SANPHAM> BestSellerProducts = donhang_SANPHAMDAO.findByBestSellerProducts();
		for (DONHANG_SANPHAM sanpham : BestSellerProducts) {
			sanpham.getSanpham().setSP_HinhAnh(spitArrImages(sanpham.getSanpham().getSP_HinhAnh()));
		}
		model.addAttribute("BestSellerProducts", BestSellerProducts);

		// Lấy ra danh sách sản phẩm loại điện tử mới nhất
		List<SANPHAM> Products_DienTu = sanphamdao.findProductsByLoaiSP("LSP003", 6);
		for (SANPHAM sanpham : Products_DienTu) {
			sanpham.setSP_HinhAnh(spitArrImages(sanpham.getSP_HinhAnh()));
		}
		model.addAttribute("Products_DienTu", Products_DienTu);

		// Lấy ra danh sách sản phẩm loại thời trang mới nhất
		List<SANPHAM> Products_ThoiTrang = sanphamdao.findProductsByLoaiSP("LSP002", 6);
		for (SANPHAM sanpham : Products_ThoiTrang) {
			sanpham.setSP_HinhAnh(spitArrImages(sanpham.getSP_HinhAnh()));
		}
		model.addAttribute("Products_ThoiTrang", Products_ThoiTrang);

		// Lấy ra danh sách sản phẩm theo shop ngẫu nhiên
		List<PARTNER> Products_ShopRandom = partnerdao.findProductsByShopRandom(3);
		for (PARTNER shop : Products_ShopRandom) {
			for (SANPHAM sanpham : shop.getSanpham()) {
				sanpham.setSP_HinhAnh(spitArrImages(sanpham.getSP_HinhAnh()));
			}
		}
		model.addAttribute("Products_ShopRandom", Products_ShopRandom);
		

		return PageInfo.goSite(model, PageType.HOMEPAGE);
	}
	
	private String spitArrImages(String arrImages) {
		String[] components = arrImages.split("-\\*-");
		if(components != null) {
			return components[0];
		}
		return null;
	}
}
