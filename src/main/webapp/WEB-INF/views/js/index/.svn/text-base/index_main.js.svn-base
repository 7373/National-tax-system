require(['layer1', 'common/util', 'jquery', 'common/validateRules', 'metisMenu', 'contabs', 'jquery.layout','jquery.nanoscroller'], function (layer, util) {

    init();

    /**
     * 初始化函数集合
     */
    function init() {
        layoutInit();
        initMenu();
        bind();
        calcHeight();
        $(".nano").nanoScroller();
    }

    /**
     * 页面布局初始化
     */
    function layoutInit() {
        $('#container').layout({
            west: {
                size: '180'
            },
            north: {
                spacing_open: 0
            }
        });
    }

    /**
     * 初始化菜单
     */
    function initMenu() {
        $('#side-menu').metisMenu();
    }

    /**
     * 计算iframe主体高度
     */
    function setHeight() {
        var h = $(window).height();
        $('.J_mainContent').css('height', h - $('.J_mainContent').offset().top - 40 + 'px');
    }
    function calcHeight() {
        setHeight();
        window.onresize = function () {
            setHeight();
            setTimeout(function(){
                $(".nano").nanoScroller();
            },500);

        };
    }

    var el = $('.js-new-info-list');
    var len = el.find('li').length;
    var i = 0;
    var height = el.find('li').height();

    function bind() {
        util.bindEvents([{
            el: '.js-logout',
            event: 'click',
            handler: function () {
                logOut();
            }
        }, {
            el: '.js-tips-close',
            event: 'click',
            handler: function () {
                $(this).closest('.js-tips-box').fadeOut('1000',function(){
                    setHeight();
                });
            }
        }, {
            el: '.js-tips-last',
            event: 'click',
            handler: function () {
                if (i == 0) {
                    i = len - 1;
                } else {
                    i--;
                }
                el.stop().animate({
                    top: -i * height + 'px'
                }, 500);
            }
        }, {
            el: '.js-tips-next',
            event: 'click',
            handler: function () {
                if (i == len - 1) {
                    i = 0;
                } else {
                    i++;
                }
                el.stop().animate({
                    top: -i * height + 'px'
                }, 500);
            }
        }, {
            el: '.js-closeAll-tab',
            event: 'click',
            handler: function () {
                $('.J_menuTabs .J_menuTab:first').addClass('active');
                $('.J_mainContent .J_iframe:first').show();
                $('.J_menuTabs .J_menuTab:not(:first)').remove();
                $('.J_mainContent .J_iframe:not(:first)').remove();
            }
        }])
    }

    function logOut() {
        layer.confirm('确定要退出登录吗?', {icon: 2, title: '提示'}, function () {
            location.assign('/admin/logout');
        });
    }
})