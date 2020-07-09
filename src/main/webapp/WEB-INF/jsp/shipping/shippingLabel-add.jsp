<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<div style="margin-top: 20px" align="center">
		<table id="shippingLabelAddList"></table>
	</div>
	
	<script type="text/javascript"> 
	
	function shippingLabelAddFunction(tpo,sid){
		// 根据tpo获取id
		$.get("getIdByTpo?tpo="+tpo,function(result){
			var id = result.data;
			$('#shippingLabelAddList').datagrid({
				title: '',  																//表格名称
				width:1330,   																//表格宽度
				border:true,  																//表格是否显示边框
				url:"listNotToChooseTpo2?id="+id+"&time="+new Date(),						//获取表格数据时请求的地址
				columns:[[
					{field:'id',title:'id',hidden:true},
					{field:'tid',title:'tid',hidden:true},
					{field:'item',title:'Item',align:'center',width:50},
					{field:'ubotPn',title:'P/N',align:'center',width:150},
					{field:'desc',title:'DWG NO',align:'center',width:200},
					{field:'uom',title:'UOM',align:'center',width:150},
					{field:'qty',title:'QTY',align:'right',width:150,
						formatter: function (val, row) {
							return val.toString().replace(/(\d)(?=(?:\d{3})+$)/g, '$1,');
						}
					},
					{field:'etdDate',title:'ETD Date',align:'center',width:150},
					{field:'requirement',title:'Requirement	',align:'center',width:450}
				]],
				pagination:true,					//如果表格需要支持分页，必须设置该选项为true
				pageSize:20,   						//表格中每页显示的行数
				pageList:[5,10,15,20],				//自定义表格选择要显示的行数
				rownumbers:false,   				//是否显示行号
				nowrap: false,   					
				striped: true,  					//奇偶行是否使用不同的颜色
				method:'get',  						//表格数据获取方式,请求地址是上面定义的url
				singleSelect:false,					//设置单选
				idField: 'id',						//表明该列是一个唯一列
				loadMsg:'Data Loading...',   		//加载数据时显示提示信息
				frozenColumns: [[  					//固定在表格左侧的栏
					{field: 'ck', checkbox: true},
				]],
				showFooter: true,
				toolbar: [{
			        text:'Save',
			        iconCls:'icon-save',
			        handler:function(){
			        	var list = $("#shippingLabelAddList").datagrid("getSelections");
			    		if(list.length == 0){
			    			$.messager.alert('Message','Please select data!');
			    			return;
			    		}
		    			$.messager.confirm('Missage','Are you sure to submit it?',function(r) {
		    				if (r) {
		    					$.ajax({
		    						type : 'POST',
		    						url : "addShippingLabel",
		    						data : '{"listShippingLabel2":'+JSON.stringify(list)+',"tid":"'+id+'","sid":"'+sid+'","tpo":"'+tpo+'"}',
		    						dataType : "json",
		    						contentType : "application/json;charset=UTF-8",
		    						success : function(result) {
		    							$('#shippingLabelDetailsList').datagrid('reload');
		    							$('#shippingLabelList').datagrid('reload');
				    					$('#shippingLabelAddWindow').window('close');
		    						}
		    					});
		    				}
		    			});
			        }
			    }]
			});
		});
		
	}
	
	</script>
