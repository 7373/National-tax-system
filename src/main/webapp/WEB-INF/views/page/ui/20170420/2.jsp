<%--
  Created by IntelliJ IDEA.
  User: dxh
  Date: 2017/4/20
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>2</title>
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
    <link rel="stylesheet" href="/css/system.css">
</head>
<body>
<table id="user-table" class="table-row nowrap" width="100%">
    <thead>
    <tr>
        <th>用户名</th>
        <th>姓名</th>
        <th>电子邮件</th>
        <th>用户状态</th>
        <th>创建时间</th>
        <th>最后登录时间</th>
        <th>操作</th>
    </tr>
    </thead>
</table>
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="{{this.class}}">{{this.text}}</button>
    {{/each}}
</script>

<script>
    // 定义全局变量
    window.__FRAMEWORK__ = {
        // 根路径
        root_url: "/".split(';')[0]
    };
</script>
<script src="/js/lib/require.js"></script>
<script src="/js/config.js"></script>

<script src="/js/system/sysuser/list_main.js"></script>

</body>
</html>
