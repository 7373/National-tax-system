<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>事中风险查询</title>
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
                <div class="col-4">
                    <label class="item-name label-name col-3"><span class="long-label">企业名称</span></label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx ipt-input" name="entName" id="entName">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name label-name col-3"><span class="long-label">成立日期</span></label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <div class="ipt-box col-5">
                                <input type="text" readonly="readonly" onclick="laydate();" id="buildDateLeft" name="buildDateLeft"
                                       class="ipt-txt laydate-icon clx ipt-input">
                            </div>
                            <span class="item-line col-2">到</span>
                            <div class="ipt-box col-5">
                                <input type="text" readonly="readonly" onclick="laydate();" id="buildDateRight" name="buildDateRight"
                                       class="ipt-txt laydate-icon clx ipt-input">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="ipt-box col-8 fr">
							<input type="text" class="ipt-txt clx" id="Industry" value="" readonly> 
							<input type="hidden" class="clx" id="hiddenIndustry" name="industry" id="hiddenIndustry">
							<span class="add-icon" id="selectIndustry"> <i></i></span>
                    </div>
                    <label class="item-name label-name col-3 fr"><span class="long-label">行业门类</span></label>
                </div>
            </div>

            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name label-name col-3"><span class="long-label">
                        <div>社会信用代码</div>
                        <div>（纳税人识别号）</div>
                    </span></label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx ipt-input" name="nsrsbh" id="nsrsbh">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name label-name col-3"><span class="long-label">纳税人地址</span></label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx ipt-input" placeholder="支持模糊查询" name="regisAddr" id="regisAddr">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="col-8 fr">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx ipt-input" placeholder="支持模糊查询" name="businessScope" id="businessScope">
                        </div>
                    </div>
                    <label class="item-name label-name col-3 fr"><span class="long-label">
                        <div>经营范围</div>
                    </span></label>
                </div>
            </div>

            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name label-name col-3">法人姓名</label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx ipt-input" name="legalPerson" id="legalPerson">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name label-name col-3"><span class="long-label">财务负责人姓名</span></label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt clx ipt-input" name="financePerson" id="financePerson">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="ipt-box col-8 fr">
                        <select name="riskMonth" class="ipt-input" id="riskMonth">
	                        <c:forEach var="month" items="${data}" varStatus="i">
	                        	<option value ="${month.riskMonth }">${month.riskMonth }</option>
	                        </c:forEach>
                        </select>
                    </div>
                    <label class="item-name label-name col-3 fr"><span class="long-label">月份</span></label>
                </div>
            </div>
            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name label-name col-3"><span class="long-label">核查状态</span></label>
                    <div class="ipt-box col-8">
                        <select name="examStatus" class="ipt-input clxs" id="examStatus">
                            <option value="2">待核查</option>
                            <option value="1">确认风险</option>
                            <option value="0">排除风险</option>
                        </select>
                    </div>
                </div>
                <div class="col-4">
               		 <label class="item-name label-name col-3"><span class="long-label">核查日期</span></label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <div class="ipt-box col-5">
                                <input type="text" readonly="readonly" onclick="laydate()" name="examDateLeft" id="examDateLeft"
                                       class="ipt-txt laydate-icon clx ipt-input">
                            </div>
                            <span class="item-line col-2">到</span>
                            <div class="ipt-box col-5">
                                <input type="text" readonly="readonly" onclick="laydate()" name="examDateRight" id="examDateRight"
                                       class="ipt-txt laydate-icon clx ipt-input">
                            </div>
                        </div>
                    </div>
                    
                </div>
                <div class="col-4">
                   <div class="col-8 fr">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt ipt-input clx" placeholder="支持模糊查询" name="examPeople" id="examPeople">
                        </div>
                    </div>
                    <label class="item-name label-name col-3 fr"><span class="long-label">核查人</span></label>
                </div>
                
            </div>

            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name label-name col-3"><span class="long-label">管理科室</span></label>
                   <div class="ipt-box col-8">
                        <select name="managerDepart" class="ipt-input" id="managerDepart">
                            <option value="" selected>所有</option>
                            <option value ="13301913300">一科</option>
                            <option value="13301913100">二科</option>
                            <option value="13301910000">其他科</option>
                        </select>
                    </div>
                </div>
                <div class="col-4">
                <label class="item-name label-name col-3"><span class="long-label">事中风险点</span></label>
                    <div class="ipt-box col-8">
                        <select name="riskName" class="ipt-input clx" id="riskName">
                            <option value="" selected>不限</option>
							<option value="1003">开票份数大于25份且作废率达50%以上</option>
							<option value="1004">开票份数大于25份且红字发票50%以上</option>
							<option value="1005">发票份额大于25份且顶额开具50%以上</option>
							<option value="1007">企业变更后集中开票</option>
							<option value="1008">应纳税减征额填报金额较大</option>
							<option value="1009">农产品收购发票或者销售发票</option>
							<option value="1010">代扣代缴税收缴款凭证</option>
							<option value="1011">其它扣税凭证</option>
							<option value="1012">期不动产允许抵扣进项税额</option>
							<option value="1013">外贸企业进项税额抵扣证明</option>
                        </select>
                    </div>
                </div>
                <div class="col-4">
                    <div class="col-8 fr">
                        <div class="ipt-box col-12">
                            <div class="ipt-box col-5">
                             <input type="text" name="riskNumLeft" class="ipt-txt clx ipt-input" id="riskNumLeft" value="1">
                            </div>
                            <span class="item-line col-2">到</span>
                            <div class="ipt-box col-5">
                                <input type="text"  name="riskNumRight" class="ipt-txt clx ipt-input" id="riskNumRight">
                            </div>
                        </div>
                    </div>
                    <label class="item-name label-name col-3 fr"><span class="long-label">预警点个数</span></label>
                </div>
            </div>
            <input type="hidden" id="riskType" name="riskType" value="CURRENT"/>
            <div class="form-item clearfix mt10 center">
                <div class="btn-box">
                    <input type="button" value="检 索" class="tax-btn mr30" id="search">
                    <input type="button" value="重 置" class="tax-btn reset mr30">
<!--                     <input type="button" value="导出" class="tax-btn" id="export"> -->
                </div>
            </div>
        </div>
        <c:forEach var="month" items="${data}" varStatus="i">
	        <c:if test="${i.index==0 }">
	           <input type="hidden" id="maxMonth" value="${month.riskMonth  }">
	        </c:if>
	     </c:forEach>
    </form>
</div>
<div class="">
    <div class="table-out">
		<table id="user-table"border="0" cellspacing="0" cellpadding="0"
		 class="table-row nowrap" width="100%">
		    <thead style="white-space: nowrap;">
		    <tr>
		        <th>序号</th>
				<th>社会信用代码</th>
				<th>企业名称</th>
				<th>事中风险项</th>
				<th>是否有事前风险</th>
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
				<th>月份</th>
		    </tr>
		    </thead>
		</table>
	</div>
</div>
<script type="text/javascript" src="<c:url value='/js/lib/jquery/jquery-1.12.3.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/lib/jquery/jquery.serialize-object.min.js'/> "></script>
<script src="<c:url value='/js/lib/laydate/laydate.js'/> "></script>
<script src="<c:url value='/js/lib/require.js'/>"></script>
<script src="<c:url value='/js/config.js'/> "></script>
<script src="<c:url value='/js/biz/risk_search_after.js'/> "></script>
<script>
window.CONFIG = {
		select_industry_url : '<c:url value="/industry/showIndustry"/>'
	}
</script>
</body>
</html>
