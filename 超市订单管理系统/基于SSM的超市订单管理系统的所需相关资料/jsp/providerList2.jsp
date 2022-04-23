<%@page import="com.smbms.entity.Provider"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>超市订单管理系统--供应商列表</title>
</head>
<body>
	<div style="width: 1680px;height: 1000px;margin: auto;">
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
		<div align="center" style="width: 100%;height: 840px;background-color: pink;overflow: scroll;">
			<table border="1" style="width: 90%;text-align: center;height: 800px;border-collapse: collapse;">
				<tr>
					<td>主键Id</td>
					<td>供应商编码</td>
					<td>供应商名称</td>
					<td>供应商详细描述</td>
					<td>供应商联系人</td>
					<td>联系电话</td>
					<td>地址</td>
					<td>传真</td>
				</tr>
				<%  List<Provider> list=(List<Provider>)request.getAttribute("providers"); %>
				<% for(int i=0;i<list.size();i++){ %>
					<tr>
					<td ><%=list.get(i).getId() %></td>
					<td><%=list.get(i).getProCode() %></td>
					<td><%=list.get(i).getProName() %></td>
					<td ><p style="text-overflow: ellipsis;
					overflow: hidden;white-space: nowrap;
					width: 260px;"><%=list.get(i).getProDesc() %></p>
					</td>
					<td><%=list.get(i).getProContact() %></td>
					<td><%=list.get(i).getProPhone() %></td>
					<td><%=list.get(i).getProAddress()%></td>
					<td><%=list.get(i).getProFax() %></td>
				</tr>
				<%} %>
			</table>
		
		</div>
	</div>
</body>
</html>