<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<div style="margin: 20px 75px" >
		<form id="shippingLabelDetailsFrom">
			<input type="hidden" name="id" id="details_id"/>
			<table>
				<tr>
					<td>Ship'G Lot # : </td>
					<td><input class="easyui-textbox" name="shipLot" id="details_shipLot" data-options="readonly:true" style="width: 200px"></td>
					<td>Ship Date # : </td>
					<td><input class="easyui-textbox" name="shipDate" id="details_shipDate" data-options="readonly:true" style="width: 200px"></td>
					<!-- <td><input class="easyui-datebox" name="shipDate" id="details_shipDate" data-options="editable:false,formatter:myformatter,parser:myparser,required:true" style="width: 200px"></td> -->
					<td>Cartons # : </td>
					<td><input class="easyui-textbox" name="cartons" id="details_cartons" data-options="readonly:true" style="width: 200px"></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div style="margin-top: 20px" align="center">
		<table id="shippingLabelDetailsList"></table>
	</div>
	
	<div id="shippingLabelAddWindow" class="easyui-window" title="Shipping Label Add" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/shipping/shippingLabel-add'" style="width:1400px;height:800px;padding:10px;"></div>
	<div id="shippingLabelEditWindow" class="easyui-window" title="Shipping Label Edit" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/shipping/shippingLabel-edit'" style="width:400px;height:400px;padding:10px;"></div>
	
	<script type="text/javascript"> 
	function shippingLabelDetailsFunction(id){
		$('#shippingLabelDetailsList').datagrid({
			title: '',  																//表格名称
			width:1480,   																//表格宽度
			border:true,  																//表格是否显示边框
			url:"listShippingLabel2?id="+id+"&time="+new Date(),						//获取表格数据时请求的地址
			columns:[[
				{field:'id',title:'id',hidden:true},
				{field:'item',title:'Item',align:'center',width:50},
                {field:'tpo',title:'TPO #',align:'center',width:200},
                {field:'ubotPn',title:'P/N',align:'center',width:200},
				{field:'desc',title:'DWG NO.',align:'center',width:200},
				{field:'uom',title:'UOM',align:'center',width:100},
				{field:'qty',title:'QTY',align:'right',width:100,
					formatter: function (val, row) {
						return val.toString().replace(/(\d)(?=(?:\d{3})+$)/g, '$1,');
					}
				},
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
			singleSelect:false,					//设置单选
			idField: 'id',						//表明该列是一个唯一列
			loadMsg:'Data Loading...',   		//加载数据时显示提示信息
			frozenColumns: [[  					//固定在表格左侧的栏
				{field: 'ck', checkbox: true},
			]],
			showFooter: true,
			toolbar: [{
		        text:'Add',
		        iconCls:'icon-add',
		        handler:function(){
		        	$("#shippingLabelAddWindow").window({
		        		onLoad :function(){
							var row = $('#shippingLabelDetailsList').datagrid('getData').rows[0];
							shippingLabelAddFunction(row.tpo,$("#details_id").val());
						}
		        	}).window("open");
		        }
		    }, {
		        text:'Remove',
		        iconCls:'icon-remove',
		        handler:function(){
		        	var list = $("#shippingLabelDetailsList").datagrid("getSelections");
		        	//console.log(list);
		        	if(list.length == 0){
		    			$.messager.alert('Message','Please select data!');
		    			return;
		    		}
		        	$.messager.confirm('Missage','Are you sure to remove it?',function(r) {
						if (r) {
							$.ajax({
	    						type : 'POST',
	    						url : "deleteShippingLabel2", 
	    						data : '{"listShippingLabel2":'+JSON.stringify(list)+'}',
	    						dataType : "json",
	    						contentType : "application/json;charset=UTF-8",
	    						success : function(result) {
	    							$('#shippingLabelList').datagrid('reload');
	    							if(result.data == "noData"){
	    								$('#shippingLabelDetailsWindow').window('close');
	    							}else{
	    								$('#shippingLabelDetailsList').datagrid('reload');
	    							}
	    						}
	    					});
						}
					});
		        }
		    },{
		        text:'Edit',
		        iconCls:'icon-edit',
		        handler:function(){
		        	$("#shippingLabelEditWindow").window({
		        		onLoad :function(){
							//var row = $('#shippingLabelDetailsList').datagrid('getData').rows[0];
							//shippingLabelAddFunction(row.tpo,$("#details_id").val());
		        			var data = $("#shippingLabelList").datagrid("getSelections")[0];
		        			$('#edit_shipLot').textbox('textbox').css('background','#ccc');
		        			$("#shippingLabelEditFrom").form("load",data);
		        			$('#edit_updateBy').val("${subject.principal}");
						}
		        	}).window("open");
		        }
		    }]
		});		
	}
	
	//var addIndex = undefined;
	
	/* function addEditing() {
		if (addIndex == undefined) {
			return true
		}
		if ($('#shippingLabelDetailsList').datagrid('validateRow', addIndex)) {
			var ed = $('#shippingLabelDetailsList').datagrid('getEditor', {
				index : addIndex
				//field : 'ubotPn'
			});
			$('#shippingLabelDetailsList').datagrid('endEdit', addIndex);
			addIndex = undefined;
			return true;
		} else {
			return false;
		}
	} */
	
	/* function append() {
		if (addEditing()) {
			$('#shippingLabelDetailsList').datagrid('appendRow', {
				//ubotJo : $("#joNo_details").html(),
				uom : "Meter",
				status : 1,
				tid : $("#shippingLabelDetailsList").datagrid('getData').rows[0].tid
				//createBy : "${subject.principal}"
			});
			addIndex = $('#shippingLabelDetailsList').datagrid('getRows').length - 1;
			$('#shippingLabelDetailsList').datagrid('selectRow', addIndex).datagrid('beginEdit', addIndex);
		}
	} */
	
	/* function accept() {
		if ($('#shippingLabelDetailsList').datagrid('getRows').length == 0) {
			return;
		}
		if (addEditing()) {
			$.messager.confirm('Missage','Are you sure to submit it?',function(r) {
				if (r) {
					var rows = $('#shippingLabelDetailsList').datagrid('getChanges');
					$.ajax({
						type : 'POST',
						url : "addTpo",
						data : '{"listTpo":'+JSON.stringify(rows)+',"updateBy":"${subject.principal}"}',
						dataType : "json",
						contentType : "application/json;charset=UTF-8",
						success : function(result) {
							
						}
					});
					$('#tpoList').datagrid('reload');
					$('#shippingLabelDetailsList').datagrid('reload');
				}
			});
		}
	} */

	/* function onSelectPn2(selected) {
		
		if (selected == undefined) {
			return;
		}
		var ubotPn = selected.id;
		var row = $('#shippingLabelDetailsList').datagrid('getSelected');
		//获取行号 
		var rowIndex = $('#shippingLabelDetailsList').datagrid('getRowIndex', row);
		var dwgNoEditor = $('#shippingLabelDetailsList').datagrid('getEditor', {index : rowIndex,field : 'desc'});
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

	/* function cellStyler(){
		return 'background-color:#ffee00;color:red;';
	} */
		
	</script>
