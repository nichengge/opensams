package com.opensams.test.dal;

import com.google.common.collect.Lists;
import com.opensams.dal.RoleDao;
import com.opensams.dal.po.Role;
import com.opensams.test.BasicTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Kevin Leung
 */
public class RoleDaoTest extends BasicTest {

    @Resource
    private RoleDao roleDao;

    @Test
    public void testQueryRolesByCodes() {
        List<Role> roles = roleDao.queryRolesByCodes(Lists.newArrayList("001"));

        roles.forEach(System.out::println);
    }

}
