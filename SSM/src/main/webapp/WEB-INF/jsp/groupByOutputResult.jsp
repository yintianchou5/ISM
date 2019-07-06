<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>出库查询结果</title>
  </head>
  <body>
   		<center>
   		<h1>出库分组查询结果</h1>
   		<h3><a href="SearchOutputServlet">返回出库记录</a></h3>
   			<table width="600" cellspacing="0" border="1">
   				<tr bgcolor="#CCCCCC">
   					<td>产品名称</td>
   					<td>数量</td>
   					
   					
   				</tr>
   				<c:forEach items="${olist}" var="pl">
	   				<tr>
	   					<td>${pl[0]}</td>
	   					<td>${pl[1]}</td>
	   					
	   					
	   				</tr>
   				</c:forEach>
   				<tr align="right">
   					<td colspan="6">
   						<font color="blue" size="5">总数量：${countTotal}</font>
   					</td>
   				</tr>
   			</table>
   		</center>
  </body>
</html>
