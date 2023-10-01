package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Gimnasio;
import uniandes.edu.co.proyecto.repositorio.GimnasioRepository;

@Controller
public class GimnasiosController {

    @Autowired
    private GimnasioRepository gimnasioRepository;

    @GetMapping("/gimnasios")
    public String gimnasios(Model model){

        model.addAttribute("gimnasios", gimnasioRepository.darGimnasios());
        return "gimnasios";
    }

    @GetMapping("/gimnasios/new")
    public String gimnasioFrom(Model model){
        model.addAttribute("gimnasio", new Gimnasio());
        return "gimnasioNuevo";
    }

    @PostMapping("/gimnasios/new/save")
    public String gimnasioGuardar(@ModelAttribute Gimnasio gimnasio){
        gimnasioRepository.insertarGimnasio(gimnasio.getCapacidad(), gimnasio.getMaquinas(), gimnasio.getHoraInicio(),gimnasio.getHoraFinal());
        return "redirect:/gimnasios";
    }

    @GetMapping("gimnasios/{id}/edit")
    public String gimnasioEditarForm(@PathVariable("id") int id, Model model){
        Gimnasio gimnasio = gimnasioRepository.darGimnasio(id);
        if (gimnasio!= null){
            model.addAttribute("gimnasio", gimnasio);
            return "gimnasioEditar";
        }
        else{
            return "redirect:/gimnasios";
        }
    }
    @PostMapping("/gimnasios/{id}/edit/save")
    public String gimnasioEditarGuardar(@PathVariable("id") int id, @ModelAttribute Gimnasio gimnasio){
        gimnasioRepository.actualizarGimnasio(id, gimnasio.getCapacidad(), gimnasio.getMaquinas(), gimnasio.getHoraInicio(),gimnasio.getHoraFinal());
        return "redirect:/gimnasios";

    }

    @GetMapping("/gimnasios/{id}/delete")
    public String gimnasioEliminar(@PathVariable("id") int id){
        gimnasioRepository.eliminarGimnasio(id);
        return "redirect:/gimnasios"; 
    }


    
    
}
