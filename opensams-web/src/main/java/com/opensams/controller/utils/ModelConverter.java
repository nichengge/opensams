package com.opensams.controller.utils;

import com.opensams.model.vo.request.RegisterRequest;
import com.opensams.service.model.dto.RegisterDto;

/**
 * @author Kevin Leung
 */
public class ModelConverter {

    public static RegisterDto registerRequest2Dto(RegisterRequest request) {
        RegisterDto registerDto = new RegisterDto();
        registerDto.setStudentName(request.getStudentName());
        registerDto.setStudentId(request.getStudentId());
        registerDto.setStudentEmail(request.getStudentEmail());
        registerDto.setStudentCollege(request.getStudentCollege());
        registerDto.setStudentAssociation(request.getStudentAssociation());
        registerDto.setStudentPassword(request.getStudentPassword());
        registerDto.setStudentRegisterKey(request.getStudentRegisterKey());
        return registerDto;
    }

}
