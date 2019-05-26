package com.opensams.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.opensams.dal.RoleDao;
import com.opensams.dal.StudentRoleDao;
import com.opensams.dal.po.Role;
import com.opensams.dal.po.StudentRole;
import com.opensams.model.dto.RoleDto;
import com.opensams.model.dto.StudentRoleDto;
import com.opensams.service.StudentRoleService;
import com.opensams.service.utils.ModelConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Kevin Leung
 */
@Service("studentRoleService")
public class StudentRoleServiceImpl implements StudentRoleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentRoleServiceImpl.class);

    @Resource
    private StudentRoleDao studentRoleDao;

    @Resource
    private RoleDao roleDao;

    @Override
    public List<StudentRoleDto> queryByStudentCodes(List<String> studentCodes) {
        LOGGER.debug("class: {}, method: {}", "StudentRoleServiceImpl", "queryByRoleCodes");

        List<StudentRole> studentRoles = studentRoleDao.queryByStudentCodes(studentCodes);

        if (CollectionUtils.isEmpty(studentRoles)) {
            LOGGER.debug("studentRoles is empty!");
            return Lists.newArrayList();
        }

        return studentRoles.stream()
                .map(ModelConverter::convertToStudentRoleDto)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<RoleDto>> buildStudentRoleRel(List<String> studentCodes) {
        LOGGER.debug("class: {}, method: {}", "StudentRoleServiceImpl", "buildStudentRoleRel");

        Map<String, List<RoleDto>> studentRoleRel = Maps.newHashMap();

        List<StudentRole> studentRoles = studentRoleDao.queryByStudentCodes(studentCodes);

        if (CollectionUtils.isEmpty(studentRoles)) {
            LOGGER.debug("studentRoles is empty!");
            return studentRoleRel;
        }

        Map<String, List<StudentRole>> studentRoleMap = studentRoles.stream()
                .collect(Collectors.groupingBy(StudentRole::getStudentCode));

        List<String> roleCodes = studentRoles.stream()
                .map(StudentRole::getRoleCode)
                .collect(Collectors.toList());

        List<Role> roles = roleDao.queryRolesByCodes(roleCodes);

        Map<String, Role> roleMap = roles.stream()
                .collect(Collectors.toMap(Role::getRoleCode, r -> r, (k1, k2) -> k1));

        for (Map.Entry<String, List<StudentRole>> entry : studentRoleMap.entrySet()) {
            String studentCode = entry.getKey();
            List<StudentRole> studentRoleListForTheStudent = entry.getValue();

            Set<String> roleCodeSetForTheStudent = studentRoleListForTheStudent.stream()
                    .map(StudentRole::getRoleCode)
                    .collect(Collectors.toSet());

            List<RoleDto> roleDtos = Lists.newArrayList();
            for (String roleCode : roleCodeSetForTheStudent) {
                Role role = roleMap.get(roleCode);
                RoleDto roleDto = ModelConverter.convertToRoleDto(role);

                roleDtos.add(roleDto);
            }

            studentRoleRel.put(studentCode, roleDtos);
        }

        return studentRoleRel;
    }
}
