package com.webbapp;

import entity.Users;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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

    @Autowired
    @Resource(name = "userservice")
    private UserService userservice;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {

        return new ModelAndView("index", "signupForm", null);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) {
         System.out.println(userservice);
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
           System.out.println(login+ "  "+ pass);
        Users curuser = userservice.findUserByLoginAndPasword(login, pass);
        System.out.println(curuser);
        model.addAttribute("user", curuser.getUsername());
        return "show";

    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createget() {

        return "show";

    }

}
