package com.sevenbee.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PRODUCT {
	String SP_MA;
	@NotBlank(message = "Xin nhập tên sản phẩm !")
	String SP_TenSP;
	String LoaiSP_MA;
	@NotNull(message = "Xin nhập giá sản phẩm")
	@Min(value = 0, message = "Giá sản phẩm phải lớn hơn 0")
	@Positive(message = "Giá sản phẩm phải là một số dương")
	long SP_Gia;
	String Kich_Thuoc;
	String CTSP_Mau;
	int SP_SoLuong;
	String SP_HinhAnh;
	String CTSP_ThongTinThem;
	
	@NotBlank(message = " - Xin nhập ít nhất 1 tiêu đề!")
	String CTSP_MoTaTitle1;
	@NotBlank(message = " - Xin nhập ít nhất 1 nội dung!")
	String CTSP_MoTaContent1;
	
	String CTSP_MoTaTitle2;
	String CTSP_MoTaContent2;
	String CTSP_MoTaTitle3;
	String CTSP_MoTaContent3;
	String CTSP_MoTaTitle4;
	String CTSP_MoTaContent4;
	String CTSP_MoTaTitle5;
	String CTSP_MoTaContent5;
	String CTSP_MoTaTitle6;
	String CTSP_MoTaContent6;
	String CTSP_MoTaTitle7;
	String CTSP_MoTaContent7;
	String CTSP_MoTaTitle8;
	String CTSP_MoTaContent8;
}
