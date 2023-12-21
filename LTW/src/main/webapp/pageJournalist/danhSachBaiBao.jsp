<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/main.css" rel="stylesheet">
</head>
<body>
		<jsp:include page="/header.jsp"></jsp:include>
	<jsp:useBean id="baos" type="java.util.ArrayList" scope="request"></jsp:useBean>
	<div class="container">
		<h1 class="fs-25">Danh sách các bài báo của bạn</h1>
		<div class="col-lg-10 ma">
			<c:forEach items="${baos }" var="bao">
			<div class="row border">
				<div class="col-lg-10 space flex ">
					<div class="col-lg-4">
						<img alt=""
							src="${bao.getFilePath()}"
							class="card-img">
					</div>
					<div class="col-lg-8 br">
						<label class="find-title">${bao.getTieuDe()}</label><br> <label
							class="find-descrip">${bao.getMoTa()}</label>
					</div>
				</div>
				<div class="col-lg-2 button">
					<a href="EditServlet?type=edit&maBaiBao=${bao.getMaBaiBao() }" class="btn">Chỉnh
						sửa</a> <a href="EditServlet?type=remove&maBaiBao=${bao.getMaBaiBao()}" class="btn">Xóa</a>
				</div>
			</div>
			
			
			</c:forEach>
		</div>
	</div>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>