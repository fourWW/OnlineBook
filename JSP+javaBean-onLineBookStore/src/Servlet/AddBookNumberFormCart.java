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
* @version 创建时间：2018年12月22日 上午10:47:48 
* @function:
*/
public class AddBookNumberFormCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月22日 上午12:10:21 
		* @function
		*/ 
		int bookID = Integer.parseInt(req.getParameter("bookID"));
		Book book = UserFactory.getBookInstance().getBookByID(bookID);
		int userID =Integer.parseInt(req.getParameter("userID"));
		int number = UserFactory.getCartInstance().getCartNumberByID(userID, bookID);
		UserFactory.getCartInstance().updateBookNumber(book, userID,number+1);
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/CartShow.jsp");
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
