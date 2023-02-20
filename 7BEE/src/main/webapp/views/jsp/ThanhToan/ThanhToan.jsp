<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="breadcrumb-area">
	<div class="container">
		<div class="breadcrumb-content">
			<ul>
				<li><a href="/">TRANG CHỦ</a></li>
				<li class="active">THANH TOÁN</li>
			</ul>
		</div>
	</div>
</div>
<!-- Li's Breadcrumb Area End Here -->
<!--Checkout Area Strat-->
<div class="checkout-area pt-60 pb-30">
	<div class="container">
		<form class="needs-validation" novalidate>
			<div class="row">
				<div class="col-lg-6 col-12">

					<div class="checkbox-form">
						<h3>Chi Tiết Thanh Toán</h3>
						<div class="different-address">
							<div class="order-notes">
								<div class="checkout-form-list">
									<label class="font-weight-bold" for="validationCustom01">Họ
										Và Tên</label> <input type="text" class="form-control"
										id="validationCustom01" placeholder="" required>
									<div class="invalid-feedback">Vui lòng nhập thông tin đầy
										đủ!</div>
									<label class="font-weight-bold" for="validationCustom">Địa
										Chỉ</label> <input type="text" class="form-control"
										id="validationCustom" placeholder="" required>
									<div class="invalid-feedback">Vui lòng nhập thông tin đầy
										đủ!</div>
									<label class="font-weight-bold" for="validationCustom02">Số
										điện thoại</label> <input type="text" class="form-control"
										id="validationCustom02" placeholder="" required>
									<div class="invalid-feedback">Vui lòng nhập thông tin đầy
										đủ!</div>
									<label class="font-weight-bold">Ghi chú Đơn Hàng</label>
									<textarea id="checkout-mess" cols="30" rows="10" placeholder=""></textarea>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="col-lg-6 col-12">
					<div class="your-order">
						<h3>Đơn Đặt Hàng Của Bạn</h3>
						<div class="your-order-table table-responsive">
							<table class="table">
								<thead>
									<tr>
										<th class="cart-product-name">Sản Phẩm</th>
										<th class="cart-product-name">Số Lượng</th>
										<th class="cart-product-total">Tổng</th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach var="product" items="${listcarts}">
										<tr class="cart_item">
											<td class="cart-product-name">${product.value.SP_TenSP}</td>
											<td class="product-quantity"> × ${product.value.SP_SoLuong} </td>
											<td class="cart-product-total"><span class="amount"><fmt:formatNumber
													type="number" value="${product.value.SP_Gia * product.value.SP_SoLuong}"></fmt:formatNumber></span> VND</td>
										</tr>
									</c:forEach>
								</tbody>
								<tfoot>
									<tr class="cart-subtotal">
										<th>Tổng Phụ của Giỏ Hàng</th>
										<td></td>
										<td><span class="amount"><fmt:formatNumber type="number"
												value="${sumtotal}"></fmt:formatNumber></span> VND</td>
									</tr>
									<tr class="order-total">
										<th>Tổng Số Đơn Đặt Hàng</th>
										<td></td>
										<td><strong><span class="amount"><fmt:formatNumber type="number"
												value="${sumtotal}"></fmt:formatNumber></span></strong> VND</td>
									</tr>
								</tfoot>
							</table>
						</div>
						<div class="payment-method">
							<div class="order-button-payment">
								<input value="ĐẶT HÀNG" type="submit">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>