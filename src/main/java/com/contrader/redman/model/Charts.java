package com.contrader.redman.model;

import com.contrader.redman.service.NodoService;
import com.contrader.redman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.ArrayList;

@Component
public class Charts {
    private UserService userService;
    private NodoService nodoService;

    @Autowired
    public Charts(UserService userService, NodoService nodoService) {
        this.userService = userService;
        this.nodoService = nodoService;
    }

    public void getGraphInfoAdmin(Model model) {
        ArrayList<Integer> totali = new ArrayList<>();
        int numResp=userService.getNumPersonForRuolo("responsabile di rete");
        totali.add(0, numResp);
        totali.add(1, nodoService.findAll().size());
        model.addAttribute("totali", totali);

        ArrayList<Integer> noAssoc = new ArrayList<>();
        noAssoc.add(0, numResp-nodoService.findAllResponsabili().size());
        noAssoc.add(1, nodoService.getNumAssocNodes().size());
        model.addAttribute("noAssoc", noAssoc);

    }
}
