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
    <title>1</title>
    <link rel="stylesheet" href="/css/system.css">
</head>
<body>
<div class="form-box">
    <form id="qryForm">
        <div class="form-list pd14-mr">

            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name label-name col-3"><span class="long-label">企业名称</span></label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt ipt-input" >
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name label-name col-3"><span class="long-label">成立日期</span></label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <div class="ipt-box col-5">
                                <input type="text" readonly="readonly" onclick="laydate()" name="apprDate_sta"
                                       class="ipt-txt laydate-icon clx ipt-input">
                            </div>
                            <span class="item-line col-2">到</span>
                            <div class="ipt-box col-5">
                                <input type="text" readonly="readonly" onclick="laydate()" name="apprDate_end"
                                       class="ipt-txt laydate-icon clx ipt-input">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="ipt-box col-8 fr">
                        <select class="ipt-input">
                            <option value ="volvo">不限</option>
                            <option value ="saab">技术部</option>
                            <option value="opel">客服部</option>
                            <option value="audi">业务部</option>
                        </select>
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
                            <input type="text" class="ipt-txt ipt-input" >
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name label-name col-3"><span class="long-label">纳税人地址</span></label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt ipt-input" placeholder="支持模糊查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="col-8 fr">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt ipt-input" placeholder="支持模糊查询">
                        </div>
                    </div>
                    <label class="item-name label-name col-3 fr"><span class="long-label">
                        <div>社会信用代码</div>
                        <div>（纳税人识别号）</div>
                    </span></label>
                </div>
            </div>

            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name label-name col-3">法人姓名</label>
                    <div class="col-8">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt ipt-input" name="entName">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name label-name col-3"><span class="long-label">财务负责人姓名</span></label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt ipt-input" >
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="col-8 fr">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt ipt-input" >
                        </div>
                    </div>
                    <label class="item-name label-name col-3 fr"><span class="long-label">法人姓名</span></label>
                </div>
            </div>

            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name label-name col-3"><span class="long-label">核查状态</span></label>
                    <div class="ipt-box col-8">
                        <select class="ipt-input">
                            <option value ="volvo">不限</option>
                            <option value ="saab">技术部</option>
                            <option value="opel">客服部</option>
                            <option value="audi">业务部</option>
                        </select>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name label-name col-3"><span class="long-label">核查人</span></label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt ipt-input" placeholder="支持模糊查询">
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="ipt-box col-8 fr">
                        <select class="ipt-input">
                            <option value ="volvo">不限</option>
                            <option value ="saab">技术部</option>
                            <option value="opel">客服部</option>
                            <option value="audi">业务部</option>
                        </select>
                    </div>
                    <label class="item-name label-name col-3 fr"><span class="long-label">核查状态</span></label>
                </div>
            </div>

            <div class="form-item clearfix">
                <div class="col-4">
                    <label class="item-name label-name col-3"><span class="long-label">算法认定状态</span></label>
                    <div class="ipt-box col-8">
                        <select class="ipt-input">
                            <option value ="volvo">不限</option>
                            <option value ="saab">技术部</option>
                            <option value="opel">客服部</option>
                            <option value="audi">业务部</option>
                        </select>
                    </div>
                </div>
                <div class="col-4">
                    <label class="item-name label-name col-3"><span class="long-label">管理科室</span></label>
                    <div class="col-9">
                        <div class="ipt-box col-12">
                            <input type="text" class="ipt-txt ipt-input" >
                        </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="ipt-box col-8 fr">
                        <select class="ipt-input">
                            <option value ="volvo">不限</option>
                            <option value ="saab">技术部</option>
                            <option value="opel">客服部</option>
                            <option value="audi">业务部</option>
                        </select>
                    </div>
                    <label class="item-name label-name col-3 fr"><span class="long-label">算法认定状态</span></label>
                </div>
            </div>

            <div class="form-item clearfix mt10 center">
                <div class="btn-box">
                    <input type="button" value="检 索" class="tax-btn mr30">
                    <input type="button" value="重 置" class="tax-btn">
                </div>
            </div>

        </div>
    </form>
</div>
</body>
<script src="../../../js/lib/laydate/laydate.js"></script>
<script>
    laydate.skin('danlan');
</script>
</html>
