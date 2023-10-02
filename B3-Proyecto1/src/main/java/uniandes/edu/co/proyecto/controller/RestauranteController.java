package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Restaurante;
import uniandes.edu.co.proyecto.repositorio.RestauranteRepository;

@Controller
public class RestauranteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/restaurantes")
    public String restaurantes(Model model){
        model.addAttribute("restaurantes", restauranteRepository.darRestaurantes());
        return "restaurantes";
    }

    @GetMapping("/restaurantes/new")
    public String restauranteFrom(Model model){
        model.addAttribute("restaurante", new Restaurante());
        return "restauranteNuevo";
    }

    @PostMapping("/restaurantes/new/save")
    public String restauranteServGuardar(@ModelAttribute Restaurante restaurante){
        restauranteRepository.insertarRestaurante(restaurante.getNombre(), restaurante.getCapacidad(), restaurante.getEstilo());
        return "redirect:/restaurantes";
    }

    @GetMapping("restaurantes/{id}/edit")
    public String RestauranteEditarForm(@PathVariable("id") int id, Model model){
        Restaurante restaurante = restauranteRepository.darRestaurante(id);
        if (restaurante!= null){
            model.addAttribute("restaurante", restaurante);
            return "restauranteEditar";
        }
        else{
            return "redirect:/restaurantes";
        }
    }
    @PostMapping("/restaurantes/{id}/edit/save")
    public String restauranteEditarGuardar(@PathVariable("id") int id, @ModelAttribute Restaurante restaurante){
        restauranteRepository.actualizarRestaurante(id, restaurante.getNombre(), restaurante.getCapacidad(), restaurante.getEstilo());
        return "redirect:/restaurantes";

    }

    @GetMapping("/restaurantes/{id}/delete")
    public String restauranteEliminar(@PathVariable("id") int id){
        restauranteRepository.eliminaRestaurante(id);
        return "redirect:/restaurantes"; 
    }
    
    
}