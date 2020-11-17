<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>电影详情</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="index.css">

</head>


<body class="layui-layout-body">

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


<div class="layui-fluid" style="margin-top: 20px;" id="mian">

    <div class="layui-row" layui-col-space10>
        <div class="layui-col-md3">
            <img style="width: 250px ; height:350px; float: right; margin-right: 20px"
                 src="../images/${film.actionStill}">
        </div>
        <div class="layui-col-md6">
            <h1>${film.filmName}</h1>
            <div style="width: 800px;height: 300px;margin-top: 20px">
                <h3>${film.synopsis}</h3>
            </div>
            <hr>


            <div style="margin-top: 30px">
                评论列表
                <table class="layui-table">
                    <colgroup>
                        <col width="30">
                        <col width="600">
                        <col>
                    </colgroup>
                    <thead>
                    <tr>
                        <th>用户</th>
                        <th>评论内容</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#if  pageC.dataList??>
                    <#list pageC.dataList as c>
                        <tr>
                            <td>${c.user.userName}(${c.user.phone})</td>
                            <td>${c.details}</td>
                        </tr>
                    </#list>
                    </#if>
                    </tbody>
                </table>
                <#--分页组件通过js加载完成-->
                <div id="pagination" align="center" style="padding:20px 0px 20px 0px"></div>
            </div>

            <#if  user??>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">添加评论</label>
                    <div class="layui-input-block">
                        <textarea name="details" id="details" placeholder="请输入内容" class="layui-textarea"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" onclick="savaComment()">立即提交</button>
                    </div>
                </div>
            <#--用户没有登录不能评论-->
            <#else >
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">添加评论</label>
                    <div class="layui-input-block">
                        <input type="text" style="width:850px;height:100px; text-align: center" readonly="readonly"
                               value="登录后评论"/>
                    </div>
                </div>
            </#if>

        </div>


        <div class="layui-col-md3">
            <div>
                <h2>主要演员：</h2>
                <h3>${film.actorName}</h3>
                </br>
                <h2>影片类型：</h2>
                <#list film.filmTypes as type>
                    <h3>${type.typeName}</h3>
                </#list>
                </br>
                <h2>发行公司：</h2>
                <h3>${film.filmDistributionCorporation}</h3>
                </br>
                <h2>上映时间</h2>
                <h3>${film.releaseDate?string("yyyy-MM-dd")}</h3>
            </div>
        </div>
    </div>


</div>


</body>

<script src="/layui/js/jquery.min.js" charset="utf-8"></script>
<script src="/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use(['element', 'form', 'laypage', 'layer', 'laydate'], function () {
        var element = layui.element,
            laypage = layui.laypage,
            form = layui.form,
            layer = layui.layer;

        //加载分页组件
        laypage.render({
            elem: 'pagination', //加载位置
            count: ${pageC.rowCount},  //总记录数
            limit: 2,  //页面大小
            curr: ${pageC.pageNum},     //当前页
            jump: function (obj, first) {
                //非第一次加载时执行
                if (!first) {
                    var url = "?fid=${film.fid}&pageNum=" + obj.curr;
                    location.href = url;
                }
            }
        });

    });

    //添加评论
    function savaComment() {
        var userId=${user.id};
        var flimFid=${film.fid};
        var details=$("#details").val();
         if (details.length==0){
             alert("请输入您的评论");
             return false;
         }else {
             $.ajax({
                 url:"/savaComment",
                 type:"post",
                 data:{
                     "details":details,
                     "flimFid":flimFid,
                     "userId":userId,
                 },
                 dataType:"text",
                 success:function (data) {
                     if (data=="ok"){
                        alert("添加成功");
                        window.location.href="/tomovieInfo?fid="+${film.fid};
                     }else if ("no") {
                         alert("添加失败");
                     }
                 }
             });
         }
    }
</script>


</html>