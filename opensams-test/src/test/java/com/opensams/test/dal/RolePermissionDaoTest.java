package com.opensams.test.dal;

import com.opensams.dal.RolePermissionDao;
import com.opensams.dal.po.RolePermission;
import com.opensams.test.BasicTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Kevin Leung
 */
public class RolePermissionDaoTest extends BasicTest {

    @Resource
    private RolePermissionDao rolePermissionDao;

    @Test
    public void testQueryPermissionCodesByRoleCode() {
        List<RolePermission> rolePermissions
                = rolePermissionDao.queryPermissionCodesByRoleCode("001");

        rolePermissions.forEach(System.out::println);
    }

}
