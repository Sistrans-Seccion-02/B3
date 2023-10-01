package uniandes.edu.co.proyecto.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.repositorio.ConsumoRepository;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/consumos")
public class ConsumosController {

    @Autowired
    private ConsumoRepository consumoRepository;

    // Mostrar todos los consumos
    @GetMapping
    public String mostrarTodosLosConsumos(Model model) {
        List<Consumo> consumos = consumoRepository.findAll();
        model.addAttribute("consumos", consumos);
        return "consumosLista"; // Vista que muestra la lista de consumos
    }

    // Mostrar detalles de un consumo por ID
    @GetMapping("/{id}")
    public String mostrarConsumoPorId(@PathVariable int id, Model model) {
        Consumo consumo = consumoRepository.darConsumoPorId(id);
        if (consumo != null) {
            model.addAttribute("consumo", consumo);
            return "consumoDetalle"; // Vista que muestra detalles de un consumo
        } else {
            return "redirect:/consumos";
        }
    }

    @GetMapping("/consumo/nuevo")
    public String mostrarFormularioRegistro(Model model) {
        model.addAttribute("consumo", new Consumo());
        return "consumoFormulario"; // Vista que muestra el formulario para registrar un consumo
    }

    @PostMapping("/consumo/nuevo/save")
    public String registrarConsumo(@ModelAttribute Consumo consumo) {
        consumoRepository.save(consumo);
        return "redirect:/consumos";
    }

    // Mostrar formulario de edición para un consumo
    @GetMapping("/consumo/{id}/edit")
    public String mostrarFormularioEdicion(@PathVariable("id") int id, Model model) {
        Consumo consumo = consumoRepository.darConsumoPorId(id);
        if (consumo != null) {
            model.addAttribute("consumo", consumo);
            return "consumoEditar"; // Vista con el formulario de edición
        } else {
            return "redirect:/consumos";
        }
    }

    // Procesar el formulario de edición
    @PostMapping("/consumo/{id}/edit/save")
    public String guardarCambiosConsumo(@PathVariable("id") int id, @ModelAttribute Consumo consumo) {
        consumoRepository.save(consumo);  // Esto asume que tu repositorio maneja tanto la inserción como la actualización con el método save
        return "redirect:/consumos";
    }

    // Eliminar un consumo
    @GetMapping("/{id}/eliminar")
    public String eliminarConsumo(@PathVariable int id) {
        consumoRepository.eliminarConsumo(id);
        return "redirect:/consumos";
    }
}
