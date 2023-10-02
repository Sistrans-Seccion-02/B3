package uniandes.edu.co.proyecto.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import uniandes.edu.co.proyecto.modelo.Checkin;

import uniandes.edu.co.proyecto.repositorio.CheckinRepository;


@Controller
@RequestMapping("/checkin")
public class CheckinController {
    @Autowired
    private CheckinRepository checkinRepository;
    
    @GetMapping("/checkins")
    public String checkins(Model model, Integer id){
        model.addAttribute("checkins", checkinRepository.darCheckins());
        return "checkins";
    }

    @GetMapping("/checkins/new")
    public String checkinFrom(Model model){
        model.addAttribute("checkins", new Checkin());
        return "checkinNuevo";
    }

    @PostMapping("/checkins/new/save")
    public String checkinGuardar(@ModelAttribute Checkin checkin){
        checkinRepository.insertarCheckin(checkin.getFechaEntrada(), checkin.getResponsable(), checkin.getResponsableHotel());
        return "redirect:/checkins";
    }
    @GetMapping("checkins/{id}/edit")
    public String checkinEditarForm(@PathVariable("id") Integer id, Model model){
        Checkin checkin=checkinRepository.darCheckin(id);
        if(checkin!=null){
            model.addAttribute("checkin", checkin);
            return "checkinEditar";
        }
        else{
            return "redirect:/checkin" ;
        }
    }
        
    @PostMapping("/checkins/{id}/edit/save")
    public String checkinEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Checkin checkin){
        checkinRepository.actualizarCheckin(id, checkin.getFechaEntrada(), checkin.getResponsable(), checkin.getResponsableHotel());
        return "redirect:/checkins";
    }

    @GetMapping("/Checkin/{id}/delete")
    public String eliminarCheckin(@PathVariable("id") int id) {
        checkinRepository.eliminarCheckin(id);
        return "redirect:/checkin";
    }
}

