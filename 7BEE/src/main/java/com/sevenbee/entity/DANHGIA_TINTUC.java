package com.sevenbee.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedEntityGraphs;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DANHGIA_TINTUC")
public class DANHGIA_TINTUC {
	@Id
	String DG_TT_MA;
	String TT_MA, DG_TTNoiDung;
	
	@ManyToOne
	@JoinColumn(name="SDT")
	NGUOIDUNG SDT;
	
	@ManyToOne
	TINTUC tintuc;
}
