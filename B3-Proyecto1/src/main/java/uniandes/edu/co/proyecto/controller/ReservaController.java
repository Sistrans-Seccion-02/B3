package uniandes.edu.co.proyecto.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;

@Controller
public class ReservaController {
    
    @Autowired 
    private ReservaRepository reservaRepository;

    @GetMapping("/reservas")
    public String reservas(Model model) {
        model.addAttribute("reservas", reservaRepository.darReservas());
        return "reservas";
    }

    @GetMapping("/reservas/new")
    public String reservaForm(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reservaNueva";
    }

    @PostMapping("/reservas/new/save")
    public String reservaGuardar(@ModelAttribute Reserva reserva) {
        reservaRepository.insertarReserva(reserva.getNumPersonas(), reserva.getFechaEntrada(), reserva.getFechaSalida(), reserva.getCliente(), reserva.getHabitacion(), reserva.getTipoPlan());
        return "redirect:/reservas";
    }
    

    @PostMapping("/reservas/{id}/edit/save")
    public String reservaEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Reserva reserva) {
        reservaRepository.actualizarReserva(id, reserva.getNumPersonas(), reserva.getFechaEntrada(), reserva.getFechaSalida(), reserva.getCliente(), reserva.getHabitacion(), reserva.getTipoPlan());
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{id}/edit")
    public String reservaEditarForm(@PathVariable("id") Integer id, Model model) {
        Reserva reserva = reservaRepository.darReserva(id);
        if (reserva != null) {
            model.addAttribute("reserva", reserva);
            return "reservaEditar";
        } else {
            return "redirect:/reservas";
        }
    }

    @GetMapping("/reservas/{id}/delete")
    public String reservaEliminar(@PathVariable("id") Integer id) {
        reservaRepository.eliminarReserva(id);
        return "redirect:/reservas";
    }

    @GetMapping("/clientesexcelentes")
    public String filtrarExcelentes(Model model) {
        model.addAttribute("clientesExcelentes", reservaRepository.findClienteEcelenteEntradas());
        return "clientesexcelentes";
    }
        
    @GetMapping("/RQ6")
    public String fechas(Model model) {
        model.addAttribute("mayorOcupacion", reservaRepository.darMayorOcupacion());
        model.addAttribute("menorOcupacion", reservaRepository.darMenorOcupacion());
        model.addAttribute("mayorIngresos", reservaRepository.darMayoresIngresos());
        return "RQ6";

    }

    @GetMapping("/RQ11")
    public String funcionamiento(Model model, @RequestParam(required = false) Integer semana) {
        System.out.println("semana"+ semana);
        if(semana != null){
            model.addAttribute("serviciomassolicitado", reservaRepository.darServiciosMasSolicitados(semana));
            model.addAttribute("serviciomenossolicitado", reservaRepository.darServiciosMenosSolicitados(semana));
            model.addAttribute("habitacionmassolicitada", reservaRepository.darHabitacionesMasSolicitadas(semana));
            model.addAttribute("habitacionmenossolicitada", reservaRepository.darHabitacionesMenosSolicitadas(semana));
        }
        else{
            model.addAttribute("serviciomassolicitado", Collections.emptyList());
            model.addAttribute("serviciomenossolicitado", Collections.emptyList());
            model.addAttribute("habitacionmassolicitada", Collections.emptyList());
            model.addAttribute("habitacionmenossolicitada", Collections.emptyList());
        
        }
        
        return "RQ11";

    }
        

}