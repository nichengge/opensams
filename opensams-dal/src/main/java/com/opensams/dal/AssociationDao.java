package com.opensams.dal;

import com.opensams.dal.po.Association;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociationDao {

    /**
     * 查询所有的社团对象
     * @return 所有社团对象集合
     */
    List<Association> queryAllAssociations();

    /**
     * 批量通过社团Id查询社团信息
     * @param ids 社团Id列表
     * @return 社团信息列表
     */
    List<Association> queryAssociationsByIds(List<Integer> ids);

}
