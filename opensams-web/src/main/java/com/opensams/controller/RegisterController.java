package com.opensams.controller;

import com.opensams.utils.ModelConverter;
import com.opensams.model.vo.request.RegisterRequest;
import com.opensams.model.vo.response.BasicResponse;
import com.opensams.service.RegisterService;
import com.opensams.model.dto.RegisterDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Kevin Leung
 */
@RestController
public class RegisterController {

    @Resource
    private RegisterService registerService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public BasicResponse register(RegisterRequest request) {
        RegisterDto registerDto = ModelConverter.registerRequest2Dto(request);
        registerService.register(registerDto);

        BasicResponse response = new BasicResponse();
        response.setCode("200");
        response.setMessgae("注册成功");
        return response;
    }

}
