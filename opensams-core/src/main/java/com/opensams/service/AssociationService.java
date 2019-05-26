package com.opensams.service;

import com.opensams.dal.po.Association;
import com.opensams.model.dto.AssociationDto;

import java.util.List;

/**
 * @author Kevin Leung
 */
public interface AssociationService {

    /**
     * 展示所有社团
     * @return 社团集合
     */
    List<AssociationDto> getAllAssociations();

    /**
     * 通过社团Id集合查询社团集合
     * @param associationIds 社团Id集合
     * @return 社团集合
     */
    List<Association> queryAssociationsByIds(List<Integer> associationIds);

}
