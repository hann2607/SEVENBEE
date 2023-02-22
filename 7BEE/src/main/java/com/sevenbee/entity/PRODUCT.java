package com.sevenbee.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PRODUCT {
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
	String CTSP_ThongTinThem;
	@NotBlank(message = " - Xin nhập ít nhất 1 tiêu đề!")
	String CTSP_MoTaTitle;
	@NotBlank(message = " - Xin nhập ít nhất 1 nội dung!")
	String CTSP_MoTaContent;
}
