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
		<table id="ltcList"></table>
	</div>
	<div id="ltcJoWindow" class="easyui-window" title="JO" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/production/ltc-jo-list'" style="width:900px;height:800px;padding:10px;"></div>
	<div id="ltcDetailsWindow" class="easyui-window" title="JODetails" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/production/ltc-details'" style="width:900px;height:800px;padding:10px;"></div>
	
	<div id="toolbar">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="ltcJO()">New</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		LTC : <input type="text" id="ltc_search" /> 
        <a id="search" href="javascript:void(0)" class="easyui-linkbutton">Search</a>  
    </div>  
	
	<script type="text/javascript"> 
		$(document).ready(function(){
			$('#ltcList').datagrid({
				title: '',  																//表格名称
				width:1410,   																//表格宽度
				border:true,  																//表格是否显示边框
				url:"listLTC",							//获取表格数据时请求的地址
				columns:[[
					{field:'id',title:'id',hidden:true},
					{field:'ltc',title:'LTC #',align:'center',width:200,
						formatter: function (val, row) {
							return '<a  style="text-decoration: none" href="javascript:void(0);" onclick="ltcDetailsWindowOpen(\'' + val + '\')">' + val + '</a>';
						}
					},
					{field:'ubotPn',title:'P/N',align:'center',width:150},
					{field:'desc',title:'DWG_NO.',align:'center',width:250},
					{field:'lane',title:'Lane #',align:'center',width:100},
					{field:'joNo',title:'JO NO.',align:'center',width:200},
					{field:'productionDate',title:'Production Date',align:'center',width:150},
					{field:'customerName',title:'Customer',align:'center',width:150},
					{field:'custPn',title:'Customer P/N',align:'center',width:150}
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
			$("#ltcList").datagrid('load',{
				"ltc": $("#ltc_search").val()
            });
        });
		
		function ltcJO(){
			$("#ltcJoWindow").window({

        	}).window("open");
		}
		
		function ltcDetailsWindowOpen(val){
			$("#ltcDetailsWindow").window({
				onLoad :function(){
					var data = $("#ltcList").datagrid("getSelections")[0];
					$('#details_ltc').textbox('textbox').css('background','#ccc');
					$('#details_sourceBatchCode').textbox('textbox').css('background','#ccc');
					$('#details_joNo').textbox('textbox').css('background','#ccc');
					$('#details_lotType').textbox('textbox').css('background','#ccc');
					$('#details_ubotPn').textbox('textbox').css('background','#ccc');
					$('#details_productType').textbox('textbox').css('background','#ccc');
					$('#details_desc').textbox('textbox').css('background','#ccc');
					$('#details_productionDate').textbox('textbox').css('background','#ccc');
					$('#details_customerName').textbox('textbox').css('background','#ccc');
					$('#details_lotSerics').textbox('textbox').css('background','#ccc');
					$('#details_custPn').textbox('textbox').css('background','#ccc');
					$('#details_sublotSerics').textbox('textbox').css('background','#ccc');
					$('#details_lane').textbox('textbox').css('background','#ccc');
					$('#details_formingTool').textbox('textbox').css('background','#ccc');
					$('#details_machine').textbox('textbox').css('background','#ccc');
					$('#details_scittingTool').textbox('textbox').css('background','#ccc');
					$('#details_puchingTool').textbox('textbox').css('background','#ccc');
					$('#details_materialLot').textbox('textbox').css('background','#ccc');
					$('#details_remarks').textbox('textbox').css('background','#ccc');
					//回显数据
        			$("#ltcDetailsFrom").form("load",data);
        			$('#details_updateBy').val("${subject.principal}");
				}
        	}).window("open");
		}
		
		function getSelectionsIds(){
	    	var List = $("#ltcList");
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
	    	var data = $("#ltcList").datagrid("getSelected");
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