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
	String Ho_Ten, Email, Mat_Khau, Dia_Chi, Hinh_Anh;
	@Temporal(TemporalType.DATE)
	@Column(name = "NgaySinh")
	Date Ngay_Sinh = new Date();
	boolean Vai_Tro = true, is_Active = false;
}
