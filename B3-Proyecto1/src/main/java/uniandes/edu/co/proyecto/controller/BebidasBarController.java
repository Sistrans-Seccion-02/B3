package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import uniandes.edu.co.proyecto.modelo.BebidaBar;
import uniandes.edu.co.proyecto.repositorio.BebidaBarRepository;

@Controller
public class BebidasBarController {

    @Autowired
    private BebidaBarRepository bebidaBarRepository;

    @GetMapping("/bebidas_bares")
    public String bebidas(Model model){

        model.addAttribute("bebidas_bares", bebidaBarRepository.darBebidas());
        return "bebidas_bares";
    }

    @GetMapping("/bebidas_bares/new")
    public String bebidaFrom(Model model){
        model.addAttribute("bebida_bar", new BebidaBar());
        return "bebidaNueva";
    }

    @PostMapping("/bebidas_bares/new/save")
    public String bebidaGuardar(@ModelAttribute BebidaBar bebida){
        bebidaBarRepository.insertarBebida(bebida.getNombre(), bebida.getCosto(), bebida.getIdServicio());
        return "redirect:/bebidas_bares";
    }

    @GetMapping("bebidas_bares/{id}/edit")
    public String bebidaEditarForm(@PathVariable("id") int id, Model model){
        BebidaBar bebidabar = bebidaBarRepository.darBebida(id);
        if (bebidabar!= null){
            model.addAttribute("bebida_bar", bebidabar);
            return "bebidaEditar";
        }
        else{
            return "redirect:/bebidas_bares";
        }
    }
    @PostMapping("/bebidas_bares/{id}/edit/save")
    public String bebidabarEditarGuardar(@PathVariable("id") int id, @ModelAttribute BebidaBar bebidabar){
        bebidaBarRepository.actualizarBebida(id, bebidabar.getNombre(), bebidabar.getCosto(), bebidabar.getIdServicio()
        );
        return "redirect:/bebidas_bares";

    }

    @GetMapping("/bebidas_bares/{id}/delete")
    public String bebidaEliminar(@PathVariable("id") int id){
       bebidaBarRepository.eliminarBebida(id);
        return "redirect:/bebidas_bares"; 
    }


    
    
}
