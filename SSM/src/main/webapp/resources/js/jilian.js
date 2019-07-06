
var xmlHttp;
//创建XMLHttpRequest对象
function createXMLHttpRequest() {
    // 这是最复杂的一步 需要针对IE和其他浏览器建立这个对象写不同的代码
    if (window.XMLHttpRequest) {
        //针对FireFox Opera IE7 IE8
        xmlHttp = new XMLHttpRequest();
        //针对某些特定版本的mozilla的bug修正
        if (xmlHttp.overrideMimeType) {
            xmlHttp.overrideMimeType("text/xml");
        }
    }
    else if (window.ActiveXObject) {
        //针对IE6及之前的版本
        //两个可以用于创建XMLHttpRequest对象的控件名,保存在一个js数组中,排在前面的较新
        var activeXName = ["MSXML2.XMLHTTP","Microsoft.XMLHTTP"];
        for (var i = 0; i < activeXName.length; i++) {
            try {
                //取出一个控件名进行创建，如果创建成功就终止创建
                //如果创建失败，回抛异常，可以继续循环，继续尝试创建
                xmlHttp = new ActiveXObject(activeXName[i]);
                break;
            }
            catch(e) {
            }
        }
    }
}

//function changeTypes(bid)
//{
//   createXMLHttpRequest();//创建XMLHttpRequest对象
//   //打开请求
//   xmlHttp.open("get","GetSmallTypeByBidServlet?bid="+bid,true);
//    xmlHttp.send(null);
//   //监听各个时候的状态
//   xmlHttp.onreadystatechange = callback;   //回调函数
//
//}

 //处理响应结果
function callback()
{
     // 判断交互是否完成
    if(xmlHttp.readyState == 4)
    {
        //判断服务器状态码是否返回成功
        if(xmlHttp.status == 200)
        {
            var domXml = xmlHttp.responseXML;
            clearSelect("smalltype");
            //得到city返回的数组
            var typeNodes = domXml.getElementsByTagName("type");
            for(var i=0;i<typeNodes.length;i++)
            {
                //分别得到city下面的子节点元素的内容
                var code = typeNodes[i].getElementsByTagName("code")[0].firstChild.nodeValue;
                var name = typeNodes[i].getElementsByTagName("name")[0].firstChild.nodeValue;
               // alert("code:"+code+",name:"+name);
                //添加option
                addOption(code,name);
            }
        }
    }
}

//添加选项
function addOption(code,name)
{
	 var typeDom = document.getElementById("smalltype");
     //向下拉列表添加内容
    //创建元素
   var stype = document.createElement("option");
    //设置其value
   stype.setAttribute("value",code);
   //添加显示的文本值
   stype.appendChild(document.createTextNode(name));
    //添加到DOM中
   typeDom.appendChild(stype);
}

//清空下拉列表
function clearSelect(selectId)
{
    var selectDom = document.getElementById(selectId);
    //如果其子元素长度大于0 就移除该子元素
    while(selectDom.childNodes.length > 0)
    {
         selectDom.removeChild(selectDom.childNodes[0]);
    }
}
