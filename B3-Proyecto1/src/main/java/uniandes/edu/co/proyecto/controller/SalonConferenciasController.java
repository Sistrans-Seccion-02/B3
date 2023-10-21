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

    @GetMapping("/salones")
    public String salonconf(Model model){
        model.addAttribute("salones", salonConferenciasRepository.darSalonConferencias());
        return "salones";
    }

    @GetMapping("/salones/new")
    public String salonFrom(Model model){
        model.addAttribute("salon", new SalonConferencias());
        return "salonNuevo";
    }

    @PostMapping("/salones/new/save")
    public String salonGuardar(@ModelAttribute SalonConferencias salonConferencias){
       salonConferenciasRepository.insertarSalonConferencias(salonConferencias.getCosto(), salonConferencias.getCapacidad());
        return "redirect:/salones";
    }

    @GetMapping("salones/{id}/edit")
    public String salonEditarForm(@PathVariable("id") int id, Model model){
        SalonConferencias salon = salonConferenciasRepository.darSalonConferencia(id);
        if (salon!= null){
            model.addAttribute("salones", salon);
            return "salonEditar";
        }
        else{
            return "redirect:/salones";
        }
    }
    @PostMapping("/salones/{id}/edit/save")
    public String salonEditarGuardar(@PathVariable("id") int id, @ModelAttribute SalonConferencias salonConferencias){
        salonConferenciasRepository.actualizarSalonConferencias(id, salonConferencias.getCosto(), salonConferencias.getId());
        return "redirect:/salones";

    }

    @GetMapping("/salones/{id}/delete")
    public String salonEliminar(@PathVariable("id") int id){
        salonConferenciasRepository.eliminarSalonConferencias(id);
        return "redirect:/salones"; 
    }
    
    
}