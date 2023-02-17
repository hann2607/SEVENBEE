<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Begin Header Area -->
<header class="li-header-4">
	<!-- Begin Header Top Area -->
	<div class="header-top">
		<div class="container">
			<div class="row">
				<!-- Begin Header Top Left Area -->
				<div class="col-lg-3 col-md-4">
					<div class="header-top-left">
						<ul class="phone-wrap">
							<li><span>HOTLINE: </span><a href="#">(+84) 9847 724 10</a></li>
						</ul>
					</div>
				</div>
				<!-- Header Top Left Area End Here -->
				<!-- Begin Header Top Right Area -->
				<div class="col-lg-9 col-md-8">
					<div class="header-top-right">
						<ul class="ht-menu">
							<!-- Begin Language Area -->
							<li><span class="language-selector-wrapper">NGÔN NGỮ
									:</span>
								<div class="ht-language-trigger">
									<span>TIẾNG VIỆT</span>
								</div>
								<div class="language ht-language">
									<ul class="ht-setting-list">
										<li class="active"><a href="#"><img
												src="/views/images/menu/flag-icon/1.jpg" alt="">TIẾNG
												ANH</a></li>
										<li><a href="#"><img
												src="/views/images/menu/flag-icon/2.png" alt="">TIẾNG
												VIỆT</a></li>
									</ul>
								</div></li>
							<!-- Language Area End Here -->
							<!-- Setting Area End Here -->
							<!-- Begin Currency Area -->
							<li><span class="currency-selector-wrapper">TIỀN TỆ :</span>
								<div class="ht-currency-trigger">
									<span>VNĐ đ</span>
								</div>
								<div class="currency ht-currency">
									<ul class="ht-setting-list">
										<li><a href="#">VNĐ đ</a></li>
										<li class="active"><a href="#">USD $</a></li>
									</ul>
								</div></li>
							<!-- Currency Area End Here -->
							<!-- Begin Setting Area -->
							<li>
								<div class="ht-setting-trigger">
									<span>TÀI KHOẢN</span>
								</div>
								<div class="setting ht-setting">
									<ul class="ht-setting-list">
										<div class="d-flex justify-content-center">
											<img
												src="https://shopgarena.net/wp-content/uploads/2022/08/Hinh-nen-Yasuo-chibi.jpg"
												alt="" height="100px"
												style="border-radius: 50%; border: 2px solid black;">
										</div>
										<div class="d-flex justify-content-center mt-2">${name}
										</div>
										<div class="d-flex justify-content-center">
											<div style="color: #ccc;">#Người dùng</div>
										</div>
										<hr class="mt-3 mb-2">
										<li class="d-flex justify-content-center"><a
											href="login-register.html">TÀI KHOẢN</a></li>
										<li class="d-flex justify-content-center"><a
											href="login-register.html">LỊCH SỬ</a></li>
										<li class="d-flex justify-content-center"><a
											href="/logout">ĐĂNG XUẤT</a></li>
										<li class="d-none justify-content-center"><a
											href="login-register.html">ĐĂNG NHẬP</a></li>
										<li class="d-none justify-content-center"><a
											href="login-register.html">ĐĂNG KÝ</a></li>
									</ul>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<!-- Header Top Right Area End Here -->
			</div>
		</div>
	</div>
	<!-- Header Top Area End Here -->
	<!-- Begin Header Middle Area -->
	<div class="header-middle pl-sm-0 pr-sm-0 pl-xs-0 pr-xs-0">
		<div class="container">
			<div class="row d-flex align-items-center">
				<!-- Begin Header Logo Area -->
				<div class="col-lg-3">
					<div class="logo pb-sm-30 pb-xs-30">
						<a href="/"> <img src="/views/images/menu/logo/logo-final.png"
							alt="">
						</a>
					</div>
				</div>
				<!-- Header Logo Area End Here -->
				<!-- Begin Header Middle Right Area -->
				<div class="col-lg-9 pl-0 ml-sm-15 ml-xs-15">
					<!-- Begin Header Middle Searchbox Area -->
					<form action="#" class="hm-searchbox">
						<select class="nice-select select-search-category">
							<option value="0">All</option>
							<option value="1">Đồ công nghệ</option>
							<option value="2">Đồ ăn, thực phẩm</option>
							<option value="3">Thời trang</option>
							<option value="4">Giải trí, thể thao</option>
							<option value="5">Đồ gia dụng nội thất</option>
							<option value="6">Bất động sản</option>
							<option value="7">Xe cộ</option>
							<option value="8">Việc làm</option>
							<option value="9">Thú cưng</option>
							<option value="10">Tủ lạnh, máy giặt</option>
							<option value="11">Đồ võ Fpoly</option>
							<option value="12">Sách cũ</option>

						</select> <input type="text" placeholder="Nhập để tìm kiếm ...">
						<button class="li-btn" type="submit">
							<i class="fa fa-search"></i>
						</button>
					</form>
					<!-- Header Middle Searchbox Area End Here -->
					<!-- Begin Header Middle Right Area -->
					<div class="header-middle-right">
						<ul class="hm-menu">
							<!-- Begin Header Middle Wishlist Area -->
							<li class="hm-wishlist"><a href="wishlist.html"> <span
									class="cart-item-count wishlist-item-count">0</span> <i
									class="fa fa-heart-o"></i>
							</a></li>
							<!-- Header Middle Wishlist Area End Here -->
							<!-- Begin Header Mini Cart Area -->
							<li class="hm-minicart">
								<div class="hm-minicart-trigger">
									<span class="item-icon"></span> <span class="item-text">80tr
										<span class="cart-item-count">2</span>
									</span>
								</div> <span></span>
								<div class="minicart">
									<ul class="minicart-product-list">
										<li><a href=""
											class="minicart-product-image"> <img
												src="/views/images/product/large-size/${product.SP_HinhAnh}"
												alt="cart products">
										</a>
											<div class="minicart-product-details">
												<h6>
													<a href="single-product.html"></a>
												</h6>
												<div class="d-flex justify-content-between">
													<span>${product.SP_SoLuong}</span>
													<div>
														<span><fmt:formatNumber type="number"
																value="${product.SP_Gia}"></fmt:formatNumber></span><span>
															VNĐ</span>
													</div>
												</div>

											</div>
											<button class="close">
												<i class="fa fa-close"></i>
											</button></li>
										<li><a href="single-product.html"
											class="minicart-product-image"> <img
												src="/views/images/product/small-size/2.jpg"
												alt="cart products">
										</a>
											<div class="minicart-product-details">
												<h6>
													<a href="single-product.html">Aenean eu tristique</a>
												</h6>
												<div class="d-flex justify-content-between">
													<span>x 1</span>
													<div>
														<span>40000000</span><span> VNĐ</span>
													</div>
												</div>

											</div>
											<button class="close">
												<i class="fa fa-close"></i>
											</button></li>
									</ul>
									<h6 class="my-3 d-flex justify-content-between">
										TỔNG TIỀN:
										<div>
											<span><fmt:formatNumber type="number"
													value=""></fmt:formatNumber></span><span>
												VNĐ</span>
										</div>
									</h6>
									<div class="minicart-button">
										<a href="/ShoppingCart"
											class="li-button li-button-dark li-button-fullwidth li-button-sm">
											<span>XEM GIỎ HÀNG</span>
										</a> <a href="checkout.html"
											class="li-button li-button-fullwidth li-button-sm"> <span>THANH
												TOÁN</span>
										</a>
									</div>
								</div>
							</li>
							<!-- Header Mini Cart Area End Here -->
						</ul>
					</div>
					<!-- Header Middle Right Area End Here -->
				</div>
				<!-- Header Middle Right Area End Here -->
			</div>
		</div>
	</div>
	<!-- Header Middle Area End Here -->
	<!-- Begin Header Bottom Area -->
	<div
		class="header-bottom header-sticky stick d-none d-lg-block d-xl-block">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<!-- navbar -->
					<jsp:include page="/views/jsp/navbar/navbar.jsp"></jsp:include>
					<!-- End navbar -->
				</div>
			</div>
		</div>
	</div>
	<!-- Header Bottom Area End Here -->
	<!-- Begin Mobile Menu Area -->
	<div
		class="mobile-menu-area mobile-menu-area-4 d-lg-none d-xl-none col-12">
		<div class="container">
			<div class="row">
				<div class="mobile-menu"></div>
			</div>
		</div>
	</div>
	<!-- Mobile Menu Area End Here -->
</header>
<!-- Header Area End Here -->