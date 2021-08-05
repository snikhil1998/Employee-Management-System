<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Employee Management System - Login</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
			<div style="position: relative; top: 25px">
				<span style="color: red">${requestScope.msg}</span>
			</div>
		</div>
	</body>
</html>