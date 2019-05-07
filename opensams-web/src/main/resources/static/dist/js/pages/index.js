// To make Pace works on Ajax calls
$(document).ajaxStart(function () {
    Pace.restart()
});

function loadPageContent(url, callback) {
    $.ajax({
        url: url,
        method: 'get',
        dataType: 'html',
        success: function (content) {
            if (content) {
                $('.ajax-content').html(content);

                if (callback) {
                    callback();
                }

                $('body').layout('fix');
            }
        }
    });
}

// 首页
$('.dashboard-page').on('click', function () {
    loadPageContent('/dashboard')
});

// 成员列表
$('.member-list').on('click', function() {
    loadPageContent('/personnel/member-list', function() {
        $('#member-table').DataTable({
            ordering: false,
            autoRefresh: true
        });
    });
});

// 成员注册
$('.member-register').on('click', function() {
    loadPageContent('/personnel/member-register', function() {
        $('.select2').select2();
    });
});

// 社团列表
$('.association-list').on('click', function() {
    loadPageContent('/association/association-list', function() {
        $('#association-table').DataTable({
            ordering: false
        });
    });
});

// 社团活动
$('.association-activities').on('click', function() {
    loadPageContent('/association/association-activities');
});

// 社团申请
$('.association-apply').on('click', function() {
    loadPageContent("/association/association-apply");
});

// 社团活动申请
$('.activities-apply').on('click', function() {
    loadPageContent('/association/activities-apply', function() {
        $('.select2').select2();
        $('#reservation').daterangepicker();
    });
});

// 收件箱
$('.mail-inbox').on('click', function() {
    loadPageContent('/mail/mail-inbox', function() {
        $('.mailbox-messages input[type="checkbox"]').iCheck({
            checkboxClass: 'icheckbox_flat-blue',
            radioClass: 'iradio_flat-blue'
        });
        $(".checkbox-toggle").click(function () {
            var clicks = $(this).data('clicks');
            if (clicks) {
                //Uncheck all checkboxes
                $(".mailbox-messages input[type='checkbox']").iCheck("uncheck");
                $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
            } else {
                //Check all checkboxes
                $(".mailbox-messages input[type='checkbox']").iCheck("check");
                $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
            }
            $(this).data("clicks", !clicks);
        });
    });
});

// 发送邮件
$('.mail-compose').on('click', function() {
    loadPageContent('mail/mail-compose', function() {
        $("#compose-textarea").wysihtml5();
    });
});

// 已发送
$('.mail-sent').on('click', function() {
    loadPageContent('mail/mail-sent', function() {
        $('.mailbox-messages input[type="checkbox"]').iCheck({
            checkboxClass: 'icheckbox_flat-blue',
            radioClass: 'iradio_flat-blue'
        });
        $(".checkbox-toggle").click(function () {
            var clicks = $(this).data('clicks');
            if (clicks) {
                //Uncheck all checkboxes
                $(".mailbox-messages input[type='checkbox']").iCheck("uncheck");
                $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
            } else {
                //Check all checkboxes
                $(".mailbox-messages input[type='checkbox']").iCheck("check");
                $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
            }
            $(this).data("clicks", !clicks);
        });
    });
});

// 草稿箱
$('.mail-draft').on('click', function() {
    loadPageContent('mail/mail-draft', function() {
        $('.mailbox-messages input[type="checkbox"]').iCheck({
            checkboxClass: 'icheckbox_flat-blue',
            radioClass: 'iradio_flat-blue'
        });
        $(".checkbox-toggle").click(function () {
            var clicks = $(this).data('clicks');
            if (clicks) {
                //Uncheck all checkboxes
                $(".mailbox-messages input[type='checkbox']").iCheck("uncheck");
                $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
            } else {
                //Check all checkboxes
                $(".mailbox-messages input[type='checkbox']").iCheck("check");
                $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
            }
            $(this).data("clicks", !clicks);
        });
    });
});

// 回收站
$('.mail-trash').on('click', function() {
    loadPageContent('mail/mail-trash', function() {
        $('.mailbox-messages input[type="checkbox"]').iCheck({
            checkboxClass: 'icheckbox_flat-blue',
            radioClass: 'iradio_flat-blue'
        });
        $(".checkbox-toggle").click(function () {
            var clicks = $(this).data('clicks');
            if (clicks) {
                //Uncheck all checkboxes
                $(".mailbox-messages input[type='checkbox']").iCheck("uncheck");
                $(".fa", this).removeClass("fa-check-square-o").addClass('fa-square-o');
            } else {
                //Check all checkboxes
                $(".mailbox-messages input[type='checkbox']").iCheck("check");
                $(".fa", this).removeClass("fa-square-o").addClass('fa-check-square-o');
            }
            $(this).data("clicks", !clicks);
        });
    });
});

// 阅读邮件
$('.mail-read').on('click', function() {
    loadPageContent('mail/mail-read');
});

// 公告列表
$('.notice-list').on('click', function() {
    loadPageContent('notice/notice-list');
});

// 公告推送
$('.notice-publish').on('click', function() {
    loadPageContent('notice/notice-publish', function() {
        $("#compose-textarea").wysihtml5();
        $('.select2').select2();
    });
});

// 审批中心
$('.approval-center').on('click', function() {
    loadPageContent('approval/approval-center', function() {
        $('.select2').select2();

        $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
            checkboxClass: 'icheckbox_flat-green',
            radioClass: 'iradio_flat-green'
        });

        $('#reservation').daterangepicker();
    });
});

// 个人信息
$('.profile-page').on('click', function() {
    loadPageContent('profile/profile', function() {
        $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
            checkboxClass: 'icheckbox_flat-blue',
            radioClass: 'iradio_flat-blue'
        });
    });
});
