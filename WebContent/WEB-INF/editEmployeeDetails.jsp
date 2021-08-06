<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit Employee Details</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<link href="styles.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<!-- <h2>Add Employee Details<h2> -->
		<div class="container" style="border: 2px solid black; padding: 30px; margin: 30px;">
			<form action="editEmployeeDetails.spring" style="position: relative; top: 20px;" method="post">
				<div class="form-group" style="margin: 10px;">
					<label for="empid">Employee ID</label>
					<input name="empid" type="text" class="form-control" id="empid" value=${employeeDetails.empid} required>
				</div>
				<!-- <div class="form-group" style="position: relative; top: 0px"> -->
				<div class="form-group" style="margin: 10px;">
					<label for="firstname">First Name</label>
					<input name="firstname" type="text" class="form-control" id="firstname" value=${employeeDetails.firstname} required>
				</div>
				<div class="form-group" style="margin: 10px;">
					<label for="lastname">Last Name</label>
					<input name="lastname" type="text" class="form-control" id="lastname" value=${employeeDetails.lastname} required>
				</div>
				<div class="form-group" style="margin: 10px;">
					<label for="dob">Date of Birth</label>
					<input name="dob" type="date" class="form-control" id="dob" value=${employeeDetails.dob} required>
				</div>
				<div class="form-group" style="margin: 10px;">
					<label for="email">Email id</label>
					<input name="email" type="email" class="form-control" id="email" value=${employeeDetails.email}>
				</div>
				<div class="form-group" style="margin: 10px;">
					<label for="department_id">Department ID</label>
					<select name="department_id" class="form-control" id="department_id" required>
						<core:forEach items="${sessionScope.allDepartmentsDetails}" var="department">
							<core:if test="${employeeDetails.department_id == department.department_id}">
								<option value=${department.department_id} selected>${department.department_nm}</option>
								<br />
							</core:if>
							<core:if test="${employeeDetails.department_id != department.department_id}">
								<option value=${department.department_id}>${department.department_nm}</option>
								<br />
							</core:if>
						</core:forEach>
					</select>
					<!-- <input name="department_id" type="text" class="form-control" id="department_id" required> -->
				</div>
				<div style="position: relative; top: 10px; margin: 10px;">
					<input type="submit" class="btn btn-primary " value="Submit"/>
				</div>
			</form>
		</div>
	</body>
</html>