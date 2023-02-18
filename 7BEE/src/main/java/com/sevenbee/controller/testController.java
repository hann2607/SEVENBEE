package com.sevenbee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenbee.dao.SANPHAMDAO;
import com.sevenbee.entity.SANPHAM;

@RestController
public class testController {
	@Autowired
	SANPHAMDAO sanphamdao;

	@GetMapping("/api/Quick-view/{id}")
	public String find(@PathVariable("id") String id, Model model) throws JsonProcessingException {
		SANPHAM sanpham = sanphamdao.findProductBySP_MA(id);
//		System.out.println(sanpham.toString());
//		ObjectMapper Obj = new ObjectMapper();
//		Obj.writeValueAsString(sanpham);
//		 System.out.println(Obj);
		return "hello";
	}
}
