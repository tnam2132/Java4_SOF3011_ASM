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
label {
	font-size: 20px;
}

.container {
	margin: 70px auto;
	width: 450px;
	height: 500px;
	border: 13px double #858585;
	box-shadow: 10px 10px 5px 5px #888888;
}

.form-control {
	margin-bottom: 30px;
}

a {
	text-decoration: none;
}

.btn {
	width: 180px;
	margin-left: 5px;
}

h6 {
	margin-top: 25px;
	text-align: center;
}
</style>
</head>
<body>
	<div class="container pt-4">
		<h1 style="margin-bottom: 25px; text-align: center;">Đăng nhập</h1>
		<form action="/assignment/login" method="POST">
			<div class="mb-2">
				<label class="form-label">Tên tài khoản</label> <input type="text"
					name="username" class="form-control" required maxlength="25"
					value="namnt">
			</div>
			<div class="mb-2">
				<label class="form-label">Mật khẩu</label> <input type="password"
					name="password" class="form-control" required maxlength="16"
					value="12345678@">
			</div>
			<div class="mb-2 row">
				<div class="col-sm-6">
					<button type="submit" class="btn btn-success">Đăng nhập</button>
				</div>
				<div class="col-sm-6">
					<a href="/assignment/may-giat" class="btn btn-primary">Hủy</a>
				</div>
			</div>
			<div class="mb-2">
				<h6>
					<a href="/assignment/register">Đăng ký</a>
				</h6>
				<h6>
					<a href="/assignment/forgotpassword">Quên mật khẩu</a>
				</h6>
			</div>
		</form>
	</div>

</body>
</html>