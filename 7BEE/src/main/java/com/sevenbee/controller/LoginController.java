package com.sevenbee.controller;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
import jakarta.validation.Valid;

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
	public String getLoginform(Model model, @ModelAttribute("nguoidung") NGUOIDUNG nguoidung)
			throws ServletException, IOException {
		return PageInfo.goSite(model, PageType.SITE_LOGIN);
	}

	@RequestMapping("/user/login")
	public String login(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password,@ModelAttribute("nguoidung") NGUOIDUNG nguoidung) throws ServletException, IOException {

		if (username.isEmpty() && password.isEmpty()) {
			// validate form
			model.addAttribute("message", "Vui lòng điều đủ thông tin tài khoản và mật khẩu");
			return PageInfo.goSite(model, PageType.SITE_LOGIN);
		} else {
			// thực hiện đăng nhập và trả về đối tượng user
			NGUOIDUNG user = accountService.login(username, password);

			if (user == null) {
				model.addAttribute("message", "Sai tài khoản hoặc mật khẩu");
				return PageInfo.goSite(model, PageType.SITE_LOGIN);
			}
			session.setAttribute("username", user.getHo_ten());
			return PageInfo.goSite(model, PageType.HOMEPAGE);
		}

		//////////////////////////// Hàm chưa xử lí remember///////////
	}

	@RequestMapping("/user/register")
	public String register(Model model, @Valid @ModelAttribute("nguoidung") NGUOIDUNG nguoidung, BindingResult result)
			throws ServletException, IOException {

		if (result.hasErrors()) {
			// validate form
			return PageInfo.goSite(model, PageType.SITE_LOGIN);
		} else {
			// Kiểm tra trùng ID
			Optional<NGUOIDUNG> user = nguoidungDAO.findById(nguoidung.getSDT());
			if (!user.isPresent()) {
				// Tạo tài khoản
				nguoidung.setVaitro(false);
				nguoidung.setIsactive(false);
				nguoidung.setNgaysinh(null);
				accountService.save(nguoidung);
				session.setAttribute("username", nguoidung.getHo_ten());
				return PageInfo.goSite(model, PageType.HOMEPAGE);
			} else {
				// Báo lỗi tài khoản đã tồn tại
				model.addAttribute("");
				System.out.println("fail register");
				return PageInfo.goSite(model, PageType.SITE_LOGIN);
			}

		}

		//////////////////////////// Hàm chưa xử lí remember///////////
	}

	@RequestMapping("/logout")
	public String getLogout(Model model) throws ServletException, IOException {
		sessionService.remove("username");
		return PageInfo.goSite(model, PageType.HOMEPAGE);
	}
}
