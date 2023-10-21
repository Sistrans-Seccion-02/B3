package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Bar;
import uniandes.edu.co.proyecto.repositorio.BarRepository;

@Controller
public class BaresController {

    @Autowired
    private BarRepository barRepository;

    @GetMapping("/bares")
    public String bares(Model model){

        model.addAttribute("bares", barRepository.darBares());
        return "bares";
    }

    @GetMapping("/bares/new")
    public String barFrom(Model model){
        model.addAttribute("bar", new Bar());
        return "barNuevo";
    }

    @PostMapping("/bares/new/save")
    public String barGuardar(@ModelAttribute Bar bar){
        barRepository.insertarBar(bar.getNombre(), bar.getCapacidad(), bar.getEstilo());
        return "redirect:/bares";
    }

    @GetMapping("bares/{id}/edit")
    public String barEditarForm(@PathVariable("id") int id, Model model){
        Bar bar = barRepository.darBar(id);
        if (bar!= null){
            model.addAttribute("bar", bar);
            return "barEditar";
        }
        else{
            return "redirect:/bares";
        }
    }
    @PostMapping("/bares/{id}/edit/save")
    public String barEditarGuardar(@PathVariable("id") int id, @ModelAttribute Bar bar){
        barRepository.actualizarrBar(id, bar.getNombre(), bar.getCapacidad(), bar.getEstilo());
        return "redirect:/bares";

    }

    @GetMapping("/bares/{id}/delete")
    public String barEliminar(@PathVariable("id") int id){
        barRepository.eliminarBar(id);
        return "redirect:/bares"; 
    }


    
    
}
