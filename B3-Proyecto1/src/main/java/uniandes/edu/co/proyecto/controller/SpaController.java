package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Spa;
import uniandes.edu.co.proyecto.repositorio.SpaRepository;

@Controller
public class SpaController {

    @Autowired
    private SpaRepository spaRepository;

    @GetMapping("/spas")
    public String spa(Model model){
        model.addAttribute("spas", spaRepository.darSpas());
        return "spas";
    }

    @GetMapping("/spas/new")
    public String spaFrom(Model model){
        model.addAttribute("salon_reunion", new Spa());
        return "spaNuevo";
    }

    @PostMapping("/spas/new/save")
    public String spaGuardar(@ModelAttribute Spa spa){
       spaRepository.insertarSpa(spa.getCosto(), spa.getDuracion());
        return "redirect:/spas";
    }

    @GetMapping("spas/{id}/edit")
    public String spaEditarForm(@PathVariable("id") int id, Model model){
        Spa spa = spaRepository.darSpa(id);
        if (spa != null){
            model.addAttribute("spa", spa);
            return "spaEditar";
        }
        else{
            return "redirect:/spas";
        }
    }
    @PostMapping("/spas/{id}/edit/save")
    public String salonEditarGuardar(@PathVariable("id") int id, @ModelAttribute Spa spa){
        spaRepository.actualizarSpa(id, spa.getCosto(), spa.getDuracion());
        return "redirect:/spas";

    }

    @GetMapping("/spas/{id}/delete")
    public String salonEliminar(@PathVariable("id") int id){
       spaRepository.eliminarSpa(id);
        return "redirect:/spas"; 
    }
    
    
}