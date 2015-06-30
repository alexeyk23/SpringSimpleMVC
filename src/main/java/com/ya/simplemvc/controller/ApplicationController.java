package com.ya.simplemvc.controller;

import com.ya.simplemvc.Service.ApplicationService;
import com.ya.simplemvc.model.Application;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Kunakovsky A. S.
 */
@Controller
@RequestMapping("/app")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;
    @RequestMapping(value = "/showall",method = RequestMethod.GET)
    public String home(ModelMap model) {
        List<Application> appList = applicationService.getAll();
        model.addAttribute("applist",appList);
        return "/apps/showall";//name of view file or address
    }
}
