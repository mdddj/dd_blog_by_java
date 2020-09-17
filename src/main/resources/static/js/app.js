// 系统弹窗
function showDialog(content,Func) {

        $('#dialogModalContent').text(content);
        $('#dialogModalOk').click(function () {
                Func()
        });
        $('#dialogModal').modal("show");
}

// 删除博客
$("#bBlogDetele").click(function () {

    showDialog("确认删除本篇博客吗?",function () {
        $.ajax({
            type:'DELETE',
            url:'/blog/delete/'+curr_blog_id,
            success:function(response){
                if(response){
                    window.location.href = "/";
                }
            }
        })
    });
})