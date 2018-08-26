package com.contrader.redman.controller.admin;

import com.contrader.redman.model.User;
import com.contrader.redman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class UserManagementAdminController {
    private UserService userService;

    @Autowired
    public UserManagementAdminController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/listaUtenti")
    public String GetListaUtenti(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("mode", "listaUtenti");
        return "/admin/MenùAdmin";
    }

    @RequestMapping(value = "deleteUser/{idUser}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable int idUser) {
        userService.deleteUser(idUser);
        return "redirect:/admin/home";
    }

    @GetMapping("/registraUtente")
    public String getViewUtente(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("mode", "creaUtente");
        model.addAttribute("ruoli", userService.FindDistinctRuoli());
        return "/admin/MenùAdmin";

    }

    @PostMapping("/registraUtente")
    public String creaUtente(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin/home";
    }

}
