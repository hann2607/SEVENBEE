<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html class="no-js" lang="zxx">

<!-- login-register31:27-->
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Login Register || limupa - Digital Products Store
	eCommerce Bootstrap 4 Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon" href="images/favicon.png">
<!-- Material Design Iconic Font-V2.2.0 -->
<link rel="stylesheet" href="css/material-design-iconic-font.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="css/font-awesome.min.css">
<!-- Font Awesome Stars-->
<link rel="stylesheet" href="css/fontawesome-stars.css">
<!-- Meanmenu CSS -->
<link rel="stylesheet" href="css/meanmenu.css">
<!-- owl carousel CSS -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<!-- Slick Carousel CSS -->
<link rel="stylesheet" href="css/slick.css">
<!-- Animate CSS -->
<link rel="stylesheet" href="css/animate.css">
<!-- Jquery-ui CSS -->
<link rel="stylesheet" href="css/jquery-ui.min.css">
<!-- Venobox CSS -->
<link rel="stylesheet" href="css/venobox.css">
<!-- Nice Select CSS -->
<link rel="stylesheet" href="css/nice-select.css">
<!-- Magnific Popup CSS -->
<link rel="stylesheet" href="css/magnific-popup.css">
<!-- Bootstrap V4.1.3 Fremwork CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Helper CSS -->
<link rel="stylesheet" href="css/helper.css">
<!-- Main Style CSS -->
<link rel="stylesheet" href="style.css">
<!-- Responsive CSS -->
<link rel="stylesheet" href="css/responsive.css">
<!-- Modernizr js -->
<script src="js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<body>
	<script>
		if ("${message}" != "") {
			alert("${message}");
		}
	</script>

	<div class="body-wrapper">
		<div class="breadcrumb-area">
			<div class="container">
				<div class="breadcrumb-content">
					<ul>
						<li><a href="index.html">Trang chủ</a></li>
						<li class="active">Đăng nhập</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- Li's Breadcrumb Area End Here -->
		<!-- Begin Login Content Area -->
		<div class="page-section mb-60">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 col-md-12 col-xs-12 col-lg-6 mb-30">
						<!-- Login Form s-->
						<form:form action="/user/login" modelAttribute="userLog">
							<div class="login-form">
								<h4 class="login-title">Đăng nhập</h4>
								<div class="row">
									<div class="col-md-12 col-12 mb-20">
										<label>Số điện thoại*</label> <input name="username"
											class="mb-0" type="tel" placeholder="090xxxxxx" />

									</div>
									<div class="col-12 mb-20">
										<label>Mật khẩu</label> <input name="password" class="mb-0"
											type="password" placeholder="Mật khẩu" />

									</div>
									<div class="col-md-8">
										<div class="check-box d-inline-block ml-0 ml-md-2 mt-10">
											<input name="rememberMe" value="true" type="checkbox" id="rememberMe" />
											<label for="rememberMe">Lưu đăng nhập</label>
										</div>
									</div>
									<div class="col-md-4 mt-10 mb-20 text-left text-md-right">
										<a href="#"> Quên mật khẩu?</a>
									</div>
									<div class="col-md-12">
										<button formaction="/user/login" class="register-button mt-0">Đăng
											nhập</button>
									</div>
								</div>
							</div>
						</form:form>
					</div>
					<div class="col-sm-12 col-md-12 col-lg-6 col-xs-12">
						<form:form action="#" modelAttribute="nguoidung">
							<div class="login-form">
								<h4 class="login-title">Đăng ký</h4>
								<div class="row">
									<div class="col-md-6 col-12 mb-20">
										<form:label path="Ho_ten">Họ tên</form:label>
										<form:input path="Ho_ten" class="mb-0" type="text" />
										<form:errors path="Ho_ten" class="badge badge-danger" />
									</div>
									<div class="col-md-6 col-12 mb-20">
										<form:label path="SDT">Số điện thoại</form:label>
										<form:input path="SDT" class="mb-0" type="text" />
										<form:errors path="SDT" class="badge badge-danger" />
									</div>
									<div class="col-md-12 mb-20">
										<form:label path="Email">Email*</form:label>
										<form:input path="Email" class="mb-0" type="email" />
										<form:errors path="Email" class="badge badge-danger" />
									</div>
									<div class="col-md-6 mb-20">
										<form:label path="Matkhau">Mật khẩu</form:label>
										<form:input path="Matkhau" class="mb-0" type="password" />
										<form:errors path="Matkhau" class="badge badge-danger" />
									</div>
									<div class="col-md-6 mb-20">
										<label>Xác nhận mật khẩu</label> <input class="mb-0"
											type="password">

									</div>
									<div class="col-12">
										<button formaction="/user/register"
											class="register-button mt-0">Đăng ký</button>
									</div>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<!-- Login Content Area End Here -->
		<!-- Begin Footer Area -->

	</div>
	<!-- Body Wrapper End Here -->
	<!-- jQuery-V1.12.4 -->
	<script src="js/vendor/jquery-1.12.4.min.js"></script>
	<!-- Popper js -->
	<script src="js/vendor/popper.min.js"></script>
	<!-- Bootstrap V4.1.3 Fremwork js -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Ajax Mail js -->
	<script src="js/ajax-mail.js"></script>
	<!-- Meanmenu js -->
	<script src="js/jquery.meanmenu.min.js"></script>
	<!-- Wow.min js -->
	<script src="js/wow.min.js"></script>
	<!-- Slick Carousel js -->
	<script src="js/slick.min.js"></script>
	<!-- Owl Carousel-2 js -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- Magnific popup js -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<!-- Isotope js -->
	<script src="js/isotope.pkgd.min.js"></script>
	<!-- Imagesloaded js -->
	<script src="js/imagesloaded.pkgd.min.js"></script>
	<!-- Mixitup js -->
	<script src="js/jquery.mixitup.min.js"></script>
	<!-- Countdown -->
	<script src="js/jquery.countdown.min.js"></script>
	<!-- Counterup -->
	<script src="js/jquery.counterup.min.js"></script>
	<!-- Waypoints -->
	<script src="js/waypoints.min.js"></script>
	<!-- Barrating -->
	<script src="js/jquery.barrating.min.js"></script>
	<!-- Jquery-ui -->
	<script src="js/jquery-ui.min.js"></script>
	<!-- Venobox -->
	<script src="js/venobox.min.js"></script>
	<!-- Nice Select js -->
	<script src="js/jquery.nice-select.min.js"></script>
	<!-- ScrollUp js -->
	<script src="js/scrollUp.min.js"></script>
	<!-- Main/Activator js -->
	<script src="js/main.js"></script>
</body>

<!-- login-register31:27-->
</html>
