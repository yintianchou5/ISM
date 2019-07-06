/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 11-4-25
 * Time: 下午4:16
 * To change this template use File | Settings | File Templates.
 */
$(document).ready(function(){
    //失去焦点触发事件
    $("#name").blur(function(){
        
        var name = $("#name").val();
        $("#message").html("正在检测....");
        //设置时间函数
        setTimeout(function(){
            //开始向Servlet发送数据
            $.get("AJAXValNameServlet?name="+name,null,callback1,true);
        },500);

    });
});

function callback1(data)
{
      $("#message").html(data);
}

