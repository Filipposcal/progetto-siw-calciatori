package it.calciatori.project.controller;

import it.calciatori.project.model.Credentials;
import it.calciatori.project.service.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class AuthenticationController {

    @Autowired
    private CredentialsService credentialsService;

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String showLoginForm(Model model) {
        return "login.html";
    }


    @RequestMapping(value = "/default", method = RequestMethod.GET)
    public String defaultAfterLogin(Model model) {

        return "index";
    }
}

