<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Bean.*,Factory.*,java.util.*" %>
<%	
User user = (User)session.getAttribute("user");
String username = "";		
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
<link rel="stylesheet" type="text/css" href="CSS/info.css">
<script language='javascript' src='JS/LoginCheck.js'></script>
</head>
<body>
	<div class = "login">
    	<h3>MOdify-Info</h3>
    	<form action = "changeInfo" method = "get" onsubmit="return isValid(this);">
    		<div class = "username">
    			userName:<br/><input type ="text" name = "name" value =<%=username %>>
		    </div>
		    <div class = "password">
		    	password:<br/><input type ="text" name = "password" value =<%=password %>>
		    </div>
		     <div class = "phone">
		    	phone:<br/><input type ="text" name = "phone" value=<%=user.getPhone() %> >
		    </div>
		     <div class = "email">
		    	email:<br/><input type ="text" name = "email" value=<%=user.getEmail() %>>
		    </div> 
		    <div class = "address">
		    	address:<br/><input type ="text" name = "address"value=<%=user.getAddress() %> >
		    </div>
		    <div class = "btn">
		    	<input type = "submit" value = "ChangeINfo">
		    </div>
     	</form>   	
</body>
</html>