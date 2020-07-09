<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>customerInfo</title>
<!-- easyui -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/demo/demo.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery.serializejson.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/easyuiVerify.js"></script>
</head>
<body>
	<div style="margin-left: 5px;margin-top: 5px">
		<table id="customerInfoList"></table>
	</div>
	<div id="customerInfoAddWindow" class="easyui-window" title="Customer Info Add" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/customer/customerInfo-add'" style="width:400px;height:300px;padding:10px;"></div>
	<div id="customerInfoEditWindow" class="easyui-window" title="Customer Info Edit" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/customer/customerInfo-edit'" style="width:400px;height:300px;padding:10px;"></div>

	<script type="text/javascript"> 
		$(document).ready(function(){
			$('#customerInfoList').datagrid({
				title: '',  																//表格名称
				width:432,   																//表格宽度
				border:true,  																//表格是否显示边框
				url:"listCustomerInfo",				//获取表格数据时请求的地址
				columns:[[
					{field:'id',title:'id',hidden:true},
					{field:'customerId',title:'Customer ID',align:'center',width:200},
					{field:'customerName',title:'Customer Name',align:'center',width:200}
				]],
				pagination:true,					//如果表格需要支持分页，必须设置该选项为true
				pageSize:20,   						//表格中每页显示的行数
				pageList:[5,10,15,20],				//自定义表格选择要显示的行数
				rownumbers:true,   					//是否显示行号
				nowrap: false,   					
				striped: true,  					//奇偶行是否使用不同的颜色
				method:'get',  						//表格数据获取方式,请求地址是上面定义的url
				singleSelect:true,					//设置单选
				idField: 'id',						//表明该列是一个唯一列
				loadMsg:'Data Loading...',   		//加载数据时显示提示信息
				toolbar: [{
			        text:'Add',
			        iconCls:'icon-add',
			        handler:function(){
			        	$("#customerInfoAddWindow").window({

			        	}).window("open");
			        }
			    },{
			        text:'Edit',
			        iconCls:'icon-edit',
			        handler:function(){
			        	var sel = $("#customerInfoList").datagrid("getSelections");
			        	if(sel.length == 0){
			        		$.messager.alert('Message','Please select one piece of data!');
			        		return;
			        	}
			        	$("#customerInfoEditWindow").window({
			        		onLoad :function(){
			        			var data = $("#customerInfoList").datagrid("getSelected");
				        		$("#customerInfoEditFrom").form("load",data);
				        		$('#edit_customerId').textbox('textbox').css('background','#ccc');
			        		}
			        	}).window("open");
			        }
			    }]  
			});
		});
		
		/* function getSelectionsIds(){
	    	var List = $("#customerInfoList");
	    	var sels = List.datagrid("getSelections");
	    	var ids = [];
	    	for(var i in sels){
	    		ids.push(sels[i].id);
	    	}
	    	ids = ids.join(",");
	    	return ids;
	    } */
		
	</script>
</body>
</html>