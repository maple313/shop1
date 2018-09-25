//引入admin.js(webapp/static/js/admin.js)
//itemlist.js(webapp/static/js/itemlist.js)
layui.extend({
    admin: '{/}../../static/js/admin'
});
//按需加载admin.js
layui.use(['admin', 'jquery', 'table', 'layer'], function () {
    //初始化变量
    var admin = layui.admin,
        $ = layui.jquery,
        table = layui.table,
        layer = layui.layer;
    //对表格进行渲染
    table.render({
        //什么是表格属性：page,elem,url,cols
        //什么是列属性：type,field,title
        //开启分页
        page: true,
        //渲染的容器是谁
        elem: '#sceneryArticle',
        //异步提交请求给后台返回JSON
        url: '../../items',
        //要显示的表头是什么
        cols: [[
            //开启复选框按钮
            {type: 'checkbox'},
            {field: 'sid', title: '景点编号'},
            {field: 'sname', title: '景点名称'},
            {field: 'sprice', title: '景点门票'},
            {field: 'slocation', title: '景点位置'},
            {field: 'scontent', title: '景点介绍'},
            {title: '操作', templet: '#myScenery'}
        ]]
        // ,done:function(res,curr,count){
        //     // var $statusCol = $("[data-field='status']");//商品状态这一列
        //     // console.log($statusCol.children());
        //     // console.log($("[data-field='status']").children());
        //     $("[data-field='status']").children().each(function(){
        //         // this 当前DOM对象
        //         //$(this) 当前jQuery对象
        //         // val() text() html() 三个函数都是既可以设值也可以取值
        //         // val() 一般用于文本框 单选按钮 复选按钮这些的取值
        //         // text() 一般是用于获取指定控件中的文本 <div><strong>hello</strong></div> text() ====> hello
        //         // html() 一般是用于获取指定控件中的标签和文本 <div><strong>hello</strong></div> html() ====> <strong>hello</strong>
        //         // console.log($(this).text());
        //         if($(this).text() == '1'){
        //             //正常
        //             $(this).text('正常');
        //         }else if($(this).text() == '2'){
        //             //下架
        //             $(this).text('下架');
        //         }
        //     });
        // }
    });

    //定义active
    var active = {
        reload: function () {
            //val text html
            var title = $.trim($("#title").val());
            if (title.length > 0) {
                table.reload('sceneryArticle', {
                    page: {curr: 1},
                    where: {title: title}
                });
            }

        },
        getCheckData: function () {
            //你点击了"批量删除"
            //为了获取到被选中的行
            var data = table.checkStatus("sceneryArticle").data;
            if (data.length > 0) {
                //确认框
                //至少选中一行
                //为了获得所有选中行的id
                var ids = [];
                for (var i = 0; i < data.length; i++) {
                    ids.push(data[i].sid);
                }
                layer.confirm("真的要删除吗",{icon: 3, title:'删除'},function (index) {
                    //异步提交到后台 ids
                    $.post(
                        '../../scenery/batch',
                        {'ids[]': ids},
                        function (data) {
                            //至少删除一条记录
                            if (data > 0) {
                                //停留在原来页面刷新
                                $('.layui-laypage-btn').click();
                                layer.msg("恭喜，删除成功！", {icon: 1});

                            }

                        }
                    );
                    layer.close(index);
                })
            } else {
                //没有选中
                layer.msg("请选择至少一行后再批量删除！", {icon: 2});
            }
        }
    };

    //点击"批量删除"按钮触发的事件
    $("#btnsn").on('click', function () {

        //为了获取data-type属性
        var type = $(this).data("type");//getCheckData
        //判断是否具有getCheckData，若有，那么直接调用，否则什么都不做
        active[type] ? active[type].call(this) : '';
    });

    //点击"模糊查询"按钮触发的事件
    $(".layui-row .layui-btn").on('click', function () {
        //为了获取按钮的data-type属性
        var type = $(this).data("type");//reload
        //判断active变量中是否具有reload属性
        active[type] ? active[type].call(this) : '';
    });

});