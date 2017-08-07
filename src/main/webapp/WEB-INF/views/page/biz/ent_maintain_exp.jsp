<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>事中排除维护企业列表</title>
	<link rel="stylesheet" href="<c:url value='/js/lib/layer/skin/layer.css'/> ">
    <link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/> ">
    <link rel="stylesheet" href="<c:url value='/css/system.css'/> ">
</head>
<body class="pd20">

<div class="mb10">
    <span><input id="warning" type="button" value="新增企业名单" class="tax-btn"></span>
    <input type="hidden" id="userID" value="${userID}"/>
</div>
<div id="content">
		<table id="user-table" class="table-row  mt5" width="100%">
			<thead>
				<tr>
					<th>序号</th>
					<th>企业名称</th>
					<th>录入人</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
<script type="text/javascript" src='<c:url value="/js/lib/jquery/jquery-1.12.3.min.js"/>'></script>
<script type="text/javascript" src='<c:url value="/js/lib/jquery/jquery.serialize-object.min.js"/>'></script>
<script src='<c:url value="/js/lib/laydate/laydate.js"/>'></script>
<script src='<c:url value="/js/lib/require.js"/>'></script>
<script src='<c:url value="/js/config.js"/>'></script>
<script src='<c:url value="/js/biz/ent_maintain_exp.js" />'></script>
<script>
    laydate.skin('danlan');
</script>
</html>
