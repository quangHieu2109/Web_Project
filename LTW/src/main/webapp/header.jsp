<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
	integrity="sha512-Avb2QiuDEEvB4bZJYdft2mNjVShBftLdPG8FJ0V7irTLQ8Uo0qcPxh4Plq7G5tGm0rU+1SPhVotteLpBERwTkw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<style type="text/css">
.label2 {
	font-size: 25px;
	font-weight: 600;
	position: relative;
	height: max-content;
	margin-top: auto;
	margin-bottom: auto;
	z-index: 4;
}

.label2:hover .div2 {
	display: block;
}

.div2 {
	display: none;
	position: absolute;
	margin-top: 5px; /* Điều chỉnh khoảng cách giữa .label2 và .div2 */
	width: max-content;
	right: -120%;
	border: 1px solid;
	border-color: #bebaba;
	border-radius: 5px;
	z-index: 2;
	background-color: white;
	padding-right: 20px;
}

.div2::before {
	content: "";
	position: absolute;
	width: 100%;
	height: 15%;
	top: -10%;
	height: 15%;
}

li {
	margin-top: 15px;
	list-style: none;
}

.nav {
	position: sticky;
	top: 0;
	z-index: 2;
	font-size: 200%;
}
.nav {
	padding: 5px 15px;
	border-radius: 5px;
	font-size: 20px;
	font-weight: 600;
	background-color: #932048e8;
	border: 1px solid;
	display: flex;
	justify-content: space-between;
	width: 90%;
	margin: auto;
	position: relative;
	display: flex;
}
@media ( max-width : 1060px) {
	.nav {
		display: none; /* Ẩn khi màn hình có chiều rộng tối đa là 1060px */
	}
}

.nav a {
	text-decoration: none;
	color: white;
}

.nav-item {
	padding: 5px;
	width: max-content;
	position: relative;
}

.nav-item:hover .nav-itemlist {
	display: block;
}

.nav-itemlist {
	position: absolute;
	display: none;
	width: max-content;
	border: 1px solid;
	border-color: gray;
	background-color: #932048e8;
	border-radius: 5px;
	margin-top: 10px;
	z-index: 1;
}

.nav-itemlist a {
	text-decoration: none;
	color: white;
}

li {
	list-style: none;
	margin-bottom: 10px;
}

ul {
	padding-left: 15px;
	padding-right: 30px;
}

.search {
	display: flex;
	margin: auto;
	margin-right: 5%;
	font-size: 30px;
}

.search input {
	display: block;
	width: 300px;
	height: 30px;
/* 	margin: auto; */
	margin-right: 10px;
	border-radius: 7px;
}
.search i {
margin-right: 0}
</style>
</head>
<body>


	<div
		style="display: flex; margin: 0 10% 0 10%; justify-content: space-between;">
		<div>
			<a href="" style="display: block; height: max_content;"><img
				alt="logo"
				src="https://tse4.mm.bing.net/th?id=OIP._IfEaUssjZQwZ1u92b1_GgHaEK&pid=Api&P=0&h=180"
				style="max-height: 100px"> </a>
		</div>
		<div class="search">
			<input type="text"> <i class="fa-solid fa-magnifying-glass"></i>
		</div>

		<div
			style="margin-top: auto; margin-bottom: auto; display:  ${newsService.getIsLogin()?"none":"flex"}; width: max-content; justify-content: space-between;">
			<a href="LoginServlet"
				style="padding: 12px; font-size: 20px; border-radius: 7px; color: white; font-weight: 600; background: #363628ed; text-decoration: none; text-align: center; margin-right: 20px;">Đăng
				nhập</a> <a href="RegisterServlet"
				style="padding: 12px; font-size: 20px; border-radius: 7px; color: white; font-weight: 600; background: #363628ed; text-decoration: none; text-align: center;">Đăng
				ký</a>
		</div>
		<div class="label2" style="display: ${newsService.getIsLogin()?"block":"none"}">
			<label>Xin chào ...</label>
			<div class="div2">
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
					<li><a href=""
						style="text-decoration: none; color: black; margin-top: 10px">Đăng
							xuất</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- Navbar -->
	<div class="nav">
		<div class="nav-item">
			<a href="" style="padding: 15px;"><i class="fa-solid fa-house"></i></a>
		</div>
		<div class="nav-item">
			<a href="">Thời sự</a>
			<div class="nav-itemlist">
				<ul>
					<li><a href="">Chính trị</a></li>
					<li><a href="">Lao động</a></li>
					<li><a href="">Giáo dục</a></li>
					<li><a href="">Giao thông</a></li>
				</ul>
			</div>
		</div>
		<div class="nav-item">
			<a href="">Thế giới</a>
			<div class="nav-itemlist">
				<ul>
					<li><a href="">Tư liệu</a></li>
					<li><a href="">Cuộc sống</a></li>
					<li><a href="">Quân sự</a></li>
				</ul>
			</div>
		</div>
		<div class="nav-item">
			<a href="">Kinh doanh</a>
			<div class="nav-itemlist">
				<ul>
					<li><a href="">Quốc tế</a></li>
					<li><a href="">Doanh nghiệp</a></li>
					<li><a href="">Chứng khoáng</a></li>
					<li><a href="">Bảo hiểm</a></li>
				</ul>
			</div>
		</div>
		<div class="nav-item">
			<a href="">Bất động sản</a>
			<div class="nav-itemlist">
				<ul>
					<li><a href="">Chính sách</a></li>
					<li><a href="">Thị trường</a></li>
					<li><a href="">Dự án</a></li>
					<li><a href="">Tư vấn</a></li>
				</ul>
			</div>
		</div>
		<div class="nav-item">
			<a href="">Thể thao</a>
			<div class="nav-itemlist">
				<ul>
					<li><a href="">Bóng đá</a></li>
					<li><a href="">Lịch thi đấu</a></li>
					<li><a href="">Tennis</a></li>
					<li><a href="">Marathon</a></li>
				</ul>
			</div>
		</div>
		<div class="nav-item">
			<a href="">Giáo dục</a>
			<div class="nav-itemlist">
				<ul>
					<li><a href="">Tin tức</a></li>
					<li><a href="">Tuyển sinh</a></li>
					<li><a href="">Du học</a></li>
					<li><a href="">Học tiếng Anh</a></li>
					<li><a href="">Giáo dục 4.0</a></li>
				</ul>
			</div>
		</div>
		<div class="nav-item">
			<a href="">Đời sống</a>
			<div class="nav-itemlist">
				<ul>
					<li><a href="">Nhịp sống</a></li>
					<li><a href="">Tổ ấm</a></li>
					<li><a href="">Cooking</a></li>
					<li><a href="">Tiêu dùng</a></li>
				</ul>
			</div>
		</div>
		<div class="nav-item">
			<a href="">Du lịch</a>
			<div class="nav-itemlist">
				<ul>
					<li><a href="">Điểm đến</a></li>
					<li><a href="">Ăm thực</a></li>
					<li><a href="">Cẩm nang</a></li>
					<li><a href="">Tư vấn</a></li>
				</ul>
			</div>
		</div>
		<div class="nav-item">
			<a href="">Xe</a>
			<div class="nav-itemlist">
				<ul>
					<li><a href="">Thị trường</a></li>
					<li><a href="">Diễn đàn</a></li>
					<li><a href="">Thi bằng lái</a></li>
					<li><a href="">Mu bán</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- end navbar -->
</body>
</html>