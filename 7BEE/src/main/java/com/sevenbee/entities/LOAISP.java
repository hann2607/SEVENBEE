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
@Table(name = "LOAISP")
public class LOAISP {
	@Id
	String LoaiSP_MA;
	String LoaiSP_Ten;
}
