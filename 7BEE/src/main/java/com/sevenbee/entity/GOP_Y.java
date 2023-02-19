package com.sevenbee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "GOP_Y")
public class GOP_Y {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	String GOPY_ID;
	@NotBlank(message = "Xin hãy để chúng tôi biết bạn tên gì!")
	String GOPY_HoTen;
	@Email(message = "Email của bạn có vẻ chưa chính xác, xin hãy thử lại !")
	@NotBlank(message = "Xin hãy cho chúng tôi email của bạn !")
	String GOPY_email;
	@NotBlank(message = "Xin hãy góp ý cho chúng tôi !")
	String NoiDung;
}
