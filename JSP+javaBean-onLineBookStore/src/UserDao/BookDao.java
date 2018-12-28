package UserDao;

import java.util.List;

import Bean.Book;
import Bean.User;

/** 
* @author four_WW: 
* @version 创建时间：2018年12月18日 上午9:47:59 
* @function:
*/
public interface BookDao {
	//查询书籍是否存在
	public boolean CheckBook(String name);
    //添加书籍
    public boolean addBook(Book book);

    //删除书籍
    public boolean deleteBook(String name);

    //修改书籍价格
    public boolean updateBookPrice(Book book, double price);

    //查询所有书籍信息
    public List<Book> getAllBook();

    //根据书名查询书籍所有信息
    public Book getBookByID(int BookID);

    //根据书名模糊查询
    public List<Book> getBookByCondition(String name);
    
    //根据书籍的类别查询
    public List<Book> getBookByCategory(String Category);
    //
    public List<Book> getBookByLimit(int startPage, int recordNumber);
	    
}
