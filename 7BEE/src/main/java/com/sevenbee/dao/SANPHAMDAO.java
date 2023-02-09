package com.sevenbee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sevenbee.entities.SANPHAM;

public interface SANPHAMDAO extends JpaRepository<SANPHAM, String>{
	// Lấy ra danh sách sản phẩm mới nhất
	@Query("SELECT sp FROM SANPHAM sp ORDER BY sp.SP_Ngaydang DESC LIMIT 6")
	List<SANPHAM> findByLatestProducts(); 
}
