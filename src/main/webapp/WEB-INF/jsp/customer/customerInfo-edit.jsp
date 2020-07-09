<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="margin: 10px">
	<form id="customerInfoEditFrom">
		<input type="hidden" name="id"/>
		<table>
			<tr>
				<td>Customer ID : </td>
				<td><input class="easyui-textbox" name="customerId" id="edit_customerId" style="width: 200px" data-options="required:true,readonly:true,validType:['length[0,10]']"></td>
			</tr>
			<tr>
				<td>Customer Name : </td>
				<td><input class="easyui-textbox" name="customerName" style="width: 200px" data-options="required:true,validType:['capitalLetter','length[0,10]']"></td>
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

	function submitForm(){
        var validate = $("#customerInfoEditFrom").form('validate');
        if (!validate) {
			$("#customerInfoEditFrom").find(".validatebox-invalid:first").focus();
            return false;
        }
        
        $.ajax({
            url: 'updateCustomerInfo',
            type: "Post",
            data: JSON.stringify($("#customerInfoEditFrom").serializeJSON()),
            contentType: "application/json;charset=UTF-8",
            success: function (result) {
				if(result.status == 200){
					$.messager.alert("Message", "successfully!");
					$('#customerInfoList').datagrid('reload');
					$('#customerInfoEditWindow').window('close');
				}else{
					$.messager.alert("Message", "Fail! Duplicate ID Or Name!");
				}          
            }
        });
        
	}
	
	/* function clearForm(){
	    $('#customerInfoEditFrom').form('clear');
	} */
</script>
