package net.iterart.tareas.controller;

import java.time.LocalDate;
import java.sql.Date;
import javax.validation.Valid;
import net.iterart.tareas.entities.Tarea;
import net.iterart.tareas.repository.ITareaRepo;
import net.iterart.tareas.service.ITareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/tareas")
@SessionAttributes({"tarea"})
public class TareaController {

    @Autowired
    ITareaService serv;

    @GetMapping("/list")
    public String home(Model m) {

        m.addAttribute("titulo", "Lista de Tareas");
        m.addAttribute("tareas", serv.findAll());

        return "list";
    }
    
    @GetMapping("/buscar")
    public String Buscar(@RequestParam String descripcion, Model m) {

        m.addAttribute("tareas", serv.buscar(descripcion));

        return "list";
    }
    
    @GetMapping("/form")
    public String nuevo(Model model) {
    
        Tarea tarea = new Tarea();

        tarea.setFecha(Date.valueOf(LocalDate.now()));
        
        model.addAttribute("tarea", tarea);
        
        return "form";
    }
    
    @PostMapping("/form")
    public String guardar(@Valid Tarea tarea) {
        
        serv.save(tarea);
        
        return "redirect:list";
    }
    
    @GetMapping("/form/{id}")
    public String editar(@PathVariable int id, Model m) {
        
        Tarea tarea = serv.findOne(id);
    
        m.addAttribute("tarea", tarea);
        
        return "form";
    }
    
    @GetMapping("/del/{id}")
    public String borrar(@PathVariable int id) {
        
        serv.delete(id);
    
        return "redirect:/tareas/list";
    }
    
    @GetMapping("/tachar/{id}")
    public String tachar(@PathVariable int id) {
        
        Tarea t = serv.findOne(id);
        t.setRealizada(!t.isRealizada());
        
        serv.save(t);
        
        return "redirect:/tareas/list";
    }
}
