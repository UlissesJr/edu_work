<%--
  Created by IntelliJ IDEA.
  User: Luobogan
  Date: 2021/6/20
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<script typet="text/javascript" src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
<script>

    $(function (){

        $("#username").blur(function(){
            // 获取用户名
            var name = $(this).val();

            // 判断用户名不为空和空串
            if (name != ull && name != "") {
                // 向后台发送请求
                $.ajax({
                    url:"/checkName",
                    async:true,
                    data:{username:name},
                    type:"GET", // 请求方式
                    dataType:"json", // 返回数据的数据类型

                    success:function (param) {
                        // 设置span中的内容
                        if (param.flag) {
                            $("#spanMsg").html("<font color='red'>" + param.msg + "</font>" )
                        }else{
                            $("#spanMsg").html("<font color='red'>" + param.msg + "</font>" )
                        }
                    },
                    error:function (param) {
                        alert("响应失败!" + param);
                    }
                });
            }

        });
    })



</script>


<body>

    <form action="#" method="POST">
        用户名<input type="text" id="username" name="username" placeholder="请输入用户名">
        <span id="spanMsg" style="color: #ff0000"></span><br>
        密码<input type="text" id="password" name="password" placeholder="请输入密码">
    </form>

</body>
</html>
