package com.sevenbee.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DONHANG_SANPHAM")
public class DONHANG_SANPHAM {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long DHSP_ID;
	
	@ManyToOne @JoinColumn(name = "DH_MA")
	DONHANG donhang;
	@ManyToOne @JoinColumn(name = "SP_MA")
	SANPHAM sanpham;

}
