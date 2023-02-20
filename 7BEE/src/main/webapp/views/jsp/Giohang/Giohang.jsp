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
								<c:forEach var="product" items="${listcarts}">
								<input value="${product.value.SP_Gia}" hidden="true" id="price${product.value.SP_MA}">
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
										<td class="quantity">
											<div class="cart-plus-minus">
												<input data-masp=${product.value.SP_MA } class="soluongdocnhat cart-plus-minus-box" id="${product.value.SP_MA}" onchange="dem('${product.value.SP_MA}')"
													value="${product.value.SP_SoLuong}" type="number">
<!-- 												<div class="dec qtybutton" > -->
<%-- 													<i class="fa fa-angle-down" onclick="dem('${product.value.SP_MA}')"></i> --%>
<!-- 												</div> -->
<!-- 												<div class="inc qtybutton" > -->
<%-- 													<i class="fa fa-angle-up" onclick="dem('${product.value.SP_MA}')"></i> --%>
<!-- 												</div> -->
											</div>
										</td>
										<td class="product-subtotal"><span class="amount" id="amount${product.value.SP_MA}"><fmt:formatNumber
													type="number" value="${product.value.SP_Gia * product.value.SP_SoLuong}"></fmt:formatNumber></span>
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
									<input  class="button" name="update_cart"
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

<script text= "text/javascript">
	var dem = function(index){
		document.getElementById('amount' + index).innerText = document.getElementById(index).value * document.getElementById('price' + index).value;
	}
	
	$(document).ready( function() {
		$(document).on("click", ".quick-view", function() {
		$.ajax({
			url : '/api/Quick-view/' + this.dataset.masp,
				type : 'GET',
					success : function(data) {
						// Handle successful response
							var arrSP = data.split("-*-");
							var sanpham = JSON.parse(arrSP[0]);
							$('#exampleModalCenter #QVNameProduct').text(sanpham.SP_TenSP.toUpperCase());
							$('#exampleModalCenter #QuickViewPrice').text(commify(sanpham.SP_Gia));
							$('#exampleModalCenter #image1').prop('src', '/views/images/product/large-size/' + sanpham.SP_HinhAnh);
							$('#exampleModalCenter #QuickViewModalLoaiSP').text(arrSP[1]);
							$('#exampleModalCenter #QuickViewmodalmotaSP').text(arrSP[2]);
							
							},
							
							error : function(jqXHR, textStatus, errorThrown) {
							// Handle error response
							console.log(errorThrown);
							}
		});
	});
});


function commify(n) {
	var parts = n.toString().split(".");
	const numberPart = parts[0];
	const decimalPart = parts[1];
	const thousands = /\B(?=(\d{3})+(?!\d))/g;
	return numberPart.replace(thousands, ".")
			+ (decimalPart ? "," + decimalPart : "");
}

</script>
<!-- Begin Quick View | Modal Area End Here-->
