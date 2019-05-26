package com.opensams.controller;

import com.google.common.collect.Lists;
import com.opensams.controller.utils.ModelConverter;
import com.opensams.model.dto.StudentDto;
import com.opensams.model.vo.StudentVo;
import com.opensams.model.vo.request.StudentSubRequest;
import com.opensams.model.vo.response.BasicResponse;
import com.opensams.model.vo.response.HttpCodeEnum;
import com.opensams.service.StudentService;
import com.opensams.utils.DateUtils;
import com.opensams.utils.SexUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Kevin Leung
 */
@RestController
@RequestMapping("/personnel")
public class StudentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Resource
    private StudentService studentService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<StudentVo> showStudentList(int start, int offset) {
        LOGGER.debug("class: {}, method: {}", "StudentController", "showStudentList");

        StudentDto studentDto = new StudentDto();
        studentDto.setStart(start);
        studentDto.setOffset(offset);

        List<StudentDto> studentDtos = studentService.getStudentInfos(studentDto);

        return studentDtos.stream()
                .filter(Objects::nonNull)
                .map(ModelConverter::convertToStudentVo)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "getStudentByCode", method = RequestMethod.GET)
    public StudentVo getStudentByCode(String studentCode) {
        LOGGER.debug("class: {}, method: {}", "StudentController", "getStudentByCode");

        StudentDto studentDto = studentService.getStudentByCode(studentCode);

        return ModelConverter.convertToStudentVo(studentDto);

    }

    @RequestMapping(value = "deleteStudentByCode", method = RequestMethod.POST)
    public BasicResponse deleteStudentByCode(String studentCode) {
        LOGGER.debug("class: {}, method: {}", "StudentController", "deleteStudentByCode");

        BasicResponse response = new BasicResponse();

        try {

            studentService.deleteStudentByCode(studentCode);

        } catch (Throwable e) {
            LOGGER.error("Error in deleting student, studentCode: {}, message: {}", studentCode, e.getMessage());

            response.setCode(HttpCodeEnum.ERROR.getStatusCode());
            response.setMessgae("Error in deleting student.");

            return response;
        }

        response.setCode(HttpCodeEnum.SUCCESS.getStatusCode());
        response.setMessgae("success");

        return response;
    }

    @RequestMapping(value = "submitStudentInfo", method = RequestMethod.POST)
    public BasicResponse submitStudentInfo(StudentSubRequest request) {
        LOGGER.debug("class: {}, method: {}", "StudentController", "submitStudentInfo");

        BasicResponse response = new BasicResponse();

        StudentDto studentDto = this.transformStudentSubRequest(request);

        try {
            studentService.saveStudentInfo(studentDto);

            response.setCode(HttpCodeEnum.SUCCESS.getStatusCode());
            response.setMessgae("success");

            return response;
        } catch (Throwable e) {
            LOGGER.error("Error in saving student, message: {}", e.getMessage());

            response.setCode(HttpCodeEnum.ERROR.getStatusCode());
            response.setMessgae("Error in saving student.");

            return response;
        }
    }

    private StudentDto transformStudentSubRequest(StudentSubRequest request) {
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentName(request.getStudentName());
        studentDto.setStudentCode(request.getStudentCode());
        studentDto.setBirthday(DateUtils.parseDate(request.getBirthday()));
        studentDto.setSex(SexUtils.transformToDbExp(request.getSex()));
        studentDto.setMail(request.getMail());
        studentDto.setLocalMail(request.getLocalMail());
        studentDto.setPhone(request.getPhone());
        studentDto.setQq(request.getQq());
        studentDto.setCollege(request.getCollege());
        studentDto.setMajor(request.getMajor());
        studentDto.setLoginName(request.getStudentCode());
        studentDto.setLoginPwd(request.getLoginPwd());
        studentDto.setDescription(request.getDescription());
        studentDto.setRoleCodeList(Lists.newArrayList(request.getRoleCode()));
        studentDto.setAssociationIdList(Lists.newArrayList(request.getAssociationId()));

        return studentDto;
    }

}
