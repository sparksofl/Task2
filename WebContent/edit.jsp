<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="main.css"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="login-form">
		<form action="Update" method="POST">
			<input type="password" name="password" placeholder="Password"/>
			<input type="text" name="fullname" placeholder="Full name" value="${user.getAttr("fullname")}"/>
			<input type="email" name="email" placeholder="E-mail" value="${user.getAttr("email")}" />
			<input type="submit" value="Update" />
		</form>
	</div>	
</body>
</html>