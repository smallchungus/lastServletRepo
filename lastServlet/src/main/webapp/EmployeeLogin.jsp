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

	<div id="header_wrapper">
		<div id="header">
			<li id="sitename"><a href="http://smallchungusBlueBook.com">smallchungusBlueBook.com</a></li>
				<form action="<%=request.getContextPath()%>/register" method="POST">
					<li>Email or Phone<br> <input type="text" name="username" /></li>
					<li>Password<br> <input type="password" name="password" /><br><a href="">Forgotten account?</a></li>
					<li><input type="submit" value="login" name="login" /></li> 
				<li><input type="button" value="register" onclick="window.location='RegisterEmployee.jsp'"></li> 
				</form>
		</div>
	</div>

	<div id="wrapper">

		<div id="div1">
			<p>
				smallchungusBlueBook helps you connect and share with the <br>
				people in your life.
			</p>
			<img
				src="">
		</div>

		<div id="div2">
			<h1>Create an account</h1>
			<p>It's free and always will be.</p>
			<li><input type="text" placeholder="First Name" id="firstname"><input type="text" placeholder="Surname" id="surname"></li>
			<li><input type="text" placeholder="Mobile number or email address"></li>
			<li><input type="text" placeholder="Re-enter mobile number or email address"></li>
			<li><input type="password" placeholder="New password"></li>
			<p>Birthday</p>
			<li><select><option>Day</option></select> <select><option>Month</option></select>
				<select><option>Year</option></select> <a href="">Why do I need
					to provide my date of birth?</a></li>
			<li><input type="radio">Female <input type="radio">Male</li>
			<li id="terms">By clicking Create an account, you agree to our <a
				href="">Terms</a> and that <br>you have read our <a href="">Data
					Policy</a>, including our <a href="">Cookie Use</a>.
			</li>
			<li><input type="submit" value="Create an account"></li>
			<li id="create_page"><a href="">Create a Page</a> for a
				celebrity, band or business.</li>
		</div>

	</div>

	<div id="footer_wrapper">

		<div id="footer1">
			English (UK) <a href="">??????????????????</a><a href="">??????????????????</a><a href="">
				????????</a><a href="">???????????????</a><a href="">???????????????</a><a href="">???????????????</a><a
				href="">??????????????????</a><a href="">?????????????????????</a><a href="">???????????????</a><a
				href="">??????????????????</a>
		</div>
		<div id="footer2">
			<a href="">Sign Up</a><a href="">Log In</a><a href="">Messenger</a><a
				href="">Talkerscode</a><a href="">Mobile</a><a href="">Find
				Friends</a><a href="">Badges</a><a href="">People</a><a href="">Pages</a><a
				href="">Places</a><a href="">Games</a><a href="">Locations</a><a
				href="">Celebrities</a><a href="">Groups</a><a href="">Moments</a><a
				href="">About</a><a href="">Create Advert</a><a href="">Create
				Page</a><a href="">Developers</a><a href="">Careers</a><a href="">Privacy</a><a
				href="">Cookies</a><a href="">Ads</a><a href="">Terms</a><a href="">Help</a>
		</div>

	</div>
</body>
</html>