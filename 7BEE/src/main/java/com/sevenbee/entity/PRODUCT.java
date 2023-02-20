package com.sevenbee.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PRODUCT {
	@NotBlank(message = "Không được để trống số điện thoại !")
	String SP_TenSP;
	@NotEmpty(message = "Không được để trống số điện thoại !")
	String LoaiSP_MA;
	@NotEmpty(message = "Không được để trống số điện thoại !")
	long SP_Gia;
	@NotBlank(message = "Không được để trống số điện thoại !")
	String Kich_Thuoc;
	@NotBlank(message = "Không được để trống số điện thoại !")
	String CTSP_Mau;
	@NotBlank(message = "Không được để trống số điện thoại !")
	int SP_SoLuong;
	@NotBlank(message = "Không được để trống số điện thoại !")
	String CTSP_ThongTinThem;
	@NotBlank(message = "Không được để trống số điện thoại !")
	String CTSP_MoTa;
}
