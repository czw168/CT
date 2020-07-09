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
		<table id="packingLabelList"></table>
	</div>
	<div id="packingLabelLtcWindow" class="easyui-window" title="LTC" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/production/packingLabel-ltc-list'" style="width:1500px;height:800px;padding:10px;"></div>
	<div id="packingLabelEditWindow" class="easyui-window" title="Packing Label Edit" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/production/packingLabel-edit'" style="width:800px;height:500px;padding:10px;"></div>
	
	<div id="toolbar">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="packingLabelLtc()">New</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="packingLabelEdit()">Edit</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		Carton # : <input type="text" id="list_carton" /> 
		Lot No. : <input type="text" id="list_lotNo" />
        <a id="search" href="javascript:void(0)" class="easyui-linkbutton">Search</a>
    </div>  
	
	<script type="text/javascript"> 
		$(document).ready(function(){
			$('#packingLabelList').datagrid({
				title: '',  																//表格名称
				width:1560,   																//表格宽度
				border:true,  																//表格是否显示边框
				url:"listPackingLabel",							//获取表格数据时请求的地址
				columns:[[
					{field:'id',title:'id',hidden:true},
					/* {field:'carton',title:'Carton #',align:'center',width:200,
						formatter: function (val, row) {
							return '<a  style="text-decoration: none" href="javascript:void(0);" onclick="ltcDetailsWindowOpen(\'' + val + '\')">' + val + '</a>';
						}
					}, */
					{field:'carton',title:'Carton #',align:'center',width:200},
					{field:'qty',title:'QTY/Carton',align:'center',width:150},
					{field:'q1',title:'Q1',align:'center',width:150},
					{field:'q2',title:'Q2',align:'center',width:150},
					{field:'q3',title:'Q3',align:'center',width:150},
					{field:'packingDate',title:'Packing Date',align:'center',width:150},
					{field:'ltc',title:'LTC #',align:'center',width:150},
					{field:'ubotPn',title:'P/N',align:'center',width:150},
					{field:'desc',title:'DWG. NO',align:'center',width:250}
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
				toolbar: "#toolbar"
			});
		});
		
		$("#search").click(function(){
			$("#packingLabelList").datagrid('load',{
				"carton": $("#list_carton").val(),
				"lotNo": $("#list_lotNo").val()
            });
        });
		
		function packingLabelLtc(){
			$("#packingLabelLtcWindow").window({

        	}).window("open");
		}
		
		/* function packingLabelEdit(){
			$("#packingLabelLtcWindow").window({

        	}).window("open");
		} */
		
		function packingLabelEdit(){
			var ids = $("#packingLabelList").datagrid("getSelections");
			//var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('Message','Please select one piece of data!');
        		return;
        	}
			$("#packingLabelEditWindow").window({
				onLoad :function(){
					var data = $("#packingLabelList").datagrid("getSelections")[0];
					$('#edit_ltc').textbox('textbox').css('background','#ccc');
        			$('#edit_carton').textbox('textbox').css('background','#ccc');
        			$("#packingLabelEditFrom").form("load",data);
        			$('#edit_updateBy').val("${subject.principal}");
				}
        	}).window("open");
		}
		
		/* function getSelectionsIds(){
	    	var List = $("#packingLabelList");
	    	var sels = List.datagrid("getSelections");
	    	var ids = [];
	    	for(var i in sels){
	    		ids.push(sels[i].id);
	    	}
	    	ids = ids.join(",");
	    	return ids;
	    } */
		
		// 获取所选行数据
		function getData(){
	    	var data = $("#packingLabelList").datagrid("getSelected");
	    	return data;
	    }
		
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