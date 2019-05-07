$('.login-btn').on('click', function() {
    let loginName = $('.login-name').val();
    let loginPwd = $('.login-pwd').val();
    let isRememberMe = $('.is-remember-me').is(':checked');

    let data = {
        loginName: loginName,
        loginPwd: loginPwd,
        isRememberMe: isRememberMe
    };

    sendPostRequest('/login', data, function(response) {
        alert('登录成功');
        location.href = '/';
    }, function(response) {
        alert('登录失败');
        location.href = '/login';
    });

});

$(function () {
    $('input').iCheck({
        checkboxClass: 'icheckbox_square-blue',
        radioClass: 'iradio_square-blue',
        increaseArea: '20%' /* optional */
    });
});