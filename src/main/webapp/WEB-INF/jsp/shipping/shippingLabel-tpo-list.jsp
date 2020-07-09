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
	<div style="margin-top: 5px" align="center">
		<table id="tpoList"></table>
	</div>
	
	<%-- <div id="tpoNewWindow" class="easyui-window" title="TPO New" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/shipping/tpo-new',maximized:true" ></div> --%>
	<div id="tpoDetailsWindow" class="easyui-window" title="TPO Details" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/shipping/shippingLabel-tpo-details',maximized:true" ></div>
	<%-- <div id="tpoEditWindow" class="easyui-window" title="TPO Edit" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/shipping/tpo-edit',maximized:true" ></div> --%>	
	
	<div id="toolbar2">
		TPO # <input type="text" id="list_tpo" /> 
        <a id="search2" href="javascript:void(0)" class="easyui-linkbutton">Search</a>  
    </div>  
	
	<script type="text/javascript"> 
		$(document).ready(function(){
			$('#tpoList').datagrid({
				title: '',  																//表格名称
				width:1310,   																//表格宽度
				border:true,  																//表格是否显示边框
				url:"listTpo?time="+new Date(),												//获取表格数据时请求的地址
				columns:[[
					{field:'id',title:'id',hidden:true},
					{field:'tpo',title:'TPO #',align:'center',width:200,
						formatter: function (val, row) {
							return '<a  style="text-decoration: none" href="javascript:void(0);" onclick="tpoDetailsWindowOpen(\'' + val + '\')">' + val + '</a>';
						}
					},
					{field:'customer',title:'Customer',align:'center',width:150},
					{field:'customerPo',title:'Customer PO #',align:'center',width:150},
					{field:'qty',title:'QTY',align:'center',width:150},
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
				toolbar: "#toolbar2"
			});
		});
		
		$("#search2").click(function(){
			$("#tpoList").datagrid('load',{
				"tpo": $("#list_tpo").val()
            });
        });
		
		/* function newTPO(){
			$("#tpoNewWindow").window({

        	}).window("open");
		} */
		
		function tpoDetailsWindowOpen(val){
			$("#tpoDetailsWindow").window({
				onLoad :function(){
					var data = $("#tpoList").datagrid("getSelections")[0];
					/* $("#tpoDetailsFrom").form("load",data);
					$('#details_customer').textbox('textbox').css('background','#ccc');
					$('#details_tpo').textbox('textbox').css('background','#ccc');
					$('#details_billTo').textbox('textbox').css('background','#ccc');
					$('#details_customerPo').textbox('textbox').css('background','#ccc');
					$('#details_shipTo').textbox('textbox').css('background','#ccc');
					$('#details_createDate').textbox('textbox').css('background','#ccc');
					$('#details_remark').textbox('textbox').css('background','#ccc');
					$('#details_terms').textbox('textbox').css('background','#ccc');
					$('#details_shipmode').textbox('textbox').css('background','#ccc');
					$('#details_requiredShipdate').textbox('textbox').css('background','#ccc'); */
					tpoDetailsFunction(data.id);
					
					$('#new_shipLot').textbox('textbox').css('background','#ccc');
					$("#new_tpo").val(data.tpo);
					
				}
        	}).window("open");
		}
		
		/* function editTPO(){
			var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('Message','Please select one piece of data!');
        		return;
        	}
			$("#tpoEditWindow").window({
				onLoad :function(){
					var data = $("#tpoList").datagrid("getSelections")[0];
					$("#tpoEditFrom1").form("load",data);
					$("#tpoEditFrom2").form("load",data);
					$('#edit_tpo').textbox('textbox').css('background','#ccc');
					$('#edit_updateBy').val("${subject.principal}");
					tpoEditFunction(data.id);
				}
        	}).window("open");
		} */
		
		/* function getSelectionsIds(){
	    	var List = $("#tpoList");
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
	    	var data = $("#tpoList").datagrid("getSelected");
	    	return data;
	    } */
		
		/* // 表单验证方式
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
		}) */
		
		/* // 日期格式化
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
		} */
		
	</script>
</body>
</html>