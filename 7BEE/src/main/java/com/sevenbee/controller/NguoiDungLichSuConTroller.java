package com.sevenbee.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.dao.DONHANGDAO;
import com.sevenbee.dao.NGUOIDUNGDAO;
import com.sevenbee.entity.DONHANG;
import com.sevenbee.entity.NGUOIDUNG;
import com.sevenbee.service.CookieService;
import com.sevenbee.service.MailService;
import com.sevenbee.service.ParamService;
import com.sevenbee.service.SessionService;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;

public class NguoiDungLichSuConTroller {
	@Autowired
	CookieService cookieService;

	@Autowired
	ParamService paramService;

	@Autowired
	SessionService sessionService;

	@Autowired
	NGUOIDUNGDAO nguoidungDAO;
	
	DONHANGDAO donhangDAO;


	
	@RequestMapping("/user/history/{id}")
	public String getUserLichSU(Model model) throws ServletException, IOException {
		Optional<DONHANG> donhanglichsu = donhangDAO.findById("id");
		
		 return "redirect:/";
		
		
	}

}
