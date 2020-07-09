<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="margin: 10px">
	<form id="customerPnEditFrom">
		<input type="hidden" name="id" >
		<table>
			<tr>
				<td>UBoT P/N : </td>
				<td><input class="easyui-textbox" name="pn" id="pn_edit" style="width: 300px" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Customer Name : </td>
				<td><input class="easyui-textbox" name="customerName" id="customerName_edit" style="width: 300px" readonly="readonly"></td>
			</tr>
			<tr>
				<td>Customer P/N : </td>
				<td><input class="easyui-textbox" name="customerPn" style="width: 300px" data-options="required:true,validType:['lettersAndNumber','length[0,20]']"></td>
			</tr>
			<tr>
				<td>Requirement : </td>
				<td><input class="easyui-textbox" name="requirement" style="height:150px;width: 300px" data-options="multiline:true,validType:['length[0,300]']"></td>
			</tr>
		</table>
	</form>
	
	<div style="margin-top: 20px">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">Submit</a>
	</div>
</div>



<script type="text/javascript">

	function submitForm(){
        var validate = $("#customerPnEditFrom").form('validate');
        if (!validate) {
			$("#customerPnEditFrom").find(".validatebox-invalid:first").focus();
            return false;
        }
        
        $.ajax({
            url: 'updateCustomerPn',
            type: "Post",
            data: JSON.stringify($("#customerPnEditFrom").serializeJSON()),
            contentType: "application/json;charset=UTF-8",
            success: function (result) {
				if(result.status == 200){
					$.messager.alert("Message", "successfully!");
					$('#customerPnList').datagrid('reload');
					$('#customerPnEditWindow').window('close');
				}else{
					$.messager.alert("Message", "Fail! Duplicate P/N!");
				}          
            }
        });
        
	}
	
</script>
