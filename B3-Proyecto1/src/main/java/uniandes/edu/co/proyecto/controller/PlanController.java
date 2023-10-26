package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Plan;
import uniandes.edu.co.proyecto.repositorio.PlanRepository;

@Controller
public class PlanController {

    @Autowired
    private PlanRepository planRepository;

    @GetMapping("/planes")
    public String planes(Model model){
        model.addAttribute("planes", planRepository.darPlanes());
        return "planes";
    }

    @GetMapping("/planes/new")
    public String planform(Model model){
        model.addAttribute("plan", new Plan());
        return "plannuevo";
    }

    @PostMapping("/planes/new/save")
    public String planGuardar(@ModelAttribute Plan plan){
        planRepository.insertarPlan(plan.getNombre(), plan.getDescripcion(), plan.getDescuento());
        return "redirect:/planes";
    }

    @GetMapping("planes/{id}/edit")
    public String planEditarForm(@PathVariable("id") String nombre, Model model){
        Plan plan = planRepository.darPlan(nombre);
        if (plan!= null){
            model.addAttribute("plan", plan);
            return "planeditar";
        }
        else{
            return "redirect:/planes";
        }
    }
    @PostMapping("/planes/{id}/edit/save")
    public String planEditarGuardar(@PathVariable("id") String nombre, @ModelAttribute Plan plan){
        planRepository.actualizarPlan(nombre, plan.getDescripcion(), plan.getDescuento());
        return "redirect:/planes";

    }

    @GetMapping("/planes/{nombre}/delete")
    public String planEliminar(@PathVariable("nombre") String nombre){
        planRepository.eliminarPlan(nombre);
        return "redirect:/planes"; 
    }


    
    
}
