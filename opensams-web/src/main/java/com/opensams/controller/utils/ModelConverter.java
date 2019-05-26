package com.opensams.controller.utils;

import com.opensams.model.dto.*;
import com.opensams.model.vo.*;
import com.opensams.model.vo.request.RegisterRequest;
import com.opensams.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

/**
 * @author Kevin Leung
 */
public class ModelConverter {

    public static RegisterDto registerRequest2Dto(RegisterRequest request) {
        RegisterDto registerDto = new RegisterDto();
        registerDto.setStudentName(request.getStudentName());
        registerDto.setStudentId(request.getStudentId());
        registerDto.setStudentEmail(request.getStudentEmail());
        registerDto.setStudentCollege(request.getStudentCollege());
        registerDto.setStudentAssociation(request.getStudentAssociation());
        registerDto.setStudentPassword(request.getStudentPassword());
        registerDto.setStudentRegisterKey(request.getStudentRegisterKey());
        return registerDto;
    }

    public static ActivityVo convertToActivityVo(ActivityDto activityDto) {
        ActivityVo activityVo = new ActivityVo();

        activityVo.setId(activityDto.getId());
        activityVo.setName(activityDto.getName());
        activityVo.setSpot(activityDto.getSpot());
        activityVo.setAssociation(activityDto.getAssociation());
        activityVo.setStartTime(DateUtils.formatDate(activityDto.getStartTime()));
        activityVo.setEndTime(DateUtils.formatDate(activityDto.getEndTime()));
        activityVo.setNumber(activityDto.getNumber());
        activityVo.setPrincipal(activityDto.getPrincipal());
        activityVo.setTeacher(activityDto.getTeacher());
        activityVo.setDescription(activityDto.getDescription());
        activityVo.setCreatedAt(DateUtils.formatDate(activityDto.getCreatedAt()));
        activityVo.setModifiedAt(DateUtils.formatDate(activityDto.getModifiedAt()));

        return activityVo;
    }

    public static NoticeVo convertToNoticeVo(NoticeDto noticeDto) {
        NoticeVo noticeVo = new NoticeVo();

        noticeVo.setId(noticeDto.getId());
        noticeVo.setTitle(noticeDto.getTitle());
        noticeVo.setContent(noticeDto.getContent());
        noticeVo.setPublishTime(DateUtils.formatDate(noticeDto.getCreatedAt()));
        noticeVo.setPublisher(noticeDto.getPublisher());
        noticeVo.setPublishDept(noticeDto.getPublishDept());

        return noticeVo;
    }

    public static StudentVo convertToStudentVo(StudentDto studentDto) {
        StudentVo studentVo = new StudentVo();
        studentVo.setId(studentDto.getId());
        studentVo.setStudentName(studentDto.getStudentName());
        studentVo.setStudentCode(studentDto.getStudentCode());
        studentVo.setBirthday(DateUtils.formatDate(studentDto.getBirthday()));
        studentVo.setSex(studentDto.getSex());
        studentVo.setMail(studentDto.getMail());
        studentVo.setLocalMail(studentDto.getLocalMail());
        studentVo.setPhone(studentDto.getPhone());
        studentVo.setQq(studentDto.getQq());
        studentVo.setCollege(studentDto.getCollege());
        studentVo.setMajor(studentDto.getMajor());
        studentVo.setAvatar(studentDto.getAvatar());
        studentVo.setLoginName(studentDto.getLoginName());
        studentVo.setLoginPwd(studentDto.getLoginPwd());
        studentVo.setDescription(studentDto.getDescription());
        studentVo.setCreatedAt(DateUtils.formatDate(studentDto.getCreatedAt()));
        studentVo.setModifiedAt(DateUtils.formatDate(studentDto.getModifiedAt()));
        studentVo.setAssociation(StringUtils.join(studentDto.getAssociation(), ','));
        studentVo.setRoleList(StringUtils.join(studentDto.getRoleList(), ','));
        return studentVo;
    }

    public static PermissionVo convertToPermissionVo(PermissionDto permissionDto) {
        PermissionVo permissionVo = new PermissionVo();
        BeanUtils.copyProperties(permissionDto, permissionVo);

        return permissionVo;
    }

    public static RoleVo convertToRoleVo(RoleDto roleDto) {
        RoleVo roleVo = new RoleVo();
        roleVo.setId(roleDto.getId());
        roleVo.setName(roleDto.getRole());
        roleVo.setRoleCode(roleDto.getRoleCode());
        roleVo.setCreatedAt(DateUtils.formatDate(roleDto.getCreatedAt()));
        roleVo.setModifiedAt(DateUtils.formatDate(roleDto.getModifiedAt()));

        return roleVo;
    }

    public static AssociationVo convertToAssociationVo(AssociationDto associationDto) {
        AssociationVo associationVo = new AssociationVo();
        BeanUtils.copyProperties(associationDto, associationVo);
        associationVo.setCreatedAt(DateUtils.formatDate(associationDto.getCreatedAt()));
        associationVo.setModifiedAt(DateUtils.formatDate(associationDto.getModifiedAt()));

        return associationVo;
    }

}
