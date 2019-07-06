<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function changePage(cp)
{
	//给隐藏域设置内容
	document.pageListForm.pageNum.value = cp;
	document.pageListForm.submit();
}

function submitContent(cp)
{
	//给隐藏域设置内容
	document.pageListForm.cp.value = cp;
	document.pageListForm.keyword.value = document.searchForm.keyword.value;
	
	document.searchForm.submit();
}
</script>
<form action="main" method="get" name="pageListForm">
<table>			
<tr>
	<td colspan="7">
		<input type="hidden" name="pageNum">
		<input type="button" value="首页" onclick="changePage(1)" ${pageinfo.pageNum==1?"disabled":""}/>
		<input type="button" value="上一页" onclick="changePage(${pageinfo.prePage})" ${pageinfo.pageNum==1?"disabled":""}/>
		<input type="button" value="下一页" onclick="changePage(${pageinfo.nextPage})" />
		<input type="button" value="尾页" onclick="changePage(${pageinfo.pages})" ${pageinfo.pageNum==pageinfo.pages?"disabled":""}/>
		一共有${pageinfo.pages}页,当前第${pageinfo.pageNum}页
		<select onchange="changePage(this.value)">
			<c:forEach begin="1" end="${pageinfo.pages}" var="i">
				<option value="${i}" ${pageinfo.pageNum==i?"selected":"" }>${i}</option>
			</c:forEach>
		</select>
	</td>
</tr>
</table>
	<input type="hidden" name="keyword"  value="${keyword}"/>
	</form>
