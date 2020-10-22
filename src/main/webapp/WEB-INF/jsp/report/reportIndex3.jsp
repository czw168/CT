<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UBoT</title>
<!-- easyui -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/demo/demo.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/locale/easyui-lang-en.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery.serializejson.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/easyuiVerify.js"></script>
</head>

<body class="easyui-layout" onkeydown="keyLogin();">
	<div data-options="region:'north',border:false" style="height:45px;padding:10px;">Carrier Tape System&nbsp;&nbsp;&nbsp;Current User ：[${subject.principal}]</div>
   	
   	<div data-options="region:'west',title:'Menu',split:true" style="width:200px;">
   		<div style="margin-top: 10px;margin-left: 10px;">
	   		<form id="dataForm" method="post" onsubmit="return false;">
	   			<table>
	    			<tr><td>&nbsp;</td></tr>
	    			<tr><td>Lot No.:</td></tr>
	    			<tr><td><input class="easyui-textbox" name="lotNo" id="lotNo" style="width: 150px" data-options="validType:'length[14,14]',prompt:'xxxxxxxxxx-xxx'"/></td></tr>
	    			<tr><td>&nbsp;</td></tr>
	    			<tr><td>ProductNo.:</td></tr>
	    			<tr><td>
	    				<!-- <input class="easyui-combobox" name="table" id="table" data-options="valueField:'value',textField:'text',method:'get',url:'/CT/statics/json/table.json',editable:false,required:true" style="width: 150px" > -->
	    				<input class="easyui-combobox" name="productNo" id="productNo" data-options="valueField:'text',textField:'text',method:'get',url:'${pageContext.request.contextPath}/report/getProductNo',editable:false,required:true" style="width: 150px" >
	    			</td></tr>
	    			<tr><td>&nbsp;</td></tr>
	    			<tr><td>
	    				<a href="javascript:;" class="easyui-linkbutton" onclick="datasubmit()">Submit</a>&nbsp;&nbsp;&nbsp;
	    				<a href="javascript:;" class="easyui-linkbutton" onclick="$('#dataForm').form('reset');">Reset</a>
	    			</td></tr>
	    			<tr><td>&nbsp;</td></tr>
	    			<tr><td>
	    				<a href="javascript:;" class="easyui-linkbutton" onclick="javascript:history.back(-1)">Return to report menu</a>
	    			</td></tr>
    			</table>
	   		</form>
   		</div>
   		<span style="vertical-align: top"></span>
    </div>
    
    <div data-options="region:'center',title:''">
		<div id="tabs" class="easyui-tabs" style="height:100%;">
			<div title="index" style="padding:20px;">
				<h1>Welcome！</h1>
			</div>
		</div>
    </div>



	

<script type="text/javascript">

	// 获取当前日期
	
	
	$(document).ready(function(){
		
	});
	
	//回车按键
	function keyLogin(){
		 if (event.keyCode==13)  		// 回车键的键值为13
		 datasubmit(); 		// 调用提交按钮的点击事件
	}
	
	function datasubmit(){
		var lotNo = $("#lotNo").val();
		var productNo = $("#productNo").val();
		var validate = $("#dataForm").form('validate');
        if (!validate) {
			$("#dataForm").find(".validatebox-invalid:first").focus();
            return false;
        }
        
        
     // 判断有无参数设定
        $.get("${pageContext.request.contextPath}/report/getReportSetting?productNumber="+productNo,function(result){
		  	var table = result.data;
        	if(table == null){
		  		$.messager.alert('Message','Parameters not set');
		  		return;
		  	}
		  	var url = "${pageContext.request.contextPath}/report/report-list3?lotNo="+lotNo+"&table="+table;
			var title = "XXXXX";
			addTab(title,url);	
		});
        
// 		var url = "${pageContext.request.contextPath}/report/report-list3?lotNo="+lotNo+"&productNo="+productNo;
// 		var title = "XXXXX";
// 		addTab(title,url);
	}
	
	// 添加tab
	function addTab(title,url){
		var tabs = $("#tabs");
		var tab = tabs.tabs("getTab",title);
		// tab存在则刷新
		if(tab){
			RefreshTab(tab,url);
			tabs.tabs('select', title);
		// tab不存在则添加
		}else{
			// 关闭当前tab
		    var currTab = tabs.tabs('getSelected');
		    if(currTab){
		        $('#tabs').tabs('close',currTab.panel('options').title);
		    }
			// iframe
			var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
			tabs.tabs('add',{
				title:title,
				content:content,
				closable:true
			});
		}
	}
	
	// 刷新tab
	function RefreshTab(tab,url) {
		var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
		$('#tabs').tabs('update', {
			tab: tab,
			options: {
				content: content
	 		}
		});
		tab.panel('refresh');
	}
	
	//注销
	function loginOut(){
		$.post("${pageContext.request.contextPath}/user/loginOut", function(result){
			if(result.status == 200){
				location.href = "${pageContext.request.contextPath}";
			}
		});
	}
	
	//ajax错误
	$(document).ajaxError(function(e, jqXHR, options, errorMsg){
	    //no login
	    if(jqXHR.status == 401) {
	        location.href = "${pageContext.request.contextPath}";
	    }
	});

	

</script>

</body>
</html>