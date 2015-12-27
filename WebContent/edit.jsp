<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />
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
	<h4>${user.getAttr('login')}</h4>
		<form action="Update" method="POST">
			<input type="password" name="password" placeholder="<fmt:message key="label.password"></fmt:message>"/>
			<input type="text" name="fullname" placeholder="<fmt:message key="label.full_name"></fmt:message>" value="${user.getAttr('fullname')}"/>
			<input type="hidden" name="login" value="${user.getAttr('login')}" />
			<input type="email" name="email" placeholder="<fmt:message key="label.email"></fmt:message>" value="${user.getAttr('email')}" />
			<input type="submit" value="Update" />
		</form>
	</div>	
</body>
</html>