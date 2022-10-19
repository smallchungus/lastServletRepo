<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Cookie cookie = null;
%>

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
				<form action="<%=request.getContextPath()%>/register" method="POST">
<!-- 					<li>Email or Phone<br> <input type="text" name="username" /></li>
					<li>Password<br> <input type="password" name="password" /><br><a href="">Forgotten account?</a></li>
					<li><input type="submit" value="login" name="login" /></li>  -->
				<!-- <li><input type="button" value="register" onclick="window.location='RegisterEmployee.jsp'"></li>  -->
				</form>
		</div>
	</div>
	

	<table align="center" cellpadding="1" cellspacing="1" border="1"
		bgcolor="#728DCF">
		<tr bgcolor="#000000">
			<%
			Cookie[] cookieArray = request.getCookies();

			String cookieName = "";
			String cookieValue = "";
			for (int i = 0; i < cookieArray.length; i++) {
				cookieName = cookieArray[i].getName();
				cookieValue = cookieArray[i].getValue();
			%>
			<td><%=cookieName%></td>
			<td><%=cookieValue%></td>
		</tr>
		<%
		}
		%>
	</table>


</body>
</html>