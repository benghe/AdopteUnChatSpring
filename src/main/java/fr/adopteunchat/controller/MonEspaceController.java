package fr.adopteunchat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.adopteunchat.dao.IPersonneDao;
import fr.adopteunchat.model.Personne;

@Controller
@RequestMapping("/mon-espace")
public class MonEspaceController {
	IPersonneDao daoPersonne;

	@GetMapping
	public String display() {
		
		return "mon-espace";
		
	}
	
	@GetMapping("modification-adoptant")
	public String modifAdoptant(HttpSession session) {
		
		int id=(int) session.getAttribute("connexionId");
		//Personne personneAModifier = new Personne();
		Personne personneAModifier=daoPersonne.findByid(id);
		
		session.setAttribute("personneAModifier", personneAModifier);
		return "modification-de-mes-infos-adoptant";
		
	}
	
	
	@PostMapping("modification-adoptant")
	public String modifAdoptant(Personne personne) {
		this.daoPersonne.save(personne);
		return "redirect:.";
	}
	
	@GetMapping("modification-refuge")
	public String modifRefuge() {
		return "modification-de-mes-infos-refuge";
	}
}
