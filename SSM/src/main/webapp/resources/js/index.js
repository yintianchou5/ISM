$(function(){
	var adminListUrl='/SSM/ssm/getadminlist';
	var loginUrl='/SSM/ssm/login'
	var username=document.getElementById('username');
	var password=document.getElementById('pass');
	function getAdminList() {
		$.getJSON(adminListUrl, function(data) {
			if (data.success) {
				var adminList=data.adminList;
				
				
			}
		});
	}
	$('#submit').click(function() {
		
		var username= $('#username').val();
		var password= $('#pass').val();
		var formData = new FormData();
		formData.append('username',username);
		formData.append('password',password);
		$.ajax({
			url : loginUrl,
			type : 'POST',
			data : formData,
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if (data.success) {
					$.toast('登录成功！');
				} else {
					$.toast('登录失败!');
				}
			}
		});
	});
});