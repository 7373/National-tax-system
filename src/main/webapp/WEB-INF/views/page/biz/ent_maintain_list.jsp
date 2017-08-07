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
<body class="pd20" style="padding-top: 150px;">
	<form id="ent_form">
    <div class="warn-process-popup common-popup">
        <div class="pd18">
            <div class="form-list filter-condition">
                <div class="form-item clearfix">
                    <div class="col-5">
                        <label class="item-name col-3"><span class="long-label">企业维护信息录入</span></label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <table id="warn-process-table" border="0" cellspacing="0" cellpadding="0" class="table-row2 nowrap" width="100%">
                <thead>
                <tr>
                    <th>纳税人识别号</th>
                    <th>企业名称</th>
                </tr>
                </thead>
                		<tr>
                			<td><font color="red">*</font>&nbsp;<input style="width: 200px;height: 25px;" type="text" name="nsrsbh" placeholder="请输入纳税人识别号"/></td>
                			<td><font color="red">*</font>&nbsp;<input style="width: 250px;height: 25px;" type="text" name="entName"  placeholder="企业名称"/></td>
                		</tr>
                </tbody>
            </table>
            <div class="center mt20">
                <input  type="submit" value="确定提交" class="btn tax-btn mr20">
                <input  id="reset" type="reset" value="重置"  class="btn tax-btn">
            </div>
        </div>
    </div>
    </form>
</body>
<%-- <script type="text/javascript" src="<c:url value='/js/lib/jquery/jquery-1.12.3.min.js'/> "></script> --%>
<%-- <script type="text/javascript" src="<c:url value='/js/lib/jquery/jquery.serialize-object.min.js'/> "></script> --%>
<script src="<c:url value='/js/lib/laydate/laydate.js'/> "></script>
<script src="<c:url value='/js/lib/require.js'/> "></script>
<script src="<c:url value='/js/config.js'/> "></script>
<script src="<c:url value='/js/biz/ent_maintain_list.js'/> "></script>
</html>
