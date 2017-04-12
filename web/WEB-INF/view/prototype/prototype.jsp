<%--
  Created by IntelliJ IDEA.
  User: majunsheng
  Date: 2017/3/30
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/lib/jquery/jquery-3.0.0.min.js"></script>
<html>
<head>
    <title>prototype</title>
</head>
<body>
        <label>prototype属性</label>
</body>

<script type="application/javascript">

    $(function () {
        //console.log(Object.getOwnPropertyNames(Array.prototype));
        var arr = [1,2,3,4,5,3,2,4,6,4,2,5,7,3,2,5,4,3,0,9,7,5,7];
        var arrStr = [{a:2,b:3},{a:3,b:1},{a:4,b:7},{a:7,b:4},{a:5,b:5},{a:6,b:4}];
        var item =[];
        for(var i =0;i<arr.length;i++){
            var t = arr[i];
            if($.inArray(t,item)==-1){
                item.push(t);
            }
        }
        arrStr.sort(function (x,y) {
            if(x.b>y.b){
                return 1;
            }else if (x.b==y.b){
                return x.a>y.a? 1:-1;
            }else if (x.b<y.b){
                return -1;
            }
        });
        for(var i=0;i<arrStr.length;i++){
            console.log(arrStr[i].a+","+arrStr[i].b);
        }
        console.log(item.sort(function (a,b) {
            return a<b? 1:-1;
        }));
    });
    function prototype() {
        var t = new Object();
        var num = new Number();
        var arr = new Array();

    }
</script>
</html>
