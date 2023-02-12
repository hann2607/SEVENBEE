package com.sevenbee.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.dao.NGUOIDUNGDAO;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;

@Controller
@RequestMapping("/dangky")
public class NguoiDungController {

	@Autowired
	NGUOIDUNGDAO nguoidungdao;

	@GetMapping("add")
	public String add(Model model) throws ServletException, IOException {

		return PageInfo.goSite(model, PageType.HOMEPAGE);
	}
}
