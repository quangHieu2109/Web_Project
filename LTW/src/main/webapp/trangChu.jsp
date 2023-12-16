<%@page import="model.NewsService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/main.css" rel="stylesheet">
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:useBean id="baos" class="java.util.ArrayList" scope="session"></jsp:useBean>
	<c:set value="${baos}" var="news"></c:set>
	<div class="container">
		<div class="row">

			<!-- Menu left -->
			<div class="col-lg-2">
				<div class="list-group border">
					<span style="font-size: 20px; font-weight: bold; color: #9F224E">Xu
						hướng</span> <a href="#" class="list-group-item"> <span
						class="text-danger " style="font-size: 18px; font-weight: bold;">Viễn
							cảnh ảm đạm</span> / Giấc mơ chủ nhà trọ tan vỡ ở Đà Lạt
					</a> <a href="#" class="list-group-item"> <span class="text-danger"
						style="font-size: 18px; font-weight: bold;">Một chiều</span> /
						Thời đại mạng xã hội, giáo viên ngày càng sợ phụ huynh
					</a> <a href="#" class="list-group-item"> <span class="text-danger"
						style="font-size: 18px; font-weight: bold;">Nhận con nuôi</span> /
						Bà mẹ Mỹ nuôi hai đứa trẻ mồ côi song sinh người Việt
					</a> <a href="#" class="list-group-item"> <span class="text-danger"
						style="font-size: 18px; font-weight: bold;">Nhu cầu tăng</span> /
						Giá gạo tăng cao kỷ lục
					</a> <a href="#" class="list-group-item"> <span class="text-danger"
						style="font-size: 18px; font-weight: bold;">Chuyển mình</span> /
						Tân Hòa: Vươn lên từ nông thôn khó khăn đến du lịch xuất sắc
					</a>
				</div>

			</div>
			<!-- 				End menu left -->
			<!--product-->

			<div class="col-lg-7">
				<div class="row">
					<!-- 				ô lớn ở giữa -->
					<div class="col-lg-12 col-md-6 mb-4">
						<div class="card h-200" style="width: 100%;">
							<a href="read?maBaiBao=${news[0].getMaBaiBao() }"><div class="row no-gutters">
									<div class="col-md-8">
										<img src="${news[0].getFilePath()}" class="card-img"
											alt="Hình ảnh">
									</div>
									<div class="col-md-4">
										<div class="card-body">
											<h5 class="card-title">${news[0].getTieuDe()}</h5>
											<p class="card-text">${news[0].getMoTa()}</p>
										</div>
									</div>
								</div></a>
						</div>
					</div>
					<!-- 						end ô lớn ở giữa -->
					<!-- 						3 ô nhỏ ở dưới -->
					<div class="row  mt-15">
						<div class="card h-200 " style="width: 31%;">
								<a href="read?maBaiBao=${news[1].getMaBaiBao() }"><div class="row no-gutters">
									<div class="col-md-12">
										<img src="${news.get(1).getFilePath()}" class=" card-img-3"
											alt="Hình ảnh">
									</div>
									<div class="row">
										<div class="card-body">
											<h5 class="card-title">${news.get(1).getTieuDe()}</h5>
											<p class="card-text">${news.get(1).getMoTa()}</p>
										</div>
									</div>
								</div></a>
							</div>
						<div class="card h-200 ml-3"
							style="width: 31%; margin-left: 3.5%; margin-right: 3.5%">
							<a href="read?maBaiBao=${news[2].getMaBaiBao() }"><div class="row no-gutters">
									<div class="col-md-12">
										<img src="${news.get(2).getFilePath()}" class="card-img-3"
											alt="Hình ảnh">
									</div>
									<div class="row">
										<div class="card-body">
											<h5 class="card-title">${news.get(2).getTieuDe()}</h5>
											<p class="card-text">${news.get(2).getMoTa()}</p>
										</div>
									</div>

								</div></a>
						</div>
						<div class="card h-200 " style="width: 31%;">
							<a href="read?maBaiBao=${news[3].getMaBaiBao() }"><div class="row no-gutters">
									<div class="col-md-12">
										<img src="${news.get(3).getFilePath()}" class="card-img-3"
											alt="Hình ảnh">
									</div>
									<div class="row">
										<div class="card-body">
											<h5 class="card-title">${news.get(3).getTieuDe()}</h5>
											<p class="card-text">${news.get(3).getMoTa()}</p>
										</div>
									</div>

								</div> </a>
						</div>
					</div>
					<!-- end 3 ô nhỏ -->




				</div>

				<!--end product-->

			</div>
			<!-- 			top view right -->
			<div class="col-lg-3">
				<div class="list-group border">
					<span style="font-size: 20px; font-weight: bold; color: #9F224E">Top
						view</span> <a href="#" class="list-group-item"> <span
						class="text-danger " style="font-size: 18px; font-weight: bold;">Viễn
							cảnh ảm đạm</span> / Giấc mơ chủ nhà trọ tan vỡ ở Đà Lạt
					</a> <a href="#" class="list-group-item"> <span class="text-danger"
						style="font-size: 18px; font-weight: bold;">Một chiều</span> /
						Thời đại mạng xã hội, giáo viên ngày càng sợ phụ huynh
					</a> <a href="#" class="list-group-item"> <span class="text-danger"
						style="font-size: 18px; font-weight: bold;">Nhận con nuôi</span> /
						Bà mẹ Mỹ nuôi hai đứa trẻ mồ côi song sinh người Việt
					</a> <a href="#" class="list-group-item"> <span class="text-danger"
						style="font-size: 18px; font-weight: bold;">Nhu cầu tăng</span> /
						Giá gạo tăng cao kỷ lục
					</a> <a href="#" class="list-group-item"> <span class="text-danger"
						style="font-size: 18px; font-weight: bold;">Chuyển mình</span> /
						Tân Hòa: Vươn lên từ nông thôn khó khăn đến du lịch xuất sắc
					</a>
				</div>
				<!-- end top view right -->
			</div>
			
				<div class="container mt-4 w-80">
				<div class="row space w-80">
					<c:forEach var="bao" items="${baos}" begin="4">
						<div class=" border col-lg-4 mt-30">
							<a href="read?maBaiBao="${bao.getMaBaiBao() }">
								<div class="col-md-12">
									<img src="${bao.getFilePath()}" class="card-img-3"
										alt="Hình ảnh">
								</div>
								<div class="col-md-12">
									<div class="card-body">
										<h5 class="card-title">${bao.getTieuDe()}</h5>
										<p class="card-text">${bao.getMoTa()}</p>
									</div>
								</div>
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
			
			<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>