<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>权限管理</title>
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/css/vendor/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/js/lib/ztree/css/zTreeStyle/zTreeStyle.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<div class="container .container-fluid">
    <div class="clearfix" style="margin-bottom: 10px;">
        <div class="col-xs-6">
            <form class="form-horizontal" id="sysRoleForm">
                <input type="hidden" name="id" value="${sysRole.id}">
                <div class="form-group">
                    <label class="control-label">角色名称：</label>
                    <input type="text" name="name" class="form-control" placeholder="请输入角色名称"
                           value="${sysRole.name}">
                </div>
                <div class="form-group">
                    <label class="control-label">备注：</label>
                    <textarea name="desc" class="form-control" rows="8" placeholder="请输入角色描述">${sysRole.desc}</textarea>
                </div>
            </form>
        </div>
        <div class="col-xs-6">
            <h5>选择角色权限</h5>
            <ul id="permisionTree" class="ztree"></ul>
        </div>
    </div>
    <div class="row text-center">
        <button id="cancel" type="button" class="btn btn-primary">取消</button>
        <button id="save" type="button" class="btn btn-primary">保存</button>
    </div>
</div>
<script>
    var roleId = '${sysRole.id}';
</script>
<!-- 通用页面 -->
<jsp:include page="../../common/common.jsp"/>
<script src="<c:url value='/js/system/sysrole/edit_main.js'/>"></script>
</body>
</html>