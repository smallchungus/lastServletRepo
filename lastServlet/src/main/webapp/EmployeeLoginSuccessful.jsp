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
				out.println("cookieName is " + cookieArray[i].getName() + " ");
				out.println("cookieValue is " + cookieArray[i].getValue() + "<BR>");
				cookieName = cookieArray[i].getName();
				cookieName = cookieArray[i].getName();
			%>
			<td><%=cookieName%></td>
			<td><%=cookieValue%></td>
		</tr>
		<%
		}
		%>
	</table>
	<! -- WebDataRocks -->
	<link href="https://cdn.webdatarocks.com/latest/webdatarocks.min.css"
		rel="stylesheet" />
	<script
		src="https://cdn.webdatarocks.com/latest/webdatarocks.toolbar.min.js"></script>
	<script src="https://cdn.webdatarocks.com/latest/webdatarocks.js"></script>
	<! -- FusionCharts -->
	<script
		src="https://static.fusioncharts.com/code/latest/fusioncharts.js"></script>
	<script
		src="https://static.fusioncharts.com/code/latest/themes/fusioncharts.theme.fusion.js"></script>
	<! -- WebDataRocks connector for FusionCharts -->
	<script
		src="https://cdn.webdatarocks.com/latest/webdatarocks.fusioncharts.js"></script>
	<table style-="width: 100%;height: 400px">
		<tr style="width: 50%; height: 400px">
			<td style>
				<div id="wdr-component"></div>
			</td>
			<td style>
				<div id="fusionChartArea"></div>
			</td>
			<td></td>
		</tr>
		<tr>
			<td style="width: 50%;">
				<div id="fusionCharPie" style="height: 200px;"></div>
			</td>
			<td style="width: 50%;">
				<div id="fusionChartBar" style="height: 200px;"></div>
			</td>
		</tr>
	</table>
	<script src="wbrFusion.js"></script>
	




</body>
</html>