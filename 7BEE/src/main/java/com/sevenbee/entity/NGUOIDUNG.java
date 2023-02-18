package com.sevenbee.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NGUOIDUNG")
public class NGUOIDUNG {
	@Id
	@NotBlank(message = "Không được để trống số điện thoại !")
	String SDT;
	@Email(message = "Email nhập vào không đúng định dạng thử lại !")
	@NotBlank(message = "Không được bỏ trống email của bạn !")
	String Email;
	@NotBlank(message = "Không được để trống họ và tên !")
	String Ho_ten;
	String Diachi, Hinhanh;
	@NotBlank(message = "Không được để trống mật khẩu !")
	@Column(length = 60, nullable = false)
	String Matkhau;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "Ngaysinh")
	Date Ngaysinh ;
	boolean Vaitro = true, isactive = false;
	@OneToMany(mappedBy = "SDT", cascade = CascadeType.ALL)
	List<DONHANG> donhang;
	@OneToMany
	@JoinColumn(name = "SDT")
	List<DANHGIA_TINTUC> danhgia_tintuc;
}
