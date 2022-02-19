package it.calciatori.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import it.calciatori.project.model.Campionato;

import it.calciatori.project.service.CampionatoService;

@Controller
public class CampionatoController {
	
	@Autowired
	private CampionatoService campionatoService;
	
	@GetMapping("/campionati")
	public String getAllCampionato(Model model) {
		model.addAttribute("campionati",this.campionatoService.findAllCampionato());
		return "campionati";
	}

	@PostMapping(path="/newCampionato")
	public String addCampionato(@ModelAttribute("campionato") Campionato campionato, Model model, BindingResult bindingResult){
		this.campionatoService.saveCampionato(campionato);
		model.addAttribute("campionati",this.campionatoService.findAllCampionato());
		return "campionati";
	}

	@GetMapping (path="/newCampionatoForm")
	public String campionatoForm(Model model){
		return "admin/newCampionatoForm";
	}

	@DeleteMapping (path="/deleteCampionato/{id}")
	public String deleteCampionato(Model model, @PathVariable Long id){
		this.campionatoService.delete(this.campionatoService.getById(id));
		model.addAttribute("campionati",campionatoService.findAllCampionato());
		return "campionati";
	}
}
