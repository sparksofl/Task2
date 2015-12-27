<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="header.jsp" />
<c:out value="${sessionScope.currentLocale}"/>

<fmt:setLocale value="${sessionScope.currentLocale}" />
<fmt:setBundle basename="${bundleBasename}" />
<fmt:setLocale value="${currentLocale}" />
<fmt:setBundle basename="resources" />

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
		<a href="register.jsp" class="new"><fmt:message key="label.add_new_user"></fmt:message></a>
	</c:if>
	<c:forEach var="user" items="${allUsers}">
		<div class="user">
			<div class="info">
				<fmt:message key="label.username"></fmt:message>: ${user.getAttr("login")}
				<br/>
				<fmt:message key="label.full_name"></fmt:message>: ${user.getAttr("fullname")}
				<br/>
				<fmt:message key="label.email"></fmt:message>: ${user.getAttr("email")}
			</div>
			<div class="edit">
				<c:if test = "${role == 'Admin'}">
					<c:if test = "${fullname != user.getAttr('fullname')}">
						<form method="get" action="Delete">
							<input type="hidden" name="login" value=${user.getAttr("login")} />
							<button type="submit" class="delete"><fmt:message key="action.delete"></fmt:message></button>
						</form>
					</c:if>
				</c:if>
				<c:if test = "${(role == 'Admin') || fullname == user.getAttr('fullname')}">
					<form method="get" action="Update">
						<input type="hidden" name="login" value=${user.getAttr("login")} />
						<button type="submit" class="edit-user"><fmt:message key="action.update"></fmt:message></button>
					</form>
				</c:if>
			</div>
		</div>
	</c:forEach>

</body>
</html>