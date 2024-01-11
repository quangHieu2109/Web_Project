<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<link rel="icon"
	href="${pageContext.request.contextPath}/img/logo_icon3.png"
	type="image/x-icon">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/logo_icon3.png"
	type="image/x-icon">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/dangKy.css">

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<form action="${pageContext.request.contextPath}/UserServlet" method="post" id="myform">
	<input type="hidden" name="type" value="register">
		<h1>Đăng ký tài khoản</h1>
		<div class="body">
			<div class="content">
				<table>
					<tr>
						<th>Tên đăng nhập</th>
						<td><input type="text" name="tenDangNhap" id="tenDangNhap"></td>
					</tr>
					<tr>
						<th>Mật khẩu</th>
						<td><input type="password" name="matKhau" id="matKhau"
							required="required"></td>
					</tr>
					<tr>
						<th>Nhập lại mật khẩu</th>
						<td><input type="password" name="nhapLaiMatKhau"
							id="nhapLaiMatKhau"></td>
					</tr>
				</table>
			</div>
			<div class="content">
				<table>
					<tr>
						<th>Họ tên</th>
						<td><input type="text" name="hoTen" id="hoTen"></td>
					</tr>
					<tr>
						<th>Email</th>
						<td><input type="email" name="email" id="email"
							required="required"></td>
					</tr>
					<tr>
						<th>Ngày sinh</th>
						<td><input type="date" name="ngaySinh" id="ngaySinh"
							required="required"></td>
					</tr>
				</table>
			</div>

		</div>
		<div class="button">
			<a href="${pageContext.request.contextPath}/UserServlet?type=dangNhap" class="btn">Đăng nhập</a>
			<button type="button" class="btn" onclick="submitForm()">Đăng
				ký</button>
		</div>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
		function submitForm() {
			var email = document.getElementById('email').value;
			var gmailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{1,}$/;
			var myform = document.getElementById('myform');
			var date = new Date(document.getElementById('ngaySinh').value);
			var ngaySinh = document.getElementById('ngaySinh').value;
			var matKhau = document.getElementById('matKhau').value;
			var tenDangNhap = document.getElementById('matKhau').value;
			var hoTen = document.getElementById('matKhau').value;
			var nhapLaiMatKhau = document.getElementById('nhapLaiMatKhau').value;
			
			if(tenDangNhap ==="" || matKhau ==="" || nhapLaiMatKhau ==="" || hoTen === "" || email ===""||ngaySinh===""){
				alert('Vui lòng nhập đầy đủ thông tin');
			}else{
				if (matKhau !== nhapLaiMatKhau) {
					alert('Mật khẩu nhập lại không chính xác');
				} else if (!gmailRegex.test(email)) {
					alert('Email không hợp lệ');

				} else if (date > new Date()) {
					alert('Ngày sinh không hợp lệ');

				} else {
					myform.submit();

				}
			}
		}
	</script>
</body>
</html>