<%@page import="com.github.pagehelper.PageInfo"%>
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
	<% PageInfo pi=(PageInfo)request.getAttribute("bills"); %>
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
		<% List<Map<String,Object>> list=pi.getList(); %>
		<div align="center" style="width: 100%;height: 840px;background-color: pink;overflow: scroll;">
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
					<td>员工姓名</td>
					<td>供应商名称</td>
					<td>创建时间</td>
					<td>修改时间</td>
					<td>操作</td>
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
					<td style="color:red;">未支付</td>
					<%}else if(type==2){ %>
					<td style="color:green;">已支付</td>
					<%} %>
					<td><%=list.get(i).get("userName") %></td>
					<td><%=list.get(i).get("proName")%></td>
					<td><%=list.get(i).get("creationDate")%></td>
					<%
					String time="";
					if(list.get(i).get("modifyDate")==null){
						time="暂未修改";
					}else if("null".equals(list.get(i).get("modifyDate"))){
						time="暂未修改";
					}else{
						time=list.get(i).get("modifyDate").toString();
					}
					%>
					<td><%=time %></td>
					<td>
					<a href="GetBillByIndex.do?index=<%=i%>"><input type="button" value="修改" style="background-color: green;border: none;border-radius: 5px;color: white;"></a>
					<a href="DeleteBill.do?id=<%=list.get(i).get("id") %>"><input type="button" value="删除" style="background-color: red;border: none;border-radius: 5px;color: white;"></a>
					</td>
				</tr>
				<%} %>
			</table>
			<!-- 分页页码导航栏 -->
			<br>
			<div align="center">
				<!-- 判断当前页是否存在上一页，不存在则不显示上一页的按钮 -->
				<%if(pi.getPrePage()>0){ %>
				<a href="GetBills.do?ym=<%=pi.getPrePage()%>"><input type="button" value="上一页"/></a>&nbsp;
				<%} %>
				<% for(int i:pi.getNavigatepageNums()){ %>
					<a href="GetBills.do?ym=<%=i%>"><%=i %></a>&nbsp;
				<%} %>
				<!-- 判断当前页是否存在下一页，不存在则不显示下一页的按钮 -->
				<% if(pi.getPageNum()<pi.getLastPage()){ %>
				<a href="GetBills.do?ym=<%=pi.getNextPage()%>"><input type="button" value="下一页"/></a>&nbsp;
				<%} %>
			</div>
			<%} %>
			
		</div>
	</div>
</body>
</html>