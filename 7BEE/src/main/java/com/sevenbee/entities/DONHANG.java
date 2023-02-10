package com.sevenbee.entities;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
	String Ho_Ten, Shop_TenShop, Ghi_Chu, SDT, DH_DiaChi;
	int So_Luong;
	long Don_gia;
	
	@OneToMany(mappedBy = "donhang")
	private Set<DONHANG_SANPHAM> donhang_sanpham;
}
