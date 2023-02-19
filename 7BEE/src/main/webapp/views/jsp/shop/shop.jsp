<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="breadcrumb-area">
	<div class="container">
		<div class="breadcrumb-content">
			<ul>
				<li><a href="/">TRANG CHỦ</a></li>
				<li class="active">SHOP</li>
			</ul>
		</div>
	</div>
</div>
<!-- Li's Breadcrumb Area End Here -->
<!-- Begin Li's Content Wraper Area -->
<div class="content-wraper pt-60 pb-60 pt-sm-30">
	<div class="container">
		<div class="row">
			<div class="col-lg-9 order-1 order-lg-2">
				<!-- Begin Li's Banner Area -->
				<div class="single-banner shop-page-banner">
					<a href="#"> <img src="/views/images/bg-banner/2.jpg"
						alt="Li's Static Banner">
					</a>
				</div>
				<!-- Li's Banner Area End Here -->
				<!-- shop-top-bar start -->
				<div class="shop-top-bar mt-30">
					<div class="shop-bar-inner">
						<div class="product-view-mode">
							<!-- shop-item-filter-list start -->
							<ul class="nav shop-item-filter-list" role="tablist">
								<li class="active" role="presentation"><a
									aria-selected="true" class="active show" data-toggle="tab"
									role="tab" aria-controls="grid-view" href="#grid-view"><i
										class="fa fa-th"></i></a></li>
								<li role="presentation"><a data-toggle="tab" role="tab"
									aria-controls="list-view" href="#list-view"><i
										class="fa fa-th-list"></i></a></li>
							</ul>
							<!-- shop-item-filter-list end -->
						</div>
						<div class="toolbar-amount">
							<span>Hiển thị ${pages.totalElements >= 9 ? (pages.number != 0 ? (pages.number * 9) : 1) : pages.totalElements}
								--> ${((pages.number + 1) * 9) <= pages.totalElements ? ((pages.number + 1) * 9) : pages.totalElements}
								của ${pages.totalElements } sản phẩm</span>
						</div>
					</div>
					<!-- product-select-box start -->
					<div class="product-select-box">
						<div class="product-short">
							<p>SẮP XẾP:</p>
							<select class="nice-select">
								<option value="sales">TÊN SẢN PHẨM (A - Z)</option>
								<option value="sales">TÊN SẢN PHẨM (Z - A)</option>
								<option value="price-asc">GIÁ (THẤP &gt; CAO)</option>
								<option value="price-desc">GIÁ (CAO &gt; THẤP)</option>
								<option value="date">NGÀY ĐĂNG (MỚI NHẤT)</option>
								<option value="date">NGÀY ĐĂNG (CŨ NHẤT)</option>
							</select>
						</div>
					</div>
					<!-- product-select-box end -->
				</div>
				<h1 class="mt-4 ${pages.totalElements > 0 ? 'd-none' : 'd-block'} text-center">Không có kết quả!</h1>
				<!-- shop-top-bar end -->
				<!-- shop-products-wrapper start -->
				<div class="shop-products-wrapper">
					<div class="tab-content">
						<div id="grid-view" class="tab-pane fade active show"
							role="tabpanel">
							<div class="product-area shop-product-area">
								<div class="row">
									<c:forEach var="product" items="${pages.content }"
										varStatus="loop">
										<div class="col-lg-4 col-md-4 col-sm-6 mt-40">
											<!-- single-product-wrap start -->
											<div class="single-product-wrap">
												<div class="product-image">
													<a href="/product-detail/${product.SP_MA}"> <img
														src="/views/images/product/large-size/${product.SP_HinhAnh}"
														alt="
											Li's ProductImage">
													</a> <span class="sticker">MỚI</span>
												</div>
												<div class="product_desc">
													<div class="product_desc_info">
														<div class="product-review">
															<h5 class="manufacturer">
																<a href="/shop/${product.loaisp.getLoaiSP_MA()}">${product.loaisp.getLoaiSP_Ten()}</a>
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
															<a class="product_name"
																href="/product-detail/${product.SP_MA}">${product.SP_TenSP}</a>
														</h4>
														<div class="price-box">
															<span class="new-price"><fmt:formatNumber
																	type="number" value="${product.SP_Gia}"></fmt:formatNumber></span><span>
																VNĐ</span>
														</div>
													</div>
													<div class="add-actions">
														<ul class="add-actions-link">
															<li class="add-cart active"><a
																href="/addCart/${product.SP_MA}">THÊM VÀO GIỎ</a></li>
															<li><a class="links-details" href="#"><i
																	class="fa fa-heart-o"></i></a></li>

															<li><a class="quick-view" data-toggle="modal"
																data-target="#exampleModalCenter" href="#"
																onclick="showQuickView(${product.SP_MA})"><i
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
						<div id="list-view" class="tab-pane fade product-list-view"
							role="tabpanel">
							<div class="row">
								<div class="col">
									<c:forEach var="product" items="${pages.content }"
										varStatus="loop">
										<div class="row product-layout-list">
											<div class="col-lg-3 col-md-5 ">
												<div class="product-image">
													<a href="/product-detail/${product.SP_MA}"> <img
														src="/views/images/product/large-size/${product.SP_HinhAnh}"
														alt="Li's Product Image">
													</a> <span class="sticker">Mới</span>
												</div>
											</div>
											<div class="col-lg-5 col-md-7">
												<div class="product_desc">
													<div class="product_desc_info">
														<div class="product-review">
															<h5 class="manufacturer">
																<a href="/shop/${product.loaisp.getLoaiSP_MA()}">${product.loaisp.getLoaiSP_Ten()}</a>
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
															<a class="product_name"
																href="/product-detail/${product.SP_MA}">${product.SP_TenSP}</a>
														</h4>
														<div class="price-box">
															<span class="new-price"><fmt:formatNumber
																	type="number" value="${product.SP_Gia}"></fmt:formatNumber></span><span>
																VNĐ</span>
														</div>
														<p>${product.ct_sanpham.getCTSP_ThongTinThem()}</p>
													</div>
												</div>
											</div>
											<div class="col-lg-4">
												<div class="shop-add-action mb-xs-30">
													<ul class="add-actions-link">
														<li class="add-cart active"><a
															href="/addCart/${product.SP_MA}">THÊM VÀO GIỎ</a></li>
														<li class="wishlist"><a href="wishlist.html"><i
																class="fa fa-heart-o"></i>YÊU THÍCH</a></li>
														<li><a class="quick-view" data-toggle="modal"
															data-target="#exampleModalCenter" href="#"><i
																class="fa fa-eye"></i>XEM NHANH</a></li>
													</ul>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="paginatoin-area">
							<div class="row">
								<div class="col-lg-6 col-md-6 pt-xs-15">
									<p>Hiển thị ${pages.totalElements >= 9 ? (pages.number != 0 ? (pages.number * 9) : 1) : pages.totalElements}
										--> ${((pages.number + 1) * 9) <= pages.totalElements ? ((pages.number + 1) * 9) : pages.totalElements}
										của ${pages.totalElements } sản phẩm</p>
								</div>
								<div class="col-lg-6 col-md-6">
									<ul class="pagination-box pt-xs-20 pb-xs-15">
										<li><a
											href="${request.getContextPath()}?page=${pages.number <= 0 ? pages.number : pages.number - 1}"
											class="Previous"><i class="fa fa-chevron-left"></i> Trước</a></li>
										<%
										for (int i = 0; i < Integer.parseInt(request.getAttribute("totalPages").toString()); i += 1) {
										%>
										<li
											<%if (Integer.parseInt(request.getAttribute("Pagecurrent").toString()) == i) {%>
											class="active" <%}%>><a
											href="${request.getContextPath()}?page=<%=i%>"><%=i + 1%></a></li>
										<%
										}
										%>

										<li><a
											href="${request.getContextPath()}?page=${pages.number >= (pages.totalPages -1) ? pages.number : pages.number + 1}"
											class="Next"> Sau <i class="fa fa-chevron-right"></i></a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- shop-products-wrapper end -->
			</div>
			<div class="col-lg-3 order-2 order-lg-1">
			<!--sidebar-categores-box start  -->
				<div class="sidebar-categores-box">
					<div class="sidebar-title">
						<h2>Bộ Lọc</h2>
					</div>
					<!-- btn-xoa tat ca-  start -->
					<button class="btn-clear-all mb-sm-30 mb-xs-30">Làm sạch tất cả</button>
					<!-- btn-xoa tat ca- end -->
					<!-- btn-Loc-start -->
					<button type="button" class="btn btn-primary btn-sm">Lọc</button>
					<!-- btn-Loc-end -->
					<!-- filter-sub-area start -->
					<div class="filter-sub-area">
						<h5 class="filter-sub-titel">Thương Hiệu</h5>
						<div class="categori-checkbox">
							<form action="#">
								<ul>
									<li><input type="checkbox" name="product-categori"><a
										href="#">SamSung</a></li>
									<li><input type="checkbox" name="product-categori"><a
										href="#">LG</a></li>
									<li><input type="checkbox" name="product-categori"><a
										href="#">Gucci</a></li>
									<li><input type="checkbox" name="product-categori"><a
										href="#">Chanel</a></li>
									<li><input type="checkbox" name="product-categori"><a
										href="#">Louis Vuitton</a></li>
								</ul>
							</form>
						</div>
					</div>
					<!-- filter-sub-area end -->
					<!-- filter-sub-area start -->
					<div class="filter-sub-area pt-sm-10 pt-xs-10">
						<h5 class="filter-sub-titel">Kích cỡ</h5>
						<div class="size-checkbox">
							<form action="#">
								<ul>
									<li><input type="checkbox" name="product-size"><a
										href="#">S (3)</a></li>
									<li><input type="checkbox" name="product-size"><a
										href="#">M (3)</a></li>
									<li><input type="checkbox" name="product-size"><a
										href="#">L (3)</a></li>
									<li><input type="checkbox" name="product-size"><a
										href="#">XL (3)</a></li>
								</ul>
							</form>
						</div>
					</div>
					<!-- filter-sub-area end -->
					<!-- filter-sub-area start -->
					<div class="filter-sub-area pt-sm-10 pt-xs-10">
						<h5 class="filter-sub-titel">Màu Sắc</h5>
						<div class="color-categoriy">
							<form action="#">
								<ul>
									<li><span class="white"></span><a href="#">Trắng (1)</a></li>
									<li><span class="black"></span><a href="#">Đen (1)</a></li>
									<li><span class="Orange"></span><a href="#">Cam (3)
									</a></li>
									<li><span class="Blue"></span><a href="#">Xanh (2) </a></li>
								</ul>
							</form>
						</div>
					</div>
					<!-- filter-sub-area end -->
					<!-- filter-sub-area start -->
					<div class="filter-sub-area pt-sm-10 pb-sm-15 pb-xs-15">
						<h5 class="filter-sub-titel">Kích thước</h5>
						<div class="categori-checkbox">
							<form action="#">
								<ul>
									<li><input type="checkbox" name="product-categori"><a
										href="#">40x60cm (6)</a></li>
									<li><input type="checkbox" name="product-categori"><a
										href="#">60x90cm (6)</a></li>
									<li><input type="checkbox" name="product-categori"><a
										href="#">80x120cm (6)</a></li>
								</ul>
							</form>
						</div>
					</div>
					<!-- filter-sub-area end -->
				</div>

				<!--sidebar-categores-box end  -->
				
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Content Wraper Area End Here -->

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
									<img src="images/product/large-size/1.jpg" alt="product image">
								</div>
								<div class="lg-image">
									<img src="images/product/large-size/2.jpg" alt="product image">
								</div>
								<div class="lg-image">
									<img src="images/product/large-size/3.jpg" alt="product image">
								</div>
								<div class="lg-image">
									<img src="images/product/large-size/4.jpg" alt="product image">
								</div>
								<div class="lg-image">
									<img src="images/product/large-size/5.jpg" alt="product image">
								</div>
								<div class="lg-image">
									<img src="images/product/large-size/6.jpg" alt="product image">
								</div>
							</div>
							<div class="product-details-thumbs slider-thumbs-1">
								<div class="sm-image">
									<img src="images/product/small-size/1.jpg"
										alt="product image thumb">
								</div>
								<div class="sm-image">
									<img src="images/product/small-size/2.jpg"
										alt="product image thumb">
								</div>
								<div class="sm-image">
									<img src="images/product/small-size/3.jpg"
										alt="product image thumb">
								</div>
								<div class="sm-image">
									<img src="images/product/small-size/4.jpg"
										alt="product image thumb">
								</div>
								<div class="sm-image">
									<img src="images/product/small-size/5.jpg"
										alt="product image thumb">
								</div>
								<div class="sm-image">
									<img src="images/product/small-size/6.jpg"
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
										<li class="review-item"><a href="#">Read Review</a></li>
										<li class="review-item"><a href="#">Write Review</a></li>
									</ul>
								</div>
								<div class="price-box pt-20">
									<span class="new-price new-price-2">$57.98</span>
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
										<button class="add-to-cart" type="submit">Add to cart</button>
									</form>
								</div>
								<div class="product-additional-info pt-25">
									<a class="wishlist-btn" href="wishlist.html"><i
										class="fa fa-heart-o"></i>Add to wishlist</a>
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
<!-- Quick View | Modal Area End Here -->