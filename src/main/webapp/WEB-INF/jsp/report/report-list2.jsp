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

	<div id="mmm" style="width: 1600px;height:800px;"></div>
	
	

<script type="text/javascript">

$(document).ready(function(){
	
	var myChart = echarts.init(document.getElementById('mmm'));
	myChart.showLoading();
	// 异步加载数据
	$.get('${pageContext.request.contextPath}/report/report2?lotNo=${lotNo}').done(function (result) {
		myChart.hideLoading();
		
		if(result.status == 400){
			$.messager.alert('massage',result.msg);
			return;
		}
		
	    // 填入数据
	    myChart.setOption({
		 	title: {
		        text: 'A120200629-102'
		    },
		    legend: {
		        data:['W','AO','BO']
		    },
		    xAxis: {
		        data: []
		    },
		    yAxis: {
		        type: 'value',
				max : 30,
				min : 0,
		        splitNumber : 30
		    },
	        series: [{
	        	name: 'W',
	        	type: 'line',
	            data: result.data.ws,
	            color: 'green',
	            smooth: true
	        },{
	            name: 'AO',
	            type: 'line',
	            data: result.data.aos,
	            color: 'red',
	            smooth: true
	        },{
	        	name: 'BO',
	        	type: 'line',
	            data: result.data.bos,
	            color: 'blue',
	            smooth: true
	        }]
	    });
	});
});


	
</script>
</body>
</html>