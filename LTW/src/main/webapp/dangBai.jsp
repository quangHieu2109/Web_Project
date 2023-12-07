<%@page import="model.DSTheLoai"%>
<%@page import="model.BaiBao"%>
<%@page import="model.TheLoai"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/dangBai.css">
</head>
<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<div>
		<form method="POST" action="UploadServlet" 
					enctype="multipart/form-data" id="myform">
					<input type="hidden" name="type" value="1234" id="type">
			<%
			String img = request.getAttribute("fileName") + "";
			String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();
			
			BaiBao baiBao = (BaiBao) request.getAttribute("baiBao");
			baiBao=(baiBao == null)?new BaiBao():baiBao;
			DSTheLoai theLoai = baiBao.getTheLoai();
			theLoai = (theLoai == null)?new TheLoai():theLoai;
			String tieuDe = (baiBao.getTieuDe() ==null)?"":baiBao.getTieuDe();
			String moTa= (baiBao.getMoTa() == null)?"":baiBao.getMoTa();
			String noiDung=(baiBao.getNoiDung() == null)?"":baiBao.getNoiDung();
			
			%>
			<div class="div TieuDe">
				<label>Tiêu đề</label>
				<textarea rows="1" cols="" wrap="soft" class="tieude" name="tieuDe" value=""><%=tieuDe%></textarea>
			</div>
			<div class="div TheLoai">
			<label>Thể loại</label>
			<div class="theloaiitem">
				<div class="uls">
					<ul class="ul">
						<input type="radio" name="theLoai" id="" value="Thời sự" <%=theLoai.name("Thời sự") %>>
						Thời sự
						<div class="li">
							<li><input type="checkbox" name="Thời sự" value="Chính trị" <%=theLoai.checked("Chính trị") %> >Chính trị</li>
							<li><input type="checkbox" name="Thời sự" value="Lao động" <%=theLoai.checked("Lao động") %>>Lao động</li>
							<li><input type="checkbox" name="Thời sự" value="Giáo dục" <%=theLoai.checked("Giáo dục") %>>Giáo dục</li>
							<li><input type="checkbox" name="Thời sự" value="Giao thông" <%=theLoai.checked("Giao thông") %>>Giao Thông</li>
						</div>
					</ul>
					<ul class="ul">
						<input type="radio" name="theLoai" id="" value="Thế giới" <%=theLoai.name("Thế giới") %>>
						Thế giới
						<div class="li">
							<li><input type="checkbox" name="Thế giới" value="Tư liệu" <%=theLoai.checked("Tư liệu") %>>Tư liệu</li>
							<li><input type="checkbox" name="Thế giới" value="Cuộc sống" <%=theLoai.checked("Cuộc sống") %>>Cuộc sống</li>
							<li><input type="checkbox" name="Thế giới" value="Quân sự" <%=theLoai.checked("Quân sự") %>>Quân sự</li>
					</ul>
					<ul class="ul">
						<input type="radio" name="theLoai" id="" value="Kinh doanh" <%=theLoai.name("Kinh doanh") %>>
						Kinh doanh
						<div class="li">
							<li><input type="checkbox" name="Thế giới" value="Quốc tế" <%=theLoai.checked("Quốc tế") %>>Quốc tế</li>
							<li><input type="checkbox" name="Thế giới" value="Doanh nghiệp" <%=theLoai.checked("Doanh nghiệp") %>>Doanh nghiệp</li>
							<li><input type="checkbox" name="Thế giới" value="Chứng khoáng" <%=theLoai.checked("Chứng khoáng") %>>Chứng khoáng</li>
							<li><input type="checkbox" name="Thế giới" value="Bảo hiểm" <%=theLoai.checked("Bảo hiểm") %>>Bảo hiểm</li>
						</div>
					</ul>
					<ul class="ul">
						<input type="radio" name="theLoai" id="" value="Bất động sản" <%=theLoai.name("Bất động sản") %>>
						Bất động sản
						<div class="li">
							<li><input type="checkbox" name="Bất động sản" value="Chính sách" <%=theLoai.checked("Chính sách") %>>Chính sách</li>
							<li><input type="checkbox"  name="Bất động sản" value="Thị trường" <%=theLoai.checked("Thị trường") %>>Thị trường</li>
							<li><input type="checkbox"  name="Bất động sản" value="Dự án" <%=theLoai.checked("Dự án") %>>Dự án</li>
							<li><input type="checkbox" name="Bất động sản" value="Tư vấn" <%=theLoai.checked("Tư vấn") %>>Tư vấn</li>
						</div>
					</ul>
					<ul class="ul">
						<input type="radio" name="theLoai" id="" value="Thể thao" <%=theLoai.name("Thể thao") %>>Thể
						thao
						<div class="li">
							<li><input type="checkbox" name="Thể thao" value="Bóng đá" <%=theLoai.checked("Bóng đá") %>>Bóng đá</li>
							<li><input type="checkbox"  name="Thể thao" value="Lịch thi đấu" <%=theLoai.checked("Lịch thi đấu") %>>Lịch thi đâu</li>
							<li><input type="checkbox" name="Thể thao" value="Tennis" <%=theLoai.checked("Tennis") %>>Tennis</li>
							<li><input type="checkbox" name="Thể thao" value="Marathon" <%=theLoai.checked("Marathon") %>>Marathon</li>
						</div>
					</ul>
					<ul class="ul">
						<input type="radio" name="theLoai" id="" value="Giáo dục" <%=theLoai.name("Giáo dục") %>>
						Giáo dục
						<div class="li">
							<li><input type="checkbox" name="Giáo dục" value="Tin tức" <%=theLoai.checked("Tin tức") %>>Tin tức</li>
							<li><input type="checkbox" name="Giáo dục" value="Tuyển sinh" <%=theLoai.checked("Tuyển sinh") %>>Tuyển sinh</li>
							<li><input type="checkbox" name="Giáo dục" value="Du học" <%=theLoai.checked("Du học") %>>Du học</li>
							<li><input type="checkbox" name="Giáo dục" value="Học tiếng Anh" <%=theLoai.checked("Học tiếng Anh") %>>Học tiếng Anh</li>
							<li><input type="checkbox" name="Giáo dục" value="Giáo dục 4.0" <%=theLoai.checked("Giáo dục 4.0") %>>Giáo dục 4.0</li>
						</div>
					</ul>
					<ul class="ul">
						<input type="radio" name="theLoai" id="" value="Đời sống" <%=theLoai.name("Đời sống") %>>
						Đời sống
						<div class="li">
							<li><input type="checkbox" name="Đời sống" value="Nhịp sống" <%=theLoai.checked("Nhịp sống") %>>Nhịp sống</li>
							<li><input type="checkbox" name="Đời sống" value="Tổ ấm" <%=theLoai.checked("Tổ ấm") %>>Tổ ấm</li>
							<li><input type="checkbox" name="Đời sống" value="Cooking" <%=theLoai.checked("Cooking") %>>Cooking</li>
							<li><input type="checkbox" name="Đời sống" value="Tiêu dùng" <%=theLoai.checked("Tiêu dùng") %>>Tiêu dùng</li>
						</div>
					</ul>
					<ul class="ul">
						<input type="radio" name="theLoai" id="" value="Du lịch" <%=theLoai.name("Du lịch") %>>Du
						lịch
						<div class="li">
							<li><input type="checkbox" name="Du lịch" value="Điểm đến" <%=theLoai.checked("Điểm đến") %>>Điểm đến</li>
							<li><input type="checkbox"  name="Du lịch" value="Ẩm thực" <%=theLoai.checked("Ẩm thực") %>>Ẩm thực</li>
							<li><input type="checkbox" name="Du lịch" value="Cẩm nang" <%=theLoai.checked("Cẩm nang") %>>Cẩm nang</li>
							<li><input type="checkbox" name="Du lịch" value="Tư vấn" <%=theLoai.checked("Tư vấn") %>>Tư vấn</li>
						</div>
					</ul>
					<ul class="ul">
						<input type="radio" name="theLoai" id="" value="Xe" <%=theLoai.name("Xe") %>>
						Xe
						<div class="li">
							<li><input type="checkbox" name="Xe" value="Thị trường" <%=theLoai.checked("Thị trường") %>>Thị trường</li>
							<li><input type="checkbox" name="Xe" value="Diễn đàn" <%=theLoai.checked("Diễn đàn") %>>Diễn đàn</li>
							<li><input type="checkbox" name="Xe" value="Thi bằng lái" <%=theLoai.checked("Thi bằng lái") %>>Thi bằng lái</li>
							<li><input type="checkbox" name="Xe" value="Mua bán" <%=theLoai.checked("Mua bán") %>>Mua bán</li>
						</div>
					</ul>
				</div>
			</div>
			</div>
			<div class="div MoTa">
				<label>Mô tả</label>
				<textarea rows="5" cols="" wrap="soft" name="moTa"><%=moTa %></textarea>
			</div>
			<div class="div TaiAnh">
			<label>Tải ảnh lên</label>
			<div class="img">
					 <input type="file" accept="image/*"
						value="" name="file" id="file"> <img alt=""
						src="<%=url1%>/img/<%=request.getAttribute("fileName")%>">
					<button type="button" onclick="submitFormUpAnh()">up anh</button>
			</div></div>
			<div class="div NoiDung">
				<label>Nội dung</label>
				<textarea rows="20" cols="" wrap="soft" name="noiDung"><%=noiDung %></textarea>
			</div>
			<div class="divBtn Button"><button type="button" onclick="submitForm()">Đăng bài</button></div>
		</form>

	</div>
	<script type="text/javascript">
		function submitFormUpAnh() {
			var form = document.getElementById('myform');
			var fileInput = document.getElementById('file');
			var type = document.getElementById('type');
			if (fileInput.files.length === 0) {
				alert("Bạn chưa chọn file ảnh!");
			} else {
				type.value="upAnh";
				form.submit();
			}
		}
		function submitForm() {
			var form = document.getElementById('myform');
			var type = document.getElementById('type');
				type.value="dangBai";
				form.submit();
		}
	</script>

	<jsp:include page="footer.jsp" flush="false"></jsp:include>
</body>
</html>