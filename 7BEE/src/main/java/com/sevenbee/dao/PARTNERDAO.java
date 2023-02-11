package com.sevenbee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sevenbee.entities.PARTNER;

public interface PARTNERDAO extends JpaRepository<PARTNER, String>{
	// Lấy ra danh sách sản phẩm theo SHOP mới nhất
	@Query("SELECT shop FROM PARTNER shop ORDER BY NEWID() LIMIT ?1")
	List<PARTNER> findProductsByShopRandom(int limit);
}
