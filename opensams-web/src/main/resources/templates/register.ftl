<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>OpenSCMS</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="/static/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/static/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="/static/bower_components/Ionicons/css/ionicons.min.css">
    <!-- Select2 -->
    <link rel="stylesheet" href="/static/bower_components/select2/dist/css/select2.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/static/plugins/iCheck/square/blue.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <a href="/"><b>Open</b>SCMS</a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">注册成为新成员</p>

        <div class="form-group has-feedback">
            <input type="text" name="studentName" class="form-control student-name" placeholder="姓名">
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <input type="text" name="studentId" class="form-control student-id" placeholder="学号">
            <span class="glyphicon glyphicon-pencil form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <input type="email" name="student-email" class="form-control student-email" placeholder="电子邮件">
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <input type="email" name="student-college" class="form-control student-college" placeholder="学院">
            <span class="glyphicon glyphicon-home form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <select name="student-association" class="form-control select2 student-association" data-placeholder="社团">
                <option></option>
                <#if studentAssociations??>
                    <#list studentAssociations as studentAssociation>
                        <option value="${studentAssociation.id}">${studentAssociation.name}</option>
                    </#list>
                </#if>
            </select>
        </div>
        <div class="form-group has-feedback">
            <input type="password" name="student-password" class="form-control student-password" placeholder="密码">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <input type="password" name="student-repassword" class="form-control student-repassword" placeholder="确认密码">
            <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
        </div>
        <div class="form-group has-feedback">
            <input type="password" name="student-register-key" class="form-control student-register-key" placeholder="授权注册密钥">
            <span class="fa fa-key form-control-feedback"></span>
        </div>
        <div class="row">
            <div class="col-xs-8">
            </div>
            <!-- /.col -->
            <div class="col-xs-4">
                <button type="button" class="btn btn-primary btn-block btn-flat register-btn">注册</button>
            </div>
            <!-- /.col -->
        </div>

        <a href="/login" class="text-center">我已有账号</a>
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 3 -->
<script src="/static/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Select2 -->
<script src="/static/bower_components/select2/dist/js/select2.full.min.js"></script>
<!-- iCheck -->
<script src="/static/plugins/iCheck/icheck.min.js"></script>
<script src="/static/dist/js/utils/common.js"></script>
<script src="/static/dist/js/pages/register.js"></script>
</body>
</html>
