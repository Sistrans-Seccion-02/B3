package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.SalonConferencias;
import uniandes.edu.co.proyecto.repositorio.SalonConferenciasRepository;

@Controller
public class SalonConferenciasController {

    @Autowired
    private SalonConferenciasRepository salonConferenciasRepository;

    @GetMapping("/salones_de_conferencia")
    public String salonconf(Model model){
        model.addAttribute("salones_de_conferencia", salonConferenciasRepository.darSalonConferencias());
        return "salones_de_conferencia";
    }

    @GetMapping("/salones_de_conferencia/new")
    public String salonFrom(Model model){
        model.addAttribute("salon_conferencia", new SalonConferencias());
        return "salonNuevo";
    }

    @PostMapping("/salones_de_conferencia/new/save")
    public String salonGuardar(@ModelAttribute SalonConferencias salonConferencias){
       salonConferenciasRepository.insertarSalonConferencias(salonConferencias.getCosto(), salonConferencias.getCapacidad());
        return "redirect:/salones_de_conferencia";
    }

    @GetMapping("salones_de_conferencia/{id}/edit")
    public String salonEditarForm(@PathVariable("id") int id, Model model){
        SalonConferencias salon = salonConferenciasRepository.darSalonConferencia(id);
        if (salon!= null){
            model.addAttribute("salon_conferencia", salon);
            return "salonEditar";
        }
        else{
            return "redirect:/salones_de_conferencia";
        }
    }
    @PostMapping("/salones_de_conferencia/{id}/edit/save")
    public String salonEditarGuardar(@PathVariable("id") int id, @ModelAttribute SalonConferencias salonConferencias){
        salonConferenciasRepository.actualizarSalonConferencias(id, salonConferencias.getCosto(), salonConferencias.getId());
        return "redirect:/salones_de_conferencia";

    }

    @GetMapping("/salones_de_conferencia/{id}/delete")
    public String salonEliminar(@PathVariable("id") int id){
        salonConferenciasRepository.eliminarSalonConferencias(id);
        return "redirect:/salones_de_conferencia"; 
    }
    
    
}