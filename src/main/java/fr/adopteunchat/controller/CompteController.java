package fr.adopteunchat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.adopteunchat.dao.IPersonneDao;
import fr.adopteunchat.model.Personne;

@Controller
@RequestMapping("/compte")
public class CompteController {
	@Autowired
	IPersonneDao daoPersonne;

	@GetMapping
	public String display() {
		return "compte";
	}
	
	
	@PostMapping
	public String connexion(@RequestParam String password,
							@RequestParam String email,
							HttpSession session) {
		
		Personne personneConnectee=daoPersonne.findBymail(email);
		
		if(personneConnectee==null) {
			return "redirect:/compte";
		}else if(personneConnectee.getPassword().equals(password)) {
			
			session.setAttribute("connexionId", personneConnectee.getId());
			session.setAttribute("personneType", personneConnectee.getType());
			return "redirect:/mon-espace";

			
		}else {
			return "redirect:/compte";
		}
		
	}
	
}
