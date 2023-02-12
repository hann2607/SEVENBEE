package com.sevenbee.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "SANPHAM")
public class SANPHAM {
	@Id
	String SP_MA;
	String SP_TenSP, SP_HinhAnh;
	long SP_Gia;
	@Temporal(TemporalType.DATE)
	@Column(name = "SP_Ngaydang")
	Date SP_Ngaydang = new Date();
	@ManyToOne
	@JoinColumn(name = "LoaiSP_MA", referencedColumnName = "LoaiSP_MA")
	private LOAISP loaisp;
	@OneToOne
	@JoinColumn(name = "CTSP_MA")
	private CHITIET_SANPHAM ct_sanpham;
	@ManyToOne
	@JoinColumn(name = "Shop_TenShop", referencedColumnName = "Shop_TenShop")
	private PARTNER shop;
}
