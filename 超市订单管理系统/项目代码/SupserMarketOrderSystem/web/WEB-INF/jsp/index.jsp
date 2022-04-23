<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>超市订单管理系统--登录</title>
<script type="text/javascript">
	function btn(obj,i) {
		//i为1的时候，表示鼠标在按钮上
		//i为2的时候，表示鼠标点击了按钮
		//i为3的时候，表示鼠标移出了按钮
		switch (i) {
		case 1:
			obj.style="width: 120px;background-color: red;border: none;padding: 5px;border-radius: 5px;color: white;";
			break;
		case 2:
			obj.style="width: 120px;background-color: skyblue;border: none;padding: 5px;border-radius: 5px;color: white;";
			break;
		case 3:
			obj.style="width: 120px;background-color: green;border: none;padding: 5px;border-radius: 5px;color: white;";
			break;
		}
	}
</script>
</head>
<body>
	<div align="center" >
		<h3>登录页面</h3>
		<form action="login.do"  method="post">
			<table  style="margin: auto;text-align: center;">
				<tr>
					<td>用户名:</td>
					<td><input type="text" name="username" placeholder="请输入用户名" /></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input type="password" name="password" placeholder="请输入密码" /></td>
				</tr>
				<tr >
					<td colspan="2"><input type="submit"
					 onmouseover="btn(this,1)" onmouseout="btn(this,3)" onmousedown="btn(this,2)" value="登录" 
					 style="width: 120px;background-color: green;
					 border: none;padding: 5px;border-radius: 5px;
					 color: white;"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>