<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JO</title>
<!-- easyui -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/demo/demo.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery.serializejson.js"></script>
</head>
<body>
	<div style="margin-left: 5px;margin-top: 5px">
		<table id="shippingLabelList"></table>
	</div>
	
	<div id="shippingLabelTpoNewWindow" class="easyui-window" title="TPO List" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/shipping/shippingLabel-tpo-list',maximized:true" ></div>
	<div id="shippingLabelDetailsWindow" class="easyui-window" title="Shipping Label Details" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/shipping/shippingLabel-details',maximized:true" ></div>
	<%-- <div id="shippingLabelEditWindow" class="easyui-window" title="TPO Edit" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/shipping/shippingLabel-edit',maximized:true" ></div>	 --%>
	
	<div id="toolbar1">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newShippingLabel()">New</a>
        <!-- <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editShippingLabel()">Edit</a> -->
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Ship'G Lot # <input type="text" id="list_shipLot" /> 
        <a id="search1" href="javascript:void(0)" class="easyui-linkbutton">Search</a>  
    </div>
    
		<script type="text/javascript"> 
		$(document).ready(function(){
			$('#shippingLabelList').datagrid({
				title: '',  																//表格名称
				width:1310,   																//表格宽度
				border:true,  																//表格是否显示边框
				url:"listShippingLabel?time="+new Date(),												//获取表格数据时请求的地址
				columns:[[
					{field:'id',title:'id',hidden:true},
					{field:'shipLot',title:'Ship\'G Lot #',align:'center',width:200,
						formatter: function (val, row) {
							return '<a  style="text-decoration: none" href="javascript:void(0);" onclick="shippingLabelDetailsWindowOpen(\'' + val + '\')">' + val + '</a>';
						}
					},
					{field:'shipDate',title:'Ship Date',align:'center',width:150},
					{field:'cartons',title:'cartons',align:'center',width:150},
					/* {field:'tpo',title:'TPO #',align:'center',width:150},
					{field:'item',title:'Item',align:'center',width:150},
					{field:'ubotPn',title:'P/N',align:'center',width:150},
					{field:'desc',title:'DWG_NO',align:'center',width:150},
					{field:'uom',title:'QTY',align:'center',width:150}, */
					{field:'qty',title:'QTY',align:'center',width:150,
						formatter: function (val, row) {
							return val.toString().replace(/(\d)(?=(?:\d{3})+$)/g, '$1,');
						}
					},
					/* {field:'etdDate',title:'ETD Date',align:'center',width:150},
					{field:'requirement',title:'Requirement',align:'center',width:150}, */
					{field:'createBy',title:'Creater',align:'center',width:150},
					{field:'createTime',title:'Create Date',align:'center',width:150},
					{field:'updateBy',title:'Editor',align:'center',width:150},
					{field:'updateTime',title:'Edit Date',align:'center',width:150}
				]],
				cache:false,
				pagination:true,					//如果表格需要支持分页，必须设置该选项为true
				pageSize:20,   						//表格中每页显示的行数
				pageList:[5,10,15,20],				//自定义表格选择要显示的行数
				rownumbers:true,   					//是否显示行号
				nowrap: false,   					
				striped: true,  					//奇偶行是否使用不同的颜色
				method:'get',  						//表格数据获取方式,请求地址是上面定义的url
				//sortName: 'ID',  					//按照ID列的值排序
				//sortOrder: 'ubotJo',  			//使用倒序排序
				singleSelect:true,					//设置单选
				idField: 'id',						//表明该列是一个唯一列
				loadMsg:'Data Loading...',   		//加载数据时显示提示信息
				frozenColumns: [[  					//固定在表格左侧的栏
					{field: 'ck', checkbox: true},
				]],
				toolbar: "#toolbar1"
			});
		});
		
		$("#search1").click(function(){
			$("#shippingLabelList").datagrid('load',{
				"shipLot": $("#list_shipLot").val()
            });
        });
		
		function newShippingLabel(){
			$("#shippingLabelTpoNewWindow").window({

        	}).window("open");
		}
		
		function shippingLabelDetailsWindowOpen(val){
			$("#shippingLabelDetailsWindow").window({
				onLoad :function(){
					var data = $("#shippingLabelList").datagrid("getSelections")[0];
					
					$("#shippingLabelDetailsFrom").form("load",data);
					$('#details_shipLot').textbox('textbox').css('background','#ccc');
					$('#details_shipDate').textbox('textbox').css('background','#ccc');
					$('#details_cartons').textbox('textbox').css('background','#ccc');
					
					shippingLabelDetailsFunction(data.id);
				}
        	}).window("open");
		}
		
		/* function editShippingLabel(){
			var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('Message','Please select one piece of data!');
        		return;
        	}
			$("#shippingLabelEditWindow").window({
				onLoad :function(){
					var data = $("#shippingLabelList").datagrid("getSelections")[0];
					$("#tpoEditFrom1").form("load",data);
					$("#tpoEditFrom2").form("load",data);
					$('#edit_tpo').textbox('textbox').css('background','#ccc');
					$('#edit_updateBy').val("${subject.principal}");
					tpoEditFunction(data.id);
				}
        	}).window("open");
		} */
		
		function getSelectionsIds(){
	    	var List = $("#shippingLabelList");
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
	    	var data = $("#shippingLabelList").datagrid("getSelected");
	    	return data;
	    }
		
		// 表单验证方式
		/* $.extend($.fn.validatebox.defaults.rules, {
			double_ : {
				// 只能输入数字和小数点		
				validator: function (value) {
					return /^\d+(\.\d+)?$/.test(value);
				},
				message: 'Please enter a valid number'
			},
			majusculeAndNumber : {
				// 只能输入大写字母和数字			
				validator: function (value) {
					return /^[A-Z0-9]*$/.test(value);
				},
				message: 'Format error'
			}
		}) */
		
		// 日期格式化
		function myformatter(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
		}
		function myparser(s){
			if (!s) return new Date();
			var ss = (s.split('-'));
			var y = parseInt(ss[0],10);
			var m = parseInt(ss[1],10);
			var d = parseInt(ss[2],10);
			if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
				return new Date(y,m-1,d);
			} else {
				return new Date();
			}
		}
		
	</script>
</body>
</html>