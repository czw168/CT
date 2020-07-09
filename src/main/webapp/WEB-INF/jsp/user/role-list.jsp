<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Role</title>
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
		<table id="roleList"></table>
	</div>
	<div id="roleAddWindow" class="easyui-window" title="RoleAdd" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/user/role-add'" style="width:600px;height:800px;padding:10px;"></div>
	<div id="roleEditWindow" class="easyui-window" title="RoleEdit" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/user/role-edit'" style="width:600px;height:800px;padding:10px;"></div>

	<script type="text/javascript"> 
		$(document).ready(function(){
			$('#roleList').datagrid({
				title: '',
				width:460,
				border:true,
				url:"listRole",
				columns:[[
					{field:'id',title:'id',hidden:true},
					{field:'roleName',title:'RoleName',align:'center',width:200},
					{field:'permissionNameList',title:'PermissionName',align:'right',width:200,
						formatter: function (val, row) {
							return val.toString().replace(/,/g,"&nbsp;<br>")+"&nbsp;";
						}
					}
				]],
				pagination:true,					//如果表格需要支持分页，必须设置该选项为true
				pageSize:20,   						//表格中每页显示的行数
				pageList:[5,10,15,20],				//自定义表格选择要显示的行数
				rownumbers:true,   					//是否显示行号
				nowrap: false,   					
				striped: true,  					//奇偶行是否使用不同的颜色
				method:'get',  						//表格数据获取方式,请求地址是上面定义的url
				//sortName: 'ID',  					//按照ID列的值排序
				//sortOrder: 'asc',  				//使用倒序排序
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
			        	$("#roleAddWindow").window({
			        		
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
			        	$("#roleEditWindow").window({
			        		onLoad :function(){
			        			$('#edit_roleName').textbox('textbox').css('background','#ccc');
			        			// 获取所选行数据
			        			var data = $("#roleList").datagrid("getSelections")[0];
			        			//回显数据
			        			$("#roleEditFrom").form("load",data);
			        			//$('#roleId').combobox('setValue',data.roleId);
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
								var data = $("#roleList").datagrid("getSelections")[0];
					        	$.ajax({
					                url: 'deleteRole',
					                type: "Post",
					                data: '{"id":"'+data.id+'"}',
					                contentType: "application/json;charset=UTF-8",
					                success: function (result) {
					    				if(result.status == 200){
					    					$.messager.alert("Message", "successfully!");
					    					$('#roleList').datagrid('reload');
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
		
		// 打开详情窗口
		/* function stockInfoWindowOpen(rem1){
			$("#stockInfoWindow").window({
	    		onLoad :function(){
	    			//回显数据
	    			var date = getData();
	    			$('#rem1').val(date.rem1);
	    			$('#itemCode').val(date.itemCode);
	    		}
	    	}).window("open");
		} */
		
		function getSelectionsIds(){
	    	var List = $("#roleList");
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
	    	var data = $("#roleList").datagrid("getSelected");
	    	return data;
	    }
		
		// 表单验证方式
		$.extend($.fn.validatebox.defaults.rules, {
			// 只能输入数字和小数点
			double_ : {
				validator: function (value) {
					return /^\d+(\.\d+)?$/.test(value);
				},
				message: 'Please enter a valid number'
			},
			// 只能输入大写字母和数字
			majusculeAndNumber : {
				validator: function (value) {
					return /^[A-Z0-9]*$/.test(value);
				},
				message: 'Format error'
			},
			// 匹配两次输入的密码
			confirmPass: {
		        validator: function(value, param){
		            var pass = $(param[0]).passwordbox('getValue');
		            return value == pass;
		        },
		        message: 'Password does not match confirmation.'
		    },
		    // 查看用户名是否存在
		    userName: {
		    	 validator: function(value, param){
						var name = "";
						$.ajax({
							type: 'POST',
							url: "../Role/checkUserName",
							data: '{"name":"'+value+'"}',
							dataType: "json",
							contentType: "application/json;charset=UTF-8",
							async:false,
							success: function(result){
								name = result.data;
							}
						});
						return value != name
			     },
			     message: 'The Role name already exists.'
		    }
		})
		
	</script>
</body>
</html>