package com.opensams.service.utils;

import com.opensams.dal.po.Student;
import com.opensams.service.dto.RegisterDto;

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

}
