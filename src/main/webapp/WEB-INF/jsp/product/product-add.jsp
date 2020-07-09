<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="margin: 10px">
	<form id="productAddFrom">
		<table>
			<tr>
				<td>P/N : </td>
				<td><input class="easyui-textbox" name="pn" style="width: 200px" data-options="required:true,validType:['majusculeAndNumber','length[10,10]']"></td>
			</tr>
			<tr>
				<td>DWG NO : </td>
				<td><input class="easyui-textbox" name="dwgNo" style="width: 300px" data-options="required:true,validType:['majusculeAndNumberAndDot','length[0,30]']"></td>
			</tr>
			<tr>
				<td>Length : </td>
				<td><input class="easyui-textbox" name="length" style="width: 200px" data-options="required:true,validType:['double_','length[1,10]']">&nbsp;M</td>
			</tr>
			<tr>
				<td>A0 : </td>
				<td><input class="easyui-textbox" name="a0" style="width: 200px" data-options="required:true,validType:['double_','length[1,10]']">&nbsp;MM</td>
			</tr>
			<tr>
				<td>B0 : </td>
				<td><input class="easyui-textbox" name="b0" style="width: 200px" data-options="required:true,validType:['double_','length[1,10]']">&nbsp;MM</td>
			</tr>
			<tr>
				<td>K0 : </td>
				<td><input class="easyui-textbox" name="k0" style="width: 200px" data-options="required:true,validType:['double_','length[1,10]']">&nbsp;MM</td>
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
		console.log("addSub");
        var validate = $("#productAddFrom").form('validate');
        if (!validate) {
			$("#productAddFrom").find(".validatebox-invalid:first").focus();
            return false;
        }
        
        $.ajax({
            url: 'addProduct',
            type: "Post",
            data: JSON.stringify($("#productAddFrom").serializeJSON()),
            contentType: "application/json;charset=UTF-8",
            success: function (result) {
				if(result.status == 200){
					$.messager.alert("Message", "successfully!");
					$('#productList').datagrid('reload');
					$('#productAddWindow').window('close');
				}else{
					$.messager.alert("Message", "Fail! Duplicate P/N!");
				}          
            }
        });
	}
	
</script>
