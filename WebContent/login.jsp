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
	<jsp:include page="error.jsp" />
	<div class="login-form">
		<form action="SignIn" method="POST">
			<input type="text" name="email" placeholder="<fmt:message key="label.email"></fmt:message>"/>
			<input type="password" name="password" placeholder="<fmt:message key="label.password"></fmt:message>"/>
			<input type="submit" value="<fmt:message key="label.login"></fmt:message>" />
		</form>
	</div>
</body>
</html>