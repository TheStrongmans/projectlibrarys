<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>超市订单管理系统--添加供应商</title>
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
			<form action="toAddProvider.do" method="post">
				<div style="padding: 5px 0px">
				<label for="proCode">供应商编码:</label>&nbsp;
				<input id="proCode" name="proCode" type="text" placeholder="请输入供应商编码" />
				</div>
				<div style="padding: 5px 0px">
				<label for="proName">供应商名称:</label>&nbsp;
				<input id="proName" name="proName" type="text" placeholder="请输入供应商名称" />
				</div>
				<div style="padding: 5px 0px">
				<label >供应商详细描述:</label><br/>
				<textarea rows="5" cols="40" name="proDesc" placeholder="请输入主营产品内容"></textarea>
				</div>
				<div style="padding: 5px 0px">
				<label >供应商联系人:</label>&nbsp;
				<input type="text" name="proContact" placeholder="请输入联系人姓名">
				</div>
				<div style="padding: 5px 0px">
				<label >联系电话:</label>&nbsp;
				<input type="number" name="proPhone" placeholder="请输入手机号" >
				</div>
				<div style="padding: 5px 0px">
				<label >地址:</label>&nbsp;
				<input type="text" name="proAddress" placeholder="请输入地址" >
				</div>
				<div style="padding: 5px 0px">
				<label >传真:</label>&nbsp;
				<input type="text" name="proFax" placeholder="请输入传真号码" >
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