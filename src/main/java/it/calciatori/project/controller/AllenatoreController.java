package it.calciatori.project.controller;

import it.calciatori.project.model.Allenatore;
import it.calciatori.project.service.AllenatoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AllenatoreController {

    @Autowired
    private AllenatoreService allenatoreService;

    @GetMapping (path="/allenatori")
    public String getAllenatori(Model model){
        model.addAttribute("allenatori",this.allenatoreService.findAll());
        return "allenatori";
    }

    @PostMapping(path="/newAllenatore")
    public String addCalciatore(@ModelAttribute("allenatore") Allenatore allenatore, Model model, BindingResult bindingResult){
        this.allenatoreService.saveAllenatore(allenatore);
        model.addAttribute("allenatori",this.allenatoreService.findAll());
        return "allenatori";
    }

    @GetMapping(path="/newAllenatoreForm")
    public String newAllenatoreForm(Model model){
        return "admin/newAllenatoreForm";
    }

    @DeleteMapping(path="/deleteAllenatore/{id}")
    public String deleteCalciatore(Model model, @PathVariable Long id){
        this.allenatoreService.delete(this.allenatoreService.getById(id));
        model.addAttribute("allenatori",allenatoreService.findAll());
        return "allenatori";
    }
}
