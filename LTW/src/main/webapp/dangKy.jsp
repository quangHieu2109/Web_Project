<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<link rel="icon"
	href="${pageContext.request.contextPath}/img/logo_icon2.png"
	type="image/x-icon">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/logo_icon2.png"
	type="image/x-icon">
<link rel="stylesheet" href="css/dangKy.css">

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<form action="RegisterServlet" method="post">
		<h1>Đăng ký tài khoản</h1>
		<div class="body">
			<div class="content">
				<table>
					<tr>
						<th>Tên đăng nhập</th>
						<td><input type="text" name="tenDangNhap"></td>
					</tr>
					<tr>
						<th>Mật khẩu</th>
						<td><input type="password" name="matKhau"></td>
					</tr>
					<tr>
						<th>Nhập lại mật khẩu</th>
						<td><input type="password" name="nhapLaiMatKhau"></td>
					</tr>
				</table>
				</div>
				<div class="content">
					<table>
						<tr>
							<th>Họ tên</th>
							<td><input type="text" name="hoTen"></td>
						</tr>
						<tr>
							<th>Email</th>
							<td><input type="email" name="email"></td>
						</tr>
						<tr>
							<th>Ngày sinh</th>
							<td><input type="date" name="ngaySinh"></td>
						</tr>
					</table>
				</div>

			</div>
<!-- 			<div class="check"> -->
<!-- 				<input type="checkbox" name="dongYDK"><label>Đồng ý -->
<!-- 					với <a href="">điều khoản</a> của chúng tôi -->
<!-- 				</label> -->
<!-- 			</div> -->
			<div class="button">
				<a href="LoginServlet" class="btn">Đăng nhập</a>
				<button type="submit" class="btn">Đăng ký</button>
			</div>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>