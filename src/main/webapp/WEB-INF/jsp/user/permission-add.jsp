<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="margin: 10px">
	<form id="permissionAddFrom">
		<div style="margin-bottom: 20px">
			<input class="easyui-textbox" name="name" style="width: 200px" data-options="label:'Name:',required:true">
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
        var validate = $("#permissionAddFrom").form('validate');
        if (!validate) {
			$("#permissionAddFrom").find(".validatebox-invalid:first").focus();
            return false;
        }
        
        $.ajax({
            url: 'addPermission',
            type: "Post",
            data: JSON.stringify($("#permissionAddFrom").serializeJSON()),
            contentType: "application/json;charset=UTF-8",
            success: function (result) {
				if(result.status == 200){
					$.messager.alert("Message", "successfully!");
					$('#permissionList').datagrid('reload');
					$('#permissionAddWindow').window('close');
				}else{
					$.messager.alert("Message", "Fail !" + result.msg);
				}          
            }
        });
	}
	
	function clearForm(){
	    $('#permissionAddFrom').form('clear');
	}
</script>
