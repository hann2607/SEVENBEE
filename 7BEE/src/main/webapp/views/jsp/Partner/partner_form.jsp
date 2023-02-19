<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<!-- Button trigger modal -->
	<button type="button" class="btn btn-primary mt-3" data-toggle="modal"
		data-target="#staticBackdrop">THÊM SẢN PHẨM</button>

	<!-- Modal -->
	<div class="modal fade" id="staticBackdrop" data-backdrop="static"
		tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel"
		aria-hidden="true">
		<div class="modal-dialog modal-lg container-fluid" role="document">
			<div class="modal-content px-3 container-sm">
				<div class="modal-header">
					<h5 class="modal-title" style="margin-left: -20px;"
						id="staticBackdropLabel">THÊM SẢN PHẨM</h5>
					<button type="button" class="close" style="margin-right: -20px;"
						data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<h3 class="d-flex justify-content-center m-4 font-weight-bold">THÔNG
					TIN SẢN PHẨM</h3>
				<form enctype="multipart/form-data">
					<div class="row">
						<div class="col-6">
							<div class="form-group">
								<label for="tensp">Tên sản phẩm</label> <input type="text"
									class="form-control" name="tensp" id="name"
									placeholder="Nhập Tên sản phẩm" required />
								<div class="invalid-feedback">Vui lòng nhập tên đăng nhập.</div>
							</div>
							<div class="form-group">
								<label for="category">Chọn Loại</label> <select
									class="form-control" id="category" name="category">
									<option>
								</select>
							</div>
							<div class="form-group">
								<label for="price">Giá</label> <input type="number"
									class="form-control" name="price" id="price" placeholder="Giá" />
							</div>
							<div class="form-group">
								<label for="category">Chọn Kích thước</label> <select
									class="form-control" id="size" name="size">
									<option>
								</select>
							</div>
							<div class="form-group">
								<label for="category">Chọn Màu sắc</label> <select
									class="form-control" id="color" name="color">
									<option>
								</select>
							</div>
							<div class="form-group">
								<label for="description">Mô tả</label>
								<textarea class="form-control" rows="6" name="description"
									id="description"></textarea>
							</div>
						</div>
						<div class="col-6">
							<p class="text-center">Ảnh sản phẩm</p>

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
							<div class="row d-lg-flex justify-content-center">
								<div class="file-input btn">
									<span><i class="fa-regular fa-image"></i> Chọn ảnh</span> <input
										type="file" multiple name="images"
										onchange="displaySelectedImages(this)">
								</div>
							</div>
						</div>

					</div>
				</form>
				<div class="modal-footer d-flex justify-content-between">
					<button type="button" class="btn btn-danger" data-dismiss="modal">
						<i class="fa-solid fa-right-to-bracket"></i> Đóng tác vụ
					</button>
					<button type="submit"
						class="btn btn-success">
						<i class="fa-solid fa-plus"></i> Thêm Sản Phẩm
					</button>
				</div>
			</div>
		</div>
	</div>
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
				<td class="align-middle"><img class="img-thumbnail" width="50%"
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
				<td class="align-middle"><img class="img-thumbnail" width="50%"
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
				<td class="align-middle"><img class="img-thumbnail" width="50%"
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