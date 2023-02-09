package com.sevenbee.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CHITIET_SANPHAM")
public class CHITIET_SANPHAM {
	@Id
	String CTSP_MA;
	String SP_MA, CTSP_Mo_Ta, Kich_Thuoc, CTSP_Mau, CTSP_Hinh_Anh;
	int CTSP_Luot_Mua,CTSP_So_Luong;
}
