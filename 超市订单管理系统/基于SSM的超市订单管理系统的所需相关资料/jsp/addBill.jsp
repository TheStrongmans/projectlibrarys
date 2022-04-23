<%@page import="com.smbms.entity.Provider"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>超市订单管理系统--添加订单</title>
</head>
<body>
<% List<Provider> oList=(List<Provider>)request.getAttribute("providers"); %>
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
			<form action="AddBill.do" method="post">
				<div style="padding: 5px 0px">
				<label for="productName">商品名称:</label>&nbsp;
				<input id="productName" name="productName" type="text" placeholder="请输入商品名称" />
				</div>
				<div style="padding: 5px 0px">
				<label >商品描述:</label>
				<input type="text" name="productDesc" placeholder="请输入商品描述信息"></input>
				</div>
				<div style="padding: 5px 0px">
				<label >商品单位:</label>&nbsp;
				<input type="text" name="productUnit" placeholder="请输入商品单位">
				</div>
				<div style="padding: 5px 0px">
				<label >商品数量:</label>&nbsp;
				<input type="number" name="productCount" placeholder="请输入商品数量" >
				</div>
				<div style="padding: 5px 0px">
				<label >商品总额:</label>&nbsp;
				<input type="number" name="totalPrice" placeholder="请输入商品总额" >
				</div>
				<div style="padding: 5px 0px">
				<label >供应商名称:</label>&nbsp;
				<!-- Html5 新增的表单的新用法 -->
				<input type="search" name="proname" placeholder="请输入供应商名称"  list="list">
				<datalist id="list">
					<% 
						for(int i=0;i<oList.size();i++){
					%>
					<option><%=oList.get(i).getProName() %></option>
					<%}%>
				</datalist>
				<%-- <select name="proName">
					<% 
						for(int i=0;i<oList.size();i++){
					%>
					<option><%=oList.get(i).getProName() %></option>
					<%} %>
				</select> --%>
				</div>
				<div style="padding: 5px 0px">
					<input type="submit"
					  value="添加" 
					 style="width: 120px;background-color: green;
					 border: none;padding: 5px;border-radius: 5px;
					 color: white;"/>
				</div>
			</form>
			
		
		</div>
	</div>
</body>
</html>