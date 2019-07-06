<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加</title>
     <script type="text/javascript">
     	function checkForm()
     	{
         	var name = document.getElementById("name").value;
  			var bid = document.getElementById("bid").value;
  			if(bid == "0")
         	{
             	alert("请选择所属大类");
             	return false;
            }
         	if("" == name)
         	{
             	alert("请输入小类名称");
             	return false;
            }
            
            return true;
        }
     </script>
  </head>
  <body>
  		<center>
  			<h1>添加小类</h1>
  			<h3><a href="GetAllProductsServlet">返回主页</a></h3>
  			<form action="AddSmallTypeServlet" method="post" onsubmit="return checkForm()">
  				<table width="300" border="1" cellspacing="0">
  					<tr>
  						<td>选择大类：</td>
  						<td>
  							<select name="bid" id="bid">
				  				<option value="0">--请选择--</option>
				  				<c:forEach items="${bigList}" var="bt">
				  					<option value="${bt.id}">${bt.name}</option>
			  					</c:forEach>
  					
  							</select>
  						</td>
  					</tr>
  					<tr>
  						<td>小类名称：</td>
  						<td>
  							<input id="name" name="name" />
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
