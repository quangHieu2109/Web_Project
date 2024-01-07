<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách đăng ký</title>
<link href="css/main.css" rel="stylesheet">
<link rel="icon"
	href="${pageContext.request.contextPath}/img/logo_icon3.png"
	type="image/x-icon">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/logo_icon3.png"
	type="image/x-icon">
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<jsp:useBean id="danhSachDK" type="java.util.ArrayList" scope="session"></jsp:useBean>
	<div class="container">
		<h1 class="fs-25">Danh sách đăng ký làm nhà báo</h1>
		<div class="col-lg-10 ma">
			<c:forEach items="${danhSachDK}" var="ds">
				<div class="row border">
					<div class="col-lg-2 avt-cmt mtb-10">
						<img alt="" src="${ds.getNguoiDung().getAvt() }">
					</div>
					<div class="col-lg-7 mtb-10">
						<div class="head-cmt">
							<label class="title-cmt">${ds.getNguoiDung().getHoVaTen() }</label>
							<label class="date-cmt">${ds.getNgayDK() }</label>
						</div>
						<div class="div-in4">
						<label>Ngày sinh: ${ds.getNguoiDung().getNgaySinh() }</label>
						<label>Email: ${ds.getNguoiDung().getEmail() }</label>
						</div>

					</div>
					<div class="col-lg-3 button">
						<a href="UserServlet?type=dangKyDangBai&typeDK=chapNhan&maDK=${ds.getMaDK() }"
							class="btn">Chấp nhận</a> <a
							href="UserServlet?type=dangKyDangBai&typeDK=xoa&maDK=${ds.getMaDK() }"
							class="btn">Xóa</a>
					</div>
				</div>




			</c:forEach>
		</div>
	</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>