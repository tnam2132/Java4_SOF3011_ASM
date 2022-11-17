<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhập máy giặt</title>
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

.error {
	color: red;
	font-size: 15px;
}
</style>
</head>
<body>
	<div class="container pt-3">
		<h1 style="margin-bottom: 25px; text-align: center;">Cập nhập
			thông tin máy giặt</h1>
		<form action="/assignment/may-giat/update" method="POST">
			<div class="row">
				<input class="form-control" name="ma" value="${mg.ma}"
					readonly="readonly" hidden />
				<div class="form-group col-sm-6">
					<label>Tên :</label> <input class="form-control" name="ten"
						value="${mg.ten}" />
				</div>
				<div class="form-group col-sm-6">
					<label>Công suất :</label> <input class="form-control"
						name="congSuat" value="${mg.congSuat}"  maxlength="16"/>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-6">
					<label>Giá :</label> <input class="form-control" name="gia"
						value="${mg.gia}" maxlength="16"/>
				</div>
				<div class="form-group col-sm-6">
					<label>Loại máy giặt :</label> <input class="form-control"
						name="loaiMayGiat" value="${mg.loaiMayGiat}" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-6">
					<label>Số lượng :</label> <input class="form-control"
						name="soLuong" value="${mg.soLuong}" maxlength="10"/>
				</div>
				<div class="form-group col-sm-6">
					<label>Mô tả :</label> <input class="form-control" name="moTa"
						value="${mg.moTa}" />
				</div>
			</div>
			<div class="row">
				<div class="form-group col-sm-6">
					<label>Người tạo :</label> <input class="form-control"
						name="nguoiTao" value="${mg.nguoiTao}" readonly="readonly" />
				</div>
				<div class="form-group col-sm-6">
					<label>Người thay đổi cuối :</label> <input class="form-control"
						name="nguoiThayDoiCuoi" value="${sessionScope.username}"
						readonly="readonly" />
				</div>

			</div>
			<div class="row">
				<div class="form-group col-sm-6">
					<label>Thời điểm tạo:</label> <input class="form-control"
						name="thoidiemtao" value="${mg.thoiDiemTao}" readonly="readonly" />
				</div>
				<div class="form-group col-sm-6 gg1" style="margin-top: 37px;">
					<label>Trạng thái : </label><label><input type="radio"
						name="daXoa" checked="checked" value="false">Chưa xóa</label> <label><input
						type="radio" name="daXoa" value="true" />Đã xóa</label>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<button type="Submit" class="btn btn-success"
						style="margin-top: 10px;">Cập nhập</button>
					<a style="margin-top: 10px;" href="/assignment/may-giat"
						class="btn btn-primary">Hủy</a>
				</div>
				<div class="col-sm-6">
					<c:if test="${message != null}">
						<div class="error" style="margin-top: 15px;">${message}</div>
					</c:if>
				</div>
			</div>
		</form>
	</div>
</body>
</html>