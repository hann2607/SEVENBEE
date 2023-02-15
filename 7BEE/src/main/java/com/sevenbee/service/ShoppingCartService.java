package com.sevenbee.service;

import java.util.Map;



import com.sevenbee.entities.DONHANG;
import com.sevenbee.entities.SANPHAM;

public interface ShoppingCartService {
	// Thêm mặt hàng vào giỏ hoặc tăng số lượng lên 1 nếu đã tồn tại
	void addProduct(String SP_MA);
	//xóa mặt hàng khỏi giỏ hàng
	void removeProduct(String SP_MA);
	//thay đổi số lượng của mặt hàng trong giỏ
	void updateProduct(String SP_MA, int qty);
	//xóa sạch các mặt hàng trong giỏ
	void clear();
	//lấy tất cả các mặt hàng trong giỏ
	Map<String, SANPHAM> getProducts();
	//lấy tổng số lượng các mặt hàng trong giỏ
	int getCount();
	//lấy tổng số tiền tất cả các mặt hàng trong giỏ
	double getAmount();
}
