package com.sevenbee.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
	String SP_MA, Ho_Ten, Shop_TenShop, Ghi_Chu, SDT, DH_DiaChi;
	int So_Luong;
	long Don_gia;
	@ManyToOne
	NGUOIDUNG nguoidung;
	@ManyToOne
	LICHSU lichsu;
	@OneToMany
	@JoinColumn(name = "SP_MA")
	List<SANPHAM> sanpham;

}
