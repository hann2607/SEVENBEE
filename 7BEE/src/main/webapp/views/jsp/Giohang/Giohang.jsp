<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Begin Slider With Banner Area -->
<div class="breadcrumb-area">
	<div class="container">
		<div class="breadcrumb-content">
			<ul>
				<li><a href="/home">Trang chủ</a></li>
				<li class="active">Giỏ hàng</li>
			</ul>
		</div>
	</div>
</div>
<!-- Li's Breadcrumb Area End Here -->
<!--Shopping Cart Area Strat-->
<div class="Shopping-cart-area pt-60 pb-60">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form action="#">
					<div class="table-content table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th class="li-product-remove">Bỏ chọn</th>
									<th class="li-product-thumbnail">Hình ảnh</th>
									<th class="cart-product-name">Tên sản phẩm</th>
									<th class="li-product-price">Đơn giá</th>
									<th class="li-product-quantity">Số lượng</th>
									<th class="li-product-subtotal">Thành tiền</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<c:forEach var="product" items="${listcarts}">
										<td class="li-product-remove"><a
											href="/removeCart/${product.value.SP_MA}"><i
												class="fa fa-times"></i></a></td>
										<td class="li-product-thumbnail"><a
											href="/product-detail/${product.value.SP_MA}"><img
												src="/views/images/product/small-size/${product.value.SP_HinhAnh}"
												alt="Li's Product Image"></a></td>
										<td class="li-product-name"><a href="#">${product.value.SP_TenSP}</a></td>
										<td class="li-product-price"><span class="amount">${product.value.SP_Gia }</span> VND</td>
										<td class="quantity">
											<div class="cart-plus-minus">
												<input class="cart-plus-minus-box" value="${product.value.SP_SoLuong}" type="text">
												<div class="dec qtybutton">
													<i class="fa fa-angle-down"></i>
												</div>
												<div class="inc qtybutton">
													<i class="fa fa-angle-up"></i>
												</div>
											</div></td>
										<td class="product-subtotal"><span class="amount"><fmt:formatNumber
													type="number"
													value="${product.value.SP_SoLuong * product.value.SP_Gia}"></fmt:formatNumber></span>
											VND</td>
									</c:forEach>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="row">
						<div class="col-12">
							<div class="coupon-all">
								<div class="coupon">
									<input id="coupon_code" class="input-text" name="coupon_code"
										value="" placeholder="Nhập mã giảm giá" type="text">
									<input class="button" name="apply_coupon" value="ADD CODE"
										type="submit">
								</div>
								<div class="coupon2">
									<input class="button" name="update_cart"
										value="Restart giỏ hàng" type="submit">
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-5 ml-auto">
							<div class="cart-page-total">
								<h2>Tổng số giỏ hàng</h2>
								<ul>
									<li>Tổng phụ <span> VND</span> 0
									</li>
									<li>Tổng cộng <span> VND</span> 0
									</li>
								</ul>
								<a href="#">Tiến hành kiểm tra</a>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- Begin Quick View | Modal Area End Here-->
