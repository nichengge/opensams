package com.opensams.service;

import com.opensams.model.dto.StudentDto;

import java.util.List;

/**
 * @author Kevin Leung
 */
public interface StudentService {

    /**
     * 分页获取学生信息
     * @param studentDto {@link StudentDto}
     * @return 学生信息列表
     */
    List<StudentDto> getStudentInfos(StudentDto studentDto);

    /**
     * 通过学号获取学生信息
     * @param studentCode 学号
     * @return 学生信息
     */
    StudentDto getStudentByCode(String studentCode);

    /**
     * 通过学号删除学生信息
     * @param studentCode 学号
     */
    void deleteStudentByCode(String studentCode);

    /**
     * 保存学生信息
     * @param studentDto 学生信息
     */
    void saveStudentInfo(StudentDto studentDto);

}
