package com.opensams.dal;

import com.opensams.dal.pojo.Student;
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

}
