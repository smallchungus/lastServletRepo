<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   // Creating cookies for name and age.    
   Cookie cUsername = new Cookie("User_name", request.getParameter("username"));
   Cookie cPassword = new Cookie("Age", request.getParameter("password"));
  
   // Setting expiry date
   cUsername.setMaxAge(60*60*24);
   cPassword.setMaxAge(60*60*24);  
   // Add both the cookies in the response header.
   response.addCookie( cUsername );
   response.addCookie( cPassword );
%>
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
			<h1>Login successful.</h1>
    <form action = "EmployeeLogin.jsp" method = "GET">
       User Name: <br/><input type = "text" name = "cUsername">
       <br />
       Age: <br/><input type = "text" name = "cPassword" />
       <br/>
                  Gender:</br><input type = "text" name = "Gender">
                  <br/>
                  <input type = "submit" value = "Go" />
    </form>
<input type="button" value="search" >
	</form>

</body>
</html>