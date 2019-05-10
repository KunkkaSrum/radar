
layui.use(['form', 'layer', 'jquery'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
    $ = layui.jquery;

    $(".loginBody .seraph").click(function () {
        layer.msg("这只是做个样式，至于功能，你见过哪个后台能这样登录的？还是老老实实的找管理员去注册吧", {
            time: 5000
        });
    })


    $("#submit").click(function () {
        $.ajax({
            type: 'post',
            url: "/authentication/form",
            data: $("#userForm").serialize(),
            dataType: 'json',
            // contentType:"application/json;charset=UTF-8",
            success: function (result) {
                console.log(result)
                if (result.code === 2000) {
                    window.location.href = result.msg;
                } else if (result.code === 2002) {
                    layer.msg("登录失败，用户名或密码错误！");
                }
            },
            error: function (re) {

            }
        })
    })


    //表单输入效果
    $(".loginBody .input-item").click(function (e) {
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    })
    $(".loginBody .layui-form-item .layui-input").focus(function () {
        $(this).parent().addClass("layui-input-focus");
    })
    $(".loginBody .layui-form-item .layui-input").blur(function () {
        $(this).parent().removeClass("layui-input-focus");
        if ($(this).val() != '') {
            $(this).parent().addClass("layui-input-active");
        } else {
            $(this).parent().removeClass("layui-input-active");
        }
    });


});

