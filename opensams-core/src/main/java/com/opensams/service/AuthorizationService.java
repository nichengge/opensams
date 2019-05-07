package com.opensams.service;

import com.opensams.dal.pojo.Permission;
import com.opensams.dal.pojo.Role;

import java.util.List;

/**
 * @author Kevin Leung
 */
public interface AuthorizationService {

    /**
     * 获取用户角色信息
     * @param studentCode 学号
     * @return 角色集合
     */
    List<Role> getRolesByStudentCode(String studentCode);

    /**
     * 获取角色权限信息
     * @param roleCode 角色编码
     * @return 权限集合
     */
    List<Permission> getPermissionsByRoleCode(String roleCode);

    /**
     * 批量获取角色权限信息
     * @param roleCodes 角色编码集合
     * @return 权限集合
     */
    List<Permission> getPermissionsByRoleCodes(List<String> roleCodes);

}
