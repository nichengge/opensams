<#include 'common/header.ftl'>
<#include 'common/sidebar.ftl'>
<#include 'common/footer.ftl'>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>OpenSCMS</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.7 -->
    <link rel="stylesheet" href="/static/bower_components/bootstrap/dist/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="/static/bower_components/font-awesome/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="/static/bower_components/Ionicons/css/ionicons.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="/static/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
    <!-- Pace style -->
    <link rel="stylesheet" href="/static/plugins/pace/pace.min.css">
    <!-- Select2 -->
    <link rel="stylesheet" href="/static/bower_components/select2/dist/css/select2.min.css">
    <!-- daterange picker -->
    <link rel="stylesheet" href="/static/bower_components/bootstrap-daterangepicker/daterangepicker.css">
    <!-- simplePagination -->
    <link rel="stylesheet" href="/static/bower_components/simplePagination/simplePagination.css"/>
    <!-- bootstrap wysihtml5 - text editor -->
    <link rel="stylesheet" href="/static/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/static/plugins/iCheck/all.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="/static/dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="/static/dist/css/skins/_all-skins.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">

    <@header></@header>

    <@sidebar></@sidebar>

    <div class="ajax-content">
    </div>

    <@footer></@footer>

</div>

<!-- jQuery 3 -->
<script src="/static/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="/static/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="/static/bower_components/fastclick/lib/fastclick.js"></script>
<!-- date-range-picker -->
<script src="/static/bower_components/moment/min/moment.min.js"></script>
<script src="/static/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- DataTables -->
<script src="/static/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="/static/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<!-- PACE -->
<script src="/static/bower_components/PACE/pace.min.js"></script>
<!-- Sparkline -->
<script src="/static/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
<!-- SlimScroll -->
<script src="/static/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- Select2 -->
<script src="/static/bower_components/select2/dist/js/select2.full.min.js"></script>
<!-- simplePagination -->
<script src="/static/bower_components/simplePagination/jquery.simplePagination.js"></script>
<!-- iCheck -->
<script src="/static/plugins/iCheck/icheck.min.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="/static/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- AdminLTE App -->
<script src="/static/dist/js/adminlte.min.js"></script>
<!-- index.js -->
<script src="/static/dist/js/pages/index.js"></script>
</body>
</html>