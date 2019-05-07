package com.opensams.service;

import com.opensams.dal.po.Student;

/**
 * @author Kevin Leung
 */
public interface AuthenticationService {

    /**
     * 通过学号查找用户信息
     * @param studentCode 学号
     * @return {@link Student}
     */
    Student getStudentByCode(String studentCode);

}
