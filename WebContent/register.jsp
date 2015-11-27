<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
	<form method="post" action="SignUp">
        Name:<input type="text" name="uname" /><br/>
        Password:<input type="password" name="pword" /><br/>
        Full name:<input id="fname" type="text" name="fname" /><br/>
        Email:<input id="email" type="email" name="email" /><br/>
        <input type="submit" value="register" />
    </form>
</body>
</html>