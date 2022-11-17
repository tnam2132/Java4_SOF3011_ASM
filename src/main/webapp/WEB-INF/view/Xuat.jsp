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
a {
	text-decoration: none;
}
</style>
</head>
<body>
		<h1 style="text-align: center;">Thông tin máy giặt được thêm</h1>
		<table border="1" class="table table-bordered table-hover table-sm">
			<thead class="table-dark">
				<tr>
					<th>Mã</th>
					<th>Tên</th>
					<th>Loại máy giặt</th>
					<th>Công suất</th>
					<th>Mô tả</th>
					<th>Giá</th>
					<th>Số lượng</th>
					<th>Người tạo</th>
					<th>Thời điểm tạo</th>
					<th>Người thay đổi cuối</th>
					<th>Thời điểm thay đổi cuối</th>
					<th>Đã xóa</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${mg.ma}</td>
					<td>${mg.ten}</td>
					<td>${mg.loaiMayGiat}</td>
					<td>${mg.congSuat}</td>
					<td>${mg.moTa}</td>
					<td>${mg.gia}</td>
					<td>${mg.soLuong}</td>
					<td>${mg.nguoiTao}</td>
					<td><fmt:formatDate value="${mg.thoiDiemTao}"
							pattern="hh:mm dd/MM/yyyy" /></td>
					<td>${mg.nguoiThayDoiCuoi}</td>
					<td><fmt:formatDate value="${mg.thoiDiemThayDoiCuoi}"
							pattern="hh:mm dd/MM/yyyy" /></td>
					<td><c:if test="${mg.daXoa eq true}">Đã xóa </c:if> <c:if
							test="${mg.daXoa eq false}">Chưa xóa</c:if></td>
				</tr>
			</tbody>
		</table>
		<button type="button" class="btn btn-outline-primary">
			<a href="/assignment/may-giat">Danh sách máy giặt</a>
		</button>
</body>
</html>