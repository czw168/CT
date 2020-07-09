<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="margin: 10px">
	<form id="joEditFrom">
		<input type="hidden" name="id"/>
		<input type="hidden" name="updateBy" id="joEdit_updateBy" />
		<table>
			<tr>
				<td>UBoT P/N : </td>
				<td><input class="easyui-combobox" name="ubotPn" id="joEdit_ubotPn" data-options="valueField:'id',textField:'text',url:'../product/getProductPn',editable:false,required:true,onChange:pnChange" style="width: 200px"></td>
			</tr>
			<tr>
				<td>DWG NO. : </td>
				<td><input class="easyui-textbox" name="desc" id="joEdit_desc" style="width: 200px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>Customer Name : </td>
				<td><input class="easyui-combobox" name="customerName" id="joEdit_customerName" data-options="valueField:'id',textField:'text',url:'../customer/getCustomerName',editable:false,required:true,onChange:CustomerNameChange" style="width: 200px"></td>
			</tr>
			<tr>
				<td>Customer P/N : </td>
				<td><input class="easyui-textbox" name="custPn" id="joEdit_custPn" style="width: 200px" data-options="readonly:true"></td>
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
				<td>Requirement : </td>
				<td><input class="easyui-textbox" name="remarks" style="height:150px;width: 300px" data-options="multiline:true,validType:['length[0,300]']"></td>
			</tr>
		</table>
	</form>
	
	<div style="margin-top: 20px">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">Save</a>
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
				$('#joEdit_desc').textbox('setValue', result.data);
			}
		});
		
		// 如果customerName不为空则查询customer P/N
		var customerName = $('#joEdit_customerName').val();
		console.log("customerName:"+customerName);
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
						$('#joEdit_custPn').textbox('setValue', "");
					}else{
						$('#joEdit_custPn').textbox('setValue', result.data.customerPn);
					}
				}
			});
		}
	}
	
	function CustomerNameChange(customerName){
		var ubotPn = $('#joEdit_ubotPn').val();
		console.log("ubotPn:"+ubotPn);
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
						$('#joEdit_custPn').textbox('setValue', "");
					}else{
						$('#joEdit_custPn').textbox('setValue', result.data.customerPn);
					}
					//$('#joEdit_custPn').textbox('setValue', result.data);
				}
			});
		}
	}

	function submitForm(){
        var validate = $("#joEditFrom").form('validate');
        if (!validate) {
			$("#joEditFrom").find(".validatebox-invalid:first").focus();
            return false;
        }
        
        $.ajax({
            url: 'updateJO',
            type: "Post",
            data: JSON.stringify($("#joEditFrom").serializeJSON()),
            contentType: "application/json;charset=UTF-8",
            success: function (result) {
				if(result.status == 200){
					$.messager.alert("Message", "successfully!");
					$('#joList').datagrid('reload');
					$('#joDetailsList').datagrid('reload');
					$('#joEditWindow').window('close');
				}else{
					$.messager.alert("Message", "Fail!");
				}          
            }
        });
        
	}
</script>
