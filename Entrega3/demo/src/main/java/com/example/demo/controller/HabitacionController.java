package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelo.BebidaEmbedded;
import com.example.demo.modelo.BebidaTipos;
import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.TipoHabitacionEmbedded;
import com.example.demo.repositorio.HabitacionRepository;

@Controller
public class HabitacionController {
    
    @Autowired
    private HabitacionRepository habitacionRepository;
    
    @GetMapping("/habitacion")
    public String obtenerTodasLasHabitaciones(Model model){
        model.addAttribute("habitaciones", habitacionRepository.findAll());
        return "habitacion";
    }

    @GetMapping("habitacionForm")
    public String mostrarFormulario(Model model){
        model.addAttribute("nuevaHabitacion", new Habitacion());
        return "habitacionForm";
    }

    @PostMapping("/crearHabitacion")
    public String crearHabitacion(@ModelAttribute("nuevaHabitacion") Habitacion nuevaHabitacion) {

        // Creamos una nueva bebida utilizando los datos del formulario
        TipoHabitacionEmbedded nuevoTipoHabitacion = new TipoHabitacionEmbedded(
            nuevaHabitacion.getTipoHabitacion().get(0).getNombre(),
            nuevaHabitacion.getTipoHabitacion().get(0).getDotacion(), 
            nuevaHabitacion.getTipoHabitacion().get(0).getCapacidad()
        );

        // Agregamos la bebida a la lista de bebidas en el nuevo tipo de bebida
        nuevaHabitacion.setTipoHabitacion(Collections.singletonList(nuevoTipoHabitacion));

        // Guardamos el nuevo tipo de bebida
        habitacionRepository.save(nuevaHabitacion);
        return "redirect:/habitacion";
    }

@GetMapping("/addTipoHabitacion")
    public String añadirHabitacion(@RequestParam(name="nhabitacion", required = false) Integer nhabitacion, Model model){
        model.addAttribute("nhabitacion", nhabitacion);
        model.addAttribute("tipoHabitacion", new TipoHabitacionEmbedded());
        return "addTipoHabitacionForm";
    }

    @PostMapping("/deleteHabitacion")
    public String deleteHabitacion(@RequestParam(name="nhabitacion", required=false) Integer nhabitacion){
        for(Habitacion cons:habitacionRepository.findBynhabitacion(nhabitacion)){
            habitacionRepository.delete(cons);
        }
        return "redirect:/habitacion";
    }

    @PostMapping("/addTipoHabitacionSave")
    public String añadirHabitacionSave(@RequestParam("nhabitacion") Integer nhabitacion, @ModelAttribute("tipohabitacion") TipoHabitacionEmbedded th){
        TipoHabitacionEmbedded nuevoTipodeHabitacion= new TipoHabitacionEmbedded(th.getNombre(), th.getDotacion(), th.getCapacidad());
        System.out.println(nhabitacion);
        
        List<Habitacion> cons=habitacionRepository.findBynhabitacion(nhabitacion);
        for(Habitacion c:cons){
            if(c.getTipoHabitacion()==null){
                List<TipoHabitacionEmbedded>emptyList=new ArrayList<>();
                c.setTipoHabitacion(emptyList);
            }
            c.addTipoHabitacion(nuevoTipodeHabitacion);
            habitacionRepository.save(c);
        }
        return "redirect:/habitacion";
    }

    

}
