
package com.sevenbee.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;

import jakarta.servlet.ServletException;






public class PageInfo {
	public static Map<PageType, PageInfo> pageRoute = new HashMap<>();

	static {
		// user
		pageRoute.put(PageType.HOMEPAGE, new PageInfo("TRANG CHỦ", "index", "/views/jsp/home/home.jsp"));
		pageRoute.put(PageType.SITE_PRODUCT, new PageInfo("SẢN PHẨM", "khachhang/product.jsp", null));
		pageRoute.put(PageType.SITE_FAVORITES, new PageInfo("YÊU THÍCH", "khachhang/favorites.jsp", null));
		pageRoute.put(PageType.SITE_CHECKOUT, new PageInfo("THANH TOÁN", "khachhang/checkout.jsp", null));
		pageRoute.put(PageType.SITE_LOGIN, new PageInfo("ĐĂNG NHẬP & ĐĂNG KÝ", "signin-signup.jsp", null));
		pageRoute.put(PageType.SITE_SHOPPINGCART, new PageInfo("GIỎ HÀNG","Giohang","/views/jsp/Giohang/Giohang.jsp"));
		pageRoute.put(PageType.SITE_HISTORY, new PageInfo("LỊCH SỬ", "Lichsu.jsp", null));
		
		// Admin
		pageRoute.put(PageType.ADMIN_CHART, new PageInfo("THỐNG KÊ", "admin/chart.jsp", null));
		pageRoute.put(PageType.ADMIN_CUSTOMER, new PageInfo("KHÁCH HÀNG", "admin/customer.jsp", null));
		pageRoute.put(PageType.ADMIN_WAREHOUSE, new PageInfo("KHO", "admin/warehouse.jsp", null));
	}

	public static String goAdmin(Model model, PageType pageTyge)
			throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageTyge);

		model.addAttribute("page", page);
		
		return page.JSPName;
	}
	
	public static String goSite(Model model, PageType pageTyge)
			throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageTyge);

		model.addAttribute("page", page);
		
		return page.JSPName;
	}

	
	private String title;
	private String JSPName;
	private String linkFile;
	
	
	public PageInfo(String title, String JSPName, String linkFile) {
		super();
		this.title = title;
		this.JSPName = JSPName;
		this.linkFile = linkFile;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getJSPName() {
		return JSPName;
	}
	public void setJSPName(String JSPName) {
		this.JSPName = JSPName;
	}
	public String getlinkFile() {
		return linkFile;
	}
	public void setlinkFile(String linkFile) {
		this.linkFile = linkFile;
	}
}
