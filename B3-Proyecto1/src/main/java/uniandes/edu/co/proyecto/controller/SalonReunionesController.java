package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.SalonReuniones;
import uniandes.edu.co.proyecto.repositorio.SalonReunionesRepository;

@Controller
public class SalonReunionesController {

    @Autowired
    private SalonReunionesRepository salonReunionesRepository;

    @GetMapping("/salones_de_reuniones")
    public String salonreuniones(Model model){
        model.addAttribute("salones_de_reuniones", salonReunionesRepository.darSalonReuniones());
        return "salones_de_reuniones";
    }

    @GetMapping("/salones_de_reuniones/new")
    public String salonFrom(Model model){
        model.addAttribute("salon_reunion", new SalonReuniones());
        return "salonNuevo";
    }

    @PostMapping("/salones_de_reuniones/new/save")
    public String salonGuardar(@ModelAttribute SalonReuniones salonReuniones){
       salonReunionesRepository.insertarSalonReuniones(salonReuniones.getCosto(), salonReuniones.getCostoAdicional(), salonReuniones.getCapacidad());
        return "redirect:/salones_de_reuniones";
    }

    @GetMapping("salones_de_reuniones/{id}/edit")
    public String salonEditarForm(@PathVariable("id") int id, Model model){
        SalonReuniones salon = salonReunionesRepository.darSalonReunion(id);
        if (salon!= null){
            model.addAttribute("salon_reunion", salon);
            return "salonEditar";
        }
        else{
            return "redirect:/salones_de_reuniones";
        }
    }
    @PostMapping("/salones_de_reuniones/{id}/edit/save")
    public String salonEditarGuardar(@PathVariable("id") int id, @ModelAttribute SalonReuniones salonReuniones){
        salonReunionesRepository.actualizarSalonReuniones(id, salonReuniones.getCosto(), salonReuniones.getCostoAdicional(), salonReuniones.getCapacidad());
        return "redirect:/salones_de_reuniones";

    }

    @GetMapping("/salones_de_reuniones/{id}/delete")
    public String salonEliminar(@PathVariable("id") int id){
       salonReunionesRepository.eliminarSalonReuniones(id);
        return "redirect:/salones_de_reuniones"; 
    }
    
    
}