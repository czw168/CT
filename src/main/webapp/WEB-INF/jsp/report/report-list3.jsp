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
<!-- echarts -->
<script src="${pageContext.request.contextPath}/statics/echarts-4.7.0/dist/echarts.min.js"></script>
<body>

<%-- <div id="pictureWindow" class="easyui-window" title="Picture" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/report/picture',maximized:true" ></div> --%>
<div id="pictureWindowA" class="easyui-window" title="Group A" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/report/pictureA'" style="width:850px;height:850px" ></div>
<div id="pictureWindowB" class="easyui-window" title="Group B" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/report/pictureB'" style="width:850px;height:850px" ></div>
<div id="pictureWindowC" class="easyui-window" title="Group C" data-options="closed:true,iconCls:'icon-save',href:'${pageContext.request.contextPath }/report/pictureC'" style="width:850px;height:850px" ></div>


	<!-- <table class="easyui-datagrid" title="Result" style="width:1000px;"
            data-options="
            			singleSelect:true,
            			pagination:true,
            			pageSize:10,pageList:[5,10,15,20],
            			loadMsg:'The amount of data is huge. Please wait a moment...'">
        <thead>
            <tr>
                <th data-options="field:'actualOkCount',width:80,align:'right',halign:'center'">A</th>
                <th data-options="field:'actualOkCount',width:80,align:'right',halign:'center'">B</th>
                <th data-options="field:'actualOkCount',width:80,align:'right',halign:'center'">C</th>
            </tr>
        </thead>
        <tbody>
        	<tr>
	            <td>5</td>
	            <td>2</td>
	            <td>7</td>
        	</tr>
    	</tbody>
    </table> -->
    
    <%-- <table class="easyui-datagrid" style="width:302px;" data-options="
            			loadMsg:'The amount of data is huge. Please wait a moment...',
            			method:'GET',
            			url:'${pageContext.request.contextPath}/report/report3?table=${table}&lotNo=${lotNo}'
            			">
	    <thead>
	        <tr>
	            <th data-options="field:'acount',width:100">A</th>
	            <th data-options="field:'bcount',width:100">B</th>
	            <th data-options="field:'ccount',width:100">C</th>
	            <th data-options="field:'pictureAUrls',width:100,hidden:true"></th>
	            <th data-options="field:'pictureBUrls',width:100,hidden:true"></th>
	            <th data-options="field:'pictureCUrls',width:100,hidden:true"></th>
	        </tr>
	    </thead>
	    <tbody>
	        <tr>
	            <td><a onclick="pictureOpen('A')"></a></td>
	            <td><a onclick="pictureOpen('B')"></a></td>
	            <td><a onclick="pictureOpen('C')"></a></td>
	        </tr>
	    </tbody>
	</table> --%>
	
	<table id="report3"></table>


<script type="text/javascript">


$('#report3').datagrid({
	title: '',
	width:'302px',
	border:true,
	url:'${pageContext.request.contextPath}/report/report3?table=${table}&lotNo=${lotNo}',
	columns:[[
		{field:'acount',title:'A',width:100,formatter: function (val, rows) {
	        return "<a href='#' onclick='pictureOpen(\"A\")'>" + val + "</a>";
		}},
		{field:'bcount',title:'B',width:100,formatter: function (val, rows) {
	        return "<a href='#' onclick='pictureOpen(\"B\")'>" + val + "</a>";
		}},
		{field:'ccount',title:'C',width:100,formatter: function (val, rows) {
	        return "<a href='#' onclick='pictureOpen(\"C\")'>" + val + "</a>";
		}},
		{field:'pictureAUrls',hidden:true},
		{field:'pictureBUrls',hidden:true},
		{field:'pictureCUrls',hidden:true}
	]],
	pagination:false,					//如果表格需要支持分页，必须设置该选项为true
	pageSize:5,   						//表格中每页显示的行数
	pageList:[5,10,15,20],				//自定义表格选择要显示的行数
	rownumbers:false,   					//是否显示行号
	nowrap: false,   					
	striped: true,  					//奇偶行是否使用不同的颜色
	method:'get',  						//表格数据获取方式,请求地址是上面定义的url
	//sortName: 'ID',  					//按照ID列的值排序
	sortOrder: 'desc',  				//使用倒序排序
	singleSelect:true,				//设置单选
	//idField: 'id',						//表明该列是一个唯一列
	//loadMsg:'数据正在努力加载，请稍后...'   	//加载数据时显示提示信息
});


function pictureOpen(val){
	// 获取第一行的数据
	var data = $('#report3').datagrid('getData').rows[0];
	if(val == "A"){
		$("#pictureWindowA").window({
			onLoad :function(){
				var urls = data.pictureAUrls;
				var str = "";
				for(var i = 0; i < urls.length; i++){
					// url中特殊字符处理
					var url = urls[i].replace(/\&/g,"%26");
					str += "<tr>";
					// window操作系统
					if(urls[i].indexOf("\\") >= 0){
						str += '<td><span style=\"font-size:20px\">' + (i+1) + '.&nbsp;&nbsp;&nbsp;' + urls[i].substring(urls[i].lastIndexOf("\\") + 1) + '</span><br><br>';
					}else{
						// linux
						str += '<td><span style=\"font-size:20px\">' + (i+1) + '.&nbsp;&nbsp;&nbsp;' + urls[i].substring(urls[i].lastIndexOf("/") + 1) + '</span><br><br>';
					}
					str += "<img src ='${pageContext.request.contextPath}/report/getImage?url=" + url + "'><hr></td>";
					str += 	"</tr>";
				}
				$("#catA").html(str);
			}
		}).window("open");
	}
	if(val == "B"){
		$("#pictureWindowB").window({
			onLoad :function(){
				var urls = data.pictureBUrls;
				var str = "";
				for(var i = 0; i < urls.length; i++){
					// url中特殊字符处理
					var url = urls[i].replace(/\&/g,"%26");
					str += "<tr>";
					// window操作系统
					if(urls[i].indexOf("\\") >= 0){
						str += '<td><span style=\"font-size:20px\">' + (i+1) + '.&nbsp;&nbsp;&nbsp;' + urls[i].substring(urls[i].lastIndexOf("\\") + 1) + '</span><br><br>';
					}else{
						// linux
						str += '<td><span style=\"font-size:20px\">' + (i+1) + '.&nbsp;&nbsp;&nbsp;' + urls[i].substring(urls[i].lastIndexOf("/") + 1) + '</span><br><br>';
					}
					str += "<img src ='${pageContext.request.contextPath}/report/getImage?url=" + url + "'><hr></td>";
					str += 	"</tr>";
				}
				$("#catB").html(str);
			}
		}).window("open");	
	}
	if(val == "C"){
		$("#pictureWindowC").window({
			onLoad :function(){
				var urls = data.pictureCUrls;
				var str = "";
				for(var i = 0; i < urls.length; i++){
					// url中特殊字符处理
					var url = urls[i].replace(/\&/g,"%26");
					str += "<tr>";
					// window操作系统
					if(urls[i].indexOf("\\") >= 0){
						str += '<td><span style=\"font-size:20px\">' + (i+1) + '.&nbsp;&nbsp;&nbsp;' + urls[i].substring(urls[i].lastIndexOf("\\") + 1) + '</span><br><br>';
					}else{
						// linux
						str += '<td><span style=\"font-size:20px\">' + (i+1) + '.&nbsp;&nbsp;&nbsp;' + urls[i].substring(urls[i].lastIndexOf("/") + 1) + '</span><br><br>';
					}
					str += "<img src ='${pageContext.request.contextPath}/report/getImage?url=" + url + "'><hr></td>";
					str += 	"</tr>";
				}
				$("#catC").html(str);
			}
		}).window("open");
	}
	
}

	
</script>
</body>
</html>