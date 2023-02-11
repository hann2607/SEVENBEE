package com.sevenbee.service;

import java.util.Map;



import com.sevenbee.entities.DONHANG;

public interface ShoppingCartService {
	// Thêm mặt hàng vào giỏ hoặc tăng số lượng lên 1 nếu đã tồn tại
	void addProduct(Integer id);
	//xóa mặt hàng khỏi giỏ hàng
	void removeProduct(Integer id);
	//thay đổi số lượng của mặt hàng trong giỏ
	void updateProduct(Integer id, int qty);
	//xóa sạch các mặt hàng trong giỏ
	void clear();
	//lấy tất cả các mặt hàng trong giỏ
	Map<String, DONHANG> getProducts();
	//lấy tổng số lượng các mặt hàng trong giỏ
	int getCount();
	//lấy tổng số tiền tất cả các mặt hàng trong giỏ
	double getAmount();
}
