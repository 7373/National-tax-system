<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>工作量统计</title>
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon" />
    <link rel="stylesheet" href="<c:url value='/js/lib/layer/skin/layer.css'/> ">
    <link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/> ">
    <link rel="stylesheet" href="<c:url value='/css/system.css'/> ">
    <style type="text/css">
    	.table-row th{
			height:30px;    	
    	}
    	.spanStyle{
    		    display: inline;
			    font-size: 20px;
			    margin-left: 7px;
    	}
    	.btn-box{
    		text-align: left;
    		margin-left: 240px
    }
    </style>
</head>
<body class="pd20">
<div>
    <div class="table-info">
        <p>人员工作量统计表</p>
    </div>
    <form id="qryFormFirst">
        <div class="form-list">
            <div class="form-item clearfix">
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
            </div>
            <div class="form-item clearfix mt10 center">
                <div class="btn-box">
                    <input type="button" id="search" value="检 索" class="tax-btn mr30">
                </div>
            </div>
        </div>
    </form>
     <p style="color:red">产生风险总数<span id="allNum"></span>条，其中产生风险待查<span id="noExamRisk"></span>条，已核实<span id="hasExamRisk"></span>条，核实百分比<span id="prec"></span>。</p>
    <table id="user-table" class="table-row mt5" style="width:100%;">
		<thead>
			<tr role="row">
				<th class="sorting_disabled center">序号</th>
				<th class="sorting_disabled center">核查人</th>
				<th class="sorting_disabled center">事前风险核查数量</th>
				<th class="sorting_disabled center">事中风险核查数量</th>
			</tr>
		</thead>
		<tbody id="userTablefirst">
			
		</tbody>
	</table>
</div>
<div class="mt20">
    <div class="table-info">
        <p>处理结果统计表</p>
    </div>
    <form id="qryFormSecond">
        <div class="form-list">
            <div class="form-item clearfix">
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
            </div>
            <div class="form-item clearfix mt10 center">
                <div class="btn-box">
                    <input type="button" id="searchSecond" value="检 索" class="tax-btn mr30">
            </div>
            </div>
        </div>
    </form>
   <table id="user-table_1" class="table-row mt5" style="width:100%;">
		<thead>
			<tr role="row">
				<th class="sorting_disabled center">风险类别</th>
				<th class="sorting_disabled center">处理方式</th>
				<th class="sorting_disabled center">数量</th>
				<th class="sorting_disabled center">占比</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td rowspan="3" class=" center">事前风险点</td>
				<td class=" center">排除风险</td>
				<td class=" center" id="beforeNoRisk"></td>
				<td class=" center" id="beforeNoRiskPrec"></td>
			</tr>
			<tr>
				<td class=" center">确认风险</td>
				<td class=" center" id="beforeHasRisk"></td>
				<td class=" center" id="beforeHasRiskPrec"></td>
			</tr>
			<tr>
				<td class=" center">待核查</td>
				<td class=" center" id="beforeNeedExamRisk"></td>
				<td class=" center" id="beforeNeedExamRiskPrec"></td>
			</tr>
			<tr>
				<td rowspan="3" class=" center">事中风险点</td>
				<td class=" center">排除风险</td>
				<td class=" center" id="afterNoRisk"></td>
				<td class=" center" id="afterNoRiskPrec"></td>
			</tr>
			<tr>
				<td class=" center">确认风险</td>
				<td class=" center" id="afterHasRisk"></td>
				<td class=" center" id="afterHasRiskPrec"></td>
			</tr>
			<tr>
				<td class=" center">待核查</td>
				<td class=" center" id="afterNeedExamRisk"></td>
				<td class=" center" id="afterNeedExamRiskPrec"></td>
			</tr>
		</tbody>
	</table>
</div>
</body>
<script type="text/javascript" src="<c:url value='/js/lib/jquery/jquery-1.12.3.min.js'/> "></script>
<script type="text/javascript" src="<c:url value='/js/lib/jquery/jquery.serialize-object.min.js'/> "></script>
<script src="<c:url value='/js/lib/require.js'/> "></script>
<script src="<c:url value='/js/config.js'/>"></script>
<script src="<c:url value='/js/biz/work_count.js'/> "></script>
<script src="<c:url value='/js/lib/laydate/laydate.js'/> "></script>
</html>
