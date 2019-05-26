package com.opensams.service;

import com.opensams.model.dto.RoleDto;
import com.opensams.model.dto.StudentRoleDto;

import java.util.List;
import java.util.Map;

/**
 * @author Kevin Leung
 */
public interface StudentRoleService {

    /**
     * 通过学号查询学生角色关联关系
     * @param studentCodes 学号列表
     * @return 学生角色关联关系集合
     */
    List<StudentRoleDto> queryByStudentCodes(List<String> studentCodes);

    /**
     * 构造学生角色关联映射
     * @param studentCodes 学号列表
     * @return 学生角色关联映射
     */
    Map<String, List<RoleDto>> buildStudentRoleRel(List<String> studentCodes);

}
