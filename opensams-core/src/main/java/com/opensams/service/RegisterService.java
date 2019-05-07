package com.opensams.service;

import com.opensams.service.dto.RegisterDto;

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
