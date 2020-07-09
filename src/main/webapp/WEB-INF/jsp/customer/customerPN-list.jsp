<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>customerPn</title>
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
		<table id="customerPnList"></table>
	</div>
	<div id="customerPnAddWindow" class="easyui-window" title="CustomerPnAdd" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/customer/customerPN-add'" style="width:600px;height:400px;padding:10px;"></div>
	<div id="customerPnEditWindow" class="easyui-window" title="CustomerPnEdit" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/customer/customerPN-edit'" style="width:600px;height:400px;padding:10px;"></div>
	<script type="text/javascript"> 
		$(document).ready(function(){
			$('#customerPnList').datagrid({
				title: '',
				width:860,
				border:true,
				url:"listCustomerPn",
				columns:[[
					{field:'id',title:'id',hidden:true},
					{field:'pn',title:'UBoT P/N',align:'center',width:200},
					{field:'customerName',title:'Customer Name',align:'center',width:200},
					{field:'customerPn',title:'Customer P/N',align:'center',width:200},
					{field:'status',title:'Status',align:'center',width:200,
						formatter: function (val, row) {
							if(val == 1){
								return "<span style='color:green'>Enabled</span>";
							}else{
								return "<span style='color:red'>Disabled</span>";
							}
						}
					},
					{field:'requirement',title:'Requirement',hidden:true}
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
			        	$("#customerPnAddWindow").window({

			        	}).window("open");
			        }
			    }, {
			        text:'Edit',
			        iconCls:'icon-edit',
			        handler:function(){
						var sel = $("#customerPnList").datagrid("getSelections");
			        	if(sel == 0){
			        		$.messager.alert('Message','Please select one piece of data!');
			        		return;
			        	}
			        	$("#customerPnEditWindow").window({
			        		onLoad :function(){
			        			$('#pn_edit').textbox('textbox').css('background','#ccc');
			        			$('#customerName_edit').textbox('textbox').css('background','#ccc');
			        			// 获取所选行数据
			        			var data = $("#customerPnList").datagrid("getSelections")[0];
			        			//回显数据
			        			$("#customerPnEditFrom").form("load",data);
			        		}
			        	}).window("open");
			        }
			    }]  
			});
		});
		
	</script>
</body>
</html>