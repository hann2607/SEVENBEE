package com.sevenbee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sevenbee.entities.DONHANG;

public interface DONHANGDAO extends JpaRepository<DONHANG, String> {
	// Lấy ra danh sách sản phẩm bán chạy nhất
//		@Query("SELECT sp FROM SANPHAM sp WHERE sp.SP_MA IN (SELECT dh FROM DONHANG dh GROUP BY dh.SP_MA ORDER BY COUNT(dh.SP_MA) LIMIT 6)")
//		List<SANPHAM> findByBestSellerProducts(); 
}
