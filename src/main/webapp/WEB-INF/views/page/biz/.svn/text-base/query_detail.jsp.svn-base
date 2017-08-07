<%--
  Created by IntelliJ IDEA.
  User: dxh
  Date: 2017/4/20
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title></title>
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon" />
  	<link rel="stylesheet" href="<c:url value='/js/lib/layer/skin/layer.css'/> ">
    <link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/> ">
    <link rel="stylesheet" href="<c:url value='/css/system.css'/> ">
</head>
<body class="pd20">
    <div class="warn-process-popup common-popup">
            <table id="warn-process-table" border="0" cellspacing="0" cellpadding="0" class="table-row2 nowrap" width="100%">
                <thead>
                <tr>
                    <th>序号</th>
                    <th>企业名称</th>
                    <th>风险预警点</th>
                    <th>核查日期</th>
                    <th>核查结果</th>
                </tr>
                </thead>
                <tbody>
                	<c:forEach var="detail" items="${data}" varStatus="st" >
                		<tr>
                			<td>${st.index+1}</td>
                			<td>${detail.entName }</td>
                			<td>${detail.riskName }</td>
                			<td><fmt:formatDate value="${detail.examDate}" type="date"/>  </td>
                			<td>${detail.examResult }</td>
                		</tr>
                	</c:forEach>
                </tbody>
            </table>
    </div>
</body>
</html>
