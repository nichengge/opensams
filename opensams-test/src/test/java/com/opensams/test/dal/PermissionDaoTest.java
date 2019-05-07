package com.opensams.test.dal;

import com.google.common.collect.Lists;
import com.opensams.dal.PermissionDao;
import com.opensams.dal.po.Permission;
import com.opensams.test.BasicTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Kevin Leung
 */
public class PermissionDaoTest extends BasicTest {

    @Resource
    private PermissionDao permissionDao;

    @Test
    public void testQueryPermissionsByRoleCodes() {
        List<Permission> permissionList = permissionDao.queryPermissionsByCodes(Lists.newArrayList("001", "002"));

        permissionList.forEach(System.out::println);
    }

}
