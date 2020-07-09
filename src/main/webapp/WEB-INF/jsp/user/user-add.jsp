<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="margin: 10px" align="center">
	<form id="userAddFrom">
		<table>
			<tr>
				<td>UserName : </td>
				<td><input class="easyui-textbox" name="userName" style="width: 200px" data-options="required:true,validType:['userName']"></td>
			</tr>
			<tr>
				<td>PassWord : </td>
				<td><input class="easyui-passwordbox" id="password_add" name="password" iconWidth="28" style="width:200px" data-options="required:true"></td>
			</tr>
			<tr>
				<td>Confirm PassWord : </td>
				<td><input class="easyui-passwordbox" iconWidth="28" style="width:200px" data-options="required:true" validType="confirmPass['#password_add']"></td>
			</tr>
			<tr>
				<td>Role Name : </td>
				<td><input class="easyui-combobox" name="roleId" data-options="valueField:'id',textField:'text',url:'listRoleName',editable:false,required:true" style="width: 200px" ></td>
			</tr>
		</table>
	</form>
	
	<div style="margin-top: 20px">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">Submit</a>
		&nbsp;&nbsp;  
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width: 80px">Clear</a>
	</div>
	
</div>

<script type="text/javascript">
	
	function submitForm(){
        var validate = $("#userAddFrom").form('validate');
        if (!validate) {
			$("#userAddFrom").find(".validatebox-invalid:first").focus();
            return false;
        }
        
        $.ajax({
            url: 'addUser',
            type: "Post",
            data: JSON.stringify($("#userAddFrom").serializeJSON()),
            contentType: "application/json;charset=UTF-8",
            success: function (result) {
				if(result.status == 200){
					$.messager.alert("Message", "successfully!");
					$('#userList').datagrid('reload');
					$('#userAddWindow').window('close');
				}else{
					$.messager.alert("Message", "Fail!");
				}          
            }
        });
        
	}
	
	function clearForm(){
	    $('#userAddFrom').form('clear');
	}
</script>
