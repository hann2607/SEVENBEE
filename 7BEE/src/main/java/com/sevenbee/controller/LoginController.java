package com.sevenbee.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sevenbee.dao.NGUOIDUNGDAO;
import com.sevenbee.entities.NGUOIDUNG;
import com.sevenbee.service.CookieService;
import com.sevenbee.service.ParamService;
import com.sevenbee.service.SessionService;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;
import com.sevenbee.validation.AccountValidate;

import jakarta.servlet.ServletException;

@Controller
public class LoginController {
	AccountValidate accountValidate=new AccountValidate();
	@Autowired
	CookieService cookieService;

	@Autowired
	ParamService paramService;

	@Autowired
	SessionService sessionService;
	
	@Autowired
	NGUOIDUNGDAO nguoidungDAO;

	@GetMapping("/showLogin")
	public String getLogin() {
		return "login";
	}

	@PostMapping("/login")
	public String login(Model model,@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("rememberMe") Boolean rememberMe) throws ServletException, IOException {

		// Check user on Database
		List<String> listCheck=new ArrayList<>();
		listCheck.add(username);
		listCheck.add(password);
		if (!accountValidate.listIsNullOrEmpty(listCheck)) {
			Optional<NGUOIDUNG> user = nguoidungDAO.findById(username);
				if (username.equalsIgnoreCase(user.get().getSDT()) && password.equals(user.get().getMatkhau())) {
					System.out.println(user.get().getHo_ten().toString());
					sessionService.set("username", user.get().getHo_ten());
					// save username and password into cookie
					if (rememberMe) {
						cookieService.add("username", username, 24);
						cookieService.add("password", password, 24);
					} else {
						cookieService.remove("username");
						cookieService.remove("password");
					}
					return PageInfo.goSite(model, PageType.HOMEPAGE);
				}
				else {
					System.out.println("fail login");
				}
			
		}
		return "error";
	}

	@GetMapping("/logout")
	public String getLogout() {
		sessionService.remove("username");
		return "redirect:/login";
	}
}
