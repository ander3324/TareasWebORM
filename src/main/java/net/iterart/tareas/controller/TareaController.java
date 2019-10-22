package net.iterart.tareas.controller;

import net.iterart.tareas.repository.ITareaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    ITareaRepo repo;

    @GetMapping("/list")
    public String home(Model m) {

        m.addAttribute("titulo", "Lista de Tareas");
        m.addAttribute("tareas", repo.findAll());

        return "home";
    }
}
