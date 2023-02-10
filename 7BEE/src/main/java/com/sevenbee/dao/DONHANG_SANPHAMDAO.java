package com.sevenbee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sevenbee.entities.DONHANG_SANPHAM;

public interface DONHANG_SANPHAMDAO extends JpaRepository<DONHANG_SANPHAM, Long> {
	// Lấy ra danh sách sản phẩm bán chạy nhất
	@Query("SELECT dhsp FROM DONHANG_SANPHAM dhsp GROUP BY dhsp ORDER BY COUNT(dhsp) DESC LIMIT 6")
	List<DONHANG_SANPHAM> findByBestSellerProducts(); 
}
