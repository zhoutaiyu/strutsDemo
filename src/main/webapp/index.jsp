<%@ page language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>index.jsp</title>
</head>
<body>
<h5>按类别查询图书</h5>
<form action="book_queryByType.action" method="post">
    书籍类别：<input type="text" name="book.type"> <!-- 参数名和action中属性名一样 -->
    <input type="submit" name="subm" value="查询">
</form>
<h5>插入图书信息</h5>
<form action="book_insert.action" method="post">
    编号：<input type="text" name="book.isbn"><br>
    标题：<input type="text" name="book.title"><br>
    类型：<input type="text" name="book.type"><br>
    价格：<input type="text" name="book.price"><br>
    <input type="submit" value="插入">
</form>
<h5>查看全部图书信息</h5>
<form action="book_queryAll.action" method="post">
    <input type="submit" value="查询所有">
</form>
</body>
</html>
