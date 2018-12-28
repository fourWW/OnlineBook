<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Bean.*,Factory.*,java.util.*" %>
<%	User user = (User)session.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/Login.css">
<link rel="stylesheet" type="text/css" href="CSS/style.css">
<style type="text/css">
.Book{
	border-right: 10px solid gray;
}
.Book{
	height:220px;
	width:80%;
	float:left;
	border:2px solid gray;
	border-radius:10px;
	text-align:center;
	border-right: 10px solid gray;
}

.Book img{
	margin:10px;
	float:left;
}
.Book .info{
	padding:20px;
	width:150px;
	float:right;
	margin-right: 400px;
}
.Book img:hover{
    opacity: 0.5;
}
.footer{
	    	position:absolute;
	    	right:0px;
	    	top:900px;
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
	<div class = "header">
       	    <div class = "logo"><h2>喵喵网上书店</h2>      
        	<div class = "name">
        		<a href="CartShow.jsp">MyCart</a>|<a href="#">MyInfo</a>
        		<strong>欢迎:</strong><%=user.getName() %>
        	</div>
       <div></div>
       <%
		String Category = request.getParameter("Categoty");
		List<Book> books = UserFactory.getBookInstance().getBookByCategory(Category);
		for(Iterator<Book> iter =books.iterator();iter.hasNext();){
				Book book = iter.next();
	    %>
		<div class = "Book">
        	<a href="BookShow.jsp?bookID=<%=book.getBookID()%>"><img alt ="null"src="Image/<%=book.getBookID()+1%>.jpg" height="200" width="150" /></a>
        	<div class = "info">
        		ISDN :<%=book.getBookID()%><br>
                                          书 名:<%=book.getBookName() %><br>
                                          作 者:<%=book.getAuthor() %><br>
                                          出 版日期:<%=book.getPublishDate() %><br>
                                          价 格:<%=book.getUnit() %> <br> 
                                          类别：<%=book.getCatagory() %><br> 
              <a href="BookShow.jsp?bookID=<%=book.getBookID()%>">查看详细信息</a>                           
        	</div>     
        </div> 
      <%} %>
       <div class ="footer">four_WW Maker</div>  
</body>
</html>