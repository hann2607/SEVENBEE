package com.sevenbee.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
import jakarta.servlet.http.HttpSession;

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
	@Autowired
	private HttpSession session;

	String codeVerify;

	/*
	 * @GetMapping("/show_userProfile") public String getUserInfo(HttpSession
	 * session, Model model) throws ServletException, IOException { // Lấy user từ
	 * session NGUOIDUNG user = (NGUOIDUNG) session.getAttribute("user");
	 * 
	 * // Nếu user không tồn tại, chuyển hướng đến trang đăng nhập if (user == null)
	 * { return PageInfo.goSite(model, PageType.HOMEPAGE); }
	 * 
	 * // để lấy thông tin của user từ cơ sở dữ liệu Optional<NGUOIDUNG> ndSDT =
	 * nguoidungDAO.findById(user.getSDT());
	 * 
	 * // Nếu không tìm thấy user trong cơ sở dữ liệu, trả về trang lỗi if (ndSDT ==
	 * null) { return "error"; } System.out.println(user.getHo_ten()+" " +
	 * user.getSDT()); // Truyền thông tin user vào model để hiển thị trên giao diện
	 * //model.addAttribute("username", ndSDT.get()); //model.addAttribute("email",
	 * ndSDT.getEmail());
	 * 
	 * return PageInfo.goSite(model, PageType.SITE_USERPROFILE);
	 * 
	 * }
	 */
	@GetMapping("/user/{sdt}")
	public String getUserByUsername(@PathVariable("sdt") String sdt, Model model) throws ServletException, IOException {
	    // Sử dụng UserRepository để lấy đối tượng User tương ứng với tên đăng nhập
		System.out.println("id: " + sdt);
//		NGUOIDUNG user = nguoidungDAO.findBySDT("395632154");
	    NGUOIDUNG user = nguoidungDAO.findById(sdt).get();
	    System.out.println(user);
	    // Nếu không tìm thấy user, trả về trang lỗi
	    if (user == null) {
	        return "error";
	    }
	    
	    // Truyền thông tin user vào model để hiển thị trên giao diện
	    model.addAttribute("user", user);
	    
	    return PageInfo.goSite(model, PageType.SITE_USERPROFILE);
	}


}
