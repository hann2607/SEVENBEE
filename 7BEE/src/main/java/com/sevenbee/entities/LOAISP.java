package com.sevenbee.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LOAISP")
public class LOAISP {
	@Id
	String LoaiSP_MA;
	String LoaiSP_Ten;
	@OneToMany
	@JoinColumn(name = "LoaiSP_MA")
	List<SANPHAM> sanpham;
}
