<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            首页
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
        </ol>
    </section>

    <!-- content -->
    <section class="content">

        <div class="row">
            <div class="col-md-12">
                <div class="box">
                    <div class="box-header with-border">
                        <h2 class="box-title">社团动态</h2>
                    </div>
                    <div class="box-body">
                        <div class="row">
                            <div class="col-md-6">
                                <ul>
                                    <#if activities1??>
                                        <#list activities1 as activity>
                                            <li><a href="#">[${activity.association}] ${activity.name}</a></li>
                                        </#list>
                                    </#if>
                                </ul>
                            </div>
                            <div class="col-md-6">
                                <ul>
                                    <#if activities2??>
                                        <#list activities2 as activity>
                                            <li><a href="#">[${activity.association}] ${activity.name} </a></li>
                                        </#list>
                                    </#if>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="box">
                    <div class="box-header with-border">
                        <h2 class="box-title">公告栏</h2>
                    </div>
                    <div class="box-body">
                        <div class="row">
                            <div class="col-md-12">
                                <#if notice??>
                                    <!-- 公告栏 -->
                                    <div class="box box-warning">
                                        <div class="box-header with-border">
                                            <div class="box-title"><span id="notice-title">${notice.title}</span></div>
                                        </div>
                                        <div class="box-body">
                                            <div class="row">
                                                <div class="col-md-12">
                                                    <p id="notice-content">
                                                        ${notice.content}
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="box-footer">
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <small>
                                                        <span id="publisher">${notice.publisher}</span>
                                                        <span id="publish-time">${notice.publishTime}</span>
                                                    </small>
                                                </div>
                                                <div class="col-md-6">
                                                    <small>
                                                        <span id="publish-dept" class="pull-right">${notice.publishDept}</span>
                                                    </small>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- /公告栏 -->
                                </#if>
                            </div>
                        </div>
                        <#if notice??>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="pull-right" id="notice-page"></div>
                                </div>
                            </div>
                        </#if>
                    </div>
                </div>
            </div>
        </div>

    </section>
    <!-- /.content -->
</div>
