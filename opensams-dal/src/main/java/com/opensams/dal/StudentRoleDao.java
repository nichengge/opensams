package com.opensams.dal;

import com.opensams.dal.po.StudentRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kevin Leung
 */
@Repository
public interface StudentRoleDao {

    /**
     * 查找某用户对应的角色关联关系
     * @param studentCode 用户编码
     * @return 学生角色关联关系
     */
    List<StudentRole> queryByStudentCode(@Param("studentCode") String studentCode);

    /**
     * 批量通过学号查询学生角色关联关系信息
     * @param studentCodes 学号列表
     * @return 学生角色关联关系列表
     */
    List<StudentRole> queryByStudentCodes(List<String> studentCodes);

}
