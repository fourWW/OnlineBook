package UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Book;
import Bean.User;
import c3po.C3P0SimpleUtils;

/** 
* @author four_WW: 
* @version 创建时间：2018年12月18日 上午10:08:54 
* @function:
*/
public class BookDaoImpl implements BookDao{
	Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null; 
	@Override
	public boolean CheckBook(String name) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月18日 上午10:09:10 
		* @function 查看书籍信息是否存在
		*/ 
		boolean flag = false;
		String sql="select * from book where bookName=?";
		try {
	            conn=C3P0SimpleUtils.getConnection();
	            pstmt=conn.prepareStatement(sql);
	            pstmt.setString(1, name);
	            rs=pstmt.executeQuery();
	            if(rs.next()){
	            	flag = true;
	            }
	          
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	        	C3P0SimpleUtils.release(conn, pstmt, rs);
	        }
	        return flag;
	}

	@Override
	public boolean addBook(Book book) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月18日 上午10:09:10 
		* @function 添加书籍信息
		*/ 
		boolean flag = false;
		String sql="INSERT INTO book (bookName, author, publishDate, catagory, unit, synopsis) VALUES (?,?,?,?,?,?)";
        try {
            conn=C3P0SimpleUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, book.getBookName());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getPublishDate());
            pstmt.setString(4, book.getCatagory());
            pstmt.setDouble(5, book.getUnit());
            pstmt.setString(6, book.getSynopsis());
            pstmt.executeUpdate();
            flag = true;
            System.out.println("添加书籍成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	C3P0SimpleUtils.release(conn, pstmt, rs);
        }
        return flag;
	}

	@Override
	public boolean deleteBook(String name) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月18日 上午10:09:10 
		* @function 通过书名来删除书籍
		*/ 
		boolean flag = false;
		 String sql="delete from book where bookName=?";
	        try {
	            conn=C3P0SimpleUtils.getConnection();
	            pstmt=conn.prepareStatement(sql);
	            pstmt.setString(1, name);
	            pstmt.executeUpdate();
	            flag= true;
	            System.out.println("删除用户成功！");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	            C3P0SimpleUtils.release(conn, pstmt, rs);
	        }
	     return flag;
	}

	@Override
	public boolean updateBookPrice(Book book, double price) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月18日 上午10:09:10 
		* @function 更新书籍的价格
		*/ 
		boolean flag = false;
		 String sql="update book set unit=? where bookID=?";
	        try {
	            conn=C3P0SimpleUtils.getConnection();
	            pstmt=conn.prepareStatement(sql);
	            pstmt.setDouble(1, price);
	            pstmt.setInt(2, book.getBookID());
	            pstmt.executeUpdate();
	            flag = true;
	            System.out.println("价格修改成功！");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	        	C3P0SimpleUtils.release(conn, pstmt, rs);
	        }
	        return flag;
	}

	@Override
	public List<Book> getAllBook() {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月18日 上午10:09:10 
		* @function 得到所有书籍
		*/ 
		List<Book> books=new ArrayList<Book>();
        String sql="select * from book";
        try {
            conn=C3P0SimpleUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while(rs.next()){
            	Book book=new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
            			rs.getDouble(6),rs.getString(7));
            	books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	C3P0SimpleUtils.release(conn, pstmt, rs);
        }
        return books;
	}

	@Override
	public Book getBookByID(int BookID) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月18日 上午10:09:10 
		* @function 通过书名来得到书籍信息
		*/ 
		Book book = null;
        String sql="select * from book where bookID = ?";
        try {
            conn=C3P0SimpleUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, BookID);
            rs=pstmt.executeQuery();
            if(rs.next()){
            	book = new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
            			rs.getDouble(6),rs.getString(7));
            	System.out.println(book.getBookID());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	C3P0SimpleUtils.release(conn, pstmt, rs);
        }
        return book;
	}

	@Override
	public List<Book> getBookByCondition(String name) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月18日 上午10:09:10 
		* @function 通过书名进行模糊搜索
		*/ 
		List<Book> books=new ArrayList<Book>();
        String sql="select * from book where bookName like ?";
        try {
            conn=C3P0SimpleUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setObject(1, "%"+name+"%");//注意此写法
            rs=pstmt.executeQuery();
            while(rs.next()){
            	Book book=new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
            			rs.getDouble(6),rs.getString(7));
            	books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	C3P0SimpleUtils.release(conn, pstmt, rs);
        }
        return books;
	}

	@Override
	public List<Book> getBookByCategory(String category) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月18日 上午10:09:10 
		* @function  通过分类返回书的集合
		*/ 
		List<Book> books=new ArrayList<Book>();
        String sql="select * from book where catagory = ?";
        try {
            conn=C3P0SimpleUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, category);
            rs=pstmt.executeQuery();
            while(rs.next()){
            	Book book=new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
            			rs.getDouble(6),rs.getString(7));
            	books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	C3P0SimpleUtils.release(conn, pstmt, rs);
        }
        return books;
	}
	
	public List<Book> getBookByLimit(int startPage, int recordNumber) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月18日 上午10:09:10 
		* @function  
		*/ 
		List<Book> books=new ArrayList<Book>();
        String sql="select * from book limit ?,?";
        try {
            conn=C3P0SimpleUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, startPage);
            pstmt.setInt(2, recordNumber);
            rs=pstmt.executeQuery();
            while(rs.next()){
            	Book book=new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
            			rs.getDouble(6),rs.getString(7));
            	books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	C3P0SimpleUtils.release(conn, pstmt, rs);
        }
        return books;
	}

}
