<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示结果</title>
    <script type="text/javascript">
    	function change(state)
    	{
        	
        	if(state == 3)
        	{
            	window.location.href="searchInput.jsp";
            }
        	else if(state == 4)
        	{
            	window.location.href="searchOutput.jsp";
            }
        	else
        	{
        		window.location.href="GetAllBigType2Servlet";
            }
        }
    	 function fun1(flag,id)
         {
         	//if(flag == 1)
         	//{
         		window.location.href = "FindProByIdServlet?id="+id+"&flag="+flag;
         	//}
         	//else
         	//{
         		//window.location.href = "FindProByIdServlet?id="+id+"&flag="+flag;
           //  }
         }
    </script>
    <script type="text/javascript" src="js/jilian.js"></script>
  </head>
  <body>
  	<center>
	  	<div>
	   		<h1>库存查询</h1>
	   		<h3><a href="GetAllProductsServlet">返回主页</a></h3>
	   		<table width="900" cellspacing="0" border="1">
	   			<form action="GetProductsByKeyWordServlet" method="post">
	   				<tr align="center">
	   				<td colspan="8">
	   					大类：<select id="bigtype" name="bid" onchange="changeTypes(this.value)">
   							<option value="0" selected>--请选择--</option>
   								<c:forEach items="${bigList}" var="bt">
				  					<option value="${bt.id}">${bt.name}</option>
				  				</c:forEach>
   						</select>
   						小类：<select id="smalltype" name="sid">
   								<option value="0" selected>--请选择--</option>
   							</select>
   						产品名称：<input name="keyword"/>	
   						<input type="submit" value="查询"/>
	   					<input type="button" value="入库查询" onclick="change(3)"/>
	   					<input type="button" value="出库查询" onclick="change(4)"/>
	   					<input type="button" value="新产品入库" onclick="change(2)"/>
	   				</td>
	   			</tr>
	   			</form>
	   			
	   			<tr bgcolor="#CCCCCC">
	   				<td>产品名称</td>
	   				<td>单位</td>
	   				<td>数量</td>
	   				<td>预警值</td>
	   				<td colspan="3">操作</td>
	   			</tr>
	   			<c:forEach items="${pList}" var="p">
	   			<tr>
	   				
	   					<td>${p.name}</td>
		   			
		   				<td>${p.units}</td>
		   				<c:if test="${p.wvalue>=p.count}">
		   					<td bgcolor="red">${p.count }</td>
		   				</c:if>
		   				<c:if test="${p.wvalue<p.count}">
		   					<td>${p.count }</td>
		   				</c:if>
		   				<td>${p.wvalue}</td>
		   				<td>
		   					<input type="button" value="入库" onclick="fun1(1,${p.id})"/>
		   				</td>
		   				<td>
		   					<input type="button" value="出库" onclick="fun1(2,${p.id})"/>
						</td>
						<td>
		   					<input type="button" value="修改" onclick="fun1(3,${p.id})"/>
						</td>
		   			</tr>
	   				</c:forEach>
	   		</table>
	   		<jsp:include page="page_list.jsp"/>
	   	</div>
   	</center>
  </body>
</html>
