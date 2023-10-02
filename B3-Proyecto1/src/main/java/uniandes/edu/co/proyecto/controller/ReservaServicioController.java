package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.ReservaServicio;
import uniandes.edu.co.proyecto.repositorio.ReservaServicioRepository;

@Controller
public class ReservaServicioController {

    @Autowired
    private ReservaServicioRepository reservaServicioRepository;

    @GetMapping("/reservas_servicio")
    public String reserva_servicio(Model model){
        model.addAttribute("reservas_servicio", reservaServicioRepository.darReservasServicio());
        return "reservas_servicio";
    }

    @GetMapping("/reservas_servicio/new")
    public String reservaServFrom(Model model){
        model.addAttribute("reserva_servicio", new ReservaServicio());
        return "reservaServNueva";
    }

    @PostMapping("/reservas_servicio/new/save")
    public String reservaServGuardar(@ModelAttribute ReservaServicio reserva){
        reservaServicioRepository.insertarReserva(reserva.getFecha(), reserva.getIdServicio(), reserva.getHabitacion());
        return "redirect:/reservas_servicio";
    }

    @GetMapping("reservas_servicio/{id}/edit")
    public String reservaServEditarForm(@PathVariable("id") int id, Model model){
        ReservaServicio reservaServ = reservaServicioRepository.darReservaServicio(id);
        if (reservaServ!= null){
            model.addAttribute("reserva", reservaServ);
            return "reservaEditar";
        }
        else{
            return "redirect:/reservas_servicio";
        }
    }
    @PostMapping("/reservas_servicio/{id}/edit/save")
    public String reservaEditarGuardar(@PathVariable("id") int id, @ModelAttribute ReservaServicio reserva){
        reservaServicioRepository.actualizarReserva(id, reserva.getFecha(), reserva.getIdServicio(), reserva.getHabitacion());
        return "redirect:/reservas_servicio";

    }

    @GetMapping("/reservas_servicio/{id}/delete")
    public String reservaEliminar(@PathVariable("id") int id){
        reservaServicioRepository.eliminarReserva(id);
        return "redirect:/reservas_servicio"; 
    }
    
    
}