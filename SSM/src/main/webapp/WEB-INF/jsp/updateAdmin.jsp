<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员添加</title>
  </head>
  <body>
  	<center>
	  	<div>
	  	${admin2}
	   		<h1>管理员修改</h1>
	   		<h3><font color="red">密码只能重新设置，不修改密码可以不填写</font></h3>
	   		<form action="UpdateAdminServlet" method="post">
	   			<table width="400">
	   				<tr>
	   					<td>登录名：</td>
	   					<td>
	   						<input name="name" value="${admin2.name}" readonly="readonly"/>
	   					</td>
	   				</tr>
	   				<tr>
	   					<td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
	   					<td>
	   						<input name="pwd"/>
	   					</td>
	   				</tr>
	   				<tr>
	   					<td>状&nbsp;&nbsp;&nbsp;&nbsp;态：</td>
	   					<td>
	   						<select name="state">
							<option value="1"  selected=${admin.state==1?"selected":""}>超级</option>
							<option value="0" selected=${admin.state==0?"selected":""}>普通</option>
						</select>
	   					</td>
	   				</tr>
	   				<tr align="center">
	   					<td colspan="2">
	   						<input type="submit" value="修  改"/>
	   					</td>
	   				</tr>
	   			</table>
	   		</form>
	   		<h2><a href="GetAllProductsServlet">返回主页</a></h2>
	   	</div>
   	</center>
  </body>
</html>
