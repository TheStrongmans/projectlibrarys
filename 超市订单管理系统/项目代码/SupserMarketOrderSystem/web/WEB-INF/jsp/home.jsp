<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>超市订单管理系统--主页</title>
<style type="text/css">
	*{
		margin: 0px;
		padding: 0px;
	}
</style>

<script type="text/javascript">
	function yhgl() {
		//当用户点击用户管理功能的时候，需要判断当前登录的用户的身份，如果是管理员或者经理允许进入，普通员工不允许进入
		//先获得当前登录的用户的身份
		var input=document.getElementById("hidd");
		var i=input.value;
		switch (i) {
		case "1":
			//管理员身份
			//跳转一个可以操作用户的添加，修改，查询，删除等功能
			location.href="yhgl.do?type=1";
			break;
		case "2":
			//经理身份
			//跳转一个只能查看普通员工的个人信息的页面
			location.href="yhgl.do?type=2";
			break;
		case "3":
			//普通员工身份
			alert("您当前没有权限使用该功能");
			break;
		}
	}
	
	function gysgl() {
		//先获得当前登录的用户的身份
		var input=document.getElementById("hidd");
		var i=input.value;
		switch (i) {
		case "2":
			//能和供应商直接对接的只能是经理身份
			//跳转至servlet--》调度业务逻辑层--》调度数据访问层--》数据库
			location.href="GetProviderList.do";
			break;
		case "3":
			//普通员工可以查看所有供应商信息，但不能添加，修改，删除供应商信息
			location.href="GetProviderList.do";
			break;
		default:
			//如果不是经理，那么都不允许操作该功能
			alert("当前登录的员工不具备该功能的操作权限");
			break;
		}
	}
	
	function ddgl() {
		var input=document.getElementById("hidd");
		var i=input.value;
		switch (i) {
		case "2":
			//经理，只能查看所有订单，修改订单，删除订单，不能添加订单
			location.href="GetBills.do";
			break;
		case "3":
			//普通员工，添加订单和查询自己的订单
			location.href="GetBillsByUserId.do";
			break;
		default:
			//管理员身份不允许操作该功能
			alert("当前登录的员工不具备该功能的操作权限");
			break;
		}
	}
</script>
</head>
<body>
	<div style="width: 1200px;height: 800px;margin: auto;">
		<div style="width: 100%;height: 160px;background-color:skyblue;">
			<div  style="width: 100%;height: 20px;">
			
				<div align="left" style="width: 20%;height: 100%;float: left;" >
					&nbsp;<a href="home.do" style="text-decoration: none;">返回首页</a>
				</div>
			
			<div align="right" style="width: 80%;height: 100%;float: right;">
				<a>欢迎,<span style="color: red;">${userInfo.userName}</span></a>
				&nbsp;&nbsp;<a href="index.do" style="text-decoration: none;">注销</a>&nbsp;
			</div>
			
			</div>
			
			<div align="center" style="width: 100%;height: 140px;line-height: 140px;"><h1>超市订单管理系统</h1></div>
		</div>
		<div align="center" style="width: 100%;height: 640px;background-color: pink;">
			<input type="hidden" id="hidd" value="${userInfo.userRole}">
			<input type="button"  value="用户管理"  onclick="yhgl()"  style="width: 400px;height: 160px;margin-bottom: 20px;margin-top: 20px;"><br/>
			<input type="button"  value="供应商管理" onclick="gysgl()" style="width: 400px;height: 160px;margin-bottom: 20px;"><br/>
			<input type="button"  value="订单管理" onclick="ddgl()" style="width: 400px;height: 160px;margin-bottom: 20px;"><br/>
		
		</div>
	</div>
</body>
</html>