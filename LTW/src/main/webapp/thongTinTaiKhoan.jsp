<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin tài khoản</title>
<link href="css/main.css" rel="stylesheet">
<link rel="icon"
	href="${pageContext.request.contextPath}/img/logo_icon3.png"
	type="image/x-icon">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/logo_icon3.png"
	type="image/x-icon">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:useBean id="baos" type="java.util.ArrayList" scope="session"></jsp:useBean>
	<jsp:useBean id="nguoiDung" type="model.NguoiDung" scope="session"></jsp:useBean>
	<div class="container w-80">
		<div class="row border mt-30">
			<div class="custom-file-input avt">
				<form method="POST" action="${pageContext.request.contextPath}/NewsServlet"
			enctype="multipart/form-data" id="my-form">
				<input type="hidden" name="type" value="avt">
				<input type="file" id="file-input" class="hidden-input" accept="image/*" name="file"> <label
					for="file-input" class="file-label" > <img alt=""
					src="${nguoiDung.getAvt() }">
				</label>
				</form>
			</div>

			<div class="in4 ml-5">
				<label class="in4-title">${nguoiDung.getHoVaTen() }</label> <label
					class="in4-amt">${baos.size() } Bài báo</label>
			</div>
		</div>
		<div class="row space mt-30">
			<div class="col-lg-4 border h-max">
				<ul class="ul">
					Thông tin

					<li class="li mt-30">Email: ${nguoiDung.getEmail() }</li>
					<li class="li">Ngày sinh: ${nguoiDung.getNgaySinh() }</li>
					<li class="li">Loại tài khoản: ${nguoiDung.loaiTaiKhoan() }</li>
				</ul>
			</div>
			<div class="col-lg-8 border  list-news">
				<div class="title">
					<label class="text-center">Các bài đăng</label>
				</div>
				<div class="row">
					<c:forEach items="${baos }" var="bao">
						<div class="col-lg-12 space flex border-t padding-10">
							<div class="col-lg-4">
								<img alt="" src="${bao.getFilePath()}" class="card-img">
							</div>
							<div class="col-lg-8 ">
								<label class="find-title line-2 font-22">${bao.getTieuDe()}</label>
								<label class="find-descrip line-3 font-18">${bao.getMoTa()}</label>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		document.getElementById('file-input').addEventListener('change',
				function() {
					document.getElementById('my-form').submit();
				});
	</script>
</body>
</html>