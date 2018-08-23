package com.contrader.redman.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.contrader.redman.service.NodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.contrader.redman.model.User;
import com.contrader.redman.service.UserService;

import java.util.ArrayList;

@Controller
public class IndexController {

    private UserService userService;
    private NodoService nodoService;
    
    @Autowired
    public IndexController(UserService userService,NodoService nodoService) {
		this.userService = userService;
		this.nodoService=nodoService;
	}

	@GetMapping(value="/")
    public String index(Model model){
        model.addAttribute("user",new User());
        return "index";
    }

    @PostMapping(value="/")
    public String CheckUser(@ModelAttribute("user") User user, Model model, HttpServletRequest request) {
        User u=userService.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        
        
        if(u!=null){
            String ruolo=u.getRuolo();
            
    		HttpSession session= request.getSession(true);
    		session.setAttribute("nomeUtente", u.getUsername());
    
            if(ruolo.equalsIgnoreCase("amministratore")){
                getGraphInfoAdmin(model);
                return "/admin/MenùAdmin";
            }else if(ruolo.equalsIgnoreCase("responsabile di rete")){
                return "/networkManager/MenùNM";
            }else if(ruolo.equalsIgnoreCase("utente semplice")){
                return "/user/MenùUser";
            }
        }

        model.addAttribute("login","error");
        return "index";
    }


    private void getGraphInfoAdmin(Model model){
        ArrayList<Integer> totali =new ArrayList<>();
        totali.add(0,userService.getNumPersonForRuolo("responsabile di rete"));
        totali.add(1,nodoService.findAll().size());
        model.addAttribute("totali",totali);

        ArrayList<Integer> noAssoc =new ArrayList<>();
        noAssoc.add(0,nodoService.findAllResponsabili().size());
        noAssoc.add(1,nodoService.getNotAssocNodes().size());
        model.addAttribute("noAssoc",noAssoc);



        
      /* model.addAttribute("Totalnumtotali",userService.getNumPersonForRuolo("responsabile di rete"));
       model.addAttribute("NumtotaliWithNode",nodoService.findAllResponsabili());*/

    }
    
}
