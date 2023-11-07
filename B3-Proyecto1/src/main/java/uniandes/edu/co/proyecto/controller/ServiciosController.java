package uniandes.edu.co.proyecto.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;

@Controller
public class ServiciosController {

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/servicios")
    public String servicios(Model model, String nhabitacion, String fechainf, String fechasup, String costoinf, String costosup){
    
           model.addAttribute("servicios", servicioRepository.darServicios());
     
        return "servicios";
    }

    @GetMapping("/req2")
    public String req2(Model model){
        model.addAttribute("top20servicios", servicioRepository.top20servicios());
        return "req2";
    }

    @GetMapping("/req4")
    public String req2(Model model, String nhabitacion, String fechain, String fechafin, String costoinf, String costosup ){
        if((nhabitacion==null || nhabitacion.equals(""))||(fechain==null || fechain.equals(""))||(fechafin==null || fechafin.equals(""))||(costoinf==null || costoinf.equals(""))||(costosup==null || costosup.equals(""))){
             model.addAttribute("servicioCaracterisitica", Collections.emptyList());
        
        }
        else {
            model.addAttribute("servicioCaracterisitica", servicioRepository.servicioCaracteristica(Integer.parseInt(nhabitacion), fechain, fechafin, Integer.parseInt(costoinf), Integer.parseInt(costosup)));
        }
        return "req4";
    }
    
    
     

    @GetMapping("/servicios/new")
    public String servicioFrom(Model model){
        model.addAttribute("servicio", new Servicio());
        return "servicioNuevo";
    }

    @PostMapping("/servicios/new/save")
    public String servicioGuardar(@ModelAttribute Servicio servicio){
       servicioRepository.insertarServicio(servicio.getdtype(), servicio.getNombre(), servicio.getCostoservicio());
        return "redirect:/servicios";
    }

    @GetMapping("servicios/{id}/edit")
    public String servicioEditarForm(@PathVariable("id") int id, Model model){
        Servicio servicio = servicioRepository.darServicio(id);
        if (servicio!= null){
            model.addAttribute("servicios", servicio);
            return "servicioEditar";
        }
        else{
            return "redirect:/servicios";
        }
    }
    @PostMapping("/servicios/{id}/edit/save")
    public String servicioEditarGuardar(@PathVariable("id") int id, @ModelAttribute Servicio servicio){
        servicioRepository.actualizarServicio(id, servicio.getdtype());
        return "redirect:/servicios";

    }

    @GetMapping("/servicios/{id}/delete")
    public String servicioEliminar(@PathVariable("id") int id){
        servicioRepository.eliminarServicio(id);
        return "redirect:/servicios"; 
    }

  
    
    
}