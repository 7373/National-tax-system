<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta charset="utf-8">
<title>事前风险查询</title>
<link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon" />
<link rel="stylesheet" href="<c:url value='/js/lib/layer/skin/layer.css'/>">
<link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>">
<link rel="stylesheet" href="<c:url value='/css/system.css'/>">
</head>
<body class="pd20">
	<div class="form-box">
		<form id="qryForm">
			<div class="form-list pd14-mr">
				<div class="form-item clearfix">
					<div class="col-4">
						<label class="item-name label-name col-3"><span
							class="long-label">企业名称</span></label>
						<div class="col-8">
							<div class="ipt-box col-12">
								<input id="entName" type="text" name="entName"
									class="ipt-txt clx ipt-input">
							</div>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name label-name col-3"><span
							class="long-label">成立日期</span></label>
						<div class="col-9">
							<div class="ipt-box col-12">
								<div class="ipt-box col-5">
									<input type="text" id="buildDateLeft" name="buildDateLeft"
										readonly="readonly" onclick="laydate()"
										class="ipt-txt laydate-icon clx ipt-input">
								</div>
								<span class="item-line col-2">到</span>
								<div class="ipt-box col-5">
									<input type="text" id="buildDateRight" name="buildDateRight"
										readonly="readonly" onclick="laydate()"
										class="ipt-txt laydate-icon clx ipt-input">
								</div>
							</div>
						</div>
					</div>
					<div class="col-4">
						<div class="ipt-box col-8 fr">
							<input type="text" class="ipt-txt clx" id="Industry" value="" readonly> 
							<input type="hidden" id="hiddenIndustry" class="clx" name="industry" id="hiddenIndustry">
							<span class="add-icon" id="selectIndustry"> <i></i></span>
						</div>
						<label class="item-name label-name col-3 fr"><span
							class="long-label">行业门类</span></label>
					</div>
				</div>

				<div class="form-item clearfix">
					<div class="col-4">
						<label class="item-name label-name col-3"><span
							class="long-label">
								<div>社会信用代码</div>
								<div>（纳税人识别号）</div>
						</span></label>
						<div class="col-8">
							<div class="ipt-box col-12">
								<input id="nsrsbh" name="nsrsbh" type="text"
									class="ipt-txt clx ipt-input">
							</div>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name label-name col-3"><span
							class="long-label">注册地址</span></label>
						<div class="col-9">
							<div class="ipt-box col-12">
								<input id="regisAddr" name="regisAddr" type="text"
									class="ipt-txt clx ipt-input" placeholder="支持模糊查询">
							</div>
						</div>
					</div>
					<div class="col-4">
						<div class="col-8 fr">
							<div class="ipt-box col-12">
								<input type="text" id="businessScope" name="businessScope"
									class="ipt-txt clx ipt-input" placeholder="支持模糊查询">
							</div>
						</div>
						<label class="item-name label-name col-3 fr"><span
							class="long-label">
								<div>经营范围</div>
						</span></label>
					</div>
				</div>

				<div class="form-item clearfix">
					<div class="col-4">
						<label class="item-name label-name col-3">法人姓名</label>
						<div class="col-8">
							<div class="ipt-box col-12">
								<input type="text" id="legalPerson" name="legalPerson"
									class="ipt-txt clx ipt-input" name="entName">
							</div>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name label-name col-3"><span
							class="long-label">财务负责人姓名</span></label>
						<div class="col-9">
							<div class="ipt-box col-12">
								<input type="text" id="financePerson" name="financePerson"
									class="ipt-txt clx ipt-input">
							</div>
						</div>
					</div>
					<div class="col-4">
						<div class="ipt-box col-8 fr">
							<select id="identityStatus" name="identityStatus"
								class="ipt-input">
								<option value="高危风险">高危风险</option>
								<option value="中度风险">中度风险</option>
<!-- 								<option value="轻微风险">轻微风险</option> -->
							</select>
						</div>
						<label class="item-name label-name col-3 fr"><span
							class="long-label">算法认定状态</span></label>
					</div>
				</div>

				<div class="form-item clearfix">
					<div class="col-4">
						<label class="item-name label-name col-3"><span
							class="long-label">核查状态</span></label>
						<div class="ipt-box col-8">
							<select id="examStatus" name="examStatus" class="ipt-input clxs">
								<option value="2">待核查</option>
								<option value="1">确认风险</option>
								<option value="0">排除风险</option>
							</select>
						</div>
					</div>
					<div class="col-4">
						<label class="item-name label-name col-3"><span
							class="long-label">核查日期</span></label>
						<div class="col-9">
							<div class="ipt-box col-12">
								<div class="ipt-box col-5">
									<input type="text" readonly="readonly" onclick="laydate()"
										id="examDateLeft" name="examDateLeft"
										class="ipt-txt laydate-icon clx ipt-input">
								</div>
								<span class="item-line col-2">到</span>
								<div class="ipt-box col-5">
									<input type="text" readonly="readonly" onclick="laydate()"
										id="examDateRight" name="examDateRight"
										class="ipt-txt laydate-icon clx ipt-input">
								</div>
							</div>
						</div>
					</div>
					<div class="col-4">
						<div class="col-8 fr">
							<div class="ipt-box col-12">
								<input type="text" id="examPeople" name="examPeople"
									class="ipt-txt clx ipt-input" placeholder="支持模糊查询">
							</div>
						</div>
						<label class="item-name label-name col-3 fr"><span
							class="long-label">核查人</span></label>
					</div>
				</div>
				<div class="form-item clearfix">
					<div class="col-4">
						<label class="item-name label-name col-3"><span
							class="long-label">管理科室</span></label>
						<div class="ipt-box col-8">
							<select id="managerDepart" name="managerDepart" class="ipt-input " >
								<option value="" selected>所有</option>
								<option value="13301913300" >一科</option>
								<option value="13301913100">二科</option>
								<option value="13301910000">其他科</option>
							</select>
						</div>
					</div>
					<div class="col-4">
<!-- 						<div class="ipt-box col-8 fr"> -->
<!-- 							<select id="riskName" name="riskName" class="ipt-input clx"> -->
<!-- 								<option value="" selected>不限</option> -->
<!-- 								<option value="1003">作废率达50%以上且开票份数大于25份</option> -->
<!-- 								<option value="1004">红字发票50%以上且开票份数大于25份</option> -->
<!-- 								<option value="1005">购方外地企业书占比50%以上且顶额开具80%以上</option> -->
<!-- 								<option value="1007">企业变更后集中开票</option> -->
<!-- 								<option value="1008">应纳税减征额填报金额较大(超过820)</option> -->
<!-- 								<option value="1009">申报表第6,7,8,10,11栏有数值</option> -->
<!-- 							</select> -->
<!-- 						</div> -->
<!-- 						<label class="item-name label-name col-3 fr"><span -->
<!-- 							class="long-label">事前风险项</span></label> -->
<!-- 						<div class="ipt-box col-8 fr"> -->
<!-- 							<select id="riskMonth" name="riskMonth" class="ipt-input clx"> -->
<!-- 								<option value="" selected>不限</option> -->
<%-- 								<c:forEach var="month" items="${data}" varStatus="i"> --%>
<%-- 									<option value="${month.riskMonth }">${month.riskMonth }</option> --%>
<%-- 								</c:forEach> --%>
<!-- 							</select> -->
<!-- 						</div> -->
<!-- 						<label class="item-name label-name col-3 fr"><span  -->
<!-- 							class="long-label">月份</span></label>  -->
					</div>
				</div>
<!-- 				<div class="form-item clearfix"> -->
<!-- 					<div class="col-4"> -->
<!-- 						<label class="item-name label-name col-3"><span -->
<!-- 							class="long-label">月份</span></label> -->
<!-- 						<div class="ipt-box col-8"> -->
<!-- 							<select id="riskMonth" name="riskMonth" class="ipt-input clx"> -->
<!-- 								<option value="" selected>不限</option> -->
<%-- 								<c:forEach var="month" items="${data}" varStatus="i"> --%>
<%-- 									<option value="${month.riskMonth }">${month.riskMonth }</option> --%>
<%-- 								</c:forEach> --%>
<!-- 							</select> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
				<div class="form-item clearfix mt10 center">
					<div class="btn-box">
						<input type="button" id="search" value="检 索" class="tax-btn mr30">
						<input type="button" value="重 置" class="tax-btn reset mr30">
<!-- 						<input type="button" id="export" value="导出" class="tax-btn"> -->
					</div>
				</div>
				<input type="hidden" id="riskType" name="riskType" value="ADVANCE" />
			</div>
		</form>
	</div>
	<div id="content">
		<table id="user-table" class="table-row  mt5 nowrap" width="100%">
			<thead style="white-space: nowrap;">
				<tr>
					<th>序号</th>
					<th>社会信用代码</th>
					<th>企业名称</th>
					<th>对应主要风险项</th>
					<th>算法认定状态</th>
					<th>最新核查状态</th>
					<th>最新核查人</th>
					<th>最新核查日期</th>
					<th>管理科室</th>
					<th>成立日期</th>
					<th>行业</th>
					<th>法人</th>
					<th>财务联系人</th>
					<th>注册地址</th>
					<th>经营范围</th>
				</tr>
			</thead>
		</table>
	</div>
</body>
<script type="text/javascript" src="<c:url value='/js/lib/jquery/jquery-1.12.3.min.js'/> "></script>
<script type="text/javascript" src="<c:url value='/js/lib/jquery/jquery.serialize-object.min.js'/> "></script>
<script src="<c:url value='/js/lib/laydate/laydate.js'/> "></script>
<script src="<c:url value='/js/lib/require.js'/> "></script>
<script src="<c:url value='/js/config.js'/> "></script>
<script src="<c:url value='/js/biz/risk_search_before.js'/> "></script>
<script>
	laydate.skin('danlan');
	window.CONFIG = {
		select_industry_url : '<c:url value="/industry/showIndustry"/>'
	}
</script>
</html>
