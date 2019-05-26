package com.opensams.test.service;

import com.google.common.collect.Lists;
import com.opensams.model.dto.RoleDto;
import com.opensams.service.StudentRoleService;
import com.opensams.test.BasicTest;
import org.apache.commons.collections4.MapUtils;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Kevin Leung
 */
public class StudentRoleServiceTest extends BasicTest {

    @Resource
    private StudentRoleService studentRoleService;

    @Test
    public void testBuildStudentRoleRel() {
        List<String> studentCodes = Lists.newArrayList("20154124");
        Map<String, List<RoleDto>> studentRoleRel
                = studentRoleService.buildStudentRoleRel(studentCodes);

        assert MapUtils.isNotEmpty(studentRoleRel);

        System.out.println(studentRoleRel);
    }

}
