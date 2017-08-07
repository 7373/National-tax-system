<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>统一开发框架首页</title>
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/css/vendor/layout-default-latest.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
</head>
<body style="overflow: hidden; position: relative">
<jsp:include page="common/header.jsp"/>
<div id="container">
    <div class="pane ui-layout-center">
        <div id="page-wrapper">
            <div class="content-tabs mt10">
                <div class="page-tabs J_menuTabs">
                    <div class="page-tabs-content">
                        <em class="tab-close js-closeAll-tab"><i class="xbt-icon"></i></em>
                        <a href="javascript:void(0);" class="active J_menuTab" data-id="/admin/dashboard"
                           style="border-left: 0;">首页</a>
                    </div>
                </div>
            </div>
            <div id="content-main" class="J_mainContent">
                <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="/admin/dashboard"
                        data-id="/admin/dashboard" frameborder="0"></iframe>
            </div>
            <div class="footer">
                版权所有：浙江省工商行政管理局<span class="ml40">技术支持：浙江汇信科技有限公司</span><span class="ml40">客服 400-888-4636</span><span
                    class="ml40">技术 0571-88234769</span>
            </div>
        </div>
    </div>

    <div class="pane ui-layout-west">
        <div class="nano">
            <div class="nano-content">
                <div class="sidebar">
                    <div class="sidebar-nav">
                        <ul id="side-menu" class="metismenu">

                            <c:forEach var="menu_1" items="${menus['-1']}">
                                <li>
                                    <a href="javascript:void(0)"><i class="fa fa-edit"></i> <span
                                            class="nav-label">${menu_1.name}</span><span class="nav-arrow"></span></a>

                                    <c:if test="${!empty menus[menu_1.id]}">
                                        <ul class="nav nav-second-level collapse">

                                            <c:forEach var="menu_2" items="${menus[menu_1.id]}">

                                                <c:if test="${empty menus[menu_2.id]}"> <%--不存在三级目录 则二级目录触发--%>
                                                    <li><a class="J_menuItem" href="${menu_2.url}"
                                                    >${menu_2.name}</a></li>
                                                </c:if>

                                                <c:if test="${!empty menus[menu_2.id]}"> <%--存在三级目录 则二级目录不触发 三级目录触发--%>
                                                    <li>
                                                        <a href="javascript:void(0)">${menu_2.name}<span class="nav-arrow"></span></a>
                                                        <ul class="nav nav-third-level collapse">
                                                            <c:forEach var="menu_3" items="${menus[menu_2.id]}">
                                                                <li><a class="J_menuItem" href="${menu_3.url}"
                                                                >${menu_3.name}</a></li>
                                                            </c:forEach>
                                                        </ul>

                                                    </li>
                                                </c:if>

                                            </c:forEach>
                                        </ul>
                                    </c:if>
                                </li>
                            </c:forEach>
                        </ul>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 通用页面 -->
<jsp:include page="common/common.jsp"/>
<script src="<c:url value='/js/index/index_main.js'/>"></script>
</body>
</html>