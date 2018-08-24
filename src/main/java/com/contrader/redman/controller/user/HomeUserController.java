package com.contrader.redman.controller.user;

import com.contrader.redman.service.NodoService;
import com.contrader.redman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("user")
public class HomeUserController {
    private UserService userService;
    private NodoService nodoService;

    @Autowired
    public HomeUserController(UserService userService, NodoService nodoService) {
        this.userService = userService;
        this.nodoService = nodoService;
    }
    
    @RequestMapping(value = "/home")
    public String Home(Model model) {
        model.addAttribute("mode", "null");
//        getGraphInfoAdmin(model);
        return "user/MenùUser";
    }

}
