package Test;

import java.util.Iterator;
import java.util.List;

import Bean.Book;
import Bean.Cart;
import Bean.User;
import Factory.UserFactory;

/** 
* @author four_WW: 
* @version 创建时间：2018年12月19日 下午10:45:47 
* @function:
*/
public class test {
	public static void main(String[] args) {
	
		List<Book> books = UserFactory.getBookInstance().getBookByLimit(5, 3);
		for(Iterator<Book> iter =books.iterator();iter.hasNext();){
			Book book = iter.next();
			System.out.println(book.getBookName());
			}
	}
	
	
	
}
