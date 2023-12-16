<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
	integrity="sha512-Avb2QiuDEEvB4bZJYdft2mNjVShBftLdPG8FJ0V7irTLQ8Uo0qcPxh4Plq7G5tGm0rU+1SPhVotteLpBERwTkw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<style type="text/css">
.rounded-circle {
	border-radius: 50%;
}

.label2 {
	/* 	font-size: 25px; */
	font-weight: 600;
	position: relative;
	height: max-content;
	margin-top: auto;
	margin-bottom: auto;
	z-index: 4;
}

.label2 label {
	text-wrap: nowrap;
}

.div2 {
	display: none;
	position: absolute;
	margin-top: 5px; /* Điều chỉnh khoảng cách giữa .label2 và .div2 */
	width: max-content;
	top: 100%;
	/* 	right: -90%; */
	border: 1px solid;
	border-color: #bebaba;
	border-radius: 5px;
	z-index: 2;
	background-color: white;
	padding-right: 20px;
}
</style>
</head>
<body>
	<div class="user label2" onclick="toggleDropdown('div2')">
		<img src="https://github.com/mdo.png" alt="mdo" width="32" height="32"
			class="rounded-circle"> <i class="fa-solid fa-angle-down"></i>

		<div class="div2" id="div2">
			<ul>
				<li><a href="dangBai.jsp"
					style="text-decoration: none; color: black;">Đăng bài</a></li>
				<li><a href="" style="text-decoration: none; color: black;">Thông
						tin tài khoản</a></li>
				<li><a href="" style="text-decoration: none; color: black;">Thay
						đổi thông tin</a></li>
				<li><a href="" style="text-decoration: none; color: black;">Đổi
						mật khẩu</a></li>
				<li style="height: 1px; margin: 0; list-style: none;"><hr
						class=""></li>
				<li><a href="Logout"
					style="text-decoration: none; color: black; margin-top: 10px">Đăng
						xuất</a></li>
			</ul>
			</ul>
		</div>
	</div>
	<script>
		function toggleDropdown(divId) {
			var dropdown = document.getElementById(divId);
			if (dropdown.style.display === "none"
					|| dropdown.style.display === "") {
				dropdown.style.display = "block";
			} else {
				dropdown.style.display = "none";
			}
		}

		// Ẩn dropdown khi nhấp vào bất kỳ nơi nào trên trang
		document.addEventListener("click", function(event) {
			var dropdowns = document.querySelectorAll('.div2');
			dropdowns.forEach(function(dropdown) {
				if (event.target !== dropdown.previousElementSibling
						&& !dropdown.contains(event.target)) {
					dropdown.style.display = "none";
				}
			});
		});
	</script>
</body>
</html>