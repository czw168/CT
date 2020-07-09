<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="margin: 10px">
	<form id="shippingLabelEditFrom">
			<input type="hidden" name="id" id="edit_id"/>
			<input type="hidden" name="updateBy" id="edit_updateBy"/>
			<table>
				<tr>
					<td>Ship'G Lot # : </td>
					<td><input class="easyui-textbox" name="shipLot" id="edit_shipLot" data-options="readonly:true" style="width: 200px"></td>
				</tr>
				<tr>
					<td>Ship Date # : </td>
					<td><input class="easyui-datebox" name="shipDate" id="edit_shipDate" data-options="editable:false,formatter:myformatter,parser:myparser,required:true" style="width: 200px"></td>
				</tr>
				<tr>
					<td>Cartons # : </td>
					<td><input class="easyui-textbox" name="cartons" id="edit_cartons" data-options="required:true" style="width: 200px"></td>
				</tr>
			</table>
		</form>
	
	<div style="margin-top: 20px">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">Submit</a>
	</div>
</div>



<script type="text/javascript">

	function submitForm(){
        var validate = $("#shippingLabelEditFrom").form('validate');
        if (!validate) {
			$("#shippingLabelEditFrom").find(".validatebox-invalid:first").focus();
            return false;
        }
        
        $.ajax({
            url: 'updateShippingLabel1',
            type: "Post",
            data: JSON.stringify($("#shippingLabelEditFrom").serializeJSON()),
            contentType: "application/json;charset=UTF-8",
            success: function (result) {
				if(result.status == 200){
					$.messager.alert("Message", "successfully!");
					$('#shippingLabelEditWindow').window('close');
					$('#shippingLabelDetailsList').datagrid('reload');
				}else{
					$.messager.alert("Message", "Fail!");
				}          
            }
        });
        
	}
	
</script>
