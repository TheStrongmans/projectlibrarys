<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>超市订单管理系统--修改用户</title>
</head>
<body>
	<% Map<String,Object> map=(Map<String,Object>)request.getAttribute("user"); %>
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
			<form action="UpdateUser.do" method="post">
				<!-- 定义一个隐藏的文本框，用于临时存储要修改的这个用户的id -->
				<input type="hidden" name="id" value="<%=map.get("id") %>">
				<div style="padding: 5px 0px">
				<label for="userCode">用户名:</label>&nbsp;
				<input id="userCode" name="userCode" type="text" value="<%=map.get("userCode") %>" placeholder="请输入用户名" />
				</div>
				<div style="padding: 5px 0px">
				<label for="userName">姓名:</label>&nbsp;
				<input id="userName" name="userName" type="text" value="<%=map.get("userName") %>" placeholder="请输入用户名" />
				</div>
				<div style="padding: 5px 0px">
				<label >性别:</label>&nbsp;
				<% int gender=(int)map.get("gender"); %>
				<% if(gender==2){ %>
				<input type="radio" name="gender" checked="checked" value="2">男&nbsp;
				<input type="radio" name="gender" value="1">女&nbsp;
				<%}else if(gender==1){ %>
				<input type="radio" name="gender"  value="2">男&nbsp;
				<input type="radio" checked="checked" name="gender" value="1">女&nbsp;
				<%} %>
				</div>
				<div style="padding: 5px 0px">
				<label >出生年月:</label>&nbsp;
				<input type="date" value="<%=map.get("birthday") %>" name="birthday" >
				</div>
				<div style="padding: 5px 0px">
				<label >手机号:</label>&nbsp;
				<input type="number" name="phone" value="<%=map.get("phone") %>" placeholder="请输入手机号" >
				</div>
				<div style="padding: 5px 0px">
				<label >家庭地址:</label>&nbsp;
				<input type="text" name="address" value="<%=map.get("address") %>" placeholder="请输入家庭地址" >
				</div>
				<div style="padding: 5px 0px">
				<label >身份:</label>&nbsp;
				<% int sf=(int)map.get("userRole"); %>
				<% if(sf==3){ %>
				<input type="radio" name="userRole" checked="checked" value="3">普通员工&nbsp;
				<input type="radio" name="userRole"  value="2">经理&nbsp;
				<%}else if(sf==2){ %>
				<input type="radio" name="userRole"  value="3">普通员工&nbsp;
				<input type="radio" name="userRole" checked="checked" value="2">经理&nbsp;
				<%} %>
				</div>
				<div style="padding: 5px 0px">
					<input type="submit"
					  value="修改" 
					 style="width: 120px;background-color: green;
					 border: none;padding: 5px;border-radius: 5px;
					 color: white;"/>
				</div>
			</form>
			
		
		</div>
	</div>
</body>
</html>