package com.opensams.service.impl;

import com.google.common.collect.Lists;
import com.opensams.dal.PermissionDao;
import com.opensams.dal.RoleDao;
import com.opensams.dal.RolePermissionDao;
import com.opensams.dal.StudentRoleDao;
import com.opensams.service.AuthorizationService;
import com.opensams.dal.pojo.Permission;
import com.opensams.dal.pojo.Role;
import com.opensams.dal.pojo.RolePermission;
import com.opensams.dal.pojo.StudentRole;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kevin Leung
 */
@Service("authorizationService")
public class AuthorizationServiceImpl implements AuthorizationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationServiceImpl.class);

    @Resource
    private StudentRoleDao studentRoleDao;

    @Resource
    private RoleDao roleDao;

    @Resource
    private RolePermissionDao rolePermissionDao;

    @Resource
    private PermissionDao permissionDao;

    @Override
    public List<Role> getRolesByStudentCode(String studentCode) {
        List<StudentRole> studentRoleList = studentRoleDao.queryRoleCodesByStudentCode(studentCode);

        if (CollectionUtils.isEmpty(studentRoleList)) {
            LOGGER.debug("The user has no roles, studentCode: {}", studentCode);

            return new ArrayList<>();
        }

        List<String> roleCodes = studentRoleList.stream()
                .map(StudentRole::getRoleCode)
                .collect(Collectors.toList());

        return roleDao.queryRolesByCodes(roleCodes);
    }

    @Override
    public List<Permission> getPermissionsByRoleCode(String roleCode) {
        List<RolePermission> rolePermissions = rolePermissionDao.queryPermissionCodesByRoleCode(roleCode);

        if (CollectionUtils.isEmpty(rolePermissions)) {
            LOGGER.debug("The role has no permission, roleCode: {}", roleCode);

            return new ArrayList<>();
        }

        List<String> permissionCodes = rolePermissions.stream()
                .map(RolePermission::getPermissionCode)
                .collect(Collectors.toList());

        return permissionDao.queryPermissionsByCodes(permissionCodes);
    }

    @Override
    public List<Permission> getPermissionsByRoleCodes(List<String> roleCodes) {
        List<Permission> permissions = Lists.newArrayList();

        for (String roleCode : roleCodes) {
            List<Permission> permissionsPerRole = getPermissionsByRoleCode(roleCode);

            permissions.addAll(permissionsPerRole);
        }

        return permissions;
    }
}
