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

	<jsp:include page="header.jsp"></jsp:include>
	<jsp:useBean id="baos" class="java.util.ArrayList" scope="session"></jsp:useBean>
	<jsp:useBean id="key" class="java.lang.String" scope="request"></jsp:useBean>
	<div class="container">
		<div class="col-md-8 mg-a">
			<label class="keyword">Từ khóa: ${key}</label>
			<c:forEach items="${baos}">
				<div class="row space">
					<div class="col-lg-4">
						<img alt="" src="${baos.filePath}" class="card-img">
					</div>
					<div class="col-lg-8">
						<label class="find-title">${baos.tieuDe}</label><br> <label
							class="find-descrip">${baos.moTa}</label>
					</div>
				</div>
				<hr>
			</c:forEach>


		</div>

	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>