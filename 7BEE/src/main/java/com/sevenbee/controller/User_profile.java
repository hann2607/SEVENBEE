package com.sevenbee.controller;

import java.io.IOException;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	String codeVerify;

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
		nguoidung.setIsactive(true);

		nguoidung.setVaitro(false);
		

		accountService.save(nguoidung);

		model.addAttribute("messages", "Update success!");
		System.out.println("update okk");

		return "redirect:/user/profile";
//		return PageInfo.goSite(model, PageType.SITE_USERPROFILE);

	}

	@PostMapping("user/profile/changepassword")
	public String ChangePasswords(@RequestParam("pwnew1") String pw1, @RequestParam("pwcomfirm") String pwcomfirm,
			Model model, @ModelAttribute("nguoidung") NGUOIDUNG nguoidung,
			@ModelAttribute("nguoidungpassword") NGUOIDUNG nguoidungpassword, BindingResult result)
			throws ServletException, IOException {

		nguoidungpassword.setSDT(cookieService.getValue("username"));
		
	//	System.out.println("check mk da nhap " + pw1);

		if (!pw1.equals(pwcomfirm)) {
			model.addAttribute("error", "Mật khẩu nhập lại không khớp");
			return "changepassword";
		} 
//			else {
//			System.out.println("test cookie sdt ; " + nguoidungpassword.getSDT());
//
//			Optional<NGUOIDUNG> ngdungpass = nguoidungDAO.findById(nguoidungpassword.getSDT());
//			System.out.println("dennnday1111 chua lay dc cai gi r" + nguoidungpassword.getHo_ten());
//			if (ngdungpass.isPresent()) {
//				System.out.println("dennnday chua lay dc cai gi r" + nguoidungpassword.getHo_ten());
//				nguoidungpassword.getHo_ten();
//				nguoidungpassword.getDiachi();
//				nguoidungpassword.getHinhanh();
//				nguoidungpassword.getNgaysinh();
//				nguoidungpassword.getEmail();
//				nguoidungpassword.isVaitro();
//				nguoidungpassword.isIsactive();
//				nguoidungpassword.setMatkhau(pwcomfirm);
//				accountService.save(nguoidungpassword);
//				model.addAttribute("messages", "Update success!");
//				System.out.println("update mat khau okk");
//			} else {
//				// Báo lỗi tài khoản đã tồn tại
//				model.addAttribute("message", "Lỗi");
//				return PageInfo.goSite(model, PageType.SITE_USERPROFILE);
//			}
//
//			// nguoidungpassword.setMatkhau(pwcomfirm);
//			// nguoidung.setMatkhau(pwcomfirm)
//
//			System.out.println("test1 ; " + nguoidungpassword.getHo_ten());
//			System.out.println("test1 ; " + nguoidungpassword.getEmail());
//		}
		else {
			nguoidung.setSDT(nguoidungpassword.getSDT());
			Optional<NGUOIDUNG> user1 = nguoidungDAO.findById(nguoidung.getSDT());
			nguoidung.setHo_ten(user1.get().getHo_ten());
			nguoidung.setEmail(user1.get().getEmail());
			nguoidung.setDiachi(user1.get().getDiachi());
			nguoidung.setNgaysinh(user1.get().getNgaysinh());
			nguoidung.setHinhanh(user1.get().getHinhanh());
			nguoidung.setMatkhau(pwcomfirm);
			nguoidung.setIsactive(true);

			nguoidung.setVaitro(false);

			accountService.save(nguoidung);

			model.addAttribute("message", "Update thành công");
			
		//	System.out.println("update okk");
		}
		cookieService.remove("username");
		cookieService.remove("password");
		sessionService.remove("name");
		return "redirect:/login";
		
	}
	

}
