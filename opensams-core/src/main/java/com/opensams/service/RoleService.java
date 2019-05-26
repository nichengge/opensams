package com.opensams.service;

import com.opensams.model.dto.RoleDto;

import java.util.List;

/**
 * @author Kevin Leung
 */
public interface RoleService {

    /**
     * 通过角色编码查询角色信息
     * @param roleCodes 角色编码列表
     * @return 角色信息列表
     */
    List<RoleDto> queryRolesByCodes(List<String> roleCodes);

    /**
     * 获取社团相关的角色信息
     * @return 角色信息
     */
    List<RoleDto> getAssociationRoles();

}
