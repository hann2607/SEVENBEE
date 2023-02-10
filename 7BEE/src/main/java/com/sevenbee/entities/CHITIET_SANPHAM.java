package com.sevenbee.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	String CTSP_MoTa, Kich_Thuoc, CTSP_Mau;
	int CTSP_LuotMua, CTSP_SoLuong;

	@OneToMany(mappedBy = "ctsanpham")
	private Set<SANPHAM> sanpham;
}
