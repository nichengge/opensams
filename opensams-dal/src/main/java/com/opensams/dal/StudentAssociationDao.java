package com.opensams.dal;

import com.opensams.dal.po.StudentAssociation;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 批量通过学号查询社团id
     * @param studentCodes 学号列表
     * @return 社团Id列表
     */
    List<StudentAssociation> queryAssociationIdsByStudentCodes(List<String> studentCodes);

}
