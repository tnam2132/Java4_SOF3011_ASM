<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin máy giặt</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<style>
.container {
	margin: 40px auto;
	width: 900px;
	height: 600px;
	border: 13px double #858585;
	box-shadow: 10px 10px 5px 5px #888888;
}

label {
	font-size: 20px;
}

input {
	margin: 5px 0 10px 0;
}
</style>
</head>
<body>
	<div class="container pt-3">
		<h1 style="text-align: center;">Điền thông tin máy giặt</h1>
		<form action="/assignment/insert" method="POST">
			<div class="row">
				<div class="form-group col-sm-6">
					<label>Tên :</label> <input class="form-control" name="ten"
						value="LG111" />
				</div>
				<div class="form-group col-sm-6">
					<label>Loại máy giặt :</label> <input class="form-control"
						name="loaiMayGiat" value="nam ngang" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-6">
					<label>Công suất :</label> <input class="form-control"
						name="congSuat" value="1000" />
				</div>
				<div class="form-group col-sm-6">
					<label>Giá :</label> <input class="form-control" name="gia"
						value="2000" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-6">
					<label>Mô tả :</label> <input class="form-control" name="moTa"
						value="TK Nhat Ban" />
				</div>
				<div class="form-group col-sm-6">
					<label>Số lượng :</label> <input class="form-control"
						name="soLuong" value="300" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-6">
					<label>Người tạo :</label> <input class="form-control"
						name="nguoiTao" value="${sessionScope.username}" readonly="readonly" />
				</div>
				<div class="form-group col-sm-6">
					<label>Người thay đổi cuối :</label> <input class="form-control"
						name="nguoiThayDoiCuoi" value="${sessionScope.username}" readonly="readonly" />
				</div>
			</div>
			<button type="Submit" class="btn btn-outline-dark"
				style="margin-top: 10px;">Submit</button>

		</form>
	</div>
</body>
</html>