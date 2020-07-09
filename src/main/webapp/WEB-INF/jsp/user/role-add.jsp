<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div style="margin: 10px">
	<form id="roleAddFrom">
		<table>
			<tr>
				<td>Role Name : </td>
				<td><input class="easyui-textbox" name="roleName" style="width: 200px" data-options="required:true"></td>
			</tr>
			<tr>
				<td>Desc : </td>
				<td><input class="easyui-textbox" name="roleDesc" style="width: 200px" data-options=""></td>
			</tr>
		</table>
		<div id="permissionResult" style="margin-top: 5px">
				Permission :
				<a href="#" class="easyui-linkbutton" onclick="setAll()">Select All</a>
				<a href="#" class="easyui-linkbutton" onclick="setOthers()">Invert Selection</a>
				<br><br>
		</div>
	</form>
	
	<div>
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width: 80px">Submit</a>
		&nbsp;&nbsp;  
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width: 80px">Clear</a>
	</div>
</div>



<script type="text/javascript">

	$(document).ready(function(){
		$.ajax({
			url: '../user/listPermission_',
			type: "GET",
			contentType: "application/json;charset=UTF-8",
			success: function (result) {
				var str = "";
				var listPermission = result.data;
				console.log(listPermission);
				str += '<div style="margin-bottom: 20px">';
				for(var i in listPermission){
					str += '<input type="checkbox" name="permissionName" value="' + listPermission[i].id + '">&nbsp;'
					str += '<label>' + listPermission[i].name + '</label><br>';
				}
				str += '</div>';
				/* var map = result.data;
				for(var key in map){
					str += '<div style="margin-bottom: 20px">' + key + '<br>';
					var permissionList = map[key];
					console.log(permissionList);
					for(var i=0; i<permissionList.length; i++){
						str += '<input type="checkbox" name="permissionName" value="' + permissionList[i].id + '">&nbsp;'
						str += '<label>' + permissionList[i].permissionName + '</label><br>';
					}
					str += "</div>";
				}; */
				$("#permissionResult").append(str);
				
				$.parser.parse($('#permissionResult')); 
			}
		});
		
	});
	
	// 全选
	function setAll() {
		var p = document.getElementsByName("permissionName");
		for (var i = 0; i < p.length; i++) {
			p[i].checked = true;
		}
	}
	
	// 反选
	function setOthers() {
		var p = document.getElementsByName("permissionName");
		for (var i = 0; i < p.length; i++) {
			if (p[i].checked == false){
				p[i].checked = true;
			}else{
				p[i].checked = false;
			}
		}
	}
	   
	function submitForm(){
        var validate = $("#roleAddFrom").form('validate');
        if (!validate) {
			$("#roleAddFrom").find(".validatebox-invalid:first").focus();
            return false;
        }
        
        var permissionNameList = [];
        $("input[name='permissionName']:checked").each(function(i){
        	permissionNameList.push($(this).val());
      	});
        
        $.ajax({
            url: '../user/addRole',
            type: "Post",
            data: '{"roleName":"'+$("input[name='roleName']").val()+'","roleDesc":"'+$("input[name='roleDesc']").val()+'","permissionNameList":'+JSON.stringify(permissionNameList)+'}',
            contentType: "application/json;charset=UTF-8",
            success: function (result) {
				if(result.status == 200){
					$.messager.alert("Message", "successfully!");
					$('#roleList').datagrid('reload');
					$('#roleAddWindow').window('close');
				}else{
					$.messager.alert("Message", "Fail !" + result.msg);
				}          
            }
        });
	}
	
	function clearForm(){
	    $('#roleAddFrom').form('clear');
	}
</script>