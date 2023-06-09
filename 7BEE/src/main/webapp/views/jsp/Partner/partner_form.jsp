<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
.file-input {
	position: relative;
	overflow: hidden;
	margin: 10px;
	background-color: #4286f4;
	color: white;
	padding: 10px 20px;
	cursor: pointer;
	border-radius: 5px;
	font-size: 16px;
	font-weight: bold;
}

.file-input input[type=file] {
	position: absolute;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	width: 100%;
	height: 100%;
	opacity: 0;
	cursor: pointer;
}
</style>
<div class="breadcrumb-area">
	<div class="container">
		<div class="breadcrumb-content">
			<ul>
				<li><a href="/">Home</a></li>
				<li class="active">Danh sách sản phẩm</li>
			</ul>
		</div>
	</div>
</div>
<div class="container mb-20">
	<nav>
		<div class="nav nav-tabs" id="nav-tab" role="tablist">
			<button class="nav-link ${btnActive1}" id="nav-home-tab"
				data-toggle="tab" data-target="#nav-home" type="button" role="tab"
				aria-controls="nav-home" aria-selected="true">Chi tiết</button>
			<button class="nav-link ${btnActive2}" id="nav-profile-tab"
				data-toggle="tab" data-target="#nav-profile" type="button"
				role="tab" aria-controls="nav-profile" aria-selected="false">Danh
				sách sản phẩm</button>
			<button class="nav-link ${btnActive3}" id="nav-contact-tab"
				data-toggle="tab" data-target="#nav-contact" type="button"
				role="tab" aria-controls="nav-contact" aria-selected="false">Đơn
				hàng</button>
		</div>
	</nav>
	<div class="tab-content" id="nav-tabContent">
		<div class="tab-pane fade ${showForm1}" id="nav-home" role="tabpanel"
			aria-labelledby="nav-home-tab">


			<form:form modelAttribute="product" enctype="multipart/form-data">
				<div class="row weight-bold">
					<h3 class="w-100 text-center my-4">THÔNG TIN SẢN PHẨM</h3>
					<c:if test="${not empty message }">
						<div class="alert alert-success" id="success">${message }</div>
					</c:if>
					<c:if test="${not empty error }">
						<div class="alert alert-danger" id="error">${error }</div>
					</c:if>
				</div>
				<div class="row">
					<div class="col-6">
						<div class="form-group">
							<form:label path="SP_TenSP" for="name">Tên sản phẩm</form:label>
							<form:input path="SP_TenSP" type="text" class="form-control"
								name="name" id="name" placeholder="Nhập Tên sản phẩm" />
							<form:errors path="SP_TenSP" class="badge badge-danger" />
						</div>
						<div class="form-group">
							<label>Chọn Loại</label>
							<form:select class="form-control" path="LoaiSP_MA">
								<%-- <form:options items="${lstLoaiSP}" itemValue="LoaiSP_MA"
									itemLabel="LoaiSP_Ten" /> --%>
								<option value="LSP003">ĐỒ ĐIỆN TỬ</option>
								<option value="LSP002">THỜI TRANG</option>
								<option value="LSP001">ĐỒ ĂN & ĐỒ UỐNG</option>
								<option value="LSP002">ĐỒ DÙNG FPOLY</option>
							</form:select>
						</div>
						<div class="form-group">
							<form:label path="SP_Gia" for="price">Giá</form:label>
							<form:input path="SP_Gia" type="text" class="form-control"
								name="price" id="price" />
							<form:errors path="SP_Gia" class="badge badge-danger" />

						</div>

						<div class="form-group">
							<label for="category">Màu sắc</label>
							<form:input type="text" path="CTSP_Mau" class="form-control"
								name="color" id="price" />
						</div>
						<div class="form-group row mx-auto">
							<div class="form-group">
								<label for="category">Số lượng</label>
								<div class="cart-plus-minus" style="float: none;">
									<form:input type="number" path="SP_SoLuong"
										class="cart-plus-minus-box quantityShopCart" value="1"
										name="qty" id="qty" />
								</div>
								<form:errors path="SP_SoLuong" class="badge badge-danger" />
							</div>
							<div class="form-group w-75">
								<label for="size">Kích thước</label>
								<form:input type="text" path="Kich_Thuoc" class="form-control"
									name="size" id="size" />
							</div>
						</div>
						<div class="form-group">
							<label for="description">Mô tả</label>
							<form:textarea class="form-control" rows="4" name="description"
								path="CTSP_ThongTinThem" id="description"></form:textarea>
						</div>
					</div>
					<div class="col-6">
						<div class="row d-flex flex-column">
							<h5 class="text-center mb-0">
								Ảnh sản phẩm
								<p class="text-danger font-weight-bold">${toida10hinh}${itnhat2hinh}</p>
							</h5>
							<div class="d-flex flex-column">
								<div id="selectedImages" class="carousel slide"
									data-ride="carousel">
									<div class="carousel-inner">
										<c:if test="${empty param.filesIMG}">
											<div style="height: 17em;" class="carousel-item active">
												<img src="/views/images/product/large-size/product.png"
													class="d-block w-50 h-100 mx-auto img-thumbnail img-fluid">
											</div>
										</c:if>
									</div>
									<a class="carousel-control-prev" href="#selectedImages"
										role="button" data-slide="prev"> <span
										class="fa fa-chevron-left fa-lg" style="color: black;"></span>
										<span class="sr-only">Previous</span>
									</a> <a class="carousel-control-next" href="#selectedImages"
										role="button" data-slide="next"> <span
										class="fa fa-chevron-right fa-lg" style="color: black;"></span>
										<span class="sr-only">Next</span>
									</a>
								</div>
								<div class="d-lg-flex justify-content-center">
									<div class="file-input btn">
										<span><i class="fa-regular fa-image"></i> Chọn ảnh</span> <input
											accept=".jpg,.png,.gif" type="file" name="filesIMG" max="10"
											multiple onchange="displaySelectedImages(this)">
									</div>
								</div>
							</div>
						</div>
						<div class="row mt-25">
							<h5 class="text-center w-100 mb-0">
								Thông số chi tiết
								<div>
									<form:errors path="CTSP_MoTaTitle1" class=" alert-danger h6" />
									<form:errors path="CTSP_MoTaContent1" class=" alert-danger h6" />
								</div>


							</h5>
							<div class="table-responsive border" style="height: 16em">
								<table id="dataTableThemSP" class="table border">
									<thead class="thead-light sticky-top">
										<tr>
											<th scope="col">#</th>
											<th scope="col" class="col-6">Tiêu đề</th>
											<th scope="col" class="col-6">Nội dung</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<th scope="row">1</th>
											<td class="col-6"><form:input path="CTSP_MoTaTitle1"
													type="text" value="${arrThongSo[0]}" class="form-control"
													placeholder="Nhập tiêu đề 1" /></td>
											<td class="col-6"><form:input path="CTSP_MoTaContent1"
													type="text" value="${arrThongSo[1]}" class="form-control"
													placeholder="Nhập nội dung 1" /></td>
										</tr>
										<tr>
											<th scope="row">2</th>
											<td class="col-6"><form:input path="CTSP_MoTaTitle2"
													type="text" value="${arrThongSo[2]}" class="form-control"
													placeholder="Nhập tiêu đề 2" /></td>
											<td class="col-6"><form:input path="CTSP_MoTaContent2"
													type="text" value="${arrThongSo[3]}" class="form-control"
													placeholder="Nhập nội dung 2" /></td>
										</tr>
										<tr>
											<th scope="row">3</th>
											<td class="col-6"><form:input path="CTSP_MoTaTitle3"
													type="text" value="${arrThongSo[4]}" class="form-control"
													placeholder="Nhập tiêu đề 3" /></td>
											<td class="col-6"><form:input path="CTSP_MoTaContent3"
													type="text" value="${arrThongSo[5]}" class="form-control"
													placeholder="Nhập nội dung 3" /></td>
										</tr>
										<tr>
											<th scope="row">4</th>
											<td class="col-6"><form:input path="CTSP_MoTaTitle4"
													type="text" value="${arrThongSo[6]}" class="form-control"
													placeholder="Nhập tiêu đề 4" /></td>
											<td class="col-6"><form:input path="CTSP_MoTaContent4"
													type="text" value="${arrThongSo[7]}" class="form-control"
													placeholder="Nhập nội dung 4" /></td>
										</tr>
										<tr>
											<th scope="row">5</th>
											<td class="col-6"><form:input path="CTSP_MoTaTitle5"
													type="text" value="${arrThongSo[8]}" class="form-control"
													placeholder="Nhập tiêu đề 5" /></td>
											<td class="col-6"><form:input path="CTSP_MoTaContent5"
													type="text" value="${arrThongSo[9]}" class="form-control"
													placeholder="Nhập nội dung 5" /></td>
										</tr>
										<tr>
											<th scope="row">6</th>
											<td class="col-6"><form:input path="CTSP_MoTaTitle6"
													type="text" value="${arrThongSo[10]}" class="form-control"
													placeholder="Nhập tiêu đề 6" /></td>
											<td class="col-6"><form:input path="CTSP_MoTaContent6"
													type="text" value="${arrThongSo[11]}" class="form-control"
													placeholder="Nhập nội dung 6" /></td>
										</tr>
										<tr>
											<th scope="row">7</th>
											<td class="col-6"><form:input path="CTSP_MoTaTitle7"
													type="text" value="${arrThongSo[12]}" class="form-control"
													placeholder="Nhập tiêu đề 7" /></td>
											<td class="col-6"><form:input path="CTSP_MoTaContent7"
													type="text" value="${arrThongSo[13]}" class="form-control"
													placeholder="Nhập nội dung 7" /></td>
										</tr>
										<tr>
											<th scope="row">8</th>
											<td class="col-6"><form:input path="CTSP_MoTaTitle8"
													type="text" value="${arrThongSo[14]}" class="form-control"
													placeholder="Nhập tiêu đề 8" /></td>
											<td class="col-6"><form:input path="CTSP_MoTaContent8"
													type="text" value="${arrThongSo[15]}" class="form-control"
													placeholder="Nhập nội dung 8" /></td>
										</tr>
										<!-- Các hàng tiếp theo tương tự -->
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<button formaction="/partner/add" type="submit"
					class="btn btn-primary mt-3">THÊM SẢN PHẨM</button>
			</form:form>
		</div>
		<div class="tab-pane fade ${showForm2}" id="nav-profile"
			role="tabpanel" aria-labelledby="nav-profile-tab">
			<div class="table-responsive" style="height: 50em">
				<table class="table-hover table text-center justify-content-center">
					<thead class="thead-light sticky-top">
						<tr>
							<th scope="col" class="w-25">Tên SP</th>
							<th scope="col" class="w-25">Loại</th>
							<th scope="col" class="w-25">Hình ảnh</th>
							<th scope="col" class="w-25">Thao tác</th>
						</tr>
					</thead>
					<tbody>
						<form action="/partner" method="post">
							<c:forEach var="item" items="${lstSPbyPartner}">
								<tr>
									<td class="align-middle">${item.SP_TenSP }</td>
									<td class="align-middle">${item.getLoaisp().getLoaiSP_Ten() }</td>
									<td class="align-middle"><img class="img-thumbnail"
										width="50%"
										src="/views/images/product/large-size/${item.SP_HinhAnh}">
									</td>
									<td colspan="2" class="align-middle">
										<button type="submit" formmethod="post"
											formaction="/partner/edit/${item.getSP_MA()}"
											class="btn btn-lg btn-warning mr-3">
											<i class="fa-solid fa-pen-to-square"></i> Sửa
										</button>
										<button formaction="" class="btn btn-lg btn-danger ">
											<i class="fa-solid fa-trash-can"></i> Xóa
										</button>
									</td>
								</tr>
							</c:forEach>
						</form>
					</tbody>
				</table>
			</div>
		</div>
		<div class="tab-pane fade ${showForm3}" id="nav-contact"
			role="tabpanel" aria-labelledby="nav-contact-tab">
			<div
				class="d-flex flex-row align-items-center justify-content-center">
				<img alt="" src="/views/images/team/7bee.png">
				<h2>Tính năng đang được phát triển</h2>
			</div>

		</div>
	</div>
</div>