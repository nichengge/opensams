<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
        <h1>
            成员注册
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 人事管理</a></li>
            <li class="active">成员注册</li>
        </ol>
    </section>

    <section class="content">
        <#--<div class="row">-->
            <#--<div class="col-md-12">-->
                <#--<div class="box">-->
                    <#--<div class="box-header with-border">-->
                        <#--<h2 class="box-title">用户头像</h2>-->
                    <#--</div>-->
                    <#--<div class="box-body">-->
                        <#--<div class="row">-->
                            <#--<div class="col-md-12">-->
                                <#--<img src="/static/dist/img/user6-128x128.jpg"-->
                                     <#--style="vertical-align: middle;border-radius:50%;"-->
                                     <#--alt="user avatar"/>-->
                                <#--<button type="button" class="btn btn-default">上传头像</button>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
        <div class="row">
            <div class="col-md-12">
                <div class="box box-warning">
                    <div class="box-header with-border">
                        <h2 class="box-title">基本信息</h2>
                    </div>
                    <div class="box-body">
                        <div class="row">
                            <div class="col-md-4 form-group">
                                <div class="row">
                                    <div class="col-md-4 text-center"><label for="studentCode">学号: </label></div>
                                    <div class="col-md-8">
                                        <input type="text" name="studentCode" id="studentCode"/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 form-group">
                                <div class="row">
                                    <div class="col-md-4 text-center"><label for="studentName">姓名: </label></div>
                                    <div class="col-md-8">
                                        <input type="text" name="studentName" id="studentName"/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 form-group">
                                <div class="row">
                                    <div class="col-md-4 text-center"><label for="initPwd">初始登录密码: </label></div>
                                    <div class="col-md-8">
                                        <input type="text" name="initPwd" id="initPwd"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 form-group">
                                <div class="row">
                                    <div class="col-md-4 text-center"><label for="birthday">出生日期: </label></div>
                                    <div class="col-md-8">
                                        <input type="text" name="birthday" id="birthday"/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 form-group">
                                <div class="row">
                                    <div class="col-md-4 text-center"><strong>性别: </strong></div>
                                    <div class="col-md-8">
                                        <input type="radio" name="sex" value="male" checked/> 男
                                        <input type="radio" name="sex" value="femail"/> 女
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 form-group">
                                <div class="row">
                                    <div class="col-md-4 text-center"><label for="email">电子邮件: </label></div>
                                    <div class="col-md-8">
                                        <input type="email" name="email" id="email"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 form-group">
                                <div class="row">
                                    <div class="col-md-4 text-center"><label for="phone">联系电话: </label></div>
                                    <div class="col-md-8">
                                        <input type="text" name="phone" id="phone">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 form-group">
                                <div class="row">
                                    <div class="col-md-4 text-center"><label for="qq">QQ: </label></div>
                                    <div class="col-md-8">
                                        <input type="text" name="qq" id="qq">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 form-group">
                                <div class="row">
                                    <div class="col-md-4 text-center"><label for="college">学院: </label></div>
                                    <div class="col-md-8">
                                        <input type="text" name="college" id="college">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-4 form-group">
                                <div class="row">
                                    <div class="col-md-4 text-center"><label for="major">专业: </label></div>
                                    <div class="col-md-8">
                                        <input type="text" name="major" id="major">
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 form-group">
                                <div class="row">
                                    <div class="col-md-4 text-center"><label for="localMail">内部邮件: </label></div>
                                    <div class="col-md-8">
                                        <input type="text" name="localMail" id="localMail">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-md-4">
                                <div class="row">
                                    <div class="col-md-4 text-center"><label for="description">个人简介: </label></div>
                                    <div class="col-md-8">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <textarea name="description" id="description" cols="100"
                                                          rows="10"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="box box-success">
                    <div class="box-header with-border">
                        <h2 class="box-title">社团与角色信息</h2>
                    </div>
                    <div class="box-body">
                        <div class="row">
                            <div class="col-md-6">
                                <div class="row form-group">
                                    <#--<div class="col-md-4 text-center"><label for="association" class="control-label">社团: </label></div>-->
                                    <div class="col-md-8">
                                        <label class="control-label">社团: </label>
                                        <select name="association" id="association" class="select2 form-control">
                                            <#if associations??>
                                                <#list associations as association>
                                                    <option value="${association.id}">${association.name}</option>
                                                </#list>
                                            </#if>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="row form-group">
                                    <#--<div class="col-md-4 text-center"><label for="role" class="control-label">角色: </label></div>-->
                                    <div class="col-md-8">
                                        <label class="control-label">角色: </label>
                                        <select name="role" id="role" class="select2 form-control">
                                            <#if roleList??>
                                                <#list roleList as role>
                                                    <option value="${role.roleCode}">${role.name}</option>
                                                </#list>
                                            </#if>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <#--<div class="row">-->
            <#--<div class="col-md-12">-->
                <#--<div class="box box-info">-->
                    <#--<div class="box-header with-border">-->
                        <#--<h2 class="box-title">权限分配</h2>-->
                    <#--</div>-->
                    <#--<div class="box-body">-->
                        <#--<div class="row">-->
                            <#--<div class="col-md-12 form-group">-->
                                <#--<label>页面权限: </label>-->
                                <#--<div class="row">-->
                                    <#--<div class="col-md-6">-->
                                        <#--<select class="form-control select2" multiple="multiple"-->
                                                <#--data-placeholder="包含页面权限"-->
                                                <#--style="width: 100%;">-->
                                            <#--<option>成员列表</option>-->
                                            <#--<option>成员注册</option>-->
                                            <#--<option>权限分配</option>-->
                                            <#--<option>成员分配</option>-->
                                            <#--<option>社团列表</option>-->
                                            <#--<option>社团活动信息</option>-->
                                            <#--<option>社团注册审核</option>-->
                                        <#--</select>-->
                                    <#--</div>-->
                                    <#--<div class="col-md-6 from-group">-->
                                        <#--<select class="form-control select2" multiple="multiple"-->
                                                <#--data-placeholder="排除页面权限"-->
                                                <#--style="width: 100%;">-->
                                            <#--<option>成员列表</option>-->
                                            <#--<option>成员注册</option>-->
                                            <#--<option>权限分配</option>-->
                                            <#--<option>成员分配</option>-->
                                            <#--<option>社团列表</option>-->
                                            <#--<option>社团活动信息</option>-->
                                            <#--<option>社团注册审核</option>-->
                                        <#--</select>-->
                                    <#--</div>-->
                                <#--</div>-->
                            <#--</div>-->
                        <#--</div>-->
                        <#--<div class="row">-->
                            <#--<div class="col-md-12 form-group">-->
                                <#--<label>功能权限: </label>-->
                                <#--<div class="row">-->
                                    <#--<div class="col-md-6">-->
                                        <#--<select class="form-control select2" multiple="multiple"-->
                                                <#--data-placeholder="包含功能权限"-->
                                                <#--style="width: 100%;">-->
                                            <#--<option>Alabama</option>-->
                                            <#--<option>Alaska</option>-->
                                            <#--<option>California</option>-->
                                            <#--<option>Delaware</option>-->
                                            <#--<option>Tennessee</option>-->
                                            <#--<option>Texas</option>-->
                                            <#--<option>washington</option>-->
                                        <#--</select>-->
                                    <#--</div>-->
                                    <#--<div class="col-md-6">-->
                                        <#--<select class="form-control select2" multiple="multiple"-->
                                                <#--data-placeholder="排除功能权限"-->
                                                <#--style="width: 100%;">-->
                                            <#--<option>Alabama</option>-->
                                            <#--<option>Alaska</option>-->
                                            <#--<option>California</option>-->
                                            <#--<option>Delaware</option>-->
                                            <#--<option>Tennessee</option>-->
                                            <#--<option>Texas</option>-->
                                            <#--<option>washington</option>-->
                                        <#--</select>-->
                                    <#--</div>-->
                                <#--</div>-->
                            <#--</div>-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->
        <div class="row">
            <div class="col-md-12 text-center">
                <button class="btn btn-primary" id="submitStudentInfoBtn">提交</button>
            </div>
        </div>
    </section>
</div>