package com.opensams.test.dal;

import com.google.common.collect.Lists;
import com.opensams.dal.StudentRoleDao;
import com.opensams.dal.po.StudentRole;
import com.opensams.test.BasicTest;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Kevin Leung
 */
public class StudentRoleDaoTest extends BasicTest {

    @Resource
    private StudentRoleDao studentRoleDao;

    @Test
    public void testQueryRoleCodesByStudentCode() {
        List<StudentRole> studentRole = studentRoleDao.queryByStudentCode("20154124");

        studentRole.forEach(System.out::println);
    }

    @Test
    public void testQueryRoleCodesByStudentCodes() {
        List<String> studentCodes = Lists.newArrayList("20154124");
        List<StudentRole> studentRoles = studentRoleDao.queryByStudentCodes(studentCodes);

        assert CollectionUtils.isNotEmpty(studentRoles);
    }

}
