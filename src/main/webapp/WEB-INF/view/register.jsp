<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<style type="text/css">
h1 {
	text-align: center;
}

label {
	font-size: 20px;
}

.container {
	margin: 0 auto;
	width: 500px;
	height: 600px;
	border: 13px double #858585;
	box-shadow: 10px 10px 5px 5px #888888;
}

.form-control {
	margin-bottom: 20px;
}

a {
	text-decoration: none;
}

.btn {
	width: 180px;
	margin-top: 12px;
	margin-left: 13px;
}

.error {
	color: red;
}
</style>
</head>
<body>
	<div class="container pt-5">
		<h1>Đăng ký</h1>
		<c:if test="${message != null}">
			<div class="error">${message}</div>
		</c:if>
		<form action="/assignment/register" method="POST">
			<div class="mb-2">
				<label class="form-label">Tên tài khoản</label> <input type="text"
					name="username" class="form-control" required maxlength="50">
			</div>
			<div class="mb-2">
				<label class="form-label">Họ và tên</label> <input type="text"
					name="hoten" class="form-control" required maxlength="50"
					value="${hoten}">
			</div>
			<div class="mb-2">
				<label class="form-label">Mật khẩu</label> <input type="password"
					name="password" class="form-control" required maxlength="16">
			</div>
			<div class="mb-2">
				<label class="form-label">Xác nhận mật khẩu</label> <input
					type="password" name="confirmpassword" class="form-control"
					required maxlength="16">
			</div>
			<div class="mb-2 row">
				<div class="col-sm-6">
					<button type="submit" class="btn btn-danger">Đăng ký</button>
				</div>
				<div class="col-sm-6">
					<a href="/assignment/login" class="btn btn-primary">Hủy</a>
				</div>
			</div>
		</form>
	</div>

</body>
</html>