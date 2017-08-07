<%--
   Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
  --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="renderer" content="webkit">
    <title>事中风险查询</title>
    <link rel="shortcut icon" href="<c:url value='/img/favicon.ico'/>" type="image/x-icon"/>
    <link rel="stylesheet" href="<c:url value='/css/vendor/dataTables.bootstrap.min.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/system.css'/>">
    <style type="text/css">
    	input[type=text],select{
    		width:250px; 
    		height:25px;
    	}
    	#form .pf{
    		width:50px;
    		height:25px;
    	}
    	input[type=reset],input[type=button]{
    		width:70px;
    		height:30px;
    		background:blue;
    		font-size:15px;
    		color:white;
    		border:0;
    		margin:11px 10px;
    	}
    	#button{
    		width:300px;
    		height:50px;
    		margin:0px auto;
    	}
    </style>
    <script type="text/javascript" src="/js/common/jquery.min.js"></script>
    <script type="text/javascript" src="/js/lib/jquery/jquery.serialize-object.min.js"></script>
    <script type="text/javascript">
		$(function(){
			var regex = /^[0-9]+$/;
			$("#search").click(function(){
				$("#hidden_page").val(1);
				load();
			});
			function load(){
				$("#tbody").empty();
				$.ajax({
					url:"/currRisk/findByAttr",
					type:"post",
					data:$("#hxForm").serializeObject(),
					dataType:"json",
					success:function(json){
						if(json.status=="success"){
							createBody(json.data);
						}
					},
					error:function(){
						alert("网络繁忙,请稍后再试");
					}
				});
			}
			function createBody(datas){
				$("#pageDiv").show();
				var data = datas.data;
				if(data.length<1){
					var tr="";
					tr="<td colspan='16'>没有可显示的数据</td></tr>";
					$("#tbody").append(tr);
					return;
				}
				$.each(data,function(i,n){
					n.examDate = parseTime(new Date(n.examDate)); 
					n.buildDate = parseTime(new Date(n.buildDate));
					if(n.examPeople==null){
						n.examPeople="--";
						n.examDate="--";
					}
					var tr = "";
					tr+="<tr>";
					tr+="<td>"+(i+1)+"</td>";
				    tr+="<td>"+n.nsrsbh+"</td>";	
				    tr+="<td>"+n.entName+"</td>";
				    tr+="<td id='risknum'>"+n.riskNum+"</td>";	
				    tr+="<td>"+n.examStatus+"</td>"
				    tr+="<td>"+n.examPeople+"</td>";
				    tr+="<td>"+n.examDate+"</td>";	
				    tr+="<td>"+departType(n.managerDepart)+"</td>";	
				    tr+="<td>"+n.buildDate+"</td>";	
				    tr+="<td>"+n.industry+"</td>";
				    tr+="<td>"+n.legalPerson+"</td>";
				    tr+="<td>"+n.financialPerson+"</td>";	
				    tr+="<td>"+n.registerAddr+"</td>";	
				    tr+="<td>"+n.businessScope+"</td>"	
				    tr+="</tr>";	
				    $("#tbody").append(tr)
				})
				var num = datas.num;
				var allPage = Math.ceil(num/$("#pageSize").val())
				$("#allNum").html(num);
				$("#currPage").html($("#hidden_page").val());
				$("#allPage").html(allPage);
			}
			$("#tbody").on("click","#risknum",function(){
				var sbh = $(this).prev().prev().html();
				$.ajax({
					url:"/entRisk/findCurrRiskByNsrsbh",
					type:"post",
					data:{"nsrsbh":sbh},
					dataType:"json",
					success:function(json){
						var data = json.data;
						var msg="主要风险项\n";
						for(var i=0;i<data.length;i++){
							msg+="序号                    风险点\n";
							msg+=(i+1)+"                       "+data[i].riskName+'\n';
						}
						alert(msg);
					}
				})
			})
			
			$("#prevPage").click(function(){
				if($("#currPage").html()==1){
					alert("当前页是第一页");
					return;
				}
				$("#hidden_page").val(Number($("#hidden_page").val())-1);
				load();
			});
			$("#lastPage").click(function(){
				if($("#currPage").html()==$("#allPage").html()){
					alert("当前页是最后一页");
					return;
				}
				$("#hidden_page").val(Number($("#hidden_page").val())+1);
				load();
			})
			//解析日期格式
			function parseTime(date){
				return date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate();
			}
			function departType(depart){
				if(depart=='13301913300'){
					return '一科';
				}else if(depart=='13301913100'){
					return '二科';
				}else if(depart=='13301910000'){
					return '其他科室';
				}else{
					return '多余科室';
				}
			};
			$("#goSearch").click(function(){
				var page=$("#page").val();
				if(!regex.test(page)){
					alert("抱歉,你输入的数据不合法");
					return;
				}
				if(page>$("#allPage").html()){
					alert("超过最大范围");
					return;
				}
				$("#hidden_page").val(page);
				load();
			})
		})
	</script>
    
</head>
<body>
<div class="iframe-wrap">
<div class="iframe-header-bg"></div>
   <form id="hxForm">
   	 <div class="form-panel" id="form">
        <div>
        	企业名称：&nbsp;<input type="text" id="entName" name="entName"/>&nbsp;
        	成立日期：<input type="text" id="createTime-begin" name="createTimeBegin"/> 到 <input type="text" id="createTime-end" name="createTimeEnd"/>
        	&nbsp;行业门类：
        	<select id="HYDM" name="industry">
        			<option selected value="">不限</option>
        			<option value="01">农业</option>
        			<option value="02">林业</option>
        			<option value="03">畜牧业</option>
        			<option value="04">渔业</option>
        			<option value="05">农、林、牧、渔服务业</option>
        			<option value="06">煤炭开采和洗选业</option>
        			<option value="07">石油和天然气开采业</option>
        			<option value="08">黑色金属矿采选业</option>
        			<option value="09">有色金属矿采选业</option>
        			<option value="10">非金属矿采选业</option>
        			<option value="11">开采辅助活动</option>
        			<option value="12">其他采矿业</option>
        			<option value="13">农副食品加工业</option>
        			<option value="14">食品制造业</option>
        			<option value="15">酒、饮料和精制茶制造业</option>
        			<option value="16">烟草制品业</option>
        			<option value="17">纺织业</option>
        			<option value="18">纺织服装、服饰业</option>
        			<option value="19">皮革、毛皮、羽毛及其制品和制鞋业</option>
        			<option value="20">木材加工和木、竹、藤、棕、草制品业</option>
        			<option value="21">家具制造业</option>
        			<option value="22">造纸和纸制品业</option>
        			<option value="23">印刷和记录媒介复制业</option>
        			<option value="24">文教、工美、体育和娱乐用品制造业</option>
        			<option value="25">石油加工、炼焦和核燃料加工业</option>
        			<option value="26">化学原料和化学制品制造业</option>
        			<option value="27">医药制造业</option>
        			<option value="28">化学纤维制造业</option>
        			<option value="29">橡胶和塑料制品业</option>
        			<option value="30">非金属矿物制品业</option>
        			<option value="31">黑色金属冶炼和压延加工业</option>
        			<option value="32">有色金属冶炼和压延加工业</option>
        			<option value="33">金属制品业</option>
        			<option value="34">通用设备制造业</option>
        			<option value="35">专用设备制造业</option>
        			<option value="36">汽车制造业</option>
        			<option value="37">铁路、船舶、航空航天和其他运输设备制造业</option>
        			<option value="38">电气机械和器材制造业</option>
        			<option value="39">计算机、通信和其他电子设备制造业</option>
        			<option value="40">仪器仪表制造业</option>
        			<option value="41">其他制造业</option>
        			<option value="42">废弃资源综合利用业</option>
        			<option value="43">金属制品、机械和设备修理业</option>
        			<option value="44">电力、热力生产和供应业</option>
        			<option value="45">燃气生产和供应业</option>
        			<option value="46">水的生产和供应业</option>
        			<option value="47">房屋建筑业</option>
        			<option value="48">土木工程建筑业</option>
        			<option value="49">建筑安装业</option>
        			<option value="50">建筑装饰和其他建筑业</option>
        			<option value="51">批发业</option>
        			<option value="52">零售业</option>
        			<option value="53">铁路运输业</option>
        			<option value="54">道路运输业</option>
        			<option value="55">水上运输业</option>
        			<option value="56">航空运输业</option>
        			<option value="57">管道运输业</option>
        			<option value="58">装卸搬运和运输代理业</option>
        			<option value="59">仓储业</option>
        			<option value="60">邮政业</option>
        			<option value="61">住宿业</option>
        			<option value="62">餐饮业</option>
        			<option value="63">电信、广播电视和卫星传输服务</option>
        			<option value="64">互联网和相关服务</option>
        			<option value="65">软件和信息技术服务业</option>
        			<option value="66">货币金融服务</option>
        			<option value="67">资本市场服务</option>
        			<option value="68">保险业</option>
        			<option value="69">其他金融业</option>
        			<option value="70">房地产业</option>
        			<option value="71">租赁业</option>
        			<option value="72">商务服务业</option>
        			<option value="73">研究和试验发展</option>
        			<option value="74">专业技术服务业</option>
        			<option value="75">科技推广和应用服务业</option>
        			<option value="76">水利管理业</option>
        			<option value="77">生态保护和环境治理业</option>
        			<option value="78">公共设施管理业</option>
        			<option value="79">居民服务业</option>
        			<option value="80">机动车、电子产品和日用产品修理业</option>
        			<option value="81">其他服务业</option>
        			<option value="82">教育</option>
        			<option value="83">卫生</option>
        			<option value="84">社会工作</option>
        			<option value="85">新闻和出版业</option>
        			<option value="86">广播、电视、电影和影视录音制作业</option>
        			<option value="87">文化艺术业</option>
        			<option value="88">体育</option>
        			<option value="89">娱乐业</option>
        			<option value="90">中国共产党机关</option>
        			<option value="91">国家机构</option>
        			<option value="92">人民政协、民主党派</option>
        			<option value="93">社会保障</option>
        			<option value="94">群众团体、社会团体和其他成员组织</option>
        			<option value="95">基层群众自治组织</option>
        			<option value="96">国际组织</option>
        			<option value="Z9">其他税务管理特定行业</option>
        	</select>
        </div>
        <br/>
        <br/>
        <div>
        	社会信用代码（纳税人识别号）： <input type="text" id="sbh" name="NSRSBH"/>
        	&nbsp;注册地址： <input type="text" id="dz" placeholder="支持模糊查询" name="registerAddr"/>
        	&nbsp;经营范围： <input type="text" id="jyfw" placeholder="支持模糊查询" name="businessScope" />
        </div>
        <br/>
        <br/>
        <div>
        	法人姓名： <input type="text" id="frxm" name="legalPerson"/>&nbsp;
        	财务负责人姓名： <input type="text" id="cwxm" name="financialPerson"/>&nbsp;
        </div>
        <br/>
        <br/>
        <div>
        	核查状态： <select id="hcstate" name="examStatus">
        		<option selected value="">不限</option>
        		<option value="排除风险">排除风险</option>
        		<option value="确认风险">确认风险</option>
        		<option value="未审核">未审核</option>
        	</select>
        	&nbsp;
        	核查人： <input type="text" id="hcr" placeholder="支持模糊查询" name="examPeople"/>&nbsp;
        	核查日期： <input type="text" id="hcbegin" class="pf" name="hcbegin"/> 到 <input type="text" id="hcend" class="pf" name="hcend"/>&nbsp;
        </div>
        <br/>
        <br/>
        <div>
        	管理科室：<select id="manager_depart" name="managerDepart">
        				<option selected value="">不限</option>
        				<option value="13301913300">一科</option>
        				<option value="13301913100">二科</option>
        				<option value="13301910000">其他</option>
        		   </select>&nbsp;
        	事中风险点：<select id="current_risk" name="currRisk">
        				<option value="" selected>不限</option>
        				<option value="1003">作废率达50%以上且开票份数大于25份</option>
        				<option value="1004">红字发票50%以上且开票份数大于25份</option>
        				<option value="1005">购方外地企业书占比50%以上且顶额开具80%以上</option>
        				<option value="1007">企业变更后集中开票</option>
        				<option value="1008">应纳税减征额填报金额较大(超过820)</option>
        				<option value="1009">申报表第6,7,8,10,11栏有数值</option>
        			</select>
        	预警点个数:<input type="text" id="warnpointbegin" style="width:50px;" name="riskNumBegin"/>到
        			<input type="text" id="warnpointend" style="width:50px;" name="riskNumEnd"/>
        				  
        </div>
        <div id="pageDiv" style="display:none;">
    		<a href="javascript:void(0);" id="prevPage">上一页</a>
    		<a href="javascript:void(0);" id="lastPage">下一页</a>
    		<input type="hidden" id="hidden_page" name="page" value="1"/>
    		<input type="text" id="page" style="width:30px;height:25px;"/>
    		<input type="button" id="goSearch" value="go" style="width:50px;"/>
    		共<span id="allNum"></span>条数据&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		<span id="currPage"></span>/<span id="allPage"></span>页
    		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		每页	<select id="pageSize" name="pageSize" style="width:40px;">
    				<option value="5" selected>5</option>
    				<option value="10">10</option>
    				<option value="15">15</option>
    			</select>条
    	</div>
        <br/>
        <br/>
    </div>
    <div id="button">
    	<input type="button" value="检索" id="search"/>
    	<input type="reset" value="重置"/>
    </div>
   </form>
   <div>
   		<input type="button" id="export" value="导出"/>
   </div>
    <div class="box-panel">
        <table id="contract-table" class="table-row nowrap" width="100%">
            <thead>
            <tr>
                <th>序号</th>
                <th>社会信用代码(纳税人识别号)</th>
                <th>企业名称</th>
                <th>事前风险项</th>
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
            <tbody id="tbody">
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
