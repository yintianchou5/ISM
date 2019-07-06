<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加</title>
     <script type="text/javascript">
     	function checkForm()
     	{
         	var name = document.getElementById("name").value;
         	if("" == name)
         	{
             	alert("请输入大类名称");
             	return false;
            }
            return true;
        }
     </script>
  </head>
  <body>
  		<center>
  			<h1>添加大类</h1>
  			<h3><a href="GetAllProductsServlet">返回主页</a></h3>
  			<form action="AddBigTypeServlet" method="post" onsubmit="return checkForm()">
  				大类名称：<input id="name" name="name" />
  				<input type="submit" value="提交"/>
  			</form>
  		</center>
  </body>
</html>
