package com.opensams.service.utils;

import com.opensams.dal.po.*;
import com.opensams.model.dto.*;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @author Kevin Leung
 */
public class ModelConverter {

    public static Student registerDto2Student(RegisterDto registerDto) {
        Student student = new Student();
        student.setStudentName(registerDto.getStudentName());
        student.setStudentCode(registerDto.getStudentId());
        student.setCollege(registerDto.getStudentCollege());
        student.setMail(registerDto.getStudentEmail());
        student.setLoginName(registerDto.getStudentId());
        student.setLoginPwd(registerDto.getStudentPassword());
        student.setCreatedAt(new Date());
        student.setModifiedAt(new Date());
        return student;
    }

    public static Student convertToStudentPo(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setStudentName(studentDto.getStudentName());
        student.setStudentCode(studentDto.getStudentCode());
        student.setBirthday(studentDto.getBirthday());
        student.setSex(studentDto.getSex());
        student.setMail(studentDto.getMail());
        student.setLocalMail(studentDto.getLocalMail());
        student.setPhone(studentDto.getPhone());
        student.setQq(studentDto.getQq());
        student.setCollege(studentDto.getCollege());
        student.setMajor(studentDto.getMajor());
        student.setAvatar(studentDto.getAvatar());
        student.setLoginName(studentDto.getLoginName());
        student.setLoginPwd(studentDto.getLoginPwd());
        student.setDescription(studentDto.getDescription());
        student.setCreatedAt(studentDto.getCreatedAt());
        student.setModifiedAt(studentDto.getModifiedAt());
        student.setStart(studentDto.getStart());
        student.setOffset(studentDto.getOffset());
        return student;
    }

    public static StudentDto convertToStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setStudentName(student.getStudentName());
        studentDto.setStudentCode(student.getStudentCode());
        studentDto.setBirthday(student.getBirthday());
        studentDto.setSex(student.getSex());
        studentDto.setMail(student.getMail());
        studentDto.setLocalMail(student.getLocalMail());
        studentDto.setPhone(student.getPhone());
        studentDto.setQq(student.getQq());
        studentDto.setCollege(student.getCollege());
        studentDto.setMajor(student.getMajor());
        studentDto.setAvatar(student.getAvatar());
        studentDto.setLoginName(student.getLoginName());
        studentDto.setLoginPwd(student.getLoginPwd());
        studentDto.setDescription(student.getDescription());
        studentDto.setCreatedAt(student.getCreatedAt());
        studentDto.setModifiedAt(student.getModifiedAt());
        studentDto.setStart(student.getStart());
        studentDto.setOffset(student.getOffset());
        return studentDto;
    }

    public static AssociationDto convertToAssociationDto(Association association) {
        AssociationDto associationDto = new AssociationDto();
        BeanUtils.copyProperties(association, associationDto);

        return associationDto;
    }

    public static StudentAssociationDto convertToStudentAssociationDto(StudentAssociation studentAssociation) {
        StudentAssociationDto studentAssociationDto = new StudentAssociationDto();
        BeanUtils.copyProperties(studentAssociation, studentAssociationDto);

        return studentAssociationDto;
    }

    public static StudentRoleDto convertToStudentRoleDto(StudentRole studentRole) {
        StudentRoleDto studentRoleDto = new StudentRoleDto();
        BeanUtils.copyProperties(studentRole, studentRoleDto);

        return studentRoleDto;
    }

    public static RoleDto convertToRoleDto(Role role) {
        RoleDto roleDto = new RoleDto();
        BeanUtils.copyProperties(role, roleDto);

        return roleDto;
    }

    public static PermissionDto convertToPermissionDto(Permission permission) {
        PermissionDto permissionDto = new PermissionDto();
        BeanUtils.copyProperties(permission, permissionDto);

        return permissionDto;
    }

}
