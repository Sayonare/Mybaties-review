package spring.mvc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by wyz_Sayonare on 2017/10/10.
 * @disCription 连接数据库
 */
public class Dbconn {

    final static String DRIVER = "com.mysql.jdbc.Driver";
    final static String USERNAME="root";
    final static String PASSWORD="pass";
    final static String URL="jdbc:mysql://localhost:3306/test";

    public static Connection getConn()
    {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("数据库加载异常");
            e.printStackTrace();
        }
        Connection conn=null;
        try {
            Connection connection = conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("数据库连接异常");
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConn(Connection conn)
    {
        if(conn==null)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("数据库连接关闭异常");
                e.printStackTrace();
            }
        }
    }


}
