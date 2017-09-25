package edu.cn.dbo;

import java.sql.*;

/**
 * Created by FZH on 2017/9/18.
 */
public class DbConnection {
    /**
     * 获得连接
     *
     * @return
     */
    public static Connection getConnect() {

        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?user=root&password=1234");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("URL");
        }
        return conn;
    }

    /**
     * 关闭查询产生的资源
     *
     * @param result
     * @param pstmt
     * @param con
     * @throws Exception
     */
    public static void closeResourses(ResultSet result, PreparedStatement pstmt, Connection con) throws Exception {
        if (result != null) {
            result.close();
        }
        closeResoursesNotresult(pstmt, con);
    }

    /**
     * 关闭更新产生的资源
     *
     * @param pstmt
     * @param con
     * @throws Exception
     */
    public static void closeResoursesNotresult(PreparedStatement pstmt, Connection con) throws Exception {
        if (pstmt != null) {
            pstmt.close();
        }
        if (con != null) {
            con.close();
        }
    }


}

