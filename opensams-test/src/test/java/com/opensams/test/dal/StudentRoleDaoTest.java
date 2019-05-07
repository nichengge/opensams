package com.opensams.test.dal;

import com.opensams.dal.StudentRoleDao;
import com.opensams.dal.po.StudentRole;
import com.opensams.test.BasicTest;
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
        List<StudentRole> studentRole = studentRoleDao.queryRoleCodesByStudentCode("20154124");

        studentRole.forEach(System.out::println);
    }

}
