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
    <a href="/user/downList">进入上传页面</a>
    <a href="/downLoad/list">进入下载一览页面</a>
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

    $(function () {
        //匿名函数变体 立即调用的函数表达式(自执行函数)
       /*(function (x,y) {
           console.log(x+y);
        })(5,6);*/

        // 函数表达式将被立即调用 因此该模式用于确保代码块的执行上下文按照预期的效果执行
        // 当 x= 42 传入function中 不管外部的x如何变化 内部取得的仍然还是42
        /*var x = 42;
        console.log(x);
        var message = (function (x) {
            return function () {
                console.log("x is  " + x);
            }
        })(x);
        message();
        x = 12;
        console.log(x);
        message();*/

        //扩展字符串String类型 的方法(字符串 'true false' 转换为boolean 类型)
        /*String.prototype.boolean = function () {
            return "true" == this;
        };
        var t = 'true'.boolean();
        var f = 'false'.boolean();
        console.log(t);
        console.log(f);*/

        //使用名为 method 方法扩充了Function.prototype
        /*Function.prototype.method = function (name,func) {
            this.prototype[name] =func;
            return this;
        };
        //重写String类的 boolean方法
        String.method('boolean', function () {
            return 'true' == this;
        });
        console.log('true'.boolean());*/

        //克隆jQuery对象
        /*var clonedjsq = $.extend(true,{},$);
        //返回 'Object'
        var jq = $.type(clonedjsq);
        //转换为一个JS数组
        var jqArray = $.makeArray(clonedjsq);
        //返回"array"
        var array = $.type(jqArray);

        console.log(jq);
        console.log(array);*/
    });
</script>
</body>
</html>
