package edu.cn.dbo;

import edu.cn.pojo.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 周太宇 on 2017/9/25.
 */
public class BookDao {
    /**
     * dao层之查询所有图书
     *
     * @return
     * @throws Exception
     */
    public List<Book> selectAll() throws Exception {
        PreparedStatement pstmt = null;
        ResultSet result = null;
        Connection con = DbConnection.getConnect();
        List<Book> list = new ArrayList<Book>();
        Book book = null;
        try {
            pstmt = con.prepareStatement("select isbn,title,type,price from bookta");
            result = pstmt.executeQuery();
            while (result.next()) {
                book = new Book();
                book.setIsbn(result.getString(1));
                book.setTitle(result.getString(2));
                book.setType(result.getString(3));
                book.setPrice(result.getDouble(4));
                list.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeResourses(result, pstmt, con);
        }

        return list;
    }

    /**
     * dao层之按类型查找图书
     *
     * @param type
     * @return
     */
    public List<Book> selectByType(String type) throws Exception {
        PreparedStatement pstmt = null;
        ResultSet result = null;
        Connection con = DbConnection.getConnect();
        List<Book> list = new ArrayList<Book>();
        Book book = null;
        try {
            pstmt = con.prepareStatement("select isbn,title,type,price from bookta where type = ?");
            pstmt.setString(1, type);
            result = pstmt.executeQuery();

            while (result.next()) {
                book = new Book();
                book.setIsbn(result.getString(1));
                book.setTitle(result.getString(2));
                book.setType(result.getString(3));
                book.setPrice(result.getDouble(4));
                list.add(book);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeResourses(result, pstmt, con);
        }
        return list;
    }

    /**
     * dao层之添加图书
     *
     * @param book
     * @return
     */
    public String insertBook(Book book) throws Exception {
        Connection conn = DbConnection.getConnect();
        PreparedStatement pstmt = null;
        int i = 0;
        String sql = "insert into bookta(isbn,title,type,price) VALUES (?,?,?,?)";
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, book.getIsbn());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getType());
            pstmt.setDouble(4, book.getPrice());
            i = pstmt.executeUpdate();
            DbConnection.closeResoursesNotresult(pstmt, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i == 1) {
            return "添加成功";
        }
        return "添加失败";
    }

    /**
     * dao层之按编号查找图书
     *
     * @param isbn
     * @return
     * @throws Exception
     */
    public Book selectByisbn(String isbn) throws Exception {
        PreparedStatement pstmt = null;
        ResultSet result = null;
        Connection con = DbConnection.getConnect();
        Book book = new Book();
        try {
            pstmt = con.prepareStatement("select isbn,title,type,price from bookta where isbn=?");
            pstmt.setString(1, isbn);
            result = pstmt.executeQuery();
            while (result.next()) {
                book.setIsbn(result.getString(1));
                book.setTitle(result.getString(2));
                book.setType(result.getString(3));
                book.setPrice(result.getDouble(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbConnection.closeResourses(result, pstmt, con);
        }
        return book;
    }

    /**
     * dao层之更新图书信息
     *
     * @param book
     * @throws Exception
     */
    public void editBook(Book book) throws Exception {
        PreparedStatement pstmt = null;
        Connection conn = DbConnection.getConnect();
        String sql = "update bookta SET title=?,type=?,price=? where isbn=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getType());
            pstmt.setDouble(3, book.getPrice());
            pstmt.setString(4, book.getIsbn());
            pstmt.executeUpdate();
            DbConnection.closeResoursesNotresult(pstmt, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * dao层之根据编号删除图书
     *
     * @param isbn
     */
    public void deleteBook(String isbn) throws Exception {
        PreparedStatement pstmt = null;
        Connection conn = DbConnection.getConnect();
        String sql = "DELETE from bookta where isbn=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, isbn);
            pstmt.executeUpdate();
            DbConnection.closeResoursesNotresult(pstmt, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
