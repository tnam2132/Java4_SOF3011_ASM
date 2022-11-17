<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
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

button {
	width: 222px;
	margin-left: 120px;
}

h6 {
	margin-top: 25px;
	text-align: center;
}
</style>
</head>
<body>

	<div class="container pt-5">
		<h1>Quên mật khẩu</h1>
		<form action="/assignment/login" method="POST">
			<div class="mb-2">
				<label class="form-label">Tên tài khoản</label> <input type="text"
					name="username" class="form-control" required maxlength="25">
			</div>
			<div class="mb-2">
				<label class="form-label">Mã xác nhận gửi qua email</label> <input
					type="text" name="maxacnhan" class="form-control" required
					maxlength="16">
			</div>
			<div class="mb-2">
				<button type="submit" class="btn btn-success">Xác nhận</button>
			</div>
		</form>
	</div>

</body>
</html>