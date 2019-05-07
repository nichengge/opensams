$('.register-btn').on('click', function() {
    let studentName = $('.student-name').val();
    let studentId = $('.student-id').val();
    let studentEmail = $('.student-email').val();
    let studentCollege = $('.student-college').val();
    let studentAssociation = $('.student-association').val();
    let studentPassword = $('.student-password').val();
    // TODO: 密码重输校验
    let studentRePassword = $('.student-repassword').val();
    let studentRegisterKey = $('.student-register-key').val();

    let data = {
        studentName: studentName,
        studentId: studentId,
        studentEmail: studentEmail,
        studentCollege: studentCollege,
        studentAssociation: studentAssociation,
        studentPassword: studentPassword,
        studentRegisterKey: studentRegisterKey
    };

    sendPostRequest('/register', data, function(response) {
        alert('注册成功');
        location.href = '/login';
    }, function(response) {
        alert('注册失败');
        console.log(response.message);
    });

});

$(function () {
    $('.select2').select2({
        placeholder: '社团',
        allowClear: true
    });

    $('input').iCheck({
        checkboxClass: 'icheckbox_square-blue',
        radioClass: 'iradio_square-blue',
        increaseArea: '20%' /* optional */
    });
});
