package Factory;

import Proxy.BookProxy;
import Proxy.CartProxy;
import Proxy.UserProxy;
import UserDao.BookDao;
import UserDao.CartDao;
import UserDao.UserDAO;

/** 
* @author four_WW: 
* @version 创建时间：2018年12月11日 下午10:39:24 
* @function:
*/
public class UserFactory {
	public static UserDAO getUserInstance() {
		UserDAO ud = new UserProxy();
		return ud;
	}
	public static BookDao getBookInstance() {
		BookDao bd = new BookProxy();
		return bd;
	}
	public static CartDao getCartInstance() {
		CartDao cd = new CartProxy();
		return cd;
	}
}
