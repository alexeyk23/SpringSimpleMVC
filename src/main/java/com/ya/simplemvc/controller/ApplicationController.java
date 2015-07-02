package com.ya.simplemvc.controller;

import com.ya.simplemvc.Service.ApplicationService;
import com.ya.simplemvc.Service.PrivilegeService;
import com.ya.simplemvc.model.Application;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
    PrivilegeService privService;
    
    @RequestMapping(value = "/showall",method = RequestMethod.GET)
    public String home(ModelMap model) {
        List<Application> appList = applicationService.getAll();
        model.addAttribute("applist",appList);
        return "apps/showall";//name of view file or address
    }
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String addForm(ModelMap model) {
        model.addAttribute("application",new Application());
        model.addAttribute("privList",privService.getAll());
        return "apps/add";
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@ModelAttribute("application") Application application,
            BindingResult result, ModelMap model){
        if (result.hasErrors()) {
            return "redirect:/app/add";
        }        
        return "redirect:/app/showall";
    }
}
