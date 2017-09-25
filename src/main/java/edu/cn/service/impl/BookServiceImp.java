package edu.cn.service.impl;

import edu.cn.dbo.BookDao;
import edu.cn.pojo.Book;
import edu.cn.service.BookService;

import java.util.List;

/**
 * Created by FZH on 2017/9/18.
 */
public class BookServiceImp implements BookService {
    private BookDao bookDao = new BookDao();

    /**
     * 调用dao层查询所有图书方法
     *
     * @return
     */
    public List<Book> selectAll() throws Exception {
        return bookDao.selectAll();
    }

    /**
     * 调用dao层按类型查询图书方法
     *
     * @param type
     * @return
     * @throws Exception
     */
    public List<Book> selectByType(String type) throws Exception {
        return bookDao.selectByType(type);
    }

    public String insertBook(Book book) throws Exception {
        return bookDao.insertBook(book);
    }

    /**
     * 根据编号返回该图书信息
     *
     * @param isbn
     * @return
     */
    public Book selectByisbn(String isbn) throws Exception {
        Book book =bookDao.selectByisbn(isbn);
        return  book;
    }

    /**
     * 根据编号更新图书
     *
     * @param book
     * @throws Exception
     */
    public void editBook(Book book) throws Exception {
        bookDao.editBook(book);
    }

    /**
     * 根据isbn删除图书
     *
     * @param isbn
     */
    public void deleteBook(String isbn) throws Exception {
        bookDao.deleteBook(isbn);
    }
}
