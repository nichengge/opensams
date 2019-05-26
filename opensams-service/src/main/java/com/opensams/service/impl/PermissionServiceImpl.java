package com.opensams.service.impl;

import com.google.common.collect.Lists;
import com.opensams.dal.PermissionDao;
import com.opensams.dal.po.Permission;
import com.opensams.model.dto.PermissionDto;
import com.opensams.service.PermissionService;
import com.opensams.service.utils.ModelConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kevin Leung
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionDao permissionDao;

    @Override
    public List<PermissionDto> getAllPermissions() {

        List<Permission> permissions = permissionDao.queryAllPermissions();

        if (CollectionUtils.isEmpty(permissions)) {
            return Lists.newArrayList();
        }

        return permissions.stream()
                .map(ModelConverter::convertToPermissionDto)
                .collect(Collectors.toList());
    }
}
