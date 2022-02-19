package it.calciatori.project.controller;

import java.util.List;

import it.calciatori.project.model.Allenatore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import it.calciatori.project.model.Procuratore;
import it.calciatori.project.service.ProcuratoreService;

@Controller
public class ProcuratoreController {

    @Autowired
    private ProcuratoreService procuratoreService;

    @GetMapping("/procuratori")
	public String getAllProcuratore(Model model) {
		model.addAttribute("procuratori",this.procuratoreService.findAllProcuratore());
        return "procuratori";
    }

    @PostMapping(path="/newProcuratore")
    public String addProcuratore(@ModelAttribute("procuratore") Procuratore procuratore, Model model, BindingResult bindingResult){
        this.procuratoreService.saveProcuratore(procuratore);
        model.addAttribute("procuratori",this.procuratoreService.findAllProcuratore());
        return "procuratori";
    }

    @GetMapping(path="/newProcuratoreForm")
    public String newProcuratoreForm(Model model){
        return "admin/newProcuratoreForm";
    }

    @DeleteMapping (path="/deleteProcuratore/{id}")
    public String deleteProcuratore(Model model, @PathVariable Long id){
        this.procuratoreService.delete(this.procuratoreService.getById(id));
        model.addAttribute("procuratori",procuratoreService.findAllProcuratore());
        return "procuratori";
    }
}
