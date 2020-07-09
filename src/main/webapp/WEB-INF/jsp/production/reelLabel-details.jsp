<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<a style="margin: 10px 43px" href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="reelLabelEditFunction()">Edit</a>
<%-- <div id="ltcEditWindow" class="easyui-window" title="LtcEdit" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/production/ltc-edit'" style="width:900px;height:800px;padding:10px;"></div> --%>
<div align="center">

	<form id="reelLabelDetailsFrom">
		<input type="hidden" name="id"/>
		<input type="hidden" name="createBy" value="${subject.principal}"/>
		<input type="hidden" name="id"/>
		<table>
			<tr>
				<td>LTC # : </td>
				<td width="250px"><input class="easyui-textbox" name="ltc" id="details_ltc" style="width: 180px" data-options="readonly:true"></td>
				<td>Material Lot # : </td>
				<td><input class="easyui-textbox" name="materialLot" id="details_materialLot" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>P/N : </td>
				<td><input class="easyui-textbox" name="ubotPn" id="details_ubotPn" style="width: 180px" data-options="readonly:true"></td>
				<td>Machine # : </td>
				<td><input class="easyui-textbox" name="machine" id="details_machine" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>DWG_NO : </td>
				<td><input class="easyui-textbox" name="desc" id="details_desc" style="width: 180px" data-options="readonly:true"></td>
				<td>Puching Tool # : </td>
				<td><input class="easyui-textbox" name="puchingTool" id="details_puchingTool" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>Lane #. : </td>
				<td><input class="easyui-textbox" name="lane" id="details_lane" style="width: 180px" data-options="readonly:true"></td>
				<td>Forming Tool # : </td>
				<td><input class="easyui-textbox" name="formingTool" id="details_formingTool" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>JO NO : </td>
				<td><input class="easyui-textbox" name="joNo" id="details_joNo" style="width: 180px" data-options="readonly:true"></td>
				<td>Scitting Tool # : </td>
				<td><input class="easyui-textbox" name="scittingTool" id="details_scittingTool" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>Customer : </td>
				<td><input class="easyui-textbox" name="customerName" id="details_customerName" style="width: 180px" data-options="readonly:true" ></td>
				<td>Production Date : </td>
				<td><input class="easyui-datebox" name="productionDate" id="details_productionDate" style="width: 180px" data-options="editable:false,required:true,readonly:true,formatter:myformatter,parser:myparser" ></td>
			</tr>
			<tr>
				<td>Customer P/N : </td>
				<td><input class="easyui-textbox" name="custPn" id="details_custPn" style="width: 180px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>Batches : </td>
				<td><input class="easyui-textbox" name="batches" id="details_batches"  style="width: 180px" data-options="prompt:'1~999',required:true,readonly:true"></td>
			</tr>
		</table>
	</form>
</div>

	<div style="margin: 1px 43px" id="details_foot" hidden="true">
		<form id="reelLabelDetailsFrom2">
			<table>
				<tr>
					<td>Batches Change to : </td>
					<td><input class="easyui-textbox" name="batches2" id="details_batches2"  style="width: 180px" data-options="prompt:'1~999 and must > Batches',required:true,validType:['number']"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>	
				<tr>
					<td><a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">Save</a></td>
				</tr>			
			</table>
		</form>
	</div>

<script>
	$.extend($.fn.validatebox.defaults.rules, {
		// 只能输入1~3位数的整数	并且大于当前的Batches
		number : {
			validator: function (value) {
				if(/^\d+(\d+)?$/.test(value) == true && value.length <= 3 && value > $("#details_batches").val()){
					return true;
				}
			},
			message: 'Please enter a valid number'
		}
	})

	function reelLabelEditFunction(){
		$("#details_foot").show();
	}
	
	function submitForm(){
	    var validate = $("#reelLabelDetailsFrom").form('validate');
	    if (!validate) {
			$("#reelLabelDetailsFrom").find(".validatebox-invalid:first").focus();
	        return false;
	    }
	    
	    
	   	var validate2 = $("#reelLabelDetailsFrom2").form('validate');
	    if (!validate2) {
			$("#reelLabelDetailsFrom2").find(".validatebox-invalid:first").focus();
	        return false;
	    }
	    
	    /* console.log($("#reelLabelDetailsFrom").serialize());
	    console.log($("#reelLabelDetailsFrom").serializeJSON());
	    console.log(JSON.stringify($("#reelLabelDetailsFrom").serializeJSON())); */
	    
	    /* var map = new Map();
	    map.set("reelLabel",JSON.stringify($("#reelLabelDetailsFrom").serializeJSON()));
	    map.set("batches",$("#details_batches2").val()); */
	    
	   $.ajax({
	        url: 'updateReelLabel',
	        type: "Post",
	        data: 
	        	'{"id":"'+$("input[name='id']").val()+'","ltc":"'+$("input[name='ltc']").val()+'","updateBy":"${subject.principal}","batches":"'+$("input[name='batches']").val()+'","batches2":"'+$("input[name='batches2']").val()+'"}',
	       	//data: JSON.stringify($("#reelLabelDetailsFrom").serializeJSON()),
	       	//data: '{"reelLabel":"'+JSON.stringify($("#reelLabelDetailsFrom").serializeJSON())+'","batches":"'+$("#details_batches2").val()+'"}', 
	        //data: "{'reelLabel':'" + JSON.stringify($("#reelLabelDetailsFrom").serializeJSON()) + "','batches':'" + $("#details_batches2").val() + "'}",
	       	//data: '{"map":"'+map+'"}',
	        contentType: "application/json;charset=UTF-8",
	        success: function (result) {
				if(result.status == 200){
					$.messager.alert("Message", "successfully!");
					$('#reelRabelList').datagrid('reload');
					$('#reelLabelDetailsWindow').window('close');
				}else{
					$.messager.alert("Message", "Fail!");
				}   
	        }
	    });
	    
	}
	

</script>

