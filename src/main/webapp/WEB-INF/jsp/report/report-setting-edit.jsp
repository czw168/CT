<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="padding:10px 10px 10px 10px">
	<form id="reportSettingEditForm" method="post">
		<input type="hidden" name="id" />
	    <table cellpadding="5">
	        <tr>
	            <td>productNo.:</td>
	            <td><input class="easyui-combobox" name="productNumber" id="edit_productNumber" data-options="valueField:'text',textField:'text',method:'get',url:'${pageContext.request.contextPath}/report/getProductNo',editable:false,required:true" style="width: 100px" ></td>
	            <td>tableName:</td>
	            <td><input class="easyui-combobox" name="tableName" id="edit_tableName" data-options="valueField:'text',textField:'text',method:'get',url:'${pageContext.request.contextPath}/report/getInspectionID',editable:false,required:true" style="width: 200px" ></td>
	            <td>linkCount:</td>
	            <td><input class="easyui-numberbox" name="linkCount" id="edit_linkCount" data-options="required:true" validtype="length[0,1]" style="width: 50px;"></input></td>
	            <td>LotNumberColumnName:</td>
	            <td><input class="easyui-numberbox" name="lotNumberColumnName" id="edit_lotNumberColumnName" data-options="required:true" validtype="length[0,3]" style="width: 50px;"></input></td>
	        </tr>
	    </table>
	</form>
	
	<div id="edit_table">
		
	</div>
	
</div>

<script type="text/javascript">
	
	function submitForm(){
		
		if(!$('#reportSettingEditForm2').form('validate')){
			$.messager.alert('Message','Please fill in the form');
			return;
		}
		
		var jsonData = "{";
		
		var id = $("input[name='id']").val();
// 		var productNumber = $("input[name='productNumber']").val();
// 		var tableName = $("input[name='tableName']").val();
// 		var linkCount = $("input[name='linkCount']").val();
// 		var lotNumberColumnName = "Column" + $("input[name='lotNumberColumnName']").val();
		
		var productNumber = $("#edit_productNumber").val();
		var tableName = $("#edit_tableName").val();
		var linkCount = $("#edit_linkCount").val();
		var lotNumberColumnName = "Column" + $("#edit_lotNumberColumnName").val();
		
		jsonData += 
			'"id":' + '"' + id + '",' +
			'"productNumber":' + '"' + productNumber + '",' +
			'"tableName":' + '"' + tableName + '",' +
			'"linkCount":' + '"' + linkCount + '",' +
			'"lotNumberColumnName":' + '"' + lotNumberColumnName + '",' +
			'"paramDetail":[';
		
		for(var i = 1; i <= linkCount; i++){
			// 链号
			var link = i;
			// 相似度字段名
			//var name_similarityColumnName = "edit_Link" + i + "_similarity_columnName";
			//var similarityColumnName = $("input[name='" + name_similarityColumnName + "']").val();
			jsonData += 
				'{' + 
					'"link":' + '"' + link + '",' +
					//'"similarityColumnName":' + '"Column' + similarityColumnName + '",' +
					'"columnDetail":[';
			
			// 循环两次（B、C）获取每组的字段名和别名
			for(var j = 2; j <= 3; j++){
				// 组名
				var group = "";
				if(j == 1){
					group = "A";
				}else if(j == 2){
					group = "B";
				}else if(j == 3){
					group = "C";
				}
				// 字段名				
				var name_columnName = "edit_Link" + i + "_" + group + "_columnName";
				var columnNameObj = $("input[name='" + name_columnName + "']");
				// 别名
				var name_alias = "edit_Link" + i + "_" + group + "_alias";
				var aliasObj = $("input[name='" + name_alias + "']");
				
				// 因为字段名和别名的个数是一样的,所以放在同一个循环体里就好了
				for(var y = 0; y < columnNameObj.length; y++){
					var columnName = columnNameObj[y].value;
					var alias = aliasObj[y].value;
					
					jsonData += 
						'{' + 
							'"columnName":' + '"Column' + columnName + '",' + 
							'"alias":' + '"' + alias + '",' + 
							'"group":' + '"' + group + '"' + 
						'}';
						
					if(y == columnNameObj.length -1 && j == 3 && i == linkCount){
						jsonData += ']}]}';
					}else if(j == 3 && y == columnNameObj.length -1){
						jsonData += ']},';
					}else{
						jsonData += ',';
					}
				}
			}
		}
			
		console.log(jsonData);
		
		<%--$.ajax({--%>
		<%--  type: 'POST',--%>
		<%--  url: "${pageContext.request.contextPath}/report/updateReportSetting",--%>
		<%--  data: jsonData,--%>
		<%--  dataType: "json",--%>
		<%--  contentType: "application/json;charset=UTF-8",--%>
		<%--  success: function(result){--%>
		<%--		$.messager.alert("Message", result.msg);--%>
		<%--		if(result.status == 200){--%>
		<%--			$('#dataList').datagrid('reload');--%>
		<%--			$('#reportSettingEditWindow').window('close');--%>
		<%--		} --%>
		<%--  }--%>
		<%--});--%>
		
	}	
	
	// 添加字段
	function columnAdd(link,group,columnName,alias) {
		// 例：#Link1_B_column
		var id = "#edit_" + link + "_" + group + "_column";
		
		var myDoc = document.getElementById("edit_" + link + "_" + group + "_column");
		// 查看对应ID的td里面有几个p标签
		var objP = myDoc.getElementsByTagName("p");
		if(objP.length >= 20){
			$.messager.alert('Message','The [' + link +' Cat ' + group + '] maximum limit has been reached and cannot be added.');
    		return;
		}
		
		var str = ""
		if(columnName != null && alias != null){
			str =
			'<p style="margin-left: 40px">' +
				'CloumnName : <input class="easyui-numberbox" name="edit_' + link + '_' + group + '_columnName" value="' + columnName + '" data-options="required:true" validtype="length[0,3]" style="width: 50px;height:25px">&nbsp;' + 
				'Alias : <input class="easyui-textbox" name="edit_' + link + '_' + group + '_alias" value="' + alias + '" data-options="required:true" validtype="length[0,3]" style="width: 50px;height:25px">' +
			'</p>';
		}else{
			str =
			'<p style="margin-left: 40px">' +
				'CloumnName : <input class="easyui-numberbox" name="edit_' + link + '_' + group + '_columnName" data-options="required:true" validtype="length[0,3]" style="width: 50px;height:25px">&nbsp;' + 
				'Alias : <input class="easyui-textbox" name="edit_' + link + '_' + group + '_alias" data-options="required:true" validtype="length[0,3]" style="width: 50px;height:25px">' +
			'</p>';
		}
		
		$(id).append(str);
		$.parser.parse($(id));
	}
	
	// 移除字段
	function columnRemove(link,group) {
		// 例：#l1_b_icon
		var id = "#edit_" + link + "_" + group + "_column";
		$(id + " p:last").remove();
	}
	
	

</script>