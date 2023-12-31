package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository.RespuestaInformacionHabitacion;
import uniandes.edu.co.proyecto.repositorio.TipoHabitacionRepository;

@Controller
public class HabitacionesController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping("/habitaciones")
    public String habitaciones(Model model, String habitacion) {
       
        if((habitacion==null || habitacion.equals("")))
             model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
        return "habitaciones";

    }

    @GetMapping("/habitaciones/new")
    public String habitacionForm(Model model) {
        model.addAttribute("habitacion", new Habitacion() );
        return "habitacionNuevo";
    }

    @PostMapping("/habitaciones/new/save")
    public String habitacionGuardar(@ModelAttribute Habitacion habitacion) {
        habitacionRepository.insertarHabitacion(habitacion.getnhabitacion(), habitacion.gettipohabitacion());
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{id}/edit")
    public String habitacionEditarForm(@PathVariable("id") int id, Model model) {
        Habitacion habitacion = habitacionRepository.darHabitacion(id);
        if (habitacion != null) {
            model.addAttribute("nhabitacion", habitacion);
            return "habitacionEditar";
        } else {
            return "redirect:/habitaciones";
        }
    }

    @PostMapping("/habitaciones/{id}/edit/save")
    public String habitacionEditarGuardar(@PathVariable("id") int id, @ModelAttribute Habitacion habitacion) {
        habitacionRepository.actualizarHabitacion(id, habitacion.gettipohabitacion());
        return "redirect:/habitaciones";
        }

    

    @GetMapping("/habitaciones/{id}/delete")
    public String habitacionEliminar(@PathVariable("id") int id) {
        habitacionRepository.eliminarHabitacion(id);
        return "redirect:/habitaciones";
    }

    @GetMapping("/req1")
    public String getConsumoPorHabitacion(Integer nHabitacion, Model model) {
             model.addAttribute("costoPorHabitaciones", habitacionRepository.consumoporHabitaciones(nHabitacion));
        return "req1";
    }

    @GetMapping("/RQ3")
    public String fraccioneshabitantes(Model model) {
        Collection<RespuestaInformacionHabitacion> informacion=habitacionRepository.darIndiceOcupacion();
        model.addAttribute("fraccionhabitaciones", informacion);
        return "RQ3";

    }
}
