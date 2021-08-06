<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Delete Employee Details</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<link href="styles.css" rel="stylesheet" type="text/css">
		<script>
		function confirmSubmission(form)
		{
			if (confirm("Are you sure you want to submit the form?"))
			{
				form.submit();
			}
		}
		</script>
	</head>
	<body>
		<!-- <h2>Add Employee Details<h2> -->
		<div class="container" style="border: 2px solid black; padding: 30px; margin: 30px;">
			<form action="removeEmployeeDetails.spring" onSubmit="return confirm('Do you wish to delete this employee\'s details? This action is not reversible.')" method="post">
				<div class="form-group" style="margin: 10px;">
					<label for="empid">Employee ID</label>
					<input name="empid" type="text" class="form-control" id="empid" required>
				</div>
				<div style="position: relative; top: 10px; margin: 10px;">
					<input type="submit" class="btn btn-primary " value="Submit"/>
				</div>
			</form>
		</div>
	</body>
</html>