<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!Doctype html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>9</title>
    <link rel="stylesheet" href="/css/system.css">
    <link rel="stylesheet" href="/js/lib/layer/skin/layer.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="white-bg pd20">
<div>
    <div class="table-info">
        <p>产生风险待查325条，已核实155条，核实百分比56%。</p>
        <p>人员工作量统计表</p>
    </div>
    <form>
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-5">
                    <label class="item-name col-3">成立日期</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <div class="ipt-box col-12">
                                <div class="ipt-box col-5">
                                    <input type="text" readonly="readonly" onclick="laydate()" name="apprDate_sta" class="ipt-txt laydate-icon clx ipt-input">
                                </div>
                                <span class="item-line col-2">到</span>
                                <div class="ipt-box col-5">
                                    <input type="text" readonly="readonly" onclick="laydate()" name="apprDate_end" class="ipt-txt laydate-icon clx ipt-input">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">&nbsp;</div>
                <div class="col-3">
                    <label class="item-name col-4"><span class="long-label">行业门类</span></label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <table border="0" cellspacing="0" cellpadding="0" class="table-row nowrap" width="100%">
        <thead>
        <tr>
            <th>序号</th>
            <th>预警点</th>
            <th>核查结果录入</th>
        </tr>
        </thead>
        <tbody>
        <td>1</td>
        <td>sdf</td>
        <td><span class="grey">请录入核查结果</span></td>
        </tbody>
    </table>
</div>
<div class="mt20">
    <div class="table-info">
        <p>处理结果统计表</p>
    </div>
    <form id="qryForm">
        <div class="form-list">
            <div class="form-item clearfix">
                <div class="col-5">
                    <label class="item-name col-3">成立日期</label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <div class="ipt-box col-12">
                                <div class="ipt-box col-5">
                                    <input type="text" readonly="readonly" onclick="laydate()" name="apprDate_sta" class="ipt-txt laydate-icon clx ipt-input">
                                </div>
                                <span class="item-line col-2">到</span>
                                <div class="ipt-box col-5">
                                    <input type="text" readonly="readonly" onclick="laydate()" name="apprDate_end" class="ipt-txt laydate-icon clx ipt-input">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">&nbsp;</div>
                <div class="col-3">
                    <label class="item-name col-4"><span class="long-label">检查人</span></label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <table border="0" cellspacing="0" cellpadding="0" class="table-row nowrap" width="100%">
        <thead>
        <tr>
            <th>序号</th>
            <th>预警点</th>
            <th>核查结果录入</th>
        </tr>
        </thead>
        <tbody>
        <td>1</td>
        <td>sdf</td>
        <td><span class="grey">请录入核查结果</span></td>
        </tbody>
    </table>
</div>



</body>
</html>
