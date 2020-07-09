<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- <div id="tpoAddWindow" class="easyui-window" title="TPO Add" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/shipping/tpo-add'" style="width:600px;height:600px;padding:10px;"></div> --%>
	<div style="margin-top: 10px" align="center">
		<form id="tpoDetailsFrom">
			<table>
				<tr>
					<td>Customer : </td>
					<td width="400px"><input class="easyui-textbox" name="customer" id="details_customer" data-options="readonly:true" style="width: 200px"></td>
					<td>TPO # : </td>
					<td><input class="easyui-textbox" name="tpo" id="details_tpo" data-options="readonly:true" style="width: 200px"></td>	
				</tr>
				<tr>
					<td>Bill To : </td>
					<td width="400px"><input class="easyui-textbox" name="billTo" id="details_billTo" data-options="readonly:true" style="width: 200px"></td>
					<td>Customer PO # : </td>
					<td width="400px"><input class="easyui-textbox" name="customerPo" id="details_customerPo" data-options="readonly:true" style="width: 200px"></td>	
				</tr>
				<tr>
					<td>Ship To : </td>
					<td width="400px"><input class="easyui-textbox" name="shipTo" id="details_shipTo" data-options="readonly:true" style="width: 200px"></td>	
					<td>Date : </td>
					<td width="400px"><input class="easyui-textbox" name="createDate" id="details_createDate" data-options="readonly:true" style="width: 200px"></td>	
				</tr>
				
				<tr>
					<td>Remark : </td>
					<td width="400px"><input class="easyui-textbox" name="remark" id="details_remark" data-options="readonly:true" style="width: 380px"></td>	
					<td>Terms : </td>
					<td width="400px"><input class="easyui-textbox" name="terms" id="details_terms" data-options="readonly:true" style="width: 380px"></td>	
				</tr>
				
				<tr>
					<td>ShipMode : </td>
					<td width="400px"><input class="easyui-textbox" name="shipmode" id="details_shipmode" data-options="readonly:true" style="width: 380px"></td>	
					<td>Required Shipdate : </td>
					<td width="400px"><input class="easyui-textbox" name="requiredShipdate" id="details_requiredShipdate" data-options="readonly:true" style="width: 380px"></td>	
				</tr>
			</table>
		</form>
	</div>
	
	<div style="margin-top: 20px" align="center">
		<table id="tpoDetailsList"></table>
	</div>
	
	<script type="text/javascript"> 
	function tpoDetailsFunction(id){
		$('#tpoDetailsList').datagrid({
			title: '',  																//表格名称
			width:1280,   																//表格宽度
			border:true,  																//表格是否显示边框
			url:"listTpo2?id="+id+"&time="+new Date(),								//获取表格数据时请求的地址
			columns:[[
				{field:'id',title:'id',hidden:true},
				{field:'tid',title:'tid',hidden:true},
				{field:'item',title:'Item',align:'center',width:50},
				{field:'ubotPn',title:'P/N',align:'center',width:200,editor:{
                    type:'combobox',
                    options:{
                        valueField:'id',
                        textField:'text',
                        url:'../product/getProductPn',
                        required:true,
                        onSelect : onSelectPn2,
                        editable : false
                    }
                }},
				{field:'desc',title:'DWG NO.',align:'center',width:200,editor:{type:'textbox',options:{readonly:true}}},
				{field:'uom',title:'UOM',align:'center',width:100,editor:{type:'textbox',options:{readonly:true}}},
				{field:'qty',title:'QTY',align:'right',width:100,editor:{type:'numberbox',options:{required:true}},
					formatter: function (val, row) {
						return val.toString().replace(/(\d)(?=(?:\d{3})+$)/g, '$1,');
					}
				},
				{field:'etdDate',title:'ETD Date',align:'center',width:150,editor:{type:'textbox',options:{readonly:false,required:true}}},
				{field:'requirement',title:'Requirement	',align:'center',width:450,editor:{type:'textbox',options:{readonly:false}}}
			]],
			pagination:true,					//如果表格需要支持分页，必须设置该选项为true
			pageSize:20,   						//表格中每页显示的行数
			pageList:[5,10,15,20],				//自定义表格选择要显示的行数
			rownumbers:false,   					//是否显示行号
			nowrap: false,   					
			striped: true,  					//奇偶行是否使用不同的颜色
			method:'get',  						//表格数据获取方式,请求地址是上面定义的url
			singleSelect:true,					//设置单选
			idField: 'id',						//表明该列是一个唯一列
			loadMsg:'Data Loading...',   		//加载数据时显示提示信息
			frozenColumns: [[  					//固定在表格左侧的栏
				{field: 'ck', checkbox: true},
			]],
			showFooter: true
		});		
	}

	function onSelectPn2(selected) {
		
		if (selected == undefined) {
			return;
		}
		var ubotPn = selected.id;
		var row = $('#tpoDetailsList').datagrid('getSelected');
		//获取行号 
		var rowIndex = $('#tpoDetailsList').datagrid('getRowIndex', row);
		var dwgNoEditor = $('#tpoDetailsList').datagrid('getEditor', {index : rowIndex,field : 'desc'});
		// 根据PN获取DWG NO.
		$.ajax({
			type : 'POST',
			url : "../product/getDwgNoByPn",
			data : '{"pn":"' + ubotPn + '"}',
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			success : function(result) {
				$(dwgNoEditor.target).textbox('setValue', result.data);
			}
		});
	}
		
	</script>
