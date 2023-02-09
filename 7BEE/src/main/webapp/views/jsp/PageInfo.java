package com.Utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;






public class PageInfo {
	public static Map<PageType, PageInfo> pageRoute = new HashMap<>();

	static {
		// user
		pageRoute.put(PageType.SITE_STORE, new PageInfo("TRANG CHỦ", "khachhang/store.jsp", null));
		pageRoute.put(PageType.SITE_PRODUCT, new PageInfo("SẢN PHẨM", "khachhang/product.jsp", null));
		pageRoute.put(PageType.SITE_FAVORITES, new PageInfo("YÊU THÍCH", "khachhang/favorites.jsp", null));
		pageRoute.put(PageType.SITE_CHECKOUT, new PageInfo("THANH TOÁN", "khachhang/checkout.jsp", null));
		pageRoute.put(PageType.SITE_LOGIN, new PageInfo("ĐĂNG NHẬP & ĐĂNG KÝ", "signin-signup.jsp", null));
		
		// Admin
		pageRoute.put(PageType.ADMIN_CHART, new PageInfo("THỐNG KÊ", "admin/chart.jsp", null));
		pageRoute.put(PageType.ADMIN_CUSTOMER, new PageInfo("KHÁCH HÀNG", "admin/customer.jsp", null));
		pageRoute.put(PageType.ADMIN_WAREHOUSE, new PageInfo("KHO", "admin/warehouse.jsp", null));
	}

	public static void prepareAndForward(HttpServletRequest req, HttpServletResponse resp, PageType pageTyge)
			throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageTyge);

		req.setAttribute("page", page);
		
		req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
	}
	
	public static void prepareAndForwardSite(HttpServletRequest req, HttpServletResponse resp, PageType pageTyge)
			throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageTyge);

		req.setAttribute("page", page);
		
		req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
	}

	private String title;
	private String contentUrl;
	private String scripUrl;
	
	
	public PageInfo(String title, String contentUrl, String scripUrl) {
		super();
		this.title = title;
		this.contentUrl = contentUrl;
		this.scripUrl = scripUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	public String getScripUrl() {
		return scripUrl;
	}
	public void setScripUrl(String scripUrl) {
		this.scripUrl = scripUrl;
	}

	

}
