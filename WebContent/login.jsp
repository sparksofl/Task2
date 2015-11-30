<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="main.css"/>
<title>Insert title here</title>
</head>
<body>
	<div class="error">
		<c:if test="${invalid}">
		    <span>Incorrect login or password</span>
		</c:if>
	</div>
	<div class="login-form">
		<form action="SignIn" method="POST">
			<input type="text" name="email" placeholder="E-mail"/>
			<input type="password" name="password" placeholder="Password"/>
			<input type="submit" value="Log In" />
		</form>
	</div>
</body>
</html>