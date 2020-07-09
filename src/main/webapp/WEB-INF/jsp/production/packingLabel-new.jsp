<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="margin: 10px" align="center">
	<form id="packingLabelNewFrom">
		<input type="hidden" name="createBy" value="${subject.principal}"/>
		<table>
			<tr>
				<td>LTC # : </td>
				<td width="250px"><input class="easyui-textbox" name="ltc" id="new_ltc" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>Carton # : </td>
				<td width="250px"><input class="easyui-textbox" name="carton" id="new_carton" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>QTY/Carton : </td>
				<td><input class="easyui-textbox" name="qty" id="new_qty" style="width: 180px" data-options="prompt:'1~9',required:true,validType:['number']"></td>
			</tr>
			<tr>
				<td>Q1 : </td>
				<td><input class="easyui-textbox" name="q1" id="new_q1" style="width: 180px" data-options="required:true"></td>
			</tr>
			<tr>
				<td>Q2 : </td>
				<td><input class="easyui-textbox" name="q2" id="new_q2" style="width: 180px" data-options="required:true"></td>
			</tr>
			<tr>
				<td>Q3 : </td>
				<td><input class="easyui-textbox" name="q3" id="new_q3" style="width: 180px" data-options="required:true"></td>
			</tr>
			<tr>
				<td>Packing Date : </td>
				<td><input class="easyui-datebox" name="packingDate" id="new_packingDate" style="width: 180px" data-options="editable:false,required:true,formatter:myformatter,parser:myparser" ></td>
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

	$(document).ready(function(){
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
		
	});

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
        var validate = $("#packingLabelNewFrom").form('validate');
        if (!validate) {
			$("#packingLabelNewFrom").find(".validatebox-invalid:first").focus();
            return false;
        }
        
        $.ajax({
            url: 'newPackingLabel',
            type: "Post",
            data: JSON.stringify($("#packingLabelNewFrom").serializeJSON()),
            contentType: "application/json;charset=UTF-8",
            success: function (result) {
				if(result.status == 200){
					$.messager.alert("Message", "successfully!");
					$('#packingLabelList').datagrid('reload');
					$('#packingLabelNewWindow').window('close');
					//$('#reelLabelLtcWindow').window('close');
				}else{
					$.messager.alert("Message", result.msg);
				}          
            }
        });
        
	}
	
	/* function clearForm(){
	    $('#packingLabelNewFrom').form('clear');
	} */
</script>