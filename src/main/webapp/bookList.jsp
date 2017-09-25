<%--
  Created by IntelliJ IDEA.
  User: 周太宇
  Date: 2017/9/24
  Time: 8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>显示图书信息</title>
    <style>
        div {text-align:center;}
    </style>
</head>
<body>
<div><span style="color: red">${msg}</span></div>
<br>
<table border="1" align="center">
    <tr>
        <td>编号</td>
        <td>标题</td>
        <td>类型</td>
        <td>价格</td>
        <td>操作1</td>
        <td>操作2</td>
    </tr>
    <c:forEach items="${booklist}" var="book">
        <tr>
            <td>${book.isbn}</td>
            <td>${book.title}</td>
            <td>${book.type}</td>
            <td>${book.price}</td>
            <td>
                <form action="book_edit.action">
                    <input type="hidden" name="book.isbn" value="${book.isbn}">
                    <input type="submit" value="编辑"/>
                </form>
            </td>
            <td>
                <form action="book_delete.action">
                    <input type="hidden" name="book.isbn" value="${book.isbn}">
                    <input type="submit" value="删除"/>
                </form>
            </td>
        </tr>
        <br>
    </c:forEach>
</table>
<div><a href="index.jsp">返回主页</a></div>
</body>
</html>