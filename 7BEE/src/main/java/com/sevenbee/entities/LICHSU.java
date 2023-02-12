package com.sevenbee.entities;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LICHSU")
public class LICHSU {
	@Id
	String LS_MA;
	String DH_MA, SP_TenSP, HoTen;
	long TongTien;
	@Temporal(TemporalType.DATE)
	@Column(name = "LS_NgayMua")
	Date LS_NgayMua = new Date();
	@OneToMany
	@JoinColumn(name = "DH_MA")
	List<DONHANG> donhang;
	@OneToMany
	@JoinColumn(name = "LS_MA")
	List<DANHGIA_SANPHAM> danhgia_sanpham;
}
