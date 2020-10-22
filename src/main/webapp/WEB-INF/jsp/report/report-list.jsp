<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- easyui -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/demo/demo.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/locale/easyui-lang-en.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery.serializejson.js"></script>
<body>

<div>
	<!-- <div id="searchTitle" style="margin-bottom: 5px;font-size: 15px"></div> -->
	<!-- <table id="engineeringReportList"></table> -->
	<table class="easyui-datagrid" style="width:802px;"
            data-options="
            			singleSelect:true,
            			pagination:false,
            			pageSize:10,pageList:[5,10,15,20],
            			loadMsg:'The amount of data is huge. Please wait a moment...',
            			method:'GET',
            			url:'${pageContext.request.contextPath}/report/report1?date=${date}'">
        <thead>
            <tr>
                <th data-options="field:'lotNo',width:160,align:'center'" rowspan="2">Lot No.</th>
                <th colspan="4">OK</th>
                <th colspan="4">NG</th>
            </tr>
            <tr>
                <th data-options="field:'actualOkCount',width:80,align:'right',halign:'center',styler:okCellStyler,formatter: function (val, row) {
					return (parseFloat(val) + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
				}">Count.</th>
                <th data-options="field:'okAvg',width:80,align:'right',halign:'center',styler:okCellStyler,formatter: function (val, row) {
					return val.toFixed(3);
				}">Avg.</th>
                <th data-options="field:'okMax',width:80,align:'right',halign:'center',styler:okCellStyler,formatter: function (val, row) {
					return val.toFixed(3);
				}">Max.</th>
                <th data-options="field:'okMin',width:80,align:'right',halign:'center',styler:okCellStyler,formatter: function (val, row) {
					return val.toFixed(3);
				}">Min.</th>
                <th data-options="field:'actualNgCount',width:80,align:'right',halign:'center',styler:ngCellStyler,formatter: function (val, row) {
					return (parseFloat(val) + '').replace(/\d{1,3}(?=(\d{3})+(\.\d*)?$)/g, '$&,');
				}">Count.</th>
                <th data-options="field:'ngAvg',width:80,align:'right',halign:'center',styler:ngCellStyler,formatter: function (val, row) {
					return val.toFixed(3);
				}">Avg.</th>
                <th data-options="field:'ngMax',width:80,align:'right',halign:'center',styler:ngCellStyler,formatter: function (val, row) {
					return val.toFixed(3);
				}">Max.</th>
                <th data-options="field:'ngMin',width:80,align:'right',halign:'center',styler:ngCellStyler,formatter: function (val, row) {
					return val.toFixed(3);
				}">Min.</th>
            </tr>
           <!--  <tr>
                <th data-options="field:'listprice',width:80,align:'right'">Count.</th>
                <th data-options="field:'unitcost',width:80,align:'right'">Avg.</th>
                <th data-options="field:'attr1',width:240">Max.</th>
                <th data-options="field:'status',width:60,align:'center'">Min.</th>
            </tr> -->
        </thead>
    </table>
	
</div>

<script type="text/javascript">

function okCellStyler(value,row,index){
	return 'background-color:#00FF00';
}

function ngCellStyler(value,row,index){
	return 'background-color:#FF6600';
}


$(document).ready(function(){
	
	var date = "${date}";
	
	/* $('#engineeringReportList').datagrid({
		title: '',
		width:1200,
		border:true,
		//url:"${pageContext.request.contextPath}/report/report1?date="+date,
		columns:[[
			{field:'lotNo',title:'lotNo'},
			{field:'actualOkCount',title:'actualOkCount',align:'left',width:160},
			{field:'okAvg',title:'okAvg',align:'left',width:100},
			{field:'okMax',title:'okMax',align:'left',width:100},
			{field:'okMin',title:'okMin',align:'left',width:60},
			{field:'actualNgCount',title:'actualNgCount',align:'left',width:100},
			{field:'ngAvg',title:'ngAvg',align:'left',width:100},
			{field:'ngMax',title:'ngMax',align:'left',width:100},
			{field:'ngMin',title:'ngMin',align:'left',width:100}
		]],
		pagination:false,					//如果表格需要支持分页，必须设置该选项为true
		pageSize:5,   						//表格中每页显示的行数
		pageList:[5,10,15,20],				//自定义表格选择要显示的行数
		rownumbers:true,   					//是否显示行号
		nowrap: false,   					
		striped: true,  					//奇偶行是否使用不同的颜色
		method:'get',  						//表格数据获取方式,请求地址是上面定义的url
		sortName: 'ID',  					//按照ID列的值排序
		sortOrder: 'desc',  				//使用倒序排序
		singleSelect:true,					//设置单选
		idField: 'id',						//表明该列是一个唯一列
		loadMsg:'数据正在努力加载，请稍后...'   	//加载数据时显示提示信息
	}); */
	
	/* if(null!=drawingNo && ""!=drawingNo){
		$("#searchTitle").html("图纸编号：" + drawingNo+"&nbsp;");
	}
	$("#searchTitle").append("修模时间由：" + startDate + "至" + endDate); */
});
	
</script>
</body>
</html>