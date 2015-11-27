<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="main.css"/>
<title>Registration</title>
</head>
<body>
	<form method="post" action="SignUp">
        <input type="text" name="login" placeholder="Username" /><br/>
        <input type="password" name="password" placeholder="Password" /><br/>
        <input id="fname" type="text" name="fullname" placeholder="Full name" /><br/>
        <input id="email" type="email" name="email" placeholder="E-mail" /><br/>
        <input type="submit" value="Sing Up" />
    </form>
</body>
</html>