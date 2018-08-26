package com.contrader.redman.controller.admin;

import com.contrader.redman.model.Nodo;
import com.contrader.redman.service.NodoService;
import com.contrader.redman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class NodesManagementAdminController {
    private NodoService nodoService;
    private UserService userService;

    @Autowired
    public NodesManagementAdminController(NodoService nodoService, UserService userService) {
        this.userService = userService;
        this.nodoService = nodoService;
    }

    @RequestMapping("/listaNodi")
    public String GetListaNodi(Model model) throws CloneNotSupportedException {
        List<Nodo> listaNodi = new ArrayList<>();

        for (Nodo nodo : nodoService.findAll()) {
            String idresp=nodo.getIdresponsabile();
            String iduser=nodo.getIdutentesemplice();
            Nodo newNodo= (Nodo) nodo.clone();

            if(idresp != null) {
                //Integer idresp = Integer.parseInt(nodostring);
                String resp = userService.findByIdutente(Integer.parseInt(idresp));
                newNodo.setIdresponsabile(resp);
            }

            if(iduser != null){
                String user = userService.findByIdutente(Integer.parseInt(iduser));
                newNodo.setIdutentesemplice(user);
            }

            listaNodi.add(newNodo);
        }
        model.addAttribute("nodes", listaNodi);
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
        return "redirect:home";
    }

}
