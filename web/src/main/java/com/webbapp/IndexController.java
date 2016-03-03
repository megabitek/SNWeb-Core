package com.webbapp;

import entity.Users;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.UserService;

/**
 *
 * @author Elena_Kholkina
 */
@Controller 
@RequestMapping(value = "/")
public class IndexController {

  
    private final UserService userservice;

    public IndexController() {
        this.userservice = new UserService();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        
        return new ModelAndView("index", "signupForm", null);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model,   RedirectAttributes redirectAttributes) {

      

        return "show";

    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createget() {

        return "show";

    }

  
}
