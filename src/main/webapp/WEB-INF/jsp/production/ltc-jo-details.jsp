<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div style="margin-top: 20px" align="center">
		<table id="joDetailsList"></table>
	</div>
	<div id="ltcNewWindow" class="easyui-window" title="LTCNew" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/production/ltc-new'" style="width:900px;height:700px;padding:10px;" ></div>
	
	<script type="text/javascript"> 
		
		function joDetailsFunction(joNo){
			$('#joDetailsList').datagrid({
				title: '',  																//表格名称
				width:1330,   																//表格宽度
				border:true,  																//表格是否显示边框
				url:"listDetailsJO?joNo="+joNo,								//获取表格数据时请求的地址
				columns:[[
					{field:'id',title:'id',hidden:true},
					{field:'item',title:'Item',align:'center',width:50},
					{field:'ubotPn',title:'P/N',align:'center',width:200},
					{field:'ubotJo',title:'JO NO.',align:'center',width:150,hidden:true},
					{field:'desc',title:'DWG NO.',align:'center',width:200},
					{field:'customerName',title:'CustomerName',align:'center',width:150},
					{field:'custPn',title:'Customer P/N',align:'center',width:150},
					{field:'uom',title:'UOM',align:'center',width:100},
					{field:'orderQuantity',title:'QTY',align:'right',width:100},
					/* {field:'createTime',title:'Create Date',align:'center',width:150}, */
					{field:'date',title:'FinishDate',align:'center',width:150},
					{field:'remarks',title:'Requirement',align:'center',width:200}
				]],
				pagination:true,					//如果表格需要支持分页，必须设置该选项为true
				pageSize:20,   						//表格中每页显示的行数
				pageList:[5,10,15,20],				//自定义表格选择要显示的行数
				rownumbers:false,   					//是否显示行号
				nowrap: false,   					
				striped: true,  					//奇偶行是否使用不同的颜色
				method:'get',  						//表格数据获取方式,请求地址是上面定义的url
				//sortName: 'ID',  					//按照ID列的值排序
				//sortOrder: 'ubotJo',  				//使用倒序排序
				singleSelect:true,					//设置单选
				idField: 'id',						//表明该列是一个唯一列
				loadMsg:'Data Loading...',   		//加载数据时显示提示信息
				frozenColumns: [[  					//固定在表格左侧的栏
					{field: 'ck', checkbox: true},
				]],
				showFooter: true,
				toolbar: [{
			        text:'Select',
			        iconCls:'icon-add',
			        handler:function(){
						var ids = getSelectionsIds();
			        	if(ids.length == 0){
			        		$.messager.alert('Message','Please select one piece of data!');
			        		return;
			        	}
			        	$("#ltcNewWindow").window({
			        		onLoad :function(){
			        			
			        			// 获取所选行数据
			        			var data = $("#joDetailsList").datagrid("getSelections")[0];
			        			//回显数据
			        			$("#ltcNewFrom").form("load",data);
			        			
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
			        			$('#new_scittingTool').textbox('textbox').css('background','#ccc');
			        			
			        			
			        			
			        		}
			        	}).window("open");
			        }
			    },{text:'<span style="margin-left: 400px;color: red;font-weight: bold;">JO NO. : <span id="joNo_details">'+joNo+'</span></span>'}]
			});
		}
	
		function getSelectionsIds(){
	    	var List = $("#joDetailsList");
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
	    	var data = $("#joDetailsList").datagrid("getSelected");
	    	return data;
	    }
		
	</script>
