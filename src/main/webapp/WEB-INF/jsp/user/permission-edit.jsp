<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="margin: 10px">
	<form id="permissionEditFrom">
		<div style="margin-bottom: 20px">
			<input type="hidden" name="id">
		</div>
		<div style="margin-bottom: 20px">
			<input class="easyui-textbox" name="name" id="name_edit" readonly="readonly" style="width: 200px" data-options="label:'Name:',required:true">
		</div>
		<div style="margin-bottom: 20px">
			<input class="easyui-textbox" name="desc" style="width: 300px" data-options="label:'Desc:'">
		</div>
		<div style="margin-bottom: 20px">
			<input class="easyui-textbox" name="url" style="width: 300px" data-options="label:'Url:'">
		</div>
	</form>
	
	<div>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">Submit</a>
		&nbsp;&nbsp;  
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width: 80px">Clear</a>
	</div>
</div>



<script type="text/javascript">

	function submitForm(){
        var validate = $("#permissionEditFrom").form('validate');
        if (!validate) {
			$("#permissionEditFrom").find(".validatebox-invalid:first").focus();
            return false;
        }
        
        $.ajax({
            url: 'updatePermission',
            type: "Post",
            data: JSON.stringify($("#permissionEditFrom").serializeJSON()),
            contentType: "application/json;charset=UTF-8",
            success: function (result) {
				if(result.status == 200){
					$.messager.alert("Message", "successfully!");
					$('#permissionList').datagrid('reload');
					$('#permissionEditWindow').window('close');
				}else{
					$.messager.alert("Message", "Fail !" + result.msg);
				}          
            }
        });
	}
	
	function clearForm(){
	    $('#permissionEditFrom').form('clear');
	}
</script>
