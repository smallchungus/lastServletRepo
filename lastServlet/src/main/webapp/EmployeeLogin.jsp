<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Login Form</h3>
	<%
	String profile_msg = (String) request.getAttribute("Can't leave the field blank bucko");
	if (profile_msg != null) {
		out.print(profile_msg);
	}
	String login_msg = (String) request.getAttribute("write something");
	if (login_msg != null) {
		out.print(login_msg);
	}
	%>
	<br />
		<form action ="<%= request.getContextPath() %>/register" method="POST">
		Email:<input type="text" name="username" /><br />
		<br /> Password:<input type="password" name="password" /><br />
		<br /> <input type="submit" value="login" name="login" /> <input
			type="button" value="register"
			onclick="window.location='RegisterEmployee.jsp'">
	</form>

</body>
</html>