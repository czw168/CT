<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>permission</title>
<!-- easyui -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/demo/demo.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/jquery.easyui.min.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/locale/easyui-lang-zh_CN.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery.serializejson.js"></script>
</head>
<body>
	<div style="margin-left: 5px;margin-top: 5px">
		<table id="permissionList"></table>
	</div>
	<div id="permissionAddWindow" class="easyui-window" title="PermissionAdd" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/user/permission-add'" style="width:500px;height:300px;padding:10px;"></div>
	<div id="permissionEditWindow" class="easyui-window" title="PermissionEdit" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/user/permission-edit'" style="width:500px;height:300px;padding:10px;"></div>

	<script type="text/javascript"> 
		$(document).ready(function(){
			$('#permissionList').datagrid({
				title: '',
				width:760,
				border:true,
				url:"listPermission",
				columns:[[
					{field:'id',title:'id',hidden:true},
					{field:'name',title:'Name',align:'center',width:200},
					{field:'desc',title:'Desc',align:'center',width:250},
					{field:'url',title:'Url',align:'center',width:250}
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
				frozenColumns: [[  					//固定在表格左侧的栏
					{field: 'ck', checkbox: true},
				]],
				toolbar: [{
			        text:'Add',
			        iconCls:'icon-add',
			        handler:function(){
			        	$("#permissionAddWindow").window({

			        	}).window("open");
			        }
			    }, {
			        text:'Edit',
			        iconCls:'icon-edit',
			        handler:function(){
						var ids = getSelectionsIds();
			        	if(ids.length == 0){
			        		$.messager.alert('Message','Please select one piece of data!');
			        		return;
			        	}
			        	$("#permissionEditWindow").window({
			        		onLoad :function(){
			        			$('#name_edit').textbox('textbox').css('background','#ccc');
			        			// 获取所选行数据
			        			var data = $("#permissionList").datagrid("getSelections")[0];
			        			//回显数据
			        			$("#permissionEditFrom").form("load",data);
			        		}
			        	}).window("open");
			        }
			    }, {
			        text:'Delete',
			        iconCls:'icon-cancel',
			        handler:function(){
			        	var ids = getSelectionsIds();
			        	if(ids.length == 0){
			        		$.messager.alert('Message','Please select one piece of data!');
			        		return;
			        	}
			        	$.messager.confirm('Missage','Are you sure to delete it?',function(r) {
							if (r) {
								var data = $("#permissionList").datagrid("getSelections")[0];
					        	$.ajax({
					                url: 'deletePermission',
					                type: "Post",
					                data: '{"id":"'+data.id+'"}',
					                contentType: "application/json;charset=UTF-8",
					                success: function (result) {
					    				if(result.status == 200){
					    					$.messager.alert("Message", "successfully!");
					    					$('#permissionList').datagrid('reload');
					    				}else{
					    					$.messager.alert("Message", "Fail !" + result.msg);
					    				}          
					                }
					            });
							}
						});
			        }
			    }]  
			});
		});
		
		function getSelectionsIds(){
	    	var List = $("#permissionList");
	    	var sels = List.datagrid("getSelections");
	    	var ids = [];
	    	for(var i in sels){
	    		ids.push(sels[i].id);
	    	}
	    	ids = ids.join(",");
	    	return ids;
	    }
		
		// 获取所选行数据
		function getData(){
	    	var data = $("#permissionList").datagrid("getSelected");
	    	return data;
	    }
		
	</script>
</body>
</html>