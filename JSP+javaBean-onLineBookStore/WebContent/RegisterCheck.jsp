<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="Proxy.*,Bean.*,DButil.*,Factory.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/Login.css" type="text/css" />
</head>
<body>
	<%
		String name = request.getParameter("name");
	    String password = request.getParameter("password");
		User user = new User(name,password);	
		UserFactory.getUserInstance().addUser(user);%>
		注册成功
		<% response.setHeader("refresh","1;url=Login.jsp");%>
</body>
</html>