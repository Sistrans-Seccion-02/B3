package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.modelo.TipoHabitacion;
import com.example.demo.repositorio.TipoHabitacionRepository;

@Controller
public class TipoHabitacionController {

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/tipoHabitacion")
    public String obtenerTodosLosTiposHabitacion(Model model) {
        List<TipoHabitacion> lista = tipoHabitacionRepository.findAll();
        System.out.println("Número de tipos de habitación encontrados: " + lista.size());
        model.addAttribute("tiposHabitacion", lista);
        return "tipoHabitacion";
    }
    

    @GetMapping("/tipoHabitacionForm")
    public String mostrarFormularioDeTipoHabitacion(Model model) {
        model.addAttribute("nuevoTipoHabitacion", new TipoHabitacion());
        return "tipoHabitacionForm";
    }

    @PostMapping("/crearTipoHabitacionNuevo")
    public String crearTipoHabitacion(@ModelAttribute("nuevoTipoHabitacion") TipoHabitacion nuevoTipoHabitacion) {
        tipoHabitacionRepository.save(nuevoTipoHabitacion);
        return "redirect:/tipoHabitacion";
    }

    @GetMapping("/editarTipoHabitacion/{id}")
    public String mostrarFormularioDeEdicion(@PathVariable String id, Model model) {
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid tipoHabitacion Id:" + id));
        model.addAttribute("tipoHabitacion", tipoHabitacion);
        return "editarTipoHabitacionForm";
    }

    @PostMapping("/actualizarTipoHabitacion")
    public String actualizarTipoHabitacion(@RequestParam("id") String id, @ModelAttribute("tipoHabitacion") TipoHabitacion tipoHabitacion) {
        tipoHabitacionRepository.save(tipoHabitacion);
        return "redirect:/tipoHabitacion";
    }
    
    @PostMapping("/deleteTipoHabitacion")
    public String eliminarTipoHabitacion(@RequestParam("id") String id, Model model) {
        tipoHabitacionRepository.deleteById(id);
        return "redirect:/tipoHabitacion";
    }

}
