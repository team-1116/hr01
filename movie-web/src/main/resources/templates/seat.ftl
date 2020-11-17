<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>选座位</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
    <link rel="stylesheet" href="index.css">

</head>



<body class="layui-layout-body">
<div  id="main">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">万达影城</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->

        <ul class="layui-nav layui-layout-right">
            <#if user??>
                <li class="layui-nav-item">
                    <a >${user.userName}</a>
                </li>
            <#else >
                <li class="layui-nav-item">
                    <a href="/goLogin">登录</a>
                </li>
                <li class="layui-nav-item">
                    <a href="/goRegister">注册</a>
                </li>
            </#if>
        </ul>
    </div>
</div>



<div class="layui-fluid" style="margin-top: 20px;">

    <div class="layui-row" layui-col-space10>
        <div class="layui-col-md3">
            <div style="height: 30px; width: 450px;"></div>
        </div>
        <div class="layui-col-md6">

            <div style="margin:30px auto;height: 30px; width: 500px;line-height: 30px; text-align: center; border: black 1px solid;">大荧幕</div>
            <form id="ceshi" method="post">
            <div style="margin-top: 150px; text-align: center">
                <#list 1..50 as index>
                    <input style="width: 25px; height: 25px ; margin-right: 15px;" type="checkbox" v-model="seat" name=${index} value=${index} ">
                    <#if index%10==0>

                    </#if>
                </#list>
            </div>
                <div style="margin-top: 50px;">
                    <button type="button"  onclick="check()" class="layui-btn layui-btn-danger" style="display:block;margin:5px auto">购票</button>
                </div>
             </form>
        </div>
        <div class="layui-col-md3">

        </div>


    </div>



</div>
</div>
</body>

<script>
    function check(){
        alert("jin");
           var one = document.getElementById("index").value;
                alert(one);

         }
</script>


</html>