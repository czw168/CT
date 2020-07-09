<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<div align="center">
		<table id="packingLabelLtcList"></table>
	</div>
	<div id="packingLabelNewWindow" class="easyui-window" title="Packing Label New" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/production/packingLabel-new'" style="width:500px;height:500px;padding:10px;"></div>
	
	<div id="toolbar2">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="packingLabelAdd()">Select</a>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		LTC : <input type="text" id="ltc2" /> 
        <a id="search2" href="javascript:void(0)" class="easyui-linkbutton">Search</a>    
    </div>  
	
	<script type="text/javascript"> 
		$(document).ready(function(){
			$('#packingLabelLtcList').datagrid({
				title: '',  																//表格名称
				width:1382,   																//表格宽度
				border:true,  																//表格是否显示边框
				url:"listLTC",							//获取表格数据时请求的地址
				columns:[[
					{field:'id',title:'id',hidden:true},
					/* {field:'ltc',title:'LTC #',align:'center',width:200,
						formatter: function (val, row) {
							return '<a  style="text-decoration: none" href="javascript:void(0);" onclick="reelLabelNewWindowOpen(\'' + val + '\')">' + val + '</a>';
						}
					}, */
					{field:'ltc',title:'LTC #',align:'center',width:200},
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
				//rownumbers:true,   					//是否显示行号
				nowrap: false,   					
				striped: true,  					//奇偶行是否使用不同的颜色
				method:'get',  						//表格数据获取方式,请求地址是上面定义的url
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
			$("#packingLabelLtcList").datagrid('load',{
				"ltc": $("#ltc2").val()
            });
        });
		
		function packingLabelAdd(){
			//var ids = getSelectionsIds();
			var ids = $("#packingLabelLtcList").datagrid("getSelections");
        	if(ids.length == 0){
        		$.messager.alert('Message','Please select one piece of data!');
        		return;
        	}
        	$("#packingLabelNewWindow").window({
        		onLoad :function(){
        			// 获取所选行数据
        			var data = $("#packingLabelLtcList").datagrid("getSelections")[0];
        			//回显数据
        			
        			$('#new_ltc').textbox('textbox').css('background','#ccc');
        			$('#new_carton').textbox('textbox').css('background','#ccc');
        			$('#new_ltc').textbox('setValue',data.ltc);
        			/* $("#ltcNewFrom").form("load",data);
        			
        			$('#new_ltc').textbox('textbox').css('background','#ccc');
        			$('#new_joNo').textbox('setValue',joNo);
        			$('#new_joNo').textbox('textbox').css('background','#ccc');
        			$('#new_ubotPn').textbox('textbox').css('background','#ccc');
        			$('#new_desc').textbox('textbox').css('background','#ccc');
        			$('#new_custPn').textbox('textbox').css('background','#ccc');
        			$('#new_machine').textbox('textbox').css('background','#ccc');
        			$('#new_puchingTool').textbox('textbox').css('background','#ccc');
        			$('#new_materialLot').textbox('textbox').css('background','#ccc');
        			
        			$('#new_sourceBatchCode').textbox('textbox').css('background','#ccc');
        			$('#new_lotType').textbox('textbox').css('background','#ccc');
        			$('#new_productType').textbox('textbox').css('background','#ccc');
        			$('#new_lotSerics').textbox('textbox').css('background','#ccc');
        			$('#new_sublotSerics').textbox('textbox').css('background','#ccc');
        			$('#new_formingTool').textbox('textbox').css('background','#ccc');
        			$('#new_scittingTool').textbox('textbox').css('background','#ccc'); */
        		}
        	}).window("open");
		}
		
		/* function reelLabelNewWindowOpen(val){
			$("#reelLabelNewWindow").window({
				onLoad :function(){
					var data = $("#packingLabelLtcList").datagrid("getSelections")[0];
					$('#new_ltc').textbox('textbox').css('background','#ccc');
					$('#new_materialLot').textbox('textbox').css('background','#ccc');
					$('#new_ubotPn').textbox('textbox').css('background','#ccc');
					$('#new_machine').textbox('textbox').css('background','#ccc');
					$('#new_desc').textbox('textbox').css('background','#ccc');
					$('#new_puchingTool').textbox('textbox').css('background','#ccc');
					$('#new_lane').textbox('textbox').css('background','#ccc');
					$('#new_formingTool').textbox('textbox').css('background','#ccc');
					$('#new_joNo').textbox('textbox').css('background','#ccc');
					$('#new_scittingTool').textbox('textbox').css('background','#ccc');
					$('#new_customerName').textbox('textbox').css('background','#ccc');
					$('#new_custPn').textbox('textbox').css('background','#ccc');
					$('#new_custPn').textbox('textbox').css('background','#ccc');
					
					$("#reelLabelNewFrom").form("load",data);
				}
        	}).window("open");
		} */
		
		/* function getSelectionsIds(){
	    	var List = $("#packingLabelLtcList");
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
	    	var data = $("#packingLabelLtcList").datagrid("getSelected");
	    	return data;
	    }
		
	</script>
