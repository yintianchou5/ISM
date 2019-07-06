<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录</title>
    <script type="text/javascript">
    	function checkForm()
    	{	
        	var userName = document.getElementById("userName").value;
        	var pwd = document.getElementById("pwd").value;
        	if(userName == "")
        	{
        		alert("请输入用户名!");
        		return false;
            }
        	if(pwd == "")
        	{
        		alert("请输入密码!");
        		return false;
            }
            return true;
        }
    </script>
  </head>
  <body bgcolor="#00ccff">
  		<center>
  		<div style="margin-top:150px; font-size: 40px;">
  			进销存管理系统
  		</div>
   		<div>
   			<h2><font color="red">${loginError }</font></h2>
   			<form action="LoginServlet" method="post" onsubmit="return checkForm()">
   				<table >
   					<tr>
   						<td>用户名：</td>
   						<td><input id="userName"  value="${loginName }" name="name" size="20"/></td>
   					</tr>
   					<tr>
   						<td>密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
   						<td><input id="pwd" type="password" name="pwd" size="22"/></td>
   					</tr>
   					<tr>
   						<td colspan="2" align="center">
   						<input type="submit" value="登录"/>
   						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   						<input type="reset" value="重置"/>
   						</td>
   					</tr>
   					<font color="red" size="20" face="宋体">${errMsg}</font>
   				</table>
			</form>
   		</div>
   		</center>
  </body>
</html>
