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
									<c:if test="${not empty user}">
										<ul class="ht-setting-list">
											<div class="d-flex justify-content-center">
												<img src="/views/images/team/${user.getHinhanh()}" alt=""
													height="100px"
													style="border-radius: 50%; border: 2px solid black;">
											</div>
											<div class="d-flex justify-content-center mt-2">${user.getHo_ten()}
											</div>
											<div class="d-flex justify-content-center">
												<div style="color: #ccc;"># ${user.isVaitro() ? 'Admin' : 'Người dùng' }</div>
											</div>
											<hr class="mt-3 mb-2">
											<li class="d-flex justify-content-center"><a
												href="/user/profile">TÀI KHOẢN</a></li>
											<li class="d-flex justify-content-center"><a
												href="login-register.html">LỊCH SỬ</a></li>
											<li class="d-flex justify-content-center"><a
												href="/logout">ĐĂNG XUẤT</a></li>

										</ul>
									</c:if>
									<c:if test="${not empty partnerCK}">
										<ul class="ht-setting-list">
											<div class="d-flex justify-content-center">
												<img src="/views/images/team/${partnerCK.getHinhanh()}" alt=""
													height="100px"
													style="border-radius: 50%; border: 2px solid black;">
											</div>
											<div class="d-flex justify-content-center mt-2">${partnerCK.getShop_TenShop()}
											</div>
											<%-- <div class="d-flex justify-content-center">
												<div style="color: #ccc;"># ${user.isVaitro() ? 'Admin' : 'Người dùng' }</div>
											</div> --%>
											<hr class="mt-3 mb-2">
											<li class="d-flex justify-content-center"><a
												href="">TÀI KHOẢN</a></li>
											<li class="d-flex justify-content-center"><a
												href="/partner">CỬA HÀNG</a></li>
											<li class="d-flex justify-content-center"><a
												href="/logout">ĐĂNG XUẤT</a></li>

										</ul>
									</c:if>
									<c:if test="${empty user || empty partnerCK}">
										<ul class="ht-setting-list">
											<li class="d-flex justify-content-center"><a
												href="/login">ĐĂNG NHẬP</a></li>
											<li class="d-flex justify-content-center"><a
												href="/login-partner">PARTNER</a></li>
										</ul>
									</c:if>
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
					<form action="/shop/search" class="hm-searchbox" method="get">
						<select class="nice-select select-search-category"
							name="selectedSearch">
							<option value="all">All</option>
							<option value="DT">ĐỒ ĐIỆN TỬ</option>
							<option value="TT">THỜI TRANG</option>
							<option value="DADU">ĐỒ ĂN & ĐỒ UỐNG</option>
							<option value="FPOLY">ĐỒ DÙNG FPOLY</option>

						</select> <input type="text" placeholder="Nhập để tìm kiếm ..."
							name="SearchValue">
						<button class="li-btn" type="submit" formaction="/shop/search">
							<i class="fa fa-search"></i>
						</button>
					</form>
					<!-- Header Middle Searchbox Area End Here -->
					<!-- Begin Header Middle Right Area -->
					<div class="header-middle-right">
						<ul class="hm-menu">
							<!-- Begin Header Middle Wishlist Area -->
							<li class="hm-wishlist"><a href="#"> <span
									class="cart-item-count wishlist-item-count">0</span> <i
									class="fa fa-heart-o"></i>
							</a></li>
							<!-- Header Middle Wishlist Area End Here -->
							<!-- Begin Header Mini Cart Area -->
							<li class="hm-minicart">
								<div class="hm-minicart-trigger">
									<span class="item-icon"></span> <span class="item-text">GIỎ
										HÀNG <span class="cart-item-count">${Carts == null ? '0' : totalProductInCart}</span>
									</span>
								</div>
								<div class="minicart">
									<c:forEach var="product" items="${Carts}">
										<ul class="minicart-product-list">

											<li><a href="single-product.html"
												class="minicart-product-image"> <img
													src="/views/images/product/large-size/${product.value.SP_HinhAnh}"
													alt="cart products">
											</a>
												<div class="minicart-product-details">
													<h6>
														<a href="single-product.html">${product.value.SP_TenSP}</a>
													</h6>
													<div class="d-flex justify-content-between">
														<span>x ${product.value.SP_SoLuong}</span>
														<div>
															<span><fmt:formatNumber type="number"
																	value="${product.value.SP_Gia}"></fmt:formatNumber></span><span>
																VNĐ</span>
														</div>
													</div>

												</div>
												<form action="/removeCart/${product.value.SP_MA}"
													method="post" style="display: flex; text-align: center;">
													<button type="submit"
														style="color: #212529; background: none; border: none; cursor: pointer;">
														<i class="fa fa-close"></i>
													</button>
												</form></li>
										</ul>
									</c:forEach>
									<h6 class="my-3 d-flex justify-content-between">
										TỔNG TIỀN: <span><span><fmt:formatNumber
													type="number" value="${sumtotal}"></fmt:formatNumber></span><span>
												VNĐ</span></span>

									</h6>
									<div class="minicart-button">
										<a href="/ShoppingCart"
											class="li-button li-button-dark li-button-fullwidth li-button-sm">
											<span>XEM GIỎ HÀNG</span>
										</a> <a href="/checkout"
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