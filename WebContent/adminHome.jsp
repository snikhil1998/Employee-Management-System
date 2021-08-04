<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Employee Management System - Admin Home</title>
	</head>
	<body>
		<h2>Employee Management System - Admin Home</h2>
		<ul class="nav">
			<li class="nav-item">
				<a class="nav-link" href="createDepartment.spring">Create Department</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="listDepartments.spring">List Departments</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="addEmployeeInformation.spring">List Employees</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="listEmployees.spring">List Employees</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="createCompliance.spring">Create Regulation</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="listCompliances.spring">List Regulations</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="listStatusReports.spring">Create Status Report</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="listStatusReports.spring">List Status Reports</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="logout.spring">Logout</a>
			</li>
		</ul>
		<div style="position: relative; top: 25px">
			<span style="color: red">${requestScope.msg}</span>
		</div>
	</body>
</html>