<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Employee Management System - Login</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<link href="styles.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div class="container" style="border: 2px solid black; padding: 30px; margin: 30px;">
			<form action="loginCheck.spring" method="post">
				<div class="form-group" style="position: relative; top: -10px">
					<label for="userid">User ID</label>
					<input type="text" class="form-control" id="userid" name="userid" required>
				</div>
				<div class="form-group" style="position: relative; top: 0px">
					<label for="password">Password</label>
					<input name="password" type="password" class="form-control" id="password" required>
				</div>
				<div style="position: relative; top: 20px">
					<input type="submit" class="btn btn-primary " value="Sign In"/>
				</div>
			</form>
			<div>
				<span style="color: red">${requestScope.msg}</span>
			</div>
		</div>
	</body>
</html>