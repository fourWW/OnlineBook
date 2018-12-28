package Proxy;

import java.util.List;

import Bean.Book;
import UserDao.BookDao;
import UserDao.BookDaoImpl;

/** 
* @author four_WW: 
* @version 创建时间：2018年12月18日 下午12:03:40 
* @function:
*/
public class BookProxy implements BookDao{
	private BookDaoImpl bd = null;
	public BookProxy() {		
		bd = new BookDaoImpl();
	}
	@Override
	public boolean CheckBook(String name) {
		return bd.CheckBook(name);
	}
	@Override
	public boolean addBook(Book book) {
		return bd.addBook(book);
	}
	@Override
	public boolean deleteBook(String name) {
		return bd.deleteBook(name);
	}
	@Override
	public boolean updateBookPrice(Book book, double price) {
		return bd.updateBookPrice(book,price);
	}
	@Override
	public List<Book> getAllBook() { 
		return bd.getAllBook();
	}
	@Override
	public Book getBookByID(int BookID) {
		return bd.getBookByID(BookID);
	}
	@Override
	public List<Book> getBookByCondition(String name) {
		return bd.getBookByCondition(name);
	}
	@Override
	public List<Book> getBookByCategory(String Category) {
		return bd.getBookByCategory(Category);
	}
	
	public List<Book> getBookByLimit(int startPage, int recordNumber){
		return bd.getBookByLimit(startPage,recordNumber);
	}
}
