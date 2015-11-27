<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="main.css"/>
<title>Insert title here</title>
</head>
<body>
	<c:if !"${validated}">
		<div class="error">Invalid e-mail or password</div>
	</c:if>
	<form action="SingIn" method="POST">
		<input type="text" name="email" placeholder="E-mail"/>
		<input type="password" name="password" placeholder="Password"/>
		<input type="submit" value="Log In" />
	</form>
</body>
</html>