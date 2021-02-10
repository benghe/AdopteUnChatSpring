package fr.adopteunchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/accueil")
public class AccueilController {
	
	@GetMapping
	public String display() {
		return "accueil";
	}
}
