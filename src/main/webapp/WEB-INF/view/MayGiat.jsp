<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="model.AccountRole"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Máy giặt</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<style>
h1 {
	margin-top: 0px;
}

a {
	text-decoration: none;
}

.btn {
	font-size: 18px;
}

h4 {
	color: white;
}

h5 {
	color: white;
	margin-top: 9px;
}

h6 {
	font-size: 16px;
}
</style>
</head>
<body>
	<div>
		<nav class="row">
			<div class="navbar navbar-expand-sm  navbar-dark bg-dark">
				<div class="container-fluid">
					<ul class="navbar-nav">
						<li class="nav-item"><a ng-click="intro=1"
							href="/assignment/may-giat" class="nav-link navbar-brand">
								<h4>Trang chủ</h4>
						</a></li>
						<li class="nav-item">
							<div>
								<c:if test="${sessionScope.username != null}">
									<h5>Tài khoản: ${sessionScope.username} | Vai trò:
										${sessionScope.role}</h5>
								</c:if>
							</div>
						</li>
					</ul>
					<ul class="navbar-nav">
						<li class="nav-item">
							<button type="button" class="btn text-white"
								data-bs-toggle="modal" data-bs-target="#myModal">Bộ lọc</button>
						</li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown">Tài khoản</a>
							<ul class="dropdown-menu">
								<c:if test="${sessionScope.username == null}">
									<li><a class="dropdown-item" href="/assignment/login">Đăng
											nhập</a></li>
									<li><a class="dropdown-item" href="/assignment/register">Đăng
											ký</a></li>
								</c:if>
								<c:if test="${sessionScope.username != null}">
									<li><a class="dropdown-item"
										href="/assignment/may-giat?a=dangxuat">Đăng xuất</a></li>
								</c:if>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
		<article>
			<h1 style="text-align: center; margin: 30px 0;">Danh sách máy
				giặt</h1>
			<table border="1"
				class="table table-bordered table-hover table-sm table-responsive">
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
						<c:if test="${sessionScope.role == AccountRole.ADMIN}">
							<th>Sửa</th>
							<th>Xóa</th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dsMayGiat}" var="mayGiat">
						<tr>
							<td>${mayGiat.ma}</td>
							<td>${mayGiat.ten}</td>
							<td>${mayGiat.loaiMayGiat}</td>
							<td>${mayGiat.congSuat}</td>
							<td>${mayGiat.moTa}</td>
							<td>${mayGiat.gia}</td>
							<td>${mayGiat.soLuong}</td>
							<td>${mayGiat.nguoiTao}</td>
							<td><fmt:formatDate value="${mayGiat.thoiDiemTao}"
									pattern="hh:mm dd/MM/yyyy" /></td>
							<td>${mayGiat.nguoiThayDoiCuoi}</td>
							<td><fmt:formatDate value="${mayGiat.thoiDiemThayDoiCuoi}"
									pattern="hh:mm dd/MM/yyyy" /></td>
							<td><c:if test="${mayGiat.daXoa eq true}">Đã xóa </c:if> <c:if
									test="${mayGiat.daXoa eq false}">Chưa xóa</c:if></td>
							<c:if test="${sessionScope.role == AccountRole.ADMIN}">
								<td><button type="button" class="btn btn-outline-primary">
										<a href="/assignment/may-giat/update?ma=${mayGiat.ma}">Sửa</a></td>
								<td><button type="button" class="btn btn-outline-danger">
										<a href="/assignment/may-giat/delete?ma=${mayGiat.ma}">Xóa</a>
									</button></td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:if test="${sessionScope.username != null}">
				<button class="btn btn-outline-primary">
					<a type="btn btn-dark" href="/assignment/insert">Thêm mới máy
						giặt</a>
				</button>
			</c:if>
		</article>

		<div class="modal" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<div class="modal-header">
						<h3 class="modal-title" style="text-align: center;">Bộ lọc</h3>
						<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
					</div>
					<form action="/assignment/may-giat" method="POST">
						<div class="modal-body">
							<div class="">
								<div class="mb-2">
									<h6>Theo tên:</h6>
									<input type="text" class="form-control" name="timkiem">
								</div>
								<div class="mb-2">
									<h6>Theo giá:</h6>
									<div class="input-group mb-3">
										<span class="input-group-text">Từ</span> <input type="text"
											class="form-control" name="giatu">
									</div>
									<div class="input-group mb-3">
										<span class="input-group-text">Đến</span> <input type="text"
											class="form-control" name="giaden">
									</div>
								</div>
								<div class="mb-2">
									<h6>Theo số lượng:</h6>
									<select class="form-select" name="soluong">
										<option>All</option>
										<option value="DESC">Cao - thấp</option>
										<option value="ASC">Thấp - cao</option>
									</select>
								</div>
								<c:if test="${sessionScope.role == AccountRole.ADMIN}">
									<div class="mb-2">
										<h6>Trạng thái:</h6>
										<select class="form-select" name="daxoa">
											<option>All</option>
											<option value="false">Chưa xóa</option>
											<option value="true">Đã xóa</option>
										</select>
									</div>
								</c:if>
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-success">Xác nhận</button>
							<button type="button" class="btn btn-primary"
								data-bs-dismiss="modal">Hủy</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>