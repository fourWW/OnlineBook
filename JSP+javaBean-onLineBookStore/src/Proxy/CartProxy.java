package Proxy;

import java.util.List;

import Bean.Book;
import Bean.Cart;
import UserDao.CartDao;
import UserDao.CartDaoImpl;

/** 
* @author four_WW: 
* @version 创建时间：2018年12月18日 下午12:04:55 
* @function:
*/
public class CartProxy implements CartDao{
	private CartDaoImpl cd = null;
	public CartProxy() {		
		cd = new CartDaoImpl();
	}
	@Override
	public boolean updateBookNumber(Book book,int UserID, int number) {
		return cd.updateBookNumber(book,UserID, number);
	}
	@Override
	public double getAllPrice(int UserID) {
		return cd.getAllPrice(UserID);
	}
	@Override
	public boolean addCart(Book book,int UserID){
		return cd.addCart(book,UserID);
	}
	@Override
	public boolean clearCart(int UserID) {
		return cd.clearCart(UserID);
	}
	@Override
	public boolean isExist(int UserID, int BookID) {
		return cd.isExist(UserID, BookID);
	}
	@Override
	public boolean deleteBook(int UserID,Book book) {
		return cd.deleteBook(UserID,book);
	}
	@Override
	public List<Cart> getAllBookFromCart(int UserID) {
		return cd.getAllBookFromCart(UserID);
	}
	@Override
	public int getCartNumberByID(int UserID, int BookID) {
		return cd.getCartNumberByID(UserID, BookID);
	}
}
