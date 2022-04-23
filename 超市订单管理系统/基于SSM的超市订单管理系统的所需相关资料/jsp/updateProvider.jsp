<%@page import="com.smbms.entity.Provider"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>超市订单管理系统--修改供应商</title>
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
		<% Provider provider=(Provider)request.getAttribute("pro"); %>
		<div align="center" style="width: 100%;height: 640px;background-color: pink;">
			<form action="UpdateProvider.do" method="post">
				<!-- 完成修改功能的时候，需要将主键id隐藏存储在表单页面上
					因为在完成修改的sql语句的同时，是需要条件，只有主键id是不允许被修改的，
					那么能作为条件去修改数据库表中的数据只有主键id
				 -->
				<input type="hidden" name="id" value="<%=provider.getId() %>">
				<div style="padding: 5px 0px">
				<label for="proCode">供应商编码:</label>&nbsp;
				<input id="proCode" name="proCode" value="<%=provider.getProCode() %>" type="text" placeholder="请输入供应商编码" />
				</div>
				<div style="padding: 5px 0px">
				<label for="proName">供应商名称:</label>&nbsp;
				<input id="proName" name="proName" value="<%=provider.getProName() %>" type="text" placeholder="请输入供应商名称" />
				</div>
				<div style="padding: 5px 0px">
				<label >供应商详细描述:</label><br/>
				<textarea rows="5" cols="40" name="proDesc"  placeholder="请输入主营产品内容"><%=provider.getProDesc() %></textarea>
				</div>
				<div style="padding: 5px 0px">
				<label >供应商联系人:</label>&nbsp;
				<input type="text" name="proContact" value="<%=provider.getProContact() %>" placeholder="请输入联系人姓名">
				</div>
				<div style="padding: 5px 0px">
				<label >联系电话:</label>&nbsp;
				<input type="number" name="proPhone" value="<%=provider.getProPhone() %>" placeholder="请输入手机号" >
				</div>
				<div style="padding: 5px 0px">
				<label >地址:</label>&nbsp;
				<input type="text" name="proAddress" value="<%=provider.getProAddress() %>" placeholder="请输入地址" >
				</div>
				<div style="padding: 5px 0px">
				<label >传真:</label>&nbsp;
				<input type="text" name="proFax" value="<%=provider.getProFax() %>" placeholder="请输入传真号码" >
				</div>
				<div style="padding: 5px 0px">
					<input type="submit"
					  value="修改供应商信息" 
					 style="background-color: green;
					 border: none;padding: 5px;border-radius: 5px;
					 color: white;"/>
				</div>
			</form>
			
		
		</div>
	</div>
</body>
</html>