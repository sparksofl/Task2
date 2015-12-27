<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<fmt:setLocale value="${currentLocale}" />
<fmt:setBundle basename="resources" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="current"><fmt:message key="action.log_out"></fmt:message>${role} ${fullname} <br/> 
	<form method="get" action="LogOut">
		<input type="hidden" name="logout" value="logout">
		<button type="submit"><fmt:message key="action.log_out"></fmt:message></button>
	</form>
	</div>
	
	<div>
		<form action = "locale" method = "POST">
		  <input type="radio" name="newLocale" value="en">English
		  <br>
		  <input type="radio" name="newLocale" value="ru">Russian
		  <br>
		  <input type = "submit" value = "Change lang">
		</form>
	</div>
<hr />
</body>
</html>