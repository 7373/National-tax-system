require(['layer1',
         'component/dataTable',
         'common/util',
         'common/http',
         'jquery',
         'jquery.serialize',
         'handlebars',
         'jquery','laydate'], function (layer, dataTable, util, http, handlebars) {
	var table;
	init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }
    
    //解析日期格式
	function parseTime(date){
		return date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate();
	}

    /**
     * 初始化dataTable
     */
	var searchParams;
    function initDataTable() {
    	$("#hismonth").val($("#opt_1").val());//月份不限制时给最大月份
    	searchParams=$("#qryForm").serializeObject();//查询参数声明!
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
            ajax: {
                url:'/risk/warnprocesslist.json',
                type: 'post',
                data:function(d){
                	d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: null, className:"center",defaultContent: 1},
                {data: 'nsrsbh', className:"center"},
                {data: 'entName', className:"center",width:"300px"},
                {data: 'buildDate', className:"center",width:"70px"},
                {data: 'riskMonth', className:"center"},
                {data: 'riskTypeDesc', className:"center"},
                {data: 'identityStatus', className:"center"},
                {data: 'riskNum', className:"center"},
                {data: 'hisNum', className:"center"}
            ],
            columnDefs: [
                         {
            	targets:7,
            	render:function(data,type,row,meta){
            		return "<span class='light-gray'><a fxId='"+row.fxId+"' href='javascript:void(0)' class='riskNum'>"+row.riskNum+"</a></span>"
            	}
            },
            {
            	targets:0,
            	render:function(data,type,row,meta){
            		return "<input class='radio' type='radio' name='radio' fxId='"+row.fxId+"' />"
            	}
            },{
            	targets:8,
            	render:function(data,type,row,meta){
            		var num = row.hisNum;
            		if(num==null||num=="") num = 0;
            		return "<span class='light-gray'><a fxId='"+row.fxId+"' riskMonth='"+row.riskMonth+"' href='javascript:void(0)' class='hisNum'>"+num+"</a></span>"
            	}
            }]
        })
    }
    $("#search").click(function(){
    	var relmon = $("#riskMonth").val();
    	if(relmon) $("#hismonth").val(relmon);
    	var mon =$("#hismonth").val();
    	if(!mon) $("#hismonth").val($("#opt_1").val());//月份不限制时给最大月份
    	searchParams =$("#qryForm").serializeObject();//查询参数声明!
    	table.ajax.reload();
    });
    function bind() {
        util.bindEvents([{
            el: '.check',
            event: 'click',
            handler: function() {
               layer.open({
            	   type:2,
       			title:"核查结果",
       			area:['780px','300px'],
       			content:'/risk/showQueryDetail?fxId='+$(this).attr('id')
       		})
            }
        },{
            el: '.riskNum',
            event: 'click',
            handler: function() {
            	if($(this).text()==0) return;
               layer.open({
            	   type:2,
       			title:"风险预警点",
       			area:['780px','300px'],
       			content:'/risk/showRiskDetail?fxId='+$(this).attr('fxId')
       		})
            }
        },{
            el: '#warning',
            event: 'click',
            handler: function() {
            	var fxId = $("input[type='radio']:checked").attr("fxId");
            	if(!fxId){
            		layer.msg("请选择处理记录！", {time: 1000}, function() {});	
//            		alert("请选择处理记录！");
            		return;
            	}
               layer.open({
            	   type:2,
       			title:"预警处理",
       			area:['780px','400px'],
       			content:'/risk/doEnWarnProcessDetail?fxId='+fxId+'&uid='+$("#uid").val()+'&name='+$("#name").val()+'&examManagerDepart='+$("#examManagerDepart").val(),
       			end: function () { 
       				if(_processResult.status=="success")
       				table.ajax.reload();
       			}
       		})
            }
        },{
        	el:'.hisNum',
        	event:'click',
        	handler:function(){
        		if($(this).text()==0) return;
        		layer.open({
        			type:2,
        			title:"历史核查记录",
        			area:['780px','300px'],
        			content:'/risk/showHistoryDetail?fxId='+$(this).attr("fxId")+'&riskMonth='+$(this).attr("riskMonth")
        		})
        	}
        }
        ])
    };
});


