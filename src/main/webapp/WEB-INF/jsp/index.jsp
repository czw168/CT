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
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-easyui-1.7.2/locale/easyui-lang-zh_CN.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery.serializejson.js"></script>
</head>

<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:50px;padding:10px;">Carrier Tape System&nbsp;&nbsp;&nbsp;Current User ：[${subject.principal}]&nbsp;&nbsp;<a href="doLogout" class="easyui-linkbutton">LogOut</a></div>
   	
   	<div data-options="region:'west',title:'Menu',split:true" style="width:270px;">
   		<div style="margin-top: 10px;margin-left: 10px;">
	   		<ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
	         	<li data-options="state:'closed'">
	         		<span>Use Information</span>
	         		<ul>
		         		<li data-options="attributes:{'url':'${pageContext.request.contextPath}/user/user-list'}">User</li>
		         		<li data-options="attributes:{'url':'${pageContext.request.contextPath}/user/role-list'}">Role</li>
		         		<li data-options="attributes:{'url':'${pageContext.request.contextPath}/user/permission-list'}">Permission</li>
		         	</ul>
	         	</li>
	         	<li>
	         		<span>Product Information</span>
	         		<ul>
		         		<li data-options="attributes:{'url':'${pageContext.request.contextPath}/product/product-list'}">Product Information</li>
		         	</ul>
	         	</li>
	         	<li>
	         		<span>Customer Information</span>
	         		<ul>
		         		<li data-options="attributes:{'url':'${pageContext.request.contextPath}/customer/customerInfo-list'}">Customer Information</li>
	         			<li data-options="attributes:{'url':'${pageContext.request.contextPath}/customer/customerPN-list'}">Customer Product P/N List</li>
		         	</ul>
	         	</li>
	         	<li>
	         		<span>Production Manager</span>
	         		<ul>
		         		<li data-options="attributes:{'url':'${pageContext.request.contextPath}/production/jo-list'}">JO</li>
		         		<li data-options="attributes:{'url':'${pageContext.request.contextPath}/production/ltc-list'}">LTC</li>
		         		<li data-options="attributes:{'url':'${pageContext.request.contextPath}/production/reelLabel-list'}">Reel Label</li>
		         		<li data-options="attributes:{'url':'${pageContext.request.contextPath}/production/packingLabel-list'}">Packing Label</li>
		         	</ul>
	         	</li>
	         	<li>
	         		<span>Shipping Manager</span>
	         		<ul>
		         		<li data-options="attributes:{'url':'${pageContext.request.contextPath}/shipping/tpo-list'}">TPO</li>
		         		<li data-options="attributes:{'url':'${pageContext.request.contextPath}/shipping/shippingLabel-list'}">Shipping Label</li>
		         	</ul>
	         	</li>
         	</ul>
         	<div style="margin-left: 10px;margin-top: 10px"><a href="${pageContext.request.contextPath}/reportMenu" class="easyui-linkbutton" style="width: 150px">Report</a></div>
   		</div>
    </div>
    
    <div data-options="region:'center',title:''">
		<div id="tabs" class="easyui-tabs" style="height:100%;">
			<div id="index" title="index" style="padding:0px 20px;">
				<h1>Welcome！</h1>				
			</div>
		</div>
    </div>

<script type="text/javascript">

	$('#menu').tree({
		onClick: function(node){
			if($('#menu').tree("isLeaf",node.target)){
				var tabs = $("#tabs");
				var tab = tabs.tabs("getTab",node.text);
			    if(tab){
					RefreshTab(tab,node.attributes.url);
					tabs.tabs('select', node.text);
				}else{
					// 关闭当前tab
				    var currTab = tabs.tabs('getSelected');
				    if(currTab){
				        $('#tabs').tabs('close',currTab.panel('options').title);
				    }
					// iframe
					var content = '<iframe scrolling="auto" frameborder="0"  src="'+node.attributes.url+'" style="width:100%;height:100%;"></iframe>';
					tabs.tabs('add',{
						title:node.text,
						content:content,
						closable:true
					});
				}
			}
		}
	});
	
	$('#tabs').tabs({
	    border:false,
	    // 点击菜单树或tab事件
	    onSelect:function(title,index){
	        var currentTab = $('#tabs').tabs('getSelected');
	        // 刷新tab
	        RefreshTab(currentTab);
	    }
	});
		
	// 刷新tab
	function RefreshTab(currentTab) {
		var url = $(currentTab.panel('options')).attr('href');
		$('#tabs').tabs('update', {
			tab: currentTab,
			options: {
				href: url
			}
		});
	}

</script>

</body>
</html>