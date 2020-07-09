<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="margin: 10px" align="center">
	<form id="userEditFrom">
		<input type="hidden" name="id" >
		<table>
			<tr>
				<td>UserName : </td>
				<td><input class="easyui-textbox" name="userName" id="userName_edit" style="width: 280px" readonly="readonly" data-options="required:true"></td>
			</tr>
			<tr>
				<td>PassWord : </td>
				<td><input class="easyui-passwordbox" prompt="If empty, the password is not changed" id="password_edit" name="password" iconWidth="28" style="width:280px"></td>
			</tr>
			<tr>
				<td>Confirm PassWord : </td>
				<td><input class="easyui-passwordbox" iconWidth="28" style="width:280px" id="password2_edit" validType="confirmPass['#password_edit']"></td>
			</tr>
			<tr>
				<td>Role Name : </td>
				<td><input class="easyui-combobox" name="roleId" style="width: 280px" data-options="valueField:'id',textField:'text',url:'listRoleName',editable:false,required:true" ></td>
			</tr>
			<tr>
				<td>Status : </td>
				<td>
					<input class="easyui-radiobutton" name="status" value="1" label="Enabled:">
            		&nbsp;&nbsp;&nbsp;
            		<input class="easyui-radiobutton" name="status" value="0" label="Disabled:">		
				</td>
				<!-- <td><input class="easyui-combobox" name="roleId" data-options="valueField:'id',textField:'text',url:'listRoleName',editable:false,required:true" style="width: 200px" ></td> -->
			</tr>
		</table>
		<!-- <div style="margin-bottom: 20px">
			<input type="hidden" name="id" >
		</div>
		<div style="margin-bottom: 20px">
			<label>UserName : </label>
			<input class="easyui-textbox" name="userName" id="userName_edit" style="width: 200px" readonly="readonly" data-options="required:true"></span>
		</div>
		<div style="margin-bottom:20px">
			<label>PassWord : </label>
            <input class="easyui-passwordbox" prompt="If empty, the password is not changed" id="password_edit" name="password" iconWidth="28" style="width:250px">
        </div>
        <div style="margin-bottom:20px">
			<label>Confirm PassWord : </label>
            <input class="easyui-passwordbox" iconWidth="28" style="width:250px" id="password2_edit" validType="confirmPass['#password_edit']">
        </div>
		<div style="margin-bottom: 20px">
			<label>Role Name : </label>
			<input class="easyui-combobox" name="roleId" data-options="valueField:'id',textField:'text',url:'listRoleName',editable:false,required:true" style="width: 200px" >
		</div> -->
		<!-- <div style="margin-bottom:20px">
            <input class="easyui-radiobutton" name="status" value="1" label="Enabled:">
            &nbsp;&nbsp;&nbsp;
            <input class="easyui-radiobutton" name="status" value="0" label="Disabled:">
        </div> -->
	</form>
	
	<div style="margin-top: 20px">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">Submit</a>
		&nbsp;&nbsp;  
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width: 80px">Clear</a>
	</div>
</div>



<script type="text/javascript">

	function submitForm(){
        var validate = $("#userEditFrom").form('validate');
        if (!validate) {
			$("#userEditFrom").find(".validatebox-invalid:first").focus();
            return false;
        }
        
        if($('#password_edit').val() != "" && $('#password2_edit').val() == ""){
        	$.messager.alert("Message", "Please confirm the password.");
        	return false;
        }
        
        $.ajax({
            url: 'updateUser',
            type: "Post",
            data: JSON.stringify($("#userEditFrom").serializeJSON()),
            contentType: "application/json;charset=UTF-8",
            success: function (result) {
				if(result.status == 200){
					$.messager.alert("Message", "successfully!");
					$('#userList').datagrid('reload');
					$('#userEditWindow').window('close');
				}else{
					$.messager.alert("Message", "Fail!");
				}          
            }
        });
        
	}
	
	function clearForm(){
	    $('#userEditFrom').form('clear');
	}
	
</script>
