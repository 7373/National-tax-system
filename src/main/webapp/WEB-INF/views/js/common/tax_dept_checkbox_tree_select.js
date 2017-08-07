require(['common/util', 'layer1', 'common/http', 'handlebars', 'layer1', 'ztree','ztreeCheck'], function (util, layer, http, handlebars) {
	init();
    /**
     * 初始化函数集合
     */
    function init() {
        loadTree();
        bind();
    }

    //部门树对象
    var treeObj = null;

    //加载部门树
    function loadTree() {
        var treeUrl = window._CONFIG.treeUrl;
        //部门树配置
        var setting = {
            check: {
                enable: true,
                chkStyle: "checkbox",
                autoCheckTrigger: true,
                radioType: "all"
                
            },
            data: {
                key: {
                    name: "hyMc",
                    title: "hyMc"
                },
                simpleData: {
                    enable: true,
                    idKey: "area",
                    pIdKey: "parentId"

                }
            }
        };
        setting.check.chkboxType = { "Y" : "ps", "N" : "ps" };
        http.httpRequest({
            type: 'post',
            url: treeUrl,
            success: function (data) {
                treeObj = $.fn.zTree.init($('#sysDepartTree'), setting, data);
                var tree = $.fn.zTree.getZTreeObj("sysDepartTree");
                beforeExpand(tree.getNodes(),tree);
            }
        });
    }
//    部门树展开时事件
    function beforeExpand(treeNodes,tree) {
        if(treeNodes!=null){
            hideNullNode(treeNodes,tree);
        }
    }

    /**
     * 以递归的形式隐藏子节点为空的节点
     * @param treeNode
     * @param treeObj
     */
    function hideNullNode(treeNode,treeObj){
        for(var i in treeNode){
            if(treeNode[i].children!=null){
                hideNullNode(treeNode[i].children,treeObj);
            }else{
                if(treeNode[i].isParent==true){
                    treeObj.hideNode(treeNode[i]);
                }
            }
        }
    }
    
    function bind() {
        util.bindEvents([
            {
                el: '#departmentSubmit',
                event: 'click',
                handler: function () {
                    var _treeData = {};
                    var treeObj = $.fn.zTree.getZTreeObj("sysDepartTree");
                    var nodes = treeObj.getCheckedNodes(true);
                    if (nodes.length == 0) {
                        layer.msg("请选择行业", {ltype: 0, time: 2000});
                        return false;
                    } else {
                    	 var orgName="",orgCode="";
                    	 for (var a = 0; a < nodes.length; a++) {
                    		if(nodes[a].area.length>1){
                    			orgName += nodes[a].hyMc + ",";
                    			if(orgCode.length==0){
                    				orgCode += nodes[a].area.substring(1,nodes[a].area.length);
                    			}else{
                    				orgCode +="," + nodes[a].area.substring(1,nodes[a].area.length);	
                    			}
                    		}
                         }
                    	parent._treeData = {};
                        parent._treeData.orgName = orgName.substring(0,orgName.length);
                        parent._treeData.orgCode = orgCode.substring(0,orgCode.length);
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭     
                    }
                }
            },
            {
                el: '#cancle',
                event: 'click',
                handler: function () {
                	var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                    parent.layer.close(index); //再执行关闭     
                }
            }
            ,{
                el: '#checkAll',
                event: 'click',
                handler: function () {
                	if($('#checkAll').val()=='全选'){
                		checkNode("checkAllTrue");
                		$('#checkAll').val('反选');
                	}else{
                		checkNode("checkAllFalse");
                		$('#checkAll').val('全选');
                	}
                }
            }
        ])
    }

	function checkNode(type) {
        var zTree = $.fn.zTree.getZTreeObj("sysDepartTree"),
            nodes = zTree.getSelectedNodes();
        if (type.indexOf("All") < 0 && nodes.length == 0) {
            alert("请先选择一个节点");
        }
        if (type == "checkAllTrue") {
            zTree.checkAllNodes(true);
        } else if (type == "checkAllFalse") {
            zTree.checkAllNodes(false);
        }
    }
})