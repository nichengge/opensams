package com.opensams.service;

import com.opensams.model.dto.AssociationDto;
import com.opensams.model.dto.StudentAssociationDto;

import java.util.List;
import java.util.Map;

/**
 * @author Kevin Leung
 */
public interface StudentAssociationService {

    /**
     * 通过学号查询学生社团关联关系
     * @param studentCodes 学号列表
     * @return 学生社团关联关系集合
     */
    List<StudentAssociationDto> queryByStudentCodes(List<String> studentCodes);

    /**
     * 建立学生和社团的管理关系映射
     * @param studentCodes 学号集合
     * @return 学生和社团的关联关系
     */
    Map<String, List<AssociationDto>> buildStudentAssociationRel(List<String> studentCodes);

}
