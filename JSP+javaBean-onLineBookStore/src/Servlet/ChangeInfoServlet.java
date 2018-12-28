package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import Bean.Book;
import Bean.User;
import Factory.UserFactory;

/** 
* @author four_WW: 
* @version 创建时间：2018年12月22日 下午5:30:02 
* @function:
*/
public class ChangeInfoServlet extends HttpServlet{
	private static final long serialVersionUID = -6627653683374336696L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月22日 上午12:10:21 
		* @function
		*/ 
		String name = req.getParameter("name");
		String psd = req.getParameter("password");
		User user = UserFactory.getUserInstance().getUser(name, psd);
		user.setPhone(req.getParameter("phone"));
		user.setEmail(req.getParameter("email"));
		user.setAddress(req.getParameter("address"));
		UserFactory.getUserInstance().updateUserInfo(user);
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/LoginSucessed.jsp");
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
