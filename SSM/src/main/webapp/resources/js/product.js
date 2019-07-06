$(function(){
	getlist();
	function getlist(){
		$.ajax({
			url:"/SSM/ssm/getproductslist",
			type:"get",
			dataType:"json",
			success:function(data){
				if(data.success){
					handleList(data.productsList);
					handleUser(data);
				}
			}
		});
		$('#dg').datagrid({
			url:'datagrid'
		});
		
	}
	function handleUser(data){
		$('#user-name').text(data.username);
	}
	function handleList(data){
		
		var html='';
		data.map(function(item,index){
			html+='<tr>'
				+'<th class="col-10">'+item.name+'</th>'
				+'<th class="col-10">'+item.units+'</th>'
				+'<th class="col-10">'+item.count+'</th>'
				+'<th class="col-10">'+item.createtime+'</th>'
				+'</tr>';
		});
		$('.productList').html(html);
	}
	
	
});