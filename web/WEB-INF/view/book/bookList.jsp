<%--
  Created by IntelliJ IDEA.
  User: majunsheng
  Date: 2017/3/9
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>--%>
<script src="/lib/jquery/jquery-3.0.0.min.js"></script>
<style type="text/css">
    table {border:1px solid #F00}
</style>

<html>
<head>
    <title>BookList</title>
</head>
<body>
<form >
    <table align="center" >
        <tr><th>书名</th><th>类型</th><th>价格</th></tr>
        <c:forEach items="${book}"  var="book">
            <tr>
                <td>${book.bookName}</td><td>${book.bookType}</td><td>${book.bookPrice}</td>
            </tr>
        </c:forEach>

    </table>
</form>
<script type="text/javascript">
    var url = {
        login:"/user/login"
    }
    //重置
    function Reset() {
        window.location.href = "";
    }

    //设置焦点
    $(function () {
        $("#username")[0].focus();
    });
</script>
</body>
</html>
