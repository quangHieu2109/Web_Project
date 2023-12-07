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
	<jsp:useBean id="newsService" class="model.NewsService" scope="session"></jsp:useBean>
	<c:set var="category" value="${newsService.getDSTheLoai()}"></c:set>
	
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
							<div class="row no-gutters">
								<div class="col-md-8">
									<img
										src="https://i1-english.vnecdn.net/2023/11/07/370594600966424437779483161250-1526-9272-1699357684.jpg?w=500&h=300&q=100&dpr=1&fit=crop&s=ofzTnXjFowCghBME9fFNdA"
										class="card-img" alt="Hình ảnh">
								</div>
								<div class="col-md-4">
									<div class="card-body">
										<h5 class="card-title">Public bike service draws users in
											Hanoi</h5>
										<p class="card-text">More than 100,000 people have
											registered to use Hanoi's public bicycle-sharing service, and
											around 135,000 rides have been made after two months.</p>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- 						end ô lớn ở giữa -->
					<!-- 						3 ô nhỏ ở dưới -->
					<div class="row  mt-15">
						<div class="card h-200 " style="width: 31%;">
							<div class="row no-gutters">
								<div class="col-md-12">
									<img
										src="https://i1-english.vnecdn.net/2023/11/07/370594600966424437779483161250-1526-9272-1699357684.jpg?w=500&h=300&q=100&dpr=1&fit=crop&s=ofzTnXjFowCghBME9fFNdA"
										class=" card-img-3" alt="Hình ảnh">
								</div>
								<div class="row">
									<div class="card-body">
										<h5 class="card-title">Public bike service draws users in
											Hanoi</h5>
										<p class="card-text">More than 100,000 people have
											registered to use Hanoi's ...</p>
									</div>
								</div>

							</div>
						</div>
						<div class="card h-200 ml-3"
							style="width: 31%; margin-left: 3.5%; margin-right: 3.5%">
							<div class="row no-gutters">
								<div class="col-md-12">
									<img
										src="https://i1-english.vnecdn.net/2023/11/07/370594600966424437779483161250-1526-9272-1699357684.jpg?w=500&h=300&q=100&dpr=1&fit=crop&s=ofzTnXjFowCghBME9fFNdA"
										class="card-img-3" alt="Hình ảnh">
								</div>
								<div class="row">
									<div class="card-body">
										<h5 class="card-title">Public bike service draws users in
											Hanoi</h5>
										<p class="card-text">More than 100,000 people have
											registered to use Hanoi's ...</p>
									</div>
								</div>

							</div>
						</div>
						<div class="card h-200 " style="width: 31%;">
							<div class="row no-gutters">
								<div class="col-md-12">
									<img
										src="https://i1-english.vnecdn.net/2023/11/07/396775675250904860965716866076-3816-9433-1699347864.jpg?w=300&h=180&q=100&dpr=1&fit=crop&s=Kemg-DmczBWoH382cx6Njg"
										class="card-img-3" alt="Hình ảnh">
								</div>
								<div class="row">
									<div class="card-body">
										<h5 class="card-title">Public bike service draws users in
											Hanoi</h5>
										<p class="card-text">More than 100,000 people have
											registered to use Hanoi's ...</p>
									</div>
								</div>

							</div>
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
			<div class="container mt-4">
				<div class="row">
					<div class="col-lg-6">
						<div class="row border h-100 mlr-5">
							<div class="col-md-8">
								<img
									src="https://i1-english.vnecdn.net/2023/11/07/370594600966424437779483161250-1526-9272-1699357684.jpg?w=500&h=300&q=100&dpr=1&fit=crop&s=ofzTnXjFowCghBME9fFNdA"
									class="card-img-3" alt="Hình ảnh">
							</div>
							<div class="col-md-4">
								<div class="card-body">
									<h5 class="card-title">Public bike service draws users in
										Hanoi</h5>
									<p class="card-text">More than 100,000 people have
										registered to use Hanoi's public bicycle-sharing service, and
										around 135,000 rides have been made after two months.</p>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="row">
							<div class=" border col-lg-6 ">
								<div class="col-md-12">
									<img
										src="https://i1-english.vnecdn.net/2023/11/07/370594600966424437779483161250-1526-9272-1699357684.jpg?w=500&h=300&q=100&dpr=1&fit=crop&s=ofzTnXjFowCghBME9fFNdA"
										class="card-img-3" alt="Hình ảnh">
								</div>
								<div class="col-md-12">
									<div class="card-body">
										<h5 class="card-title">Public bike service draws users in
											Hanoi</h5>
										<p class="card-text">More than 100,000 people have
											registered to use Hanoi's public bicycle-sharing service, and
											around 135,000 rides have been made after two months.</p>
									</div>
								</div>
							</div>
							<div class=" border col-lg-6">
								<div class="col-md-12">
									<img
										src="https://i1-english.vnecdn.net/2023/11/07/370594600966424437779483161250-1526-9272-1699357684.jpg?w=500&h=300&q=100&dpr=1&fit=crop&s=ofzTnXjFowCghBME9fFNdA"
										class="card-img-3" alt="Hình ảnh">
								</div>
								<div class="col-md-12">
									<div class="card-body">
										<h5 class="card-title">Public bike service draws users in
											Hanoi</h5>
										<p class="card-text">More than 100,000 people have
											registered to use Hanoi's public bicycle-sharing service, and
											around 135,000 rides have been made after two months.</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>