package com.opensams.controller;

import com.opensams.controller.utils.ModelConverter;
import com.opensams.model.dto.ActivityDto;
import com.opensams.model.dto.AssociationDto;
import com.opensams.model.dto.NoticeDto;
import com.opensams.model.dto.RoleDto;
import com.opensams.model.vo.ActivityVo;
import com.opensams.model.vo.AssociationVo;
import com.opensams.model.vo.NoticeVo;
import com.opensams.model.vo.RoleVo;
import com.opensams.service.ActivityService;
import com.opensams.service.AssociationService;
import com.opensams.service.NoticeService;
import com.opensams.service.RoleService;
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

    @Resource
    private RoleService roleService;

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

    @RequestMapping(value = "/personnel/member-register", method = RequestMethod.GET)
    public String memberRegister(Model model) {
        List<RoleDto> roleDtos = roleService.getAssociationRoles();

        if (CollectionUtils.isNotEmpty(roleDtos)) {
            List<RoleVo> roleVos = roleDtos.stream()
                    .map(ModelConverter::convertToRoleVo)
                    .collect(Collectors.toList());

            model.addAttribute("roleList", roleVos);
        }

        List<AssociationDto> associationDtos = associationService.getAllAssociations();

        if (CollectionUtils.isNotEmpty(associationDtos)) {
            List<AssociationVo> associationVos = associationDtos.stream()
                    .map(ModelConverter::convertToAssociationVo)
                    .collect(Collectors.toList());

            model.addAttribute("associations", associationVos);
        }

        return "content/personnel/member-register";
    }

    @RequestMapping(value = "/{prefix}/{page}", method = RequestMethod.GET)
    public String pageContent(@PathVariable String prefix, @PathVariable String page) {
        return "content/" + prefix + "/" + page;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        LOGGER.debug("class: {}, method: {}", "PageController", "login");
        return "login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        List<AssociationDto> studentAssociations = associationService.getAllAssociations();
        if (CollectionUtils.isNotEmpty(studentAssociations)) {
            List<AssociationVo> associationVos = studentAssociations.stream()
                    .map(ModelConverter::convertToAssociationVo)
                    .collect(Collectors.toList());

            model.addAttribute("studentAssociations", associationVos);
        }
        return "register";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String pageFor403() {
        LOGGER.debug("class: {}, method: {}", "PageController", "pageFor403");
        return "error/403";
    }

}
