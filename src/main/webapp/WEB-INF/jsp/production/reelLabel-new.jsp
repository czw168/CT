<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="margin: 10px">
	<form id="reelLabelNewFrom">
		<input type="hidden" name="createBy" value="${subject.principal}"/>
		<table>
			<tr>
				<td>LTC # : </td>
				<td width="250px"><input class="easyui-textbox" name="ltc" id="new_ltc" style="width: 180px" data-options="readonly:true"></td>
				<td>Material Lot # : </td>
				<td><input class="easyui-textbox" name="materialLot" id="new_materialLot" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>P/N : </td>
				<td><input class="easyui-textbox" name="ubotPn" id="new_ubotPn" style="width: 180px" data-options="readonly:true"></td>
				<td>Machine # : </td>
				<td><input class="easyui-textbox" name="machine" id="new_machine" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>DWG_NO : </td>
				<td><input class="easyui-textbox" name="desc" id="new_desc" style="width: 180px" data-options="readonly:true"></td>
				<td>Puching Tool # : </td>
				<td><input class="easyui-textbox" name="puchingTool" id="new_puchingTool" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>Lane #. : </td>
				<td><input class="easyui-textbox" name="lane" id="new_lane" style="width: 180px" data-options="readonly:true"></td>
				<td>Forming Tool # : </td>
				<td><input class="easyui-textbox" name="formingTool" id="new_formingTool" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>JO NO : </td>
				<td><input class="easyui-textbox" name="joNo" id="new_joNo" style="width: 180px" data-options="readonly:true"></td>
				<td>Scitting Tool # : </td>
				<td><input class="easyui-textbox" name="scittingTool" id="new_scittingTool" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>Customer : </td>
				<td><input class="easyui-textbox" name="customerName" id="new_customerName" style="width: 180px" data-options="readonly:true" ></td>
				<td>Production Date : </td>
				<td><input class="easyui-datebox" name="productionDate" style="width: 180px" data-options="editable:false,required:true,formatter:myformatter,parser:myparser" ></td>
			</tr>
			<tr>
				<td>Customer P/N : </td>
				<td><input class="easyui-textbox" name="custPn" id="new_custPn" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>Batches : </td>
				<td><input class="easyui-textbox" name="batches" style="width: 180px" data-options="prompt:'1~999',required:true,validType:['number']"></td>
			</tr>
		</table>
	</form>
	<div style="margin-top: 20px">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 150px">Create Lot No.</a>
		<!-- &nbsp;&nbsp;  
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width: 80px">Clear</a> -->
	</div>
</div>



<script type="text/javascript">

	$.extend($.fn.validatebox.defaults.rules, {
		// 只能输入1~3位数的整数	
		number : {
			validator: function (value) {
				if(/^\d+(\d+)?$/.test(value) == true && value.length <= 3){
					return true;
				}
			},
			message: 'Please enter a valid number'
		}
	})

	function submitForm(){
        var validate = $("#reelLabelNewFrom").form('validate');
        if (!validate) {
			$("#reelLabelNewFrom").find(".validatebox-invalid:first").focus();
            return false;
        }
        
        $.ajax({
            url: 'newReelLabel',
            type: "Post",
            data: JSON.stringify($("#reelLabelNewFrom").serializeJSON()),
            contentType: "application/json;charset=UTF-8",
            success: function (result) {
				if(result.status == 200){
					$.messager.alert("Message", "successfully!");
					$('#reelLabelList').datagrid('reload');
					$('#reelLabelNewWindow').window('close');
					$('#reelLabelLtcWindow').window('close');
				}else{
					$.messager.alert("Message", result.msg);
				}          
            }
        });
        
	}
	
	/* function clearForm(){
	    $('#reelLabelNewFrom').form('clear');
	} */
</script>