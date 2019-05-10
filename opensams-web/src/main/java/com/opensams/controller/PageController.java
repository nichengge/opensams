package com.opensams.controller;

import com.opensams.dal.po.Association;
import com.opensams.model.dto.ActivityDto;
import com.opensams.model.dto.NoticeDto;
import com.opensams.model.vo.ActivityVo;
import com.opensams.model.vo.NoticeVo;
import com.opensams.service.ActivityService;
import com.opensams.service.AssociationService;
import com.opensams.service.NoticeService;
import com.opensams.utils.ModelConverter;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author Kevin Leung
 */
@Controller
public class PageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PageController.class);

    @Resource
    private AssociationService associationService;

    @Resource
    private ActivityService activityService;

    @Resource
    private NoticeService noticeService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index() {
        LOGGER.debug("class: {}, method: {}", "PageController", "index");
        return "index";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model) {
        Map<String, List<ActivityDto>> dashboardActivitiesMap
                = activityService.showActivitiesInDashboard();

        List<ActivityDto> activityDtos1 = dashboardActivitiesMap.get("activities1");
        List<ActivityDto> activityDtos2 = dashboardActivitiesMap.get("activities2");

        if (CollectionUtils.isNotEmpty(activityDtos1)) {
            List<ActivityVo> activityVos1 = activityDtos1.stream()
                    .filter(Objects::nonNull)
                    .map(ModelConverter::convertToActivityVo)
                    .collect(Collectors.toList());

            model.addAttribute("activities1", activityVos1);
        }

        if (CollectionUtils.isNotEmpty(activityDtos2)) {
            List<ActivityVo> activityVos2 = activityDtos2.stream()
                    .filter(Objects::nonNull)
                    .map(ModelConverter::convertToActivityVo)
                    .collect(Collectors.toList());

            model.addAttribute("activities2", activityVos2);
        }

        List<NoticeDto> noticeDtos = noticeService.queryNoticesPage(0, 1);

        if (CollectionUtils.isNotEmpty(noticeDtos)) {
            NoticeDto noticeDto = noticeDtos.get(0);
            NoticeVo noticeVo = ModelConverter.convertToNoticeVo(noticeDto);

            model.addAttribute("notice", noticeVo);
        }

        return "content/dashboard";
    }

    @RequestMapping(value = "/{prefix}/{page}", method = RequestMethod.GET)
    public String pageContent(@PathVariable String prefix, @PathVariable String page) {
        return "content/" + prefix + "/" + page;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        List<Association> studentAssociations = associationService.showAllAssociations();
        if (CollectionUtils.isNotEmpty(studentAssociations)) {
            model.addAttribute("studentAssociations", studentAssociations);
        }
        return "register";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String pageFor403() {
        return "error/403";
    }

}
