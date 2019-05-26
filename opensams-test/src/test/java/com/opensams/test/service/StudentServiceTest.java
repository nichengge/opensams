package com.opensams.test.service;

import com.opensams.model.dto.StudentDto;
import com.opensams.service.StudentService;
import com.opensams.test.BasicTest;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kevin Leung
 */
public class StudentServiceTest extends BasicTest {

    @Resource
    private StudentService studentService;

    @Test
    public void testGetStudentInfos() {
        StudentDto studentDto = new StudentDto();
        studentDto.setStart(0);
        studentDto.setOffset(10);
        List<StudentDto> studentDtoList = studentService.getStudentInfos(studentDto);

        assert CollectionUtils.isNotEmpty(studentDtoList);

        System.out.println(studentDtoList);
    }

}
