package com.sevenbee.entity;

import java.util.Date;
import java.util.List;

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
import jakarta.validation.constraints.NotEmpty;
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
	@NotEmpty
	String SDT;
	@Email
	@NotEmpty
	String Email;
	@NotBlank(message = "Không được để trống họ và tên !")
	String Ho_ten;
	String Diachi, Hinhanh;
	@NotEmpty
	String Matkhau;
	@Temporal(TemporalType.DATE)
	@Column(name = "NgaySinh")
	Date Ngaysinh = new Date();
	boolean Vaitro = true, isactive = false;
	@OneToMany
	@JoinColumn(name = "SDT")
	List<DONHANG> donhang;
	@OneToMany
	@JoinColumn(name = "SDT")
	List<DANHGIA_TINTUC> danhgia_tintuc;
}
