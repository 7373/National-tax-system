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
//        initDataTable();
        bind();
    }
    
    function buildJson(){
    	var checkFlag = true;
    	$("input[type='text']").each(function(index,item){
    		if(!$(item).val()){
    			layer.msg("核查结果录入不能为空！", {time: 800}, function() {});
    			checkFlag = false;
    		}
    	});
    	if(!checkFlag) return ;
    	var length = $("input[type='text']").length;
    	var ids="",results="";
    	$("input[type='text']").each(function(index,item){
    		ids+=$(item).attr("detailid");
    		results+=$(item).val();
    		if(index!=(length-1)){
    			ids+=',';
    			results+=',';
    		}
    	});
    	$("#ids").val(ids);
    	$("#results").val(results);
    	var formParam = $('#content_form').serializeObject();
        http.httpRequest({
            url: '/risk/doUpdateWarnProcessDetail',
            serializable: false,
            data: formParam,
            type: 'post',
            success: function (json) {
            	if(json.status=="success"){
					layer.msg("处理成功", {time: 800}, function() {
						parent._processResult = {};
						parent._processResult.status = "success";
						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		                parent.layer.close(index); //再执行关闭   
					});
				}else{
					layer.msg("处理失败", {time: 800}, function() {});
				}
            }
        });
        }

    /**
     * 初始化dataTable
     */
    function initDataTable() {
    	var mon =$("#hismonth").val(); 
    	if(!mon) $("#hismonth").val($("#opt_1").val());//月份不限制时给最大月份
    	var searchParams=$("#qryForm").serializeObject();//查询参数声明!
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
            scrollX: true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/risk/warnprocesslist.json',
                data:function(d){
                	d.params = searchParams;
                }
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: null, className:"center",defaultContent: 1},
                {data: 'nsrsbh', className:"center"},
                {data: 'entName', className:"center"},
                {data: 'buildDate', className:"center"},
                {data: 'month', className:"center"},
                {data: 'riskTypeDesc', className:"center"},
                {data: 'fxGrade', className:"center"},
                {data: 'identityStatus', className:"center"},
                {data: 'riskNum', className:"center"},
                {data: 'hisNum', className:"center"}
            ],
            columnDefs: [{
            	targets:8,
            	render:function(data,type,row,meta){
            		return "<span class='light-gray'><a fxId='"+row.fxId+"' href='javascript:void(0)' class='riskNum'>"+row.riskNum+"</a></span>"
            	}
            }]
        })
    }
    
    function bind() {
        util.bindEvents([{
            el: '#check',
            event: 'click',
            handler: function() {
            	buildJson();
            }
        },{
            el: '#close',
            event: 'click',
            handler: function() {
            	var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.layer.close(index); //再执行关闭    
            }
        }])
    };
});


