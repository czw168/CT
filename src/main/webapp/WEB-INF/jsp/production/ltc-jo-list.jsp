<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<div align="center">
		<table id="joList"></table>
	</div>
	<div id="ltcJoDetailsWindow" class="easyui-window" title="JODetails" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/production/ltc-jo-details',maximized:true" ></div>
	
	<div id="toolbar2">
		&nbsp;&nbsp;&nbsp;JO NO. <input type="text" id="joNo_search" /> 
        <a id="joNoSearch" href="javascript:void(0)" class="easyui-linkbutton">Search</a>  
    </div>  
	
	<script type="text/javascript"> 
		$(document).ready(function(){
			$('#joList').datagrid({
				title: '',  																//表格名称
				width:552,   																//表格宽度
				border:true,  																//表格是否显示边框
				url:"listJO",							//获取表格数据时请求的地址
				columns:[[
					{field:'id',title:'id',hidden:true},
					{field:'ubotJo',title:'JO NO.',align:'center',width:200,
						formatter: function (val, row) {
							return '<a  style="text-decoration: none" href="javascript:void(0);" onclick="ltcJoDetailsWindowOpen(\'' + val + '\')">' + val + '</a>';
						}
					},
					{field:'uom',title:'UOM',align:'center',width:100},
					{field:'total',title:'QTY',align:'center',width:100},
					{field:'createTime',title:'Create Date',align:'center',width:150}
				]],
				pagination:true,					//如果表格需要支持分页，必须设置该选项为true
				pageSize:20,   						//表格中每页显示的行数
				pageList:[5,10,15,20],				//自定义表格选择要显示的行数
				//rownumbers:true,   					//是否显示行号
				nowrap: false,   					
				striped: true,  					//奇偶行是否使用不同的颜色
				method:'get',  						//表格数据获取方式,请求地址是上面定义的url
				singleSelect:true,					//设置单选
				idField: 'id',						//表明该列是一个唯一列
				loadMsg:'Data Loading...',   		//加载数据时显示提示信息
				/* frozenColumns: [[  					//固定在表格左侧的栏
					{field: 'ck', checkbox: true},
				]], */
				toolbar: "#toolbar2"
			});
		});
		
		$("#joNoSearch").click(function(){
			$("#joList").datagrid('load',{
				"joNo": $("#joNo_search").val()
            });
        });
		
		function ltcJoDetailsWindowOpen(val){
			$("#ltcJoDetailsWindow").window({
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
		
	</script>
