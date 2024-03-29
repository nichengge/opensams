package com.opensams.dal;

import com.opensams.dal.po.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kevin Leung
 */
@Repository
public interface StudentDao {

    /**
     * 通过登录用户名查找用户
     * @param loginName loginName
     * @return {@link Student}
     */
    Student queryStudentByLoginName(@Param("loginName") String loginName);

    /**
     * 插入一条学生记录
     * @param student {@link Student}
     * @return 影响的行数
     */
    int insertStudent(Student student);

    /**
     * 批量插入学生记录
     * @param studentList 学生集合
     * @return 影响的行数
     */
    int insertStudents(List<Student> studentList);

    /**
     * 通过学号批量查询学生信息
     * @param studentCodes 学号列表
     * @return 学生列表
     */
    List<Student> queryStudentsByCodes(List<String> studentCodes);

    /**
     * 分页查询学生信息
     * @param student {@link Student}
     * @return 学生信息列表
     */
    List<Student> queryStudentsPage(Student student);

    /**
     * 通过学号查询学生信息
     * @param studentCode 学号
     * @return 学生信息
     */
    Student queryStudentByCode(@Param("studentCode") String studentCode);

    /**
     * 通过学号删除学生信息
     * @param studentCode 学号
     * @return 影响的行数
     */
    int deleteStudentByCode(@Param("studentCode") String studentCode);

}
