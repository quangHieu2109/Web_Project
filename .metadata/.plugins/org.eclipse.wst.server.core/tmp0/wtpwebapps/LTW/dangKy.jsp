<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<link rel="stylesheet" href="css/dangKy.css">

</head>
<body>
	<form action="">
		<h1>Đăng ký tài khoản</h1>
		<div class="body">
			<div class="content">
				<h2>Thông tin tài khoản</h2>
				<div class="line">
					<label>Tên đăng nhập</label> <input type="text" name="tenDangNhap">
				</div>
				<div class="line">
					<label>Mật khẩu</label> <input type="password" name="matKhau">
				</div>
				<div class="line">
					<label>Nhập lại mật khẩu</label> <input type="password"
						name="nhapLaiMatKhau">
				</div>
			</div>
			<div class="content">
				<h2>Thông tin người dùng</h2>
				<div class="line">
					<label>Họ tên</label> <input type="text" name="hoTen">
				</div>
				<div class="line">
					<label>Email</label> <input type="email" name="email">
				</div>
				<div class="line">
					<label>Ngày sinh</label> <input type="date" name="ngaySinh">
				</div>
			</div>

		</div>
		<div class="check">
			<input type="checkbox" name="dongYDK"><label>Đồng ý
				với <a href="">điều khoản</a> của chúng tôi
			</label>
		</div>
		<div class="button">
			<a href="dangNhap.jsp" class="btn">Đăng nhập</a>
			<button type="submit" class="btn">Đăng ký</button>
		</div>
	</form>
</body>
</html>