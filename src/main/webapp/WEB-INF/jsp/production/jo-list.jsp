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
		<table id="joList"></table>
	</div>
	<div id="joNewWindow" class="easyui-window" title="JO New" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/production/jo-new',maximized:true" ></div>
	<div id="joDetailsWindow" class="easyui-window" title="JO Details" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/production/jo-details',maximized:true" ></div>
	
	<div id="toolbar">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newJO()">New</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		JO NO.<input type="text" id="joNo_search" /> 
        <a id="search" href="javascript:void(0)" class="easyui-linkbutton">Search</a>  
    </div>  
	
	<script type="text/javascript"> 
		$(document).ready(function(){
			$('#joList').datagrid({
				title: '',  																//表格名称
				width:1060,   																//表格宽度
				border:true,  																//表格是否显示边框
				url:"listJO?time="+new Date(),							//获取表格数据时请求的地址
				columns:[[
					{field:'id',title:'id',hidden:true},
					{field:'ubotJo',title:'JO NO.',align:'center',width:200,
						formatter: function (val, row) {
							return '<a  style="text-decoration: none" href="javascript:void(0);" onclick="joDetailsWindowOpen(\'' + val + '\')">' + val + '</a>';
						}
					},
					{field:'uom',title:'UOM',align:'center',width:100},
					{field:'total',title:'QTY',align:'right',width:100,
						formatter: function (val, row) {
							return val.toString().replace(/(\d)(?=(?:\d{3})+$)/g, '$1,');
						}
					},
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
				toolbar: "#toolbar"
			});
		});
		
		$("#search").click(function(){
			$("#joList").datagrid('load',{
				"joNo": $("#joNo_search").val()
            });
        });
		
		function newJO(){
			$("#joNewWindow").window({
				onLoad :function(){
					$.get("getMaxJoNo",function(result) {
						joNewFunction(result.data);
					});
				}
        	}).window("open");
		}
		
		function joDetailsWindowOpen(val){
			$("#joDetailsWindow").window({
				onLoad :function(){
					var data = $("#joList").datagrid("getSelections")[0];
					joDetailsFunction(data.ubotJo);
				}
        	}).window("open");
		}
		
		function getSelectionsIds(){
	    	var List = $("#joList");
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
	    	var data = $("#joList").datagrid("getSelected");
	    	return data;
	    }
		
		// 表单验证方式
		$.extend($.fn.validatebox.defaults.rules, {
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
		})
		
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