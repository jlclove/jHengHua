/**
 * Created by charles on 15/9/16.
 */
$('#loginForm').validate({
    rules: {
        username: {
            required: true
        },
        password: {
            required: true
        }
    },
    messages: {
        username: {
            required: '请输入用户名'
        },
        password: {
            required: '请输入密码'
        }
    },
    errorElement: 'span',
    submitHandler: function(form, e){
        e.preventDefault()
        $('#loginBtn').button('loading');
        $('.error-msg').hide();

        $.ajax({
            url: '/business/user/login',
            data: {
                mobilePhone: form.username.value,
                password: form.password.value
            },
            method: 'post',
            complete: function(){
                $('#loginBtn').button('reset');
            },
            success: function(){
                window.location.href = '/admin';
            },
            error: function(data){
                var result = data.responseJSON;
                if(result && result.message) {
                    $('.error-msg').text(result.message);
                }
                $('.error-msg').show();
            }
        });
    }
});


var Template = {
    // 模板缓存
    _tmplCache : {},
    // 获取模板
    getHtml: function(url, callback){
        if(this._tmplCache[url]) {
            callback(this._tmplCache[url]);
        } else {
            $.get('/static/template/' + url, function(res){
                callback(res);
                Template._tmplCache[url] = res;
            })
        }
    },
    // 计算分页
    getPage : function(pageNo, totalPages) {
        var show = 2;
        var left = pageNo - show;
        var right = pageNo + show, totalPages;
        if(left < 1) {
            left = 1;
            right = Math.min(right + show - pageNo + 1, totalPages);
        }
        if (right> totalPages){
            right = totalPages;
            left = Math.max(left + (totalPages - (show + pageNo)), 1);
        }
        return {
            left: left,
            right: right,
            pageNo: pageNo,
            totalPages: totalPages
        };
    }
};
