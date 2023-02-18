<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="breadcrumb-area">
	<div class="container">
		<div class="breadcrumb-content">
			<ul>
				<li><a href="/">Home</a></li>
				<li class="active">Product Detail</li>
			</ul>
		</div>
	</div>
</div>
<!-- Li's Breadcrumb Area End Here -->
<!-- content-wraper start -->
<div class="content-wraper">
	<div class="container">
		<div class="row single-product-area">
			<div class="col-lg-5 col-md-6">
				<!-- Product Details Left -->
				<div class="product-details-left">
					<div class="product-details-images slider-navigation-1">
						<%
						String inputIMG = (String) request.getAttribute("listAnh");
						String[] listIMG = inputIMG.split("-\\*-");
						for (int i = 0; i < listIMG.length; i ++) {
						%>
						<div class="lg-image">
							<img
								src="/views/images/product/large-size/<%=listIMG[i]%>"
								alt="product image">
						</div>
						<%
						}
						%>
					</div>
					<div class="product-details-thumbs slider-thumbs-1">
						<%
						String inputIMGsm = (String) request.getAttribute("listAnh");
						String[] listIMGsm = inputIMGsm.split("-\\*-");
						for (int i = 0; i < listIMGsm.length; i ++) {
						%>
						<div class="sm-image">
							<img src="/views/images/product/small-size/<%=listIMGsm[i]%>"
								alt="product image thumb">
						</div>
						<%
						}
						%>
					</div>
				</div>
				<!--// Product Details Left -->
			</div>

			<div class="col-lg-7 col-md-6">
				<div class="product-details-view-content sp-normal-content pt-60">
					<div class="product-info">
						<h2>${sanpham.getSP_TenSP()}</h2>
						<span class="product-details-ref">${sanpham.getShop().getShop_TenShop()}</span>

						<div class="price-box pt-20">
							<span class="new-price new-price-2"><fmt:formatNumber
									type="number" value="${sanpham.getSP_Gia()}"></fmt:formatNumber></span><span>
								VNĐ</span>
						</div>
						<div class="product-desc">
							<p>
								<span>${sanpham.getCt_sanpham().getCTSP_ThongTinThem()}</span>
							</p>
						</div>
						<div class="single-add-to-cart">
							<form action="#" class="cart-quantity">
								<div class="">
									<button type="button" class="btn btn-primary">Xanh</button>
									<button type="button" class="btn btn-warning">Vàng</button>
									<button type="button" class="btn btn-dark">Đen</button>
								</div>
								<div class="quantity">
									<label>Số Lượng</label>
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
								<button class="add-to-cart"  type="submit">Thêm Vào Giỏ
									Hàng</button>
							</form>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- content-wraper end -->
<!-- Begin Product Area -->
<div class="product-area pt-40">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="li-product-tab">
					<ul class="nav li-product-menu">
						<li><a data-toggle="tab" href="#product-details"><span>Chi
									Tiết Sản Phẩm</span></a></li>
						<li><a data-toggle="tab" href="#reviews"><span>Đánh
									Giá</span></a></li>
					</ul>
				</div>
				<!-- Begin Li's Tab Menu Content Area -->
			</div>
		</div>
		<div class="tab-content">

			<div id="product-details" class="tab-pane" role="tabpanel">
				<ul class="list-group border">
					<%
					String inputMT = (String) request.getAttribute("mota");
					String[] listMT = inputMT.split("-\\*-");
					for (int i = 0; i < listMT.length; i += 2) {
					%>
					<li
						class="list-group-item d-flex justify-content-between align-items-center ">
						<span class="font-weight-bold text-capitalize"><%=listMT[i]%></span>
						<span class=""><%=listMT[i + 1]%></span>
					</li>
					<%
					}
					%>
				</ul>
			</div>
			<div id="reviews" class="tab-pane" role="tabpanel">
				<div class="product-reviews">
					<div class="product-details-comment-block">
						<div class="comment-review">
							<span>Grade</span>
							<ul class="rating">
								<li><i class="fa fa-star-o"></i></li>
								<li><i class="fa fa-star-o"></i></li>
								<li><i class="fa fa-star-o"></i></li>
								<li class="no-star"><i class="fa fa-star-o"></i></li>
								<li class="no-star"><i class="fa fa-star-o"></i></li>
							</ul>
						</div>
						<div class="comment-author-infos pt-25">
							<span>HTML 5</span> <em>01-12-18</em>
						</div>
						<div class="comment-details">
							<h4 class="title-block">Demo</h4>
							<p>Plaza</p>
						</div>
						<div class="review-btn">
							<a class="review-links" href="#" data-toggle="modal"
								data-target="#mymodal">Write Your Review!</a>
						</div>
						<!-- Begin Quick View | Modal Area -->
						<div class="modal fade modal-wrapper" id="mymodal">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-body">
										<h3 class="review-page-title">Write Your Review</h3>
										<div class="modal-inner-area row">
											<div class="col-lg-6">
												<div class="li-review-product">
													<img
														src="/views/images/product/large-size/${sanpham.getSP_HinhAnh()}"
														alt="Li's Product">
													<div class="li-review-product-desc">
														<p class="li-product-name">${sanpham.getSP_TenSP()}</p>
														<p>
															<span>No data</span>
														</p>
													</div>
												</div>
											</div>
											<div class="col-lg-6">
												<div class="li-review-content">
													<!-- Begin Feedback Area -->
													<div class="feedback-area">
														<div class="feedback">
															<h3 class="feedback-title">Our Feedback</h3>
															<form action="#">
																<p class="your-opinion">
																	<label>Your Rating</label> <span> <select
																		class="star-rating">
																			<option value="1">1</option>
																			<option value="2">2</option>
																			<option value="3">3</option>
																			<option value="4">4</option>
																			<option value="5">5</option>
																	</select>
																	</span>
																</p>
																<p class="feedback-form">
																	<label for="feedback">Your Review</label>
																	<textarea id="feedback" name="comment" cols="45"
																		rows="8" aria-required="true"></textarea>
																</p>
																<div class="feedback-input">
																	<p class="feedback-form-author">
																		<label for="author">Name<span class="required">*</span>
																		</label> <input id="author" name="author" value="" size="30"
																			aria-required="true" type="text">
																	</p>
																	<p class="feedback-form-author feedback-form-email">
																		<label for="email">Email<span class="required">*</span>
																		</label> <input id="email" name="email" value="" size="30"
																			aria-required="true" type="text"> <span
																			class="required"><sub>*</sub> Required fields</span>
																	</p>
																	<div class="feedback-btn pb-15">
																		<a href="#" class="close" data-dismiss="modal"
																			aria-label="Close">Close</a> <a href="#">Submit</a>
																	</div>
																</div>
															</form>
														</div>
													</div>
													<!-- Feedback Area End Here -->
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Quick View | Modal Area End Here -->
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Product Area End Here -->
<!-- Begin Li's Laptop Product Area -->
<section class="product-area li-laptop-product pt-30 pb-50">
	<div class="container">
		<div class="row">
			<!-- Begin Li's Section Area -->
			<div class="col-lg-12">
				<div class="li-section-title">
					<h2>
						<span>${Same_Products.size()} other products in the same
							category:</span>
					</h2>
				</div>
				<div class="row">
					<div class="product-active owl-carousel">
						<c:forEach var="item" items="${Same_Products}">
							<div class="col-lg-12">
								<!--product-->
								<!-- single-product-wrap start -->
								<div class="single-product-wrap">
									<div class="product-image">
										<a href="/product-detail/${item.SP_MA}"> <img
											src="/views/images/product/large-size/${item.SP_HinhAnh}"
											alt="Li's Product Image">
										</a> <span class="sticker">New</span>
									</div>
									<div class="product_desc">
										<div class="product_desc_info">
											<div class="product-review">
												<h5 class="manufacturer">
													<a href="#">${item.loaisp.getLoaiSP_Ten()}</a>
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
												<a class="product_name" href="/product-detail/${item.SP_MA}">${item.SP_TenSP}</a>
											</h4>
											<div class="price-box">
												<span class="new-price"><fmt:formatNumber
														type="number" value="${item.SP_Gia}"></fmt:formatNumber><span>VNĐ</span></span>
											</div>
										</div>
										<div class="add-actions">
											<ul class="add-actions-link">
												<li class="add-cart active"><a href="#">Add to cart</a></li>
												<li><a href="#" title="quick view"
													class="quick-view-btn" data-toggle="modal"
													data-target="#exampleModalCenter"><i class="fa fa-eye"></i></a></li>
												<li><a class="links-details" href="wishlist.html"><i
														class="fa fa-heart-o"></i></a></li>
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