package com.suaguilda.animeguild.controller;

import com.suaguilda.animeguild.model.Personagem;
import com.suaguilda.animeguild.repository.PersonagemRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/guilda")
public class PersonagemController {

    private final PersonagemRepository repository;

    public PersonagemController(PersonagemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String listarPersonagens(Model model) {
        model.addAttribute("personagens", repository.findAll());
        return "lista"; 
    }

    @GetMapping("/novo")
    public String formularioNovoPersonagem(Model model) {
        model.addAttribute("personagem", new Personagem());
        return "formulario";
    }

    @PostMapping("/salvar")
    public String salvarPersonagem(@Valid @ModelAttribute Personagem personagem, BindingResult result) {
        if (result.hasErrors()) {
            return "formulario";
        }
        repository.save(personagem);
        return "redirect:/guilda";
    }
}