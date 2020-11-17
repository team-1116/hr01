<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>MyShop</title>
	<link rel="stylesheet" href="../layui/css/layui.css">
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
					<a href="">注册</a>
				</li>
			</ul>
		</div>
	</div>


	<div class="layui-fluid" style="margin-top: 20px;">

	<div class="layui-row" style="padding-top: 30px">
		<div class="layui-col-md6 layui-col-md-offset3" style="padding:20px; background-color:#F2F2F2;">
			<div class="layui-card">
				<div class="layui-card-body">
					<div id="login-layer">
						<form id="login-form" class="layui-form" style="padding:30px 20px 5px 20px">
							<div class="layui-form-item">
								<label class="layui-form-label">登录名</label>
								<div class="layui-input-block">
									<input type="text"  name="userName" class="layui-input" id="userName" style="width:80%">
								</div>
								<div id="msgname"  style="display:none;">
									<label class="layui-form-label" style="color:red">错　误</label>
									<div class="layui-form-mid layui-word-aux">此登录名以被注册，请重新填写登录名</div>
								</div>
							</div>

							<div class="layui-form-item">
								<label class="layui-form-label">姓　名</label>
								<div class="layui-input-block">
									<input type="text" id="name" name="name" class="layui-input" style="width:80%">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">密　码</label>
								<div class="layui-input-block">
									<input type="password"  id="password" name="password" class="layui-input" style="width:80%">
								</div>
								<div id="passwordmsg" style="display:none;">
									<label class="layui-form-label" style="color:red">错　误</label>
									<div class="layui-form-mid layui-word-aux">密码长度不能小于6位数</div>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">手　机</label>
								<div class="layui-input-block">
									<input type="phone" id="phone" name="phone" class="layui-input" style="width:80%">
								</div>
								<div id="phonemsg"  style="display:none;">
									<label class="layui-form-label" style="color:red">错　误</label>
									<div class="layui-form-mid layui-word-aux">手机号应为11位数</div>
								</div>
								<div id="phonemsgs"  style="display:none;">
									<label class="layui-form-label" style="color:red">错　误</label>
									<div class="layui-form-mid layui-word-aux">请你输入正确手机号</div>
								</div>
							</div>
							<div class="layui-form-item" align="center" style="padding-top: 10px;">
								<button type="button" class="layui-btn layui-btn-normal layui-btn-sm" onclick="adduser()">注　册</button>
								<button type="button" class="layui-btn layui-btn-primary layui-btn-sm">关　闭</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</div>
	
	<script src="../layui/js/jquery.min.js"></script>
	<script src="../layui/layui.js"></script>
	<script>
	//JavaScript代码区域
	layui.use(['element', 'form'], function(){
		var element = layui.element,
			form = layui.form;
	});

	//验证用户编码是否重复
	$(function () {
		$("#userName").blur(function () {
			var  userName=$(this).val();
			if (userName==null||userName==""){
				userName="null";
			}
			//ajax请求
			$.get("/getuserName","userName="+userName,function (result) {
				if (result=="no"){
					//用户编码重复
					$("#msgname").css('display','block');
					//获取焦点
					$("#userName").focus();
				}else {
					//用户编码不重复
					$("#msgname").css('display','none');
				}
			})
		});


		$("#password").blur(function () {
			var  password=$(this).val();
			//ajax请求
			$.get("/passwordlength","password="+password,function (result) {
				if (result=="no"){
					//密码小于6位数
					$("#passwordmsg").css('display','block');
					//获取焦点
					$("#password").focus();
				}else {
					//密码不小于6位数
					$("#passwordmsg").css('display','none');
				}
			})

		});


		$("#phone").blur(function () {
			var  phone=$(this).val();
			//ajax请求
			$.get("/phone","phone="+phone,function (result) {
				if (result=="length"){
					//手机号应为11位数
					$("#phonemsg").css('display','block');
					$("#phonemsgs").css('display','none');
					//获取焦点
					$("#phone").focus();
				}else if (result=="no"){
					//手机号格式不正确
					$("#phonemsgs").css('display','block');
					$("#phonemsg").css('display','none');
					//获取焦点
					$("#phone").focus();
				} else {
					//手机号正常
					$("#phonemsg").css('display','none');
					$("#phonemsgs").css('display','none');
				}
			})

		});
	})

		function adduser() {
			var userName=$("#userName").val();
			var name=$("#name").val();
			var password=$("#password").val();
			var phone=$("#phone").val();
			if (userName==null||userName==''){
				alert("登录名不能为空");
				return false;
			}else  if (name==null||name==''){
				alert("姓名不能为空");
				return false;
			}else  if (password==null||password==''){
				alert("密码不能为空");
				return false;
			}else  if (phone==null||phone==''){
				alert("手机号不能为空");
				return false;
			}
			 	else {
				$.ajax({
					url:"/savaUser",
					type:"post",
					data:{
						"userName":userName,
						"name":name,
						"password":password,
						"phone":phone,
					},
					dataType:"text",
					success:function (data) {
						if (data=="ok"){
							alert("注册成功");
							window.location.href="/goLogin";
						}else {
							alert("注册失败");
						}
					}

				})
			}
		}
	</script>
</body>
</html>