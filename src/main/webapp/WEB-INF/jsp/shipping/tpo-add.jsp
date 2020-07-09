<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="margin: 10px">
	<input type="hidden" name="createBy" id="tpoAdd_createBy" value="${subject.principal}"/>
	<form id="tpoAddFrom">
		<input type="hidden" name="tid" id="tpoAdd_tid" value=""/>
		<table>
			<tr>
				<td>UBoT P/N : </td>
				<td><input class="easyui-combobox" name="ubotPn" id="tpoAdd_ubotPn" data-options="valueField:'id',textField:'text',url:'../product/getProductPn',editable:false,required:true,onChange:pnChange" style="width: 200px"></td>
			</tr>
			<tr>
				<td>DWG NO. : </td>
				<td><input class="easyui-textbox" name="desc" id="tpoAdd_desc" style="width: 200px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>UOM : </td>
				<td><input class="easyui-textbox" name="uom" id="tpoAdd_uom" value="Meter" style="width: 200px" data-options="readonly:true"></td>
			</tr>
			<tr>
				<td>QTY : </td>
				<td><input class="easyui-textbox" name="qty" style="width: 200px" data-options="required:true,validType:['double_','length[1,10]']"></td>
			</tr>
			<tr>
				<td>etdDate : </td>
				<td><input class="easyui-datebox" name="etdDate" style="width: 200px" data-options="editable:false,formatter:myformatter,parser:myparser"></td>
			</tr>
			<tr>
				<td>Requirement:</td>
				<td><input class="easyui-textbox" name="requirement" style="height:150px;width: 300px" data-options="multiline:true,validType:['length[0,300]']"></td>
			</tr>
		</table>
	</form>
	
	<div style="margin-top: 20px">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">Submit</a>
	</div>
</div>



<script type="text/javascript">

	function pnChange(pn){
		// 根据PN获取DWG NO.
		$.ajax({
			type: 'POST',
			url: "../product/getDwgNoByPn",
			data:'{"pn":"'+pn+'"}',
			dataType: "json",
			contentType: "application/json;charset=UTF-8",
			success: function(result){
				$('#tpoAdd_desc').textbox('setValue', result.data);
			}
		});
	}

	function submitForm(){
        var validate = $("#tpoAddFrom").form('validate');
        if (!validate) {
			$("#tpoAddFrom").find(".validatebox-invalid:first").focus();
            return false;
        }
       // console.log(JSON.stringify($("#tpoAddFrom").serializeJSON()));
       // console.log($("#tpoAdd_createBy").val());
        $.ajax({
            url: 'addTpo',
            type: "Post",
            data: '{"tpo2":'+JSON.stringify($("#tpoAddFrom").serializeJSON())+',"createBy":"'+$("#tpoAdd_createBy").val()+'"}',
            contentType: "application/json;charset=UTF-8",
            success: function (result) {
				if(result.status == 200){
					$.messager.alert("Message", "successfully!");
					$('#tpoList').datagrid('reload');
					$('#tpoEditList').datagrid('reload');
					$('#tpo2NewList').datagrid('reload');
				}else{
					$.messager.alert("Message", "Fail!");
				}          
            }
        });
	}
</script>