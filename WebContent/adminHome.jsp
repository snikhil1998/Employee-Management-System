<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Employee Management System - Admin Home</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="styles.css" />
	</head>
	<body>
		<h2>Employee Management System - Admin Home</h2>
		<h3 style="position: relative; left: 10px; top: 20px;">Departments</h3>
		<ul class="nav" style="position: relative; left: 10px; top: 10px;">
			<li class="nav-item">
				<a class="nav-link" href="createDepartment.spring">Create Department</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="viewDepartmentsDetails.spring">List Departments</a>
			</li>
		</ul>
		<h3 style="position: relative; left: 10px; top: 20px;">Employees</h3>
		<ul class="nav" style="position: relative; left: 10px; top: 10px;">
			<li class="nav-item">
				<a class="nav-link" href="addEmployeeDetails.spring">Add Employee Information</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="viewEmployeesDetails.spring">List Employees</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="inputEmployeeId.spring">Edit Employee Details</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="deleteEmployeeDetails.spring">Delete Employee Details</a>
			</li>
		</ul>
		<h3 style="position: relative; left: 10px; top: 20px;">Compliances</h3>
		<ul class="nav" style="position: relative; left: 10px; top: 10px;">
			<li class="nav-item">
				<a class="nav-link" href="createCompliance.spring">Create Regulation</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="viewCompliancesDetails.spring">List Regulations</a>
			</li>
		</ul>
		<h3 style="position: relative; left: 10px; top: 20px;">Status Reports</h3>
		<ul class="nav" style="position: relative; left: 10px; top: 10px;">
			<li class="nav-item">
				<a class="nav-link" href="createStatusReport.spring">Create Status Report</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="viewStatusReportsDetails.spring">List Status Reports</a>
			</li>
		</ul>
		<a class="btn btn-primary" href="logout.spring" style="position: relative; top: 10px; margin: 20px;">Logout</a>
		<div style="position: relative; top: 25px">
			<span style="color: red">${requestScope.msg}</span>
		</div>
	</body>
</html>