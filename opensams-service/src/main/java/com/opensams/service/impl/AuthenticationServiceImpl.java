package com.opensams.service.impl;

import com.opensams.dal.StudentDao;
import com.opensams.dal.po.Student;
import com.opensams.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Kevin Leung
 */
@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Resource
    private StudentDao studentDao;

    @Override
    public Student getStudentByCode(String studentCode) {
        Student student = studentDao.queryStudentByLoginName(studentCode);

        if (student == null) {
            LOGGER.debug("Cannot find student info by student code: {}", studentCode);

            return null;
        }

        return student;
    }
}
