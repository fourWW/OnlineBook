<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	String username = "";		
	String password = "";		
	Cookie[] c = request.getCookies();		
	if (c != null) {			
	for (int i = 0; i < c.length; i++) {				
		if ("username".equals(c[i].getName())) {					
			username = c[i].getValue();				
			} 
		else if ("password".equals(c[i].getName())) {					
				password = c[i].getValue();				
			}			
		}		
	} 
	else {			
		username = " ";			
		password = " ";		
	}	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/Login.css">
<script language='javascript' src='JS/LoginCheck.js'></script>
<style type="text/css">
	p{
		text-align: center;
		margin-right: 50px;
	}
</style>
</head>
<body>
	<div class = "login">
    	<h3>Login-Shoping</h3>
    	<form action = "CheckLogin.jsp" method = "get" onsubmit="return isValid(this);">
    		<div class = "username">
    			userName:<br/><input type ="text" name = "name" value =<%=username %>>
		    </div>
		    <div class = "password">
		    	password:<br/><input type ="password" name = "password" value =<%=password %>>
		    </div>
		    <div class = "btn">
		    	<input type = "submit" value = "Login">
		    	<input type = "reset" value = "Reset">
		    </div>
     	</form>   	
     	<p>onclik<a href="Register.jsp">here</a>Register！</p>
    </div>
</body>
</html>