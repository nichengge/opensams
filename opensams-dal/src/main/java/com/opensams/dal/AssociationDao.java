package com.opensams.dal;

import com.opensams.dal.pojo.Association;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociationDao {

    /**
     * 查询所有的社团对象
     * @return 所有社团对象集合
     */
    List<Association> queryAllAssociations();

}
