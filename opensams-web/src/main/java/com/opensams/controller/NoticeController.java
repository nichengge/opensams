package com.opensams.controller;

import com.opensams.model.dto.NoticeDto;
import com.opensams.model.vo.NoticeVo;
import com.opensams.service.NoticeService;
import com.opensams.controller.utils.ModelConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Kevin Leung
 */
@RestController
@RequestMapping(value = "/notice")
public class NoticeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(NoticeController.class);

    @Resource
    private NoticeService noticeService;

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Integer countNotice() {
        LOGGER.debug("class: {}, method: {}", "NoticeController", "countNotice");
        return noticeService.getTotalNotices();
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public NoticeVo getDashboardNotice(@RequestParam("p") Integer pageNumber) {
        LOGGER.debug("class: {}, method: {}", "NoticeController", "getDashboardNotice");
        List<NoticeDto> noticeDtos = noticeService.queryNoticesPage(pageNumber, 1);

        if (CollectionUtils.isEmpty(noticeDtos)) {
            return null;
        }

        NoticeDto noticeDto = noticeDtos.get(0);

        return ModelConverter.convertToNoticeVo(noticeDto);
    }

}
