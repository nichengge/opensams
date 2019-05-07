package com.opensams.dal;

import com.opensams.dal.po.RolePermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kevin Leung
 */
@Repository
public interface RolePermissionDao {

    /**
     * 通过角色编码查找权限编码
     * @param roleCode 角色编码
     * @return 权限编码列表
     */
    List<RolePermission> queryPermissionCodesByRoleCode(@Param("roleCode") String roleCode);

}
