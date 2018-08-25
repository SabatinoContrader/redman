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
    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String index(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        model.addAttribute("user", new User());
        return "index";

    }

    @PostMapping(value = "/")
    public String CheckUser(@ModelAttribute("user") User user, Model model, HttpSession session) {
        User u = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (u != null) {
            String ruolo = u.getRuolo();

            switch (ruolo) {
                case "Amministratore":
                    session.setAttribute("user", u);
                    return "redirect:admin/home";
                case "Responsabile di rete":
                    session.setAttribute("user", u);
                    return "redirect:networkManager/home";
                case "Utente semplice":
                    session.setAttribute("user", u);
                    return "redirect:user/home";
            }
        }

        model.addAttribute("login", "error");
        return "index";
    }
}