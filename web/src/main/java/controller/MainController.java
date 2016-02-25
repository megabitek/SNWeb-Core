/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author Elena_Kholkina
 */
@Controller
public class MainController {
    
    @RequestMapping(value = "/userpage", method = RequestMethod.POST)
    public String viewHome(Model model, HttpServletRequest req) {
        return "userpage";
    }
    
}
