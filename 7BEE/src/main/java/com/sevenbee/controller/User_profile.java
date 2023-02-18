package com.sevenbee.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.dao.NGUOIDUNGDAO;
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
import jakarta.validation.Valid;

@Controller
public class User_profile {
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


//	@GetMapping("/userinfo")
//	public String getUserInfo(Model model) throws ServletException, IOException {
//		
//	    // Lấy user từ session
//	    NGUOIDUNG ndung = (NGUOIDUNG) session.getAttribute("user");
//
//	    // Nếu user không tồn tại, chuyển hướng đến trang đăng nhập
//	    if (ndung == null) {
//	        return "redirect:/home";
//	    }
//
//	    // Sử dụng UserRepository để lấy thông tin của user từ cơ sở dữ liệu
//	    NGUOIDUNG dbUser = nguoidungDAO.findById("375586332").orElse(null);
//	    System.out.println(dbUser + " id");
//
//	    // Nếu không tìm thấy user trong cơ sở dữ liệu, trả về trang lỗi
//	    if (dbUser == null) {
//	        return "error";
//	    }
//
//	    // Truyền thông tin user vào model để hiển thị trên giao diện
//	    model.addAttribute("username", dbUser.getHo_ten());
//	    model.addAttribute("email", dbUser.getEmail());
//	    model.addAttribute("sdt", dbUser.getSDT());
//	    model.addAttribute("DOB", dbUser.getNgaysinh());
//	    model.addAttribute("vaitro", dbUser.isVaitro());
//	   
//
//	    return PageInfo.goSite(model, PageType.SITE_USERPROFILE);
//	}

//
	@RequestMapping("/user/profile")
	public String getUserByUsername(Model model, @ModelAttribute("nguoidung") NGUOIDUNG nguoidung,
			@ModelAttribute("nguoidungpassword") NGUOIDUNG nguoidungpassword) throws ServletException, IOException {
		// Sử dụng UserRepository để lấy đối tượng User tương ứng với tên đăng nhập
		// System.out.println(cookieService.getValue("username"));
		NGUOIDUNG user = nguoidungDAO.findById(cookieService.getValue("username")).get();
		// System.out.println(user.getHo_ten());
		// Nếu không tìm thấy user, trả về trang lỗi
		if (user == null) {
			return PageInfo.goSite(model, PageType.SITE_LOGIN);
		}

		// Truyền thông tin user vào model để hiển thị trên giao diện
		model.addAttribute("user", user);

		String test = (user.isVaitro() == true) ? "Admin" : "Người dùng";
		model.addAttribute("test111", test);

		return PageInfo.goSite(model, PageType.SITE_USERPROFILE);
	}

	@PostMapping("/user/profile/update")
	public String updateProfile(Model model, @ModelAttribute("nguoidung") NGUOIDUNG nguoidung,
			@ModelAttribute("nguoidungpassword") NGUOIDUNG nguoidungpassword, BindingResult result)
			throws ServletException, IOException {

		nguoidung.setSDT(cookieService.getValue("username"));
		nguoidung.setMatkhau(cookieService.getValue("password"));

		nguoidung.setVaitro(false);

		accountService.save(nguoidung);

		model.addAttribute("messages", "Update success!");
		System.out.println("update okk");

		return PageInfo.goSite(model, PageType.SITE_USERPROFILE);

	}

	@PostMapping("user/profile/changepassword")
	public String ChangePasswords(Model model, @Valid @ModelAttribute("nguoidung") NGUOIDUNG nguoidung,
			@ModelAttribute("nguoidungpassword") NGUOIDUNG nguoidungpassword, BindingResult result)
			throws ServletException, IOException {
		nguoidungpassword.setSDT(cookieService.getValue("username"));
		accountService.save(nguoidungpassword);
		model.addAttribute("messages", "Update success!");
		System.out.println("update okk");
		return PageInfo.goSite(model, PageType.SITE_USERPROFILE);
	}

}
