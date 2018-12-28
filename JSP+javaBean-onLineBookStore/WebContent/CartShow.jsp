<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Bean.*,Factory.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="CSS/Login.css">
<style type="text/css">
	.info{
		width: 800px;	
		margin-top: 5px;
	}
	.info-left{
		float: left;
		width: 500px;	
		line-height: 30px;
		
	}
	.info-left span{
		float: left;
	}
	form input{
		float: right;
		width: 100px;	
	}
	.price{
		position: absolute;
		right:20px;
		top: 5px;
	}
	.order{
		position: absolute;
		right:20px;
		top: 60px;
	}
	a{ text-decoration:none;
	} 
	.head{
		border-bottom: 10px solid gray;
		width:100%;
		font-size: 1.2em;
	}
	.back{
		position: absolute;
		right:20px;
		top: 90px;
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
		<%User user = (User)session.getAttribute("user"); %>
		<div class ="head">
			<strong>欢迎：</strong><%=user.getName()%>
		</div>
		<%
		List<Cart> carts = UserFactory.getCartInstance().getAllBookFromCart(user.getUserID());
		double price = UserFactory.getCartInstance().getAllPrice(user.getUserID());
		for(Iterator<Cart> iter=carts.iterator();iter.hasNext();){
			Cart cart = iter.next();
			System.out.print(cart.getBookID());
		%>
	<div class = "info">
		<div class = "info-left">  
			<span>书 名: <%=cart.getBookName()%></span>
	        <span>价格： <%=cart.getPrice() %></span>
			<span>数量：<%=cart.getQuantity() %></span>
		</div>
                   
        <form action="AddNumber" method="get">
             <input type = "hidden" name="bookID" value=<%=cart.getBookID()%>>
             <input type = "hidden" name="userID" value=<%=user.getUserID()%>>
             <input type = "submit" value="增加1">
        </form>
        <form action="reduceNumber" method="get">
             <input type = "hidden" name="bookID" value=<%=cart.getBookID()%>>
             <input type = "hidden" name="userID" value=<%=user.getUserID()%>>
             <input type = "submit" value="减少1">
        </form>
	</div>
	<%} %>
	<div class="price">总价：<%=price %></div>
	<div class = "order"><a href="#">提交订单</a></div>
	<div class = "back"><a href="LoginSucessed.jsp">返回</a></div>
	 <div class ="footer">four_WW Maker</div>  
</body>
</html>