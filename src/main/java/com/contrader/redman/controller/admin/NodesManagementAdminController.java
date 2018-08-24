package com.contrader.redman.controller.admin;

import com.contrader.redman.model.Nodo;
import com.contrader.redman.service.NodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class NodesManagementAdminController {
    private NodoService nodoService;
    //private Charts charts;

    @Autowired
    public NodesManagementAdminController(NodoService nodoService/*, Charts charts*/) {
        this.nodoService = nodoService;
        //this.charts = charts;
    }


   /* public NodesManagementAdminController(NodoService nodoService) {
        this.nodoService = nodoService;
    }*/

    @RequestMapping("/listaNodi")
    public String GetListaNodi(Model model) {

        model.addAttribute("nodes", nodoService.findAll());
        model.addAttribute("mode", "listaNodi");
        return "/admin/MenùAdmin";
    }

    @GetMapping("/aggiungiNodo")
    public String getViewNodo(Model model) {
        model.addAttribute("nodo", new Nodo());
        model.addAttribute("mode", "creaNodo");
        return "/admin/MenùAdmin";

    }

    @PostMapping("/aggiungiNodo")
    public String creaNodo(@ModelAttribute("nodo") Nodo nodo, Model model) {
        nodoService.save(nodo);
        /*model.addAttribute("mode", "null");
        charts.getGraphInfoAdmin(model);
        return "redirect:/home";*/
        return "redirect:home";
    }

}
