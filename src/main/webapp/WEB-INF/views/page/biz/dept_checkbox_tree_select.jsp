<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>行业选择</title>
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href='<c:url value='/js/lib/ztree/css/zTreeStyle/zTreeStyle.css'/>'>
    <link rel="stylesheet" href="<c:url value='/css/system.css'/>">
</head>
<body class="pd20">
<ul id="sysDepartTree" class="ztree ztree-list"></ul>
<div class="center mt20">
   <input type="button" id="checkAll" class="btn btn-sm mr20" value="全选"/>
   <input type="button" id="departmentSubmit" class="btn btn-sm mr20" value="确定"/>
   <input id="cancle"  type="button" class="btn btn-sm" value="取消"/>
</div>
<script src='<c:url value="/js/lib/require.js"/>'></script>
<script src='<c:url value="/js/config.js"/>'></script>
<script src='<c:url value="/js/common/tax_dept_checkbox_tree_select.js"/>'></script>
<script type="text/javascript">
    window._CONFIG = {
        treeUrl: '<c:url value="/industry/registTreeList"/>'
    }
</script>
</body>
</html>
