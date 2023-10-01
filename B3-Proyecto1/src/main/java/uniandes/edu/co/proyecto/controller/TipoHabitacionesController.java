package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repositorio.TipoHabitacionRepository;

@Controller
@RequestMapping("/tipoHabitaciones")
public class TipoHabitacionesController {

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/tipoHabitaciones")
    public String listarTipoHabitaciones(Model model) {
        model.addAttribute("tipoHabitaciones", tipoHabitacionRepository.findAll());
        return "tipoHabitaciones"; // Nombre de la vista para mostrar la lista de tipos de habitaciones
    }

    @GetMapping("/tipoHabitaciones/new")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("tipoHabitacion", new TipoHabitacion());
        return "formularioCrearTipoHabitacion"; // Nombre de la vista para crear un tipo de habitación
    }


    @PostMapping("/tipoHabitaciones/save")
    public String crearTipoHabitacion(@ModelAttribute TipoHabitacion tipoHabitacion) {
        tipoHabitacionRepository.insertarTipoHabitacion(tipoHabitacion.getNombre(), tipoHabitacion.getDotacion(), tipoHabitacion.getCapacidad());
        return "redirect:/tipoHabitaciones";
    }

    @GetMapping("/tipoHabitaciones/{id}/edit")
    public String mostrarFormularioEditar(@PathVariable("id") int id, Model model) {
        TipoHabitacion tipoHabitacion = tipoHabitacionRepository.darTipoHabitacion(id);
        if (tipoHabitacion != null) {
            model.addAttribute("tipoHabitacion", tipoHabitacion);
            return "formularioEditarTipoHabitacion"; // Nombre de la vista para editar un tipo de habitación
        } else {
            return "redirect:/tipoHabitaciones";
        }
    }

    @PostMapping("/tipoHabitaciones/{id}/save")
    public String editarTipoHabitacion(@PathVariable("id") int id, @ModelAttribute TipoHabitacion tipoHabitacion) {
        tipoHabitacionRepository.actualizarTipoHabitacion(id, tipoHabitacion.getNombre(), tipoHabitacion.getDotacion(), tipoHabitacion.getCapacidad());
        return "redirect:/tipoHabitaciones";
    }

    @GetMapping("/tipoHabitaciones/{id}/delete")
    public String eliminarTipoHabitacion(@PathVariable("id") int id) {
        tipoHabitacionRepository.eliminarTipoHabitacion(id);
        return "redirect:/tipoHabitaciones";
    }
}
