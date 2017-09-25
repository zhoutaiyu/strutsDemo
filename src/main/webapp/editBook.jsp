<%--
  Created by IntelliJ IDEA.
  User: 周太宇
  Date: 2017/9/24
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>编辑图书信息</title>
    <style>
        div {
            text-align: center;
        }
    </style>
</head>
<body>
<div><span style="color: red">请编辑你想修改的信息</span></div>
<br>
<form action="book_editSubmit.action" method="post">
    <table border="1" align="center">
        <tr>
            <td>编号</td>
            <td>标题</td>
            <td>类型</td>
            <td>价格</td>
            <td></td>
        </tr>
        <tr>
            <!--隐藏域，传递主键值。
            如果EL遍历的只有一个对象，不能用c:each，直接引用即可-->
            <input type="hidden" name="book.isbn" value='${b.isbn}'/>
            <td>${book.isbn}</td>
            <td>
                <input type="text" name="book.title" value='${b.title}'/>
            </td>
            <td><input type="text" name="book.type" value='${b.type}'/></td>
            <td><input type="text" name="book.price" value='${b.price}'/></td>
            <td><input type="submit" value="确定修改"/></td>
        </tr>
    </table>
</form>
<div><a href="index.jsp">返回主页</a></div>
</body>
</html>
