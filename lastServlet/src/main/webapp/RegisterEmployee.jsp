<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
<div align="center">
	<h1>Register User</h1>
	<form action ="<%= request.getContextPath() %>/register" method="POST">
	<table style="with: 80%">
	<tr>
		<td>First Name</td>
		<td><input type="text" name="firstName"></td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td><input type="text" name="lastName"></td>
	</tr>
	<tr>
		<td>Email Address</td>
		<td><input type="text" name="emailAddress"></td>
	</tr>
	<tr>
		<td>UserName</td>
		<td><input type="text" name="userName"></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name="passWord"></td>
	</tr>
	</table>
	<input type="submit" value="Register" />
	</form>

	</div>
</body>
</html>