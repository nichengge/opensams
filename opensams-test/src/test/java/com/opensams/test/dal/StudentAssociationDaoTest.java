package com.opensams.test.dal;

import com.opensams.dal.StudentAssociationDao;
import com.opensams.dal.pojo.StudentAssociation;
import com.opensams.test.BasicTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author Kevin Leung
 */
public class StudentAssociationDaoTest extends BasicTest {

    @Resource
    private StudentAssociationDao studentAssociationDao;

    @Test
    public void testInsertStudentAssociation() {
        StudentAssociation studentAssociation = new StudentAssociation();
        studentAssociation.setStudentCode("20154124");
        studentAssociation.setAssociationId(1);
        studentAssociation.setCreatedAt(new Date());
        studentAssociation.setModifiedAt(new Date());

        int affectedRows = studentAssociationDao.insertStudentAssociation(studentAssociation);

        assert affectedRows == 1;
    }

}
