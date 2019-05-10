package com.opensams.utils;

import com.opensams.model.dto.ActivityDto;
import com.opensams.model.dto.NoticeDto;
import com.opensams.model.dto.RegisterDto;
import com.opensams.model.vo.ActivityVo;
import com.opensams.model.vo.NoticeVo;
import com.opensams.model.vo.request.RegisterRequest;

/**
 * @author Kevin Leung
 */
public class ModelConverter {

    public static RegisterDto registerRequest2Dto(RegisterRequest request) {
        RegisterDto registerDto = new RegisterDto();
        registerDto.setStudentName(request.getStudentName());
        registerDto.setStudentId(request.getStudentId());
        registerDto.setStudentEmail(request.getStudentEmail());
        registerDto.setStudentCollege(request.getStudentCollege());
        registerDto.setStudentAssociation(request.getStudentAssociation());
        registerDto.setStudentPassword(request.getStudentPassword());
        registerDto.setStudentRegisterKey(request.getStudentRegisterKey());
        return registerDto;
    }

    public static ActivityVo convertToActivityVo(ActivityDto activityDto) {
        ActivityVo activityVo = new ActivityVo();

        activityVo.setId(activityDto.getId());
        activityVo.setName(activityDto.getName());
        activityVo.setSpot(activityDto.getSpot());
        activityVo.setAssociation(activityDto.getAssociation());
        activityVo.setStartTime(DateUtils.formatDate(activityDto.getStartTime()));
        activityVo.setEndTime(DateUtils.formatDate(activityDto.getEndTime()));
        activityVo.setNumber(activityDto.getNumber());
        activityVo.setPrincipal(activityDto.getPrincipal());
        activityVo.setTeacher(activityDto.getTeacher());
        activityVo.setDescription(activityDto.getDescription());
        activityVo.setCreatedAt(DateUtils.formatDate(activityDto.getCreatedAt()));
        activityVo.setModifiedAt(DateUtils.formatDate(activityDto.getModifiedAt()));

        return activityVo;
    }

    public static NoticeVo convertToNoticeVo(NoticeDto noticeDto) {
        NoticeVo noticeVo = new NoticeVo();

        noticeVo.setId(noticeDto.getId());
        noticeVo.setTitle(noticeDto.getTitle());
        noticeVo.setContent(noticeDto.getContent());
        noticeVo.setPublishTime(DateUtils.formatDate(noticeDto.getCreatedAt()));
        noticeVo.setPublisher(noticeDto.getPublisher());
        noticeVo.setPublishDept(noticeDto.getPublishDept());

        return noticeVo;
    }

}
