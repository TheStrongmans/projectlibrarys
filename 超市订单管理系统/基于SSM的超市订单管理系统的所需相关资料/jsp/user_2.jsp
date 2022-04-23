<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>超市订单管理系统--用户信息列表</title>
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
			<table border="1" style="width: 80%;text-align: center;border-collapse: collapse;">
				<tr>
					<td>主键Id</td>
					<td>用户编码</td>
					<td>用户名称</td>
					<td>性别</td>
					<td>出生日期</td>
					<td>手机</td>
					<td>地址</td>
				</tr>
				<% List<Map<String,Object>> oList=(List<Map<String,Object>>)request.getAttribute("pt_users"); %>
				<%for(int i=0;i<oList.size();i++){ %>
					<tr>
					<td><%=oList.get(i).get("id") %></td>
					<td><%=oList.get(i).get("userCode") %></td>
					<td><%=oList.get(i).get("userName") %></td>
					<% int gender=(int)oList.get(i).get("gender");
					if(gender==1){%>
					<td>女</td>
					<%}else if(gender==2){ %>
					<td>男</td>
					<%} %>
					<td><%=oList.get(i).get("birthday") %></td>
					<td><%=oList.get(i).get("phone") %></td>
					<td><%=oList.get(i).get("address") %></td>
					</tr>
				<%} %>
			</table>
		
		</div>
	</div>
</body>
</html>