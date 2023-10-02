package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.Hotel;

import uniandes.edu.co.proyecto.repositorio.HotelRepository;


@Controller
public class HotelController {
    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/hoteles")
    public String hoteles(Model model, Integer id){
        model.addAttribute("hoteles", hotelRepository.darHoteles());
        return "hoteles";
    }

    @GetMapping("/hoteles/new")
    public String hotelFrom(Model model){
        model.addAttribute("hoteles", new Empleado());
        return "hotelNuevo";
    }

    @PostMapping("/hoteles/new/save")
    public String hotelGuardar(@ModelAttribute Hotel hotel){
        hotelRepository.insertarHotel(hotel.getNombre(), hotel.getUbicacion(), hotel.getCapacidad()) ;
        return "redirect:/hoteles";

    }

    @GetMapping("hoteles/{id}/edit")
    public String hotelEditarForm(@PathVariable("id") Integer id, Model model){
        Hotel hotel=hotelRepository.darHotelID(id);
       
        if(hotel!=null){
            model.addAttribute("hotel", hotel);
            return "hotelEditar";
        }
        else{
            return "redirect:/hoteles";
        }

        
    }

    @PostMapping("/hot/{id}/edit/save")
    public String usuarioEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Hotel hotel){

        hotelRepository.actualizarHotel(id, hotel.getNombre(), hotel.getUbicacion(), hotel.getCapacidad());
        return "redirect:/hoteles";

    }
    
}