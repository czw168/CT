<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- <div style="margin: 20px 150px" >
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
	</div> -->
	
	<input type="hidden" id="new_tpo"/>
	
	<div style="margin: 20px 150px" >
		<form id="shippingLabelNewFrom">
			<input type="hidden" name="createBy" value="${subject.principal}"/>
			<table>
				<tr>
					<td>Ship'G Lot # : </td>
					<td><input class="easyui-textbox" name="shipLot" id="new_shipLot" value="new" data-options="readonly:true" style="width: 200px"></td>
					<td>Ship Date : </td>
					<td><input class="easyui-datebox" name="shipDate" data-options="editable:false,formatter:myformatter,parser:myparser,required:true" style="width: 200px"></td>
					<td>Cartons : </td>
					<td><input class="easyui-textbox" name="cartons" data-options="required:true" style="width: 200px"></td>	
				</tr>
			</table>
		</form>
	</div>
	
	<div style="margin-top: 20px" align="center">
		<table id="tpoDetailsList"></table>
	</div>
	<div id="tpoEditWindow" class="easyui-window" title="JOEdit" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/shipping/tpo-edit'" style="width:600px;height:500px;padding:10px;" ></div>
	
	<script type="text/javascript"> 
		
		function tpoDetailsFunction(id){
			$('#tpoDetailsList').datagrid({
				title: '',  																//表格名称
				width:1330,   																//表格宽度
				border:true,  																//表格是否显示边框
				url:"listNotToChooseTpo2?id="+id+"&time="+new Date(),						//获取表格数据时请求的地址
				columns:[[
					/* {field:'id',title:'id',hidden:true},
					{field:'tid',title:'tid',hidden:true},
					{field:'item',title:'Item',align:'center',width:50},
					{field:'ubotPn',title:'P/N',align:'center',width:150,editor:{
                        type:'combobox',
                        options:{
                            valueField:'id',
                            textField:'text',
                            url:'../product/getProductPn',
                            required:true,
                            onSelect : onSelectPn1,
                            editable : false
                        }
					}},
					{field:'desc',title:'DWG NO',align:'center',width:200,editor:{type:'textbox',options:{readonly:true}}},
					{field:'uom',title:'UOM',align:'center',width:150,editor:{type:'textbox',options:{readonly:false}}},
					{field:'qty',title:'QTY',align:'center',width:150,editor:{type:'numberbox',options:{required:true}}},
					{field:'etdDate',title:'ETD Date',align:'center',width:150,editor:{type:'textbox',options:{readonly:false}}},
					{field:'requirement',title:'Requirement	',align:'center',width:450,editor:{type:'textbox',options:{readonly:false}}} */
					{field:'id',title:'id',hidden:true},
					{field:'tid',title:'tid',hidden:true},
					{field:'item',title:'Item',align:'center',width:50},
					{field:'ubotPn',title:'P/N',align:'center',width:150},
					{field:'desc',title:'DWG NO',align:'center',width:200},
					{field:'uom',title:'UOM',align:'center',width:150},
					{field:'qty',title:'QTY',align:'center',width:150},
					{field:'etdDate',title:'ETD Date',align:'center',width:150},
					{field:'requirement',title:'Requirement	',align:'center',width:450}
				]],
				pagination:true,					//如果表格需要支持分页，必须设置该选项为true
				pageSize:20,   						//表格中每页显示的行数
				pageList:[5,10,15,20],				//自定义表格选择要显示的行数
				rownumbers:false,   				//是否显示行号
				nowrap: false,   					
				striped: true,  					//奇偶行是否使用不同的颜色
				method:'get',  						//表格数据获取方式,请求地址是上面定义的url
				//sortName: 'ID',  					//按照ID列的值排序
				//sortOrder: 'ubotJo',  			//使用倒序排序
				singleSelect:false,					//设置单选
				idField: 'id',						//表明该列是一个唯一列
				loadMsg:'Data Loading...',   		//加载数据时显示提示信息
				frozenColumns: [[  					//固定在表格左侧的栏
					{field: 'ck', checkbox: true},
				]],
				//onClickRow: onClickRow2,
				showFooter: true,
				toolbar: [/* {
			        text:'Add',
			        iconCls:'icon-add',
			        handler:function(){
			        	append();
			        }
			    }, */{
			        text:'Save',
			        iconCls:'icon-save',
			        handler:function(){
			        	accept1();
			        }
			    }]
			});
		}
		
	//var addIndex1 = undefined;
		
	/* function addEditing1() {
		if (addIndex1 == undefined) {
			return true
		}
		if ($('#tpoDetailsList').datagrid('validateRow', addIndex1)) {
			var ed = $('#tpoDetailsList').datagrid('getEditor', {
				index : addIndex1,
				field : 'ubotPn'
			});
			$('#tpoDetailsList').datagrid('endEdit', addIndex1);
			addIndex1 = undefined;
			return true;
		} else {
			return false;
		}
	} */

	/* function append() {
		if (addEditing1()) {
			// 获取第一行数据
			var data = $("#tpoDetailsList").datagrid('getData').rows[0];
			$('#tpoDetailsList').datagrid('appendRow', {
				uom : "Meter",
				tid : data.tid
			});
			addIndex1 = $('#tpoDetailsList').datagrid('getRows').length - 1;
			$('#tpoDetailsList').datagrid('selectRow', addIndex1).datagrid('beginEdit', addIndex1);
		}
	} */
	
	/* function getSelectionsIds2(){
    	var List = $("#tpoDetailsList");
    	var sels = List.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	console.log(ids);
    	return ids;
    } */
	
	function accept1() {
		
		var validate = $("#shippingLabelNewFrom").form('validate');
        if (!validate) {
			//$("#shippingLabelNewFrom").find(".validatebox-invalid:first").focus();
			$.messager.alert('Message','Please complete the form!');
            return false;
        }
        
		var list = $("#tpoDetailsList").datagrid("getSelections");
		//console.log(list);
		if(list.length == 0){
			$.messager.alert('Message','Please select data!');
			return;
		}
		
		$.messager.confirm('Missage','Are you sure to submit it?',function(r) {
			if (r) {
				//var rows = $('#tpoDetailsList').datagrid('getChanges');
				var data = $('#tpoDetailsList').datagrid('getData').rows[0];
				//console.log(data);
				$.ajax({
					type : 'POST',
					url : "newShippingLabel",
					data : '{"listShippingLabel2":'+JSON.stringify(list)+',"shippingLabelNewFrom":'+JSON.stringify($("#shippingLabelNewFrom").serializeJSON())+',"tpo":"'+$("#new_tpo").val()+'","tid":"'+data.tid+'"}',
					dataType : "json",
					contentType : "application/json;charset=UTF-8",
					success : function(result) {
						$('#shippingLabelList').datagrid('reload');
						$('#shippingLabelTpoNewWindow').window('close');
						$('#tpoDetailsWindow').window('close');
					}
				});
				
			}
		});
	}

	/* function onSelectPn1(selected) {
		
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

	} */
		
	</script>
