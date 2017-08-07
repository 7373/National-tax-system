require(['common/util', 'component/iframeLayer', 'common/http', 'jquery.validate', 'jquery','jquery.serialize'], function (util, layer, http) {
	//执行初始化函数
    init();

    /**
     * 初始化集合
     */
    function init() {
        formValid();
    }

    /**
     * 
     */
    function formValid() {
        $('#ent_form').validate({
            rules: {
            	entName: {
                    required: true
                },
                nsrsbh: {
                    required: true
                }
            },
            messages: {
            	entName: {
                    required: '企业名称不能为空'
                },
                nsrsbh: {
                    required: 'nsrsbh不能为空'
                }
            },
            submitHandler: function (form) {
                var formParam = $(form).serializeObject();
                http.httpRequest({
                    url: '/entMaintain/save',
                    type: 'post',
                    data: formParam,
                    serializable: true,
                    success: function (data) {
                    	layer.msg(data.msg, {time: 1000}, function () {
                        	if(data.status=='success'){
                        	   $('#reset').click();
                        	}
                        });
                    }
                });
            }
        });
    }
})