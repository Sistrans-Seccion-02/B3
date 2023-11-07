package uniandes.edu.co.proyecto.controller;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;

import org.springframework.ui.Model;

@Controller
public class ConsumosController {

    @Autowired
    private ConsumoRepository consumoRepository;

    // Mostrar todos los consumos
    @GetMapping("/consumos")
    public String consumos(Model model) {
        model.addAttribute("consumos", consumoRepository.darConsumos());
        return "consumos"; // Vista que muestra la lista de consumos
    }

    // Mostrar detalles de un consumo por ID
    @GetMapping("/consumos/new")
    public String consumoFrom(Model model){
        model.addAttribute("consumo", new Consumo());
        return "consumoNuevo";
    }

    @PostMapping("/consumos/new/save")
    public String consumoGuardar(@ModelAttribute Consumo consumo){
        consumoRepository.insertarConsumo(consumo.getIdServicio(), consumo.getIdReserva(), consumo.getHabitacion());
        return "redirect:/consumos";
    }

    @GetMapping("consumos/{id}/edit")
    public String consumoEditarForm(@PathVariable("id") int id, Model model){
        Consumo consumo = consumoRepository.darConsumo(id);
        if (consumo != null){
            model.addAttribute("consumo", consumo);
            return "consumoEditar";
        }
        else{
            return "redirect:/consumos";
        }
    }
    @PostMapping("/consumos/{id}/edit/save")
    public String consumoEditarGuardar(@PathVariable("id") int id, @ModelAttribute Consumo consumo){
        consumoRepository.actualizarConsumo(id, consumo.getIdServicio(), consumo.getIdReserva(), consumo.getHabitacion());
        return "redirect:/consumos";

    }

    @GetMapping("/consumos/{id}/delete")
    public String consumoEliminar(@PathVariable("id") int id){
        consumoRepository.eliminarConsumo(id);
        return "redirect:/consumos"; 
    }

    @GetMapping("/filtrarconsumos")
    public String filtrarReservasServicio(Model model, 
                                          @RequestParam(required = false) Integer idusuario, 
                                          @RequestParam(required = false) String inicio, 
                                          @RequestParam(required = false) String fin) {
        System.out.println("idusuario: " + idusuario);
        System.out.println("inicio: " + inicio);
        System.out.println("fin: " + fin);
        if (idusuario != null && inicio != null && fin != null) {
            model.addAttribute("consumosFiltrados", consumoRepository.filtrarConsumos(idusuario, inicio, fin));
        } else {
            // Manejar el caso cuando uno o más parámetros son null
            // Por ejemplo, puedes añadir una lista vacía o mostrar un mensaje de error
            model.addAttribute("consumosFiltrados", Collections.emptyList());
        }
        return "filtrarconsumos";
    }

    @GetMapping("/noconsumos")
    public String filtrarNoConsumo(Model model, 
                                          @RequestParam(required = false) Integer idservicio, 
                                          @RequestParam(required = false) String inicio, 
                                          @RequestParam(required = false) String fin) {
        System.out.println("idusuario: " + idservicio);
        System.out.println("inicio: " + inicio);
        System.out.println("fin: " + fin);
        if (idservicio != null && inicio != null && fin != null) {
            model.addAttribute("noConsumos", consumoRepository.findServicioUsuarioNotIn(idservicio, inicio, fin));
        } else {
            // Manejar el caso cuando uno o más parámetros son null
            // Por ejemplo, puedes añadir una lista vacía o mostrar un mensaje de error
            model.addAttribute("noConsumos", Collections.emptyList());
        }
        return "noconsumos";
    }

    
    
}
