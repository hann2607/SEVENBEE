<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Begin Slider With Banner Area -->
<div class="breadcrumb-area">
	<div class="container">
		<div class="breadcrumb-content">
			<ul>
				<li><a href="/">TRANG CHỦ</a></li>
				<li class="active">GIỎ HÀNG</li>
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
								<c:forEach var="product" items="${Carts != null ? Carts : ''}">
									<input value="${product.value.SP_Gia}" hidden="true"
										id="price${product.value.SP_MA}">
									<tr>
										<td class="li-product-remove"><a
											href="/removeCart/${product.value.SP_MA}"><i
												class="fa fa-times"></i></a></td>
										<td class="li-product-thumbnail"><a
											href="/product-detail/${product.value.SP_MA}"><img
												src="/views/images/product/large-size/${product.value.SP_HinhAnh}"
												alt="Li's Product Image" height="100px"></a></td>
										<td class="li-product-name"><a href="#">${product.value.SP_TenSP}</a></td>
										<td class="li-product-price"><span class="amount"><fmt:formatNumber
													type="number" value="${product.value.SP_Gia}"></fmt:formatNumber></span>
											VND</td>
										<td class="quantity changeQuantity"
											data-masp="${product.value.SP_MA}" onclick="dem(this)">
											<div class="cart-plus-minus">
												<input class="cart-plus-minus-box quantityShopCart"
													value="${product.value.SP_SoLuong}"
													id="${product.value.SP_MA}" type="number">
												<div class="dec qtybutton">
													<i class="fa fa-angle-down"></i>
												</div>
												<div class="inc qtybutton">
													<i class="fa fa-angle-up"></i>
												</div>
											</div>
										</td>
										<td class="product-subtotal"><span class="amount"
											id="amount${product.value.SP_MA}"><fmt:formatNumber
													type="number"
													value="${product.value.SP_Gia * product.value.SP_SoLuong}"></fmt:formatNumber></span>
											VND</td>
									</tr>
								</c:forEach>
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

									<a href="/clearCart">XÓA GIỎ HÀNG</a>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-5 ml-auto">
							<div class="cart-page-total">
								<h2>Tổng số giỏ hàng</h2>
								<ul>
									<li>Tổng phụ <span><fmt:formatNumber type="number"
												value="${sumtotal}"></fmt:formatNumber> VND</span>
									</li>
									<li>Tổng cộng <span><fmt:formatNumber type="number"
												value="${sumtotal}"></fmt:formatNumber> VND</span>
									</li>
								</ul>
								<a href="/checkout">THANH TOÁN</a>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	// $(document).ready(function() {
	// 	$(document).on("click", ".changeQuantity", function() {
	// 		console.log("abc")
	// 		$.ajax({
	// 			url: '/updateCart/' + this.dataset.masp,
	// 			type: 'GET',
	// 			success: function(data) {
	// 				// Handle successful response
	// 			},

	// 			error: function(jqXHR, textStatus, errorThrown) {
	// 				// Handle error response
	// 				console.log(errorThrown);
	// 			}
	// 		});
	// 	});
	// });

	var dem = function(index) {
		$.ajax({
			url : '/updateCart/' + index.dataset.masp + '/'
					+ document.getElementById(index.dataset.masp).value,
			type : 'GET',
			success : function(data) {
				// Handle successful response
				location.reload(true);
			},

			error : function(jqXHR, textStatus, errorThrown) {
				// Handle error response
				console.log(errorThrown);
			}
		});
	}
</script>
<!-- Begin Quick View | Modal Area End Here-->
