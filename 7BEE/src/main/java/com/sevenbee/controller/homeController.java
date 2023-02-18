package com.sevenbee.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sevenbee.dao.DONHANGDAO;
import com.sevenbee.dao.DONHANG_SANPHAMDAO;
import com.sevenbee.dao.LOAISPDAO;
import com.sevenbee.dao.NGUOIDUNGDAO;
import com.sevenbee.dao.PARTNERDAO;
import com.sevenbee.dao.SANPHAMDAO;
import com.sevenbee.entity.DONHANG_SANPHAM;
import com.sevenbee.entity.PARTNER;
import com.sevenbee.entity.SANPHAM;
import com.sevenbee.service.SessionService;
import com.sevenbee.util.DataSharing;
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

	@RequestMapping("/")
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

// tổng tiền trong giỏ hàng nhỏ
		model.addAttribute("sumtotal", total());

		int totalProductInCart = 0;
		for (Map.Entry<String, SANPHAM> entry : DataSharing.cart.entrySet()) {
			totalProductInCart += entry.getValue().getSP_SoLuong();
		}
		model.addAttribute("totalProductInCart", totalProductInCart);
		
		return PageInfo.goSite(model, PageType.HOMEPAGE);
	}

	private double total() {
		double sum = 0;
		for (SANPHAM sanpham : DataSharing.cart.values()) {
			sum += sanpham.getSP_Gia() * sanpham.getSP_SoLuong();
		}
		return sum;
	}

	private String spitArrImages(String arrImages) {
		String[] components = arrImages.split("-\\*-");
		if (components != null) {
			return components[0];
		}
		return null;
	}

	@RequestMapping(value = "home/Quick-view/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<SANPHAM> find(@PathVariable("id") String id) {
		System.out.println(id);
		try {
			return new ResponseEntity<SANPHAM>(sanphamdao.findProductBySP_MA(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<SANPHAM>(HttpStatus.BAD_REQUEST);
		}
	}
}
