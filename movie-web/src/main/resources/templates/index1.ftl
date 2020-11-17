<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>万达电影购票系统</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/index.css">
</head>


<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin" id="mian">
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
                <li class="layui-nav-item">
                    <a href="/goOrder">我的订单</a>
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

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <#list storeList as s>
                <#--判断是否是当前分类-->
                    <#if sid == s.id>
                        <li class="layui-nav-item layui-this" style="text-align:center"><a
                                    href="?sid=${s.id}">${s.storeName}</a></li>
                    <#else>
                        <li class="layui-nav-item" style="text-align:center"><a href="?sid=${s.id}">${s.storeName}</a>
                        </li>
                    </#if>
                </#list>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <form action="?sid=${sid}" method="get">
            <div style="margin: 30px 40px">
                <label class="">放映厅</label>
                <select id="pid" name="pid">
                    <option value="0">所有厅</option>
                    <option value="1">一号厅</option>
                    <option value="2">二号厅</option>
                    <option value="3">三号厅</option>
                    <option value="4">四号厅</option>
                </select>
                <div class="layui-inline">
                    <label class="layui-form-label">上映日期</label>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" id="releaseDate" placeholder="yyyy-MM-dd"
                               name="releaseDate">
                    </div>
                </div>
                <button type="submit" class="layui-btn">查询</button>
            </div>
        </form>
        <hr>

        <div align="center">
            <#list pageF.dataList as p>
            <#--第0,4,8...号元素前面输出行首标签-->
                <#if p_index % 4 == 0>
                    <div class="layui-row layui-col-space1" style="padding-top:20px">
                </#if>

                <div class="layui-col-md3">
                    <a href="/tomovieInfo?fid=${p.fid}"><img src="../images/${p.actionStill}"
                                                             style="width:200px;height:200px"></a>
                    <div style="padding:10px 20px 5px 35px" align="left">
                        <p>片名：<span>${p.filmName}</span></p>
                        <p>放映：<span>${p.projectionRoom.projectionId}号厅</span></p>
                        <p>时间：<span>${p.releaseDate?string("yyyy-MM-dd HH:mm:ss")}</span></p>
                        <p>票价：<span style="color:red">￥${p.filmPrice}</span></p>
                    </div>

                    <button type="button" onclick="gopurchase(${p.fid})" class="layui-btn layui-btn-radius layui-btn-sm layui-btn-primary">
                        <i class="layui-icon layui-icon-cart-simple"></i>购票
                    </button>
                </div>

            <#--第3,7,11...号元素后面输出行尾标签-->
                <#if (p_index + 1) % 4 == 0>
                    </div>
                </#if>
            </#list>
        </div>
        <#--分页组件通过js加载完成-->
        <div id="pagination" align="center" style="padding:20px 0px 20px 0px"></div>

    </div>


    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © 万达影城
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
        laydate = layui.laydate;

        //加载分页组件
        laypage.render({
            elem: 'pagination', //加载位置
            count: ${pageF.rowCount},  //总记录数
            limit: 8,  //页面大小
            curr: ${pageF.pageNum},     //当前页
            jump: function (obj, first) {
                //非第一次加载时执行
                if (!first) {
                    var url = "?sid=${sid}&pageNum=" + obj.curr;
                    <#if pid??>
                    url += "&pid=" + ${pid};
                    </#if>
                    <#if releaseDate??>
                    url += "&releaseDate=" +${date};
                    </#if>
                    location.href = url;
                }
            }
        });
        //定义时间格式
        laydate.render({
            <#if date?string("yyyy-MM-dd")!="1997-05-07">
            elem: '#releaseDate'
            , value: '${date?string("yyyy-MM-dd")}'
            , isInitValue: true
            </#if>
        });


        //下拉框回显
        $(function () {
            $('#pid').val(${pid});
        })
    });

    //购票
    function  gopurchase(id) {
        var fid=id;
        if(${user}==null){
            alert("请先登录");
            return false;
        }
    }
</script>

</html>