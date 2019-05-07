package com.opensams.controller;

import com.opensams.dal.po.Association;
import com.opensams.service.ActivityService;
import com.opensams.service.AssociationService;
import com.opensams.service.dto.ActivityDto;
import com.opensams.vo.ActivityVo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
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

    @Resource
    private AssociationService associationService;
    @Resource
    private ActivityService activityService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index() {
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
                    .map(this::convertToActivityVo)
                    .collect(Collectors.toList());

            model.addAttribute("activities1", activityVos1);
        }

        if (CollectionUtils.isNotEmpty(activityDtos2)) {
            List<ActivityVo> activityVos2 = activityDtos2.stream()
                    .filter(Objects::nonNull)
                    .map(this::convertToActivityVo)
                    .collect(Collectors.toList());

            model.addAttribute("activities2", activityVos2);
        }

        return "content/dashboard";
    }

    private ActivityVo convertToActivityVo(ActivityDto activityDto) {
        ActivityVo activityVo = new ActivityVo();
        BeanUtils.copyProperties(activityDto, activityVo);

        return activityVo;
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
        model.addAttribute("studentAssociations", studentAssociations);
        return "register";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String pageFor403() {
        return "error/403";
    }

}
