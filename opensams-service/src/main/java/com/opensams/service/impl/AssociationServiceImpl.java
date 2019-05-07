package com.opensams.service.impl;

import com.opensams.service.AssociationService;
import com.opensams.dal.AssociationDao;
import com.opensams.dal.po.Association;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Kevin Leung
 */
@Service("associationService")
public class AssociationServiceImpl implements AssociationService {

    @Resource
    private AssociationDao associationDao;

    @Override
    public List<Association> showAllAssociations() {
        return associationDao.queryAllAssociations();
    }
}
