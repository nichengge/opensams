<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            成员列表
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 人事管理</a></li>
            <li class="active">成员列表</li>
        </ol>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-md-12">
                <div class="box">
                    <div class="box-header">
                        <div class="box-body">
                            <table id="member-table" class="table table-bordered table-hover">
                                <thead>
                                <tr>
                                    <td> 姓名</td>
                                    <td> 学号</td>
                                    <td> 内部邮件</td>
                                    <td> 学院</td>
                                    <td> 专业</td>
                                    <td> 社团</td>
                                    <td> 角色</td>
                                    <td> 操作</td>
                                </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>

<div class="modal fade" id="myModal" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    成员信息
                </h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="row margin-bottom">
                        <div class="col-md-2 text-center">
                            <label class="control-label">姓名: </label>
                        </div>
                        <div class="col-md-8">
                            <input type="text" name="studentName" class="form-control"/>
                        </div>
                    </div>
                    <div class="row margin-bottom">
                        <div class="col-md-2 text-center">
                            <label class="control-label">学号: </label>
                        </div>
                        <div class="col-md-8">
                            <input type="text" name="studentCode" class="form-control"/>
                        </div>
                    </div>
                    <div class="row margin-bottom">
                        <div class="col-md-2 text-center">
                            <label class="control-label">生日: </label>
                        </div>
                        <div class="col-md-8">
                            <input type="text" name="birthday" class="form-control"/>
                        </div>
                    </div>
                    <div class="row margin-bottom">
                        <div class="col-md-2 text-center">
                            <label class="control-label">性别: </label>
                        </div>
                        <div class="col-md-8" style="padding-top: 7px;">
                            <input type="radio" name="sex" id="maleRadio"/> 男
                            <input type="radio" name="sex" id="femaleRadio"/> 女
                        </div>
                    </div>
                    <div class="row margin-bottom">
                        <div class="col-md-2 text-center">
                            <label class="control-label">邮件</label>
                        </div>
                        <div class="col-md-8">
                            <input type="text" name="mail" class="form-control"/>
                        </div>
                    </div>
                    <div class="row margin-bottom">
                        <div class="col-md-2 text-center">
                            <label class="control-label">内部邮件</label>
                        </div>
                        <div class="col-md-8">
                            <input type="text" name="localMail" class="form-control"/>
                        </div>
                    </div>
                    <div class="row margin-bottom">
                        <div class="col-md-2 text-center">
                            <label class="control-label">联系电话</label>
                        </div>
                        <div class="col-md-8">
                            <input type="text" name="phone" class="form-control"/>
                        </div>
                    </div>
                    <div class="row margin-bottom">
                        <div class="col-md-2 text-center">
                            <label class="control-label">QQ</label>
                        </div>
                        <div class="col-md-8">
                            <input type="text" name="qq" class="form-control"/>
                        </div>
                    </div>
                    <div class="row margin-bottom">
                        <div class="col-md-2 text-center">
                            <label class="control-label">学院</label>
                        </div>
                        <div class="col-md-8">
                            <input type="text" name="college" class="form-control"/>
                        </div>
                    </div>
                    <div class="row margin-bottom">
                        <div class="col-md-2 text-center">
                            <Label class="control-label">专业</Label>
                        </div>
                        <div class="col-md-8">
                            <input type="text" name="major" class="form-control"/>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    提交更改
                </button>
            </div>
        </div>
    </div>
</div>