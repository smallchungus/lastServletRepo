<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="styles.css" type="text/css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>

	<div id="header_wrapper">
		<div id="header">
			<li id="sitename"><a href="http://smallchungusBlueBook.com">smallchungusBlueBook.com</a></li>
			<h1>Login unsuccessful.</h1>
				<%-- <form action="<%=request.getContextPath()%>/register" method="POST"> --%>
<!-- 					<li>Email or Phone<br> <input type="text" name="username" /></li>
					<li>Password<br> <input type="password" name="password" /><br><a href="">Forgotten account?</a></li>a
					<li><input type="submit" value="login" name="login" /></li>  -->
				<!-- <li><input type="button" value="register" onclick="window.location='RegisterEmployee.jsp'"></li>  -->
				<!--  hello -->


<form action ="<%= request.getContextPath() %>/register" method="POST">
<input type="button" value="register" onclick="window.location='RegisterEmployee.jsp" >

				</form>
		</div>
 	</div>

</body>
</html>