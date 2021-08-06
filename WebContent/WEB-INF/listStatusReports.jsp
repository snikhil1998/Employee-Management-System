<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Departments</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="styles.css" />
		<style>
			table
			{
				width:100%;
			}
			table, th, td
			{
				border: 1px solid black;
				border-collapse: collapse;
			}
			th, td
			{
				padding: 15px;
				text-align: left;
			}
			#t01 tr:nth-child(even)
			{
				background-color: #eee;
			}
			#t01 tr:nth-child(odd)
			{
				background-color: #fff;
			}
			#t01 th
			{
				background-color: black;
				color: white;
			}
		</style>
	</head>
	<body>
		<div class="container">
			<ul class="nav">
				<li class="nav-item">
					<a class="nav-link" href="adminDashboard.spring">Dashboard</a>
				</li>
			</ul>
			<h2>View All Department Details</h2>
			<table id="t01">
				<tr>
					<th>Compliance ID</th>
					<th>RL Type</th>
					<th>Details</th>
					<th>Date Created</th>
					<th>Department</th>
				</tr>
				<core:forEach items="${sessionScope.allStatusReportsDetails}" var="statusreport">
					<tr>
						<td>${statusreport.statusrptid}</td>
						<td>${statusreport.complianceid}</td>
						<td>${statusreport.empid}</td>
						<td>${statusreport.comments}</td>
						<td>${statusreport.createdate}</td>
						<td>${sessionScope.allDepartmentsDetails.get(statusreport.department_id)}</td>
					</tr>
				</core:forEach>
			</table>
		</div>
	</body>
</html>