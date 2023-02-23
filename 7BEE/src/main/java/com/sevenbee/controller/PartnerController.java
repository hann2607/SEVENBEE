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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

	@RequestMapping("/partner/add")
	public String add_Product(Model model, @Valid @ModelAttribute("product") PRODUCT p, BindingResult result,
			@RequestParam("filesIMG") MultipartFile[] files) throws ServletException, IOException {
		if (result.hasErrors()) {
			// validate form
			model.addAttribute("showForm1", "show active");
			model.addAttribute("btnActive1", "active");
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
				if (!p.getCTSP_MoTaTitle1().isEmpty() && !p.getCTSP_MoTaContent1().isEmpty()) {
					CTSP_Table += p.getCTSP_MoTaTitle1() + "-*-" + p.getCTSP_MoTaContent1() + "-*-";
				}
				if (!p.getCTSP_MoTaTitle2().isEmpty() && !p.getCTSP_MoTaContent2().isEmpty()) {
					CTSP_Table += p.getCTSP_MoTaTitle2() + "-*-" + p.getCTSP_MoTaContent2() + "-*-";
				}
				if (!p.getCTSP_MoTaTitle3().isEmpty() && !p.getCTSP_MoTaContent3().isEmpty()) {
					CTSP_Table += p.getCTSP_MoTaTitle3() + "-*-" + p.getCTSP_MoTaContent3() + "-*-";
				}
				if (!p.getCTSP_MoTaTitle4().isEmpty() && !p.getCTSP_MoTaContent4().isEmpty()) {
					CTSP_Table += p.getCTSP_MoTaTitle4() + "-*-" + p.getCTSP_MoTaContent4() + "-*-";
				}
				if (!p.getCTSP_MoTaTitle5().isEmpty() && !p.getCTSP_MoTaContent5().isEmpty()) {
					CTSP_Table += p.getCTSP_MoTaTitle5() + "-*-" + p.getCTSP_MoTaContent5() + "-*-";
				}
				if (!p.getCTSP_MoTaTitle6().isEmpty() && !p.getCTSP_MoTaContent6().isEmpty()) {
					CTSP_Table += p.getCTSP_MoTaTitle6() + "-*-" + p.getCTSP_MoTaContent6() + "-*-";
				}
				if (!p.getCTSP_MoTaTitle7().isEmpty() && !p.getCTSP_MoTaContent7().isEmpty()) {
					CTSP_Table += p.getCTSP_MoTaTitle7() + "-*-" + p.getCTSP_MoTaContent7() + "-*-";
				}
				if (!p.getCTSP_MoTaTitle8().isEmpty() && !p.getCTSP_MoTaContent8().isEmpty()) {
					CTSP_Table += p.getCTSP_MoTaTitle8() + "-*-" + p.getCTSP_MoTaContent8() + "-*-";
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

	@PostMapping("/partner/edit/{id}")
	public String edit(@PathVariable("id") String id, Model model) throws ServletException, IOException {
		findAllSPbyPartner(cookieService.getValue("username"), model);
		SANPHAM sp = spDAO.findById(id).get();
		PRODUCT pd = new PRODUCT();
		pd.setSP_MA(sp.getSP_MA());
		pd.setSP_TenSP(sp.getSP_TenSP());
		pd.setLoaiSP_MA(sp.getLoaisp().getLoaiSP_MA());
		pd.setSP_Gia(sp.getSP_Gia());
		pd.setCTSP_Mau(sp.getCt_sanpham().getCTSP_Mau());
		pd.setSP_SoLuong(sp.getSP_SoLuong());
		pd.setKich_Thuoc(sp.getCt_sanpham().getKich_Thuoc());
		pd.setCTSP_ThongTinThem(sp.getCt_sanpham().getCTSP_ThongTinThem());
//		pd.setSP_HinhAnh(sp.getSP_HinhAnh());
		String[] arrThongSo = sp.getCt_sanpham().getCTSP_MoTa().split("-\\*-");
		model.addAttribute("arrThongSo", arrThongSo);
		model.addAttribute("product", pd);
		model.addAttribute("showForm1", "show active");
		model.addAttribute("btnActive1", "active");
		return PageInfo.goSite(model, PageType.SITE_PARTNER);
	}

	private void findAllSPbyPartner(String id, Model model) {
		PARTNER p = partnerDAO.findById(id).get();
		List<SANPHAM> lstSP = p.getSanpham();
		model.addAttribute("lstSPbyPartner", lstSP);
	}

}
