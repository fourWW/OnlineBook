package DButil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** 
* @author four_WW: 
* @version 创建时间：2018年12月6日 上午9:28:41 
* @function:
*/
public class DBUtil {
	private  Connection conn = null;
    //获取数据库连接
    public Connection getConnection(){       
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/connection", "root", "wyq980315");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭所有资源 
    public void close(){
        if(conn != null) {
        	try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
    }
}
