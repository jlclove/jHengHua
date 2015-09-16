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
                window.location.href = '/admin/index';
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
