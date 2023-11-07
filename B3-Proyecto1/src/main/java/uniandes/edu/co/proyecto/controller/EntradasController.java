package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Entrada;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.repositorio.EntradaRepository;

@Controller
public class EntradasController {

    @Autowired
    private EntradaRepository entradaRepository;

    @GetMapping("/entradas")
    public String entradas(Model model){

        model.addAttribute("entradas", entradaRepository.darEntradas());
        return "entradas";
    }

    @GetMapping("/entradas/new")
    public String entradaFrom(Model model){
        model.addAttribute("entradas", new Entrada());
        return "entradaNueva";
    }

    @PostMapping("/entradas/new/save")
    public String entradaGuardar(@ModelAttribute Entrada entrada){
        entradaRepository.insertarEntrada(entrada.getIdReserva(), entrada.getIdEncargado());
        return "redirect:/entradas";
    }

    @GetMapping("entradas/{id}/edit")
    public String entradaEditarForm(@PathVariable("id") int id_entrada, Model model){
        Entrada entrada = entradaRepository.darEntrada(id_entrada);
        if (entrada!= null){
            model.addAttribute("entrada", entrada);
            return "entradaEditar";
        }
        else{
            return "redirect:/entradas";
        }
    }
    @PostMapping("/entradas/{id}/edit/save")
    public String entradaEditarGuardar(@PathVariable("id") int id_entrada, @ModelAttribute Entrada entrada){
        entradaRepository.actualizarEntrada(id_entrada, entrada.getIdReserva() , entrada.getIdEncargado());
        return "redirect:/entradas";

    }

    

    @GetMapping("/entradas/{id}/delete")
    public String entradaEliminar(@PathVariable("id") int id_entrada){
        entradaRepository.eliminarEntrada(id_entrada);
        return "redirect:/entradas"; 
    }


    
}
