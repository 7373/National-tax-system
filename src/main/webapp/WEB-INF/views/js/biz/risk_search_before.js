require(['layer1',
         'component/dataTable',
         'common/util',
         'common/http',
         'jquery',
         'jquery.serialize',
         'handlebars',
         'jquery','laydate'], function (layer, dataTable, util, http, handlebars) {
	var table;
	var searchParams=$("#qryForm").serializeObject();//查询参数声明!
	init();
    /**
     * 初始化函数集合
     */
    function init() {
//        initDataTable();
        bind();
    }
    
    //解析日期格式
	function parseTime(date){
		return date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate();
	}

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
            scrollX: true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/risk/list.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: null,defaultContent: 1, className:"center",width:"70px"},
                {data: 'nsrsbh', className:"center"},
                {data: 'entName', className:"center"},
                {data: 'riskNum', className:"center",width:"30px"},
                {data: 'identityStatus', className:"center",width:"70px"},
                {data: 'examStatus', className:"center",width:"70px"},
                {data: 'examPeople', className:"center",width:"70px"},
                {data: 'examDate', className:"center",width:"70px"},
                {data: 'managerDepart', className:"center",width:"70px"},
                {data: 'buildDate', className:"center",width:"70px"},
                {data: 'industry', className:"center"},
                {data: 'legalPerson', className:"center",width:"70px"},
                {data: 'financePerson', className:"center",width:"70px"},
                {data: 'regisAddr', className:"center"},
                {data: 'businessScope', className:"center",cut:{length:15,mark:"..."}}
            ],
            columnDefs: [{
            	targets:3,
            	render:function(data,type,row,meta){
            		if(row.identityStatus=="高危风险"){
            			return "<span class='light-gray'><a href='javascript:void(0)' id='' class='show'>"+row.riskNum+"</a></span>"
            		}
            		return "<span>正常</span>";
            	}
            },{
        		targets:8,
        		render: function (data, type, row, meta) {
        		 if(row.managerDepart=='13301913300'){
        			 return '一科';
        		 }else if(row.managerDepart=='13301913100'){
        			 return '二科';
        		 }else if(row.managerDepart=='13301910000'){
        			 return '其他科';
        		 }else{
        			 return '不存在的科';
        		 }
        	 }
        }]
        })
    }
    $("#search").click(function(){
    	searchParams=$("#qryForm").serializeObject();//查询参数声明!
    	if(table){
    		table.ajax.reload();
    	}else{
    		initDataTable();
    	}
    	
    });
    $("#export").click(function(){
    	var entName = $("#entName").val();
    	var buildDateLeft = $("#buildDateLeft").val();
    	var buildDateRight = $("#buildDateRight").val();
    	var industry = $("#hiddenIndustry").val();
    	var nsrsbh = $("#nsrsbh").val();
    	var regisAddr = $("#regisAddr").val();
    	var businessScope = $("#businessScope").val();
    	var legalPerson = $("#legalPerson").val();
    	var financePerson = $("#financePerson").val();
    	var fxGradeLeft = $("#fxGradeLeft").val();
    	var fxGradeRight = $("#fxGradeRight").val();
    	var examStatus = $("#examStatus").val();
    	var examDateLeft = $("#examDateLeft").val();
    	var examDateRight = $("#examDateRight").val();
    	var examPeople = $("#examPeople").val();
    	var identityStatus = $("#identityStatus").val();
    	var managerDepart = $("#managerDepart").val();
    	var riskName = $("#riskName").val();
    	var riskMonth = $("#riskMonth").val();
    	var riskType = $("#riskType").val();
    	window.open("/risk/download?entName="+entName+"&buildDateLeft="+buildDateLeft+"&buildDateRight="+buildDateRight+"&industry="+industry+"&nsrsbh="+nsrsbh+"&regisAddr="+regisAddr+"&businessScope="+businessScope+"&legalPerson="+legalPerson+"&financePerson="+financePerson+"&fxGradeLeft="+fxGradeLeft+"&fxGradeRight="+fxGradeRight+"&examStatus="+examStatus+"&examDateLeft="+examDateLeft+"&examDateRight="+examDateRight+"&examPeople="+examPeople+"&identityStatus="+identityStatus+"&managerDepart="+managerDepart+"&riskName="+riskName+"&riskMonth="+riskMonth+"&riskType="+riskType);
    });
    function bind() {
        util.bindEvents([{
        	el:'.show',
        	event:'click',
        	handler:function(){
        		var fxId = table.row($(this).closest('td')).data().fxId;
        		layer.open({
        			type:2,
        			title:"主要风险项",
        			area:['800px','300px'],
        			content:'/risk/showRiskDetail?fxId='+fxId
        		})
        	}
        },{
        	el:'#selectIndustry',
        	event:"click",
        	handler:function(){
        		doselectIndustry();
        	}
        },{
        	el:".reset",
        	event:"click",
        	handler:function(){
        		doClear();
        	}
        }])
    };
    function doselectIndustry(){
    	var select_industry_url = window.CONFIG.select_industry_url;
    	layer.open({
    		type :2,
    		title:"请选择行业类型",
    		area:['420px','666px'],
    		content: select_industry_url,
    		end: function () {
    			$("#Industry").val(_treeData.orgName);
    			$("#hiddenIndustry").val(_treeData.orgCode);
    		}
    	})
    }
    function doClear(){
    	$(".clx").val("");
    	$(".clxs").val("3");
    	$("#managerDepart").val("13301913300");
    	$("#identityStatus").val("高危风险");
    	$("#examStatus").val("2");
    }
});
















