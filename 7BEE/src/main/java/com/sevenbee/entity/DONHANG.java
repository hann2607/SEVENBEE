package com.sevenbee.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "DONHANG")
public class DONHANG {
	@Id
	String DH_MA;
	String Ho_Ten, Shop_TenShop, Ghi_Chu, DH_DiaChi;
	@ManyToOne
	@JoinColumn(name = "SDT")
	NGUOIDUNG SDT;
	int So_Luong;
	long Don_gia;
	@Temporal(TemporalType.DATE)
	@Column(name = "Ngay_xuat_HD")
	Date Ngay_xuat_HD = new Date();
	
	@OneToMany(mappedBy = "donhang")
	private Set<DONHANG_SANPHAM> donhang_sanpham;

}
