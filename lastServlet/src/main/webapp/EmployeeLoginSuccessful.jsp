<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Cookie cookie = null;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login successful.</h1>

	<table align="center" cellpadding="1" cellspacing="1" border="1"
		bgcolor="#728DCF">
		<tr bgcolor="#000000">
			<%
			Cookie[] cookieArray = request.getCookies();

			String cookieName = null;
			String cookieValue = null;
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