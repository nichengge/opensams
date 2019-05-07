package com.opensams.dal;

import com.opensams.dal.po.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kevin Leung
 */
@Repository
public interface RoleDao {

    /**
     * 通过角色编码批量查找角色对象
     * @param roleCodes 角色编码列表
     * @return 角色对象列表
     */
    List<Role> queryRolesByCodes(@Param("roleCodes") List<String> roleCodes);

}
