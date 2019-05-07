package com.opensams.dal;

import com.opensams.dal.pojo.StudentAssociation;
import org.springframework.stereotype.Repository;

/**
 * @author Kevin Leung
 */
@Repository
public interface StudentAssociationDao {

    /**
     * 添加学生和社团之间的关联关系
     * @param studentAssociation 学生社团关联关系对象
     * @return 影响的行数
     */
    int insertStudentAssociation(StudentAssociation studentAssociation);

}
