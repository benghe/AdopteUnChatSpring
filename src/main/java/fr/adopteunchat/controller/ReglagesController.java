package fr.adopteunchat.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.adopteunchat.dao.IColorDao;
import fr.adopteunchat.dao.IDepartementDao;
import fr.adopteunchat.dao.IPersonneDao;
import fr.adopteunchat.dao.IRaceDao;
import fr.adopteunchat.dao.IRegionDao;

@Controller
@RequestMapping("/reglages")
public class ReglagesController {
	@Autowired 
	IPersonneDao daoPersonne;
	@Autowired
	IRaceDao daoRace;
	@Autowired
	IColorDao daoColor;
	@Autowired
	IRegionDao daoRegion;
	@Autowired
	IDepartementDao daoDepartement;
	
	
	@GetMapping
	public String display(@RequestParam String r, Model model) {
		
		model.addAttribute("reglagesSection", r);
		
		
		
		if(r==null) {
			model.addAttribute("personnes", daoPersonne.findAll());
			
		}else if(r.equals("comptes")) {
			model.addAttribute("personnes", daoPersonne.findAll());
			
		}else if(r.equals("races")) {
			model.addAttribute("races", daoRace.findAll());
			
		}else if(r.equals("couleurs")) {
			model.addAttribute("couleurs", daoColor.findAll());
			
		}else if(r.equals("regions")) {
			model.addAttribute("regions", daoRegion.findAll());
			
		}else if(r.equals("departements")) {
			model.addAttribute("departements", daoDepartement.findAll());
		}
		
		
		return "reglages";
	}
	
	@GetMapping("supprimer")
	public String supprimer(@RequestParam int id,
							@RequestParam String r) {
		
		if(r.equals("comptes")) {
			daoPersonne.deleteById(id);
		}else if(r.equals("races")) {
			daoRace.deleteById(id);
			
		}else if(r.equals("couleurs")) {
			daoColor.deleteById(id);
			
		}else if(r.equals("regions")) {
			daoRegion.deleteById(id);
			
		}else if(r.equals("departements")) {
			daoDepartement.deleteById(id);
		}
		
		return "redirect:/reglages?r="+r;
	}

}
