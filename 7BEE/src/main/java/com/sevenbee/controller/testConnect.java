package com.sevenbee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.dao.TINTUCDAO;
import com.sevenbee.entities.TINTUC;

@Controller
public class testConnect {

	@Autowired
	TINTUCDAO dao;

	@RequestMapping("/")
	public String home() {
		List<TINTUC> list = dao.findAll();
		System.out.println(list.toString());
		return "index";
	}
}
