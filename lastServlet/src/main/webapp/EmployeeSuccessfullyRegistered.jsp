<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>You have successfully Registered!</title>
</head>
<body>
<h1>You have successfully registered congrats!!!!</h1>
<form action ="<%= request.getContextPath() %>/register" method="POST">
<input type="button" value="login" onclick="window.location='EmployeeLogin.jsp" >
</form>

</body>
</html>