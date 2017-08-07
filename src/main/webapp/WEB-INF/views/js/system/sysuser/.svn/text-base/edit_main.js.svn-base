require(['component/iframeLayer', 'common/util', 'common/http', 'layer1', 'jquery.validate', 'jquery.serialize'], function (layer, util, http) {


    init();

    /**
     * 初始化函数集合
     */

    function init() {
        formValid();
        bind();
    }

    /**
     * 表单验证
     */
    function formValid() {
        $('#sysUserForm').validate({
            rules: {
                username: {
                    required: true
                },
                email: {
                    required: true
                }
            },
            /**
             * 如果想用layer.tips做验证提示，可以用这个方法
             * @param errorMap
             * @param errorList
             */
            showErrors: function (errorMap, errorList) {
                for (var i in errorMap) {
                    layer.tips(errorMap[i], $('#sysUserForm input[name=' + i + ']'), {
                        tips: 3,
                        tipsMore: true,
                        ltype: 0
                    });
                }
            },
            submitHandler: function () {
                var formParam = $('#sysUserForm').serializeObject();
                http.httpRequest({
                    url: '/admin/system/sysuser/save',
                    serializable: true,
                    data: formParam,
                    type: 'post',
                    success: function (data) {
                        layer.msg(data.msg, {time: 1000}, function () {
                            layer.close({reload: true});
                        });
                    }
                })
            }
        })
    }

    function bind() {
        util.bindEvents([{
            el: '#cancel',
            event: 'click',
            handler: function () {
                layer.close();
            }
        }])
    }

})