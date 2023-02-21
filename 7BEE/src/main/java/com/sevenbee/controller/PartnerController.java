package com.sevenbee.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sevenbee.dao.LOAISPDAO;
import com.sevenbee.entity.LOAISP;
import com.sevenbee.entity.PRODUCT;
import com.sevenbee.service.CookieService;
import com.sevenbee.service.RandomService;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class PartnerController {

	@Autowired
	CookieService cookieService;

	@Autowired
	LOAISPDAO loaispDAO;

	@Autowired
	RandomService randomService;

	@GetMapping("/partner")
	public String detai_Product(Model model, @ModelAttribute("product") PRODUCT p)
			throws ServletException, IOException {
//		System.out.println(randomService.randomString(5));
//		if (cookieService.getValue("username") == null) {
//			return "forward:/login";
//		}
		List<LOAISP> lstLoaiSP = loaispDAO.findAll();
		model.addAttribute("lstLoaiSP", lstLoaiSP);
		return PageInfo.goSite(model, PageType.SITE_PARTNER);
	}

	@RequestMapping("/partner/addproduct")
	public String add_Product(Model model, @ModelAttribute("product") PRODUCT p, BindingResult result,
			HttpServletRequest request, @RequestParam("filesIMG") MultipartFile[] files)
			throws ServletException, IOException {
		if (result.hasErrors()) {
			// validate form
			return PageInfo.goSite(model, PageType.SITE_PARTNER);
		} else {
//			String CTSP_Table = "";
//			if (!p.getCTSP_MoTa().isEmpty() && !request.getParameter("content1").isEmpty()) {
//				CTSP_Table += p.getCTSP_MoTa() + "-*-" + request.getParameter("content1") + "-*-";
//			}
//			if (request.getParameter("content2") != null && !request.getParameter("content2").isEmpty()) {
//				CTSP_Table += request.getParameter("title2") + "-*-" + request.getParameter("content2") + "-*-";
//			}
//			if (request.getParameter("content3") != null && !request.getParameter("content3").isEmpty()) {
//				CTSP_Table += request.getParameter("title3") + "-*-" + request.getParameter("content3") + "-*-";
//			}
//			if (request.getParameter("content4") != null && !request.getParameter("content4").isEmpty()) {
//				CTSP_Table += request.getParameter("title4") + "-*-" + request.getParameter("content4") + "-*-";
//			}
			System.out.println(files.length);
			if (files.length > 10) {
				// handle error
			} else {
				try {
					String uploadDirectory = "src/main/webapp/views/images/product/large-size/";
					for (MultipartFile file : files) {
						Path filePath = Paths.get(uploadDirectory, file.getOriginalFilename());
						Files.write(filePath, file.getBytes());
					}
				} catch (IOException e) {
				}
			}
		}
		return PageInfo.goSite(model, PageType.SITE_PARTNER);
	}
//	@ModelAttribute("lstLoaiSP")
//	public List<LOAISP> getlstLoaiSP() {
//		List<LOAISP> lstLoaiSP = loaispDAO.findAll();
//		return lstLoaiSP;
//	}
}
