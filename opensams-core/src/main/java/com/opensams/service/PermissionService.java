package com.opensams.service;

import com.opensams.model.dto.PermissionDto;

import java.util.List;

/**
 * @author Kevin Leung
 */
public interface PermissionService {

    /**
     * 获取所有权限信息
     * @return 权限列表
     */
    List<PermissionDto> getAllPermissions();

}
