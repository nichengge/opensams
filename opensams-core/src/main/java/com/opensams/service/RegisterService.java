package com.opensams.service;

import com.opensams.model.dto.RegisterDto;

/**
 * @author Kevin Leung
 */
public interface RegisterService {

    /**
     * 成员注册服务
     * @param registerDto {@link RegisterDto}
     */
    void register(RegisterDto registerDto);

}
