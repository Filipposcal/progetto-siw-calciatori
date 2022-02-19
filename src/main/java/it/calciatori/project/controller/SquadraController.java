package it.calciatori.project.controller;

import java.util.List;

import it.calciatori.project.model.Procuratore;
import it.calciatori.project.service.AllenatoreService;
import it.calciatori.project.service.CampionatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import it.calciatori.project.model.Squadra;
import it.calciatori.project.service.SquadraService;

@Controller
public class SquadraController {
	
	@Autowired
	private SquadraService squadraService;

	@Autowired
	private AllenatoreService allenatoreService;

	@Autowired
	private CampionatoService campionatoService;
	
	@GetMapping("/squadre")
	public String getAllSquadra(Model model) {
		model.addAttribute("squadre",this.squadraService.findAllSquadra());
		return "squadre";
	}

	@PostMapping(path="/newSquadra")
	public String addSquadra(@ModelAttribute("squadra") Squadra squadra, Model model, BindingResult bindingResult){
		this.squadraService.saveSquadra(squadra);
		model.addAttribute("squadre",this.squadraService.findAllSquadra());
		return "squadre";
	}

	@GetMapping(path="/newSquadraForm")
	public String newSquadraForm(Model model){
		model.addAttribute("allenatori",allenatoreService.findAll());
		model.addAttribute("campionati",campionatoService.findAllCampionato());
		return "admin/newSquadraForm";
	}

	@DeleteMapping (path="/deleteSquadra/{id}")
	public String deleteSquadra(Model model, @PathVariable Long id){
		this.squadraService.delete(this.squadraService.getById(id));
		model.addAttribute("squadre",squadraService.findAllSquadra());
		return "squadre";
	}

}
