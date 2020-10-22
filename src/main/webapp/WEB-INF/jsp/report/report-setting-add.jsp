<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="padding:10px 10px 10px 10px">
	<form id="reportSettingAddForm" method="post">
	    <table cellpadding="5">
	        <tr>
	            <td>productNo.:</td>
	            <td><input class="easyui-combobox" name="productNumber" id="add_productNumber" data-options="valueField:'text',textField:'text',method:'get',url:'${pageContext.request.contextPath}/report/getProductNo',editable:false,required:true" style="width: 100px" ></td>
	            <td>tableName:</td>
	            <td><input class="easyui-combobox" name="tableName" id="add_tableName" data-options="valueField:'text',textField:'text',method:'get',url:'${pageContext.request.contextPath}/report/getInspectionID',editable:false,required:true" style="width: 200px" ></td>
	            <td>linkCount:</td>
	            <td><input class="easyui-numberbox" name="linkCount" id="add_linkCount" data-options="required:true" validtype="length[0,1]" style="width: 50px;"></input></td>
	            <td>LotNumberColumnName:</td>
	            <td><input class="easyui-numberbox" name="lotNumberColumnName" id="add_lotNumberColumnName" data-options="required:true" validtype="length[0,3]" style="width: 50px;"></input></td>
	        	<td><a href="javascript:" class="easyui-linkbutton" onclick="ok()">OK</a></td>
	        </tr>
	    </table>
	</form>
	<!-- <div style="padding:5px">
	    <a href="javascript:" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
	</div> -->
	
	<div id="table">
		
	</div>
	
	<!-- <table>
		<tr>
			<th>Link 1</th>
		</tr>
		<tr>
			<td><span style="margin-left: 20px">SimilarityCloumnName : <input class="easyui-numberbox" name="Link1_similarity_columnName" data-options="required:true" validtype="length[0,3]" style="width: 50px;height:25px"></span></td>
		</tr>
		<tr>
			<td><span style="margin-left: 20px">Cat A.</span></td>
		</tr>
		<tr style="margin-left: 10">
			<td>
				<p style="margin-left: 40px">
					CloumnName : <input class="easyui-numberbox" name="Link1_A_columnName" data-options="required:true" validtype="length[0,3]" style="width: 50px;height:25px">
					Alias : <input class="easyui-textbox" name="link1_A_alias" data-options="required:true" validtype="length[0,3]" style="width: 50px;height:25px">
				</p>
			</td>
		</tr>
		<tr>
			<td>
				<span style="margin-left: 20px" >
				Cat B.
				<a id="Link1_B_columnAdd" class='easyui-linkbutton' iconCls='icon-add' onclick="columnAdd('Link1','B')" style="height: 15px"></a>
				<a id="Link1_B_columnRemove" class='easyui-linkbutton' iconCls='icon-remove' onclick="columnRemove('Link1','B')" style="height: 15px"></a>
				</span>
			</td>
		</tr>
		<tr style="margin-left: 10">
			<td id="Link1_B_column"></td>
		</tr>
		<tr>
			<td>
				<span style="margin-left: 20px" >
				Cat C.
				<a id="Link1_C_columnAdd" class='easyui-linkbutton' iconCls='icon-add' onclick="columnAdd('Link1','C')" style="height: 15px"></a>
				<a id="Link1_C_columnRemove" class='easyui-linkbutton' iconCls='icon-remove' onclick="columnRemove('Link1','C')" style="height: 15px"></a>
				</span>
			</td>
		</tr>
		<tr style="margin-left: 10">
			<td id="Link1_C_column"></td>
		</tr>
	</table> -->
	
	
</div>

<script type="text/javascript">

	function ok(){
		if(!$('#reportSettingAddForm').form('validate')){
			$.messager.alert('Message','Please fill in the form');
			return;
		}
// 		var productNumber = $("input[name='productNumber']").val();
// 		var tableName = $("input[name='tableName']").val();
// 		var linkCount = $("input[name='linkCount']").val();

		var productNumber = $("#add_productNumber").val();
		var tableName = $("#add_tableName").val();
		var linkCount = $("#add_linkCount").val();

		// 查看该参数设定是否设置过
        $.get("${pageContext.request.contextPath}/report/getReportSetting?productNumber="+productNumber+"&tableName="+tableName,function(result){
		  	var tableName = result.data;
        	if(tableName != null){
        		$("#table").html("<hr><span style='color:red;margin-left: 20px'>This parameter has been set</span>");
		  		return;
		  	}
        	
        	$("#add_productNumber").combobox('disable');
        	$("#add_tableName").combobox('disable');
        	$("#add_linkCount").numberbox('disable');
        	$("#add_lotNumberColumnName").numberbox('disable');
        	
        	getForm(linkCount);
		});
	}
	
	function submitForm(){
		
		if(!$('#reportSettingAddForm2').form('validate')){
			$.messager.alert('Message','Please fill in the form');
			return;
		}
		
		var jsonData = "{";
		
// 		var productNumber = $("input[name='productNumber']").val();
// 		var tableName = $("input[name='tableName']").val();
// 		var linkCount = $("input[name='linkCount']").val();
// 		var lotNumberColumnName = "Column" + $("input[name='lotNumberColumnName']").val();
		var productNumber = $("#add_productNumber").val();
		var tableName = $("#add_tableName").val();
		var linkCount = $("#add_linkCount").val();
		var lotNumberColumnName = "Column" + $("#add_lotNumberColumnName").val();
		
		jsonData += 
			'"productNumber":' + '"' + productNumber + '",' +
			'"tableName":' + '"' + tableName + '",' +
			'"linkCount":' + '"' + linkCount + '",' +
			'"lotNumberColumnName":' + '"' + lotNumberColumnName + '",' +
			'"paramDetail":[';
		
		for(var i = 1; i <= linkCount; i++){
			// 链号
			var link = i;
			// 相似度字段名
			var name_similarityColumnName = "Link" + i + "_similarity_columnName";
			var similarityColumnName = $("input[name='" + name_similarityColumnName + "']").val();
			jsonData += 
				'{' + 
					'"link":' + '"' + link + '",' +
					'"similarityColumnName":' + '"Column' + similarityColumnName + '",' +
					'"columnDetail":[';
			
			// 循环三次（A、B、C）获取每组的字段名和别名
			for(var j = 1; j <= 3; j++){
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
				var name_columnName = "Link" + i + "_" + group + "_columnName";
				var columnNameObj = $("input[name='" + name_columnName + "']");
				if(columnNameObj.length == 0){
					$.messager.alert('Message','Please fill in the form');
					return;
				}
				// 别名
				var name_alias = "Link" + i + "_" + group + "_alias";
				var aliasObj = $("input[name='" + name_alias + "']");
				
				// 因为字段名和别名的个数是一样的，所以放在同一个循环体里就好了
				for(var y = 0; y < columnNameObj.length; y++){
					var columnName = columnNameObj[y].value;
					var alias = aliasObj[y].value;
					
					jsonData += 
						'{' + 
							'"columnName":' + '"Column' + columnName + '",' + 
							'"alias":' + '"' + alias + '",' + 
							'"group":' + '"' + group + '"' + 
						'}';
					//debugger;
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
		
		$.ajax({
		  type: 'POST',
		  url: "${pageContext.request.contextPath}/report/addReportSetting",
		  data: jsonData,
		  //data: '{"jsonData":"' + jsonData + '"}',
		  dataType: "json",
		  contentType: "application/json;charset=UTF-8",
		  success: function(result){
				$.messager.alert("Message", result.msg);
				if(result.status == 200){
					$('#dataList').datagrid('reload');
					$('#reportSettingAddWindow').window('close');
				}
		  }
		 	
		});
		
	}	
	
	// 添加字段
	function columnAdd(link,group) {
		// 例：#Link1_B_column
		var id = "#" + link + "_" + group + "_column";
		
		var myDoc = document.getElementById(link + "_" + group + "_column");
		// 查看对应ID的td里面有几个p标签
		var objP = myDoc.getElementsByTagName("p");
		
		if(objP.length >= 20){
			$.messager.alert('Message','The [' + link +' Cat ' + group + '] maximum limit has been reached and cannot be added.');
    		return;
		}
		var str =
		'<p style="margin-left: 40px">' +
			'CloumnName : <input class="easyui-numberbox" name="' + link + '_' + group + '_columnName" data-options="required:true" validtype="length[0,3]" style="width: 50px;height:25px">&nbsp;' + 
			'Alias : <input class="easyui-textbox" name="' + link + '_' + group + '_alias" data-options="required:true" validtype="length[0,3]" style="width: 50px;height:25px">' +
		'</p>';
		
		$(id).append(str);
		$.parser.parse($(id));
	}
	
	// 移除字段
	function columnRemove(link,group) {
		// 例：#l1_b_icon
		var id = "#" + link + "_" + group + "_column";
		$(id + " p:last").remove();
	}
	
	// 循环拼接表单的方法
	function getForm(linkCount){
		var str = '<form id="reportSettingAddForm2" method="post">';
		//var str = '';
		for(var i = 1; i <= linkCount; i++){
			str += 
			'<table>' +
				'<hr>' +
				'<tr>' +
					'<th>Link ' + i + '</th>' +
				'</tr>' +
				'<tr>' +
					'<td><span style="margin-left: 20px">SimilarityCloumnName : <input class="easyui-numberbox" name="Link' + i + '_similarity_columnName" data-options="required:true" validtype="length[0,3]" style="width: 50px;height:25px"></span></td>' +
				'</tr>' +
				'<tr>' +
					'<td><span style="margin-left: 20px">Cat A.</span></td>' +
				'</tr>' +
				'<tr style="margin-left: 10">' +
					'<td>' +
						'<p style="margin-left: 40px">' +
							'CloumnName : <input class="easyui-numberbox" name="Link' + i + '_A_columnName" data-options="required:true" validtype="length[0,3]" style="width: 50px;height:25px">&nbsp;' +
							'Alias : <input class="easyui-textbox" name="Link' + i + '_A_alias" data-options="required:true" validtype="length[0,3]" style="width: 50px;height:25px">' +
						'</p>' +
					'</td>' +
				'</tr>' +
				'<tr>' +
					'<td>' +
						'<span style="margin-left: 20px" >' +
						'Cat B.' +
						'<a id="Link' + i + '_B_columnAdd" class="easyui-linkbutton" iconCls="icon-add" onclick="columnAdd(\'Link' + i + '\',\'B\')" style="height: 15px"></a>' +
						'<a id="Link' + i + '_B_columnRemove" class="easyui-linkbutton" iconCls="icon-remove" onclick="columnRemove(\'Link' + i + '\',\'B\')" style="height: 15px"></a>' +
						'</span>' +
					'</td>' +
				'</tr>' +
				'<tr style="margin-left: 10">' +
					'<td id="Link' + i + '_B_column"></td>' +
				'</tr>' +
				'<tr>' +
					'<td>' +
						'<span style="margin-left: 20px" >' +
						'Cat C.' +
						'<a id="Link' + i + '_C_columnAdd" class="easyui-linkbutton" iconCls="icon-add" onclick="columnAdd(\'Link' + i + '\',\'C\')" style="height: 15px"></a>' +
						'<a id="Link' + i + '_C_columnRemove" class="easyui-linkbutton" iconCls="icon-remove" onclick="columnRemove(\'Link' + i + '\',\'C\')" style="height: 15px"></a>' +
						'</span>' +
					'</td>' +
				'</tr>' +
				'<tr style="margin-left: 10">' +
					'<td id="Link' + i + '_C_column"></td>' +
				'</tr>' +
			'</table>'
			
    	}
		
		str += 
			'</form>' +
			'<hr>' + 
			'<div style="padding:5px">' + 
		    	'<a href="javascript:" class="easyui-linkbutton" onclick="submitForm()">Submit</a>' +
			'</div>';
		
		$("#table").html(str);
	  	$.parser.parse($('#table'));
	}
	
	

</script>