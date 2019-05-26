package com.opensams.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.opensams.dal.AssociationDao;
import com.opensams.dal.StudentAssociationDao;
import com.opensams.dal.po.Association;
import com.opensams.dal.po.StudentAssociation;
import com.opensams.model.dto.AssociationDto;
import com.opensams.model.dto.StudentAssociationDto;
import com.opensams.service.StudentAssociationService;
import com.opensams.service.utils.ModelConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Kevin Leung
 */
@Service("studentAssociationService")
public class StudentAssociationServiceImpl implements StudentAssociationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentAssociationServiceImpl.class);

    @Resource
    private StudentAssociationDao studentAssociationDao;

    @Resource
    private AssociationDao associationDao;

    @Override
    public List<StudentAssociationDto> queryByStudentCodes(List<String> studentCodes) {
        LOGGER.debug("class: {}, method: {}", "StudentAssociationServiceImpl", "queryByStudentCodes");

        List<StudentAssociation> studentAssociations = studentAssociationDao.queryByStudentCodes(studentCodes);

        if (CollectionUtils.isEmpty(studentAssociations)) {
            return Lists.newArrayList();
        }

        return studentAssociations.stream()
                .map(ModelConverter::convertToStudentAssociationDto)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<AssociationDto>> buildStudentAssociationRel(List<String> studentCodes) {
        LOGGER.debug("class: {}, method: {}", "StudentAssociationServiceImpl", "buildStudentAssociationRel");

        Map<String, List<AssociationDto>> studentAssociationRel = Maps.newHashMap();

        List<StudentAssociation> studentAssociations = studentAssociationDao.queryByStudentCodes(studentCodes);

        if (CollectionUtils.isEmpty(studentAssociations)) {
            LOGGER.debug("studentAssociations is empty!");
            return studentAssociationRel;
        }

        List<Integer> associationIds = studentAssociations.stream()
                .map(StudentAssociation::getAssociationId)
                .collect(Collectors.toList());

        List<Association> associations = associationDao.queryAssociationsByIds(associationIds);

        if (CollectionUtils.isEmpty(associations)) {
            LOGGER.debug("associations is empty!");
            return studentAssociationRel;
        }

        Map<Integer, Association> associationMap = associations.stream()
                .collect(Collectors.toMap(Association::getId, a -> a, (k1, k2) -> k1));

        Map<String, List<StudentAssociation>> studentAssociationMap = studentAssociations.stream()
                .collect(Collectors.groupingBy(StudentAssociation::getStudentCode));

        for (Map.Entry<String, List<StudentAssociation>> entry : studentAssociationMap.entrySet()) {
            String studentCode = entry.getKey();
            List<StudentAssociation> studentAssociationList = entry.getValue();

            Set<Integer> associationIdSetForTheStudent = studentAssociationList.stream()
                    .map(StudentAssociation::getAssociationId)
                    .collect(Collectors.toSet());

            List<AssociationDto> associationListForTheStudent = Lists.newArrayList();
            for (Integer associationId : associationIdSetForTheStudent) {
                Association association = associationMap.get(associationId);
                AssociationDto associationDto = ModelConverter.convertToAssociationDto(association);
                associationListForTheStudent.add(associationDto);
            }

            studentAssociationRel.put(studentCode, associationListForTheStudent);
        }

        return studentAssociationRel;
    }
}
