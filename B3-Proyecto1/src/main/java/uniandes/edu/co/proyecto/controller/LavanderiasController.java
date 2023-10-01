package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Lavanderia;
import uniandes.edu.co.proyecto.repositorio.LavanderiaRepository;

@Controller
public class LavanderiasController {

    @Autowired
    private LavanderiaRepository lavanderiaRepository;

    @GetMapping("/lavanderias")
    public String lavanderias(Model model){

        model.addAttribute("lavanderias", lavanderiaRepository.darLavanderias());
        return "lavanderias";
    }

    @GetMapping("/lavanderias/new")
    public String lavanderiasFrom(Model model){
        model.addAttribute("lavanderia", new Lavanderia());
        return "lavanderiaNueva";
    }

    @PostMapping("/lavanderias/new/save")
    public String lavanderiaGuardar(@ModelAttribute Lavanderia lavanderia){
       lavanderiaRepository.insertarLavanderia(lavanderia.getPrenda(), lavanderia.getZapatos(), lavanderia.getCosto());;
        return "redirect:/lavanderias";
    }

    @GetMapping("lavanderias/{id}/edit")
    public String lavanderiaEditarForm(@PathVariable("id") int id, Model model){
        Lavanderia lavanderia = lavanderiaRepository.darLavanderia(id);
        if (lavanderia != null){
            model.addAttribute("lavanderia", lavanderia);
            return "lavanderiaEditar";
        }
        else{
            return "redirect:/lavanderias";
        }
    }
    @PostMapping("/lavanderias/{id}/edit/save")
    public String lavanderiaEditarGuardar(@PathVariable("id") int id, @ModelAttribute Lavanderia lavanderia){
        lavanderiaRepository.actualizarLavanderia(id, lavanderia.getPrenda(), lavanderia.getZapatos(), lavanderia.getCosto());
        return "redirect:/lavanderias";

    }

    @GetMapping("/lavanderias/{id}/delete")
    public String internetEliminar(@PathVariable("id") int id){
       lavanderiaRepository.eliminarLavanderia(id);
        return "redirect:/lavanderias"; 
    }


    
    
}
