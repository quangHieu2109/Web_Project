<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/main.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:useBean id="bao" class="model.BaiBao" scope="session"></jsp:useBean>
	<div class="container">
		<div class="row space  w-80">
			<div class="col-lg-8">
				<div class="dateTime">
					<label>${bao.getNgayDang()}</label>
				</div>
				<div class="title">
					<label>${bao.getTieuDe()}</label>
				</div>
				<div class="descrip">
					<label>${bao.getMoTa()}</label>
				</div>
				<div>
					<img alt=""
						src="${bao.getFilePath()}"
						class="card-img">
				</div>
				<div class="content">
					<label>${bao.getNoiDung()}</label>
				</div>
			</div>

			<div class="col-lg-4 ml-5">
				<div class="list-group border sticky">
					<span
						style="font-size: 20px; font-weight: bold; color: #9F224E; padding: 10px">Xem
						nhiều</span> <a href="#" class="list-group-item">
						<div class="row">
							<div class="col-md-4">
								<img alt=""
									src="https://i1-vnexpress.vnecdn.net/2023/12/06/VNEPlan-1701832660-8253-1701832713.jpg?w=300&h=180&q=100&dpr=1&fit=crop&s=VKgb_lY8XxyD6S-QVwdIAw"
									class="card-img">
							</div>
							<div class="col-md-8">
								<label class="center">Siêu tàu container chạy bằng lò
									phản ứng muối nóng chảy</label>
							</div>
						</div>
					</a> <a href="#" class="list-group-item">
						<div class="row">
							<div class="col-md-4">
								<img alt=""
									src="https://i1-vnexpress.vnecdn.net/2023/12/06/VNEPlan-1701832660-8253-1701832713.jpg?w=300&h=180&q=100&dpr=1&fit=crop&s=VKgb_lY8XxyD6S-QVwdIAw"
									class="card-img">
							</div>
							<div class="col-md-8">
								<label class="center">Siêu tàu container chạy bằng lò
									phản ứng muối nóng chảy</label>
							</div>
						</div>
					</a> <a href="#" class="list-group-item">
						<div class="row">
							<div class="col-md-4">
								<img alt=""
									src="https://i1-vnexpress.vnecdn.net/2023/12/06/VNEPlan-1701832660-8253-1701832713.jpg?w=300&h=180&q=100&dpr=1&fit=crop&s=VKgb_lY8XxyD6S-QVwdIAw"
									class="card-img">
							</div>
							<div class="col-md-8">
								<label class="center">Siêu tàu container chạy bằng lò
									phản ứng muối nóng chảy</label>
							</div>
						</div>
					</a> <a href="#" class="list-group-item">
						<div class="row">
							<div class="col-md-4">
								<img alt=""
									src="https://i1-vnexpress.vnecdn.net/2023/12/06/VNEPlan-1701832660-8253-1701832713.jpg?w=300&h=180&q=100&dpr=1&fit=crop&s=VKgb_lY8XxyD6S-QVwdIAw"
									class="card-img">
							</div>
							<div class="col-md-8">
								<label class="center">Siêu tàu container chạy bằng lò
									phản ứng muối nóng chảy</label>
							</div>
						</div>
					</a>

				<a href="#" class="list-group-item">
						<div class="row">
							<div class="col-md-4">
								<img alt=""
									src="https://i1-vnexpress.vnecdn.net/2023/12/06/VNEPlan-1701832660-8253-1701832713.jpg?w=300&h=180&q=100&dpr=1&fit=crop&s=VKgb_lY8XxyD6S-QVwdIAw"
									class="card-img">
							</div>
							<div class="col-md-8">
								<label class="center">Siêu tàu container chạy bằng lò
									phản ứng muối nóng chảy</label>
							</div>
						</div>
					</a>
				<a href="#" class="list-group-item">
						<div class="row">
							<div class="col-md-4">
								<img alt=""
									src="https://i1-vnexpress.vnecdn.net/2023/12/06/VNEPlan-1701832660-8253-1701832713.jpg?w=300&h=180&q=100&dpr=1&fit=crop&s=VKgb_lY8XxyD6S-QVwdIAw"
									class="card-img">
							</div>
							<div class="col-md-8">
								<label class="center">Siêu tàu container chạy bằng lò
									phản ứng muối nóng chảy</label>
							</div>
						</div>
					</a>
				
				</div>
			</div>
			</div>
	<div class="row space w-80">
	<div class="col-lg-8">
	<div class="comment">
	<h3>Bình luận</h3>
	<textarea rows="7" cols="" wrap="soft"></textarea>
	<button>Bình luận</button>
	 </div>
	
	</div>
	
	</div>
		
	</div>

		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>