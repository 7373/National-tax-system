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
    function initDataTable() {
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#user-table',
            scrollX: true, //支持滚动
            //是否加索引值
            showIndex: true,
            ajax: {
                url:'/entMaintain/doGetEntMaintainList',
            },
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: null, className:"center",defaultContent: 1,width:"50px"},
                {data: 'nsrsbh', className:"center",width:"150px"},
                {data: 'entName', className:"center",width:"200px"},
            ],
            columnDefs: []
        })
    }
    $("#search").click(function(){
    	searchParams=$("#qryForm").serializeObject();//查询参数声明!
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
               layer.open({
            	type:2,
       			title:"风险预警点",
       			area:['780px','300px'],
       			content:'/risk/showRiskDetail?fxId='+$(this).attr('fxId')
       		})
            }
        }])
    };
});


