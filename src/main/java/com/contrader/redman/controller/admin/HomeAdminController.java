package com.contrader.redman.controller.admin;

import com.contrader.redman.service.NodoService;
import com.contrader.redman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("admin")
public class HomeAdminController {
    private UserService userService;
    private NodoService nodoService;

    @Autowired
    public HomeAdminController(UserService userService, NodoService nodoService) {
        this.userService = userService;
        this.nodoService = nodoService;
    }

    @RequestMapping(value = "/home")
    public String Home(Model model) {
        model.addAttribute("mode", "null");
        getGraphInfoAdmin(model);
        return "admin/MenùAdmin";
    }

    private void getGraphInfoAdmin(Model model) {
        ArrayList<Integer> totali = new ArrayList<>();
        int numResp = userService.getNumPersonForRuolo("Responsabile di rete");
        totali.add(0, numResp);
        totali.add(1, nodoService.findAll().size());
        model.addAttribute("totali", totali);

        ArrayList<Integer> noAssoc = new ArrayList<>();
        noAssoc.add(0, numResp - nodoService.findAllResponsabiliAssoc().size());
        noAssoc.add(1, nodoService.getNumNotAssocNodes());
        model.addAttribute("noAssoc", noAssoc);
    }
}
