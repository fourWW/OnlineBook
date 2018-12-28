<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="Proxy.*,Bean.*,DButil.*,Factory.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My JSP 'check.jsp' starting page</title>
<link rel="stylesheet" type="text/css" href="CSS/Login.css">
</head>
<body>

<% 
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	User user = UserFactory.getUserInstance().getUser(name, password);
	boolean flag = UserFactory.getUserInstance().CheckUser(user);
%>
<!-- 判断是否是正确的登录用户 -->

<% if (flag==true){  session.setAttribute("user", user);%>
<jsp:forward page="LoginSucessed.jsp"/>
<%} else if (flag == false){%>
<jsp:forward page="Login.jsp"/>
<%} %>
</body>
</html>
