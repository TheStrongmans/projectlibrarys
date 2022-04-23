<%@page import="com.github.pagehelper.PageInfo"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>超市订单管理系统--用户信息列表</title>
<style type="text/css">
	tr {
	height: 40px;
}
</style>
</head>
<body>
	<!-- 获得分页信息对象 -->
	<% PageInfo pi=(PageInfo)request.getAttribute("pj_info"); %>
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
			<div align="left" style="height: 40px;" >
				<a href="addUser.do" style="text-decoration: none;
				 text-align:center;  width: 50px;
				 height: 20px;
				 color: white;font-weight: bold;
				 margin-top:20px;margin-left:10px;
				 border-radius: 5px;">添加用户</a>
			</div>
			<table border="1" style="width: 90%;text-align: center;border-collapse: collapse;">
				<tr>
					<td>主键Id</td>
					<td>用户编码</td>
					<td>用户名称</td>
					<td>性别</td>
					<td>出生日期</td>
					<td>手机</td>
					<td>地址</td>
					<td>身份</td>
					<td>操作</td>
				</tr>
				<% List<Map<String,Object>> oList=pi.getList(); %>
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
					<td><%
						if((int)oList.get(i).get("userRole")==2){
					%>
					经理
					<%
						}else if((int)oList.get(i).get("userRole")==3){
					%>
					普通员工
					<%} %>
					</td>
					<td><a href="GetUserInfo.do?index=<%=i %>">
					<input type="button" value="修改" style="background-color: green;border: none;
					border-radius: 5px;color: white;" /></a>&nbsp;
					<a href="deleteUser.do?id=<%=oList.get(i).get("id") %>">
					<input type="button" value="删除" style="background-color: red;border: none;
					border-radius: 5px;color: white;"/></a></td>
					</tr>
				<%} %>
			</table>
			<!-- 分页页码导航栏 -->
			<br>
			<div align="center">
				<!-- 判断当前页是否存在上一页，不存在则不显示上一页的按钮 -->
				<%if(pi.getPrePage()>0){ %>
				<a href="yhgl.do?type=1&ym=<%=pi.getPrePage()%>"><input type="button" value="上一页"/></a>&nbsp;
				<%} %>
				<% for(int i:pi.getNavigatepageNums()){ %>
					<a href="yhgl.do?type=1&ym=<%=i%>"><%=i %></a>&nbsp;
				<%} %>
				<!-- 判断当前页是否存在下一页，不存在则不显示下一页的按钮 -->
				<% if(pi.getPageNum()<pi.getLastPage()){ %>
				<a href="yhgl.do?type=1&ym=<%=pi.getNextPage()%>"><input type="button" value="下一页"/></a>&nbsp;
				<%} %>
			</div>
		</div>
	</div>
</body>
</html>