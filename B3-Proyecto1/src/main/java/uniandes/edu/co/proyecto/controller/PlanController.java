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
    public String planFrom(Model model){
        model.addAttribute("plan", new Plan());
        return "planNuevo";
    }

    @PostMapping("/planes/new/save")
    public String planGuardar(@ModelAttribute Plan plan){
        planRepository.insertarPlan(plan.getNombre(), plan.getDescripcion(), plan.getDescuento());
        return "redirect:/planes";
    }

    @GetMapping("planes/{id}/edit")
    public String planEditarForm(@PathVariable("id") int id, Model model){
        Plan plan = planRepository.darPlan(id);
        if (plan!= null){
            model.addAttribute("plan", plan);
            return "planEditar";
        }
        else{
            return "redirect:/planes";
        }
    }
    @PostMapping("/planes/{id}/edit/save")
    public String planEditarGuardar(@PathVariable("id") int id, @ModelAttribute Plan plan){
        planRepository.actualizarPlan(id, plan.getNombre(), plan.getDescripcion(), plan.getDescuento());
        return "redirect:/planes";

    }

    @GetMapping("/planes/{id}/delete")
    public String planEliminar(@PathVariable("plan") int id){
        planRepository.eliminarPlan(id);
        return "redirect:/planes"; 
    }


    
    
}