<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>统一开发框架登录页</title>
    <!-- 默认视图 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <!-- 360浏览器兼容视图适配 -->
    <meta name="renderer" content="webkit">
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/css/vendor/bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    <script>
        //失效自动跳转到顶层登录页面
        if (top.location != self.location) {
            top.location = "<c:url value='/'/>";
        }
    </script>
</head>

<body>
<jsp:include page="common/header.jsp">
    <jsp:param name="flag" value="false"/>
</jsp:include>
<div class="loginContent">
    <div class="loginMoudle">
        <h2><i>|</i>登录</h2>
        <div>
            <form id="login-form">
                <ul>
                    <li class="form-li">
                        <div class="form-label">
                            <label for="username">账户：</label>
                            <input type="text" class="form-control" name="username" id="username" placeholder="用户名">
                        </div>
                    </li>
                    <li class="form-li">
                        <div class="form-label">
                            <label for="password">密码：</label>
                            <input type="password" class="form-control" name="password" id="password" placeholder="密码">
                        </div>
                    </li>
                    <li class="form-li">
                        <div class="form-label">
                            <label for="checkCode">验证码：</label>
                            <input type="text" name="checkCode" id="checkCode" class="form-control w-120">
                            <img class="js-checkcode" style="cursor: pointer" src="/captcha">
                        </div>
                    </li>
                    <li class="form-li">
                        <button type="submit" class="btn btn-primary login-btn">登 录</button>
                    </li>
                </ul>
            </form>
        </div>
    </div>
</div>
<!-- 通用页面 -->
<jsp:include page="common/common.jsp"/>
<script src="<c:url value='/js/login/login_main.js'/>"></script>
</body>
</html>