package com.opensams.service.impl;

import com.google.common.collect.Lists;
import com.opensams.model.dto.AssociationDto;
import com.opensams.service.AssociationService;
import com.opensams.dal.AssociationDao;
import com.opensams.dal.po.Association;
import com.opensams.service.utils.ModelConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Kevin Leung
 */
@Service("associationService")
public class AssociationServiceImpl implements AssociationService {

    @Resource
    private AssociationDao associationDao;

    @Override
    public List<AssociationDto> getAllAssociations() {
        List<Association> associations = associationDao.queryAllAssociations();

        if (CollectionUtils.isEmpty(associations)) {
            return Lists.newArrayList();
        }

        return associations.stream()
                .map(ModelConverter::convertToAssociationDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Association> queryAssociationsByIds(List<Integer> associationIds) {
        return associationDao.queryAssociationsByIds(associationIds);
    }
}
