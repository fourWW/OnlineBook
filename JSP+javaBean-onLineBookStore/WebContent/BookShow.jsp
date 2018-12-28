<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Bean.*,Factory.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/Login.css">
<link rel="stylesheet" type="text/css" href="CSS/style.css">
<style type="text/css">
	    a:link{color:#FF4500;text-decoration:none}/*未访问，红色，无下划线*/
	    a:active{color:blue;}/*激活，红色*/
	    a:visited{color:red;text-decoration:none}/*已访问，紫色，无下划线*/
	    a:hover{color:yellow;text-decoration:underline}/*鼠标移动上面，蓝色，下划线*/
	    .info{
	    	width:100%;
	    	height:500px;
	    	margin:10px;
	    }
	    .footer{
			width:100%;
	    	height:50px;
	    	text-align: center;
	    	font-size: 2em;
	    	border: 2px solid gray;
	    	border-radius:2px;
		}
		  .footer{
		  	position:absolute;
		  	right:0px;
		  	top:600px;
		  	width:100%;
		  	height:100px;
		  	background-color: gray;
		  	border-radius:5px; 
		  	text-align: center;
		  	line-height: 100px;
		  }
	</style>
</head>
<body>
	<%int id = Integer.parseInt(request.getParameter("bookID"));
		Book book = UserFactory.getBookInstance().getBookByID(id);
		User user = (User)session.getAttribute("user");
	%>
	<div class = "header">
       	    <div class = "logo"><h2>喵喵网上书店</h2>      
        	<div class = "name">
        		<a href="CartShow.jsp">MyCart</a>|<a href="#">MyInfo</a>
        		<strong>欢迎:</strong><%=user.getName() %>
        	</div>
       <div></div>
	<div class = "info">
		ISDN :<%=book.getBookID()%></p>
                      书 名:<%=book.getBookName() %></p>
                      作 者:<%=book.getAuthor() %></p>
                      出 版日期:<%=book.getPublishDate() %></p>
                      价 格:<%=book.getUnit() %> </p>
                      类别：<%=book.getCatagory() %></p>
                      简介：<%= book.getSynopsis() %></p>
		<form action="AddCart" method="get">
			<input type = "hidden" name="bookID" value=<%=book.getBookID()%>>
		<input type = "hidden" name="userID" value=<%=user.getUserID()%>>
			<input type = "submit" value="添加购物车">
		</form>
	</div>
	<div class ="footer">four_WW Maker</div> 
</body>
</html>