<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
<link rel="stylesheet" href="css/dangKy.css">
<style type="text/css">
.content {
	display: block;
	margin: auto;
}

button {
	display: flex;
	/* 	justify-content: space-between; */
	font-size: 20px;
	margin: auto;
}

a {
	text-decoration: none;
}

.button2 {
	width: 60%;
	display: flex;
	justify-content: space-between;
	font-size: 20px;
	margin: auto;
	display: flex;
}

h1 {
	font-size: 50px;
	margin-bottom: 50px;
}

form {
	border: 1px solid;
	width: 40%;
	margin: auto;
	margin-top: 10%;
	padding-bottom: 30px;
}
</style>

</head>
<body>
	<form action="">
		<h1>Đăng nhập tài khoản</h1>
		<div class="body">
			<div class="content">
				<div class="line">
					<label>Tên đăng nhập</label> <input type="text" name="tenDangNhap">
				</div>
				<div class="line">
					<label>Mật khẩu</label> <input type="password" name="matKhau">
				</div>


				<div class="button2">
					<a href="dangKy.jsp" class="btn">Đăng ký</a>
					<button type="submit" class="btn">Đăng nhập</button>
				</div>
			</div>
	</form>
</body>
</html>