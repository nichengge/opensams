<#macro sidebar>
    <aside class="main-sidebar">
        <section class="sidebar">
            <!-- 侧边栏用户头像 -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="${userAvatar!"/static/dist/img/user-avatar.jpg"}" class="img-circle" alt="User Image">
                </div>
                <div class="text-center info">
                    <p>Kevin Leung</p>
                </div>
            </div>
            <!-- / 侧边栏用户头像 -->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="header">主菜单</li>
                <li>
                    <a href="javascript:" class="dashboard-page"><i class="fa fa-dashboard"></i> <span>首页</span></a>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </li>
                <!-- 人事管理 -->
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-files-o"></i>
                        <span>人事管理</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="javascript:" class="member-list"><i class="fa fa-circle-o"></i> 成员列表</a></li>
                        <li><a href="javascript:" class="member-register"><i class="fa fa-circle-o"></i> 成员注册</a></li>
                    </ul>
                </li>
                <!-- /人事管理 -->
                <!-- 社团管理 -->
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-pie-chart"></i>
                        <span>社团管理</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="javascript:" class="association-list"><i class="fa fa-circle-o"></i> 社团列表</a></li>
                        <li><a href="javascript:" class="association-activities"><i class="fa fa-circle-o"></i> 社团活动信息</a></li>
                        <li><a href="javascript:" class="association-apply"><i class="fa fa-circle-o"></i> 社团申请</a></li>
                        <li><a href="javascript:" class="activities-apply"><i class="fa fa-circle-o"></i> 社团活动申请</a>
                        </li>
                    </ul>
                </li>
                <!-- /社团管理 -->
                <!-- 邮件管理 -->
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-edit"></i> <span>邮件管理</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="javascript:" class="mail-inbox"><i class="fa fa-circle-o"></i> 收件箱</a></li>
                        <li><a href="javascript:" class="mail-compose"><i class="fa fa-circle-o"></i> 发送邮件</a></li>
                        <li><a href="javascript:" class="mail-sent"><i class="fa fa-circle-o"></i> 已发送</a></li>
                        <li><a href="javascript:" class="mail-draft"><i class="fa fa-circle-o"></i> 草稿</a></li>
                        <li><a href="javascript:" class="mail-trash"><i class="fa fa-circle-o"></i> 回收站</a></li>
                    </ul>
                </li>
                <!-- /邮件管理 -->
                <!-- 公告管理 -->
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-table"></i> <span>公告管理</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="javascript:" class="notice-list"><i class="fa fa-circle-o"></i> 公告列表</a></li>
                        <li><a href="javascript:" class="notice-publish"><i class="fa fa-circle-o"></i> 推送公告</a></li>
                    </ul>
                </li>
                <!-- /公告管理 -->
                <!-- 资产管理 -->
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-table"></i> <span>资产管理</span>
                        <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="javascript:" class="asset-list"><i class="fa fa-circle-o"></i> 资产列表</a></li>
                        <li><a href="javascript:" class="asset-apply"><i class="fa fa-circle-o"></i> 资产申请</a></li>
                    </ul>
                </li>
                <!-- /资产管理 -->
                <!-- 审批中心 -->
                <li>
                    <a href="javascript:" class="approval-center"><i class="fa fa-dashboard"></i> <span>审批中心</span></a>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </li>
                <!-- /审批中心 -->
            </ul>
        </section>
    </aside>
</#macro>