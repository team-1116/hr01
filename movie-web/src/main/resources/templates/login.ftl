<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登录</title>

    <link rel="stylesheet" href="/layui/css/layui.css" media="all">

    <script src="/layui/js/jquery.min.js" charset="utf-8"></script>
    <script src="/layui/layui.js"></script>

</head>


<body class="layui-layout-body">
<div id="main">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <div class="layui-logo">万达影城</div>
            <!-- 头部区域（可配合layui已有的水平导航） -->

            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">
                    <a href="">登录</a>
                </li>
                <li class="layui-nav-item">
                    <a href="goRegister">注册</a>
                </li>
            </ul>
        </div>
    </div>


    <div class="layui-fluid" style="margin-top: 20px;">

        <div class="layui-row" layui-col-space10>
            <div class="layui-col-md3">
                <div style="height: 30px; width: 450px;"></div>
            </div>
            <div class="layui-col-md6">

                <div style="text-align: center;margin-left: 250px">
                    <div class="layui-form-item">
                        <label class="layui-form-label">账号</label>
                        <div class="layui-input-inline">
                            <input type="text" name="userName" id="userName" required lay-verify="required"
                                   placeholder="请输入账户" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">密码</label>
                        <div class="layui-input-inline">
                            <input type="password" name="password"  id="password" required lay-verify="required"
                                   placeholder="请输入密码" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>

                <div style="margin-top: 50px;">
                    <button type="button" class="layui-btn layui-btn-danger" style="display:block;margin:5px auto"
                            onclick="touser()">登录
                    </button>
                </div>
            </div>
            <div class="layui-col-md3">

            </div>


        </div>
    </div>

</div>

</body>

<script>

    function touser() {
        var userName=$("#userName").val();
        var password=$("#password").val();
        if (userName.length==0){
            alert("登录名不能为空");
            return false;
        }else if (password.length==0){
            alert("密码不能为空");
            return false;
        } else {
            $.ajax({
                url:"/toUser",
                type:"post",
                data:{
                    "userName":userName,
                    "password":password,
                },
                dataType:"text",
                success:function (data) {
                    if (data=="ok"){
                        window.location.href="/tolist";
                        // window.location.href="/login1";
                    }else if ("no") {
                        alert("账号错误")
                    }else {
                        alert("密码错误")
                    }
                }
            })
        }
    }
</script>


</html>