<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product</title>
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
		<table id="productList"></table>
	</div>
	<div id="productAddWindow" class="easyui-window" title="ProductAdd" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/product/product-add'" style="width:600px;height:600px;padding:10px;"></div>
	<div id="productEditWindow" class="easyui-window" title="ProductEdit" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/product/product-edit'" style="width:600px;height:600px;padding:10px;"></div>

	<script type="text/javascript"> 
		$(document).ready(function(){
			$('#productList').datagrid({
				title: '',
				width:1260,
				border:true,
				url:"listProduct",
				columns:[[
					{field:'id',title:'id',hidden:true},
					{field:'pn',title:'P/N',align:'center',width:200},
					{field:'dwgNo',title:'DWG NO',align:'center',width:250},
					{field:'length',title:'Length',align:'center',width:150,
						formatter: function (val, row) {
							return val + "M";
						}},
					{field:'a0',title:'A0',align:'center',width:150,
						formatter: function (val, row) {
							return val + "MM";
						}},
					{field:'b0',title:'B0',align:'center',width:150,
						formatter: function (val, row) {
							return val + "MM";
						}},
					{field:'k0',title:'K0',align:'center',width:150,
						formatter: function (val, row) {
							return val + "MM";
						}
					},
					{field:'status',title:'Status',align:'center',width:150,
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
			        	$("#productAddWindow").window({

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
			        	$("#productEditWindow").window({
			        		onLoad :function(){
			        			$('#pn_edit').textbox('textbox').css('background','#ccc');
			        			// 获取所选行数据
			        			var data = $("#productList").datagrid("getSelections")[0];
			        			//回显数据
			        			$("#productEditFrom").form("load",data);
			        		}
			        	}).window("open");
			        }
			    }]  
			});
		});
		
		function getSelectionsIds(){
	    	var List = $("#productList");
	    	var sels = List.datagrid("getSelections");
	    	var ids = [];
	    	for(var i in sels){
	    		ids.push(sels[i].id);
	    	}
	    	ids = ids.join(",");
	    	return ids;
	    }
		
		// 表单验证方式
		$.extend($.fn.validatebox.defaults.rules, {
			// 只能输入数字、小数点
			double_ : {
				validator: function (value) {
					return /^\d+(\.\d+)?$/.test(value);
				},
				message: 'Please enter a valid number'
			},
			// 只能输入大写字母、数字
			majusculeAndNumber : {
				validator: function (value) {
					// 字母小写转换成大写
					this.value = this.value.toUpperCase();
					return /^[A-Z0-9]*$/.test(value);
				},
				message: 'Format error'
			},
			// 只能输入大写字母、数字、小数点
			majusculeAndNumberAndDot : {
				validator: function (value) {
					// 字母小写转换成大写
					this.value = this.value.toUpperCase();
					return /^[0-9a-zA-Z\.]+$/.test(value);
				},
				message: 'Format error'
			}
		})
		
	</script>
</body>
</html>