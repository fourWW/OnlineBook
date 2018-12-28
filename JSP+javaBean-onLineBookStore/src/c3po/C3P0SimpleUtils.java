package c3po;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/** 
* @author four_WW: 
* @version 创建时间：2018年11月27日 上午9:27:03 
* @function: c3p0连接池的建立
*/
public class C3P0SimpleUtils {
    //1. 构造私有
    private C3P0SimpleUtils() {
    }

    //2. 定义一个变量, 用来记录连接池对象. 由于所有的连接池对象都继承自DataSource 所以这里使用多态的形式
    private static DataSource ds = new ComboPooledDataSource();

    //3. 对外提供一个方法, 用来获取连接池对象.
    public static DataSource getDataSource() {
        return ds;
    }

    //4. 对外提供一个方法, 用来获取连接对象. 连接对象是从数据库连接池中获取的.
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //5. 释放资源 释放资源的方法跟之前提取的JDBC简单工具类基本一样
    public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                	pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void release(Connection conn, Statement stm, ResultSet rs) {
    	  try {
              if (rs != null) {
                  rs.close();
              }
          } catch (SQLException e) {
              e.printStackTrace();
          } finally {
              try {
                  if (stm != null) {
                	  stm.close();
                  }
              } catch (SQLException e) {
                  e.printStackTrace();
              } finally {
                  try {
                      if (conn != null) {
                          conn.close();
                      }
                  } catch (SQLException e) {
                      e.printStackTrace();
                  }
              }
          }
    }
}