package com.opensams.service.impl;

import com.google.common.collect.Lists;
import com.opensams.dal.RoleDao;
import com.opensams.dal.po.Role;
import com.opensams.model.dto.RoleDto;
import com.opensams.service.RoleService;
import com.opensams.service.utils.ModelConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kevin Leung
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Resource
    private RoleDao roleDao;

    @Override
    public List<RoleDto> queryRolesByCodes(List<String> roleCodes) {
        LOGGER.debug("class: {}, method: {}", "RoleServiceImpl", "queryRolesByCodes");

        List<Role> roles = roleDao.queryRolesByCodes(roleCodes);

        if (CollectionUtils.isEmpty(roles)) {
            LOGGER.debug("roles is empty!");
            return Lists.newArrayList();
        }

        return roles.stream()
                .map(ModelConverter::convertToRoleDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RoleDto> getAssociationRoles() {
        LOGGER.debug("class: {}, method: {}", "RoleServiceImpl", "getAssociationRoles");

        List<String> associationRoleCodes = Lists.newArrayList("R_002", "R_003");

        List<Role> roleDtos = roleDao.queryRolesByCodes(associationRoleCodes);

        if (CollectionUtils.isEmpty(roleDtos)) {
            LOGGER.debug("associationRoleCodes is empty!");
            return Lists.newArrayList();
        }

        return roleDtos.stream()
                .map(ModelConverter::convertToRoleDto)
                .collect(Collectors.toList());
    }
}
