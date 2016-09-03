/**
 * Created by charles on 16/9/3.
 */
var accountValidator = $('#accountForm').validate({
    errorElement: 'span',
    submitHandler: function(form, e){
        e.preventDefault()
        $('#accountBtn').button('loading');

        $.ajax({
            url: '/business/user/' + userId,
            data: {
                nickname: form.nickname.value,
                companyName: form.companyName.value,
                email: form.email.value
            },
            method: 'put',
            complete: function(){
                $('#accountBtn').button('reset');
            },
            success: function(){
                window.location.href = '/account/profile';
            },
            error: function(data){
                var result = data.responseJSON;
                if(result && result.message) {
                    $('#account-error-msg').text(result.message);
                }
                $('#account-error-msg').show();
            }
        });
    }
});

var passwordValidator = $('#passwordForm').validate({
    rules: {
        oldPassword: {
            required: true
        },
        newPassword: {
            required: true
        },
        newPassword2: {
            required: true,
            equalTo: '#newPassword'
        }
    },
    messages: {
        oldPassword: {
            required: '请输入老密码'
        },
        newPassword: {
            required: '请输入新密码'
        },
        newPassword2: {
            required: '请重复输入新密码',
            equalTo: '两次输入的密码不一致'
        }
    },
    errorElement: 'span',
    submitHandler: function(form, e){
        e.preventDefault()
        $('#passwordBtn').button('loading');

        $.ajax({
            url: '/business/user/' + userId + '/changePassword',
            data: {
                oldPassword: form.oldPassword.value,
                newPassword: form.newPassword.value
            },
            method: 'put',
            complete: function(){
                $('#passwordBtn').button('reset');
            },
            success: function(){
                window.location.href = '/account/profile';
            },
            error: function(data){
                var result = data.responseJSON;
                if(result && result.message) {
                    $('#account-error-msg2').text(result.message);
                }
                $('#account-error-msg2').show();
            }
        });
    }
});

$('#profileModal').on('hidden.bs.modal', function (e) {
    accountValidator.resetForm();
    $('.form-control.error', $(this)).removeClass('error');
    $('.form-control.valid', $(this)).removeClass('valid');
    $('.error-msg', $(this)).hide();
});
$('#passwordModal').on('hidden.bs.modal', function (e) {
    passwordValidator.resetForm();
    $('.form-control.error', $(this)).removeClass('error');
    $('.form-control.valid', $(this)).removeClass('valid');
    $('.error-msg', $(this)).hide();
    passwordForm.reset();
});