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

<div id="datagridResult">

	<%-- <table class="easyui-datagrid"
            data-options="
           				fitColumns:true,
            			loadMsg:'The amount of data is huge. Please wait a moment...',
            			method:'GET',
            			url:'${pageContext.request.contextPath}/report/report4?date=${date}&table=${table}'
            			">
        <thead>
            <tr>
                <th data-options="field:'lotNo',align:'center',width:'200'" rowspan="3">Lot No.</th>
                <th data-options="field:'actualOkCount',align:'center',width:'100'" rowspan="3">OK</th>
                <th colspan="19">NG</th>
                <th data-options="field:'result',align:'center',styler:resultStyler,width:'200'" rowspan="3">Result</th>
            </tr>
            <tr>
                <th>Cat.A</th>
                <th colspan="7">Cat.B</th>
                <th colspan="10">Cat.C</th>
                <th>Total</th>
            </tr>
           	<tr>
           		<!-- A组 -->
           		<th data-options="field:'a',align:'center',width:'100'"></th>
           		<!-- B组 -->
                <th data-options="field:'c1',align:'center',width:'50'">C1</th>
                <th data-options="field:'c2',align:'center',width:'50'">C2</th>
                <th data-options="field:'s1',align:'center',width:'50'">S1</th>
                <th data-options="field:'s2',align:'center',width:'50'">S2</th>
                <th data-options="field:'s3',align:'center',width:'50'">S3</th>
                <th data-options="field:'s4',align:'center',width:'50'">S4</th>
                <th data-options="field:'s5',align:'center',width:'50'">S5</th>
                <!-- C组 -->
                <th data-options="field:'sf1',align:'center',width:'50'">SF1</th>
                <th data-options="field:'sf2',align:'center',width:'50'">SF2</th>
                <th data-options="field:'sf3',align:'center',width:'50'">SF3</th>
                <th data-options="field:'sf4',align:'center',width:'50'">SF4</th>
                <th data-options="field:'ed1',align:'center',width:'50'">ED1</th>
                <th data-options="field:'ed2',align:'center',width:'50'">ED2</th>
                <th data-options="field:'ch2',align:'center',width:'50'">CH1</th>
                <th data-options="field:'ch2',align:'center',width:'50'">CH2</th>
                <th data-options="field:'sh1',align:'center',width:'50'">SH1</th>
                <th data-options="field:'sh2',align:'center',width:'50'">SH2</th>
                <!-- Total -->
                <th data-options="field:'actualNgCount',align:'center',width:'100'"></th>
            </tr>
        </thead>
    </table> --%>
    
	
</div>

<script type="text/javascript">

function resultStyler(value,row,index){
	if (value == "OK"){
        return 'color:green;';
    }else{
    	return 'color:red;';
    }
}


$(document).ready(function(){
	
	// 拼接表单
	// 获取指定产品里的组和组里面的字段别名
	$.get("${pageContext.request.contextPath}/report/getDatagrid?date=${date}&productNumber=${table}",function(result){
		console.log(result);
	  	console.log(result.data);
	  	$("#datagridResult").html(result.data);
	  	$.parser.parse($('#datagridResult'));
	});

});
	
</script>
</body>
</html>