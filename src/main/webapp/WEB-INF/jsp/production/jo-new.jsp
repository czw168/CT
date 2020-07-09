<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<table id="joNewList"></table>
	<div id="joAddWindow" class="easyui-window" title="JO Add" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/production/jo-add'"  style="width:600px;height:600px;padding:10px;" ></div>
	
	<script type="text/javascript"> 
		
		function joNewFunction(joNo){
			$('#joNewList').datagrid({
				title: '',  																//表格名称
				width:1634,   																//表格宽度
				border:true,  																//表格是否显示边框
				url:"listDetailsJO?joNo="+joNo+"&time="+new Date(),								//获取表格数据时请求的地址
				columns:[[
					{field:'id',title:'id',hidden:true},
					{field:'ubotJo',title:'JO NO.',align:'center',width:150,hidden:true},
					{field:'item',title:'Item',align:'center',width:50,editor:{type:'textbox',options:{readonly:true}}},
					{field:'ubotPn',title:'P/N',align:'center',width:180},
					{field:'desc',title:'DWG NO.',align:'center',width:200,editor:{type:'textbox',options:{readonly:true}}},
					{field:'customerName',title:'CustomerName',align:'center',width:180},
					{field:'custPn',title:'Customer P/N',align:'center',width:200,editor:{type:'textbox',options:{readonly:true}}},
					{field:'uom',title:'UOM',align:'center',width:100,editor:{type:'textbox',options:{readonly:true}}},
					{field:'orderQuantity',title:'QTY',align:'right',width:100,editor:{type:'numberbox',options:{required:true}}},
					{field:'date',title:'FinishDate',align:'center',width:150},
					{field:'remarks',title:'Requirement',align:'center',width:442,editor:{type:'textbox',options:{validType:['length[0,300]']}}},
					{field:'createBy',title:'CreateBy',align:'center',width:200,editor:{type:'textbox',options:{readonly:true}},hidden:true}
				]],
				pagination:true,					//如果表格需要支持分页，必须设置该选项为true
				pageSize:20,   						//表格中每页显示的行数
				pageList:[5,10,15,20],				//自定义表格选择要显示的行数
				rownumbers:false,   					//是否显示行号
				nowrap: false,   					
				striped: true,  					//奇偶行是否使用不同的颜色
				method:'get',  						//表格数据获取方式,请求地址是上面定义的url
				//sortName: 'ID',  					//按照ID列的值排序
				//sortOrder: 'ubotJo',  				//使用倒序排序
				singleSelect:true,					//设置单选
				idField: 'id',						//表明该列是一个唯一列
				loadMsg:'Data Loading...',   		//加载数据时显示提示信息
				frozenColumns: [[  					//固定在表格左侧的栏
					{field: 'ck', checkbox: true},
				]],
				showFooter: true,
				toolbar: [{
			        text:'Add',
			        iconCls:'icon-add',
			        handler:function(){
			        	$("#joAddWindow").window({
			        		onLoad :function(){
			        			$('#joAdd_uom').textbox('textbox').css('background','#ccc');
			        			$("#joAdd_ubotJo").val(joNo);
			        		}
			        	}).window("open");
			        }
			    },{text:'<span style="margin-left: 550px;color: red;font-weight: bold;">JO NO. : <span id="joNo_new">'+joNo+'</span></span>'}]
			});
		}

		
		
	</script>
