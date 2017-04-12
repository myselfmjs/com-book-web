<%--
  Created by IntelliJ IDEA.
  User: majunsheng
  Date: 2017/3/30
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/lib/jquery/jquery-3.0.0.min.js"></script>
<html>
<head>
    <title>Jquery闭包</title>
</head>

<script type="application/javascript">
    $(function () {
        function createFunction() {
            var arr =new Array();
            for(var i=0;i<=10;i++){
                arr[i]=function () {
                    return i;
                }
            }
            return arr;
        }
        var funcs = createFunction();
        for(var i=0; i<funcs.length; i++){
            console.log(i+"="+funcs[i]());//猜猜输出的是几
        }

        function a() {
            var a=0;
            function inc() {
                a++;
                console.log(a);
            }
            return inc;
        }
        var funA= a();
        funA();
        funA();
        funA();
    });
    
</script>
<body>
            <label>闭包！</label>
</body>

</html>
