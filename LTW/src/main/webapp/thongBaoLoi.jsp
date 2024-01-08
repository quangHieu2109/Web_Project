<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link rel="icon"
	href="${pageContext.request.contextPath}/img/logo_icon3.png"
	type="image/x-icon">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/logo_icon3.png"
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

.form {
	border: 1px solid;
	min-width: 60%;
	max-width: max-content;
	margin: auto;
	margin-top: 5%;
	padding-bottom: 30px;
}

label {
	text-wrap: nowrap;
	font-size: 25px;
	margin: auto;
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

.error {
	width: max-content;
	color: red;
	font-weight: 600;
	margin: auto;
	margin-top: 10%;
	color: red;
}

.error label {
	font-size: 40px;
}

.line {
	flex-direction: column;
}
</style>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:useBean id="error" class="java.lang.String" scope="request"></jsp:useBean>


	<form action="UserServlet" method="post" class="form">
		<input type="hidden" name="type" value="login">
		<h1>Thông báo</h1>
		<div class="body">
			<div class="content">


				<div class="line">
					<label>Chức năng này chỉ dành cho Admin. </label> <label>Vui
						lòng sử dụng chức năng khác! </label>
				</div>
			</div>
		</div>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>