<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>入库</title>
    <script type="text/javascript">
    	//计算总价
    	function countPrice()
    	{
        	var dprice = document.getElementById("dprice").value;
        	var pcount = document.getElementById("pcount").value;
        	var totalprice = dprice*pcount;
        	document.getElementById("price").value = totalprice;
        }
        //
        function checkForm()
        {
        	var pcount = document.getElementById("pcount").value;
        	var dprice = document.getElementById("dprice").value;
        	var annt = document.getElementById("annt").value;
        	var sname = document.getElementById("sname").value;
        	//alert(sname);
        	if(pcount == "")
        	{
            	alert("请输入数量!");
            	return false;
            }
        	if(dprice == "")
        	{
            	alert("请输入单价!");
            	return false;
            }
        	if(annt == "")
        	{
            	alert("请输入经办人!");
            	return false;
            }
        	if(sname == "0")
        	{
            	alert("请选择供应商!");
            	return false;
            }
            return true;
        }
    </script>
  </head>
  <body>
   		<center>
   			<h1>入库</h1>
   			<h3><a href="GetAllProductsServlet">返回主页</a></h3>
   			<form action="AddInputServlet" method="post" onsubmit="return checkForm()">
   				<table width="" cellspacing="0" border="1">
   					<tr>
   						<td>产品名称:</td>
   						<td>
   							<input name="name" value="${p.name}" readonly="readonly"/>
   						</td>
   					</tr>
   					<tr>
   						<td>数量:</td>
   						<td>
   							<input name="pcount" id="pcount"/>
   						</td>
   					</tr>
   					<tr>
   						<td>单价:</td>
   						<td>
   							<input name="dprice" id="dprice" onblur="countPrice()"/>
   							<font color="red">精确到小数点两位</font>
   						</td>
   					</tr>
   					<tr>
   						<td>总价格:</td>
   						<td>
   							<input name="price" id="price" readonly="readonly" value="0"/>
   						</td>
   					</tr>
   					<tr>
   						<td>经办人:</td>
   						<td>
   							<input name="annt"/>
   						</td>
   					</tr>
   					<tr>
   						<td>选择供应商:</td>
   						<td>
   							<select name="pname" id="pname">
   							<option value="0" selected>--请选择--</option>
   							<c:forEach items="${proList}" var="plist">
   								<option value="${plist.pname}">${plist.pname}</option>
   							</c:forEach>		
   							</select>
   							<a href="addProvider">添加供应商</a>
   						</td>
   					</tr>
   				</table>
   				<input type="hidden" name="pid" value="${p.id}"/>
   				<input type="hidden" name="count" value="${p.count}"/>
   				<input type="submit" value="提  交"/>
   				
   			</form>
   		</center>
  </body>
</html>
