<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="margin: 10px">
	<form id="customerPnAddFrom">
		<table>
			<tr>
				<td>UBoT P/N : </td>
				<td><input class="easyui-combobox" id="pn_add" name="pn" data-options="valueField:'id',textField:'text',url:'../product/getProductPn',editable:false,required:true,onChange:pnChange" style="width: 200px"></td>
			</tr>
			<tr>
				<td>Customer Name : </td>
				<td><input class="easyui-combobox" name="customerName" data-options="valueField:'id',textField:'text',url:'getCustomerName',editable:false,required:true" style="width: 200px"></td>
			</tr>
			<tr>
				<td>Customer P/N : </td>
				<td><input class="easyui-textbox" name="customerPn" style="width: 300px" data-options="required:true,validType:['lettersAndNumber','length[0,20]']"></td>
			</tr>
			<tr>
				<td>Requirement : </td>
				<td><input class="easyui-textbox" id="requirement" name="requirement" style="height:150px;width: 300px" data-options="multiline:true,validType:['length[0,300]']"></td>
			</tr>
		</table>
	</form>
	
	<div style="margin-top: 20px">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">Submit</a>
		&nbsp;&nbsp;  
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width: 80px">Clear</a>
	</div>
</div>



<script type="text/javascript">

	function pnChange(pn){
		$.get("../product/getRequirementByPn?pn="+pn,function(result){
			$("#requirement").textbox('setValue',result.data);
		});
	}

	function submitForm(){
        var validate = $("#customerPnAddFrom").form('validate');
        if (!validate) {
			$("#customerPnAddFrom").find(".validatebox-invalid:first").focus();
            return false;
        }
        
        $.ajax({
            url: 'addCustomerPn',
            type: "Post",
            data: JSON.stringify($("#customerPnAddFrom").serializeJSON()),
            contentType: "application/json;charset=UTF-8",
            success: function (result) {
				if(result.status == 200){
					$.messager.alert("Message", "successfully!");
					$('#customerPnList').datagrid('reload');
					$('#customerPnAddWindow').window('close');
				}else{
					$.messager.alert("Message", "Fail!");
				}          
            }
        });
        
	}
	
	function clearForm(){
	    $('#customerPnAddFrom').form('clear');
	}
</script>
