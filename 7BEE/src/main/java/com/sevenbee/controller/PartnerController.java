package com.sevenbee.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sevenbee.dao.CHITIET_SANPHAMDAO;
import com.sevenbee.dao.LOAISPDAO;
import com.sevenbee.dao.PARTNERDAO;
import com.sevenbee.dao.SANPHAMDAO;
import com.sevenbee.entity.CHITIET_SANPHAM;
import com.sevenbee.entity.LOAISP;
import com.sevenbee.entity.PARTNER;
import com.sevenbee.entity.PRODUCT;
import com.sevenbee.entity.SANPHAM;
import com.sevenbee.service.CookieService;
import com.sevenbee.service.RandomService;
import com.sevenbee.util.PageInfo;
import com.sevenbee.util.PageType;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class PartnerController {

	@Autowired
	CookieService cookieService;

	@Autowired
	LOAISPDAO loaispDAO;

	@Autowired
	SANPHAMDAO spDAO;

	@Autowired
	CHITIET_SANPHAMDAO ctspDAO;

	@Autowired
	PARTNERDAO partnerDAO;

	@Autowired
	RandomService randomService;

	@GetMapping("/partner")
	public String detai_Product(Model model, @ModelAttribute("product") PRODUCT p)
			throws ServletException, IOException {
		if (cookieService.getValue("username") == null) {
			return "forward:/login-partner";
		}
		List<LOAISP> lstLoaiSP = loaispDAO.findAll();
		model.addAttribute("lstLoaiSP", lstLoaiSP);
		model.addAttribute("showForm2", "show active");
		model.addAttribute("btnActive2", "active");
		findAllSPbyPartner(cookieService.getValue("username"), model);
		return PageInfo.goSite(model, PageType.SITE_PARTNER);
	}

	@RequestMapping("/partner/addproduct")
	public String add_Product(Model model, @Valid @ModelAttribute("product") PRODUCT p, BindingResult result,
			HttpServletRequest request, @RequestParam("filesIMG") MultipartFile[] files)
			throws ServletException, IOException {
		if (result.hasErrors()) {
			// validate form
			model.addAttribute("showForm1", "show active");
			model.addAttribute("btnActive1", "active");
			System.err.println("check");
			return PageInfo.goSite(model, PageType.SITE_PARTNER);
		} else {
			if (files == null || files.length < 2) {
				// Không có ảnh nào được tải lên
				model.addAttribute("itnhat2hinh", "Vui lòng đăng tải ít nhất 2 ảnh!");
			}
			if (files.length > 10) {
				// Báo lỗi nếu có nhiều hơn 10 hình ảnh
				model.addAttribute("toida10hinh", "Bạn chỉ có thể đăng tải tối đa 10 ảnh!");
			} else {
				// Xử lí thông số chi tiết dạng table
				String CTSP_Table = "";
				if (!p.getCTSP_MoTaTitle().isEmpty() && !p.getCTSP_MoTaContent().isEmpty()) {
					CTSP_Table += p.getCTSP_MoTaTitle() + "-*-" + p.getCTSP_MoTaContent() + "-*-";
				}
				if (request.getParameter("content2") != null && !request.getParameter("content2").isEmpty()) {
					CTSP_Table += request.getParameter("title2") + "-*-" + request.getParameter("content2") + "-*-";
				}
				if (request.getParameter("content3") != null && !request.getParameter("content3").isEmpty()) {
					CTSP_Table += request.getParameter("title3") + "-*-" + request.getParameter("content3") + "-*-";
				}
				if (request.getParameter("content4") != null && !request.getParameter("content4").isEmpty()) {
					CTSP_Table += request.getParameter("title4") + "-*-" + request.getParameter("content4") + "-*-";
				}
				if (request.getParameter("content5") != null && !request.getParameter("content5").isEmpty()) {
					CTSP_Table += request.getParameter("title5") + "-*-" + request.getParameter("content5") + "-*-";
				}
				if (request.getParameter("content6") != null && !request.getParameter("content6").isEmpty()) {
					CTSP_Table += request.getParameter("title6") + "-*-" + request.getParameter("content6") + "-*-";
				}
				if (request.getParameter("content7") != null && !request.getParameter("content7").isEmpty()) {
					CTSP_Table += request.getParameter("title7") + "-*-" + request.getParameter("content7") + "-*-";
				}
				if (request.getParameter("content8") != null && !request.getParameter("content8").isEmpty()) {
					CTSP_Table += request.getParameter("title8") + "-*-" + request.getParameter("content8") + "-*-";
				}
//				System.out.println(CTSP_Table);
				try {
					// Lưu hình ảnh về thư mục sản phẩm
					String uploadDirectory = "src/main/webapp/views/images/product/large-size/";
					// Mảng hình được tạo sẳn dựa trên số hình ảnh đăng tải
					String[] lstIMGname = new String[files.length];
					// Vòng lặp để thêm hình vào folder và thêm tên hình vào mảng
					for (int i = 0; i < files.length; i++) {
						// Lấy hình từ mảng input trả về
						Path filePath = Paths.get(uploadDirectory, files[i].getOriginalFilename());
						// Lưu hình vào thư mục theo đường dẫn
						Files.write(filePath, files[i].getBytes());
						// Thêm từng tên hình vào mảng
						lstIMGname[i] = files[i].getOriginalFilename();
					}
					// Chèn thêm kí hiệu đặc biệt giữa các phần tử trong mảng và đưa về dạng chuỗi
					String lstIMGsp = String.join("-*-", lstIMGname);
//					 System.out.println(joinedlstIMGname);

					// Kiểm tra mã của CTSP và SP
					String maCTSP = "CTSP" + cookieService.getValue("username") + randomService.randomString(5);
					Optional<CHITIET_SANPHAM> ctsp = ctspDAO.findById(maCTSP);
					Optional<SANPHAM> sp = spDAO.findById(maCTSP.substring(2));

					if (ctsp.isPresent() || sp.isPresent()) {
						System.out.println("check");
						model.addAttribute("error", "Thêm sản phẩm thất bại, vui lòng thử lại!");
					} else {
						// Thêm dữ liệu vào bảng Chi tiết sản phẩm
						CHITIET_SANPHAM ctspNEW = new CHITIET_SANPHAM();
						ctspNEW.setCTSP_MA(maCTSP);
						ctspNEW.setCTSP_MoTa(CTSP_Table);
						ctspNEW.setKich_Thuoc(p.getCTSP_Mau());
						ctspNEW.setCTSP_Mau(p.getCTSP_Mau());
						ctspNEW.setCTSP_ThongTinThem(p.getCTSP_ThongTinThem());
						ctspDAO.save(ctspNEW);

						// Thêm dữ liệu vào bảng Sản phẩm
						SANPHAM spNEW = new SANPHAM();
						spNEW.setSP_MA(maCTSP.substring(2));
						spNEW.setShop(partnerDAO.findById(cookieService.getValue("username")).get());/////////
						spNEW.setLoaisp(loaispDAO.findById(p.getLoaiSP_MA()).get());
						Date currentDate = new Date();
						spNEW.setSP_Ngaydang(currentDate);
						spNEW.setSP_TenSP(p.getSP_TenSP());
						spNEW.setSP_HinhAnh(lstIMGsp);
						spNEW.setSP_Gia(p.getSP_Gia());
						spNEW.setSP_SoLuong(p.getSP_SoLuong());
						spNEW.setCt_sanpham(ctspDAO.findById(maCTSP).get());
						spDAO.save(spNEW);
						model.addAttribute("message", "Thêm sản phẩm thành công");
					}
				} catch (IOException e) {
					model.addAttribute("error", "Error: " + e.getMessage());
//					model.addAttribute("error", "Thêm sản phẩm thất bại, vui lòng thử lại!");
				}
			}
		}
		model.addAttribute("showForm1", "show active");
		model.addAttribute("btnActive1", "active");
		return PageInfo.goSite(model, PageType.SITE_PARTNER);
	}

	private void findAllSPbyPartner(String id, Model model) {
		PARTNER p = partnerDAO.findById(id).get();
		List<SANPHAM> lstSP = p.getSanpham();
		System.out.println(lstSP.size());
		model.addAttribute("lstSPbyPartner",lstSP);
	}

}
