package com.sevenbee.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sevenbee.entity.SANPHAM;

public interface SANPHAMDAO extends JpaRepository<SANPHAM, String> {
	// Lấy ra danh sách sản phẩm mới nhất
	@Query("SELECT sp FROM SANPHAM sp ORDER BY sp.SP_Ngaydang DESC LIMIT ?1")
	List<SANPHAM> findByLatestProducts(int limit);

	// Lấy ra danh sách sản phẩm theo loại mới nhất
	@Query("SELECT sp FROM SANPHAM sp WHERE sp.loaisp.LoaiSP_MA=?1 ORDER BY sp.SP_Ngaydang DESC LIMIT ?2")
	List<SANPHAM> findProductsByLoaiSP(String LoaiSP_MA, int limit);

	// Tìm sản phẩm theo mã
	@Query("SELECT sp FROM SANPHAM sp WHERE sp.SP_MA=?1")
	SANPHAM findProductBySP_MA(String masp);

	// Lấy ra danh sách sản phẩm theo loại
	@Query("SELECT sp FROM SANPHAM sp WHERE sp.loaisp.LoaiSP_MA=?1")
	Page<SANPHAM> findProductsByLoaiSPAndPage(String LoaiSP_MA, Pageable pageable);

	// Lấy ra danh sách sản phẩm theo 1 loại sản phẩm
	@Query("SELECT sp FROM SANPHAM sp WHERE sp.SP_TenSP LIKE ?1")
	Page<SANPHAM> findProductsBy1LoaiSPAndPage(String LoaiSP_MA, Pageable pageable);

	// Lấy ra danh sách sản phẩm theo 2 loại sản phẩm
	@Query("SELECT sp FROM SANPHAM sp WHERE sp.SP_TenSP LIKE ?1 OR sp.SP_TenSP LIKE ?2")
	Page<SANPHAM> findProductsBy2LoaiSPAndPage(String LoaiSP_MA1, String LoaiSP_MA2, Pageable pageable);

}
