package com.sevenbee.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "PARTNER")
public class PARTNER {
	@Id
	String SDT;
	@Column(unique = true)
	String Shop_TenShop;
	String Email, Hinhanh, Matkhau, MoTaShop;
	@Temporal(TemporalType.DATE)
	@Column(name = "NgayDKShop")
	Date NgayDKShop = new Date();
	boolean isactive = false;
//	@OneToMany
//	@JoinColumn(name = "Shop_TenShop")
//	List<TINTUC> tintuc;
	
	@OneToMany(mappedBy = "shop")
	private List<SANPHAM> sanpham;
}
