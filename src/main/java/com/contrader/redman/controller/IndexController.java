package com.contrader.redman.controller;

import com.contrader.redman.model.User;
import com.contrader.redman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    private UserService userService;


    @Autowired
    public IndexController(UserService userService/*, Charts charts*/) {
        this.userService = userService;
        //this.charts = charts;
    }

    @GetMapping(value = "/")
    public String index(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        model.addAttribute("user", new User());
        return "index";

    }

    @PostMapping(value = "/")
    public String CheckUser(@ModelAttribute("user") User user, Model model,HttpSession session) {
        User u = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (u != null) {
            String ruolo = u.getRuolo();

            switch (ruolo) {
                case "amministratore":
                    session.setAttribute("user", u);
                    return "redirect:admin/home";
                case "responsabile di rete":
                	session.setAttribute("user", u);
                    return "redirect:networkManager/home";
                case "utente semplice":
                	session.setAttribute("user", u);
                    return "redirect:user/home";
            }

           /* if (ruolo.equalsIgnoreCase("amministratore")) {
                model.addAttribute("mode", "null");
                charts.getGraphInfoAdmin(model);
                return "/admin/MenùAdmin";
            } else if (ruolo.equalsIgnoreCase("responsabile di rete")) {
                return "/networkManager/MenùNM";
            } else if (ruolo.equalsIgnoreCase("utente semplice")) {
                return "/user/MenùUser";
            } else {
                model.addAttribute("login", "error");
                return "index";
            }*/
        }
/*        if (u != null) {
            session.setAttribute("user", u);
            return callView(u.getRuolo(), model);
        } else if (session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
            return callView(user.getRuolo(), model);
        } else {
            model.addAttribute("login", "error");
            return "index";
        }*/
        model.addAttribute("login", "error");
        return "index";
    }

    /*private String callView(String ruolo, Model model) {
        if (ruolo.equalsIgnoreCase("amministratore")) {
            model.addAttribute("mode", "null");
            charts.getGraphInfoAdmin(model);
            return "/admin/MenùAdmin";
        } else if (ruolo.equalsIgnoreCase("responsabile di rete")) {
            return "/networkManager/MenùNM";
        } else if (ruolo.equalsIgnoreCase("utente semplice")) {
            return "/user/MenùUser";
        } else return null;
    }*/
}