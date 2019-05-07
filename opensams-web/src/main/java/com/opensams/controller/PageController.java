package com.opensams.controller;

import com.opensams.dal.pojo.Association;
import com.opensams.service.AssociationService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Kevin Leung
 */
@Controller
public class PageController {

    @Resource
    private AssociationService associationService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index() {
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.getPrincipal());
        return "index";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard() {
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
        model.addAttribute("studentAssociations", studentAssociations);
        return "register";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String pageFor403() {
        return "error/403";
    }

}
