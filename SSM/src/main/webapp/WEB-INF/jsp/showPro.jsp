<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>商品修改</title>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jilian.js"></script>
   
    <script type="text/javascript">
   		var isSubmit = false;
    	function checkForm()
    	{
        	var bid = document.getElementById("bigtype").value;
        	var name = document.getElementById("name").value;
        	var units = document.getElementById("units").value;
        	if(bid == 0)
            {
                alert("请选择产品类别");
                return false; 
            }
        	if(name == "")
            {
                alert("请输入产品名称");
                return false; 
            }
        	if(units == "")
            {
                alert("请输入产品单位");
                return false; 
            }
            if(isSubmit == false)
            {
                alert("请仔细核对后信息再点入库，输入后无法更改！");
                isSubmit = true;
                return false;
            }
            return true;
        }
    </script>
  </head>
  <body>
   		<center>
   			<h1>商品修改</h1>
   			<h3><a href="GetAllProductsServlet">返回主页</a></h3>
   			<h4><font color="red">产品名称不能修改</font></h4>
   			<form action="UpdateProductsServlet" method="post" onsubmit="return checkForm()">
   				<table width="500" cellspacing="0" border="1">
   					<tr>
   						<td>选择大类:</td>
   						<td>
   							<select id="bigtype" name="bid" onchange="changeTypes(this.value)">
   								<c:forEach items="${bigList}" var="bt">
				  					<option value="${bt.id}" ${p.bid==bt.id?"selected":""} }>${bt.name}</option>
				  				</c:forEach>
   							</select>
   							<a href="addBigType.jsp">添加大类</a>
   						</td>
   					</tr>
   					<tr>
   						<td>选择小类:</td>
   						<td>
   							<select id="smalltype" name="sid">
   								<option value="${st.id}" selected>${st.name}</option>
   							</select>
   							<a href="GetAllBigTypeServlet">添加小类</a>
   						</td>
   					</tr>
   					<tr>
   						<td>产品名称:</td>
   						<td>
   							<input id="name" name="name" size="30" value="${p.name}" readonly/>
   						</td>
   					</tr>
   					<tr>
   						<td>单位:</td>
   						<td>
   							<input id="units" name="units" size="10" value="${p.units}"/>
   						</td>
   					</tr>
   					
   					<tr>
   						<td>预警值:</td>
   						<td>
   							<input name="wvalue" value="${p.wvalue}" size="4"/>
   						</td>
   					</tr>
   					
   					<tr align="center">
   						<td colspan="2">
   							<input type="submit" value="修  改">
   						</td>
   					</tr>
   				</table>
   				<input type="hidden" value="${p.count}" name="count"/>
   				<input type="hidden" value="${p.id}" name="id"/>
   				<input type="hidden" value="${p.state}" name="state"/>
   			</form>
   		</center>
  </body>
</html>
