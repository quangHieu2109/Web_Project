<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thay đổi thông tin</title>
<link rel="icon"
	href="${pageContext.request.contextPath}/img/logo_icon3.png"
	type="image/x-icon">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/logo_icon3.png"
	type="image/x-icon">
<link rel="stylesheet" href="css/dangKy.css">

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:useBean id="nguoiDung" type="model.NguoiDung" scope="session"></jsp:useBean>
	<form action="${pageContext.request.contextPath}/UserServlet" method="post" id="myform">
	<input type="hidden" name="type" value="editIn4">
	<jsp:useBean id="thongBao" class="java.lang.String" scope="request"></jsp:useBean>
	<div class="thongBao">
		<c:if test="${thongBao.length() >0 }">
			<label>${thongBao }</label>
		</c:if>
	</div>
		<h1>Thay đổi thông tin tài khoản</h1>
		<div class="body">
			<div class="content">
				<table>
					<tr>
						<th>Tên đăng nhập</th>
						<td><input type="text" name="tenDangNhap" id="tenDangNhap"
							value="${nguoiDung.getTenDangNhap()}" disabled="disabled"></td>
					</tr>
					<tr>
						<th>Mật khẩu</th>
						<td><input type="password" name="matKhau" id="matKhau"
							required="required" value="${nguoiDung.getMatKhau()}"></td>
					</tr>
					<tr>
						<th>Nhập lại mật khẩu</th>
						<td><input type="password" name="nhapLaiMatKhau"
							id="nhapLaiMatKhau" value="${nguoiDung.getMatKhau()}"></td>
					</tr>
				</table>
			</div>
			<div class="content">
				<table>
					<tr>
						<th>Họ tên</th>
						<td><input type="text" name="hoTen" id="hoTen"
							value="${nguoiDung.getHoVaTen()}"></td>
					</tr>
					<tr>
						<th>Email</th>
						<td><input type="email" name="email" id="email"
							required="required" value="${nguoiDung.getEmail()}"></td>
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
			<button type="button" class="btn margin-a" onclick="submitForm()">Lưu
				thay đổi</button>
		</div>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
		var ngaySinhInput = document.getElementById('ngaySinh');
		var ngaySinhValue = "${nguoiDung.getNgaySinh()}";
		ngaySinhInput.value = ngaySinhValue;
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

			if (tenDangNhap === "" || matKhau === "" || nhapLaiMatKhau === ""
					|| hoTen === "" || email === "" || ngaySinh === "") {
				alert('Vui lòng nhập đầy đủ thông tin');
			} else {
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