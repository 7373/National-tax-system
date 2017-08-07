<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>角色管理</title>
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/css/vendor/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body>
<div class="iframe-wrap">
    <div class="tool-box clearfix">
        <div class="toobar">
            <button class="btn btn-primary btn-sm glyphicon glyphicon-plus js-add" type="button">&nbsp;创建角色</button>
        </div>
    </div>
    <table id="role-table" class="table table-striped table-bordered table-hover" width="100%">
        <thead>
        <tr>
            <th>序号</th>
            <th>角色名</th>
            <th>角色描述</th>
            <th>操作</th>
        </tr>
        </thead>
    </table>
</div>
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>
<!-- 通用页面 -->
<jsp:include page="../../common/common.jsp"/>
<script src="<c:url value='/js/system/sysrole/list_main.js'/>"></script>
</body>
</html>
