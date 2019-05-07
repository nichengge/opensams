<div class="content-wrapper">
    <section class="content-header">
        <h1>
            发送邮件
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 邮件管理</a></li>
            <li class="active">发送邮件</li>
        </ol>
    </section>
    <section class="content">
        <div class="row">
            <div class="col-md-12">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">撰写邮件</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <div class="form-group">
                            <input class="form-control" placeholder="To:">
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Subject:">
                        </div>
                        <div class="form-group">
                    <textarea id="compose-textarea" class="form-control" style="height: 300px">
                      <!-- mail body -->
                    </textarea>
                        </div>
                        <div class="form-group">
                            <div class="btn btn-default btn-file">
                                <i class="fa fa-paperclip"></i> 附件
                                <input type="file" name="attachment">
                            </div>
                            <p class="help-block">文件限制 32MB</p>
                        </div>
                    </div>
                    <!-- /.box-body -->
                    <div class="box-footer">
                        <div class="pull-right">
                            <button type="button" class="btn btn-default"><i class="fa fa-pencil"></i> 草稿</button>
                            <button type="submit" class="btn btn-primary"><i class="fa fa-envelope-o"></i> 发送</button>
                        </div>
                        <button type="reset" class="btn btn-default"><i class="fa fa-times"></i> 取消</button>
                    </div>
                    <!-- /.box-footer -->
                </div>
            </div>
        </div>
    </section>
</div>