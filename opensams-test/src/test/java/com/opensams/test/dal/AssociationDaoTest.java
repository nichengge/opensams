package com.opensams.test.dal;

import com.opensams.dal.AssociationDao;
import com.opensams.dal.po.Association;
import com.opensams.test.BasicTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Kevin Leung
 */
public class AssociationDaoTest extends BasicTest {

    @Resource
    private AssociationDao associationDao;

    @Test
    public void testQueryAllAssociations() {
        List<Association> associations = associationDao.queryAllAssociations();

        assert associations.size() > 0;
    }

}
