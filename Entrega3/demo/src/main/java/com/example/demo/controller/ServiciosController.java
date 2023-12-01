package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelo.Servicio;
import com.example.demo.repositorio.ServiciosRepository;

@Controller
public class ServiciosController {

    @Autowired
    private ServiciosRepository serviciosRepository;
    
    @GetMapping("/crearServicio")
    public String crearServicio(Model model){
        model.addAttribute("servicioNuevo", new Servicio());
        return "servicioForm";
    }
    @PostMapping("/crearServicioNuevo")
    public String crearServicioNuevo(@ModelAttribute("servicioNuevo") Servicio servicio){
        Servicio nuevo = new Servicio(
            servicio.getNombre(), servicio.getTipo(), servicio.getPrecio()
        );
        serviciosRepository.save(nuevo);
        return "redirect:/servicios";
    }

    @PostMapping("/deleteServicio")
    public String eliminarServicio(@RequestParam(name = "id", required = false) String id){  
        serviciosRepository.deleteById(id);
        return "redirect:/servicios";
        
    }

    @GetMapping("/servicios")
    public String obtenerTodosLosServicios(Model model){
        model.addAttribute("servicios", serviciosRepository.findAll());
        return "servicios";
    }

}
