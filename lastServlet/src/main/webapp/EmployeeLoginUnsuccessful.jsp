<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Login unsuccessful.</h1>

<form action ="<%= request.getContextPath() %>/register" method="POST">
<input type="button" value="register" onclick="window.location='RegisterEmployee.jsp" >
</form>


</body>
</html>