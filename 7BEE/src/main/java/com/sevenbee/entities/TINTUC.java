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
@Table(name = "TINTUC")
public class TINTUC {
	@Id
	String TT_MA;
	String Shop_TenShop, TT_Tags, TT_Hinh_Anh, TT_Noi_Dung_Title, TT_Noi_Dung_Body;
	@Temporal(TemporalType.DATE)
	@Column(name = "TT_Ngay_Dang")
	Date TT_Ngay_Dang = new Date();
}
