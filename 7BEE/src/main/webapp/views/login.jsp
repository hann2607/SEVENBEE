<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>

<head>
<meta charset='utf-8'>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>LOGIN</title>
<link
	href='https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css'
	rel='stylesheet'>
<link href='' rel='stylesheet'>
<style>
@import
	url(https://fonts.googleapis.com/css?family=Roboto:300,400,700&display=swap)
	;

body {
	background: /* top, transparent black, faked with gradient */
		linear-gradient( rgba( 0, 0, 0, 0.5), rgba( 0, 0, 0, 0.5)),
		/* bottom, image */
    
		url(https://img.gs/czjpqfbdkz/full/https://raw.githubusercontent.com/mov-rax-rbx/rsmatrix/3a5a42c5dd585c707637d9f62f7c93f95405d7f7/gif/preview2.gif);
}

@media only screen and (max-width: 767px) {
	.hide-on-mobile {
		display: none;
	}
}

.login-box {
	border-radius: 20px;
	background-size: cover;
	background-position: center;
	padding: 50px;
	margin: 8% auto;
	min-height: 700px;
	-webkit-box-shadow: 0 2px 60px -5px rgba(0, 0, 0, 0.1);
	box-shadow: 0 2px 60px -5px rgba(0, 0, 0, 0.1);
}

.logo {
	font-family: "Script MT";
	font-size: 54px;
	text-align: center;
	color: #888888;
	margin-bottom: 50px;
}

.logo .logo-font {
	color: #3BC3FF;
}

@media only screen and (max-width: 767px) {
	.logo {
		font-size: 34px;
	}
}

.header-title {
	text-align: center;
	margin-bottom: 50px;
}

.login-form {
	max-width: 300px;
	margin: 0 auto;
}

.login-form .form-control {
	border-radius: 0;
	margin-bottom: 30px;
}

.login-form .form-group {
	position: relative;
}

.login-form .form-group .forgot-password {
	position: absolute;
	top: 6px;
	right: 15px;
}

.login-form .btn {
	border-radius: 0;
	-webkit-box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	margin-bottom: 30px;
}

.login-form .btn.btn-primary {
	background: #3BC3FF;
	border-color: #31c0ff;
}

.slider-feature-card {
	background: #fff;
	max-width: 280px;
	margin: 0 auto;
	padding: 30px;
	text-align: center;
	-webkit-box-shadow: 0 2px 25px -3px rgba(0, 0, 0, 0.1);
	box-shadow: 0 2px 25px -3px rgba(0, 0, 0, 0.1);
}

.slider-feature-card img {
	height: 80px;
	margin-top: 30px;
	margin-bottom: 30px;
}

.slider-feature-card h3, .slider-feature-card p {
	margin-bottom: 30px;
}

.carousel-indicators {
	bottom: -50px;
}

.carousel-indicators li {
	cursor: pointer;
}
</style>
<script type='text/javascript' src=''></script>
<script type='text/javascript'
	src='https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js'></script>
<script type='text/javascript'
	src='https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js'></script>
</head>

<body oncontextmenu='return false' class='snippet-body'>
	<section class="body">
		<div class="container">
			<div class="login-box bg-white">
				<div class="row justify-content-center mt-4">
					<div class="col-sm-6">
						<div class="logo">
							<img alt="" src="images/logo-7bee1.gif">
						</div>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-sm-6">
						<br>
						<h3 class="header-title">LOGIN</h3>
						<form class="login-form" action="/login" method="post">
							<div class="form-group">
								<input type="text" class="form-control"
									placeholder="Email or UserName" name="username"
									value="${cookie.username.value}">
							</div>
							<div class="form-group">
								<input type="Password" class="form-control"
									placeholder="Password" name="password"
									value="${cookie.password.value}"> <a href="#!"
									class="forgot-password">Forgot Password?</a>
							</div>
							<div class="form-check">
								<input type="checkbox" class="form-check-input" id="rememberMe"
									name="rememberMe" value="true"> <label
									class="form-check-label" for="rememberMe">Remember Me?</label>
							</div>
							<div class="form-group mt-4">
								<button type="submit" class="btn btn-primary btn-block"
									formaction="/login">LOGIN</button>
							</div>
							<div class="form-group">
								<div class="text-center">
									New Member? <a href="#!">Sign up Now</a>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script type='text/javascript'></script>
</body>

</html>