package com.sevenbee.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sevenbee.dao.NGUOIDUNGDAO;
import com.sevenbee.entity.NGUOIDUNG;
import com.sevenbee.service.AccountService;
import com.sevenbee.service.CookieService;
import com.sevenbee.service.ParamService;
import com.sevenbee.service.SessionService;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;
import com.sevenbee.validation.AccountValidate;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	AccountValidate accountValidate = new AccountValidate();
	@Autowired
	CookieService cookieService;

	@Autowired
	ParamService paramService;

	@Autowired
	SessionService sessionService;

	@Autowired
	NGUOIDUNGDAO nguoidungDAO;

	@Autowired
	private AccountService accountService;
	@Autowired
	private HttpSession session;

	@GetMapping("/showLogin")
	public String getLogin() {
		return "login";
	}

	@PostMapping("/login")
	public String login(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password, BindingResult result) throws ServletException, IOException {

		if (result.hasErrors()) {
			// validate form
			return " trả về trang báo lỗi";
		}
		// thực hiện đăng nhập và trả về đối tượng user
		NGUOIDUNG user = accountService.login(password, password);

		if (user == null) {
			model.addAttribute("message", "Sai tài khoảng hoặc mật khẩu");
			return " trả về trang báo lỗi";
		}

		//////////////////////////// Hàm chưa xử lí remember/////////////////////////////////////////////////////////

		session.setAttribute("username", user.getHo_ten());
		return PageInfo.goSite(model, PageType.HOMEPAGE);
	}

	@PostMapping("/logout")
	public String getLogout() {
		sessionService.remove("username");
		return "redirect:/login";
	}
}
