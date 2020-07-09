<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="margin: 10px" align="center">
	<form id="packingLabelEditFrom">
		<input type="hidden" name="id" >
		<input type="hidden" name="updateBy" id="edit_updateBy"/>
		<table>
			<tr>
				<td>LTC # : </td>
				<td width="250px"><input class="easyui-textbox" name="ltc" id="edit_ltc" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>Carton # : </td>
				<td width="250px"><input class="easyui-textbox" name="carton" id="edit_carton" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>QTY/Carton : </td>
				<td><input class="easyui-textbox" name="qty" id="edit_qty" style="width: 180px" data-options="prompt:'1~9',required:true,validType:['number']"></td>
			</tr>
			<tr>
				<td>Q1 : </td>
				<td><input class="easyui-textbox" name="q1" id="edit_q1" style="width: 180px" data-options="required:true"></td>
			</tr>
			<tr>
				<td>Q2 : </td>
				<td><input class="easyui-textbox" name="q2" id="edit_q2" style="width: 180px" data-options="required:true"></td>
			</tr>
			<tr>
				<td>Q3 : </td>
				<td><input class="easyui-textbox" name="q3" id="edit_q3" style="width: 180px" data-options="required:true"></td>
			</tr>
			<tr>
				<td>Packing Date : </td>
				<td><input class="easyui-datebox" name="packingDate" id="edit_packingDate" style="width: 180px" data-options="editable:false,required:true,formatter:myformatter,parser:myparser" ></td>
			</tr>
		</table>
	</form>
	<div style="margin-top: 20px">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 150px">Submit</a>
		<!-- &nbsp;&nbsp;  
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width: 80px">Clear</a> -->
	</div>
</div>

<script type="text/javascript">

	/* $(document).ready(function(){
		var d = new Date();
		var currentDate = d.getFullYear() + d.getMonth() + d.getDate();
		$("#new_packingDate").val(currentDate);
		
		$.ajax({
            url: 'getMaxCarton',
            type: "Get",
            contentType: "application/json;charset=UTF-8",
            success: function (result) {
				if(result.status == 200){
					$('#new_carton').textbox('setValue',result.data);
				}         
            }
        });
		
	}); */

	$.extend($.fn.validatebox.defaults.rules, {
		// 只能输入1位数的整数	
		number : {
			validator: function (value) {
				if(/^\d+(\d+)?$/.test(value) == true && value.length <= 1){
					return true;
				}
			},
			message: 'Please enter a valid number'
		}
	})

	function submitForm(){
        var validate = $("#packingLabelEditFrom").form('validate');
        if (!validate) {
			$("#packingLabelEditFrom").find(".validatebox-invalid:first").focus();
            return false;
        }
        
        $.messager.confirm('Missage','Are you sure to update it?',function(r) {
			if (r) {
				$.ajax({
		            url: 'updatePackingLabel',
		            type: "Post",
		            data: JSON.stringify($("#packingLabelEditFrom").serializeJSON()),
		            contentType: "application/json;charset=UTF-8",
		            success: function (result) {
						if(result.status == 200){
							$.messager.alert("Message", "successfully!");
							$('#packingLabelList').datagrid('reload');
							$('#packingLabelEditWindow').window('close');
						}else{
							$.messager.alert("Message", result.msg);
						}          
		            }
		        });
			}
		});
        
        
        
	}
	
</script>