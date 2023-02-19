<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Begin Li's Breadcrumb Area -->
<div class="breadcrumb-area">
	<div class="container">
		<div class="breadcrumb-content">
			<ul>
				<li><a href="/">TRANG CHỦ</a></li>
				<li class="active">LIÊN HỆ</li>
			</ul>
		</div>
	</div>
</div>
<!-- Li's Breadcrumb Area End Here -->
<!-- Begin Contact Main Page Area -->
<div class="contact-main-page mt-60 mb-40 mb-md-40 mb-sm-40 mb-xs-40">
	<div class="container mb-60">
		<iframe
			src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.4322647643116!2d106.62551690157714!3d10.854690195801494!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317528dfcf546de7%3A0xf872809fb8deded!2zVHLGsMahzIBuZyBDYW8gxJDEg8yJbmcgRlBUIFBvbHl0ZWNobmljIEjhu5MgQ2jDrSBNaW5o!5e0!3m2!1svi!2s!4v1676773591190!5m2!1svi!2s"
			width="600" height="700" style="border: 0;" allowfullscreen=""
			loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-5 offset-lg-1 col-md-12 order-1 order-lg-2">
				<div class="contact-page-side-content">
					<h3 class="contact-page-title">LIÊN HỆ VỚI CHÚNG TÔI</h3>
					<p class="contact-page-message mb-25">Nếu bạn cần được tư vấn
						hay liên hệ với chúng tôi. Chúng tôi có đội ngũ chuyên viên tư vấn
						chuyên nghiệp túc trực 24/7 - "Nếu bạn cần SENVENBEE sẽ có mặt".</p>
					<div class="single-contact-block">
						<h4>
							<i class="fa fa-fax"></i> ĐỊA CHỈ
						</h4>
						<p>Quận 12, TP Hồ Chí Minh, Việt Nam</p>
						<p>Quận Bình Thạnh, TP Hồ Chí Minh, Việt Nam</p>
						<p>Quận 9, TP Hồ Chí Minh, Việt Nam</p>
					</div>
					<div class="single-contact-block">
						<h4>
							<i class="fa fa-phone"></i> ĐIỆN THOẠI
						</h4>
						<p>ĐIỆN THOẠI: (+84) 1234 567 89</p>
						<p>ĐƯỜNG DÂY NÓNG: (+84) 9847 724 10</p>
					</div>
					<div class="single-contact-block last-child">
						<h4>
							<i class="fa fa-envelope-o"></i> EMAIL
						</h4>
						<p>sevenbee.7bee@gmail.com</p>
						<p>ledangduong@gmail.com</p>
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-md-12 order-2 order-lg-1">
				<div class="contact-form-content pt-sm-55 pt-xs-55">
					<h3 class="contact-page-title">GÓP Ý</h3>
					<div class="contact-form">
						<form:form action="/contact/feedback" modelAttribute="gopy">
							<div class="form-group">
								<form:label path="GOPY_HoTen">HỌ VÀ TÊN <span
										class="text-danger">*</span>
								</form:label>
								<form:input path="GOPY_HoTen" type="text" name="customerName"
									id="customername" />
								<form:errors path="GOPY_HoTen" class="badge badge-danger" />

							</div>
							<div class="form-group">
								<form:label path="GOPY_email">EMAIL <span
										class="text-danger">*</span>
								</form:label>
								<form:input path="GOPY_email" type="email" name="customerEmail"
									id="customerEmail" />
								<form:errors path="GOPY_email" class="badge badge-danger" />

							</div>
							<div class="form-group mb-30">
								<form:label path="NoiDung">NỘI DUNG GÓP Ý</form:label>
								<form:textarea path="NoiDung" name="contactMessage"
									id="contactMessage"></form:textarea>
								<form:errors path="NoiDung" class="badge badge-danger" />
							</div>
							<div class="form-group">
								<button class="li-btn-3" formaction="/contact/feedback">GỬI
									ĐI</button>
							</div>
						</form:form>
					</div>
					<c:if test="${not empty message }">
						<div class="alert alert-success" id="success">${message }</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Contact Main Page Area End Here -->