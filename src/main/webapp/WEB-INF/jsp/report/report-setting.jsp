<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UBoT</title>
<!-- easyui -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/demo/demo.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/locale/easyui-lang-en.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery.serializejson.js"></script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:45px;padding:10px;">Carrier Tape System&nbsp;&nbsp;&nbsp;Current User ：[${subject.principal}]<!-- &nbsp;&nbsp;<input type="button" value="注销" onclick="loginOut()"/> --></div>
   	
    <div data-options="region:'center',title:''">
		<div id="tabs" class="easyui-tabs" style="height:100%;">
			<div id="index" title="Report parameter setting" style="padding:20px;">
				<input style="margin-left: 1250px" type="button" id="goBack" value="Return"/>
				<div style="margin-top: 5px"></div>
				<div style="margin-left: 560px;margin-bottom: 5px">
					<form id="from" >
							productNo. <input class="easyui-textbox" id="productNo" data-options="validType:'length[1,5]'"/>&nbsp;&nbsp;
							<a class="easyui-linkbutton" onclick="doSearch()">Search</a>&nbsp;&nbsp;
							<a href="javascript:" class="easyui-linkbutton" onclick="clearForm()">Reset</a>
					</form>
				</div>
				<div align="center">
					<table id="dataList"></table>
				</div>
			</div>
		</div>
    </div>
    <div id="reportSettingAddWindow" class="easyui-window" title="Add" data-options="closed:true,iconCls:'icon-save',href:'./report-setting-add'" style="width:100%;height:100%;padding:10px;"></div>
    <div id="reportSettingEditWindow" class="easyui-window" title="Edit" data-options="closed:true,iconCls:'icon-save',href:'./report-setting-edit'" style="width:100%;height:100%;padding:10px;"></div>

<script type="text/javascript">
	
	$(document).ready(function(){
		$('#dataList').datagrid({
			width:750,   							//表格宽度
			border:true,  							//表格是否显示边框
			url:'${pageContext.request.contextPath}/report/getReportSettings',   	//获取表格数据时请求的地址
			columns:[[
				{field:'id',title:'id',hidden:true},
				{field:'productNumber',title:'productNo.',align:'left',width:200,formatter:function(val,rows){
					 return "<a style='text-decoration: none' href='javascript:' onclick='reportSettingInfoWindowOpen(" + val + ")'>" + val + "</a>";
				}},
				{field:'tableName',title:'tableName',align:'center',width:200},
				{field:'linkCount',title:'linkCount',align:'center',width:150}
				//{field:'lotNumberColumnName',title:'lotNumberColumnName',hidden:true}
			]],
			pagination:false,					//如果表格需要支持分页，必须设置该选项为true
			pageSize:20,   						//表格中每页显示的行数
			pageList:[5,10,15,20],				//自定义表格选择要显示的行数
			rownumbers:true,   					//是否显示行号
			nowrap: false,   					
			striped: true,  					//奇偶行是否使用不同的颜色
			method:'get',  						//表格数据获取方式,请求地址是上面定义的url
			sortName: 'ID',  					//按照ID列的值排序
			sortOrder: 'desc',  				//使用倒序排序
			singleSelect:true,					//设置单选
			idField: 'id',						//表明该列是一个唯一列
			//loadMsg:'数据正在努力加载，请稍后...',   	//加载数据时显示提示信息
			frozenColumns: [[  					//固定在表格左侧的栏
				{field: 'ck', checkbox: true},
			]],
			toolbar: [{
		        text:'Add',
		        iconCls:'icon-add',
		        handler:function(){
		        	$("#reportSettingAddWindow").window().window("open");
		        }
		    },{
		        text:'Edit',
		        iconCls:'icon-edit',
		        handler:function(){
		        	var sel = $("#dataList").datagrid("getSelections");
		        	if(sel.length == 0){
		        		$.messager.alert('Message','Please select one piece of data!');
		        		return;
		        	}
		        	
		        	$("#reportSettingEditWindow").window({
		        		onLoad :function(){
		        			// 获取所选行数据
		        			var data = $("#dataList").datagrid("getSelections")[0];
		        			// 截取后面的数字
		        			var lotNumberColumnName = data.lotNumberColumnName.substring(6);
		        			//回显数据
		        			$("#reportSettingEditForm").form("load",data);
		        			
		        			$("#edit_productNumber").combobox('disable');
		                	$("#edit_tableName").combobox('disable');
		                	$("#edit_linkCount").numberbox('disable');
		                	$("#edit_lotNumberColumnName").numberbox('disable');
		                	$("#edit_lotNumberColumnName").numberbox('setValue',lotNumberColumnName);
		        			
		        			var str = '<form id="reportSettingEditForm2" method="post">';
		        			
		        			for(var i = 1; i <= data.linkCount; i++){
		        				str += 
		        				'<table>' +
		        					'<hr>' +
		        					'<tr>' +
		        						'<th>Link ' + i + '</th>' +
		        					'</tr>' +
		        					'<tr>' +
		        						'<td><span style="margin-left: 20px">SimilarityCloumnName : <input class="easyui-numberbox" name="edit_Link' + i + '_similarity_columnName" id="edit_Link' + i + '_similarity_columnName" data-options="required:true" validtype="length[0,3]" style="width: 50px;height:25px"></span></td>' +
		        					'</tr>' +
		        					'<tr>' +
		        						'<td><span style="margin-left: 20px">Cat A.</span></td>' +
		        					'</tr>' +
		        					'<tr style="margin-left: 10">' +
		        						'<td>' +
		        							'<p style="margin-left: 40px">' +
		        								'CloumnName : <input class="easyui-numberbox" name="edit_Link' + i + '_A_columnName" id="edit_Link' + i + '_A_columnName" data-options="required:true" validtype="length[0,3]" style="width: 50px;height:25px">&nbsp;' +
		        								'Alias : <input class="easyui-textbox" name="edit_Link' + i + '_A_alias" id="edit_Link' + i + '_A_alias" data-options="required:true" validtype="length[0,3]" style="width: 50px;height:25px">' +
		        							'</p>' +
		        						'</td>' +
		        					'</tr>' +
		        					'<tr>' +
		        						'<td>' +
		        							'<span style="margin-left: 20px" >' +
		        							'Cat B.' +
		        							'<a id="edit_Link' + i + '_B_columnAdd" class="easyui-linkbutton" iconCls="icon-add" onclick="columnAdd(\'Link' + i + '\',\'B\')" style="height: 15px"></a>' +
		        							'<a id="edit_Link' + i + '_B_columnRemove" class="easyui-linkbutton" iconCls="icon-remove" onclick="columnRemove(\'Link' + i + '\',\'B\')" style="height: 15px"></a>' +
		        							'</span>' +
		        						'</td>' +
		        					'</tr>' +
		        					'<tr style="margin-left: 10">' +
		        						'<td id="edit_Link' + i + '_B_column"></td>' +
		        					'</tr>' +
		        					'<tr>' +
		        						'<td>' +
		        							'<span style="margin-left: 20px" >' +
		        							'Cat C.' +
		        							'<a id="edit_Link' + i + '_C_columnAdd" class="easyui-linkbutton" iconCls="icon-add" onclick="columnAdd(\'Link' + i + '\',\'C\')" style="height: 15px"></a>' +
		        							'<a id="edit_Link' + i + '_C_columnRemove" class="easyui-linkbutton" iconCls="icon-remove" onclick="columnRemove(\'Link' + i + '\',\'C\')" style="height: 15px"></a>' +
		        							'</span>' +
		        						'</td>' +
		        					'</tr>' +
		        					'<tr style="margin-left: 10">' +
		        						'<td id="edit_Link' + i + '_C_column"></td>' +
		        					'</tr>' +
		        				'</table>'
		        				
		        	    	}
		        			
		        			str += 
		        				'</form>' +
		        				'<hr>' + 
		        				'<div style="padding:5px">' + 
		        			    	'<a href="javascript:" class="easyui-linkbutton" onclick="submitForm()">Submit</a>' +
		        				'</div>';
		        			
		        			$("#edit_table").html(str);
		        		  	$.parser.parse($('#edit_table'));
		        		  	
 		        		  	var paramDetail =  data.paramDetail;
 		        		  	
							for(var j = 0; j < paramDetail.length; j++){
								var link = "Link" + (j + 1);
								var columnDetail = paramDetail[j].columnDetail;
								var similarityColumnName = paramDetail[j].similarityColumnName;
								// 截取后面的数字
								similarityColumnName = similarityColumnName.substring(6);
								for(var y = 0; y < columnDetail.length; y++){
									var columnName = columnDetail[y].columnName;
									// 截取后面的数字
									columnName = columnName.substring(6);
									var alias = columnDetail[y].alias;
									var group = columnDetail[y].group;
									if(group != "A"){
										columnAdd(link,group,columnName,alias);
									}else{
										var similarityCloumnNameId = "#edit_" + link + "_similarity_columnName";
										$(similarityCloumnNameId).numberbox('setValue',similarityColumnName);
										
										var cloumnNameId = "#edit_" + link + "_A_columnName";
										$(cloumnNameId).numberbox('setValue',columnName);
										
										var aliasId = "#edit_" + link + "_A_alias";
										$(aliasId).textbox('setValue',alias);
									}
								}
							}
		        			
		        		}
		        	}).window("open");
		        }
		    },{
		        text:'Delete',
		        iconCls:'icon-cancel',
		        handler:function(){
		        	var sel = $("#dataList").datagrid("getSelections");
		        	if(sel.length == 0){
		        		$.messager.alert('Message','Please select one piece of data!');
		        		return;
		        	}
		        	
		        	// 获取所选行数据
        			var data = $("#dataList").datagrid("getSelections")[0];
		        	$.messager.confirm('Message','Are you sure you would like to delete？',function(r){
		        	    if (r){
		                	$.ajax({
		                		  type: 'POST',
		                		  url: "${pageContext.request.contextPath}/report/deleteReportSetting",
		                		  data:'{"id":"'+data.id+'","tableName":"'+data.tableName+'"}',
		                		  dataType: "json",
		                		  contentType: "application/json;charset=UTF-8",
		                		  success: function(result){
		                			  $.messager.alert("Message", result.msg);
				        				if(result.status == 200){
				        					$('#dataList').datagrid('reload');
				        				} 
		                		  }
		                	});
		        	    }
		        	});
		        }
		    } ],
		});
	});
	
// 	//返回所选行数据的ID，非列表ID
// 	function getSelectionsIds(){
// 		var dataList = $("#dataList");
// 		var sels = dataList.datagrid("getSelections");
// 		var ids = [];
// 		for(var i in sels){
// 			ids.push(sels[i].id);
// 		}
// 		ids = ids.join(",");
// 		return ids;
// 	}
	
	$("#goBack").click(function(){
		location.href = "${pageContext.request.contextPath}/report/reportIndex4";
	});
	
	// 注销
// 	function loginOut(){
// 		$.post("${pageContext.request.contextPath}/user/loginOut", function(result){
// 			if(result.status == 200){
// 				location.href = "${pageContext.request.contextPath}";
// 			}
// 		});
// 	}
	
	function doSearch(){
		var validate = $("#from").form('validate');
        if (!validate) {
			$("#from").find(".validatebox-invalid:first").focus();
            return false;
        }
		
		var productNo = $("#productNo").textbox("getValue");
		$('#dataList').datagrid('load',{
			productNumber : productNo
		});
	}
	
	function clearForm(){
		$('#from').form('reset');
	}
	
	// ajax错误
	$(document).ajaxError(function(e, jqXHR, options, errorMsg){
	    //no login
	    if(errorMsg == "Unauthorized") {
	        location.href = "${pageContext.request.contextPath}";
	    }
	});
	
</script>
</body>
</html>