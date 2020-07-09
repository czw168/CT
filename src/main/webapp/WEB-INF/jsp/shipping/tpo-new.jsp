<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div id="tpoAddWindow" class="easyui-window" title="TPO Add" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/shipping/tpo-add'" style="width:600px;height:600px;padding:10px;"></div>
	<div style="margin-top: 10px" align="center">
		<form id="tpo1NewFrom">
			<input type="hidden" name="createBy" value="${subject.principal}"/>
			<table>
				<tr>
					<td>Customer : </td>
					<td width="400px"><input class="easyui-combobox" name="customer" data-options="valueField:'id',textField:'text',url:'../customer/getCustomerName',editable:false,required:true" style="width: 200px"></td>
					<td>TPO # : </td>
					<td><input class="easyui-textbox" name="tpo" id="new_tpo" data-options="readonly:true" style="width: 200px"></td>	
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
					<td><input class="easyui-datebox" name="createDate" id="new_createDate" data-options="editable:false,formatter:myformatter,parser:myparser" style="width: 200px"></td>
				</tr>
				<tr>
					<td>Remark : </td>
					<td width="400px"><input class="easyui-textbox" name="remark" data-options="readonly:false" style="width: 380px"></td>	
					<td>Terms : </td>
					<td width="400px"><input class="easyui-textbox" name="terms" data-options="readonly:false" style="width: 380px"></td>	
				</tr>
				<tr>
					<td>ShipMode : </td>
					<td width="400px"><input class="easyui-textbox" name="shipmode" data-options="readonly:false" style="width: 380px"></td>	
					<td>Required Shipdate : </td>
					<td width="400px"><input class="easyui-textbox" name="requiredShipdate" data-options="readonly:false" style="width: 380px"></td>	
				</tr>
			</table>
		</form>
		<div id="tpoNewSubmit" style="margin-top: 20px">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">Submit</a>
		</div>
	</div>
	
	<div style="margin-top: 20px" align="center">
		<table id="tpo2NewList"></table>
	</div>
	
	<script type="text/javascript">
	
	function submitForm(){
		//隐藏div
		$("#tpoNewSubmit").attr("style","display:none;");
		
        var validate = $("#tpo1NewFrom").form('validate');
        if (!validate) {
			$("#tpo1NewFrom").find(".validatebox-invalid:first").focus();
            return false;
        }
       // console.log(JSON.stringify($("#tpo1NewFrom").serializeJSON()));
        $.ajax({
            url: 'newTpo1',
            type: "Post",
            data: '{"tpo1":'+JSON.stringify($("#tpo1NewFrom").serializeJSON())+'}',
            contentType: "application/json;charset=UTF-8",
            success: function (result) {
				if(result.status == 200){
					tpo2NewFunction(result.data);
				}else{
					$.messager.alert("Message", "Fail!");
				}          
            }
        });
	}
	
	function tpo2NewFunction(id){
		$('#tpo2NewList').datagrid({
			title: '',  																//表格名称
			width:1280,   																//表格宽度
			border:true,  																//表格是否显示边框
			url:"listTpo2?id="+id+"&time="+new Date(),								//获取表格数据时请求的地址
			columns:[[
				{field:'id',title:'id',hidden:true},
				{field:'tid',title:'tid',hidden:true},
				{field:'item',title:'Item',align:'center',width:50},
				{field:'ubotPn',title:'P/N',align:'center',width:200},
				{field:'desc',title:'DWG NO.',align:'center',width:200,editor:{type:'textbox',options:{readonly:true}}},
				{field:'uom',title:'UOM',align:'center',width:100,editor:{type:'textbox',options:{readonly:true}}},
				{field:'qty',title:'QTY',align:'right',width:100,editor:{type:'numberbox',options:{required:true}}},
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
			showFooter: true,
			toolbar: [{
		        text:'Add',
		        iconCls:'icon-add',
		        handler:function(){
		        	//append();
		        	$("#tpoAddWindow").window({
		        		onLoad :function(){
		        			//var row = $('#tpo2NewList').datagrid('getData').rows[0];
		        			//$("#tpoAdd_tid").val(row.tid);
		        			//$('#tpoAdd_desc').textbox('textbox').css('background','#ccc');
		        			//$('#tpoAdd_uom').textbox('textbox').css('background','#ccc');
		        			$('#tpoAdd_desc').textbox('textbox').css('background','#ccc');
		        			$('#tpoAdd_uom').textbox('textbox').css('background','#ccc');
		        			$("#tpoAdd_tid").val(id);
		        		}
		        	}).window("open");
		        }
		    }]
		});		
	}
		
	</script>
