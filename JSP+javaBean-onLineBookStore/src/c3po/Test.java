package c3po;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** 
* @author four_WW: 
* @version 创建时间：2018年11月27日 上午9:29:13 
* @function:使用c3p0工具类
*/

public class Test {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            //这里使用我们刚抽取出的工具类来从连接池中取出数据库连接对象
            conn = C3P0SimpleUtils.getConnection();
            //下面代码跟之前一样
            stat = conn.createStatement();
            String sql = "SELECT * FROM test";
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println(id + "--" + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //这里可以使用我们C3P0SimpleUtils工具类的释放资源的方法
            C3P0SimpleUtils.release(conn, stat, rs);
        }
    }
}
