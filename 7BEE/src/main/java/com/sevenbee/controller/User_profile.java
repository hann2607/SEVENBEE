package com.sevenbee.controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;

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

//import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

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

	private static final String URL_PHOTO = System.getProperty("user.dir") + "/src/main/webapp/views/images/team/";
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
//	 @RequestParam("images") MultipartFile attach,
	@PostMapping("/user/profile/update")
	public String updateProfile(Model model, @ModelAttribute("nguoidung") NGUOIDUNG nguoidung,
			@ModelAttribute("nguoidungpassword") NGUOIDUNG nguoidungpassword,  @RequestParam("images") MultipartFile attach,
			BindingResult result)
			throws ServletException, IOException {
		//String image ;
		nguoidung.setSDT(cookieService.getValue("username"));
		nguoidung.setMatkhau(cookieService.getValue("password"));
		nguoidung.setIsactive(true);
		//System.out.println(nguoidung.getHinhanh() + " name hinh anh");
		nguoidung.setVaitro(false);
		if(!attach.isEmpty()) {
			 String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMddHHmmss-"));
			String filename = date + attach.getOriginalFilename();
			File file = new File(URL_PHOTO + filename);
			if(!file.exists()) {
				file.mkdirs();
			}
			attach.transferTo(file);
			
			nguoidung.setHinhanh(filename);
		} else {
			nguoidung.setHinhanh(nguoidung.getHinhanh());
		}
		

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
//	@Autowired
//	ServletContext app;
//	public void createFloder() {
//		File uploadRootDir = new File(app.getRealPath("upload"));
//		if (!uploadRootDir.exists()) {
//			uploadRootDir.mkdirs();
//		}
//	}
//
//	// Lưu hình người dùng đã chọn
//	public String saveImage(MultipartFile attach) throws IOException {
//		// Lấy đường dẫn chính của thư mục upload
//		File uploadRootDir = new File(app.getRealPath("upload"));
//		// Nếu thư mục chưa được tạo thì sẽ tạo
//		createFloder();
//		// Lấy tên file được chọn
//		String filename = attach.getOriginalFilename();
//		File serverFile = new File(uploadRootDir.getAbsoluteFile() + File.separator + filename);
//		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
//		stream.write(attach.getBytes());
//		stream.close();
//		return filename;
//	}
	@Autowired
    private HttpServletRequest request;
	public String saveImage(MultipartFile attach) throws IOException {
	    // Lấy đường dẫn chính của thư mục upload
	    String uploadRootDir = request.getSession().getServletContext().getRealPath("upload");

	    // Nếu thư mục chưa được tạo thì sẽ tạo
	    File uploadRootDirPath = new File(uploadRootDir);
	    if (!uploadRootDirPath.exists()) {
	        uploadRootDirPath.mkdirs();
	    }

	    // Lấy tên file được chọn
	    String fileName = attach.getOriginalFilename();

	    // Lưu file vào thư mục upload
	    String filePath = uploadRootDir + File.separator + fileName;
	    File serverFile = new File(filePath);
	    attach.transferTo(serverFile);

	    return fileName;
	}

}
