package com.opensams.test.service;

import com.google.common.collect.Lists;
import com.opensams.model.dto.AssociationDto;
import com.opensams.service.StudentAssociationService;
import com.opensams.test.BasicTest;
import org.apache.commons.collections4.MapUtils;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Kevin Leung
 */
public class StudentAssociationServiceTest extends BasicTest {

    @Resource
    private StudentAssociationService studentAssociationService;

    @Test
    public void testBuildStudentAssociationRel() {
        List<String> studentCodes = Lists.newArrayList("20154124");
        Map<String, List<AssociationDto>> studentAssociationRel
                = studentAssociationService.buildStudentAssociationRel(studentCodes);

        assert MapUtils.isNotEmpty(studentAssociationRel);

        System.out.println(studentAssociationRel);
    }

}
