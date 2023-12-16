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
			<c:forEach var="bao" items="${baos}" varStatus="status">
				<a href="read?maBaiBao=${bao.getMaBaiBao() }"><div class="row space">
					<div class="col-lg-4">
						<img alt="" src="${bao.getFilePath()}" class="card-img">
					</div>
					<div class="col-lg-8">
						<label class="find-title">${bao.getTieuDe()}</label><br> <label
							class="find-descrip">${bao.getMoTa()}</label>
					</div>
				</div></a>
				<hr>
			</c:forEach>


		</div>

	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>