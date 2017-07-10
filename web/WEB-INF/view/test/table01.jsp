<%--
  Created by IntelliJ IDEA.
  User: majunsheng
  Date: 2017/3/28
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="/lib/jquery/jquery-3.0.0.min.js"></script>
<style type="text/css">
    table {border:1px solid #F00}
    td {border:1px solid #F00}
</style>
<html>

<head>
    <title>Title</title>
</head>
<body>
    <table align="center">
        <tr><td>1</td><td>1</td><td>1</td>
            <td>
                <a href="#" name="MoveUp" onclick="check(this,'MoveUp')">上移</a>
                <a href="#" name="MoveDown" onclick="check(this,'MoveDown')">下移</a>
            </td>
        </tr>
        <tr><td>2</td><td>2</td><td>2</td>
            <td>
                <a href="#"  name="MoveUp" onclick="check(this,'MoveUp')">上移</a>
                <a href="#"  name="MoveDown" onclick="check(this,'MoveDown')">下移</a>
            </td>
        </tr>
        <tr><td>3</td><td>3</td><td>3</td>
            <td>
                <a href="#" name="MoveUp" onclick="check(this,'MoveUp')">上移</a>
                <a href="#" name="MoveDown" onclick="check(this,'MoveDown')">下移</a>
            </td>
        </tr>
        <tr><td>4</td><td>4</td><td>4</td>
            <td  id="">
                <a href="#" name="MoveUp" onclick="check(this,'MoveUp')">上移</a>
                <a href="#" name="MoveDown" onclick="check(this,'MoveDown')">下移</a>
            </td>
        </tr>
    </table>
</body>

<script type="text/javascript">
    $(function () {
        $("a[name='MoveUp']:first").css("display","none");
        $("a[name='MoveDown']:last").css("display","none");
    });
    function check(t,oper){
        var data_tr=$(t).parent().parent(); //获取到触发的tr
        if(oper=="MoveUp"){    //向上移动
            if($(data_tr).prev().html()==null){ //获取tr的前一个相同等级的元素是否为空
                //$(t).hide();
                //alert("已经是最顶部了!");
                return;
            }else {
                $(data_tr).insertBefore($(data_tr).prev()); //将本身插入到目标tr的前面
                var sort = $(data_tr).find("td:first").html();
                $(data_tr).find("td:first").html(sort - 1);
                $(data_tr).next().find("td:first").html(sort);
            }
        }else{
            if($(data_tr).next().html()==null){
               // alert("已经是最低部了!");
                return;
            }else {
                $(data_tr).insertAfter($(data_tr).next()); //将本身插入到目标tr的后面
                var sort = $(data_tr).find("td:first").html();
                var up = $(data_tr).prev().find("td:first").html();
                $(data_tr).find("td:first").html(up);
                $(data_tr).prev().find("td:first").html(sort);
            }
        }
        $("a[name='MoveUp']").css("display","inline-block");
        $("a[name='MoveDown']").css("display","inline-block");
        $("a[name='MoveUp']:first").css("display","none");
        $("a[name='MoveDown']:last").css("display","none");
    }

</script>
</html>
