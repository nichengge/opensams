package com.opensams.dal;

import com.opensams.dal.po.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kevin Leung
 */
@Repository
public interface PermissionDao {

    /**
     * 通过角色编码批量查找权限
     * @param permissionCodes 权限编码列表
     * @return 权限列表
     */
    List<Permission> queryPermissionsByCodes(@Param("permissionCodes") List<String> permissionCodes);

    /**
     * 查询所有权限信息
     * @return 权限列表
     */
    List<Permission> queryAllPermissions();

}
