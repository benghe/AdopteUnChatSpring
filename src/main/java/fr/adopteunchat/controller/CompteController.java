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
		}else if(password.equals("")) {
			session.setAttribute("connexionId", personneConnectee.getId());
			session.setAttribute("personneType", personneConnectee.getType());
			return "redirect:/mon-espace";
		}else if(personneConnectee.getPassword().equals(password)) {
			
			session.setAttribute("connexionId", personneConnectee.getId());
			session.setAttribute("personneType", personneConnectee.getType());
			return "redirect:/mon-espace";

			
		}else {
			return "redirect:/compte";
		}
		
	}
	
	
	@GetMapping("inscription-adoptant")
	public String displayInscriptionAdoptant() {
		return "inscription-adoptant";
	}
	

	@PostMapping("inscription-adoptant")
	public String inscriptionAdoptant(@RequestParam String inputLastname,
			@RequestParam String inputFirstname,
			@RequestParam String inputEmail,
			@RequestParam String inputPhone,
			@RequestParam String inputDateOfBirth,
			@RequestParam String inputAdresseNumber,
			@RequestParam String inputAdresseStreet,
			@RequestParam String inputAdressePostalCode,
			@RequestParam String inputAdresseTown,
			@RequestParam String inputPassword,
			@RequestParam String confPassword
			) {
		
		Personne personne = new Personne();
		String adresseAdoptant = inputAdresseNumber + ", " + inputAdresseStreet + ", " + inputAdressePostalCode
				+ ", " + inputAdresseTown;

		
		personne.setNom(inputLastname);
		personne.setPrenom(inputFirstname);
		personne.setMail(inputEmail);
		personne.setTelephone(inputPhone);
		personne.setDateNaissance(inputDateOfBirth);
		personne.setAdresse(adresseAdoptant);
		personne.setPassword(inputPassword);
		personne.setType("Adoptant");
		
		
		this.daoPersonne.save(personne);
		return "redirect:/compte";
	}
	
	
	
	@GetMapping("inscription-refuge")
	public String displayInscriptionRefuge() {
		return "inscription-refuge";
	}
	

	@PostMapping("inscription-refuge")
	public String inscriptionRefuge(@RequestParam String inputLastname,
			@RequestParam String inputEmail,
			@RequestParam String inputPhone,
			@RequestParam String inputAdresseNumber,
			@RequestParam String inputAdresseStreet,
			@RequestParam String inputAdressePostalCode,
			@RequestParam String inputAdresseTown,
			@RequestParam String inputPassword,
			@RequestParam String confPassword
			) {
		
		Personne personne = new Personne();
		String adresseAdoptant = inputAdresseNumber + ", " + inputAdresseStreet + ", " + inputAdressePostalCode
				+ ", " + inputAdresseTown;

		
		personne.setNom(inputLastname);
		personne.setPrenom("refuge");
		personne.setMail(inputEmail);
		personne.setTelephone(inputPhone);
		personne.setAdresse(adresseAdoptant);
		personne.setPassword(inputPassword);
		personne.setType("Refuge");
		
		
		this.daoPersonne.save(personne);
		return "redirect:/compte";
	}
	
	@GetMapping("deconnexion")
	public String deconnexion(HttpSession session) {
		session.invalidate();
		return "redirect:/compte";
	}
}
