package it.calciatori.project.controller;

import java.util.List;

import it.calciatori.project.service.ProcuratoreService;
import it.calciatori.project.service.SquadraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import it.calciatori.project.model.Calciatore;
import it.calciatori.project.service.CalciatoreService;

@Controller
public class CalciatoreController {
	
	@Autowired
	private CalciatoreService calciatoreService;
	@Autowired
	private ProcuratoreService procuratoreService;
	@Autowired
	private SquadraService squadraService;
	
	@GetMapping(path = "/calciatori")
	public String getAllCalciatori(Model model) {
		model.addAttribute("calciatori",this.calciatoreService.findAllCalciatori());
		return "calciatori";
	}


	@GetMapping("/calciatore/bysquadra/{id}")
	public List<Calciatore> findBySquadra_Id(@PathVariable("id") Long squadra){
		return calciatoreService.findBySquadra_Id(squadra);
	}

	@PostMapping(path="/newCalciatore")
	public String addCalciatore(@ModelAttribute("calciatore") Calciatore calciatore, Model model, BindingResult bindingResult){
		this.calciatoreService.saveCalciatore(calciatore);
		model.addAttribute("calciatori",this.calciatoreService.findAllCalciatori());
		return "calciatori";
	}

	@GetMapping (path="/newCalciatoreForm")
	public String calciatoreForm(Model model){
		model.addAttribute("procuratori",procuratoreService.findAllProcuratore());
		model.addAttribute("squadre",squadraService.findAllSquadra());
		return "admin/newCalciatoreForm";
	}

	@DeleteMapping (path="/deleteCalciatore/{id}")
	public String deleteCalciatore(Model model, @PathVariable Long id){
		this.calciatoreService.delete(this.calciatoreService.getById(id));
		model.addAttribute("calciatori",calciatoreService.findAllCalciatori());
		return "calciatori";
	}
}
