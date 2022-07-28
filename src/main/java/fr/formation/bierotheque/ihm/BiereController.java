package fr.formation.bierotheque.ihm;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.formation.bierotheque.bll.BiereException;
import fr.formation.bierotheque.bll.BiereManager;
import fr.formation.bierotheque.bo.Biere;

@Controller
@RequestMapping("/biere")
public class BiereController {
	@Autowired
	BiereManager manager;
	
	@PostConstruct
	public void init() throws BiereException {
		Biere b1 = new Biere("Stout une histoire","Noire","Brasserie de l'oudon");
		Biere b2 = new Biere("Pinte du Raz","Blonde","Pinte du Raz");
		manager.addBiere(b1,b2);
	}
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("list",manager.getAllBieres());
		return "index";
	}
	
	@GetMapping("/add")
	public String iniAddForm(Biere biere, Model model) {
		return "add";
	}
	
	@PostMapping("/add")
	public String validAddForm(@Valid Biere biere, BindingResult errors, Model model) {
		if(errors.hasErrors()) {
			return "add";
		}
		try {
			manager.addBiere(biere);
		} catch (BiereException e) {
			errors.addError(new FieldError("biere","couleur",e.getMessage()));
			return "add";
		}
		return "redirect:/biere";
	}
	
	@GetMapping("/del/{id}")
	public String delBiere(@PathVariable("id") Integer id, Model model) {
		manager.delBiereById(id);
		return "redirect:/biere";
	}
	
	@GetMapping("/mod/{id}")
	public String modBiere(@PathVariable("id") Integer id, Model model) {
		Biere biere = manager.getBiereById(id);
		model.addAttribute("biere",biere);
		return "mod";
	}
	
	@PostMapping("/mod/{id}") 
	public String modeValidBiere(@PathVariable("id") Integer id,@Valid Biere biere, BindingResult errors, Model model) {
		if(errors.hasErrors()) {
			return "mod";
		}
		biere.setIdBiere(id);
		try {
			manager.addBiere(biere);
		} catch (BiereException e) {
			errors.addError(new FieldError("biere","couleur",e.getMessage()));
			return "add";
		}
		return "redirect:/biere";
	}
	
	
	
	
	
	
	
}
