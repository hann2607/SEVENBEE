package com.sevenbee.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LOGIN {
	@NotBlank(message = "Không được để trống số điện thoại !")
	private String username;
	@NotBlank(message = "Không được để trống mật khẩu !")
	private String password;
	
	private Boolean rememberMe = false;
}
