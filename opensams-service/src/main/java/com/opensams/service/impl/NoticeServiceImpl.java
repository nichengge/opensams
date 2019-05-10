package com.opensams.service.impl;

import com.google.common.collect.Lists;
import com.opensams.dal.AssociationDao;
import com.opensams.dal.NoticeDao;
import com.opensams.dal.StudentAssociationDao;
import com.opensams.dal.StudentDao;
import com.opensams.dal.po.Association;
import com.opensams.dal.po.Notice;
import com.opensams.dal.po.Student;
import com.opensams.dal.po.StudentAssociation;
import com.opensams.model.PageModel;
import com.opensams.model.dto.NoticeDto;
import com.opensams.service.NoticeService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Kevin Leung
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeDao noticeDao;

    @Resource
    private StudentDao studentDao;

    @Resource
    private StudentAssociationDao studentAssociationDao;

    @Resource
    private AssociationDao associationDao;

    @Override
    public List<NoticeDto> queryNoticesPage(int start, int offset) {
        PageModel pageModel = new PageModel();
        pageModel.setStart(start);
        pageModel.setOffset(offset);
        List<Notice> notices = noticeDao.queryNoticesPageAndOrderByExpireDate(pageModel);

        if (CollectionUtils.isEmpty(notices)) {
            return Lists.newArrayList();
        }

        List<String> publisherCodes = notices.stream()
                .filter(n -> n != null && n.getPublisherCode() != null)
                .map(Notice::getPublisherCode)
                .collect(Collectors.toList());

        List<Student> students = studentDao.queryStudentsByCodes(publisherCodes);

        if (CollectionUtils.isEmpty(students)) {
            return Lists.newArrayList();
        }

        List<StudentAssociation> studentAssociations = studentAssociationDao.queryAssociationIdsByStudentCodes(publisherCodes);

        if (CollectionUtils.isEmpty(studentAssociations)) {
            return Lists.newArrayList();
        }

        List<Integer> associationIds = studentAssociations.stream()
                .filter(s -> s != null && s.getAssociationId() != null)
                .map(StudentAssociation::getAssociationId)
                .collect(Collectors.toList());

        List<Association> associations = associationDao.queryAssociationsByIds(associationIds);

        if (CollectionUtils.isEmpty(associationIds)) {
            return Lists.newArrayList();
        }

        Map<String, Student> studentMap = students.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Student::getStudentCode, s -> s, (k1, k2) -> k1));

        Map<String, Integer> studentAssociationMap = studentAssociations.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(StudentAssociation::getStudentCode, StudentAssociation::getAssociationId, (k1, k2) -> k1));

        Map<Integer, Association> associationMap = associations.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Association::getId, a -> a, (k1, k2) -> k1));


        return transformToNoticeDtos(notices, studentMap,
                studentAssociationMap, associationMap);
    }

    private List<NoticeDto> transformToNoticeDtos(List<Notice> notices,
                                                  Map<String, Student> studentMap,
                                                  Map<String, Integer> studentAssociationMap,
                                                  Map<Integer, Association> associationMap) {
        List<NoticeDto> noticeDtos = Lists.newArrayList();

        for (Notice notice : notices) {
            NoticeDto noticeDto = new NoticeDto();
            noticeDto.setId(notice.getId());
            noticeDto.setContent(notice.getContent());
            noticeDto.setTitle(notice.getTitle());
            noticeDto.setPublisherCode(notice.getTitle());
            noticeDto.setCreatedAt(notice.getCreatedAt());
            noticeDto.setModifiedAt(notice.getModifiedAt());

            String publisherCode = notice.getPublisherCode();
            Student student = studentMap.get(publisherCode);
            noticeDto.setPublisher(student.getStudentName());

            Integer associationId = studentAssociationMap.get(publisherCode);
            Association association = associationMap.get(associationId);
            noticeDto.setPublishDept(association.getName());

            noticeDtos.add(noticeDto);
        }

        return noticeDtos;
    }

    @Override
    public Integer getTotalNotices() {
        return noticeDao.countNotices();
    }
}
