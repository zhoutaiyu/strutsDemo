package edu.cn.action;

import com.opensymphony.xwork2.ActionContext;
import edu.cn.pojo.Book;
import edu.cn.service.BookService;
import edu.cn.service.impl.BookServiceImp;

/**
 * Created by FZH on 2017/9/18.
 */
public class BookAction {

    private Book book;
    private String msg = "";//显示提示消息

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    private BookService bookService = new BookServiceImp();

    /**
     * 根据图书类型查找图书集合
     *
     * @return
     * @throws Exception
     */
    public String queryByType() throws Exception {
        ActionContext.getContext().put("booklist", bookService.selectByType(book.getType()));
        msg = "图书类型为" + book.getType() + "的图书列表：";
        ActionContext.getContext().put("msg", msg);
        return "bookList";
    }

    /**
     * 查询所有图书
     *
     * @return
     * @throws Exception
     */
    public String queryAll() throws Exception {
        ActionContext.getContext().put("booklist", bookService.selectAll());
        msg = "全部图书：";
        ActionContext.getContext().put("msg", msg);
        return "bookList";
    }

    /**
     * 添加图书
     *
     * @return
     * @throws Exception
     */
    public String insert() throws Exception {
        ActionContext.getContext().put("msg", bookService.insertBook(book));
        ActionContext.getContext().put("booklist", bookService.selectAll());
        return "bookList";
    }

    /**
     * 由前台传过来的isbn参数查询到一条记录，并填充到表单中
     *request域设置的属性名不建议和book对象相同，否则会产生el读不出数据的情况
     * @return
     * @throws Exception
     */
    public String edit() throws Exception {
        Book b=bookService.selectByisbn(book.getIsbn());
        ActionContext.getContext().put("b",b);
        return "editBook";
    }

    /**
     * 根据前台封装的数据修改数据库，同时传来隐藏域的主键
     *
     * @return
     * @throws Exception
     */
    public String editSubmit() throws Exception {
        bookService.editBook(book);
        msg = "修改成功";
        ActionContext.getContext().put("msg", msg);
        ActionContext.getContext().put("booklist", bookService.selectAll());
        return "bookList";
    }

    public String delete() throws Exception {
        bookService.deleteBook(book.getIsbn());
        msg = "删除成功";
        ActionContext.getContext().put("msg", msg);
        ActionContext.getContext().put("booklist", bookService.selectAll());
        return "bookList";
    }
}
