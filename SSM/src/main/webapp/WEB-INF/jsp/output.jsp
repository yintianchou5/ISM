<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>出库</title>
	<script type="text/javascript">
		function checkNum(nowNum,pcount){
			if(nowNum > pcount){
				document.getElementById("pcount").value = 0;
				alert("您输入的数量大于库存！");
			}else if(nowNum <= 0){
				alert("出库数量必须大于0！");
				document.getElementById("pcount").value = 0;
			}
		}
	</script>
  </head>
  <body>
   		<center>
   			<h2>出库</h2>
   			<h3><a href="GetAllProductsServlet">返回主页</a></h3>
   			<form action="AddOutputServlet" method="post">
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
   							<input name="pcount" id="pcount" value="" onblur="checkNum(this.value,${p.count})"/>
   						</td>
   					</tr>
   					<!--<tr>
   						<td>价格:</td>
   						<td>
   							<input name="price"/>*精确到小数点两位
   						</td>
   					</tr>  -->
   					<tr>
   						<td>经办人:</td>
   						<td>
   							<input name="annt"/>
   						</td>
   					</tr>
   				</table>
   				<input type="hidden" name="price" value="0"/>
   				<input type="hidden" name="pid" value="${p.id}"/>
   				<input type="hidden" name="count" value="${p.count}"/>
   				<input type="submit" value="提  交"/>
   				
   			</form>
   		</center>
  </body>
</html>
