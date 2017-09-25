package edu.cn.service;

import edu.cn.pojo.Book;

import java.util.List;

/**
 * Created by FZH on 2017/9/18.
 */
public interface BookService {
    /**
     * 按类型查找
     * @param type
     * @return
     */
    public List<Book> selectByType(String type) throws Exception ;

    /**
     * 查询全部图书
     * @return
     */
    public List<Book> selectAll() throws Exception;

    /**
     * 添加图书
     * @return
     */
    public  String insertBook(Book book) throws Exception;

    /**
     * 根据编号返回该图书信息
     * @param isbn
     * @return
     */
    public Book selectByisbn(String isbn) throws Exception;

    /**
     * 根据前台封装的数据修改数据库，传来隐藏域的主键
     * @param book
     */
    public void editBook(Book book) throws Exception;

    /**
     * 通过主键删除图书
     * @param isbn
     */
    public void deleteBook(String isbn) throws Exception;
}
