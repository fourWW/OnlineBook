<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/Login.css">
<script language='javascript' type="text/javascript" src='JS/RegisterCheck.js'></script>
<style type="text/css">
	p{
		text-align: center;
		margin-right: 50px;
	}
</style>
</head>
<body>
	<div class = "login">
    	<h3>Register-Shoping</h3>
    	<form action = "RegisterCheck.jsp" method = "get" onsubmit="return isValid(this);">
    		<div class = "username">
    			userName:<br/><input type ="text" name = "name">
		    </div>
		    <div class = "password">
		    	password:<br/><input type ="password" name = "password">
		    </div>
		    <div class = "password">
		    	password:<br/><input type ="password" name = "repassword">
		    </div>
		    <div class = "btn">
		    	<input type = "submit" value = "Register">
		    	<input type = "reset" value = "Reset">
		    </div>
     	</form>   	
    </div>
</body>
</html>