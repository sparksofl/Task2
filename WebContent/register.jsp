<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="main.css"/>
<title>Registration</title>
</head>
<body>
	<div class="error">
		<c:if test="${invalid}">
		    <span>${message}</span>
		</c:if>
	</div>
	<form method="post" action="SignUp">
        <input type="text" name="login" placeholder="<fmt:message key="label.username"></fmt:message>" required="required" /><br/>
        <input type="password" name="password" placeholder="<fmt:message key="label.password"></fmt:message>" required="required" /><br/>
        <input id="fname" type="text" name="fullname" placeholder="<fmt:message key="label.full_name"></fmt:message>" /><br/>
        <input id="email" type="email" name="email" placeholder="<fmt:message key="label.email"></fmt:message>" required="required" /><br/>
        <input type="submit" value="Sing Up" />
    </form>
</body>
</html>