package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Plato;
import uniandes.edu.co.proyecto.repositorio.PlatoRepository;

@Controller
public class PlatoController {

    @Autowired
    private PlatoRepository platoRepository;

    @GetMapping("/platos")
    public String platos(Model model){
        model.addAttribute("platos", platoRepository.darPlatos());
        return "platos";
    }

    @GetMapping("/platos/new")
    public String platosFrom(Model model){
        model.addAttribute("plato", new Plato());
        return "platoNuevo";
    }

    @PostMapping("/platos/new/save")
    public String platoGuardar(@ModelAttribute Plato plato){
        platoRepository.insertarPlato(plato.getNombre(), plato.getCosto(), plato.getIdRestaurante());
        return "redirect:/platos";
    }

    @GetMapping("platos/{id}/edit")
    public String platoEditarForm(@PathVariable("id") int id, Model model){
        Plato plato = platoRepository.darPlato(id);
        if (plato!= null){
            model.addAttribute("plato", plato);
            return "platoEditar";
        }
        else{
            return "redirect:/platos";
        }
    }
    @PostMapping("/platos/{id}/edit/save")
    public String platoEditarGuardar(@PathVariable("id") int id, @ModelAttribute Plato plato){
        platoRepository.actualizarPlato(id, plato.getNombre(), plato.getCosto(), plato.getIdRestaurante());
        return "redirect:/platos";

    }

    @GetMapping("/platos/{id}/delete")
    public String platoEliminar(@PathVariable("id") int id){
        platoRepository.eliminarPlato(id);
        return "redirect:/platos"; 
    }


    
    
}