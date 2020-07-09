<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<a style="margin: 10px 50px" href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="ltcEditFunction()">Edit</a>
<%-- <div id="ltcEditWindow" class="easyui-window" title="LtcEdit" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/production/ltc-edit'" style="width:900px;height:800px;padding:10px;"></div> --%>
<div align="center">

	<form id="ltcDetailsFrom">
		<input type="hidden" name="id"/>
		<input type="hidden" name="updateBy" id="details_updateBy"/>
		<table>
			<tr>
				<td>LTC # : </td>
				<td><input class="easyui-textbox" name="ltc" id="details_ltc" value="new" style="width: 180px" data-options="readonly:true"></td>
				<td>Source Batch Code : </td>
				<td><input class="easyui-textbox" name="sourceBatchCode" id="details_sourceBatchCode" value="A" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>JO NO : </td>
				<td><input class="easyui-textbox" name="joNo" id="details_joNo" style="width: 180px" data-options="readonly:true"></td>
				<td>Lot Type : </td>
				<td><input class="easyui-textbox" name="lotType" id="details_lotType" value="0" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>P/N : </td>
				<td><input class="easyui-textbox" name="ubotPn" id="details_ubotPn" style="width: 180px" data-options="readonly:true"></td>
				<td>Product Type : </td>
				<td><input class="easyui-textbox" name="productType" id="details_productType" value="8" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>DWG_NO : </td>
				<td><input class="easyui-textbox" name="desc" id="details_desc" style="width: 180px" data-options="readonly:true"></td>
				<td>Production Date : </td>
				<td><input class="easyui-datebox" name="productionDate" id="details_productionDate" style="width: 180px" data-options="editable:false,readonly:true,formatter:myformatter,parser:myparser"></td>
			</tr>
			<tr>
				<td>Customer : </td>
				<td>
					<input class="easyui-combobox" name="customerName" id="details_customerName" style="width: 180px" data-options="
                				valueField:'id',
                                textField:'text',
                                url:'../customer/getCustomerName',
                                required:true,
                                readonly:true,
                                onSelect:customerNameChange,
                                editable : false
                			" >
				</td>
				<td>Lot Serics : </td>
				<td><input class="easyui-textbox" name="lotSerics" id="details_lotSerics" value="01" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>Customer P/N : </td>
				<td><input class="easyui-textbox" name="custPn" id="details_custPn" style="width: 180px" data-options="editable:false"></td>
				<td>Sublot Serics : </td>
				<td><input class="easyui-textbox" name="sublotSerics" id="details_sublotSerics" value="01" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>Lane. : </td>
				<td>
					<select class="easyui-combobox" name="lane" id="details_lane" style="width: 180px" data-options="editable : false,readonly:true">
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
            	<!-- <td><input class="easyui-textbox" name="lane" id="details_lane" style="width: 180px" data-options="required:true,readonly:true" ></td> -->
				<td>Forming Tool # : </td>
				<td><input class="easyui-textbox" name="formingTool" id="details_formingTool" value="1" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>Machine # : </td>
				<td><input class="easyui-textbox" name="machine" id="details_machine" value="A1" style="width: 180px" data-options="readonly:true"></td>
				<td>Scitting Tool # : </td>
				<td><input class="easyui-textbox" name="scittingTool" id="details_scittingTool" value="1" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>Puching Tool # : </td>
				<td><input class="easyui-textbox" name="puchingTool" id="details_puchingTool" value="1" style="width: 180px" data-options="readonly:true"></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Material Lot # : </td>
				<td><input class="easyui-textbox" name="materialLot" id="details_materialLot" value="See Material Log Bool" style="width: 180px" data-options="readonly:true"></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>Requirement : </td>
				<td><input class="easyui-textbox" name="remarks" id="details_remarks" style="width: 300px;height: 150px" data-options="multiline:true,readonly:true,validType:['length[0,300]']"></td>
				<td></td>
				<td></td>
			</tr>
		</table>
	</form>
</div>

	<div style="margin: 10px 50px" id="details_foot" hidden="true">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">Save</a>
	</div>

<script>

	function ltcEditFunction(){
		$("#details_remarks").textbox({'readonly':false});
		$("#details_lane").textbox({'readonly':false});
		var productionDate = $("#details_productionDate").datebox('getValue');
		$("#details_productionDate").datebox({'readonly':false});
		$("#details_productionDate").datebox('setValue',productionDate);
		var customerName = $("#details_customerName").combobox('getValue');
		$("#details_customerName").combobox({'readonly':false});
		$("#details_customerName").combobox('setValue',customerName);
		
		$("#details_foot").show();
	}
	
	function customerNameChange(record){
		$.ajax({
			type : 'POST',
			url : "../customer/getCustomerInfo",
			data : '{"pn":"' + $("#details_ubotPn").textbox('getValue') + '","customerName":"' + record.id + '"}',
			dataType : "json",
			contentType : "application/json;charset=UTF-8",
			success : function(result) {
				if(null == result.data){
					$("#details_custPn").textbox('setValue',"");
				}else{
					$("#details_custPn").textbox('setValue',result.data.customerPn);
				}
			}
		});
	}
	
	function submitForm(){
	    var validate = $("#ltcDetailsFrom").form('validate');
	    if (!validate) {
			$("#ltcDetailsFrom").find(".validatebox-invalid:first").focus();
	        return false;
	    }
	    
	    $.ajax({
	        url: 'updateLTC',
	        type: "Post",
	        data: JSON.stringify($("#ltcDetailsFrom").serializeJSON()),
	        contentType: "application/json;charset=UTF-8",
	        success: function (result) {
				if(result.status == 200){
					$.messager.alert("Message", "successfully!");
					$('#ltcList').datagrid('reload');
					$('#ltcDetailsWindow').window('close');
				}else{
					$.messager.alert("Message", "Fail!");
				}   
	        }
	    });
	    
	}
	

</script>

