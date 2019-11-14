<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team longest period</title>
</head>
<body>
	<br/>
	<h1 style="color:red;">${errorMessage}</h1>
	<form method="POST" action="uploadFile" enctype="multipart/form-data">
		<input type="file" name="file" onchange="this.form.submit();" style="color:transparent;"/>
	</form>
	<br/>
	<table>
		<tbody>
			<tr>
				<td>Employee ID #1</td><td>${employeesPair.firstEmpID }</td>
			</tr>
			<tr>
				<td>Employee ID #2</td><td>${employeesPair.secondEmpID }</td>
			</tr>
			<tr>
				<td>Project ID</td><td>${employeesPair.projectID }</td>
			</tr>
			<tr>
				<td>Days worked</td><td>${employeesPair.daysWorked }</td>
			</tr>
		</tbody>
	</table>
</body>
</html>