function initStudentTable(dataTableOptions) {
    dataTableOptions.ajax = {
        url: "/personnel/list?start=0&offset=100",
        type: 'get',
        dataSrc: ''
    };
    dataTableOptions.columns = [
        {data: 'studentName'},
        {data: 'studentCode'},
        {data: 'localMail'},
        {data: 'college'},
        {data: 'major'},
        {data: 'association'},
        {data: 'roleList'},
        {
            render: function (data, type, row, meta) {
                var editAnchor = ' <a href="javascript:" data-toggle="modal" data-target="#myModal" onclick="initEditInfo(\'' + row.studentCode + '\')">编辑</a> ';
                var deleteAnchor = ' <a href="javascript:" onclick="deleteStudent(\'' + row.studentCode + '\')">删除</a> ';
                return editAnchor + deleteAnchor;
            }
        }
    ];

    $('#member-table').DataTable(dataTableOptions);
}

function initEditInfo(studentCode) {
    $.ajax({
        url: '/personnel/getStudentByCode?studentCode=' + studentCode,
        method: 'get',
        dataType: 'json',
        success: function (student) {
            $('input[name="studentName"]').val(student.studentName);

            $('input[name="studentCode"]').val(student.studentCode);

            $('input[name="birthday"]').val(student.birthday);

            if (student.sex === '男') {
                $('#maleRadio').attr('checked', true);
            } else if (student.sex === '女') {
                $('#femaleRadio').attr('checked', true);
            }

            $('input[name="mail"]').val(student.mail);

            $('input[name="localMail"]').val(student.localMail);

            $('input[name="phone"]').val(student.phone);

            $('input[name="qq"]').val(student.qq);

            $('input[name="college"]').val(student.college);

            $('input[name="major"]').val(student.major);
        }
    });
}

function deleteStudent(studentCode) {
    $.ajax({
        url: '/personnel/deleteStudentByCode',
        method: 'post',
        dataType: 'json',
        data: {
            studentCode: studentCode
        },
        success: function (response) {
            if (response && response.code === '500') {
                console.log(response.message);
                alert('删除失败，请联系管理员解决');
            } else if (response && response.code === '200') {
                $.fn.dataTable.tables({visible: true, api: true}).ajax.reload();
            }
        }
    });
}

function bindSubmitEvent() {
    $('#submitStudentInfoBtn').on('click', function() {
        var studentCode = $('input[name="studentCode"]').val();

        var studentName = $('input[name="studentName"]').val();

        var loginPwd = $('input[name="initPwd"]').val();

        var birthday = $('input[name="birthday"]').val();

        var sex = $('input[name="sex"]:checked').val();

        var mail = $('input[name="email"]').val();

        var localMail = $('input[name="localMail"]').val();

        var phone = $('input[name="phone"]').val();

        var qq = $('input[name="qq"]').val();

        var college = $('input[name="college"]').val();

        var major = $('input[name="major"]').val();

        var description = $('textarea[name="description"]').val();

        var associationId = $('select[name="association"]').val();

        var roleCode = $('select[name="role"]').val();

        var student = {
            studentCode: studentCode,
            studentName: studentName,
            loginPwd: loginPwd,
            birthday: birthday,
            sex: sex,
            mail: mail,
            localMail: localMail,
            phone: phone,
            qq: qq,
            college: college,
            major: major,
            description: description,
            associationId: associationId,
            roleCode: roleCode
        };

        submitStudentInfo(student);
    });
}

function submitStudentInfo(student) {
    $.ajax({
        url: '/personnel/submitStudentInfo',
        method: 'post',
        dataType: 'json',
        data: {
            studentName: student.studentName,
            studentCode: student.studentCode,
            birthday: student.birthday,
            sex: student.sex,
            mail: student.mail,
            localMail: student.localMail,
            phone: student.phone,
            qq: student.qq,
            college: student.college,
            major: student.major,
            loginPwd: student.loginPwd,
            description: student.description,
            associationId: student.associationId,
            roleCode: student.roleCode
        },
        success: function(response) {
            if (response && reponse.code === '500') {
                console.log(response.message);

                alert('系统发生异常，请联系管理员');
            }
        }
    });
}



