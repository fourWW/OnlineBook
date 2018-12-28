package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Book;
import Factory.UserFactory;

/** 
* @author four_WW: 
* @version 创建时间：2018年12月22日 下午3:02:52 
* @function:
*/
@SuppressWarnings("serial")
public class SearchBookServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月22日 上午12:10:21 
		* @function
		*/ 
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/SearchBook.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月22日 上午9:30:55 
		* @function
		*/ 
		super.doGet(req, resp);
	}
}
