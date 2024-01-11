<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css"
	integrity="sha512-Avb2QiuDEEvB4bZJYdft2mNjVShBftLdPG8FJ0V7irTLQ8Uo0qcPxh4Plq7G5tGm0rU+1SPhVotteLpBERwTkw=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="icon"
	href="${pageContext.request.contextPath}/img/logo_icon3.png"
	type="image/x-icon">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/logo_icon3.png"
	type="image/x-icon">
</head>
<style type="text/css">
.rounded-circle {
	border-radius: 50%;
}

.user {
	display: flex;
	cursor: pointer;
}

.user i {
	display: block;
	margin-top: auto;
	margin-bottom: auto;
	margin-left: 5px;
}

.label2 {
	font-size: 15px;
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
	/* 	font-size: 200%; */
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

.search form {
	display: flex;
}

.search i {
	margin-right: 0
}
</style>
</head>
<body>
	<jsp:useBean id="nguoiDung" type="model.NguoiDung" scope="session"></jsp:useBean>
	<jsp:useBean id="path" class="java.lang.String" scope="application"></jsp:useBean>

	<div
		style="display: flex; margin: 0 10% 0 10%; justify-content: space-between;">
		<div>
			<a href="${pageContext.request.contextPath}/MainServlet" style="display: block; height: max_content;"><img
				alt="logo" src="
				${path}/img/logo3.png" type="image/x-icon"
				style="max-height: 100px; max-width: 100%;"> </a>
		</div>
		<div class="search">
			<form action="${pageContext.request.contextPath}/NewsServlet" id="searchForm">
				<input type="hidden" name="typeSearch" value="seachByTen"> <input
					type="hidden" name="type" value="search"> <input
					type="text" name="txtSearch"> <i
					class="fa-solid fa-magnifying-glass" id="search" onclick="search()"></i>
			</form>
		</div>
		<div
			style="margin-top: auto; margin-bottom: auto; display:  ${nguoiDung.getTenDangNhap() == null ? "flex" : "none"}; width:max-content; justify-content:space-between;">

			<a href="${pageContext.request.contextPath}/UserServlet?type=dangNhap"
				style="padding: 12px; font-size: 20px; border-radius: 7px; color: white; font-weight: 600; background: #363628ed; text-decoration: none; text-align: center; margin-right: 20px;">Đăng
				nhập</a> <a href="${pageContext.request.contextPath}/UserServlet?type=dangKy"
				style="padding: 12px; font-size: 20px; border-radius: 7px; color: white; font-weight: 600; background: #363628ed; text-decoration: none; text-align: center;">Đăng
				ký</a>
		</div>
		<div class="user label2" onclick="toggleDropdown('div2')"
			style="display:  ${nguoiDung.getTenDangNhap() != null ? "flex" : "none"}">
			<img src="${nguoiDung.getAvt() }" alt="mdo" width="32" height="32"
				class="rounded-circle"> <i class="fa-solid fa-angle-down"></i>

			<div class="div2" id="div2">
				<ul>
					<li><a href="${pageContext.request.contextPath}/NewsServlet?type=dangBao"
						style="text-decoration: none; color: black;">Đăng bài</a></li>
					<c:if test="${nguoiDung.isAdmin() }">
					<li><a href="${pageContext.request.contextPath}/UserServlet?type=dangKyDangBai&typeDK=danhSach"
						style="text-decoration: none; color: black;">Danh sách đăng ký</a></li>
					</c:if>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?typeShow=danhSachBaiBao&type=showList"
						style="text-decoration: none; color: black;">Danh sách bài báo</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?typeShow=trangCaNhan&type=showList"
						style="text-decoration: none; color: black;">Thông tin tài
							khoản</a></li>
					<li><a href="${pageContext.request.contextPath}/thayDoiThongTin.jsp"
						style="text-decoration: none; color: black;">Thay đổi thông
							tin</a></li>
					<li style="height: 1px; margin: 0; list-style: none;"><hr
							class=""></li>
					<li><a href="${pageContext.request.contextPath}/UserServlet?type=logout"
						style="text-decoration: none; color: black; margin-top: 10px">Đăng
							xuất</a></li>
				</ul>
				</ul>
			</div>
		</div>
	</div>
	</div>
	<!-- Navbar -->
	<div class="nav">
		<div class="nav-item">
			<a href="${pageContext.request.contextPath}/MainServlet" style="padding: 15px;"><i
				class="fa-solid fa-house"></i></a>
		</div>
		<div class="nav-item">
			<a
				href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=thoisu">Thời
				sự</a>
			<div class="nav-itemlist">
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=thoisu&theLoaiPhu=chinhtri">Chính
							trị</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=thoisu&theLoaiPhu=laodong">Lao
							động</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=thoisu&theLoaiPhu=dansinh">Dân
							sinh</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=thoisu&theLoaiPhu=giaothong">Giao
							thông</a></li>
				</ul>
			</div>
		</div>
		<div class="nav-item">
			<a
				href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=thegioi">Thế
				giới</a>
			<div class="nav-itemlist">
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=thegioi&theLoaiPhu=tulieu">Tư
							liệu</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=thegioi&theLoaiPhu=cuocsong">Cuộc
							sống</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=thegioi&theLoaiPhu=quansu">Quân
							sự</a></li>
				</ul>
			</div>
		</div>
		<div class="nav-item">
			<a
				href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=kinhdoanh">Kinh
				doanh</a>
			<div class="nav-itemlist">
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=kinhdoanh&theLoaiPhu=quocte">Quốc
							tế</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=kinhdoanh&theLoaiPhu=doanhnghiep">Doanh
							nghiệp</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=kinhdoanh&theLoaiPhu=chungkhoan">Chứng
							khoán</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=kinhdoanh&theLoaiPhu=baohiem">Bảo
							hiểm</a></li>
				</ul>
			</div>
		</div>
		<div class="nav-item">
			<a
				href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=batdongsan">Bất
				động sản</a>
			<div class="nav-itemlist">
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=batdongsan&theLoaiPhu=chinhsach">Chính
							sách</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=batdongsan&theLoaiPhu=thitruong">Thị
							trường</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=batdongsan&theLoaiPhu=duan">Dự
							án</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=batdongsan&theLoaiPhu=tuvan">Tư
							vấn</a></li>
				</ul>
			</div>
		</div>
		<div class="nav-item">
			<a
				href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=thethao">Thể
				thao</a>
			<div class="nav-itemlist">
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=thethao&theLoaiPhu=bongda">Bóng
							đá</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=thethao&theLoaiPhu=lichthidau">Lịch
							thi đấu</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=thethao&theLoaiPhu=tennis">Tennis</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=thethao&theLoaiPhu=marathon">Marathon</a></li>
				</ul>
			</div>
		</div>
		<div class="nav-item">
			<a
				href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=giaoduc">Giáo
				dục</a>
			<div class="nav-itemlist">
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=giaoduc&theLoaiPhu=tintuc">Tin
							tức</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=giaoduc&theLoaiPhu=tuyensinh">Tuyển
							sinh</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=giaoduc&theLoaiPhu=tuyensinh">Du
							học</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=giaoduc&theLoaiPhu=hoctienganh">Học
							tiếng Anh</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=giaoduc&theLoaiPhu=giaoduc40">Giáo
							dục 4.0</a></li>
				</ul>
			</div>
		</div>
		<div class="nav-item">
			<a
				href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=doisong">Đời
				sống</a>
			<div class="nav-itemlist">
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=doisong&theLoaiPhu=nhipsong">Nhịp
							sống</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=doisong&theLoaiPhu=toam">Tổ
							ấm</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=doisong&theLoaiPhu=cooking">Cooking</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=doisong&theLoaiPhu=tieudung">Tiêu
							dùng</a></li>
				</ul>
			</div>
		</div>
		<div class="nav-item">
			<a
				href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=dulich">Du
				lịch</a>
			<div class="nav-itemlist">
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=dulich&theLoaiPhu=diemden">Điểm
							đến</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=dulich&theLoaiPhu=amthuc">Ăm
							thực</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=dulich&theLoaiPhu=camnang">Cẩm
							nang</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=dulich&theLoaiPhu=tuvan">Tư
							vấn</a></li>
				</ul>
			</div>
		</div>
		<div class="nav-item">
			<a
				href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=xe">Xe</a>
			<div class="nav-itemlist">
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=xe&theLoaiPhu=thitruong">Thị
							trường</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=xe&theLoaiPhu=diendan">Diễn
							đàn</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=xe&theLoaiPhu=thibanglai">Thi
							bằng lái</a></li>
					<li><a
						href="${pageContext.request.contextPath}/NewsServlet?type=search&typeSearch=searchByTheLoai&theLoaiChinh=xe&theLoaiPhu=muaban">Mua
							bán</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- end navbar -->
	<script type="text/javascript">
		function search() {
			var form = document.getElementById('searchForm');
			form.submit();
		}
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