<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div style="margin: 10px">
	<form id="ltcNewFrom">
		<input type="hidden" name="createBy" value="${subject.principal}"/>
		<table>
			<tr>
				<td>LTC # : </td>
				<td><input class="easyui-textbox" name="ltc" id="new_ltc" value="new" style="width: 180px" data-options="readonly:true"></td>
				<td>Source Batch Code : </td>
				<td><input class="easyui-textbox" name="sourceBatchCode" id="new_sourceBatchCode" value="A" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>JO NO : </td>
				<td><input class="easyui-textbox" name="joNo" id="new_joNo" style="width: 180px" data-options="readonly:true"></td>
				<td>Lot Type : </td>
				<td><input class="easyui-textbox" name="lotType" id="new_lotType" value="0" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>P/N : </td>
				<td><input class="easyui-textbox" name="ubotPn" id="new_ubotPn" style="width: 180px" data-options="readonly:true"></td>
				<td>Product Type : </td>
				<td><input class="easyui-textbox" name="productType" id="new_productType" value="8" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>DWG_NO : </td>
				<td><input class="easyui-textbox" name="desc" id="new_desc" style="width: 180px" data-options="readonly:true"></td>
				<td>Production Date : </td>
				<td><input class="easyui-datebox" name="productionDate"  style="width: 180px" data-options="editable:false,required:true,formatter:myformatter,parser:myparser"></td>
			</tr>
			<tr>
				<td>Customer : </td>
				<td>
					<input class="easyui-textbox" name="customerName" id="new_customerName" style="width: 180px" data-options="required:true" >
				</td>
				<td>Lot Serics : </td>
				<td><input class="easyui-textbox" name="lotSerics" id="new_lotSerics" value="01" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>Customer P/N : </td>
				<td><input class="easyui-textbox" name="custPn" id="new_custPn" style="width: 180px" data-options="editable:false"></td>
				<td>Sublot Serics : </td>
				<td><input class="easyui-textbox" name="sublotSerics" id="new_sublotSerics" value="01" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>Lane. : </td>
				<td>
					<select class="easyui-combobox" name="lane" style="width: 180px" data-options="editable : false">
		                <option value="1">1</option>
		                <option value="2">2</option>
		                <option value="3">3</option>
		                <option value="4">4</option>
		                <option value="5">5</option>
		                <option value="6">6</option>
		                <option value="7">7</option>
		                <option value="8">8</option>
		                <option value="9">9</option>
            		</select>
            	</td>
				<td>Forming Tool # : </td>
				<td><input class="easyui-textbox" name="formingTool" id="new_formingTool" value="1" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>Machine # : </td>
				<td><input class="easyui-textbox" name="machine" id="new_machine" value="A1" style="width: 180px" data-options="readonly:true"></td>
				<td>Scitting Tool # : </td>
				<td><input class="easyui-textbox" name="scittingTool" id="new_scittingTool" value="1" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>Puching Tool # : </td>
				<td><input class="easyui-textbox" name="puchingTool" id="new_puchingTool" value="1" style="width: 180px" data-options="readonly:true"></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Material Lot # : </td>
				<td><input class="easyui-textbox" name="materialLot" id="new_materialLot" value="See Material Log Bool" style="width: 180px" data-options="readonly:true"></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Requirement : </td>
				<td><input class="easyui-textbox" name="remarks" id="new_remarks" style="width: 300px;height: 150px" data-options="multiline:true,validType:['length[0,300]']"></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>
	
	<div style="margin-top: 20px">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">Submit</a>
		<!-- &nbsp;&nbsp;  
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width: 80px">Clear</a> -->
	</div>
</div>

<script>

//表单验证方式
$.extend($.fn.validatebox.defaults.rules, {
    // 根据
    customer: {
    	 validator: function(value, param){
			$.ajax({
				type: 'POST',
				url: "../customer/getCustomerInfo",
				data: '{"pn":"'+$("#new_ubotPn").val()+'","customerName":"'+value+'"}',
				dataType: "json",
				contentType: "application/json;charset=UTF-8",
				async:false,
				success: function(result){
					console.log($("#new_remarks").textbox('getValue'));
					if(null == result.data){
						$("#new_custPn").textbox('setValue','');
						$("#new_remarks").textbox('setValue','');
					}else{
						if(null != result.data.customerPn){
							$("#new_custPn").textbox('setValue',result.data.customerPn);
						}else{
							$("#new_custPn").textbox('setValue','');
						}
						
						if(null != result.data.requirement){
							$("#new_remarks").textbox('setValue',result.data.requirement);
						}else{
							$("#new_remarks").textbox('setValue','');
						}
					}
				}
			});
			return true
	     },
	     message: ''
    }
})
	
	function submitForm(){
	    var validate = $("#ltcNewFrom").form('validate');
	    if (!validate) {
			$("#ltcNewFrom").find(".validatebox-invalid:first").focus();
	        return false;
	    }
	    
	    $.ajax({
	        url: 'newLTC',
	        type: "Post",
	        data: JSON.stringify($("#ltcNewFrom").serializeJSON()),
	        contentType: "application/json;charset=UTF-8",
	        success: function (result) {
				if(result.status == 200){
					$.messager.alert("Message", "successfully!");
					$('#ltcList').datagrid('reload');
					$('#ltcNewWindow').window('close');
				}else{
					$.messager.alert("Message", "Fail!");
				}          
	        }
	    });
	    
	}
	
	function clearForm(){
	    $('#ltcNewFrom').form('clear');
	}

</script>

