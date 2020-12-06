$(function () {//网页加载完成执行方法
    //使用$("#id")通过id获取页面元素，绑定表单提交事件
    $("#login_form").submit(function () {
        //自己ajax提交表单数据
        $.ajax({
            url:"../login",//请求的服务路径
            type:"post",//请求方法
            // 请求数据类型，不使用默认为表单数据类型。如果是json要注明
            //contentType:"application/json",
            data:$("#login_form").serialize(),//序列化表单数据格式
            dataType:"json",//响应的数据类型
            success:function (r) {
                if (r.success){//用户登录业务操作成功
                    //跳转到文章列表操作
                    window.location.href = "../jsp/articleList.jsp";
                }else {
                    alert("错误码：" + r.code + "\n错误信息" + r.message);
                }

            }

        })
        //禁用表单默认提交
        return false;
    })

})