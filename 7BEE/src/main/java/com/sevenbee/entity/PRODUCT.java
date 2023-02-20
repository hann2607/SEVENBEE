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
	@NotBlank(message = "Không được để trống số điện thoại !")
	String Kich_Thuoc;
	@NotBlank(message = "Không được để trống số điện thoại !")
	String CTSP_Mau;
	int SP_SoLuong;
	@NotBlank(message = "Không được để trống số điện thoại !")
	String CTSP_ThongTinThem;
	@NotBlank(message = " - Xin nhập ít nhất 1 thông số chi tiết !")
	String CTSP_MoTa;
}
