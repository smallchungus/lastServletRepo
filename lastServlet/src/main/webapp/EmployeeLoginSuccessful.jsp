<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
</body>
</html>