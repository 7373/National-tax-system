<%--
  Created by IntelliJ IDEA.
  User: dxh
  Date: 2017/4/20
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <meta charset="utf-8">
    <title>3</title>
    <link rel="stylesheet" href="/css/system.css">
    <link rel="stylesheet" href="/js/lib/layer/skin/layer.css">
    <link rel="stylesheet" href="/css/vendor/dataTables.bootstrap.min.css">
</head>
<body class="white-bg">
    <div class="warn-process-popup common-popup">
        <div class="layui-layer-title" style="cursor: move;">预警处理</div>
        <span class="layui-layer-setwin"><a class="layui-layer-ico layui-layer-close layui-layer-close1" href="javascript:;"></a></span>
        <div class="pd18">
            <div class="form-list filter-condition">
                <div class="form-item clearfix">
                    <div class="col-5">
                        <label class="item-name col-3"><span class="long-label">总核查结果</span></label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <input type="text" class="ipt-txt" placeholder="支持模糊查询">
                            </div>
                        </div>
                    </div>
                    <div class="col-5">
                        <label class="item-name col-3"><span class="long-label">核查日期</span></label>
                        <div class="col-7">
                            <div class="ipt-box col-12">
                                <select name="" id="">
                                    <option value="不限" selected = "selected">不限</option>
                                    <option value=""></option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <table id="warn-process-table" border="0" cellspacing="0" cellpadding="0" class="table-row2 nowrap" width="100%">
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
            <div class="center mt20">
                <input type="button" value="检索" class="btn tax-btn mr20">
                <input type="button" value="重置"  class="btn tax-btn">
            </div>
        </div>
    </div>
</body>
</html>
