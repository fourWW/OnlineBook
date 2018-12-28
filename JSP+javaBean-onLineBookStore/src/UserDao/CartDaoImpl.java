package UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.ReturnaddressType;

import Bean.Book;
import Bean.Cart;
import Factory.UserFactory;
import c3po.C3P0SimpleUtils;

/** 
* @author four_WW: 
* @version 创建时间：2018年12月18日 上午10:26:10 
* @function:
*/
public class CartDaoImpl implements CartDao {
	Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null; 
	@Override
	public boolean deleteBook(int UserID,Book book) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月18日 上午10:26:22 
		* @function 通过用户ID 书籍ID来删除书籍
		*/ 
		boolean flag = false;
		String sql="delete from cart where UserID=? and BookID=?";
		try {
	            conn=C3P0SimpleUtils.getConnection();
	            pstmt=conn.prepareStatement(sql);
	            pstmt.setInt(1, UserID);
	            pstmt.setInt(2, book.getBookID());
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
	public boolean updateBookNumber(Book book,int UserID, int number) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月18日 上午10:26:22 
		* @function 修改书籍数量
		*/ 
		boolean flag = false;
		 String sql="update cart set quantity =? where UserID=? and BookID=?";
	        try {
	            conn=C3P0SimpleUtils.getConnection();
	            pstmt=conn.prepareStatement(sql);
	            pstmt.setDouble(1, number);
	            pstmt.setInt(2, UserID);
	            pstmt.setInt(3, book.getBookID());
	            int n = pstmt.executeUpdate();	            
	            if(n > 0) {
	            	flag = true;
	            	System.out.println("修改书籍数量"+book.getBookName()+"成功！");
	            }
	          
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	        	C3P0SimpleUtils.release(conn, pstmt, rs);
	        }
	        return flag;
	}

	@Override
	public List<Cart> getAllBookFromCart(int UserID) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月18日 上午10:26:22 
		* @function  获取用户的购物车列表
		*/ 
		List<Cart> carts=new ArrayList<Cart>();
        String sql="select * from cart where UserID = ?";
        try {
            conn=C3P0SimpleUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, UserID);
            rs=pstmt.executeQuery();
            while(rs.next()){
            	Cart cart=new Cart(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getDouble(5),
            			rs.getInt(6));
            	carts.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	C3P0SimpleUtils.release(conn, pstmt, rs);
        }
        return carts;
	}

	@Override
	public double getAllPrice(int UserID) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月18日 上午10:26:22 
		* @function 获取购物车的总价格
		*/ 
		double sum = 0;
        String sql="select price,quantity from cart where UserID = ?";
        try {
            conn=C3P0SimpleUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, UserID);
            rs=pstmt.executeQuery();
            while(rs.next()){
            	sum += rs.getDouble(1) * rs.getInt(2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	C3P0SimpleUtils.release(conn, pstmt, rs);
        }
        return sum;
	}

	@Override
	public boolean addCart(Book book,int UserID) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月18日 上午10:26:22 
		* @function
		*/ 
		boolean flag = UserFactory.getCartInstance().isExist(UserID, book.getBookID());
		if(flag == false) {
			String sql="insert into cart(UserID,BookID,bookName,price,quantity) values (?,?,?,?,?)";
	        try {
	            conn=C3P0SimpleUtils.getConnection();
	            pstmt=conn.prepareStatement(sql);
	            pstmt.setInt(1, UserID);
	            pstmt.setInt(2, book.getBookID());
	            pstmt.setString(3, book.getBookName());
	            pstmt.setDouble(4, book.getUnit());
	            pstmt.setInt(5, 1);
	            pstmt.executeUpdate();
	            flag = true;
	            System.out.println("添加书籍成功！");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	        	C3P0SimpleUtils.release(conn, pstmt, rs);
	        }       
		}
		else {
        	System.out.println("书籍已存在！");
        }
        return flag;
	}

	@Override
	public boolean clearCart(int UserID) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月18日 上午11:37:18 
		* @function 清空购物车
		*/ 
		boolean flag = false;
		String sql="delete from cart where UserID=?";
        try {
            conn=C3P0SimpleUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, UserID);
            pstmt.executeUpdate();
            flag = true;
            System.out.println("购物车删除成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	C3P0SimpleUtils.release(conn, pstmt, rs);
        }
        return flag;
	}

	@Override
	public boolean isExist(int UserID, int BookID) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月18日 上午11:42:51 
		* @function 查看购物车的商品是否过期
		*/ 
		boolean flag = false;
		String sql="select * from cart where UserID=? and BookID = ?";
        try {
            conn=C3P0SimpleUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, UserID);
            pstmt.setInt(2, BookID);
            rs=pstmt.executeQuery();
            if(rs.next()) {
            	flag = true;
                System.out.println("商品过期！");
            }           
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	C3P0SimpleUtils.release(conn, pstmt, rs);
        }
        return flag;
	}

	@Override
	public int getCartNumberByID(int UserID,int BookID) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月20日 上午10:15:05 
		* @function 得到购物车某书的数量
		*/ 
		int number = 0;
		String sql="select quantity from cart where UserID=? and BookID = ?";
        try {
            conn=C3P0SimpleUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, UserID);
            pstmt.setInt(2, BookID);
            rs=pstmt.executeQuery();
            if(rs.next()) {
            	number = rs.getInt(1);
            }           
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	C3P0SimpleUtils.release(conn, pstmt, rs);
        }
        return number;
	}

}
