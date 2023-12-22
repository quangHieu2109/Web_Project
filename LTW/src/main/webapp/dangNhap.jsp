<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link rel="icon"
	href="${pageContext.request.contextPath}/img/logo_icon.png"
	type="image/x-icon">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/logo_icon.png"
	type="image/x-icon">
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
	font-size: 40px;
	margin-bottom: 50px;
}

form {
	border: 1px solid;
	min-width: 60%;
	max-width: max-content;
	margin: auto;
	margin-top: 10%;
	padding-bottom: 30px;
}

label {
	text-wrap: nowrap;
	font-size: 25px;
}

.body {
	width: 100%;
}

.line input {
	width: 60%;
}

.content {
	width: 90%;
}
</style>

</head>
<body>

	<form action="LoginServlet" method="post">
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

					<a href="RegisterServlet" class="btn">Đăng ký</a>
					<button type="submit" class="btn">Đăng nhập</button>

				</div>
			</div>
		</div>
	</form>
</body>
</html>