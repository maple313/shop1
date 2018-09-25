layui.extend({
    admin: '{/}../../static/js/admin'
});

layui.use(['form', 'table', 'jquery', 'admin'], function () {
    var form = layui.form,
        table = layui.table,
        $ = layui.jquery,
        admin = layui.admin;

    $("#btnImport").click(function(){

        //点击后禁用按钮
        $("#btnImport").addClass('layui-btn-disabled').attr('disabled',"true");
        $.post(
            //url
            '../../scenery/indexlib/import',
            //data
            null,
            //success
            function(data){
                var sss=data.msg;
                if(sss="success!"){
                    layer.msg("导入成功！", {icon: 1},function () {
                        var index = parent.layer.getFrameIndex(window.name);
                        //关闭当前frame
                        parent.layer.close(index);
                        //停留在原来页面刷新
                        window.location.reload();
                    });
                }else{
                    layer.msg("导入失败！",{icon: 3});
                    window.location.reload();
                }
            },
            //dataType
            'json'
        );
        //点击提交异步请求到后台，一键导入索引库成功之后操作
        //1,提交成功或者失败
        //2,按钮再改为可用
    });


});