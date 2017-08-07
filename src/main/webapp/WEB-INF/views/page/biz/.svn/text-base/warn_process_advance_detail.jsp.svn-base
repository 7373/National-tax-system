<%--
  Created by IntelliJ IDEA.
  User: dxh
  Date: 2017/4/20
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon" />
	<link rel="stylesheet" href='<c:url value='/css/system.css'/>'>
    <link rel="stylesheet" href='<c:url value='/js/lib/layer/skin/layer.css'/>'>
    <link rel="stylesheet" href='<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>'>
</head>
<body class="pd20">
    <div class="warn-process-popup common-popup">
        <div class="pd18">
        <form id="content_form">
            <div class="form-list filter-condition">
                <div class="form-item clearfix">
                    <div class="col-5">
                        <label class="item-name col-3"><span class="long-label">总核查结果</span></label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                               <select name="riskResult" id="riskResult">
                                    <option value="确认风险" selected = "selected">确认风险</option>
                                    <option value="排除风险">排除风险</option>
                                </select>
                                <input type="hidden" name="ids" id="ids">
                                <input type="hidden" name="results" id="results">
                                <input type="hidden" name="fxId" id="fxId" value="${fxId}">
                                <input type="hidden" name="uid" id="uid" value="${uid}">
                                <input type="hidden" name="name" id="name" value="${name}">
                                <input type="hidden" name="examManagerDepart" id="examManagerDepart" value="${examManagerDepart }">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </form>
            <div class="center mt20">
                <input id="check" type="button" value="确定" class="btn tax-btn mr20">
                <input id="close" type="button" value="取消"  class="btn tax-btn">
            </div>
        </div>
    </div>
</body>
<script type="text/javascript" src="<c:url value='/js/lib/jquery/jquery-1.12.3.min.js'/> "></script>
<script type="text/javascript" src="<c:url value='/js/lib/jquery/jquery.serialize-object.min.js'/> "></script>
<script src="<c:url value='/js/lib/laydate/laydate.js'/> "></script>
<script src="<c:url value='/js/lib/require.js'/> "></script>
<script src="<c:url value='/js/config.js'/> "></script>
<script src="<c:url value='/js/biz/warn_process_advance_detail.js'/> "></script>
</html>
