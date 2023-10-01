package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.EmpleadoRepository;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

@Controller
public class EmpleadoController {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @GetMapping("/empleado")
    public String usuarios(Model model, Integer id){
        model.addAttribute("empleados", empleadoRepository.darEmpleados());
        return "empleados";
    }

    @GetMapping("/empleados/new")
    public String empleadoFrom(Model model){
        model.addAttribute("empleados", new Empleado());
        return "empleadoNuevo";
    }

    @PostMapping("/empleados/new/save")
    public String empleadoGuardar(@ModelAttribute Empleado empleado){
        empleadoRepository.insertarEmpleado(empleado.getNombre(), empleado.getCargo());
        return "redirect:/empleado";
    }

    @GetMapping("empleados/{id}/edit")
    public String empleadosEditarForm(@PathVariable("id") Integer id, Model model){
        Usuario empleados=empleadoRepository.darEmpleadoID(id);
        if(empleados!=null){
            model.addAttribute("empleados", empleados);
            return "empleadosEditar";
        }
        else{
            return "redirect:/empleados";
        }

        
    }

    @PostMapping("/empleados/{id}/edit/save")
    public String empleadosEditarGuardar(@PathVariable("id") Integer id, @ModelAttribute Empleado empleado){
        empleadoRepository.actualizarEmpleado(id, empleado.getNombre(), empleado.getCargo());
        return "redirect:/empleados";

    }
}
