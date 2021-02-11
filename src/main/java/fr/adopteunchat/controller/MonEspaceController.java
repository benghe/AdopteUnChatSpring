package fr.adopteunchat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.adopteunchat.dao.IPersonneDao;
import fr.adopteunchat.model.Personne;

@Controller
@RequestMapping("/mon-espace")
public class MonEspaceController {
	@Autowired
	IPersonneDao daoPersonne;

	@GetMapping
	public String display() {
		
		return "mon-espace";
		
	}
	
	
	@PostMapping
	public String delete(HttpSession session) {
		int id=(int) session.getAttribute("connexionId");
		this.daoPersonne.deleteById(id);
		
		session.invalidate();
		return "redirect:/compte";
	}
	
	
	@GetMapping("modification-adoptant")
	public String modifAdoptant(HttpSession session) {
		
		int id=(int) session.getAttribute("connexionId");
		Personne personneAModifier=this.daoPersonne.findByid(id);
		
		session.setAttribute("personneAModifier", personneAModifier);
		
		String adressePersonneAModifier=personneAModifier.getAdresse();
		
		int firstvirgule=adressePersonneAModifier.indexOf(',');
		int secondvirgule=adressePersonneAModifier.indexOf(',', firstvirgule+1);
		int thirdvirgule=adressePersonneAModifier.indexOf(',', secondvirgule+1);
		
		
		String numero=adressePersonneAModifier.substring(0, firstvirgule);
		String voie=adressePersonneAModifier.substring(firstvirgule+2, secondvirgule);
		String codePostal=adressePersonneAModifier.substring(secondvirgule+2, thirdvirgule);
		String ville=adressePersonneAModifier.substring(thirdvirgule+2, adressePersonneAModifier.length());

		
		session.setAttribute("numero", numero);
		session.setAttribute("voie", voie);
		session.setAttribute("codePostal", codePostal);
		session.setAttribute("ville", ville);
		
		return "modification-de-mes-infos-adoptant";
		
	}
	
	
	@PostMapping("modification-adoptant")
	public String modifAdoptant(@RequestParam String inputLastname,
			@RequestParam String inputFirstname,
			@RequestParam String inputEmail,
			@RequestParam String inputPhone,
			@RequestParam String inputDateOfBirth,
			@RequestParam String inputAdresseNumber,
			@RequestParam String inputAdresseStreet,
			@RequestParam String inputAdressePostalCode,
			@RequestParam String inputAdresseTown,
			@RequestParam String inputOldPassword,
			@RequestParam String inputPassword,
			@RequestParam String confPassword,
			HttpSession session
			) {
		
		Personne personne = new Personne();
		String adresseAdoptant = inputAdresseNumber + ", " + inputAdresseStreet + ", " + inputAdressePostalCode
				+ ", " + inputAdresseTown;

		int id=(int) session.getAttribute("connexionId");
		
		personne.setId(id);
		personne.setNom(inputLastname);
		personne.setPrenom(inputFirstname);
		personne.setMail(inputEmail);
		personne.setTelephone(inputPhone);
		personne.setDateNaissance(inputDateOfBirth);
		personne.setAdresse(adresseAdoptant);
		personne.setType("Adoptant");
		
		
		Personne personneAModifier=this.daoPersonne.findByid(id);
		
				
		if(personneAModifier.getPassword()!=null && inputOldPassword.equals(personneAModifier.getPassword()) && inputPassword.equals(confPassword)) {
			personne.setPassword(inputPassword);
		} else {
			personne.setPassword(personneAModifier.getPassword());
		}
		
		
		this.daoPersonne.save(personne);
		return "redirect:.";
	}
	
	
	
	
	
	@GetMapping("modification-refuge")
	public String modifRefuge(HttpSession session) {
		
		int id=(int) session.getAttribute("connexionId");
		Personne personneAModifier=this.daoPersonne.findByid(id);
		
		session.setAttribute("personneAModifier", personneAModifier);
		
		String adressePersonneAModifier=personneAModifier.getAdresse();
		
		int firstvirgule=adressePersonneAModifier.indexOf(',');
		int secondvirgule=adressePersonneAModifier.indexOf(',', firstvirgule+1);
		int thirdvirgule=adressePersonneAModifier.indexOf(',', secondvirgule+1);
		
		
		String numero=adressePersonneAModifier.substring(0, firstvirgule);
		String voie=adressePersonneAModifier.substring(firstvirgule+2, secondvirgule);
		String codePostal=adressePersonneAModifier.substring(secondvirgule+2, thirdvirgule);
		String ville=adressePersonneAModifier.substring(thirdvirgule+2, adressePersonneAModifier.length());

		
		session.setAttribute("numero", numero);
		session.setAttribute("voie", voie);
		session.setAttribute("codePostal", codePostal);
		session.setAttribute("ville", ville);
		
		return "modification-de-mes-infos-refuge";
		
	}
	
	
	@PostMapping("modification-refuge")
	public String modifRefuge(@RequestParam String inputLastname,
			@RequestParam String inputEmail,
			@RequestParam String inputPhone,
			@RequestParam String inputAdresseNumber,
			@RequestParam String inputAdresseStreet,
			@RequestParam String inputAdressePostalCode,
			@RequestParam String inputAdresseTown,
			@RequestParam String inputOldPassword,
			@RequestParam String inputPassword,
			@RequestParam String confPassword,
			HttpSession session
			) {
		
		Personne personne = new Personne();
		String adresseRefuge = inputAdresseNumber + ", " + inputAdresseStreet + ", " + inputAdressePostalCode
				+ ", " + inputAdresseTown;

		int id=(int) session.getAttribute("connexionId");
		
		personne.setId(id);
		personne.setNom(inputLastname);
		personne.setPrenom("refuge");
		personne.setMail(inputEmail);
		personne.setTelephone(inputPhone);
		personne.setAdresse(adresseRefuge);
		personne.setType("Refuge");
		
		
		Personne personneAModifier=this.daoPersonne.findByid(id);
		
				
		if(personneAModifier.getPassword()!=null && inputOldPassword.equals(personneAModifier.getPassword()) && inputPassword.equals(confPassword)) {
			personne.setPassword(inputPassword);
		} else {
			personne.setPassword(personneAModifier.getPassword());
		}
		
		
		this.daoPersonne.save(personne);
		return "redirect:.";
	}
	

	
	
}
