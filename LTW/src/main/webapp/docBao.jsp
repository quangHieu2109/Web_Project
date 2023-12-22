<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đọc báo</title>
<link href="css/main.css" rel="stylesheet">
<link rel="icon"
	href="${pageContext.request.contextPath}/img/logo_icon2.png"
	type="image/x-icon">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/logo_icon2.png"
	type="image/x-icon">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:useBean id="bao" class="model.BaiBao" scope="session"></jsp:useBean>
	<jsp:useBean id="topView" class="java.util.ArrayList" scope="session"></jsp:useBean>
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
					<img alt="" src="${bao.getFilePath()}" class="card-img">
				</div>
				<div class="content">
					<label>${bao.getNoiDung()}</label>
				</div>
			</div>

			<div class="col-lg-4 ml-5">
				<div class="list-group border sticky">
					<span
						style="font-size: 20px; font-weight: bold; color: #9F224E; padding: 10px">Xem
						nhiều</span>
					<c:forEach items="${topView }" var="baoTV">
						<a href="read?maBaiBao=${baoTV.getMaBaiBao() }"
							class="list-group-item">
							<div class="row">
								<div class="col-md-4">
									<img alt="" src="${baoTV.getFilePath() }" class="card-img">
								</div>
								<div class="col-md-8">
									<label class="center">${baoTV.getTieuDe() }</label>
								</div>
							</div>
						</a>
					</c:forEach>

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