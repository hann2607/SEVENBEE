package com.sevenbee.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
	@NotNull(message = "SP_Gia không được để trống")
	@Min(value = 0, message = "SP_Gia phải lớn hơn 0")
	@Positive(message = "SP_Gia phải là một số dương")
	long SP_Gia;
	@NotBlank(message = "Không được để trống số điện thoại !")
	String Kich_Thuoc;
	@NotBlank(message = "Không được để trống số điện thoại !")
	String CTSP_Mau;
	@NotNull(message = "SP_Gia không được để trống")
	@Min(value = 0, message = "SP_Gia phải lớn hơn 0")
	@Positive(message = "SP_Gia phải là một số dương")
	int SP_SoLuong;
	@NotBlank(message = "Không được để trống số điện thoại !")
	String CTSP_ThongTinThem;
	@NotBlank(message = "Không được để trống số điện thoại !")
	String CTSP_MoTa;
}
