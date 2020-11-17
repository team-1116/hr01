<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>订单页</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="index.css">
</head>

<body class="layui-layout-body">
<div id="main">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <!-- 头部区域最左侧-->
            <div class="layui-logo">万达影城</div>
            <ul class="layui-nav layui-layout-left">
                <li class="layui-nav-item"><a href="/tolist">首页</a></li>
            </ul>
            <!-- 头部区域最右侧 -->
            <ul class="layui-nav layui-layout-right">
                <#if user??>
                    <li class="layui-nav-item">
                        <a>${user.userName}</a>
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

                <table class="layui-table">
                    <colgroup>
                        <col width="150">
                        <col width="200">
                        <col width="200">
                        <col width="200">
                        <col width="200">
                        <col width="200">
                    </colgroup>
                    <thead>
                    <tr>
                        <th>片名</th>
                        <th>影院</th>
                        <th>放映厅</th>
                        <th>座位号</th>
                        <th>放映时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <if orders??>
                    <#list orders as o>
                    <tbody>
                    <tr>
                        <td>${o.film.filmName}</td>
                        <td>${o.store.storeName}</td>
                        <td>${o.projectionId}号厅</td>
                        <td>${o.seatNum}</td>
                        <td><span>${o.film.releaseDate?string("yyyy-MM-dd HH:mm:ss")}</span></td>

                        <td>
                            <button>退票</button>
                        </td>
                    </tr>

                    </tbody>
                    </#list>
                    </if>
                </table>
            </div>
            <div class="layui-col-md3">

            </div>


        </div>


    </div>
</div>
</body>

<script>

</script>


</html>