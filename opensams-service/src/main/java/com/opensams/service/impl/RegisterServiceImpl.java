package com.opensams.service.impl;

import com.opensams.service.RegisterService;
import com.opensams.model.dto.RegisterDto;
import com.opensams.utils.ModelConverter;
import com.opensams.dal.StudentAssociationDao;
import com.opensams.dal.StudentDao;
import com.opensams.dal.po.Student;
import com.opensams.dal.po.StudentAssociation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Kevin Leung
 */
@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

    @Resource
    private StudentDao studentDao;

    @Resource
    private StudentAssociationDao studentAssociationDao;

    @Override
    public void register(RegisterDto registerDto) {
        Student student = ModelConverter.registerDto2Student(registerDto);
        // TODO: association 是否存在校验
        Integer associationId = registerDto.getStudentAssociation();

        studentDao.insertStudent(student);

        StudentAssociation studentAssociation = buildStudentAssociationRel(student, associationId);
        studentAssociationDao.insertStudentAssociation(studentAssociation);
    }

    private StudentAssociation buildStudentAssociationRel(Student student, Integer associationId) {
        StudentAssociation studentAssociation = new StudentAssociation();
        studentAssociation.setStudentCode(student.getStudentCode());
        studentAssociation.setAssociationId(associationId);
        studentAssociation.setCreatedAt(new Date());
        studentAssociation.setModifiedAt(new Date());
        return studentAssociation;
    }
}
