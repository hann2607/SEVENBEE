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
import com.sevenbee.entity.MailInfo;
import com.sevenbee.entity.NGUOIDUNG;
import com.sevenbee.mailCONSTANT.mail_CONSTANT;
import com.sevenbee.service.AccountService;
import com.sevenbee.service.CookieService;
import com.sevenbee.service.MailService;
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
	mail_CONSTANT mailBody = new mail_CONSTANT();
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
	MailService mailService;

	@Autowired
	private AccountService accountService;
	@Autowired
	private HttpSession session;

	@GetMapping("/login")
	public String getLoginform(Model model, @ModelAttribute("nguoidung") NGUOIDUNG nguoidung)
			throws ServletException, IOException {
		return PageInfo.goSite(model, PageType.SITE_LOGIN);
	}

	@RequestMapping("/user/login")
	public String login(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password, @ModelAttribute("nguoidung") NGUOIDUNG nguoidung)
			throws ServletException, IOException {

		boolean rememberMe = paramService.getBoolean("rememberMe", false);
		if (username.isEmpty() && password.isEmpty()) {
			// validate form
			model.addAttribute("message", "Vui lòng điền đủ thông tin tài khoản và mật khẩu");
			return PageInfo.goSite(model, PageType.SITE_LOGIN);
		} else {
			// thực hiện đăng nhập và trả về đối tượng user
			NGUOIDUNG user = accountService.login(username, password);

			if (user == null) {
				model.addAttribute("message", "Sai tài khoản hoặc mật khẩu");
				return PageInfo.goSite(model, PageType.SITE_LOGIN);
			}
			if (rememberMe) {
				cookieService.add("username", username, 1);
				cookieService.add("password", password, 1);
			} else {
				cookieService.remove("username");
				cookieService.remove("password");
			}
			cookieService.add("username", username, 1);
			cookieService.add("password", password, 1);
			session.setAttribute("user", user);
			return "forward:/";
		}

	}

	@RequestMapping("/user/createUser")
	public String register(Model model, @Valid @ModelAttribute("nguoidung") NGUOIDUNG nguoidung, BindingResult result)
			throws ServletException, IOException {
		if (result.hasErrors()) {
			// validate form
			return PageInfo.goSite(model, PageType.SITE_LOGIN);
		} else {
			// Kiểm tra trùng ID
			Optional<NGUOIDUNG> user = nguoidungDAO.findById(nguoidung.getSDT());
			if (!user.isPresent()) {
				sendMail(nguoidung.getEmail(), nguoidung.getSDT(), nguoidung.getMatkhau());
				nguoidung.setVaitro(false);
				nguoidung.setIsactive(false);
				nguoidung.setNgaysinh(null);
				
				cookieService.add("username", nguoidung.getSDT(), 1);
				cookieService.add("password",  nguoidung.getMatkhau(), 1);
				session.setAttribute("name", nguoidung.getHo_ten());
				accountService.save(nguoidung);
				return "forward:/";
			} else {
				// Báo lỗi tài khoản đã tồn tại
				model.addAttribute("message", "Tài khoản đã tồn tại");
				return PageInfo.goSite(model, PageType.SITE_LOGIN);
			}
		}
	}

	@RequestMapping("/logout")
	public String getLogout(Model model) throws ServletException, IOException {
		cookieService.remove("username");
		cookieService.remove("password");
		sessionService.remove("user");
		return "forward:/";
	}

	public void sendMail(String txtTo, String username, String password) {
		MailInfo mail = new MailInfo();
		mail.setTo(txtTo);
		mail.setSubject("Thông Báo Tạo Tài Khoản Thành Công");
		mail.setBody(mailBody.mail_Welcome(username, password));
		mailService.queue(mail);
	}

}
