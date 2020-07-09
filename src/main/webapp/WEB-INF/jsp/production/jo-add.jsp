<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="margin: 10px">
	<form id="joAddFrom">
		<input type="hidden" name="ubotJo" id="joAdd_ubotJo"/>
		<input type="hidden" name="createBy" value="${subject.principal}"/>
		<table>
			<tr>
				<td>UBoT P/N : </td>
				<td><input class="easyui-combobox" name="ubotPn" id="joAdd_ubotPn" data-options="valueField:'id',textField:'text',url:'../product/getProductPn',editable:false,required:true,onChange:pnChange" style="width: 200px"></td>
			</tr>
			<tr>
				<td>DWG NO. : </td>
				<td><input class="easyui-textbox" name="desc" id="joAdd_desc" style="width: 200px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>Customer Name : </td>
				<td><input class="easyui-combobox" name="customerName" id="joAdd_customerName" data-options="valueField:'id',textField:'text',url:'../customer/getCustomerName',editable:false,required:true,onChange:CustomerNameChange" style="width: 200px"></td>
			</tr>
			<tr>
				<td>Customer P/N : </td>
				<td><input class="easyui-textbox" name="custPn" id="joAdd_custPn" style="width: 200px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>UOM : </td>
				<td><input class="easyui-textbox" name="uom" id="joAdd_uom" value="Meter" style="width: 200px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>QTY : </td>
				<td><input class="easyui-textbox" name="orderQuantity" style="width: 200px" data-options="required:true,validType:['double_','length[1,10]']"></td>
			</tr>
			<tr>
				<td>Finish Date : </td>
				<td><input class="easyui-datebox" name="date" style="width: 200px" data-options="editable:false,formatter:myformatter,parser:myparser"></td>
			</tr>
			<tr>
				<td>Requirement:</td>
				<td><input class="easyui-textbox" name="remarks" id="joAdd_remarks" style="height:150px;width: 300px" data-options="multiline:true,validType:['length[0,300]']"></td>
			</tr>
		</table>
	</form>
	
	<div style="margin-top: 20px">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">Submit</a>
		<!-- &nbsp;&nbsp;  
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width: 80px">Clear</a> -->
	</div>
</div>



<script type="text/javascript">

	function pnChange(pn){
		// 根据PN获取DWG NO.
		$.ajax({
			type: 'POST',
			url: "../product/getDwgNoByPn",
			data:'{"pn":"'+pn+'"}',
			dataType: "json",
			contentType: "application/json;charset=UTF-8",
			success: function(result){
				$('#joAdd_desc').textbox('setValue', result.data);
			}
		});
		
		// 如果customerName不为空则查询customer P/N
		var customerName = $('#joAdd_customerName').val();
		if("" != customerName){
			// 根据pn和customerName获取Customer PN
			$.ajax({
				type: 'POST',
				url: "../customer/getCustomerInfo",
				data: '{"pn":"'+pn+'","customerName":"'+customerName+'"}',
				dataType: "json",
				contentType: "application/json;charset=UTF-8",
				success: function(result){
					if(null == result.data){
						$('#joAdd_custPn').textbox('setValue', '');
						$('#joAdd_remarks').textbox('setValue', '');
						return;
					}
					if(null != result.data.customerPn){
						$('#joAdd_custPn').textbox('setValue', result.data.customerPn);
					}else{
						$('#joAdd_custPn').textbox('setValue', '');
					}
					if(null != result.data.requirement){
						$('#joAdd_remarks').textbox('setValue', result.data.requirement);
					}else{
						$('#joAdd_remarks').textbox('setValue', '');
					}
				}
			});
		}
	}
	
	function CustomerNameChange(customerName){
		var ubotPn = $('#joAdd_ubotPn').val();
		if("" != ubotPn){
			// 根据pn和customerName获取Customer PN
			$.ajax({
				type: 'POST',
				url: "../customer/getCustomerInfo",
				data: '{"pn":"'+ubotPn+'","customerName":"'+customerName+'"}',
				dataType: "json",
				contentType: "application/json;charset=UTF-8",
				success: function(result){
					if(null == result.data){
						$('#joAdd_custPn').textbox('setValue', '');
						$('#joAdd_remarks').textbox('setValue', '');
						return;
					}
					if(null != result.data.customerPn){
						$('#joAdd_custPn').textbox('setValue', result.data.customerPn);
					}else{
						$('#joAdd_custPn').textbox('setValue', '');
					}
					if(null != result.data.requirement){
						$('#joAdd_remarks').textbox('setValue', result.data.requirement);
					}else{
						$('#joAdd_remarks').textbox('setValue', '');
					}
				}
			});
		}
	}

	function submitForm(){
        var validate = $("#joAddFrom").form('validate');
        if (!validate) {
			$("#joAddFrom").find(".validatebox-invalid:first").focus();
            return false;
        }
        console.log(JSON.stringify($("#joAddFrom").serializeJSON()));
        $.ajax({
            url: 'addJO',
            type: "Post",
            data: JSON.stringify($("#joAddFrom").serializeJSON()),
            contentType: "application/json;charset=UTF-8",
            success: function (result) {
				if(result.status == 200){
					$.messager.alert("Message", "successfully!");
					$('#joList').datagrid('reload');
					$('#joNewList').datagrid('reload');
					$('#joDetailsList').datagrid('reload');
				}else{
					$.messager.alert("Message", "Fail!");
				}          
            }
        });
        
	}
	
	/* function clearForm(){
	    $('#joAddFrom').form('clear');
	} */
</script>