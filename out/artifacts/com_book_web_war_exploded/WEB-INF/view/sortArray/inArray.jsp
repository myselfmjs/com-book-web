<%--
  Created by IntelliJ IDEA.
  User: majunsheng
  Date: 2017/3/29
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/lib/jquery/jquery-3.0.0.min.js"></script>
<html>
<head>
    <title>Jquery数组去重复</title>
</head>
<body>
            <label>原数据：<p style="display: inline-block"></p></label></br>
            <label><a href="#" onclick="checkArray(this)">去重:</a><p style="display: inline-block"></p></label>

</body>

<script type="application/javascript">
    $(function () {
        var arr =[0,4,2,1,5,3,6,3,7,4,2,7,2,1,6,1,5,2];
        $("p:first").html(arr.join());
    });
    function checkArray(element) {
        var arr = $("p:first").html().split(",");
        //console.log(arr);
        var new_arr = [];
        for(var i=0;i<arr.length;i++){
            var item = arr[i];
            if($.inArray(item,new_arr)==-1){
                new_arr.push(item);
            }
        }
        $(element).next().html(new_arr.sort().join());
    }

</script>
</html>
