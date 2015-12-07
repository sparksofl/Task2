<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="main.css"/>
<title>Task2</title>
</head>
<body>
	<!-- <div class="current">You are logged in as ${role} ${fullname} <br/> 
	<form method="get" action="LogOut">
		<input type="hidden" name="logout" value="logout">
		<button type="submit">Log Out</button>
	</form>
	</div> -->
	<c:if test = "${role == 'Admin'}">
		<a href="register.jsp" class="new">Add new user</a>
	</c:if>
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
				<c:if test = "${role == 'Admin'}">
					<c:if test = "${fullname != user.getAttr('fullname')}">
						<form method="get" action="Delete">
							<input type="hidden" name="login" value=${user.getAttr("login")} />
							<button type="submit" class="delete">Delete</button>
						</form>
					</c:if>
				</c:if>
				<c:if test = "${(role == 'Admin') || fullname == user.getAttr('fullname')}">
					<form method="get" action="Update">
						<input type="hidden" name="login" value=${user.getAttr("login")} />
						<button type="submit" class="edit-user">Update</button>
					</form>
				</c:if>
			</div>
		</div>
	</c:forEach>

</body>
</html>