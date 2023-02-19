package com.sevenbee.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sevenbee.dao.GOP_YDAO;
import com.sevenbee.entity.GOP_Y;
import com.sevenbee.entity.MailInfo;
import com.sevenbee.mailCONSTANT.mail_CONSTANT;
import com.sevenbee.service.MailService;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;
import jakarta.validation.Valid;

@Controller
public class FeedbackController {
	
	@Autowired
	GOP_YDAO gopyDAO;
	
	@Autowired
	MailService mailService;
	mail_CONSTANT mailBody = new mail_CONSTANT();
	
	@RequestMapping("/contact")
	public String contact(Model model, @ModelAttribute("gopy") GOP_Y gopy) throws ServletException, IOException {
		return PageInfo.goSite(model, PageType.SITE_CONTACT);
	}

	@RequestMapping("/contact/feedback")
	public String register(Model model, @Valid @ModelAttribute("gopy") GOP_Y gopy, BindingResult result)
			throws ServletException, IOException {
		if (result.hasErrors()) {
			// validate form
			return PageInfo.goSite(model, PageType.SITE_CONTACT);
		} else {
			gopyDAO.save(gopy);
			model.addAttribute("message", "Cảm ơn bạn đã đóng góp ý kiến cho chúng tôi ");
			model.addAttribute("gopy", new GOP_Y());
			sendMail(gopy.getGOPY_email(), gopy.getGOPY_HoTen());
		}
		return PageInfo.goSite(model, PageType.SITE_CONTACT);
	}
	
	public void sendMail(String txtTo, String username) {
		MailInfo mail = new MailInfo();
		mail.setTo(txtTo);
		mail.setSubject("CẢM ƠN BẠN ĐÃ ĐÓNG GÓP Ý KIẾN QUÝ GIÁ");
		mail.setBody(mailBody.mail_Camon(username));
		mailService.queue(mail);
	}
}
