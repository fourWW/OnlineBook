package UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.User;
import DButil.DBUtil;
import c3po.C3P0SimpleUtils;

/** 
* @author four_WW: 
* @version 创建时间：2018年12月6日 上午9:26:05 
* @function:
*/
public class  UserDAOImpl implements  UserDAO {
    Connection conn=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null; 

	@Override
	public boolean addUser(User user) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月11日 下午9:52:40 
		* @function
		*/ 
		boolean flag = false;
		String sql="insert into user(name, password) values (?,?)";
        try {
            conn=C3P0SimpleUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getPassword());
            pstmt.executeUpdate();
            flag = true;
            System.out.println("添加用户成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	C3P0SimpleUtils.release(conn, pstmt, rs);
        }
        return flag;
	}

	@Override
	public boolean deleteUser(int id) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月11日 下午9:52:40 
		* @function
		*/ 
		boolean flag = false;
		 String sql="delete from user where id=?";
	        try {
	            conn=C3P0SimpleUtils.getConnection();
	            pstmt=conn.prepareStatement(sql);
	            pstmt.setInt(1, id);
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
	public boolean updateUserInfo(User user) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月11日 下午9:52:40 
		* @function
		*/ 
		boolean flag = false;
		 String sql="update user set phone=?,email=?,address=? where UserID=?";
	        try {
	            conn=C3P0SimpleUtils.getConnection();
	            pstmt=conn.prepareStatement(sql);
	            pstmt.setString(1, user.getPhone());
	            pstmt.setString(2, user.getEmail());
	            pstmt.setString(3, user.getAddress());
	            pstmt.setInt(4, user.getUserID());
	            pstmt.executeUpdate();
	            flag = true;
	            System.out.println("修改用户信息成功！");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	        	C3P0SimpleUtils.release(conn, pstmt, rs);
	        }
	        return flag;
	}

	@Override
	public List<User> getAllUser() {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月11日 下午9:52:40 
		* @function
		*/ 
		 List<User> users=new ArrayList<User>();
	        String sql="select * from user";
	        try {
	            conn=C3P0SimpleUtils.getConnection();
	            pstmt=conn.prepareStatement(sql);
	            rs=pstmt.executeQuery();
	            while(rs.next()){
	            	User user=new User(rs.getInt(1),rs.getString(2),rs.getString(3));
	            	users.add(user);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	        	C3P0SimpleUtils.release(conn, pstmt, rs);
	        }
	        return users;
	}

	@Override
	public User getUser(String name, String psd) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月11日 下午9:52:40 
		* @function
		*/ 
		User user=null;
        String sql="select * from user where name=? and password = ?";
        try {
            conn=C3P0SimpleUtils.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, psd);
            rs=pstmt.executeQuery();
            if(rs.next()){
            	user=new User(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
        	C3P0SimpleUtils.release(conn, pstmt, rs);
        }
        return user;
	}

	@Override
	public List<User> getUserByCondition(String name) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月11日 下午9:52:40 
		* @function
		*/ 
		 List<User> users=new ArrayList<User>();
	        String sql="select * from user where name like ?";
	        try {
	            conn=C3P0SimpleUtils.getConnection();
	            pstmt=conn.prepareStatement(sql);
	            pstmt.setObject(1, "%"+name+"%");//注意此写法
	            rs=pstmt.executeQuery();
	            while(rs.next()){
	            	User user=new User(rs.getInt(1),rs.getString(2), rs.getString(3));
	            	users.add(user);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }finally{
	        	C3P0SimpleUtils.release(conn, pstmt, rs);
	        }
	        return users;
	}

	@Override
	public boolean CheckUser(User user) {
		/** 
		* @author 作者 E-mail: 
		* @version 创建时间：2018年12月17日 上午11:34:27 
		* @function
		*/ 
		boolean flag = false;
		String sql="select * from user where name=? and password = ?";
		try {
	            conn=C3P0SimpleUtils.getConnection();
	            pstmt=conn.prepareStatement(sql);
	            pstmt.setString(1, user.getName());
	            pstmt.setString(2, user.getPassword());
	            rs=pstmt.executeQuery();
	            if(rs.next()){
	            	flag = true;
	  	            System.out.println("用户名和密码存在！");
	            }
	          
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("用户名不存在");
	        }finally{
	        	C3P0SimpleUtils.release(conn, pstmt, rs);
	        }
	        return flag;
	}
}