/**
 * Created by charles on 15/9/12.
 */
(function (w, $) {
    var $layer = $('<div class="loading-container" style="display: none;"><i class="fa fa-spinner fa-spin"></i></div>');
    var Loading = {
        open: function () {
            $('.product-wrap').append($layer);
            $layer.show();
        },

        close: function(){
            setTimeout(function(){
                $layer.remove();
            }, 500);
        }
    };

    w['Loading'] = Loading;
})(window, $);

//login
$('.btnAccount').on('click', function(e){
    e.preventDefault();
    $('#popModal').modal('show');
});
$('.loginOrRegist').on('click', function(e){
    e.preventDefault();
    $('#registBody,#loginBody').toggle();
    $('#popModal').toggleClass('login-modal').toggleClass('regist-modal');
    resetForm();
});

// 重置表单
function resetForm(){
    $('#loginForm').validate().resetForm();
    $('#registForm').validate().resetForm();
    $('#loginForm')[0].reset();
    $('#registForm')[0].reset();
    $('input.valid').removeClass('valid');
    $('input.error').removeClass('error');
    $('.error-msg').hide();
}

$.validator.addMethod('mobile', function(value, element){
    return this.optional( element ) || /^$/i.test( value );
}, '请输入正确的手机号码');

//退出
$('.btn-logout').on('click', function(){
    $.ajax({
        url: '/business/user/logout',
        method: 'post',
        success: function(){
            window.location.reload();
        }
    });
});

$(document).ready(function(){
    $('#loginForm').validate({
        rules: {
            userId: {
                required: true,
                minlength: 2
            },
            password: {
                required: true,
                minlength: 6
            }
        },
        messages: {
            userId: {
                required: '请输入用户名',
                minlength: '用户名不能少于2位'
            },
            password: {
                required: '请输入密码',
                minlength: '密码不能少于6位'
            }
        },
        submitHandler: function(form, e){
            e.preventDefault();
            $('.error-msg').hide();
            $('#btn-login').button('loading');
            setTimeout(function(){
                $.ajax({
                    url: '/business/user/login',
                    method: 'post',
                    data: {
                        mobilePhone: form.userId.value,
                        password: form.password.value
                    },
                    success: function(res){
                        window.location.reload();
                    },
                    error: function(data){
                        var result = data.responseJSON;
                        if(result && result.message) {
                            $('#loginBody .error-msg').text(result.message);
                        }
                        $('#loginBody .error-msg').show();
                    },
                    complete: function(){
                        $('#btn-login').button('reset');
                    }
                });
            }, 1000);
        }
        //errorPlacement: function(error, element){
        //    error.appendTo( element.closest(".form-group") );
        //    element.closest(".form-group").addClass('has-error');
        //}
    });
    $('#registForm').validate({
        rules: {
            mobilePhone: {
                required: true,
                minlength: 4
            },
            verifyCode: {
                required: true
            },
            nickname: {
                required: true,
                minlength: 4
            },
            password: {
                required: true,
                minlength: 6
            },
            password2: {
                required: true,
                equalTo: '#registForm input[name=password]',
                minlength: 6
            }
        },
        messages: {
            mobilePhone: {
                required: '请输入用户名',
                minlength: '用户名不能少于4位'
            },
            verifyCode: {
                required: '请输入短信验证码'
            },
            nickname: {
                required: '请输入昵称',
                minlength: '昵称不能少于4位'
            },
            password: {
                required: '请输入密码',
                minlength: '密码不能少于6位'
            },
            password2: {
                required: '请确认密码',
                equalTo: '两次输入的密码不一致',
                minlength: '密码不能少于6位'
            }
        },
        submitHandler: function(form, e){
            e.preventDefault();
            $('#btn-regist').button('loading');
            setTimeout(function(){
                $.ajax({
                    url: '/business/user/registerWithVC',
                    method: 'post',
                    data: {
                        mobilePhone: form.mobilePhone.value,
                        veriCode: form.verifyCode.value,
                        nickname: form.nickname.value,
                        password: form.password.value
                    },
                    success: function(res){
                        console.log(res);
                        $('#popModal').modal('hide');
                        resetForm();
                    },
                    error: function(res){
                        var error = {};
                        try {
                            error = JSON.parse(res.responseText);
                        } catch (e) {
                            error.message = '未知错误';
                        }
                        $('#registBody .error-msg').text(error.message).show();
                    },
                    complete: function(){
                        $('#btn-regist').button('reset');
                    }
                });
            }, 1000);
        }
    });

    //验证码
    function bindVerifyEvent() {
        $('.js_send_verify_code').off('click', bindVerifyEvent);
        $('.js_send_verify_code').addClass("disable")
        var last = 60;
        updateText(last);
        var interval = setInterval(function(){
            if(last <= 0) {
                clearInterval(interval);
                $('.js_send_verify_code').removeClass("disable")
                $('.js_send_verify_code').text("获取验证码");
                $('.js_send_verify_code').on('click', bindVerifyEvent);
            } else {
                last--;
                updateText(last);
            }
        }, 1000);
        function updateText(time){
            $('.js_send_verify_code').text(time + "s后重新获取");
        }
        $.post('/business/user/sendVeriCode', {mobilePhone: registForm.mobilePhone.value}, function(res){
            console.log(res);
        });
    }
    $('.js_send_verify_code').on('click', bindVerifyEvent);


    $('#keyword').on('keydown', function(e){
        if(e.keyCode == 13) {
            searchKeyWord();
        }
    });
});

//关键字搜索
function searchKeyWord(){
    window.location.href='/product/sample?keyword=' + encodeURIComponent($('#keyword').val())
}

var exhibitions = $('.exhibition-container ul li');
var index = 1, length = exhibitions.length;
if(length > 1) {
    setInterval(function(){
        if(index >= length) {
            index = 0;
        }

        if(index == 0){
            var $e = $(exhibitions[length - 1]);
            if($e.is('.active')) {
                $e.addClass('disactive');
            }
            $e.removeClass('active');
        } else {
            $(exhibitions[index - 1]).removeClass('active').addClass('disactive');
        }
        $(exhibitions[index]).removeClass('disactive').addClass('active');

        index++;
    }, 5000);
}

function handleBodyClick(e) {
    if($('#bs-menu-navbar-collapse').find(e.target).length == 0) {
        $('#bs-menu-navbar-collapse').collapse('hide');
        e.stopPropagation();
        e.preventDefault();
    }
}
$('#bs-menu-navbar-collapse').on('hidden.bs.collapse', function (e) {
    $('html, body').css('overflow', 'auto');
    $(document).off('click', handleBodyClick);
});
$('#bs-menu-navbar-collapse').on('shown.bs.collapse', function (e) {
    $('html, body').css('overflow', 'hidden');
    $(document).on('click', handleBodyClick);
})