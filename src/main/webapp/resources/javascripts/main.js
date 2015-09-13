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
            $layer.hide();
            setTimeout(function(){
                $layer.remove();
            }, 0);
        }
    };

    w['Loading'] = Loading;
})(window, $);

//login
$('#btnAccount').on('click', function(e){
    e.preventDefault();
    $('#loginModal').modal('show');
});
$('.loginOrRegist').on('click', function(e){
    e.preventDefault();
    $('#registModal,#loginModal').modal('toggle');
});
$(document).ready(function(){
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
                required: '请输入手机号'
            },
            password: {
                required: '请输入密码'
            }
        }
    });
    $('#registForm').validate({
        rules: {
            username: {
                required: true
            },
            nickname: {
                required: true
            },
            password: {
                required: true
            },
            password2: {
                required: true
            }
        },
        messages: {
            username: {
                required: '请输入手机号'
            },
            nickname: {
                required: '请输入昵称'
            },
            password: {
                required: '请输入密码'
            },
            password2: {
                required: '请确认密码'
            }
        }
    });
});
