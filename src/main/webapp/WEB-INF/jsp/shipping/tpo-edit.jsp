<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <div id="tpoAddWindow" class="easyui-window" title="TPO Add" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/shipping/tpo-add'" style="width:600px;height:600px;padding:10px;"></div>
    <div id="tpo2EditWindow" class="easyui-window" title="TPO Edit" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/shipping/tpo-tpo2-edit'" style="width:600px;height:500px;padding:10px;" ></div>
    
    <div style="margin: 20px 150px" >
		<form id="tpo1EditFrom">
			<input type="hidden" name="id"/>
			<input type="hidden" name="updateBy" value="${subject.principal}">
			<table>
				<tr>
					<td>Customer : </td>
					<td width="400px"><input class="easyui-combobox" name="customer" data-options="valueField:'id',textField:'text',url:'../customer/getCustomerName',editable:false,required:true" style="width: 200px"></td>
					<td>TPO # : </td>
					<td><input class="easyui-textbox" name="tpo" id="tpo1Edit_tpo" data-options="readonly:true" style="width: 200px"></td>	
				</tr>
				<tr>
					<td>Bill To : </td>
					<td><input class="easyui-combobox" name="billTo" data-options="valueField:'id',textField:'text',url:'../customer/getCustomerName',editable:false,required:true" style="width: 200px"></td>
					<td>Customer PO # : </td>
					<td><input class="easyui-textbox" name="customerPo" style="width: 200px"></td>	
				</tr>
				<tr>
					<td>Ship To : </td>
					<td><input class="easyui-combobox" name="shipTo" data-options="valueField:'id',textField:'text',url:'../customer/getCustomerName',editable:false,required:true" style="width: 200px"></td>
					<td>Date : </td>
					<td><input class="easyui-datebox" name="createDate" data-options="editable:true,formatter:myformatter,parser:myparser" style="width: 200px"></td>
				</tr>
				<tr>
					<td>Remark : </td>
					<td><input class="easyui-textbox" name="remark" data-options="" style="width: 380px"></td>
					<td>Terms : </td>
					<td><input class="easyui-textbox" name="terms" data-options="" style="width: 380px"></td>
				</tr>
				
				<tr>
					<td>ShipMode : </td>
					<td><input class="easyui-textbox" name="shipmode" data-options="" style="width: 380px"></td>
					<td>Required Shipdate : </td>
					<td><input class="easyui-textbox" name="requiredShipdate" data-options="" style="width: 380px"></td>
				</tr>
			</table>
		</form>
		<div style="margin-top: 20px">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">Submit</a>
		</div>
	</div>
    
    <hr/>
    
	<div style="margin-top: 20px" align="center">
		<table id="tpo2EditList"></table>
	</div>
	
	<script type="text/javascript"> 
		
		function tpoEditFunction(id){
			$('#tpo2EditList').datagrid({
				title: '',  																//表格名称
				width:1330,   																//表格宽度
				border:true,  																//表格是否显示边框
				url:"listTpo2?id="+id+"&time="+new Date(),									//获取表格数据时请求的地址
				columns:[[
					{field:'id',title:'id',hidden:true},
					{field:'tid',title:'tid',hidden:true},
					{field:'item',title:'Item',align:'center',width:50},
					{field:'ubotPn',title:'P/N',align:'center',width:150},
					{field:'desc',title:'DWG NO',align:'center',width:200,editor:{type:'textbox',options:{readonly:true}}},
					{field:'uom',title:'UOM',align:'center',width:150,editor:{type:'textbox',options:{readonly:false}}},
					{field:'qty',title:'QTY',align:'right',width:150,editor:{type:'numberbox',options:{required:true}},
						formatter: function (val, row) {
							return val.toString().replace(/(\d)(?=(?:\d{3})+$)/g, '$1,');
						}
					},						
					{field:'etdDate',title:'ETD Date',align:'center',width:150,editor:{type:'textbox',options:{readonly:false}}},
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
				showFooter: true,
				toolbar: [{
			        text:'Add',
			        iconCls:'icon-add',
			        handler:function(){
			        	$("#tpoAddWindow").window({
			        		onLoad :function(){
			        			$("#tpoAdd_tid").val(id);
			        			$('#tpoAdd_desc').textbox('textbox').css('background','#ccc');
			        			$('#tpoAdd_uom').textbox('textbox').css('background','#ccc');
			        		}
			        	}).window("open");
			        }
			    },{
			        text:'Edit',
			        iconCls:'icon-edit',
			        handler:function(){
				    	var sel = $("#tpo2EditList").datagrid("getSelections");
				    	if(sel.length == 0){
			        		$.messager.alert('Message','Please select one piece of data!');
			        		return;
			        	}
			        	$("#tpo2EditWindow").window({
			        		onLoad :function(){
			        			var data = $("#tpo2EditList").datagrid("getSelected");
			        			$("#tpo2EditFrom").form("load",data);
			        			$('#tpo2Edit_desc').textbox('textbox').css('background','#ccc');
			        			$('#tpo2Edit_uom').textbox('textbox').css('background','#ccc');
			        		}
			        	}).window("open");
			        }
			    }]
			});
		}
		
		function submitForm(){
	        var validate = $("#tpo1EditFrom").form('validate');
	        if (!validate) {
				$("#tpo1EditFrom").find(".validatebox-invalid:first").focus();
	            return false;
	        }
	        console.log(JSON.stringify($("#tpo1EditFrom").serializeJSON()));
	        $.ajax({
	            url: 'updateTpo1',
	            type: "Post",
	            data: '{"tpo1":'+JSON.stringify($("#tpo1EditFrom").serializeJSON())+'}',
	            contentType: "application/json;charset=UTF-8",
	            success: function (result) {
					if(result.status == 200){
						$.messager.alert("Message", "successfully!");
						//tpo2NewFunction(result.data);
					}else{
						$.messager.alert("Message", "Fail!");
					}          
	            }
	        });
	        
		}
		
	</script>
