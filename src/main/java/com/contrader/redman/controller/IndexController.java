package com.contrader.redman.controller;

import com.contrader.redman.model.Charts;
import com.contrader.redman.model.User;
import com.contrader.redman.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    private UserService userService;
    //private NodoService nodoService;
    private Charts charts;

    @Autowired
    public IndexController(UserService userService, Charts charts) {
        this.userService = userService;
        this.charts = charts;
    }


/*    public IndexController(UserService userService, NodoService nodoService) {
        this.userService = userService;
        this.nodoService = nodoService;
    }*/

    @RequestMapping(value = "/login")
    public String index(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        //session.setAttribute("user",new User());
        model.addAttribute("user", new User());
        return "index";
/*        ModelAndView mv = new ModelAndView("index");
        //UserData userData = userService.selectById(100000L);
        //System.out.println("get:"+userData.toString());
        mv.addObject("userDetailView", new LoggedUser(new User()));
        return mv;*/
    }

    @RequestMapping(value = "/home")
    public String CheckUser(@ModelAttribute("user") User user, Model model, HttpSession session) {
        User u = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        /*HttpSession session = null;

        if(u!=null){
            String ruolo=u.getRuolo();
    		session= request.getSession(true);
    		session.setAttribute("nomeUtente", u.getUsername());
            //session.setAttribute("user", user);
    
            if(ruolo.equalsIgnoreCase("amministratore")){
                model.addAttribute("mode","null");
                getGraphInfoAdmin(model);
                return "/admin/MenùAdmin";
            }else if(ruolo.equalsIgnoreCase("responsabile di rete")){
                return "/networkManager/MenùNM";
            }else if(ruolo.equalsIgnoreCase("utente semplice")){
                return "/user/MenùUser";
            }
        }else if(session.getAttribute("user")!=null){
            user= (User) session.getAttribute("user");
        }

        model.addAttribute("login","error");
        return "index";*/
        if (u != null) {
            String ruolo = u.getRuolo();
            session.setAttribute("user", u);
            return callView(ruolo, model);
        } else if (session.getAttribute("user") != null) {
            user = (User) session.getAttribute("user");
            return callView(user.getRuolo(), model);
        } else {
            model.addAttribute("login", "error");
            return "index";
        }
    }

    private String callView(String ruolo, Model model) {
        if (ruolo.equalsIgnoreCase("amministratore")) {
            model.addAttribute("mode", "null");
            charts.getGraphInfoAdmin(model);
            return "/admin/MenùAdmin";
        } else if (ruolo.equalsIgnoreCase("responsabile di rete")) {
            return "/networkManager/MenùNM";
        } else if (ruolo.equalsIgnoreCase("utente semplice")) {
            return "/user/MenùUser";
        } else return null;
    }

    /*public void getGraphInfoAdmin(Model model) {
        ArrayList<Integer> totali = new ArrayList<>();
        totali.add(0, userService.getNumPersonForRuolo("responsabile di rete"));
        totali.add(1, nodoService.findAll().size());
        model.addAttribute("totali", totali);

        ArrayList<Integer> noAssoc = new ArrayList<>();
        noAssoc.add(0, nodoService.findAllResponsabili().size());
        noAssoc.add(1, nodoService.getNotAssocNodes().size());
        model.addAttribute("noAssoc", noAssoc);

    }*/
}