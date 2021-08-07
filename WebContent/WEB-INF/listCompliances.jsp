<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<%
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
if(session.getAttribute("userid")==null || session.getAttribute("role")==null)
{
	response.sendRedirect(request.getContextPath() + "/index.jsp");
}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Compliances</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="styles.css" />
		<script>
			//if ( window.history.replaceState )
			if(<%request.getSession().getAttribute("role");%> == null)
			{
				//window.history.replaceState( null, null, window.location.href );
				window.history.replaceState( null, null, "${pageContext.request.contextPath}/index.jsp" );
			}
		</script>
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
				<core:forEach items="${sessionScope.allCompliancesDetails}" var="compliance">
					<tr>
						<td>${compliance.complianceid}</td>
						<td>${compliance.rltype}</td>
						<td>${compliance.details}</td>
						<td>${compliance.createdate}</td>
						<td>${sessionScope.allDepartmentsDetails.get(compliance.department_id)}</td>
					</tr>
				</core:forEach>
			</table>
		</div>
	</body>
</html>