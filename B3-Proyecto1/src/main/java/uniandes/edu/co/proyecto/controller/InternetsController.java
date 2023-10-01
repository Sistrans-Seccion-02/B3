package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Internet;
import uniandes.edu.co.proyecto.repositorio.InternetRepository;

@Controller
public class InternetsController {

    @Autowired
    private InternetRepository internetRepository;

    @GetMapping("/internets")
    public String internets(Model model){

        model.addAttribute("internets", internetRepository.darInternets());
        return "internets";
    }

    @GetMapping("/internets/new")
    public String internetFrom(Model model){
        model.addAttribute("internet", new Internet());
        return "internetNuevo";
    }

    @PostMapping("/internets/new/save")
    public String internetGuardar(@ModelAttribute Internet internet){
       internetRepository.insertarInternet(internet.getCapacidad());
        return "redirect:/internets";
    }

    @GetMapping("internets/{id}/edit")
    public String internetEditarForm(@PathVariable("id") int id, Model model){
        Internet internet = internetRepository.darInternet(id);
        if (internet != null){
            model.addAttribute("internet", internet);
            return "internetEditar";
        }
        else{
            return "redirect:/internets";
        }
    }
    @PostMapping("/internets/{id}/edit/save")
    public String internetEditarGuardar(@PathVariable("id") int id, @ModelAttribute Internet internet){
        internetRepository.actualizarInternet(id, internet.getCapacidad());
        return "redirect:/internets";

    }

    @GetMapping("/internets/{id}/delete")
    public String internetEliminar(@PathVariable("id") int id){
       internetRepository.eliminarInternet(id);
        return "redirect:/internets"; 
    }


    
    
}

