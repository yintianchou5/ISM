<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加供应商</title>
     <script type="text/javascript">
     	function checkForm()
     	{
         	var pname = document.getElementById("pname").value;
         	if("" == pname)
         	{
             	alert("请输供应商名称");
             	return false;
            }
            return true;
        }
     </script>
  </head>
  <body>
   		<center>
   			<h1>添加供应商</h1>
   			<h3><a href="GetAllProductsServlet">返回主页</a></h3>
   			<form action="AddProviderServlet" method="post" onsubmit="return checkForm()">
   				<table width="400" border="1" cellspacing="0">
   					<tr>
  						<td>供应商名称：</td>
  						<td>
  							<input id="pname" name="pname" size="30" />
  						</td>
  					</tr>
  					<tr>
  						<td>供应商简介：</td>
  						<td>
  							<textarea name="intro" rows="10" cols="30" ></textarea>
  						</td>
  					</tr>
  					<tr align="center">
  						<td colspan="2">
  							<input type="submit" value="提  交"/>
  						</td>				
  					</tr>
   				</table>
   			</form>
   		</center>	
  </body>
</html>
