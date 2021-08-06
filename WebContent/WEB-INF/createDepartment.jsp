<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create Department</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<link href="styles.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div class="container" style="border: 2px solid black; padding: 30px; margin: 30px;">
			<form action="addDepartmentDetails.spring" method="post">
				<div class="form-group" style="position: relative; top: -10px">
					<label for="department_nm">Department Name</label>
					<input name="department_nm" type="text" class="form-control" id="department_nm" required>
				</div>
				<div style="position: relative; top: 10px">
					<input type="submit" class="btn btn-primary " value="Submit"/>
				</div>
			</form>
		</div>
	</body>
</html>