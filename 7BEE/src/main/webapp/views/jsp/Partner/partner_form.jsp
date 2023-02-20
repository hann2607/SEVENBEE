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
<div class="container">
	<nav>
		<div class="nav nav-tabs" id="nav-tab" role="tablist">
			<button class="nav-link active" id="nav-home-tab" data-toggle="tab"
				data-target="#nav-home" type="button" role="tab"
				aria-controls="nav-home" aria-selected="true">Home</button>
			<button class="nav-link" id="nav-profile-tab" data-toggle="tab"
				data-target="#nav-profile" type="button" role="tab"
				aria-controls="nav-profile" aria-selected="false">Profile</button>
			<button class="nav-link" id="nav-contact-tab" data-toggle="tab"
				data-target="#nav-contact" type="button" role="tab"
				aria-controls="nav-contact" aria-selected="false">Contact</button>
		</div>
	</nav>
	<div class="tab-content" id="nav-tabContent">
		<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
			aria-labelledby="nav-home-tab">
			<h3 class="d-flex justify-content-center m-4 font-weight-bold">THÔNG
				TIN SẢN PHẨM</h3>
			<form:form modelAttribute="product">
				<div class="row">
					<div class="col-6">
						<div class="form-group">
							<form:label path="SP_TenSP" for="name">Tên sản phẩm</form:label>
							<form:input path="SP_TenSP" type="text" class="form-control"
								name="name" id="name" placeholder="Nhập Tên sản phẩm" />
							<form:errors path="SP_TenSP" class="badge badge-danger" />


						</div>
						<div class="form-group">
							<form:label path="">Chọn Loại</form:label>
							<form:select path="" class="form-control">
								<form:options items="${lstLoaiSP}" itemValue="id" itemLabel="name" />
							</form:select>
							<form:errors path="" class="badge badge-danger" />

						</div>
						<div class="form-group">
							<form:label path="SP_Gia" for="price">Giá</form:label>
							<form:input path="SP_Gia" type="text" class="form-control"
								name="price" id="price" />
							<form:errors path="SP_Gia" class="badge badge-danger" />

						</div>
						<div class="form-group">
							<label for="category">Kích thước</label> <input type="text"
								class="form-control" name="size" id="price">

						</div>
						<div class="form-group">
							<label for="category">Màu sắc</label> <input type="text"
								class="form-control" name="color" id="price">
						</div>
						<div class="form-group">
							<form:label path="SP_SoLuong" for="category">Số lượng</form:label>
							<form:input path="SP_SoLuong" type="number" class="form-control"
								name="qty" id="qty" />
							<form:errors path="SP_SoLuong" class="badge badge-danger" />

						</div>
						<div class="form-group">
							<label for="description">Mô tả</label>
							<textarea class="form-control" rows="4" name="description"
								id="description"></textarea>

						</div>
					</div>
					<div class="col-6">
						<div class="row h-50 d-flex flex-column">
							<h5 class="text-center mb-0">Ảnh sản phẩm</h5>
							<div class="d-flex flex-column">
								<div id="selectedImages" class="carousel slide"
									data-ride="carousel">
									<div class="carousel-inner"></div>
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
											type="file" multiple onchange="displaySelectedImages(this)">
									</div>
								</div>
							</div>
						</div>
						<div class="row h-50">
							<h5 class="text-center w-100 mb-0">Thông số chi tiết</h5>
							<table class="table">
								<thead class="thead-light">
									<tr>
										<th>Tiêu đề</th>
										<th>Nội dung</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><form:input path="CTSP_MoTa" type="text"
												class="form-control" placeholder="Nhập tiêu đề" /></td>
										<td><form:input path="CTSP_MoTa" type="text"
												class="form-control" placeholder="Nhập nội dung" /></td>
										<form:errors path="CTSP_MoTa" class="badge badge-danger" />

									</tr>
									<tr>
										<td><input type="text" class="form-control"
											placeholder="Nhập tiêu đề"></td>
										<td><input type="text" class="form-control"
											placeholder="Nhập nội dung"></td>
									</tr>
									<tr>
										<td><input type="text" class="form-control"
											placeholder="Nhập tiêu đề"></td>
										<td><input type="text" class="form-control"
											placeholder="Nhập nội dung"></td>
									</tr>
									<tr>
										<td><input type="text" class="form-control"
											placeholder="Nhập tiêu đề"></td>
										<td><input type="text" class="form-control"
											placeholder="Nhập nội dung"></td>
									</tr>
									<!-- Các hàng tiếp theo tương tự -->
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<button type="submit" class="btn btn-primary mt-3">THÊM SẢN
					PHẨM</button>
			</form:form>
		</div>
		<div class="tab-pane fade" id="nav-profile" role="tabpanel"
			aria-labelledby="nav-profile-tab">
			<table
				class="table-hover table mt-3 text-center justify-content-center">
				<thead class="thead-light">
					<tr>
						<th scope="col">#</th>
						<th scope="col" class="w-25">Tên SP</th>
						<th scope="col" class="w-25">Loại</th>
						<th scope="col" class="w-25">Hình ảnh</th>
						<th scope="col" class="w-25">Thao tác</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row" class="align-middle">1</th>
						<td class="align-middle">Loa Bluetooth SamSung</td>
						<td class="align-middle">Điện Tử</td>
						<td class="align-middle"><img class="img-thumbnail"
							width="50%"
							src="https://images.wallpaperscraft.com/image/single/context_word_text_825858_1280x720.jpg">
						</td>
						<td colspan="2" class="align-middle">
							<button formaction="" class="btn btn-lg btn-warning mr-3">
								<i class="fa-solid fa-pen-to-square"></i> Sửa
							</button>
							<button formaction="" class="btn btn-lg btn-danger ">
								<i class="fa-solid fa-trash-can"></i> Xóa
							</button>
						</td>
					</tr>
					<tr>
						<th scope="row" class="align-middle">1</th>
						<td class="align-middle">Loa Bluetooth SamSung</td>
						<td class="align-middle">Điện Tử</td>
						<td class="align-middle"><img class="img-thumbnail"
							width="50%"
							src="https://images.wallpaperscraft.com/image/single/context_word_text_825858_1280x720.jpg">
						</td>
						<td colspan="2" class="align-middle">
							<button formaction="" class="btn btn-lg btn-warning mr-3">
								<i class="fa-solid fa-pen-to-square"></i> Sửa
							</button>
							<button formaction="" class="btn btn-lg btn-danger ">
								<i class="fa-solid fa-trash-can"></i> Xóa
							</button>
						</td>
					</tr>
					<tr>
						<th scope="row" class="align-middle">1</th>
						<td class="align-middle">Loa Bluetooth SamSung</td>
						<td class="align-middle">Điện Tử</td>
						<td class="align-middle"><img class="img-thumbnail"
							width="50%"
							src="https://images.wallpaperscraft.com/image/single/context_word_text_825858_1280x720.jpg">
						</td>
						<td colspan="2" class="align-middle">
							<button formaction="" class="btn btn-lg btn-warning mr-3">
								<i class="fa-solid fa-pen-to-square"></i> Sửa
							</button>
							<button formaction="" class="btn btn-lg btn-danger ">
								<i class="fa-solid fa-trash-can"></i> Xóa
							</button>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="tab-pane fade" id="nav-contact" role="tabpanel"
			aria-labelledby="nav-contact-tab">
			<div
				class="d-flex flex-row align-items-center justify-content-center">
				<img alt="" src="/views/images/team/7bee.png">
				<h2>Tính năng đang được phát triển</h2>
			</div>

		</div>
	</div>
</div>