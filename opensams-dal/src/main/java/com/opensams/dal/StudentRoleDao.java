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
     * 查找某用户对应的角色号
     * @param studentCode 用户编码
     * @return 角色号列表
     */
    List<StudentRole> queryRoleCodesByStudentCode(@Param("studentCode") String studentCode);

}
