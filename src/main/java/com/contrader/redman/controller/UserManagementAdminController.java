package com.contrader.redman.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.contrader.redman.model.User;
import com.contrader.redman.service.UserService;

@Controller
@RequestMapping("/admin")
public class UserManagementAdminController {
	
    @Autowired
    private UserService userService;
	
	@RequestMapping("listaUtenti")
	public String GetListaUtenti(Model model ) {
		
		model.addAttribute("users", userService.findAll());
		model.addAttribute("mode", "listaUtenti");
		return "/admin/MenùAdmin";	
	}

	@GetMapping("/registraUtente")
	public String getViewUtente(Model model) {
   		model.addAttribute("user",new User());
		model.addAttribute("mode", "creaUtente");
		return "/admin/MenùAdmin";
		
	}
	
	@PostMapping("/registraUtente")
	public String creaUtente(@ModelAttribute("user") User user) {
		userService.save(user);
		return "/admin/MenùAdmin";
	}
}
