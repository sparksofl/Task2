<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="main.css"/>
<title>Task2</title>
</head>
<body>
	<span class="current">You are logged in as ${fullname}, <br/> role: ${role}</span>
	<a href="register.jsp" class="new">Add new user</a>
	<c:forEach var="user" items="${allUsers}">
		<div class="user">
			<div class="info">
				Username: ${user.getAttr("login")}
				<br/>
				Full name: ${user.getAttr("fullname")}
				<br/>
				E-mail: ${user.getAttr("email")}
			</div>		
			<div class="edit">
				<a class="delete" href="#">Delete</a>
				<a class="edit-user" href="#">Edit</a>
			</div>
		</div>
	</c:forEach>

</body>
</html>