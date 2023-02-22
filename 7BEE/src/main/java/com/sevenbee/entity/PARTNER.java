package com.sevenbee.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "PARTNER")
public class PARTNER {
	@Id
	@NotBlank(message = "Vui lòng nhập số điện thoại !")
	String SDT;
	@Column(unique = true)
	@NotBlank(message = "Vui lòng nhập tên shop !")
	String Shop_TenShop;
	@Email(message = "Email nhập vào không đúng định dạng thử lại !")
	@NotBlank(message = "Vui lòng nhập email của bạn !")
	String Email; 
	String Hinhanh;
	@NotBlank(message = "Vui lòng nhập mật khẩu !")
	String Matkhau;
	String MoTaShop;
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
