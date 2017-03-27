<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: majunsheng
  Date: 2017/3/9
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<base href="${pageContext.request.scheme}://${pageContext.request.serverName}
:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>--%>
<script type="text/javascript" src="/lib/jquery/jquery-3.0.0.min.js"></script>
<html>
<head>
    <title>haha</title>
</head>
<body style="text-align: center">
    欢迎 ${userName} 登录!!!<br>
    <input type="button" value="退出" id="btn"><br>
    <input type="button" value="查询" id="search" onclick="search()">
    <br>  <br>  <br>
<table align="center" border="1px">
    <thead><td>Admin</td><td>Password</td></thead>
    <c:forEach var="row" varStatus="i" items="${admin}">
    <tr><td>${row.username}</td><td>${row.password}</td></tr>
    </c:forEach>
</table>


<script type="text/javascript">

    $(function () {
        //退出
        $("#btn").click(function () {
            window.location.href = "/user/deleteLogin";
        });
    });

    //查询
    function search() {
        $.ajax({
            type: 'post',
           /* async:false,*/
            url:"/user/list",
            data:{'id':1},
            dataType:'json',
            success: function (data) {
                console.log("success");
                console.log(data);

            },
            error:function(data){
                console.log("error");
                console.log(data);
            }
        });
    }

</script>
</body>
</html>
