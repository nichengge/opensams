package com.opensams.service.impl;

import com.google.common.collect.Lists;
import com.opensams.dal.StudentDao;
import com.opensams.dal.po.Student;
import com.opensams.model.dto.AssociationDto;
import com.opensams.model.dto.RoleDto;
import com.opensams.model.dto.StudentDto;
import com.opensams.service.StudentAssociationService;
import com.opensams.service.StudentRoleService;
import com.opensams.service.StudentService;
import com.opensams.service.utils.ModelConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Kevin Leung
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Resource
    private StudentDao studentDao;

    @Resource
    private StudentAssociationService studentAssociationService;

    @Resource
    private StudentRoleService studentRoleService;

    @Override
    public List<StudentDto> getStudentInfos(StudentDto studentDto) {
        LOGGER.debug("class: {}, method: {}", "StudentServiceImpl", "getStudentInfos");

        Student student = ModelConverter.convertToStudentPo(studentDto);
        List<Student> students = studentDao.queryStudentsPage(student);

        if (CollectionUtils.isEmpty(students)) {
            LOGGER.debug("students is empty!");
            return Lists.newArrayList();
        }

        List<String> studentCodes = students.stream()
                .filter(Objects::nonNull)
                .map(Student::getStudentCode)
                .collect(Collectors.toList());

        Map<String, List<RoleDto>> studentRoleRel
                = studentRoleService.buildStudentRoleRel(studentCodes);

        Map<String, List<AssociationDto>> studentAssociationRel
                = studentAssociationService.buildStudentAssociationRel(studentCodes);

        return students.stream()
                .map(s -> {
                    StudentDto sDto = ModelConverter.convertToStudentDto(s);

                    List<RoleDto> roleDtos = studentRoleRel.get(s.getStudentCode());
                    if (CollectionUtils.isNotEmpty(roleDtos)) {
                        sDto.setRoleList(Lists.transform(roleDtos, RoleDto::getRole));
                    }

                    List<AssociationDto> associationDtos = studentAssociationRel.get(s.getStudentCode());
                    if (CollectionUtils.isNotEmpty(associationDtos)) {
                        sDto.setAssociation(Lists.transform(associationDtos, AssociationDto::getName));
                    }

                    return sDto;
                }).collect(Collectors.toList());
    }

    @Override
    public StudentDto getStudentByCode(String studentCode) {
        Student student = studentDao.queryStudentByCode(studentCode);

        return ModelConverter.convertToStudentDto(student);
    }

    @Override
    public void deleteStudentByCode(String studentCode) {
        int affectedRows = studentDao.deleteStudentByCode(studentCode);

        if (affectedRows > 1) {
            LOGGER.warn("Affected rows is more than one.");
        }
    }

    @Override
    public void saveStudentInfo(StudentDto studentDto) {
        LOGGER.debug("class: {}, method: {}", "StudentServiceImpl", "saveStudentInfo");

        Student student = ModelConverter.convertToStudentPo(studentDto);

        int affectedRows = studentDao.insertStudent(student);

        if (affectedRows > 1) {
            LOGGER.warn("Affected rows is more than one.");
        }
    }
}
