package com.sevenbee.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
	String SDT;
	String HoTen, Email, MatKhau, DiaChi, NgayDanhGiaSanPham;
	@Temporal(TemporalType.DATE)
	@Column(name = "NgaySinh")
	Date NgaySinh = new Date();
	boolean VaiTro = true, isActive = false;
}
