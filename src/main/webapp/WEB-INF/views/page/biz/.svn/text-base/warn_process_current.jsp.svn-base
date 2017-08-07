<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>事中预警待处理</title>
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon" />
    <link rel="stylesheet" href="<c:url value='/js/lib/layer/skin/layer.css'/> ">
    <link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/> ">
    <link rel="stylesheet" href="<c:url value='/css/system.css'/> ">
</head>
<body class="pd20">
<div class="form-box">
    <form id="qryForm">
        <div class="form-list pd14-mr">

            <div class="form-item clearfix">
                <div class="col-3">
                    <label class="item-name label-name col-3"><span class="long-label">企业名称</span></label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" name="entName" class="ipt-txt ipt-input" >
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name label-name col-3"><span class="long-label">成立日期</span></label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <div class="ipt-box col-5">
                                <input type="text" id="buildDateLeft" name="buildDateLeft" readonly="readonly" onclick="laydate()"
                                      class="ipt-txt laydate-icon clx ipt-input">
                            </div>
                            <span class="item-line col-2">到</span>
                            <div class="ipt-box col-5">
                                <input type="text" name="buildDateRight" readonly="readonly" onclick="laydate()"
                                       class="ipt-txt laydate-icon clx ipt-input">
                            </div>
                        </div>
                    </div>
                </div>
                
                
                <div class="col-5">
                    <label class="item-name label-name col-5"><span class="long-label">
                        <div>社会信用代码（纳税人识别号）</div>
                    </span></label>
                    <div class="col-7">
                        <div class="ipt-box col-12">
                            <input name="nsrsbh" type="text" class="ipt-txt ipt-input" >
                        </div>
                    </div>
                </div>
                
            </div>

            <div class="form-item clearfix">
	                <div class="col-3" style="display:  ${riskType == 'CURRENT' ? 'block' :'none'}">
	                    <label class="item-name label-name col-3"><span class="long-label">月份</span></label>
	                    <div class="ipt-box col-9  ">
	                    	<input type="hidden" value="" name="hismonth" id="hismonth">
	                    	<select name="riskMonth" class="ipt-input" id="riskMonth">
	                    		<option value="">不限</option>
		                        <c:forEach var="month" items="${data}" varStatus="i">
		                        		<option id="opt_${i.index+1}" value ="${month.riskMonth }">${month.riskMonth }</option>
		                        </c:forEach>
	                        </select>
						</div>
	                </div>
                
	                <div class="col-4">
	               	 	<input type="hidden" name="riskType" value="${riskType}">
	                </div>
            </div>
			
            <div class="form-item clearfix mt10 center">
                <div class="btn-box">
                    <input type="button" id="search" value="检 索" class="tax-btn mr30">
                    <input type="reset" value="重 置" class="tax-btn">
                </div>
            </div>
        </div>
    </form>
</div>

<div class="mb10">
    <input type="hidden" value="${uid}" id="uid">
    <input type="hidden" value="${name}" id="name">
    <input type="hidden" value="${examManagerDepart }" id="examManagerDepart" name="examManagerDepart">
</div>

<div id="content">
		<table id="user-table" class="table-row  nowrap mt5" width="100%">
			<thead>
				<tr>
<!-- 					<th>选择</th> -->
					<th>社会信用代码</th>
					<th>企业名称</th>
					<th>成立日期</th>
					<th>月份</th>
					<th>风险类别</th>
					<th>风险预警点</th>
					<th>历史核查记录</th>
					<th>处理</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
<script type="text/javascript" src="<c:url value='/js/lib/jquery/jquery-1.12.3.min.js'/> "></script>
<script type="text/javascript" src="<c:url value='/js/lib/jquery/jquery.serialize-object.min.js'/> "></script>
<script src="<c:url value='/js/lib/laydate/laydate.js'/> "></script>
<script src="<c:url value='/js/lib/require.js'/> "></script>
<script src="<c:url value='/js/config.js'/>"></script>
<script src="<c:url value='/js/biz/warn_process_current.js'/> "></script>
<script>
    laydate.skin('danlan');
</script>
</html>
