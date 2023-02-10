<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- Begin Slider With Banner Area -->
<div class="slider-with-banner">
	<div class="container">
		<div class="row">
			<!-- Begin Slider Area -->
			<div class="col-lg-8 col-md-8">
				<div class="slider-area pt-sm-30 pt-xs-30">
					<div class="slider-active owl-carousel">
						<!-- Begin Single Slide Area -->
						<div
							class="single-slide align-center-left animation-style-01 bg-1">
							<div class="slider-progress"></div>
							<div class="slider-content">
								<h5>
									Giảm tới <span>-20%</span> Trong tuần này
								</h5>
								<h2>Chamcham Galaxy S9 | S9+</h2>
								<h3>
									Giả chỉ còn <span>10000000</span> <span> VNĐ</span>
								</h3>
								<div class="default-btn slide-btn">
									<a class="links" href="#">MUA
										NGAY</a>
								</div>
							</div>
						</div>
						<!-- Single Slide Area End Here -->
						<!-- Begin Single Slide Area -->
						<div
							class="single-slide align-center-left animation-style-02 bg-2">
							<div class="slider-progress"></div>
							<div class="slider-content">
								<h5>
									Bắt đầu từ <span>Black Friday</span>
								</h5>
								<h2>Work Desk Surface Studio 2018</h2>
								<h3>
									Giá chỉ còn <span>12000000</span> <span> VNĐ</span>
								</h3>
								<div class="default-btn slide-btn">
									<a class="links" href="#">MUA
										NGAY</a>
								</div>
							</div>
						</div>
						<!-- Single Slide Area End Here -->
						<!-- Begin Single Slide Area -->
						<div
							class="single-slide align-center-left animation-style-01 bg-3">
							<div class="slider-progress"></div>
							<div class="slider-content">
								<h5>
									Giảm tới <span>-10%</span> Trong tuần này
								</h5>
								<h2>Phantom 4 Pro+ Obsidian</h2>
								<h3>
									Giá chỉ còn <span>7000000</span> <span> VNĐ</span>
								</h3>
								<div class="default-btn slide-btn">
									<a class="links" href="#">MUA
										NGAY</a>
								</div>
							</div>
						</div>
						<!-- Single Slide Area End Here -->
					</div>
				</div>
			</div>
			<!-- Slider Area End Here -->
			<!-- Begin Li Banner Area -->
			<div class="col-lg-4 col-md-4 text-center pt-sm-30 pt-xs-30">
				<div class="li-banner">
					<a href="#"> <img src="/views/images/banner/1_1.jpg" alt="">
					</a>
				</div>
				<div class="li-banner mt-15 mt-md-30 mt-xs-25 mb-xs-5">
					<a href="#"> <img src="/views/images/banner/1_2.jpg" alt="">
					</a>
				</div>
			</div>
			<!-- Li Banner Area End Here -->
		</div>
	</div>
</div>
<!-- Slider With Banner Area End Here -->
<!-- Begin Static Top Area -->
<div class="static-top-wrap">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="static-top-content mt-sm-30">Khai xuân 2023 giảm
					lên tới 10% tất cả mặt hàng!</div>
			</div>
		</div>
	</div>
</div>
<!-- Static Top Area End Here -->
<!-- product-area start -->
<div class="product-area pt-55 pb-25 pt-xs-50">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="li-product-tab">
					<ul class="nav li-product-menu">
						<li><a class="active" data-toggle="tab"
							href="#li-new-product"><span>SẢN PHẨM MỚI</span></a></li>
						<li><a data-toggle="tab" href="#li-bestseller-product"><span>BÁN
									CHẠY NHẤT</span></a></li>
						<li><a data-toggle="tab" href="#li-featured-product"><span>SẮP
									RA MẮT</span></a></li>
					</ul>
				</div>
				<!-- Begin Li's Tab Menu Content Area -->
			</div>
		</div>
		<div class="tab-content">
			<div id="li-new-product" class="tab-pane active show" role="tabpanel">
				<div class="row">
					<div class="product-active owl-carousel">
						<c:forEach var="product" items="${LatestProducts}">
							<div class="col-lg-12">
								<!-- single-product-wrap start -->
								<div class="single-product-wrap">
									<div class="product-image">
										<a href="/product-detail?id=${product.SP_MA}"> <img
											src="/views/images/product/large-size/${product.SP_HinhAnh}"
											alt="Li's Product Image">
										</a> <span class="sticker">MỚI</span>
									</div>
									<div class="product_desc">
										<div class="product_desc_info">
											<div class="product-review">
												<h5 class="manufacturer">
													<a href="#">${product.loaisp.getLoaiSP_Ten()}</a>
												</h5>
												<div class="rating-box">
													<ul class="rating">
														<li><i class="fa fa-star-o"></i></li>
														<li><i class="fa fa-star-o"></i></li>
														<li><i class="fa fa-star-o"></i></li>
														<li class="no-star"><i class="fa fa-star-o"></i></li>
														<li class="no-star"><i class="fa fa-star-o"></i></li>
													</ul>
												</div>
											</div>
											<h4>
												<a class="product_name" href="/product-detail?id=${product.SP_MA}">${product.SP_TenSP}</a>
											</h4>
											<div class="price-box">
												<span class="new-price"><fmt:formatNumber
														type="number" value="${product.SP_Gia}"></fmt:formatNumber></span><span>
													VNĐ</span>
											</div>
										</div>
										<div class="add-actions">
											<ul class="add-actions-link">
												<li class="add-cart active"><a href="/addCart?id=${product.SP_MA}">THÊM VÀO
														GIỎ</a></li>
												<li><a class="links-details"
													href="#"><i
														class="fa fa-heart-o"></i></a></li>
												<li><a class="quick-view" data-toggle="modal"
													data-target="#exampleModalCenter" href="#"><i
														class="fa fa-eye"></i></a></li>
											</ul>
										</div>
									</div>
								</div>
								<!-- single-product-wrap end -->
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div id="li-bestseller-product" class="tab-pane" role="tabpanel">
				<div class="row">
					<div class="product-active owl-carousel">
						<c:forEach var="dhsp" items="${BestSellerProducts}">
							<div class="col-lg-12">
								<!-- single-product-wrap start -->
								<div class="single-product-wrap">
									<div class="product-image">
										<a href="/product-detail?id=${dhsp.sanpham.SP_MA}"> <img
											src="/views/images/product/large-size/${dhsp.sanpham.SP_HinhAnh}"
											alt="Li's Product Image">
										</a> <span class="sticker">MỚI</span>
									</div>
									<div class="product_desc">
										<div class="product_desc_info">
											<div class="product-review">
												<h5 class="manufacturer">
													<a href="#">${dhsp.sanpham.loaisp.getLoaiSP_Ten()}</a>
												</h5>
												<div class="rating-box">
													<ul class="rating">
														<li><i class="fa fa-star-o"></i></li>
														<li><i class="fa fa-star-o"></i></li>
														<li><i class="fa fa-star-o"></i></li>
														<li class="no-star"><i class="fa fa-star-o"></i></li>
														<li class="no-star"><i class="fa fa-star-o"></i></li>
													</ul>
												</div>
											</div>
											<h4>
												<a class="product_name" href="/product-detail?id=${dhsp.sanpham.SP_MA}">${dhsp.sanpham.SP_TenSP}</a>
											</h4>
											<div class="price-box">
												<span class="new-price"><fmt:formatNumber
														type="number" value="${dhsp.sanpham.SP_Gia}"></fmt:formatNumber></span><span>
													VNĐ</span>
											</div>
										</div>
										<div class="add-actions">
											<ul class="add-actions-link">
												<li class="add-cart active"><a href="/addCart?id=${dhsp.sanpham.SP_MA}">THÊM VÀO
														GIỎ</a></li>
												<li><a class="links-details"
													href="#"><i
														class="fa fa-heart-o"></i></a></li>
												<li><a class="quick-view" data-toggle="modal"
													data-target="#exampleModalCenter" href="#"><i
														class="fa fa-eye"></i></a></li>
											</ul>
										</div>
									</div>
								</div>
								<!-- single-product-wrap end -->
							</div>
						</c:forEach>

					</div>
				</div>
			</div>
			<div id="li-featured-product" class="tab-pane" role="tabpanel">
				<div class="row">
					<div class="product-active owl-carousel">
						<c:forEach var="product" items="${LatestProducts}">
							<div class="col-lg-12">
								<!-- single-product-wrap start -->
								<div class="single-product-wrap">
									<div class="product-image">
										<a href="/product-detail?id=${product.SP_MA}"> <img
											src="/views/images/product/large-size/${product.SP_HinhAnh}"
											alt="Li's Product Image">
										</a> <span class="sticker">MỚI</span>
									</div>
									<div class="product_desc">
										<div class="product_desc_info">
											<div class="product-review">
												<h5 class="manufacturer">
													<a href="#">${product.loaisp.getLoaiSP_Ten()}</a>
												</h5>
												<div class="rating-box">
													<ul class="rating">
														<li><i class="fa fa-star-o"></i></li>
														<li><i class="fa fa-star-o"></i></li>
														<li><i class="fa fa-star-o"></i></li>
														<li class="no-star"><i class="fa fa-star-o"></i></li>
														<li class="no-star"><i class="fa fa-star-o"></i></li>
													</ul>
												</div>
											</div>
											<h4>
												<a class="product_name" href="/product-detail?id=${product.SP_MA}">${product.SP_TenSP}</a>
											</h4>
											<div class="price-box">
												<span class="new-price"><fmt:formatNumber
														type="number" value="${product.SP_Gia}"></fmt:formatNumber></span><span>
													VNĐ</span>
											</div>
										</div>
										<div class="add-actions">
											<ul class="add-actions-link">
												<li class="add-cart active"><a href="/addCart?id=${product.SP_MA}">THÊM VÀO
														GIỎ</a></li>
												<li><a class="links-details"
													href="#"><i
														class="fa fa-heart-o"></i></a></li>
												<li><a class="quick-view" data-toggle="modal"
													data-target="#exampleModalCenter" href="#"><i
														class="fa fa-eye"></i></a></li>
											</ul>
										</div>
									</div>
								</div>
								<!-- single-product-wrap end -->
							</div>
						</c:forEach>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- product-area end -->
<!-- Begin Li's Static Banner Area -->
<div class="li-static-banner li-static-banner-4 text-center pt-20">
	<div class="container">
		<div class="row">
			<!-- Begin Single Banner Area -->
			<div class="col-lg-6">
				<div class="single-banner pb-sm-30 pb-xs-30">
					<a href="#"> <img src="/views/images/banner/2_3.jpg"
						alt="Li's Static Banner">
					</a>
				</div>
			</div>
			<!-- Single Banner Area End Here -->
			<!-- Begin Single Banner Area -->
			<div class="col-lg-6">
				<div class="single-banner">
					<a href="#"> <img src="/views/images/banner/2_4.jpg"
						alt="Li's Static Banner">
					</a>
				</div>
			</div>
			<!-- Single Banner Area End Here -->
		</div>
	</div>
</div>
<!-- Li's Static Banner Area End Here -->
<!-- Begin Li's Laptop Product Area -->
<section
	class="product-area li-laptop-product pt-60 pb-45 pt-sm-50 pt-xs-60">
	<div class="container">
		<div class="row">
			<!-- Begin Li's Section Area -->
			<div class="col-lg-12">
				<div class="li-section-title">
					<h2>
						<span>ĐỒ CÔNG NGHỆ</span>
					</h2>
					<ul class="li-sub-category-list">
						<li class="active"><a href="shop-left-sidebar.html">LAPTOP</a></li>
						<li><a href="shop-left-sidebar.html">TV</a></li>
						<li><a href="shop-left-sidebar.html">ĐIỆN THOẠI</a></li>
					</ul>
				</div>
				<div class="row">
					<div class="product-active owl-carousel">
						<c:forEach var="product" items="${Products_DienTu}">
							<div class="col-lg-12">
								<!-- single-product-wrap start -->
								<div class="single-product-wrap">
									<div class="product-image">
										<a href="/product-detail?id=${product.SP_MA}"> <img
											src="/views/images/product/large-size/${product.SP_HinhAnh}"
											alt="Li's Product Image">
										</a> <span class="sticker">MỚI</span>
									</div>
									<div class="product_desc">
										<div class="product_desc_info">
											<div class="product-review">
												<h5 class="manufacturer">
													<a href="#">${product.loaisp.getLoaiSP_Ten()}</a>
												</h5>
												<div class="rating-box">
													<ul class="rating">
														<li><i class="fa fa-star-o"></i></li>
														<li><i class="fa fa-star-o"></i></li>
														<li><i class="fa fa-star-o"></i></li>
														<li class="no-star"><i class="fa fa-star-o"></i></li>
														<li class="no-star"><i class="fa fa-star-o"></i></li>
													</ul>
												</div>
											</div>
											<h4>
												<a class="product_name" href="/product-detail?id=${product.SP_MA}">${product.SP_TenSP}</a>
											</h4>
											<div class="price-box">
												<span class="new-price"><fmt:formatNumber
														type="number" value="${product.SP_Gia}"></fmt:formatNumber></span><span>
													VNĐ</span>
											</div>
										</div>
										<div class="add-actions">
											<ul class="add-actions-link">
												<li class="add-cart active"><a href="/addCart?id=${product.SP_MA}">THÊM VÀO
														GIỎ</a></li>
												<li><a class="links-details"
													href="#"><i
														class="fa fa-heart-o"></i></a></li>
												<li><a class="quick-view" data-toggle="modal"
													data-target="#exampleModalCenter" href="#"><i
														class="fa fa-eye"></i></a></li>
											</ul>
										</div>
									</div>
								</div>
								<!-- single-product-wrap end -->
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<!-- Li's Section Area End Here -->
		</div>
	</div>
</section>
<!-- Li's Laptop Product Area End Here -->
<!-- Begin Li's TV & Audio Product Area -->
<section
	class="product-area li-laptop-product li-tv-audio-product pb-45">
	<div class="container">
		<div class="row">
			<!-- Begin Li's Section Area -->
			<div class="col-lg-12">
				<div class="li-section-title">
					<h2>
						<span>THỜI TRANG</span>
					</h2>
					<ul class="li-sub-category-list">
						<li class="active"><a href="shop-left-sidebar.html">ÁO</a></li>
						<li><a href="shop-left-sidebar.html">QUẦN</a></li>
						<li><a href="shop-left-sidebar.html">GIÀY</a></li>
					</ul>
				</div>
				<div class="row">
					<div class="product-active owl-carousel">
						<c:forEach var="product" items="${Products_ThoiTrang}">
							<div class="col-lg-12">
								<!-- single-product-wrap start -->
								<div class="single-product-wrap">
									<div class="product-image">
										<a href="/product-detail?id=${product.SP_MA}"> <img
											src="/views/images/product/large-size/${product.SP_HinhAnh}"
											alt="Li's Product Image">
										</a> <span class="sticker">MỚI</span>
									</div>
									<div class="product_desc">
										<div class="product_desc_info">
											<div class="product-review">
												<h5 class="manufacturer">
													<a href="#">${product.loaisp.getLoaiSP_Ten()}</a>
												</h5>
												<div class="rating-box">
													<ul class="rating">
														<li><i class="fa fa-star-o"></i></li>
														<li><i class="fa fa-star-o"></i></li>
														<li><i class="fa fa-star-o"></i></li>
														<li class="no-star"><i class="fa fa-star-o"></i></li>
														<li class="no-star"><i class="fa fa-star-o"></i></li>
													</ul>
												</div>
											</div>
											<h4>
												<a class="product_name" href="/product-detail?id=${product.SP_MA}">${product.SP_TenSP}</a>
											</h4>
											<div class="price-box">
												<span class="new-price"><fmt:formatNumber
														type="number" value="${product.SP_Gia}"></fmt:formatNumber></span><span>
													VNĐ</span>
											</div>
										</div>
										<div class="add-actions">
											<ul class="add-actions-link">
												<li class="add-cart active"><a href="/addCart?id=${product.SP_MA}">THÊM VÀO
														GIỎ</a></li>
												<li><a class="links-details"
													href="#"><i
														class="fa fa-heart-o"></i></a></li>
												<li><a class="quick-view" data-toggle="modal"
													data-target="#exampleModalCenter" href="#"><i
														class="fa fa-eye"></i></a></li>
											</ul>
										</div>
									</div>
								</div>
								<!-- single-product-wrap end -->
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<!-- Li's Section Area End Here -->
		</div>
	</div>
</section>
<!-- Li's TV & Audio Product Area End Here -->
<!-- Begin Li's Static Home Area -->
<div class="li-static-home">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<!-- Begin Li's Static Home Image Area -->
				<div class="li-static-home-image"></div>
				<!-- Li's Static Home Image Area End Here -->
				<!-- Begin Li's Static Home Content Area -->
				<div class="li-static-home-content">
					<p>
						Giảm tới<span>-20%</span>Trong tuần này
					</p>
					<h2>Sản phẩm mới</h2>
					<h2>Sanai Accessories 2023</h2>
					<p class="schedule">
						Giá chỉ từ <span> <fmt:formatNumber type="number"
								value="1000000"></fmt:formatNumber></span> <span> VNĐ</span>
					</p>
					<div class="default-btn">
						<a href="shop-left-sidebar.html" class="links">MUA NGAY</a>
					</div>
				</div>
				<!-- Li's Static Home Content Area End Here -->
			</div>
		</div>
	</div>
</div>
<!-- Li's Static Home Area End Here -->
<!-- Begin Group Featured Product Area -->
<div class="group-featured-product pt-60 pb-40 pb-xs-25">
	<div class="container">
		<div class="row">
			<!-- Begin Featured Product Area -->
			<div class="col-lg-4">
				<div class="featured-product">
					<div class="li-section-title">
						<h2>
							<span>Chamcham</span>
						</h2>
					</div>
					<div class="featured-product-active-2 owl-carousel">
						<div class="featured-product-bundle">
							<div class="row">
								<div class="group-featured-pro-wrapper">
									<div class="product-img">
										<a href="product-details.html"> <img alt=""
											src="/views/images/featured-product/1.jpg">
										</a>
									</div>
									<div class="featured-pro-content">
										<div class="product-review">
											<h5 class="manufacturer">
												<a href="product-details.html">Studio Design</a>
											</h5>
										</div>
										<div class="rating-box">
											<ul class="rating">
												<li><i class="fa fa-star-o"></i></li>
												<li><i class="fa fa-star-o"></i></li>
												<li><i class="fa fa-star-o"></i></li>
												<li class="no-star"><i class="fa fa-star-o"></i></li>
												<li class="no-star"><i class="fa fa-star-o"></i></li>
											</ul>
										</div>
										<h4>
											<a class="featured-product-name" href="single-product.html">Mug
												Today is a good day</a>
										</h4>
										<div class="featured-price-box">
											<span class="new-price"><span> <fmt:formatNumber type="number"
								value="1000000"></fmt:formatNumber></span> <span> VNĐ</span></span>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="group-featured-pro-wrapper">
									<div class="product-img">
										<a href="product-details.html"> <img alt=""
											src="images/featured-product/2.jpg">
										</a>
									</div>
									<div class="featured-pro-content">
										<div class="product-review">
											<h5 class="manufacturer">
												<a href="product-details.html">Studio Design</a>
											</h5>
										</div>
										<div class="rating-box">
											<ul class="rating">
												<li><i class="fa fa-star-o"></i></li>
												<li><i class="fa fa-star-o"></i></li>
												<li><i class="fa fa-star-o"></i></li>
												<li class="no-star"><i class="fa fa-star-o"></i></li>
												<li class="no-star"><i class="fa fa-star-o"></i></li>
											</ul>
										</div>
										<h4>
											<a class="featured-product-name" href="single-product.html">Mug
												Today is a good day</a>
										</h4>
										<div class="featured-price-box">
											<span class="new-price">$71.80</span>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="group-featured-pro-wrapper">
									<div class="product-img">
										<a href="product-details.html"> <img alt=""
											src="images/featured-product/3.jpg">
										</a>
									</div>
									<div class="featured-pro-content">
										<div class="product-review">
											<h5 class="manufacturer">
												<a href="product-details.html">Studio Design</a>
											</h5>
										</div>
										<div class="rating-box">
											<ul class="rating">
												<li><i class="fa fa-star-o"></i></li>
												<li><i class="fa fa-star-o"></i></li>
												<li><i class="fa fa-star-o"></i></li>
												<li class="no-star"><i class="fa fa-star-o"></i></li>
												<li class="no-star"><i class="fa fa-star-o"></i></li>
											</ul>
										</div>
										<h4>
											<a class="featured-product-name" href="single-product.html">Mug
												Today is a good day</a>
										</h4>
										<div class="featured-price-box">
											<span class="new-price">$71.80</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Featured Product Area End Here -->
			<!-- Begin Featured Product Area -->
			<div class="col-lg-4">
				<div class="featured-product pt-sm-10 pt-xs-25">
					<div class="li-section-title">
						<h2>
							<span>Meito</span>
						</h2>
					</div>
					<div class="featured-product-active-2 owl-carousel">
						<div class="featured-product-bundle">
							<div class="row">
								<div class="group-featured-pro-wrapper">
									<div class="product-img">
										<a href="product-details.html"> <img alt=""
											src="images/featured-product/4.jpg">
										</a>
									</div>
									<div class="featured-pro-content">
										<div class="product-review">
											<h5 class="manufacturer">
												<a href="product-details.html">Studio Design</a>
											</h5>
										</div>
										<div class="rating-box">
											<ul class="rating">
												<li><i class="fa fa-star-o"></i></li>
												<li><i class="fa fa-star-o"></i></li>
												<li><i class="fa fa-star-o"></i></li>
												<li class="no-star"><i class="fa fa-star-o"></i></li>
												<li class="no-star"><i class="fa fa-star-o"></i></li>
											</ul>
										</div>
										<h4>
											<a class="featured-product-name" href="single-product.html">Mug
												Today is a good day</a>
										</h4>
										<div class="featured-price-box">
											<span class="new-price">$71.80</span>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="group-featured-pro-wrapper">
									<div class="product-img">
										<a href="product-details.html"> <img alt=""
											src="images/featured-product/5.jpg">
										</a>
									</div>
									<div class="featured-pro-content">
										<div class="product-review">
											<h5 class="manufacturer">
												<a href="product-details.html">Studio Design</a>
											</h5>
										</div>
										<div class="rating-box">
											<ul class="rating">
												<li><i class="fa fa-star-o"></i></li>
												<li><i class="fa fa-star-o"></i></li>
												<li><i class="fa fa-star-o"></i></li>
												<li class="no-star"><i class="fa fa-star-o"></i></li>
												<li class="no-star"><i class="fa fa-star-o"></i></li>
											</ul>
										</div>
										<h4>
											<a class="featured-product-name" href="single-product.html">Mug
												Today is a good day</a>
										</h4>
										<div class="featured-price-box">
											<span class="new-price">$71.80</span>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="group-featured-pro-wrapper">
									<div class="product-img">
										<a href="product-details.html"> <img alt=""
											src="images/featured-product/6.jpg">
										</a>
									</div>
									<div class="featured-pro-content">
										<div class="product-review">
											<h5 class="manufacturer">
												<a href="product-details.html">Studio Design</a>
											</h5>
										</div>
										<div class="rating-box">
											<ul class="rating">
												<li><i class="fa fa-star-o"></i></li>
												<li><i class="fa fa-star-o"></i></li>
												<li><i class="fa fa-star-o"></i></li>
												<li class="no-star"><i class="fa fa-star-o"></i></li>
												<li class="no-star"><i class="fa fa-star-o"></i></li>
											</ul>
										</div>
										<h4>
											<a class="featured-product-name" href="single-product.html">Mug
												Today is a good day</a>
										</h4>
										<div class="featured-price-box">
											<span class="new-price">$71.80</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Featured Product Area End Here -->
			<!-- Begin Featured Product Area -->
			<div class="col-lg-4">
				<div class="featured-product pt-sm-10 pt-xs-25">
					<div class="li-section-title">
						<h2>
							<span>Sanai</span>
						</h2>
					</div>
					<div class="featured-product-active-2 owl-carousel">
						<div class="featured-product-bundle">
							<div class="row">
								<div class="group-featured-pro-wrapper">
									<div class="product-img">
										<a href="product-details.html"> <img alt=""
											src="images/featured-product/6.jpg">
										</a>
									</div>
									<div class="featured-pro-content">
										<div class="product-review">
											<h5 class="manufacturer">
												<a href="product-details.html">Studio Design</a>
											</h5>
										</div>
										<div class="rating-box">
											<ul class="rating">
												<li><i class="fa fa-star-o"></i></li>
												<li><i class="fa fa-star-o"></i></li>
												<li><i class="fa fa-star-o"></i></li>
												<li class="no-star"><i class="fa fa-star-o"></i></li>
												<li class="no-star"><i class="fa fa-star-o"></i></li>
											</ul>
										</div>
										<h4>
											<a class="featured-product-name" href="single-product.html">Mug
												Today is a good day</a>
										</h4>
										<div class="featured-price-box">
											<span class="new-price">$71.80</span>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="group-featured-pro-wrapper">
									<div class="product-img">
										<a href="product-details.html"> <img alt=""
											src="images/featured-product/4.jpg">
										</a>
									</div>
									<div class="featured-pro-content">
										<div class="product-review">
											<h5 class="manufacturer">
												<a href="product-details.html">Studio Design</a>
											</h5>
										</div>
										<div class="rating-box">
											<ul class="rating">
												<li><i class="fa fa-star-o"></i></li>
												<li><i class="fa fa-star-o"></i></li>
												<li><i class="fa fa-star-o"></i></li>
												<li class="no-star"><i class="fa fa-star-o"></i></li>
												<li class="no-star"><i class="fa fa-star-o"></i></li>
											</ul>
										</div>
										<h4>
											<a class="featured-product-name" href="single-product.html">Mug
												Today is a good day</a>
										</h4>
										<div class="featured-price-box">
											<span class="new-price">$71.80</span>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="group-featured-pro-wrapper">
									<div class="product-img">
										<a href="product-details.html"> <img alt=""
											src="images/featured-product/2.jpg">
										</a>
									</div>
									<div class="featured-pro-content">
										<div class="product-review">
											<h5 class="manufacturer">
												<a href="product-details.html">Studio Design</a>
											</h5>
										</div>
										<div class="rating-box">
											<ul class="rating">
												<li><i class="fa fa-star-o"></i></li>
												<li><i class="fa fa-star-o"></i></li>
												<li><i class="fa fa-star-o"></i></li>
												<li class="no-star"><i class="fa fa-star-o"></i></li>
												<li class="no-star"><i class="fa fa-star-o"></i></li>
											</ul>
										</div>
										<h4>
											<a class="featured-product-name" href="single-product.html">Mug
												Today is a good day</a>
										</h4>
										<div class="featured-price-box">
											<span class="new-price">$71.80</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Featured Product Area End Here -->
		</div>
	</div>
</div>
<!-- Group Featured Product Area End Here -->


<!-- Begin Quick View | Modal Area -->
<div class="modal fade modal-wrapper" id="exampleModalCenter">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-body">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<div class="modal-inner-area row">
					<div class="col-lg-5 col-md-6 col-sm-6">
						<!-- Product Details Left -->
						<div class="product-details-left">
							<div class="product-details-images slider-navigation-1">
								<div class="lg-image">
									<img src="/views/images/product/large-size/1.jpg"
										alt="product image">
								</div>
								<div class="lg-image">
									<img src="/views/images/product/large-size/2.jpg"
										alt="product image">
								</div>
								<div class="lg-image">
									<img src="/views/images/product/large-size/3.jpg"
										alt="product image">
								</div>
								<div class="lg-image">
									<img src="/views/images/product/large-size/4.jpg"
										alt="product image">
								</div>
								<div class="lg-image">
									<img src="/views/images/product/large-size/5.jpg"
										alt="product image">
								</div>
								<div class="lg-image">
									<img src="/views/images/product/large-size/6.jpg"
										alt="product image">
								</div>
							</div>
							<div class="product-details-thumbs slider-thumbs-1">
								<div class="sm-image">
									<img src="/views/images/product/small-size/1.jpg"
										alt="product image thumb">
								</div>
								<div class="sm-image">
									<img src="/views/images/product/small-size/2.jpg"
										alt="product image thumb">
								</div>
								<div class="sm-image">
									<img src="/views/images/product/small-size/3.jpg"
										alt="product image thumb">
								</div>
								<div class="sm-image">
									<img src="/views/images/product/small-size/4.jpg"
										alt="product image thumb">
								</div>
								<div class="sm-image">
									<img src="/views/images/product/small-size/5.jpg"
										alt="product image thumb">
								</div>
								<div class="sm-image">
									<img src="/views/images/product/small-size/6.jpg"
										alt="product image thumb">
								</div>
							</div>
						</div>
						<!--// Product Details Left -->
					</div>

					<div class="col-lg-7 col-md-6 col-sm-6">
						<div class="product-details-view-content pt-60">
							<div class="product-info">
								<h2>Today is a good day Framed poster</h2>
								<span class="product-details-ref">Reference: demo_15</span>
								<div class="rating-box pt-20">
									<ul class="rating rating-with-review-item">
										<li><i class="fa fa-star-o"></i></li>
										<li><i class="fa fa-star-o"></i></li>
										<li><i class="fa fa-star-o"></i></li>
										<li class="no-star"><i class="fa fa-star-o"></i></li>
										<li class="no-star"><i class="fa fa-star-o"></i></li>
										<li class="review-item"><a href="#">XEM ĐÁNH GIÁ</a></li>
										<li class="review-item"><a href="#">ĐÁNH GIÁ</a></li>
									</ul>
								</div>
								<div class="price-box pt-20">
									<span class="new-price new-price-2">1000</span> <span>VNĐ</span>
								</div>
								<div class="product-desc">
									<p>
										<span>100% cotton double printed dress. Black and white
											striped top and orange high waisted skater skirt bottom.
											Lorem ipsum dolor sit amet, consectetur adipisicing elit.
											quibusdam corporis, earum facilis et nostrum dolorum
											accusamus similique eveniet quia pariatur. </span>
									</p>
								</div>
								<div class="product-variants">
									<div class="produt-variants-size">
										<label>Dimension</label> <select class="nice-select">
											<option value="1" title="S" selected="selected">40x60cm</option>
											<option value="2" title="M">60x90cm</option>
											<option value="3" title="L">80x120cm</option>
										</select>
									</div>
								</div>
								<div class="single-add-to-cart">
									<form action="#" class="cart-quantity">
										<div class="quantity">
											<label>Quantity</label>
											<div class="cart-plus-minus">
												<input class="cart-plus-minus-box" value="1" type="text">
												<div class="dec qtybutton">
													<i class="fa fa-angle-down"></i>
												</div>
												<div class="inc qtybutton">
													<i class="fa fa-angle-up"></i>
												</div>
											</div>
										</div>
										<button class="add-to-cart" type="submit">THÊM VÀO
											GIỎ HÀNG</button>
									</form>
								</div>
								<div class="product-additional-info pt-25">
									<a class="wishlist-btn" href="/views/wishlist.html"><i
										class="fa fa-heart-o"></i>THÊM VÀO YÊU THÍCH</a>
									<div class="product-social-sharing pt-25">
										<ul>
											<li class="facebook"><a href="#"><i
													class="fa fa-facebook"></i>Facebook</a></li>
											<li class="twitter"><a href="#"><i
													class="fa fa-twitter"></i>Twitter</a></li>
											<li class="google-plus"><a href="#"><i
													class="fa fa-google-plus"></i>Google +</a></li>
											<li class="instagram"><a href="#"><i
													class="fa fa-instagram"></i>Instagram</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Begin Quick View | Modal Area End Here-->