package com.sevenbee.controller;

import java.io.IOException;
import java.util.Date;
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
import com.sevenbee.dao.PARTNERDAO;
import com.sevenbee.entity.MailInfo;
import com.sevenbee.entity.NGUOIDUNG;
import com.sevenbee.entity.PARTNER;
import com.sevenbee.mailCONSTANT.mail_CONSTANT;
import com.sevenbee.service.AccountService;
import com.sevenbee.service.CookieService;
import com.sevenbee.service.MailService;
import com.sevenbee.service.ParamService;
import com.sevenbee.service.PartnerService;
import com.sevenbee.service.SessionService;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;
import com.sevenbee.validation.AccountValidate;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
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
	PARTNERDAO partnerDAO;

	@Autowired
	MailService mailService;

	@Autowired
	private AccountService accountService;
	@Autowired
	private PartnerService partnerService;
	@Autowired
	private HttpSession session;

	@GetMapping("/login")
	public String getLoginform(Model model, @ModelAttribute("nguoidung") NGUOIDUNG nguoidung,
			HttpServletRequest request) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String referer = request.getHeader("Referer");
		session.setAttribute("referer", referer);
		return PageInfo.goSite(model, PageType.SITE_LOGIN);
	}

	@RequestMapping("/user/login")
	public String login(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password, @ModelAttribute("nguoidung") NGUOIDUNG nguoidung,
			HttpServletRequest request) throws ServletException, IOException {

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
			// Lưu thông tin đăng nhập
			cookieService.add("username", username, 1);
			cookieService.add("password", password, 1);
			// Show thông tin đăng nhập
			sessionService.set("userCK", user);
//			model.addAttribute("userCK", user);
//			showUserLog(username, model);
			// Lấy trang hiện tại từ session
			HttpSession session = request.getSession();
			String referer = (String) session.getAttribute("referer");

			// Chuyển hướng trở lại trang trước đó
			if (referer != null) {
				return "redirect:" + referer;
			}

			// Nếu không tìm thấy trang trước đó, chuyển hướng đến trang chủ
			return "redirect:/";
		}

	}

	@RequestMapping("/user/createUser")
	public String register(Model model, @Valid @ModelAttribute("nguoidung") NGUOIDUNG nguoidung, BindingResult result,
			HttpServletRequest request) throws ServletException, IOException {
		if (result.hasErrors()) {
			// validate form
			return PageInfo.goSite(model, PageType.SITE_LOGIN);
		} else {
			// Kiểm tra trùng ID
			Optional<NGUOIDUNG> user = nguoidungDAO.findById(nguoidung.getSDT());
			if (!user.isPresent()) {
				sendMail(nguoidung.getEmail(), nguoidung.getSDT(), nguoidung.getMatkhau());
				nguoidung.setVaitro(false);
				nguoidung.setIsactive(true);
				nguoidung.setNgaysinh(null);
				nguoidung.setHinhanh("user.jpeg");
				cookieService.add("username", nguoidung.getSDT(), 1);
				cookieService.add("password", nguoidung.getMatkhau(), 1);
				accountService.save(nguoidung);
				// Show thông tin đăng nhập
				sessionService.set("userCK", nguoidung);
				// Lấy trang hiện tại từ session
				HttpSession session = request.getSession();
				String referer = (String) session.getAttribute("referer");

				// Chuyển hướng trở lại trang trước đó
				if (referer != null) {
					return "redirect:" + referer;
				}

				// Nếu không tìm thấy trang trước đó, chuyển hướng đến trang chủ
				return "redirect:/";
			} else {
				// Báo lỗi tài khoản đã tồn tại
				model.addAttribute("message", "Tài khoản đã tồn tại");
				return PageInfo.goSite(model, PageType.SITE_LOGIN);
			}
		}
	}


	public void sendMail(String txtTo, String username, String password) {
		MailInfo mail = new MailInfo();
		mail.setTo(txtTo);
		mail.setSubject("Thông Báo Tạo Tài Khoản Thành Công");
		mail.setBody(mailBody.mail_Welcome(username, password));
		mailService.queue(mail);
	}

	// PARTNER

	@GetMapping("/login-partner")
	public String getPartnerForm(Model model, @ModelAttribute("partner") PARTNER partner, HttpServletRequest request)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String referer = request.getHeader("Referer");
		session.setAttribute("referer", referer);
		return PageInfo.goSite(model, PageType.SITE_LOGIN_PARTNER);
	}

	@RequestMapping("/partner/login")
	public String loginPartner(Model model, @RequestParam("username") String username,
			@RequestParam("password") String password, @ModelAttribute("partner") PARTNER partner,
			HttpServletRequest request) throws ServletException, IOException {

		boolean rememberMe = paramService.getBoolean("rememberMe", false);
		if (username.isEmpty() && password.isEmpty()) {
			// validate form
			model.addAttribute("message", "Vui lòng điền đủ thông tin tài khoản và mật khẩu");
			return PageInfo.goSite(model, PageType.SITE_LOGIN_PARTNER);
		} else {
			// thực hiện đăng nhập và trả về đối tượng user
			PARTNER p = partnerService.login(username, password);

			if (p == null) {
				model.addAttribute("message", "Sai tài khoản hoặc mật khẩu");
				return PageInfo.goSite(model, PageType.SITE_LOGIN_PARTNER);
			}
			if (rememberMe) {
				cookieService.add("username", username, 24);
				cookieService.add("password", password, 24);
			} else {
				cookieService.remove("username");
				cookieService.remove("password");
			}
			cookieService.add("username", username, 1);
			cookieService.add("password", password, 1);

			// Show thông tin đăng nhập
			sessionService.set("partnerCK", p);
			// Lấy trang hiện tại từ session
			HttpSession session = request.getSession();
			String referer = (String) session.getAttribute("referer");

			// Chuyển hướng trở lại trang trước đó
			if (referer != null) {
				return "redirect:" + referer;
			}

			// Nếu không tìm thấy trang trước đó, chuyển hướng đến trang chủ
			return "redirect:/";
		}

	}

	@RequestMapping("/partner/createPartner")
	public String register(Model model, @RequestParam("XacnhanMatkhau") String XNmatkhau,
			@Valid @ModelAttribute("partner") PARTNER partner, BindingResult result, HttpServletRequest request)
			throws ServletException, IOException {
		if (result.hasErrors()) {
			// validate form
			return PageInfo.goSite(model, PageType.SITE_LOGIN_PARTNER);
		} else {
			if (!XNmatkhau.equalsIgnoreCase(partner.getMatkhau())) {
				model.addAttribute("XNMatkhau", "Xác nhận mật khẩu chưa chính xác");
				return PageInfo.goSite(model, PageType.SITE_LOGIN_PARTNER);
			}
			// Kiểm tra trùng ID
			Optional<PARTNER> p = partnerService.findById(partner.getSDT());
			if (!p.isPresent()) {
				sendMailPartner(partner.getEmail(), partner.getSDT(), partner.getMatkhau());
				partner.setIsactive(false);
				Date currentDate = new Date();
				partner.setNgayDKShop(currentDate);
				partner.setHinhanh("partner.png");
				partner.setIsactive(true);
				partnerService.save(partner);
				cookieService.add("username", partner.getSDT(), 1);
				cookieService.add("password", partner.getMatkhau(), 1);
				
				// Show thông tin đăng nhập
				sessionService.set("partnerCK", partner);

				// Lấy trang hiện tại từ session
				HttpSession session = request.getSession();
				String referer = (String) session.getAttribute("referer");

				// Chuyển hướng trở lại trang trước đó
				if (referer != null) {
					return "redirect:" + referer;
				}

				// Nếu không tìm thấy trang trước đó, chuyển hướng đến trang chủ
				return "redirect:/";
			} else {
				// Báo lỗi tài khoản đã tồn tại
				model.addAttribute("message", "Tài khoản đã tồn tại");
				return PageInfo.goSite(model, PageType.SITE_LOGIN_PARTNER);
			}
		}
	}

	@RequestMapping("/logout")
	public String getLogout(HttpServletRequest request) throws ServletException, IOException {
		// Lấy trang hiện tại từ session
		HttpSession session = request.getSession();
		String referer = (String) session.getAttribute("referer");
		// Xử lí đăng xuất
		cookieService.remove("username");
		cookieService.remove("password");
		sessionService.remove("userCK");
		sessionService.remove("partnerCK");
		// Xóa trang trước đó khỏi session
		session.removeAttribute("referer");

		// Chuyển hướng trở lại trang trước đó (nếu có)
		if (referer != null) {
			return "redirect:" + referer;
		}

		// Nếu không tìm thấy trang trước đó, chuyển hướng đến trang chủ
		return "redirect:/";

	}

	public void sendMailPartner(String txtTo, String username, String password) {
		MailInfo mail = new MailInfo();
		mail.setTo(txtTo);
		mail.setSubject("THÔNG BÁO ĐĂNG KÝ SHOP THÀNH CÔNG");
		mail.setBody(mailBody.mail_WelcomePartner(username, password));
		mailService.queue(mail);
	}

}
