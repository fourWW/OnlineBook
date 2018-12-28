<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="Bean.*,Factory.*,java.util.*" %>
<%
		User user = (User)session.getAttribute("user");
		Cookie name = new Cookie("username", user.getName());				
		Cookie psd = new Cookie("password", user.getPassword());				
		name.setMaxAge(1000);				
		psd.setMaxAge(1000);		
		response.addCookie(name);			
		response.addCookie(psd);	
	%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>图书信息列表</title>
	<link rel="stylesheet" type="text/css" href="CSS/Login.css">
	<link rel="stylesheet" type="text/css" href="CSS/style.css">
	<style type="text/css">
	    a:link{color:#FF4500;text-decoration:none}/*未访问，红色，无下划线*/
	    a:active{color:blue;}/*激活，红色*/
	    a:visited{color:red;text-decoration:none}/*已访问，紫色，无下划线*/
	    a:hover{color:gray;text-decoration:underline}/*鼠标移动上面，蓝色，下划线*/
	</style>
  </head>
  <body >
       <div class = "header">
       	    <div class = "logo"><h2>喵喵书屋</h2>
       	    <div class = "reach">
       	    	<form action="search" method="get">
	       	    	<input type="text" name ="b_name">
	       	    	<input class="sub" type="submit" value="Search">
       	   		 </form>
       	    </div>       
        	<div class = "name">
        		<a href="CartShow.jsp">MyCart</a>|<a href="ModifyInfo.jsp">P-MyInfo</a>
        		<strong>欢迎:</strong><%=user.getName() %>
        	</div>
       </div>   	 
       </div>      
       <div class="border">
       		<ul class = "ULlist">
       			<a href ="CategoryBookList.jsp?Categoty=python"><li>Python</li></a>
       			<a href ="CategoryBookList.jsp?Categoty=AI"><li>AI</li></a>
       			<a href ="CategoryBookList.jsp?Categoty=java"><li>Java</li></a>
       			<a href ="CategoryBookList.jsp?Categoty=c"><li>C语言</li></a>
       			<a href ="CategoryBookList.jsp?Categoty=internet"><li>internet</li></a>
       		</ul>
       </div>
       <% 
       List<Book> books =UserFactory.getBookInstance().getAllBook();
       int number = 1;
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
         <%
         number++;
         if(number % 7 == 0)
        	 break;
         }
         %>   
       <div class = "index">总共:<%=books.size()%>记录 | 当前页数:1| 共<%=books.size()/6 +1 %>页 | <a href="#">上一页</a> | <a href="#">下一页</a></div>   
       <div class ="footer">four_WW Maker</div>                 
</body>
</html>
	