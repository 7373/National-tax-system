require(['common/util', 'component/iframeLayer', 'component/dataTable', 'common/http', 'handlebars', 'jquery'], function (util, layer, dataTable, http, handlebars) {

    init();
    /**
     * 初始化函数集合
     */
    function init() {
        initDataTable();
        bind();
    }


    var table;

    /**
     * 初始化dataTable
     */
    function initDataTable() {
        var tpl = $('#tpl').html();
        var template = handlebars.compile(tpl);
        table = dataTable.load({
            //需要初始化dataTable的dom元素
            el: '#role-table',
            //是否加索引值
            showIndex: true,
            ajax: '/admin/system/sysrole/list.json',
            //需注意如果data没有对应的字段的，请设置为null，不然ie下会出错;
            //className不要写成class
            columns: [
                {data: null, width: '100px', className: 'center'},
                {data: 'name', width: '150px'},
                {data: 'desc'},
                {data: null, width: '120px', className: 'center'}
            ],
            columnDefs: [
                {
                    targets: 3,
                    render: function (data, type, row, meta) {
                        var context = {
                            func: [
                                {
                                    'text': '编辑',
                                    'class': 'btn btn-xs btn-primary js-edit'
                                },
                                {
                                    'text': '删除',
                                    'class': 'btn btn-xs btn-danger js-delete'
                                }
                            ]
                        };
                        return template(context);
                    }
                }
            ]
        });

    }


    function bind() {
        util.bindEvents([{
            el: '.js-add',
            event: 'click',
            handler: function () {
                layer.dialog({
                    title: '新增用户',
                    area: ['628px', '500px'],
                    content: '/admin/system/sysrole/show',
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        }, {
            el: '.js-edit',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.dialog({
                    title: '编辑用户',
                    area: ['628px', '500px'],
                    content: '/admin/system/sysrole/show?id=' + data.id,
                    callback: function (data) {
                        //重新加载列表数据
                        if (data.reload) {
                            table.ajax.reload();
                        }
                    }
                })
            }
        }, {
            el: '.js-delete',
            event: 'click',
            handler: function () {
                var data = table.row($(this).closest('td')).data();
                layer.confirm('确定要删除吗?', {icon: 2, title: '提示'}, function (index) {
                    http.httpRequest({
                        url: '/admin/system/sysrole/delete',
                        data: {id: data.id},
                        success: function (data) {
                            if (data.status == 'success') {
                                //重新加载列表数据
                                if (data.msg) {
                                    layer.msg(data.msg, {time: 500}, function () {
                                        table.ajax.reload();
                                    });
                                }
                            }
                        }
                    });

                });
            }
        }])
    }

})
