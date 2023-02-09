package com.sevenbee.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "DANHGIA_SANPHAM")
public class DANHGIA_SANPHAM {
	@Id
	String DG_SP_MA;
	String LS_MA, SP_MA, Ho_Ten, DG_SP_BinhLuan;
	@Temporal(TemporalType.DATE)
	@Column(name = "DG_SP_NgayDanhGia")
	Date DG_SP_NgayDanhGia = new Date();
	boolean DG_SP_Like = true;
	@ManyToOne @JoinColumn(name = "LS_MA")
	LICHSU lichsu;
}
