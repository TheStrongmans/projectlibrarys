<%@page import="java.util.Map"%>
<%@page import="com.smbms.entity.Provider"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>超市订单管理系统--订单列表</title>
<style type="text/css">
	tr {
	height: 40px;
}
</style>
</head>
<body>
	<div style="width: 1800px;height: 1000px;margin: auto;">
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
		<% List<Map<String,Object>> list=(List<Map<String,Object>>)request.getAttribute("bills"); %>
		<div align="center" style="width: 100%;height: 840px;background-color: pink;overflow: scroll;">
			<div align="left" style="height: 40px;" >
				<a href="toAddBill.do" style="text-decoration: none;
				 text-align:center;  width: 50px;
				 height: 20px;
				 color: white;font-weight: bold;
				 margin-top:20px;margin-left:10px;
				 border-radius: 5px;">添加订单</a>
			</div>
			<!-- 当前普通员工是否有谈下过订单信息，如果没有，显示暂无信息，如果有，展示该员工的所有订单 -->
			<% if(list==null||list.size()==0){ %>
				<div style="width: 98%;text-align: center;height: 800px;">
					当前暂无订单信息
				</div>
			<%}else { %>
			<table border="1" style="width: 98%;text-align: center;border-collapse: collapse;">
				<tr>
					<td>主键Id</td>
					<td>账单编码</td>
					<td>商品名称</td>
					<td>商品描述</td>
					<td>商品数量</td>
					<td>商品单位</td>
					<td>商品总额</td>
					<td>是否支付</td>
					<td>供应商名称</td>
					<td>创建时间</td>
				</tr>
				<% for(int i=0;i<list.size();i++){ %>
					<tr>
					<td ><%=list.get(i).get("id") %></td>
					<td><%=list.get(i).get("billCode") %></td>
					<td><%=list.get(i).get("productName") %></td>
					<td><%=list.get(i).get("productDesc") %></td>
					<td><%=list.get(i).get("productCount") %></td>
					<td><%=list.get(i).get("productUnit") %></td>
					<td><%=list.get(i).get("totalPrice")%>元</td>
					<% int type=(int)list.get(i).get("isPayment"); %>
					<% if(type==1){ %>
					<td ><a href="UpdatePayBill.do?id=<%=list.get(i).get("id") %>"><input type="button" value="未支付" style="color: white;border: none;background-color: red;border-radius: 5px;font-weight: bold;"></a></td>
					<%}else if(type==2){ %>
					<td style="color:green;">已支付</td>
					<%} %>
					<td><%=list.get(i).get("proName")%></td>
					<td><%=list.get(i).get("creationDate")%></td>
				</tr>
				<%} %>
			</table>
			<%} %>
		</div>
	</div>
</body>
</html>